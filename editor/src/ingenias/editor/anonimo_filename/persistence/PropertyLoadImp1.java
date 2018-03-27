/*
    Copyright (C) 2002 Jorge Gomez Sanz, Ruben Fuentes

    This file is part of INGENIAS IDE, a support tool for the INGENIAS
    methodology, availabe at http://grasia.fdi.ucm.es/ingenias or
    http://ingenias.sourceforge.net

    INGENIAS IDE is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    INGENIAS IDE is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with INGENIAS IDE; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

*/

package ingenias.editor.persistence;

import java.lang.reflect.*;
import javax.swing.tree.*;
import org.apache.xerces.parsers.DOMParser;
import org.xml.sax.InputSource;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.*;
import javax.xml.parsers.*;
import org.jgraph.JGraph;
import org.jgraph.graph.*;
import org.w3c.dom.*;
import ingenias.editor.entities.*;
import ingenias.exception.*;
import ingenias.editor.cell.*;
import ingenias.editor.*;
import ingenias.generator.util.Conversor;

public class PropertyLoadImp1
    implements PropertyLoad {

  public PropertyLoadImp1() {
  }

  private Map restoreMap(Node propertiesNode) {
	  //System.err.println("restoring map");
    Hashtable result = new Hashtable();
    NodeList keys = propertiesNode.getChildNodes();
    for (int k = 0; k < keys.getLength(); k++) {
      Node current = keys.item(k);
      if (current.getNodeName().equalsIgnoreCase("key")) {
        String id = current.getAttributes().getNamedItem("id").getNodeValue();
        String value = "";
        if (current.getAttributes().getNamedItem("value") != null) {
          value = current.getAttributes().getNamedItem("value").getNodeValue();
        //  System.err.println("reading 1"+value);
        }
        else
        if (current.getFirstChild() != null) {
          value = current.getFirstChild().getNodeValue();
          //System.err.println("reading 2"+value);
        }
       // System.err.println("reading 3"+value);
        result.put(id, value);
      }
    }
    return result;
  }

  private void restoreCollectionObjectProperty(ingenias.editor.entities.Entity
                                               en, ObjectManager om,
                                               GraphManager gm, Node current) throws
      ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
      InstantiationException, InvocationTargetException {
    java.lang.reflect.Method m = null;
    String fieldid = current.getAttributes().getNamedItem("id").getNodeValue();
    Enumeration objectNodes = this.getCollectionObject(current).elements();
    while (objectNodes.hasMoreElements()) {    	
      Node oNode = (Node) objectNodes.nextElement();
      ingenias.editor.entities.Entity childEntity = PersistenceManager.getOL().
          restoreObject(om,
                        gm, oNode);
      Object[] params1 = {
          childEntity};
      Class[] paramtype1 = {
          childEntity.getClass()};
      m = this.findAppropriateMethod(en.getClass(), "add" + fieldid, paramtype1);
      if (m == null) {
        throw new RuntimeException("Method " + "add" + fieldid +
            " does not exist in class  implements java.io.Serializable " +
            en.getClass().getName());
      }
      m.invoke(en, params1);
    }
  }

  private void restoreSingleObjectProperty(ingenias.editor.entities.Entity en,
                                           ObjectManager om,
                                           GraphManager gm, Node current) throws
      ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
      InstantiationException, InvocationTargetException {
    java.lang.reflect.Method m = null;
    String fieldid = current.getAttributes().getNamedItem("id").getNodeValue();
    Node objectNode = this.getObject(current);
    if (objectNode != null) {
      ingenias.editor.entities.Entity childEntity = PersistenceManager.getOL().
          restoreObject(om,
                        gm, objectNode);
      Object[] params1 = {
          childEntity};
      Class[] paramtype1 = {
          childEntity.getClass()};
      m = this.findAppropriateMethod(en.getClass(), "set" + fieldid, paramtype1);

      if (m == null) {
    	  String params="";
    	  for (int k=0;k<paramtype1.length;k++){
    		  params=params+paramtype1[k]+":"+((ingenias.editor.entities.Entity)params1[k]).getId()+",";
    	  }
        throw new RuntimeException("Restoring entity:"+ en.getId()+" of type "+en.getType()+". Method " + "set" + fieldid + "("+params+")"+
            " does not exist in class  implements java.io.Serializable " +
            en.getClass().getName());
      }
      m.invoke(en, params1);

    }
  }

  private Vector getCollectionObject(Node propertyNode) {
    Vector result = new Vector();
    NodeList children = propertyNode.getChildNodes();
    for (int k = 0; k < children.getLength(); k++) {
      Node current = children.item(k);
      if (current.getNodeName().equalsIgnoreCase("object")) {
        result.add(current);
      }
    }
    return result;
  }

  public void restoreProperty(ObjectManager om, GraphManager gm, Node current,
                              ingenias.editor.entities.Entity en) throws
      ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
      InstantiationException, InvocationTargetException {
    if (current.getNodeName().equalsIgnoreCase("objectproperty")) {
      if (current.getAttributes().getNamedItem("collection") != null) {
        this.restoreCollectionObjectProperty(en, om, gm, current);
      }
      else {
        this.restoreSingleObjectProperty(en, om, gm, current);
      }
    }
    else
    if (current.getNodeName().equalsIgnoreCase("mapproperties")) {
      Map map = this.restoreMap(current);
      en.fromMap(map);
    }

  }

  private java.lang.reflect.Method findAppropriateMethod(Class object,
      String name, Class[] params) {
    java.lang.reflect.Method[] ms = object.getMethods();
    boolean found = false;
    java.lang.reflect.Method current = null;
    for (int k = 0; k < ms.length && !found; k++) {
      current = ms[k];
      if (current.getName().equals(name) &&
          current.getParameterTypes().length == params.length) {
        Class[] cparams = current.getParameterTypes();
        boolean correct = true;
        for (int j = 0; j < cparams.length && correct; j++) {
          correct = correct && cparams[j].isAssignableFrom(params[j]);
        }
        found = correct;
      }
    }
    if (found) {
      return current;
    }
    else {
      return null;
    }
  }

  private Node getObject(Node propertyNode) {
    NodeList children = propertyNode.getChildNodes();
    for (int k = 0; k < children.getLength(); k++) {
      Node current = children.item(k);
      if (current.getNodeName().equalsIgnoreCase("object")) {
        return current;
      }
    }
    return null;
  }

  public static void main(String[] args) {
    PropertyLoadImp1 propertyLoad1 = new PropertyLoadImp1();

  }

}