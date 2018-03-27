

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



public class ConversationRenderer extends VertexRenderer implements CellViewRenderer, Serializable {

  
	private static ViewPreferences.ViewType current = ViewPreferences.ViewType.INGENIAS;

  static {

    try {

    	ViewPreferences.ViewType index=ViewPreferences.ViewType.INGENIAS;
	index=ViewPreferences.ViewType.INGENIAS;
	
	index=ViewPreferences.ViewType.UML;
	RenderComponentManager.loadRenderFile("Conversation",
	index,"/ingenias/editor/rendererxml/ConversationUMLPanel.xml");
	
	index=ViewPreferences.ViewType.INGENIAS;
	RenderComponentManager.loadRenderFile("Conversation",
	index,"/ingenias/editor/rendererxml/ConversationINGENIASPanel.xml");
	
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }

  }

    /**
     * Constructs a renderer that may be used to render vertices.
     */
    public ConversationRenderer() {
    }

    public Dimension getSize() {
    return RenderComponentManager.getSize("Conversation",current);
    }

    public boolean supportsAttribute(Object key) {
    	return true;
        }

  public static void setEntity(Conversation ent){
  Map currentMap=(Map)  RenderComponentManager.retrieveIDs("Conversation",ent.getPrefs().getView());
  
		if (ent != null
				&& currentMap.get("_attributes_") != null
				&& currentMap.get("_attributes_") instanceof ingenias.editor.rendererxml.AttributesPanel) {

			((ingenias.editor.rendererxml.AttributesPanel) currentMap
					.get("_attributes_")).setEntity(ent);

		}

	
        if (currentMap.get("Collaborators")!=null && 
            currentMap.get("Collaborators") instanceof ingenias.editor.rendererxml.CollectionPanel) {
          try {
            ( (ingenias.editor.rendererxml.CollectionPanel) currentMap.get(
                "Collaborators")).setCollection("Collaborators",ent.Collaborators, ent.Collaborators.getType());
          }
          catch (IllegalArgumentException ex) {
            ex.printStackTrace();
          }
          catch (IllegalAccessException ex) {
            ex.printStackTrace();
          }
        }
	
        if (currentMap.get("CurrentContent")!=null && 
            currentMap.get("CurrentContent") instanceof ingenias.editor.rendererxml.CollectionPanel) {
          try {
            ( (ingenias.editor.rendererxml.CollectionPanel) currentMap.get(
                "CurrentContent")).setCollection("CurrentContent",ent.CurrentContent, ent.CurrentContent.getType());
          }
          catch (IllegalArgumentException ex) {
            ex.printStackTrace();
          }
          catch (IllegalAccessException ex) {
            ex.printStackTrace();
          }
        }
	
        if (currentMap.get("Collaborators")!=null && 
            currentMap.get("Collaborators") instanceof ingenias.editor.rendererxml.CollectionPanel) {
          try {
            ( (ingenias.editor.rendererxml.CollectionPanel) currentMap.get(
                "Collaborators")).setCollection("Collaborators",ent.Collaborators, ent.Collaborators.getType());
          }
          catch (IllegalArgumentException ex) {
            ex.printStackTrace();
          }
          catch (IllegalAccessException ex) {
            ex.printStackTrace();
          }
        }
	
        if (currentMap.get("CurrentContent")!=null && 
            currentMap.get("CurrentContent") instanceof ingenias.editor.rendererxml.CollectionPanel) {
          try {
            ( (ingenias.editor.rendererxml.CollectionPanel) currentMap.get(
                "CurrentContent")).setCollection("CurrentContent",ent.CurrentContent, ent.CurrentContent.getType());
          }
          catch (IllegalArgumentException ex) {
            ex.printStackTrace();
          }
          catch (IllegalAccessException ex) {
            ex.printStackTrace();
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
	   
      if (currentMap.get("Collaborators")!=null){
	   if (ent!=null && ent.getCollaborators()!=null){
		if (currentMap.get("Collaborators") instanceof javax.swing.JLabel){
		((javax.swing.JLabel)( currentMap).get("Collaborators")).setText(ent.getCollaborators().toString());
		} else {
		 if (currentMap.get("Collaborators") instanceof javax.swing.text.JTextComponent)
		 ((javax.swing.text.JTextComponent)( currentMap).get("Collaborators")).setText(ent.getCollaborators().toString());
		
	      } 
	   } else  {
	     if (currentMap.get("Collaborators") instanceof javax.swing.JLabel)
	     ((javax.swing.JLabel)( currentMap).get("Collaborators")).setText("");
	     else {
		if (!(currentMap.get("Collaborators") instanceof ingenias.editor.rendererxml.CollectionPanel)) 
		((javax.swing.text.JTextComponent)( currentMap).get("Collaborators")).setText("");
	     }
         }
	  }
	   
      if (currentMap.get("Interaction")!=null){
	   if (ent!=null && ent.getInteraction()!=null){
		if (currentMap.get("Interaction") instanceof javax.swing.JLabel){
		((javax.swing.JLabel)( currentMap).get("Interaction")).setText(ent.getInteraction().toString());
		} else {
		 if (currentMap.get("Interaction") instanceof javax.swing.text.JTextComponent)
		 ((javax.swing.text.JTextComponent)( currentMap).get("Interaction")).setText(ent.getInteraction().toString());
		
	      } 
	   } else  {
	     if (currentMap.get("Interaction") instanceof javax.swing.JLabel)
	     ((javax.swing.JLabel)( currentMap).get("Interaction")).setText("");
	     else {
		if (!(currentMap.get("Interaction") instanceof ingenias.editor.rendererxml.CollectionPanel)) 
		((javax.swing.text.JTextComponent)( currentMap).get("Interaction")).setText("");
	     }
         }
	  }
	   
      if (currentMap.get("Initiator")!=null){
	   if (ent!=null && ent.getInitiator()!=null){
		if (currentMap.get("Initiator") instanceof javax.swing.JLabel){
		((javax.swing.JLabel)( currentMap).get("Initiator")).setText(ent.getInitiator().toString());
		} else {
		 if (currentMap.get("Initiator") instanceof javax.swing.text.JTextComponent)
		 ((javax.swing.text.JTextComponent)( currentMap).get("Initiator")).setText(ent.getInitiator().toString());
		
	      } 
	   } else  {
	     if (currentMap.get("Initiator") instanceof javax.swing.JLabel)
	     ((javax.swing.JLabel)( currentMap).get("Initiator")).setText("");
	     else {
		if (!(currentMap.get("Initiator") instanceof ingenias.editor.rendererxml.CollectionPanel)) 
		((javax.swing.text.JTextComponent)( currentMap).get("Initiator")).setText("");
	     }
         }
	  }
	   
      if (currentMap.get("Description")!=null){
	   if (ent!=null && ent.getDescription()!=null){
		if (currentMap.get("Description") instanceof javax.swing.JLabel){
		((javax.swing.JLabel)( currentMap).get("Description")).setText(ent.getDescription().toString());
		} else {
		 if (currentMap.get("Description") instanceof javax.swing.text.JTextComponent)
		 ((javax.swing.text.JTextComponent)( currentMap).get("Description")).setText(ent.getDescription().toString());
		
	      } 
	   } else  {
	     if (currentMap.get("Description") instanceof javax.swing.JLabel)
	     ((javax.swing.JLabel)( currentMap).get("Description")).setText("");
	     else {
		if (!(currentMap.get("Description") instanceof ingenias.editor.rendererxml.CollectionPanel)) 
		((javax.swing.text.JTextComponent)( currentMap).get("Description")).setText("");
	     }
         }
	  }
	   
      if (currentMap.get("ParticipantsSearch")!=null){
	   if (ent!=null && ent.getParticipantsSearch()!=null){
		if (currentMap.get("ParticipantsSearch") instanceof javax.swing.JLabel){
		((javax.swing.JLabel)( currentMap).get("ParticipantsSearch")).setText(ent.getParticipantsSearch().toString());
		} else {
		 if (currentMap.get("ParticipantsSearch") instanceof javax.swing.text.JTextComponent)
		 ((javax.swing.text.JTextComponent)( currentMap).get("ParticipantsSearch")).setText(ent.getParticipantsSearch().toString());
		
	      } 
	   } else  {
	     if (currentMap.get("ParticipantsSearch") instanceof javax.swing.JLabel)
	     ((javax.swing.JLabel)( currentMap).get("ParticipantsSearch")).setText("");
	     else {
		if (!(currentMap.get("ParticipantsSearch") instanceof ingenias.editor.rendererxml.CollectionPanel)) 
		((javax.swing.text.JTextComponent)( currentMap).get("ParticipantsSearch")).setText("");
	     }
         }
	  }
	   
      if (currentMap.get("CurrentContent")!=null){
	   if (ent!=null && ent.getCurrentContent()!=null){
		if (currentMap.get("CurrentContent") instanceof javax.swing.JLabel){
		((javax.swing.JLabel)( currentMap).get("CurrentContent")).setText(ent.getCurrentContent().toString());
		} else {
		 if (currentMap.get("CurrentContent") instanceof javax.swing.text.JTextComponent)
		 ((javax.swing.text.JTextComponent)( currentMap).get("CurrentContent")).setText(ent.getCurrentContent().toString());
		
	      } 
	   } else  {
	     if (currentMap.get("CurrentContent") instanceof javax.swing.JLabel)
	     ((javax.swing.JLabel)( currentMap).get("CurrentContent")).setText("");
	     else {
		if (!(currentMap.get("CurrentContent") instanceof ingenias.editor.rendererxml.CollectionPanel)) 
		((javax.swing.text.JTextComponent)( currentMap).get("CurrentContent")).setText("");
	     }
         }
	  }
	   
      
    
  }


	public Component getRendererComponent(JGraph graph,
			CellView view, boolean sel,
			boolean focus, boolean preview)
	{
	return RenderComponentManager.retrievePanel("Conversation",
	((Entity)((DefaultGraphCell)(view.getCell())).getUserObject()).getPrefs().getView());
		
	}
	
	public static JPanel setCurrent(ViewPreferences.ViewType c) {
	
		current = ViewPreferences.ViewType.INGENIAS;
	
		return (JPanel) RenderComponentManager.retrievePanel("Conversation",current);
	}
	

}
