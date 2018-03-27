


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
import java.awt.event.*;
import java.awt.image.*;

import java.util.Map;
import java.util.Hashtable;
import java.util.Vector;

import java.lang.reflect.*;

import java.net.URL;

import java.util.Map;
import java.util.Hashtable;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.event.UndoableEditEvent;

import org.jgraph.JGraph;
import org.jgraph.graph.*;
import org.jgraph.event.*;
import org.jgraph.plaf.basic.*;

import ingenias.editor.entities.*;
import ingenias.editor.widget.*;
import ingenias.editor.*;

import ingenias.exception.InvalidEntity;
import ingenias.exception.NullEntity;

import ingenias.generator.browser.BrowserImp;
import ingenias.generator.browser.Graph;
import ingenias.generator.browser.GraphEntity;

// MarqueeHandler that Connects Vertices and Displays PopupMenus

public class AgentModelActionsFactory extends DiagramMenuEntriesActionsFactory  implements java.io.Serializable {

        public AgentModelActionsFactory(GUIResources resources, IDEState state){
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
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.Plan")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.Plan")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.StateGoal")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.StateGoal")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.Fact")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.Fact")){
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
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.FrameFact")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.FrameFact")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.Believe")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.Believe")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.Compromise")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.Compromise")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.GeneralEvent")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.GeneralEvent")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.ApplicationEvent")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.ApplicationEvent")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.ApplicationEventSlots")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.ApplicationEventSlots")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.MentalStateProcessor")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.MentalStateProcessor")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.MentalStateManager")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.MentalStateManager")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.MentalState")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.MentalState")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.ConditionalMentalState")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.ConditionalMentalState")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.AutonomousEntityQuery")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.AutonomousEntityQuery")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.AgentRequirementsQuery")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.AgentRequirementsQuery")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.ConcreteAgent")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.ConcreteAgent")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.AgentModelBelieve")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.AgentModelBelieve")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.Conversation")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.Conversation")){
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
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.Application")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.Application")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.EnvironmentApplication")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.EnvironmentApplication")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
				graph.repaint();
                     }
                   });
			 }
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.InternalApplication")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.InternalApplication")){
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
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.GoalStateWS")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.GoalStateWS")){
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
			
                  
			
			
			
			 if (ent.getClass().getName().equals("ingenias.editor.entities.MentalInstanceSpecification")){
			 final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
                   possibleViews.add(new AbstractAction("UML") {
                     public void actionPerformed(ActionEvent e) {				
		     ent.getPrefs().setView(ViewPreferences.ViewType.UML);
				//ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
				graph.repaint();
                     }
                   });
			 }
			
                  
			 if (ent.getClass().getName().equals("ingenias.editor.entities.MentalInstanceSpecification")){
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
			
                     
		 
			
		    
			 if (ent.getClass().getName().equals("ingenias.editor.entities.AInherits")){
			
                   possibleViews.add(new AbstractAction("NOICON") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.AInherits")){
			
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.AInherits")){
			
                   possibleViews.add(new AbstractAction("LABEL") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
		 
			
		    
			 if (ent.getClass().getName().equals("ingenias.editor.entities.AHasMS")){
			
                   possibleViews.add(new AbstractAction("NOICON") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.AHasMS")){
			
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.AHasMS")){
			
                   possibleViews.add(new AbstractAction("LABEL") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
		 
			
		    
			 if (ent.getClass().getName().equals("ingenias.editor.entities.AHasMSManager")){
			
                   possibleViews.add(new AbstractAction("NOICON") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.AHasMSManager")){
			
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.AHasMSManager")){
			
                   possibleViews.add(new AbstractAction("LABEL") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
		 
			
		    
			 if (ent.getClass().getName().equals("ingenias.editor.entities.AHasMSProcessor")){
			
                   possibleViews.add(new AbstractAction("NOICON") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.AHasMSProcessor")){
			
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.AHasMSProcessor")){
			
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
			
                     
		 
			
		    
			 if (ent.getClass().getName().equals("ingenias.editor.entities.AInstanceOf")){
			
                   possibleViews.add(new AbstractAction("NOICON") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.AInstanceOf")){
			
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.AInstanceOf")){
			
                   possibleViews.add(new AbstractAction("LABEL") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
		 
			
		    
			 if (ent.getClass().getName().equals("ingenias.editor.entities.AContainsME")){
			
                   possibleViews.add(new AbstractAction("NOICON") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.AContainsME")){
			
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.AContainsME")){
			
                   possibleViews.add(new AbstractAction("LABEL") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
		 
			
		    
			 if (ent.getClass().getName().equals("ingenias.editor.entities.WFPlays")){
			
                   possibleViews.add(new AbstractAction("NOICON") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.WFPlays")){
			
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.WFPlays")){
			
                   possibleViews.add(new AbstractAction("LABEL") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
		 
			
		    
			 if (ent.getClass().getName().equals("ingenias.editor.entities.ARoleInheritance")){
			
                   possibleViews.add(new AbstractAction("NOICON") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.ARoleInheritance")){
			
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.ARoleInheritance")){
			
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
			
                     
		 
			
		    
			 if (ent.getClass().getName().equals("ingenias.editor.entities.EResourceBelongsTo")){
			
                   possibleViews.add(new AbstractAction("NOICON") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.EResourceBelongsTo")){
			
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.EResourceBelongsTo")){
			
                   possibleViews.add(new AbstractAction("LABEL") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
		 
			
		    
			 if (ent.getClass().getName().equals("ingenias.editor.entities.ApplicationBelongsTo")){
			
                   possibleViews.add(new AbstractAction("NOICON") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.ApplicationBelongsTo")){
			
                   possibleViews.add(new AbstractAction("INGENIAS") {
                     public void actionPerformed(ActionEvent e) {
		     ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,
                    			 ent, cell, graph);
	
				graph.repaint();
                     }
                   });
			 }
			
                     
			 if (ent.getClass().getName().equals("ingenias.editor.entities.ApplicationBelongsTo")){
			
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

		// Insert an object of type Plan
		nobjects.add(
			new AbstractAction("Insert Plan") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "Plan");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type Plan is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

		// Insert an object of type StateGoal
		nobjects.add(
			new AbstractAction("Insert StateGoal") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "StateGoal");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type StateGoal is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

		// Insert an object of type Fact
		nobjects.add(
			new AbstractAction("Insert Fact") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "Fact");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type Fact is not allowed in this diagram",
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

		// Insert an object of type FrameFact
		nobjects.add(
			new AbstractAction("Insert FrameFact") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "FrameFact");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type FrameFact is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

		// Insert an object of type Believe
		nobjects.add(
			new AbstractAction("Insert Believe") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "Believe");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type Believe is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

		// Insert an object of type Compromise
		nobjects.add(
			new AbstractAction("Insert Compromise") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "Compromise");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type Compromise is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

		// Insert an object of type GeneralEvent
		nobjects.add(
			new AbstractAction("Insert GeneralEvent") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "GeneralEvent");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type GeneralEvent is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

		// Insert an object of type ApplicationEvent
		nobjects.add(
			new AbstractAction("Insert ApplicationEvent") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "ApplicationEvent");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type ApplicationEvent is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

		// Insert an object of type ApplicationEventSlots
		nobjects.add(
			new AbstractAction("Insert ApplicationEventSlots") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "ApplicationEventSlots");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type ApplicationEventSlots is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

		// Insert an object of type MentalStateProcessor
		nobjects.add(
			new AbstractAction("Insert MentalStateProcessor") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "MentalStateProcessor");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type MentalStateProcessor is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

		// Insert an object of type MentalStateManager
		nobjects.add(
			new AbstractAction("Insert MentalStateManager") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "MentalStateManager");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type MentalStateManager is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

		// Insert an object of type MentalState
		nobjects.add(
			new AbstractAction("Insert MentalState") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "MentalState");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type MentalState is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

		// Insert an object of type ConditionalMentalState
		nobjects.add(
			new AbstractAction("Insert ConditionalMentalState") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "ConditionalMentalState");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type ConditionalMentalState is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

		// Insert an object of type AutonomousEntityQuery
		nobjects.add(
			new AbstractAction("Insert AutonomousEntityQuery") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "AutonomousEntityQuery");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type AutonomousEntityQuery is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

		// Insert an object of type AgentRequirementsQuery
		nobjects.add(
			new AbstractAction("Insert AgentRequirementsQuery") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "AgentRequirementsQuery");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type AgentRequirementsQuery is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

		// Insert an object of type ConcreteAgent
		nobjects.add(
			new AbstractAction("Insert ConcreteAgent") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "ConcreteAgent");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type ConcreteAgent is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

		// Insert an object of type AgentModelBelieve
		nobjects.add(
			new AbstractAction("Insert AgentModelBelieve") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "AgentModelBelieve");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type AgentModelBelieve is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

		// Insert an object of type Conversation
		nobjects.add(
			new AbstractAction("Insert Conversation") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "Conversation");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type Conversation is not allowed in this diagram",
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

		// Insert an object of type Application
		nobjects.add(
			new AbstractAction("Insert Application") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "Application");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type Application is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

		// Insert an object of type EnvironmentApplication
		nobjects.add(
			new AbstractAction("Insert EnvironmentApplication") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "EnvironmentApplication");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type EnvironmentApplication is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

		// Insert an object of type InternalApplication
		nobjects.add(
			new AbstractAction("Insert InternalApplication") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "InternalApplication");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type InternalApplication is not allowed in this diagram",
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

		// Insert an object of type GoalStateWS
		nobjects.add(
			new AbstractAction("Insert GoalStateWS") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "GoalStateWS");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type GoalStateWS is not allowed in this diagram",
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

		// Insert an object of type MentalInstanceSpecification
		nobjects.add(
			new AbstractAction("Insert MentalInstanceSpecification") {
				public void actionPerformed(ActionEvent ev) {
					try {
						graph.insert(pt, "MentalInstanceSpecification");
					} catch (InvalidEntity e) {						
						e.printStackTrace();
						JOptionPane.showMessageDialog(graph, "Object type MentalInstanceSpecification is not allowed in this diagram",
                                "Warning", JOptionPane.WARNING_MESSAGE);
					}
				}
			});

			return nobjects;
	}
	
	




}

