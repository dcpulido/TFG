


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

public class PhaseDiagramActionsFactory extends DiagramMenuEntriesActionsFactory  implements java.io.Serializable {
	
	public PhaseDiagramActionsFactory(GUIResources resources, IDEState state){
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
		
		
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.Phase")){
			final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
			possibleViews.add(new AbstractAction("UML") {
				public void actionPerformed(ActionEvent e) {				
					ent.getPrefs().setView(ViewPreferences.ViewType.UML);
					//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.Phase")){
			final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {				
					ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
					//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
					graph.repaint();
				}
			});
		}
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.iPhase")){
			final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
			possibleViews.add(new AbstractAction("UML") {
				public void actionPerformed(ActionEvent e) {				
					ent.getPrefs().setView(ViewPreferences.ViewType.UML);
					//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.iPhase")){
			final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {				
					ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
					//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
					graph.repaint();
				}
			});
		}
		
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.Activity")){
			final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
			possibleViews.add(new AbstractAction("UML") {
				public void actionPerformed(ActionEvent e) {				
					ent.getPrefs().setView(ViewPreferences.ViewType.UML);
					//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.Activity")){
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
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.ActivityPrecedes")){
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON, ent, cell, graph);
					graph.repaint();
				}
			});
		}
		if (ent.getClass().getName().equals("ingenias.editor.entities.ActivityPrecedes")){
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS, ent, cell, graph);
					graph.repaint();
				}
			});
		}
		if (ent.getClass().getName().equals("ingenias.editor.entities.ActivityPrecedes")){
			possibleViews.add(new AbstractAction("LABEL") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL, ent, cell, graph);
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTCreates")){
			
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTCreates")){
			
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTCreates")){
			
			possibleViews.add(new AbstractAction("LABEL") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTAffects")){
			
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTAffects")){
			
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTAffects")){
			
			possibleViews.add(new AbstractAction("LABEL") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTDestroys")){
			
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTDestroys")){
			
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTDestroys")){
			
			possibleViews.add(new AbstractAction("LABEL") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTModifies")){
			
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTModifies")){
			
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTModifies")){
			
			possibleViews.add(new AbstractAction("LABEL") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTFails")){
			
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTFails")){
			
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTFails")){
			
			possibleViews.add(new AbstractAction("LABEL") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTSatisfies")){
			
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTSatisfies")){
			
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTSatisfies")){
			
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
		
		
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFConsumes")){
			
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFConsumes")){
			
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFConsumes")){
			
			possibleViews.add(new AbstractAction("LABEL") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.Consumes")){
			
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.Consumes")){
			
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.Consumes")){
			
			possibleViews.add(new AbstractAction("LABEL") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFUses")){
			
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFUses")){
			
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFUses")){
			
			possibleViews.add(new AbstractAction("LABEL") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFUsesMethod")){
			
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFUsesMethod")){
			
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFUsesMethod")){
			
			possibleViews.add(new AbstractAction("LABEL") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTDecomposes")){
			
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTDecomposes")){
			
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTDecomposes")){
			
			possibleViews.add(new AbstractAction("LABEL") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTDecomposesAND")){
			
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTDecomposesAND")){
			
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTDecomposesAND")){
			
			possibleViews.add(new AbstractAction("LABEL") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTDecomposesOR")){
			
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTDecomposesOR")){
			
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTDecomposesOR")){
			
			possibleViews.add(new AbstractAction("LABEL") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTDepends")){
			
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTDepends")){
			
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTDepends")){
			
			possibleViews.add(new AbstractAction("LABEL") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTInherits")){
			
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTInherits")){
			
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTInherits")){
			
			possibleViews.add(new AbstractAction("LABEL") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTAndDepends")){
			
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTAndDepends")){
			
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTAndDepends")){
			
			possibleViews.add(new AbstractAction("LABEL") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTOrDepends")){
			
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTOrDepends")){
			
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.GTOrDepends")){
			
			possibleViews.add(new AbstractAction("LABEL") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFDecomposes")){
			
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFDecomposes")){
			
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFDecomposes")){
			
			possibleViews.add(new AbstractAction("LABEL") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.Contribute")){
			
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.Contribute")){
			
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.Contribute")){
			
			possibleViews.add(new AbstractAction("LABEL") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.ContributePositively")){
			
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.ContributePositively")){
			
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.ContributePositively")){
			
			possibleViews.add(new AbstractAction("LABEL") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.ContributeNegatively")){
			
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.ContributeNegatively")){
			
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.ContributeNegatively")){
			
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
		
		
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFParticipates")){
			
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFParticipates")){
			
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFParticipates")){
			
			possibleViews.add(new AbstractAction("LABEL") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFCancels")){
			
			possibleViews.add(new AbstractAction("NOICON") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFCancels")){
			
			possibleViews.add(new AbstractAction("INGENIAS") {
				public void actionPerformed(ActionEvent e) {
					ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
																					ent, cell, graph);
					
					graph.repaint();
				}
			});
		}
		
		
		if (ent.getClass().getName().equals("ingenias.editor.entities.WFCancels")){
			
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
		
		// Insert an object of type Phase
		nobjects.add(
					 new AbstractAction("Insert Phase") {
			public void actionPerformed(ActionEvent ev) {
				try {
					graph.insert(pt, "Phase");
				} catch (InvalidEntity e) {						
					e.printStackTrace();
					JOptionPane.showMessageDialog(graph, "Object type Phase is not allowed in this diagram",
												  "Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		// Insert an object of type iPhase
		nobjects.add(
					 new AbstractAction("Insert iPhase") {
			public void actionPerformed(ActionEvent ev) {
				try {
					graph.insert(pt, "iPhase");
				} catch (InvalidEntity e) {						
					e.printStackTrace();
					JOptionPane.showMessageDialog(graph, "Object type iPhase is not allowed in this diagram",
												  "Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		// Insert an object of type Activity
		nobjects.add(
					 new AbstractAction("Insert Activity") {
			public void actionPerformed(ActionEvent ev) {
				try {
					graph.insert(pt, "Activity");
				} catch (InvalidEntity e) {						
					e.printStackTrace();
					JOptionPane.showMessageDialog(graph, "Object type Activity is not allowed in this diagram",
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
		
		// Insert an object of type JoinNode
		nobjects.add(
					 new AbstractAction("Insert JoinNode") {
			public void actionPerformed(ActionEvent ev) {
				try {
					graph.insert(pt, "JoinNode");
				} catch (InvalidEntity e) {						
					e.printStackTrace();
					JOptionPane.showMessageDialog(graph, "Object type JoinNode is not allowed in this diagram",
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

