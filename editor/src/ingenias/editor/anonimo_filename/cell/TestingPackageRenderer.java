

/*
    Copyright (C) 2002 Jorge Gomez Sanz, Ruben Fuentes

    Modifications over original code from Jon Barrileaux.
    It has been significantly modified to enhance drawing speed.


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

package ingenias.editor.cell;


import org.jgraph.JGraph;
import org.jgraph.graph.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.beans.*;
import java.io.*;
import java.util.*;
import ingenias.editor.entities.*;
import ingenias.editor.entities.*;
import org.swixml.SwingEngine;
import ingenias.editor.entities.Entity;



public class TestingPackageRenderer extends VertexRenderer implements CellViewRenderer, Serializable {

  
	private static ViewPreferences.ViewType current = ViewPreferences.ViewType.INGENIAS;

  static {

    try {

    	ViewPreferences.ViewType index=ViewPreferences.ViewType.INGENIAS;
	index=ViewPreferences.ViewType.INGENIAS;
	
	index=ViewPreferences.ViewType.UML;
	RenderComponentManager.loadRenderFile("TestingPackage",
	index,"/ingenias/editor/rendererxml/TestingPackageUMLPanel.xml");
	
	index=ViewPreferences.ViewType.INGENIAS;
	RenderComponentManager.loadRenderFile("TestingPackage",
	index,"/ingenias/editor/rendererxml/TestingPackageINGENIASPanel.xml");
	
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }

  }

    /**
     * Constructs a renderer that may be used to render vertices.
     */
    public TestingPackageRenderer() {
    }

    public Dimension getSize() {
    return RenderComponentManager.getSize("TestingPackage",current);
    }

    public boolean supportsAttribute(Object key) {
    	return true;
        }

  public static void setEntity(TestingPackage ent){
  Map currentMap=(Map)  RenderComponentManager.retrieveIDs("TestingPackage",ent.getPrefs().getView());
  
		if (ent != null
				&& currentMap.get("_attributes_") != null
				&& currentMap.get("_attributes_") instanceof ingenias.editor.rendererxml.AttributesPanel) {

			((ingenias.editor.rendererxml.AttributesPanel) currentMap
					.get("_attributes_")).setEntity(ent);

		}

	
        if (currentMap.get("Tests")!=null && 
            currentMap.get("Tests") instanceof ingenias.editor.rendererxml.CollectionPanel) {
          try {
            ( (ingenias.editor.rendererxml.CollectionPanel) currentMap.get(
                "Tests")).setCollection("Tests",ent.Tests, ent.Tests.getType());
          }
          catch (IllegalArgumentException ex) {
            ex.printStackTrace();
          }
          catch (IllegalAccessException ex) {
            ex.printStackTrace();
          }
        }
	
        if (currentMap.get("Parameters")!=null && 
            currentMap.get("Parameters") instanceof ingenias.editor.rendererxml.CollectionPanel) {
          try {
            ( (ingenias.editor.rendererxml.CollectionPanel) currentMap.get(
                "Parameters")).setCollection("Parameters",ent.Parameters, ent.Parameters.getType());
          }
          catch (IllegalArgumentException ex) {
            ex.printStackTrace();
          }
          catch (IllegalAccessException ex) {
            ex.printStackTrace();
          }
        }
	
        if (currentMap.get("Tests")!=null && 
            currentMap.get("Tests") instanceof ingenias.editor.rendererxml.CollectionPanel) {
          try {
            ( (ingenias.editor.rendererxml.CollectionPanel) currentMap.get(
                "Tests")).setCollection("Tests",ent.Tests, ent.Tests.getType());
          }
          catch (IllegalArgumentException ex) {
            ex.printStackTrace();
          }
          catch (IllegalAccessException ex) {
            ex.printStackTrace();
          }
        }
	

      
      if (currentMap.get("Tests")!=null){
	   if (ent!=null && ent.getTests()!=null){
		if (currentMap.get("Tests") instanceof javax.swing.JLabel){
		((javax.swing.JLabel)( currentMap).get("Tests")).setText(ent.getTests().toString());
		} else {
		 if (currentMap.get("Tests") instanceof javax.swing.text.JTextComponent)
		 ((javax.swing.text.JTextComponent)( currentMap).get("Tests")).setText(ent.getTests().toString());
		
	      } 
	   } else  {
	     if (currentMap.get("Tests") instanceof javax.swing.JLabel)
	     ((javax.swing.JLabel)( currentMap).get("Tests")).setText("");
	     else {
		if (!(currentMap.get("Tests") instanceof ingenias.editor.rendererxml.CollectionPanel)) 
		((javax.swing.text.JTextComponent)( currentMap).get("Tests")).setText("");
	     }
         }
	  }
	   
      if (currentMap.get("TestingDeployment")!=null){
	   if (ent!=null && ent.getTestingDeployment()!=null){
		if (currentMap.get("TestingDeployment") instanceof javax.swing.JLabel){
		((javax.swing.JLabel)( currentMap).get("TestingDeployment")).setText(ent.getTestingDeployment().toString());
		} else {
		 if (currentMap.get("TestingDeployment") instanceof javax.swing.text.JTextComponent)
		 ((javax.swing.text.JTextComponent)( currentMap).get("TestingDeployment")).setText(ent.getTestingDeployment().toString());
		
	      } 
	   } else  {
	     if (currentMap.get("TestingDeployment") instanceof javax.swing.JLabel)
	     ((javax.swing.JLabel)( currentMap).get("TestingDeployment")).setText("");
	     else {
		if (!(currentMap.get("TestingDeployment") instanceof ingenias.editor.rendererxml.CollectionPanel)) 
		((javax.swing.text.JTextComponent)( currentMap).get("TestingDeployment")).setText("");
	     }
         }
	  }
	   
      if (currentMap.get("Id")!=null){
	   if (ent!=null && ent.getId()!=null){
		if (currentMap.get("Id") instanceof javax.swing.JLabel){
		((javax.swing.JLabel)( currentMap).get("Id")).setText(ent.getId().toString());
		} else {
		 if (currentMap.get("Id") instanceof javax.swing.text.JTextComponent)
		 ((javax.swing.text.JTextComponent)( currentMap).get("Id")).setText(ent.getId().toString());
		
	      } 
	   } else  {
	     if (currentMap.get("Id") instanceof javax.swing.JLabel)
	     ((javax.swing.JLabel)( currentMap).get("Id")).setText("");
	     else {
		if (!(currentMap.get("Id") instanceof ingenias.editor.rendererxml.CollectionPanel)) 
		((javax.swing.text.JTextComponent)( currentMap).get("Id")).setText("");
	     }
         }
	  }
	   
      
    
  }


	public Component getRendererComponent(JGraph graph,
			CellView view, boolean sel,
			boolean focus, boolean preview)
	{
	return RenderComponentManager.retrievePanel("TestingPackage",
	((Entity)((DefaultGraphCell)(view.getCell())).getUserObject()).getPrefs().getView());
		
	}
	
	public static JPanel setCurrent(ViewPreferences.ViewType c) {
	
		current = ViewPreferences.ViewType.INGENIAS;
	
		return (JPanel) RenderComponentManager.retrievePanel("TestingPackage",current);
	}
	

}
