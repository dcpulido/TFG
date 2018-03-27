


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

public class ActivityDiagramActionsFactory extends DiagramMenuEntriesActionsFactory  implements java.io.Serializable {
	
	public ActivityDiagramActionsFactory(GUIResources resources, IDEState state){
		super(resources,state);
	}
	
	
	protected Vector<AbstractAction> createChangeViewActions(final DefaultGraphCell cell, final ModelJGraph graph) {
		Vector<AbstractAction> possibleViews=new Vector<AbstractAction>();
		final ingenias.editor.entities.Entity ent=((ingenias.editor.entities.Entity)cell.getUserObject());
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.InitialNode")){
			final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
			possibleViews.add(new AbstractAction("UML") {
				public void actionPerformed(ActionEvent e) {				
					ent.getPrefs().setView(ViewPreferences.ViewType.UML);
					//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.InitialNode")){
			final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {				
					ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
					//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
					graph.repaint();
				}
			});
		}
		
		
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.DecisionNode")){
			final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
			possibleViews.add(new AbstractAction("UML") {
				public void actionPerformed(ActionEvent e) {				
					ent.getPrefs().setView(ViewPreferences.ViewType.UML);
					//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.DecisionNode")){
			final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {				
					ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
					//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
					graph.repaint();
				}
			});
		}
		
		
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.ForkNode")){
			final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
			possibleViews.add(new AbstractAction("UML") {
				public void actionPerformed(ActionEvent e) {				
					ent.getPrefs().setView(ViewPreferences.ViewType.UML);
					//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.ForkNode")){
			final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {				
					ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
					//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.JoinNode")){
			final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
			possibleViews.add(new AbstractAction("UML") {
				public void actionPerformed(ActionEvent e) {				
					ent.getPrefs().setView(ViewPreferences.ViewType.UML);
					//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.JoinNode")){
			final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {				
					ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
					//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
					graph.repaint();
				}
			});
		}
		
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.EndNode")){
			final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
			possibleViews.add(new AbstractAction("UML") {
				public void actionPerformed(ActionEvent e) {				
					ent.getPrefs().setView(ViewPreferences.ViewType.UML);
					//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.EndNode")){
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
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WorkflowBox")){
			final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
			possibleViews.add(new AbstractAction("UML") {
				public void actionPerformed(ActionEvent e) {				
					ent.getPrefs().setView(ViewPreferences.ViewType.UML);
					//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WorkflowBox")){
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
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WorkProduct")){
			final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
			possibleViews.add(new AbstractAction("UML") {
				public void actionPerformed(ActionEvent e) {				
					ent.getPrefs().setView(ViewPreferences.ViewType.UML);
					//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WorkProduct")){
			final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {				
					ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
					//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.FreeWP")){
			final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
			possibleViews.add(new AbstractAction("UML") {
				public void actionPerformed(ActionEvent e) {				
					ent.getPrefs().setView(ViewPreferences.ViewType.UML);
					//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.FreeWP")){
			final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {				
					ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
					//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.BehaviourWP")){
			final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
			possibleViews.add(new AbstractAction("UML") {
				public void actionPerformed(ActionEvent e) {				
					ent.getPrefs().setView(ViewPreferences.ViewType.UML);
					//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.BehaviourWP")){
			final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {				
					ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
					//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.StructuredWP")){
			final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
			possibleViews.add(new AbstractAction("UML") {
				public void actionPerformed(ActionEvent e) {				
					ent.getPrefs().setView(ViewPreferences.ViewType.UML);
					//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.StructuredWP")){
			final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {				
					ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
					//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.StructuralWP")){
			final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
			possibleViews.add(new AbstractAction("UML") {
				public void actionPerformed(ActionEvent e) {				
					ent.getPrefs().setView(ViewPreferences.ViewType.UML);
					//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.StructuralWP")){
			final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {				
					ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
					//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
					graph.repaint();
				}
			});
		}
		
		
		
		
		
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.DPDFPrecedes")){
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON, ent, cell, graph);
					graph.repaint();
				}
			});
		}
		if (ent.getClass().getName().equals("ingenias.editor.entities.DPDFPrecedes")){
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS, ent, cell, graph);
					graph.repaint();
				}
			});
		}
		if (ent.getClass().getName().equals("ingenias.editor.entities.DPDFPrecedes")){
			possibleViews.add(new AbstractAction("LABEL") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL, ent, cell, graph);
					graph.repaint();
				}
			});
		}
		

		if (ent.getClass().getName().equals("ingenias.editor.entities.WFResponsable")){
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON, ent, cell, graph);
					graph.repaint();
				}
			});
		}
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFResponsable")){
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS, ent, cell, graph);
					graph.repaint();
				}
			});
		}
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFResponsable")){
			possibleViews.add(new AbstractAction("LABEL") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL, ent, cell, graph);
					graph.repaint();
				}
			});
		}
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFProduces")){
			
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON, ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFProduces")){
			
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS, ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFProduces")){
			
			possibleViews.add(new AbstractAction("LABEL") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL, ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFConsumes")){
			
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON, ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFConsumes")){
			
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS, ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFConsumes")){
			
			possibleViews.add(new AbstractAction("LABEL") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL, ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFContains")){
			
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON, ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFContains")){
			
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS, ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFContains")){
			
			possibleViews.add(new AbstractAction("LABEL") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL, ent, cell, graph);
					
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
		
		
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFStarts")){
			
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFStarts")){
			
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFStarts")){
			
			possibleViews.add(new AbstractAction("LABEL") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFEnds")){
			
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFEnds")){
			
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFEnds")){
			
			possibleViews.add(new AbstractAction("LABEL") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFDecides")){
			
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFDecides")){
			
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFDecides")){
			
			possibleViews.add(new AbstractAction("LABEL") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFResponsable")){
			
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFResponsable")){
			
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFResponsable")){
			
			possibleViews.add(new AbstractAction("LABEL") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFFollows")){
			
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFFollows")){
			
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFFollows")){
			
			possibleViews.add(new AbstractAction("LABEL") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFFollowsGuarded")){
			
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFFollowsGuarded")){
			
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFFollowsGuarded")){
			
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
		
		// Insert an object of type InitialNode
		nobjects.add(
					 new AbstractAction("Insert InitialNode") {
			public void actionPerformed(ActionEvent ev) {
				try {
					graph.insert(pt, "InitialNode");
				} catch (InvalidEntity e) {						
					e.printStackTrace();
					JOptionPane.showMessageDialog(graph, "Object type InitialNode is not allowed in this diagram",
												  "Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		// Insert an object of type DecisionNode
		nobjects.add(
					 new AbstractAction("Insert DecisionNode") {
			public void actionPerformed(ActionEvent ev) {
				try {
					graph.insert(pt, "DecisionNode");
				} catch (InvalidEntity e) {						
					e.printStackTrace();
					JOptionPane.showMessageDialog(graph, "Object type DecisionNode is not allowed in this diagram",
												  "Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		// Insert an object of type ForkNode
		nobjects.add(
					 new AbstractAction("Insert ForkNode") {
			public void actionPerformed(ActionEvent ev) {
				try {
					graph.insert(pt, "ForkNode");
				} catch (InvalidEntity e) {						
					e.printStackTrace();
					JOptionPane.showMessageDialog(graph, "Object type ForkNode is not allowed in this diagram",
												  "Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		// Insert an object of type EndNode
		nobjects.add(
					 new AbstractAction("Insert EndNode") {
			public void actionPerformed(ActionEvent ev) {
				try {
					graph.insert(pt, "EndNode");
				} catch (InvalidEntity e) {						
					e.printStackTrace();
					JOptionPane.showMessageDialog(graph, "Object type EndNode is not allowed in this diagram",
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
		
		// Insert an object of type WorkProduct
		nobjects.add(
					 new AbstractAction("Insert WorkProduct") {
			public void actionPerformed(ActionEvent ev) {
				try {
					graph.insert(pt, "WorkProduct");
				} catch (InvalidEntity e) {						
					e.printStackTrace();
					JOptionPane.showMessageDialog(graph, "Object type WorkProduct is not allowed in this diagram",
												  "Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		// Insert an object of type FreeWP
		nobjects.add(
					 new AbstractAction("Insert FreeWP") {
			public void actionPerformed(ActionEvent ev) {
				try {
					graph.insert(pt, "FreeWP");
				} catch (InvalidEntity e) {						
					e.printStackTrace();
					JOptionPane.showMessageDialog(graph, "Object type FreeWP is not allowed in this diagram",
												  "Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		// Insert an object of type BehaviourWP
		nobjects.add(
					 new AbstractAction("Insert BehaviourWP") {
			public void actionPerformed(ActionEvent ev) {
				try {
					graph.insert(pt, "BehaviourWP");
				} catch (InvalidEntity e) {						
					e.printStackTrace();
					JOptionPane.showMessageDialog(graph, "Object type BehaviourWP is not allowed in this diagram",
												  "Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		// Insert an object of type StructuralWP
		nobjects.add(
					 new AbstractAction("Insert StructuralWP") {
			public void actionPerformed(ActionEvent ev) {
				try {
					graph.insert(pt, "StructuralWP");
				} catch (InvalidEntity e) {						
					e.printStackTrace();
					JOptionPane.showMessageDialog(graph, "Object type StructuralWP is not allowed in this diagram",
												  "Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		// Insert an object of type StructuredWP
		nobjects.add(
					 new AbstractAction("Insert StructuredWP") {
			public void actionPerformed(ActionEvent ev) {
				try {
					graph.insert(pt, "StructuredWP");
				} catch (InvalidEntity e) {						
					e.printStackTrace();
					JOptionPane.showMessageDialog(graph, "Object type StructuredWP is not allowed in this diagram",
												  "Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		// Insert an object of type WorkflowBox
		nobjects.add(
					 new AbstractAction("Insert WorkflowBox") {
			public void actionPerformed(ActionEvent ev) {
				try {
					graph.insert(pt, "WorkflowBox");
				} catch (InvalidEntity e) {						
					e.printStackTrace();
					JOptionPane.showMessageDialog(graph, "Object type WorkflowBox is not allowed in this diagram",
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
		
		return nobjects;
	}
	
}

