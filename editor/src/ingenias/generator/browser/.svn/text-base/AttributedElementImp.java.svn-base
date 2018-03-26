/*
    Copyright (C) 2002 Jorge Gomez Sanz

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

package ingenias.generator.browser;

import ingenias.editor.IDEState;
import ingenias.editor.ModelJGraph;
import ingenias.exception.NotFound;

import java.lang.reflect.*;
import java.util.*;

class AttributedElementImp implements AttributedElement {

  private Object element;
  private ModelJGraph graph;
private IDEState ids;

  AttributedElementImp(Object ent,ModelJGraph graph, IDEState ids ){
     this.element=ent;
     this.graph=graph;
     this.ids=ids;
  }

  public GraphAttribute[] getAllAttrs(){
       Field[] fields=element.getClass().getFields();
        GraphAttribute[] result=new GraphAttribute[fields.length];
        Vector v=new Vector();
        int k=0;
        boolean found=false;
        while (k<fields.length){
         try {
          result[k]=new GraphAttributeImp(fields[k].getName(),fields[k].get(this.element),graph,ids);
         } catch (IllegalAccessException iae){
           iae.printStackTrace();
         }

         k=k+1;
        }

    return result;

  }


  public GraphAttribute getAttributeByName(String name) throws NotFound{

    Field[] fields=element.getClass().getFields();
    GraphAttribute result=null;
    int k=0;
    boolean found=false;
    String availableFields="";
    while (k<fields.length && !found){
      try {
		availableFields=availableFields+fields[k].getName()+"="+fields[k].get(element)+",";
	} catch (IllegalArgumentException e) {
		
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		
		e.printStackTrace();
	}
     found=fields[k].getName().equalsIgnoreCase(name);
     if (!found) k++;
    }

    if (!found)
     throw new NotFound("Available fields in "+element.getClass()+" are "+availableFields);
    try {
    result=new GraphAttributeImp(name,fields[k].get(this.element),graph,ids);
    } catch (IllegalAccessException iae){
      iae.printStackTrace();
    }
    return result;
  }

}