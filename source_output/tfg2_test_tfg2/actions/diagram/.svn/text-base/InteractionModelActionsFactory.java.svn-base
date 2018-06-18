


/*
    Copyright (C) 2002 Jorge Gomez Sanz, Ruben Fuentes, Juan Pavon

    Modifications over original code from jgraph.sourceforge.net

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

package ingenias.editor.actions.diagram;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.Map;
import java.util.Hashtable;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;
import java.util.Map;
import java.util.Hashtable;
import java.util.ArrayList;
import javax.swing.event.UndoableEditEvent;
import org.jgraph.JGraph;
import org.jgraph.graph.*;
import org.jgraph.event.*;
import java.util.Vector;
import org.jgraph.JGraph;
import org.jgraph.graph.*;
import org.jgraph.event.*;
import org.jgraph.plaf.basic.*;
import java.lang.reflect.*;
import ingenias.editor.entities.*;
import ingenias.editor.widget.*;
import ingenias.exception.NullEntity;
import ingenias.generator.browser.BrowserImp;
import ingenias.generator.browser.Graph;
import ingenias.generator.browser.GraphEntity;
import ingenias.exception.InvalidEntity;
import ingenias.editor.*;

// MarqueeHandler that Connects Vertices and Displays PopupMenus

public class InteractionModelActionsFactory extends DiagramMenuEntriesActionsFactory  implements java.io.Serializable {

        public InteractionModelActionsFactory(GUIResources resources, IDEState state){
	super(resources,state);
        }


	 protected Vector<AbstractAction> createChangeViewActions(final DefaultGraphCell cell, final ModelJGraph graph) {
		 Vector<AbstractAction> possibleViews=new Vector<AbstractAction>();
		final ingenias.editor.entities.Entity ent=((ingenias.editor.entities.Entity)cell.getUserObject());
		
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.Agent")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.Agent")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.AgentWS")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.AgentWS")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.Role")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.Role")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.RoleWS")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.RoleWS")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.Task")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.Task")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.TaskWS")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.TaskWS")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.Goal")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.Goal")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.Interaction")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.Interaction")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.IUIterate")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.IUIterate")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.IUConcurrence")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.IUConcurrence")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.InteractionUnit")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.InteractionUnit")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.UMLSpecification")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.UMLSpecification")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.AUMLSpecification")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.AUMLSpecification")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.GRASIASpecification")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.GRASIASpecification")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.TextNote")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.TextNote")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.UMLComment")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.UMLComment")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
    		      
			
		  
			
		    
			 if (ent.getClass().getName().equals("ingenias.editor.entities.IInitiates")){
			
                   possibleViews.add(new AbstractAction("NOICON") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.IInitiates")){
			
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.IInitiates")){
			
                   possibleViews.add(new AbstractAction("LABEL") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
		 
			
		    
			 if (ent.getClass().getName().equals("ingenias.editor.entities.IColaborates")){
			
                   possibleViews.add(new AbstractAction("NOICON") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.IColaborates")){
			
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.IColaborates")){
			
                   possibleViews.add(new AbstractAction("LABEL") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
		 
			
		    
			 if (ent.getClass().getName().equals("ingenias.editor.entities.UIInitiates")){
			
                   possibleViews.add(new AbstractAction("NOICON") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.UIInitiates")){
			
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.UIInitiates")){
			
                   possibleViews.add(new AbstractAction("LABEL") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
		 
			
		    
			 if (ent.getClass().getName().equals("ingenias.editor.entities.UIColaborates")){
			
                   possibleViews.add(new AbstractAction("NOICON") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.UIColaborates")){
			
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.UIColaborates")){
			
                   possibleViews.add(new AbstractAction("LABEL") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
		 
			
		    
			 if (ent.getClass().getName().equals("ingenias.editor.entities.UISelection")){
			
                   possibleViews.add(new AbstractAction("NOICON") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.UISelection")){
			
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.UISelection")){
			
                   possibleViews.add(new AbstractAction("LABEL") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
		 
			
		    
			 if (ent.getClass().getName().equals("ingenias.editor.entities.IPursues")){
			
                   possibleViews.add(new AbstractAction("NOICON") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.IPursues")){
			
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.IPursues")){
			
                   possibleViews.add(new AbstractAction("LABEL") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
		 
			
		    
			 if (ent.getClass().getName().equals("ingenias.editor.entities.GTPursues")){
			
                   possibleViews.add(new AbstractAction("NOICON") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.GTPursues")){
			
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.GTPursues")){
			
                   possibleViews.add(new AbstractAction("LABEL") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
		 
			
		    
			 if (ent.getClass().getName().equals("ingenias.editor.entities.IHasSpec")){
			
                   possibleViews.add(new AbstractAction("NOICON") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.IHasSpec")){
			
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.IHasSpec")){
			
                   possibleViews.add(new AbstractAction("LABEL") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
		 
			
		    
			 if (ent.getClass().getName().equals("ingenias.editor.entities.UIPrecedes")){
			
                   possibleViews.add(new AbstractAction("NOICON") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.UIPrecedes")){
			
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.UIPrecedes")){
			
                   possibleViews.add(new AbstractAction("LABEL") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
		 
			
		    
			 if (ent.getClass().getName().equals("ingenias.editor.entities.UMLSendsMessage")){
			
                   possibleViews.add(new AbstractAction("NOICON") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.UMLSendsMessage")){
			
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.UMLSendsMessage")){
			
                   possibleViews.add(new AbstractAction("LABEL") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
		 
			
		    
			 if (ent.getClass().getName().equals("ingenias.editor.entities.UMLAnnotatedElement")){
			
                   possibleViews.add(new AbstractAction("NOICON") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.UMLAnnotatedElement")){
			
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.UMLAnnotatedElement")){
			
                   possibleViews.add(new AbstractAction("LABEL") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
		 
			
		    
			 if (ent.getClass().getName().equals("ingenias.editor.entities.IAccesses")){
			
                   possibleViews.add(new AbstractAction("NOICON") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.IAccesses")){
			
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.IAccesses")){
			
                   possibleViews.add(new AbstractAction("LABEL") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
		 
		 return possibleViews;
		 }
		 
		 

		 protected Vector<AbstractAction> createDiagramSpecificInsertActions(final Point pt, final ModelJGraph graph) {
			 Vector<AbstractAction> nobjects=new Vector<AbstractAction>();

		// Insert an object of type Agent
		nobjects.add(
			new AbstractAction("Insert Agent") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "Agent");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type Agent is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

		// Insert an object of type AgentWS
		nobjects.add(
			new AbstractAction("Insert AgentWS") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "AgentWS");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type AgentWS is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

		// Insert an object of type Role
		nobjects.add(
			new AbstractAction("Insert Role") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "Role");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type Role is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

		// Insert an object of type RoleWS
		nobjects.add(
			new AbstractAction("Insert RoleWS") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "RoleWS");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type RoleWS is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

		// Insert an object of type Task
		nobjects.add(
			new AbstractAction("Insert Task") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "Task");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type Task is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

		// Insert an object of type TaskWS
		nobjects.add(
			new AbstractAction("Insert TaskWS") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "TaskWS");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type TaskWS is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

		// Insert an object of type Goal
		nobjects.add(
			new AbstractAction("Insert Goal") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "Goal");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type Goal is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

		// Insert an object of type Interaction
		nobjects.add(
			new AbstractAction("Insert Interaction") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "Interaction");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type Interaction is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

		// Insert an object of type IUIterate
		nobjects.add(
			new AbstractAction("Insert IUIterate") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "IUIterate");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type IUIterate is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

		// Insert an object of type IUConcurrence
		nobjects.add(
			new AbstractAction("Insert IUConcurrence") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "IUConcurrence");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type IUConcurrence is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

		// Insert an object of type InteractionUnit
		nobjects.add(
			new AbstractAction("Insert InteractionUnit") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "InteractionUnit");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type InteractionUnit is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

		// Insert an object of type UMLSpecification
		nobjects.add(
			new AbstractAction("Insert UMLSpecification") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "UMLSpecification");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type UMLSpecification is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

		// Insert an object of type AUMLSpecification
		nobjects.add(
			new AbstractAction("Insert AUMLSpecification") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "AUMLSpecification");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type AUMLSpecification is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

		// Insert an object of type GRASIASpecification
		nobjects.add(
			new AbstractAction("Insert GRASIASpecification") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "GRASIASpecification");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type GRASIASpecification is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

		// Insert an object of type TextNote
		nobjects.add(
			new AbstractAction("Insert TextNote") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "TextNote");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type TextNote is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

		// Insert an object of type UMLComment
		nobjects.add(
			new AbstractAction("Insert UMLComment") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "UMLComment");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type UMLComment is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

			return nobjects;
	}
	
	




}

