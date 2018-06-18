
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
package ingenias.editor.models;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import java.net.URL;

import java.util.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;

import org.jgraph.event.*;
import org.jgraph.graph.*;
import org.jgraph.JGraph;
import org.jgraph.plaf.basic.*;

import ingenias.editor.*;
import ingenias.editor.cell.*;
import ingenias.editor.entities.*;
import ingenias.editor.events.*;

import ingenias.exception.InvalidEntity;

public class AgentModelModelJGraph extends ModelJGraph {
	
	private Preferences prefs;
	
	public AgentModelModelJGraph(AgentModelDataEntity mde, 
								 String nombre, ObjectManager om, Model
								 m, BasicMarqueeHandler mh, Preferences prefs) {
		super(mde, nombre, m, mh,om);
		this.prefs=prefs;
		ToolTipManager.sharedInstance().registerComponent(this);
		this.getModel().addGraphModelListener(new ChangeNARYEdgeLocation(this));
		this.getModel().addGraphModelListener(new ChangeEntityLocation(this));
		this.getGraphLayoutCache().setFactory(new ingenias.editor.cellfactories.AgentModelCellViewFactory());
	}
	
	
	//
	// Adding Tooltips
	//
	
	// Return Cell Label as a Tooltip
	public String getToolTipText(MouseEvent e) {
		if (e != null) {
			// Fetch Cell under Mousepointer
			Object c = getFirstCellForLocation(e.getX(), e.getY());
			if (c != null) {
				
				// Convert Cell to String and Return
				return convertValueToString(c);
			}
		}
		return null;
	}
	
	
	public JToolBar getPaleta() {
		return toolbar;
		
	}
	
	protected void creaToolBar() {
		if (toolbar==null){
			toolbar = new FilteredJToolBar("AgentModel");
			toolbar.setFloatable(false);
			ImageIcon undoIcon = null;
			JButton jb = null;
			
			/* Agent Definition */
			
			Image img_Agent = ImageLoader.getImage("images/agent40.gif");
			undoIcon = new ImageIcon(img_Agent);
			Action Agent= new AbstractAction("Agent", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "Agent");
					} catch (InvalidEntity e1) {
						e1.printStackTrace();
					}
				}
			};
			Agent.setEnabled(true);
			jb = new JButton(Agent);
			jb.setText("");
			jb.setName("Agent");	
			jb.setToolTipText("Agent");
			toolbar.add(jb);
			
			/* Role Definition */
			
			Image img_Role =
			ImageLoader.getImage("images/role40.png");
			undoIcon = new ImageIcon(img_Role);
			Action Role=
			new AbstractAction("Role", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "Role");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			Role.setEnabled(true);
			jb = new JButton(Role);
			jb.setText("");
			jb.setName("Role");	
			jb.setToolTipText("Role");
			toolbar.add(jb);
			
			/* Goal Definition */
			
			Image img_Goal =
			ImageLoader.getImage("images/goal40.png");
			undoIcon = new ImageIcon(img_Goal);
			Action Goal=
			new AbstractAction("Goal", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "Goal");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			Goal.setEnabled(true);
			jb = new JButton(Goal);
			jb.setText("");
			jb.setName("Goal");	
			jb.setToolTipText("Goal");
			toolbar.add(jb);
			
			/* Plan Definition */
			
			Image img_Plan =
			ImageLoader.getImage("images/plan40.gif");
			undoIcon = new ImageIcon(img_Plan);
			Action Plan=
			new AbstractAction("Plan", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "Plan");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			Plan.setEnabled(true);
			jb = new JButton(Plan);
			jb.setText("");
			jb.setName("Plan");	
			jb.setToolTipText("Plan");
			toolbar.add(jb);
			
			/* StateGoal Definition */
			
			Image img_StateGoal =
			ImageLoader.getImage("images/sgoal40.gif");
			undoIcon = new ImageIcon(img_StateGoal);
			Action StateGoal=
			new AbstractAction("StateGoal", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "StateGoal");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			StateGoal.setEnabled(true);
			jb = new JButton(StateGoal);
			jb.setText("");
			jb.setName("StateGoal");	
			jb.setToolTipText("StateGoal");
			toolbar.add(jb);
			
			/* Fact Definition */
			
			Image img_Fact =
			ImageLoader.getImage("images/fact40.png");
			undoIcon = new ImageIcon(img_Fact);
			Action Fact=
			new AbstractAction("Fact", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "Fact");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			Fact.setEnabled(true);
			jb = new JButton(Fact);
			jb.setText("");
			jb.setName("Fact");	
			jb.setToolTipText("Fact");
			toolbar.add(jb);
			
			/* Task Definition */
			
			Image img_Task =
			ImageLoader.getImage("images/task40.png");
			undoIcon = new ImageIcon(img_Task);
			Action Task=
			new AbstractAction("Task", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "Task");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			Task.setEnabled(true);
			jb = new JButton(Task);
			jb.setText("");
			jb.setName("Task");	
			jb.setToolTipText("Task");
			toolbar.add(jb);
			
			/* FrameFact Definition */
			
			Image img_FrameFact =
			ImageLoader.getImage("images/ffact40.png");
			undoIcon = new ImageIcon(img_FrameFact);
			Action FrameFact=
			new AbstractAction("FrameFact", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "FrameFact");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			FrameFact.setEnabled(true);
			jb = new JButton(FrameFact);
			jb.setText("");
			jb.setName("FrameFact");	
			jb.setToolTipText("FrameFact");
			toolbar.add(jb);
			
			/* Believe Definition */
			
			Image img_Believe =
			ImageLoader.getImage("images/bel40.gif");
			undoIcon = new ImageIcon(img_Believe);
			Action Believe=
			new AbstractAction("Believe", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "Believe");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			Believe.setEnabled(true);
			jb = new JButton(Believe);
			jb.setText("");
			jb.setName("Believe");	
			jb.setToolTipText("Believe");
			toolbar.add(jb);
			
			/* Compromise Definition */
			
			Image img_Compromise =
			ImageLoader.getImage("images/comp40.gif");
			undoIcon = new ImageIcon(img_Compromise);
			Action Compromise=
			new AbstractAction("Compromise", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "Compromise");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			Compromise.setEnabled(true);
			jb = new JButton(Compromise);
			jb.setText("");
			jb.setName("Compromise");	
			jb.setToolTipText("Compromise");
			toolbar.add(jb);
			
			/* Event Definition */
			
			Image img_GeneralEvent =
			ImageLoader.getImage("images/event40.png");
			undoIcon = new ImageIcon(img_GeneralEvent);
			Action GeneralEvent=
			new AbstractAction("GeneralEvent", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "GeneralEvent");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			GeneralEvent.setEnabled(true);
			jb = new JButton(GeneralEvent);
			jb.setText("");
			jb.setName("GeneralEvent");	
			jb.setToolTipText("GeneralEvent");
			toolbar.add(jb);
			
			/* Application Event Definition */
			
			Image img_ApplicationEvent =
			ImageLoader.getImage("images/eventa40.gif");
			undoIcon = new ImageIcon(img_ApplicationEvent);
			Action ApplicationEvent=
			new AbstractAction("ApplicationEvent", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "ApplicationEvent");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			ApplicationEvent.setEnabled(true);
			jb = new JButton(ApplicationEvent);
			jb.setText("");
			jb.setName("ApplicationEvent");	
			jb.setToolTipText("ApplicationEvent");
			toolbar.add(jb);
			
			/* Application Event Slots Definition */
			
			Image img_ApplicationEventSlots =
			ImageLoader.getImage("images/eventas40.png");
			undoIcon = new ImageIcon(img_ApplicationEventSlots);
			Action ApplicationEventSlots=
			new AbstractAction("ApplicationEventSlots", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "ApplicationEventSlots");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			ApplicationEventSlots.setEnabled(true);
			jb = new JButton(ApplicationEventSlots);
			jb.setText("");
			jb.setName("ApplicationEventSlots");	
			jb.setToolTipText("ApplicationEventSlots");
			toolbar.add(jb);
			
			/* Mental State Processor Definition */
			
			Image img_MentalStateProcessor =
			ImageLoader.getImage("images/proc40.gif");
			undoIcon = new ImageIcon(img_MentalStateProcessor);
			Action MentalStateProcessor=
			new AbstractAction("MentalStateProcessor", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "MentalStateProcessor");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			MentalStateProcessor.setEnabled(true);
			jb = new JButton(MentalStateProcessor);
			jb.setText("");
			jb.setName("MentalStateProcessor");	
			jb.setToolTipText("MentalStateProcessor");
			toolbar.add(jb);
			
			/* Mental State Manager Definition */
			
			Image img_MentalStateManager =
			ImageLoader.getImage("images/man40.gif");
			undoIcon = new ImageIcon(img_MentalStateManager);
			Action MentalStateManager=
			new AbstractAction("MentalStateManager", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "MentalStateManager");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			MentalStateManager.setEnabled(true);
			jb = new JButton(MentalStateManager);
			jb.setText("");
			jb.setName("MentalStateManager");	
			jb.setToolTipText("MentalStateManager");
			toolbar.add(jb);
			
			/* Mental State Definition */
			
			Image img_MentalState =
			ImageLoader.getImage("images/mstate40.gif");
			undoIcon = new ImageIcon(img_MentalState);
			Action MentalState=
			new AbstractAction("MentalState", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "MentalState");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			MentalState.setEnabled(true);
			jb = new JButton(MentalState);
			jb.setText("");
			jb.setName("MentalState");	
			jb.setToolTipText("MentalState");
			toolbar.add(jb);
			
			Image img_ConditionalMentalState =
			ImageLoader.getImage("images/cmstate40.gif");
			undoIcon = new ImageIcon(img_ConditionalMentalState);
			Action ConditionalMentalState=
			new AbstractAction("ConditionalMentalState", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "ConditionalMentalState");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			ConditionalMentalState.setEnabled(true);
			jb = new JButton(ConditionalMentalState);
			jb.setText("");
			jb.setName("ConditionalMentalState");	
			jb.setToolTipText("ConditionalMentalState");
			toolbar.add(jb);
			
			Image img_AutonomousEntityQuery =
			ImageLoader.getImage("images/query40.gif");
			undoIcon = new ImageIcon(img_AutonomousEntityQuery);
			Action AutonomousEntityQuery=
			new AbstractAction("AutonomousEntityQuery", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "AutonomousEntityQuery");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			AutonomousEntityQuery.setEnabled(true);
			jb = new JButton(AutonomousEntityQuery);
			jb.setText("");
			jb.setName("AutonomousEntityQuery");	
			jb.setToolTipText("AutonomousEntityQuery");
			toolbar.add(jb);
			
			Image img_AgentRequirementsQuery =
			ImageLoader.getImage("images/rquery40.gif");
			undoIcon = new ImageIcon(img_AgentRequirementsQuery);
			Action AgentRequirementsQuery=
			new AbstractAction("AgentRequirementsQuery", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "AgentRequirementsQuery");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			AgentRequirementsQuery.setEnabled(true);
			jb = new JButton(AgentRequirementsQuery);
			jb.setText("");
			jb.setName("AgentRequirementsQuery");	
			jb.setToolTipText("AgentRequirementsQuery");
			toolbar.add(jb);
			
			Image img_ConcreteAgent =
			ImageLoader.getImage("images/caquery40.gif");
			undoIcon = new ImageIcon(img_ConcreteAgent);
			Action ConcreteAgent=
			new AbstractAction("ConcreteAgent", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "ConcreteAgent");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			ConcreteAgent.setEnabled(true);
			jb = new JButton(ConcreteAgent);
			jb.setText("");
			jb.setName("ConcreteAgent");	
			jb.setToolTipText("ConcreteAgent");
			toolbar.add(jb);
			
			Image img_AgentModelBelieve =
			ImageLoader.getImage("images/abel40.gif");
			undoIcon = new ImageIcon(img_AgentModelBelieve);
			Action AgentModelBelieve=
			new AbstractAction("AgentModelBelieve", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "AgentModelBelieve");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			AgentModelBelieve.setEnabled(true);
			jb = new JButton(AgentModelBelieve);
			jb.setText("");
			jb.setName("AgentModelBelieve");	
			jb.setToolTipText("AgentModelBelieve");
			toolbar.add(jb);
			
			/* Conversation Definition */
			
			
			Image img_Conversation =
			ImageLoader.getImage("images/conv40.png");
			undoIcon = new ImageIcon(img_Conversation);
			Action Conversation=
			new AbstractAction("Conversation", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "Conversation");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			Conversation.setEnabled(true);
			jb = new JButton(Conversation);
			jb.setText("");
			jb.setName("Conversation");	
			jb.setToolTipText("Conversation");
			toolbar.add(jb);
			
			/* Application Definition */
			
			
			Image img_Application =
			ImageLoader.getImage("images/app40.png");
			undoIcon = new ImageIcon(img_Application);
			Action Application=
			new AbstractAction("Application", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "Application");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			Application.setEnabled(true);
			jb = new JButton(Application);
			jb.setText("");
			jb.setName("Application");	
			jb.setToolTipText("Application");
			toolbar.add(jb);
			
			/* Environent Application Definition */
			
			
			Image img_EnvironmentApplication =
			ImageLoader.getImage("images/appe40.png");
			undoIcon = new ImageIcon(img_EnvironmentApplication);
			Action EnvironmentApplication=
			new AbstractAction("EnvironmentApplication", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "EnvironmentApplication");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			EnvironmentApplication.setEnabled(true);
			jb = new JButton(EnvironmentApplication);
			jb.setText("");
			jb.setName("EnvironmentApplication");	
			jb.setToolTipText("EnvironmentApplication");
			toolbar.add(jb);
			
			/* Internal Application Definition */
			
			Image img_InternalApplication =
			ImageLoader.getImage("images/appi40.png");
			undoIcon = new ImageIcon(img_InternalApplication);
			Action InternalApplication=
			new AbstractAction("InternalApplication", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "InternalApplication");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			InternalApplication.setEnabled(true);
			jb = new JButton(InternalApplication);
			jb.setText("");
			jb.setName("InternalApplication");	
			jb.setToolTipText("InternalApplication");
			toolbar.add(jb);
			
			Image img_RoleWS =
			ImageLoader.getImage("images/rolews40.gif");
			undoIcon = new ImageIcon(img_RoleWS);
			Action RoleWS=
			new AbstractAction("RoleWS", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "RoleWS");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			RoleWS.setEnabled(true);
			jb = new JButton(RoleWS);
			jb.setText("");
			jb.setName("RoleWS");	
			jb.setToolTipText("RoleWS");
			toolbar.add(jb);
			
			Image img_TaskWS =
			ImageLoader.getImage("images/taskws40.gif");
			undoIcon = new ImageIcon(img_TaskWS);
			Action TaskWS=
			new AbstractAction("TaskWS", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "TaskWS");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			TaskWS.setEnabled(true);
			jb = new JButton(TaskWS);
			jb.setText("");
			jb.setName("TaskWS");	
			jb.setToolTipText("TaskWS");
			toolbar.add(jb);
			
			Image img_GoalStateWS =
			ImageLoader.getImage("images/goalstatews40.png");
			undoIcon = new ImageIcon(img_GoalStateWS);
			Action GoalStateWS=
			new AbstractAction("GoalStateWS", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "GoalStateWS");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			GoalStateWS.setEnabled(true);
			jb = new JButton(GoalStateWS);
			jb.setText("");
			jb.setName("GoalStateWS");	
			jb.setToolTipText("GoalStateWS");
			toolbar.add(jb);
			
			Image img_AgentWS =
			ImageLoader.getImage("images/agentws40.gif");
			undoIcon = new ImageIcon(img_AgentWS);
			Action AgentWS=
			new AbstractAction("AgentWS", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "AgentWS");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			AgentWS.setEnabled(true);
			jb = new JButton(AgentWS);
			jb.setText("");
			jb.setName("AgentWS");	
			jb.setToolTipText("AgentWS");
			toolbar.add(jb);
			
			Image img_MentalInstanceSpecification =
			ImageLoader.getImage("images/mispec40.gif");
			undoIcon = new ImageIcon(img_MentalInstanceSpecification);
			Action MentalInstanceSpecification=
			new AbstractAction("MentalInstanceSpecification", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(200, 300), "MentalInstanceSpecification");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			MentalInstanceSpecification.setEnabled(true);
			jb = new JButton(MentalInstanceSpecification);
			jb.setText("");
			jb.setName("MentalInstanceSpecification");	
			jb.setToolTipText("MentalInstanceSpecification");
			toolbar.add(jb);
			Image img_UMLComment =
			ImageLoader.getImage("images/umlcomment40.png");
			undoIcon = new ImageIcon(img_UMLComment);
			Action UMLComment=
			new AbstractAction("UMLComment", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "UMLComment");
					} catch (InvalidEntity e1) {
						e1.printStackTrace();
					}
				}
			};
			UMLComment.setEnabled(true);
			jb = new JButton(UMLComment);
			jb.setText("");
			jb.setName("UMLComment");
			jb.setToolTipText("UMLComment");
			toolbar.add(jb);
			
			Image img_TextNote =
			ImageLoader.getImage("images/text40.png");
			undoIcon = new ImageIcon(img_TextNote);
			Action TextNote=
			new AbstractAction("TextNote", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "TextNote");
					} catch (InvalidEntity e1) {
						e1.printStackTrace();
					}
				}
			};
			TextNote.setEnabled(true);
			jb = new JButton(TextNote);
			jb.setText("");
			jb.setName("TextNote");
			jb.setToolTipText("TextNote");
			toolbar.add(jb);
			
			
		}
		
	}
	
	public static Vector<String> getAllowedRelationships(){
		Vector<String> relationships=new   Vector<String>();
		
		
		relationships.add("GTPursues");
		
		relationships.add("AInherits");
		
		relationships.add("AHasMS");
		
		relationships.add("AHasMSManager");
		
		relationships.add("AHasMSProcessor");
		
		relationships.add("WFResponsable");
		
		relationships.add("AInstanceOf");
		
		relationships.add("AContainsME");
		
		relationships.add("WFPlays");
		
		relationships.add("ARoleInheritance");
		
		relationships.add("UMLAnnotatedElement");
		
		relationships.add("WFUses");
		
		relationships.add("EResourceBelongsTo");
		
		relationships.add("ApplicationBelongsTo");
		
		return relationships;
	}
	
	public static Vector<String> getAllowedEntities(){
		Vector<String> entities=new   Vector<String>();
		
		
		entities.add("Agent");
		
		entities.add("Role");
		
		entities.add("Goal");
		
		entities.add("StateGoal");
		
		entities.add("Plan");
		
		entities.add("Application");
		
		entities.add("EnvironmentApplication");
		
		entities.add("InternalApplication");
		
		entities.add("ApplicationEvent");
		
		entities.add("ApplicationEventSlots");
		
		entities.add("Fact");
		
		entities.add("FrameFact");
		
		entities.add("Task");
		
		entities.add("Believe");
		
		entities.add("Compromise");
		
		entities.add("GeneralEvent");
		
		entities.add("MentalState");
		
		entities.add("MentalStateProcessor");
		
		entities.add("MentalStateManager");
		
		entities.add("ConditionalMentalState");
		
		entities.add("MentalInstanceSpecification");
		
		entities.add("AutonomousEntityQuery");
		
		entities.add("AgentRequirementsQuery");
		
		entities.add("ConcreteAgent");
		
		entities.add("AgentModelBelieve");
		
		entities.add("Conversation");
		
		entities.add("UMLComment");
		
		entities.add("TextNote");
		
		entities.add("RoleWS");
		
		entities.add("TaskWS");
		
		entities.add("GoalStateWS");
		
		entities.add("AgentWS");
		
		return entities;
	}
	
	// Gets the name of the possible relationships for the selected GraphCells.
	// A relationship can be binary (DefaultEdge) or n-ary (NAryEdge).
	// The requested action is slightly different depending on selected items.
	// According to the number of Edges in selected, the action can be:
	// 0 => Propose a relationship between selected according included classes.
	// 1 and it is NAryEdge => The class of that NAryEdge if it is possible according implements java.io.Serializable
	//      current cardinality and included classes..
	// other cases => Error, no relationships are allowed.
	public Object[] getPossibleRelationships(GraphCell[] selected) {
		// Possible relationships initialization.
		Vector v = new Vector();
		
		// Search for NAryEdges in selected.
		int nAryEdgesNum = 0;
		int edgesNum = 0;
		NAryEdge selectedEdge = null;
		for (int i = 0; i < selected.length; i++) {
			if (selected[i] instanceof NAryEdge) {
				nAryEdgesNum++;
				selectedEdge = (NAryEdge) selected[i];
			}
			else if (selected[i] instanceof DefaultEdge) {
				edgesNum++;
				
				// Connections are only possible with two or more elements and without binary edges.
			}
		}
		if (selected.length >= 2 && edgesNum == 0) {
			
			// The number of NAryEdges is considered.
			if (nAryEdgesNum == 0) {
				// acceptConnection methods only admits vertex parameters.
				// Binary relationships.
				
				// N-ary relationships. Sometimes they can be also binary.
				if (GTPursuesEdge.acceptConnection(this.getModel(), selected)) {
					v.add("GTPursues");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (AInheritsEdge.acceptConnection(this.getModel(), selected)) {
					v.add("AInherits");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (AHasMSEdge.acceptConnection(this.getModel(), selected)) {
					v.add("AHasMS");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (AHasMSManagerEdge.acceptConnection(this.getModel(), selected)) {
					v.add("AHasMSManager");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (AHasMSProcessorEdge.acceptConnection(this.getModel(), selected)) {
					v.add("AHasMSProcessor");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (WFResponsableEdge.acceptConnection(this.getModel(), selected)) {
					v.add("WFResponsable");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (AInstanceOfEdge.acceptConnection(this.getModel(), selected)) {
					v.add("AInstanceOf");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (AContainsMEEdge.acceptConnection(this.getModel(), selected)) {
					v.add("AContainsME");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (WFPlaysEdge.acceptConnection(this.getModel(), selected)) {
					v.add("WFPlays");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (ARoleInheritanceEdge.acceptConnection(this.getModel(), selected)) {
					v.add("ARoleInheritance");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (UMLAnnotatedElementEdge.acceptConnection(this.getModel(), selected)) {
					v.add("UMLAnnotatedElement");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (WFUsesEdge.acceptConnection(this.getModel(), selected)) {
					v.add("WFUses");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (EResourceBelongsToEdge.acceptConnection(this.getModel(), selected)) {
					v.add("EResourceBelongsTo");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (ApplicationBelongsToEdge.acceptConnection(this.getModel(), selected)) {
					v.add("ApplicationBelongsTo");
				}
				
			}
			else if (nAryEdgesNum == 1) {
				
				if (selectedEdge instanceof GTPursuesEdge &&
					(GTPursuesEdge.acceptConnection(this.getModel(), selected))) {
					v.add("GTPursues");
				}
				
				if (selectedEdge instanceof AInheritsEdge &&
					(AInheritsEdge.acceptConnection(this.getModel(), selected))) {
					v.add("AInherits");
				}
				
				if (selectedEdge instanceof AHasMSEdge &&
					(AHasMSEdge.acceptConnection(this.getModel(), selected))) {
					v.add("AHasMS");
				}
				
				if (selectedEdge instanceof AHasMSManagerEdge &&
					(AHasMSManagerEdge.acceptConnection(this.getModel(), selected))) {
					v.add("AHasMSManager");
				}
				
				if (selectedEdge instanceof AHasMSProcessorEdge &&
					(AHasMSProcessorEdge.acceptConnection(this.getModel(), selected))) {
					v.add("AHasMSProcessor");
				}
				
				if (selectedEdge instanceof WFResponsableEdge &&
					(WFResponsableEdge.acceptConnection(this.getModel(), selected))) {
					v.add("WFResponsable");
				}
				
				if (selectedEdge instanceof AInstanceOfEdge &&
					(AInstanceOfEdge.acceptConnection(this.getModel(), selected))) {
					v.add("AInstanceOf");
				}
				
				if (selectedEdge instanceof AContainsMEEdge &&
					(AContainsMEEdge.acceptConnection(this.getModel(), selected))) {
					v.add("AContainsME");
				}
				
				if (selectedEdge instanceof WFPlaysEdge &&
					(WFPlaysEdge.acceptConnection(this.getModel(), selected))) {
					v.add("WFPlays");
				}
				
				if (selectedEdge instanceof ARoleInheritanceEdge &&
					(ARoleInheritanceEdge.acceptConnection(this.getModel(), selected))) {
					v.add("ARoleInheritance");
				}
				
				if (selectedEdge instanceof UMLAnnotatedElementEdge &&
					(UMLAnnotatedElementEdge.acceptConnection(this.getModel(), selected))) {
					v.add("UMLAnnotatedElement");
				}
				
				if (selectedEdge instanceof WFUsesEdge &&
					(WFUsesEdge.acceptConnection(this.getModel(), selected))) {
					v.add("WFUses");
				}
				
				if (selectedEdge instanceof EResourceBelongsToEdge &&
					(EResourceBelongsToEdge.acceptConnection(this.getModel(), selected))) {
					v.add("EResourceBelongsTo");
				}
				
				if (selectedEdge instanceof ApplicationBelongsToEdge &&
					(ApplicationBelongsToEdge.acceptConnection(this.getModel(), selected))) {
					v.add("ApplicationBelongsTo");
				}
				
			}
		}
		
		return v.toArray();
	}
	
	public DefaultGraphCell getInstanciaNRelacion(String relacion,
												  GraphCell[] selected) {
		
		// Search for NAryEdges in selected.
		int nAryEdgesNum = 0;
		int edgesNum = 0;
		NAryEdge selectedEdge = null;
		for (int i = 0; i < selected.length; i++) {
			if (selected[i] instanceof NAryEdge) {
				nAryEdgesNum++;
				selectedEdge = (NAryEdge) selected[i];
			}
			else if (selected[i] instanceof DefaultEdge) {
				edgesNum++;
				
			}
		}
		if (nAryEdgesNum <= 1 && edgesNum == 0) {
			
			if (relacion.equalsIgnoreCase("GTPursues")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof GTPursuesEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new GTPursuesEdge(new GTPursues(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("AInherits")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof AInheritsEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new AInheritsEdge(new AInherits(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("AHasMS")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof AHasMSEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new AHasMSEdge(new AHasMS(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("AHasMSManager")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof AHasMSManagerEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new AHasMSManagerEdge(new AHasMSManager(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("AHasMSProcessor")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof AHasMSProcessorEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new AHasMSProcessorEdge(new AHasMSProcessor(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("WFResponsable")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof WFResponsableEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new WFResponsableEdge(new WFResponsable(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("AInstanceOf")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof AInstanceOfEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new AInstanceOfEdge(new AInstanceOf(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("AContainsME")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof AContainsMEEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new AContainsMEEdge(new AContainsME(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("WFPlays")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof WFPlaysEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new WFPlaysEdge(new WFPlays(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("ARoleInheritance")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof ARoleInheritanceEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new ARoleInheritanceEdge(new ARoleInheritance(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("UMLAnnotatedElement")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof UMLAnnotatedElementEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new UMLAnnotatedElementEdge(new UMLAnnotatedElement(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("WFUses")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof WFUsesEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new WFUsesEdge(new WFUses(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("EResourceBelongsTo")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof EResourceBelongsToEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new EResourceBelongsToEdge(new EResourceBelongsTo(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("ApplicationBelongsTo")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof ApplicationBelongsToEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new ApplicationBelongsToEdge(new ApplicationBelongsTo(getMJGraph().getNewId()));
				}
			}
			
		}
		
		return null;
	}
	
	public DefaultGraphCell createCell(String entity) throws InvalidEntity{
		
		if (entity.equalsIgnoreCase("Agent")) {
			Agent nentity=getOM().createAgent(getMJGraph().getNewId("Agent"));
			DefaultGraphCell vertex = new
			AgentCell(nentity);
			// Default Size for the cell with the new entity
			return vertex;
		}
		else
			
			if (entity.equalsIgnoreCase("Role")) {
				Role nentity=getOM().createRole(getMJGraph().getNewId("Role"));
				DefaultGraphCell vertex = new
				RoleCell(nentity);
				// Default Size for the cell with the new entity
				return vertex;
			}
			else
				
				if (entity.equalsIgnoreCase("Goal")) {
					Goal nentity=getOM().createGoal(getMJGraph().getNewId("Goal"));
					DefaultGraphCell vertex = new
					GoalCell(nentity);
					// Default Size for the cell with the new entity
					return vertex;
				}
				else
					
					if (entity.equalsIgnoreCase("Plan")) {
						Plan nentity=getOM().createPlan(getMJGraph().getNewId("Plan"));
						DefaultGraphCell vertex = new
						PlanCell(nentity);
						// Default Size for the cell with the new entity
						return vertex;
					}
					else
						
						if (entity.equalsIgnoreCase("StateGoal")) {
							StateGoal nentity=getOM().createStateGoal(getMJGraph().getNewId("StateGoal"));
							DefaultGraphCell vertex = new
							StateGoalCell(nentity);
							// Default Size for the cell with the new entity
							return vertex;
						}
						else
							
							if (entity.equalsIgnoreCase("Fact")) {
								Fact nentity=getOM().createFact(getMJGraph().getNewId("Fact"));
								DefaultGraphCell vertex = new
								FactCell(nentity);
								// Default Size for the cell with the new entity
								return vertex;
							}
							else
								
								if (entity.equalsIgnoreCase("Task")) {
									Task nentity=getOM().createTask(getMJGraph().getNewId("Task"));
									DefaultGraphCell vertex = new
									TaskCell(nentity);
									// Default Size for the cell with the new entity
									return vertex;
								}
								else
									
									if (entity.equalsIgnoreCase("FrameFact")) {
										FrameFact nentity=getOM().createFrameFact(getMJGraph().getNewId("FrameFact"));
										DefaultGraphCell vertex = new
										FrameFactCell(nentity);
										// Default Size for the cell with the new entity
										return vertex;
									}
									else
										
										if (entity.equalsIgnoreCase("Believe")) {
											Believe nentity=getOM().createBelieve(getMJGraph().getNewId("Believe"));
											DefaultGraphCell vertex = new
											BelieveCell(nentity);
											// Default Size for the cell with the new entity
											return vertex;
										}
										else
											
											if (entity.equalsIgnoreCase("Compromise")) {
												Compromise nentity=getOM().createCompromise(getMJGraph().getNewId("Compromise"));
												DefaultGraphCell vertex = new
												CompromiseCell(nentity);
												// Default Size for the cell with the new entity
												return vertex;
											}
											else
												
												if (entity.equalsIgnoreCase("GeneralEvent")) {
													GeneralEvent nentity=getOM().createGeneralEvent(getMJGraph().getNewId("GeneralEvent"));
													DefaultGraphCell vertex = new
													GeneralEventCell(nentity);
													// Default Size for the cell with the new entity
													return vertex;
												}
												else
													
													if (entity.equalsIgnoreCase("ApplicationEvent")) {
														ApplicationEvent nentity=getOM().createApplicationEvent(getMJGraph().getNewId("ApplicationEvent"));
														DefaultGraphCell vertex = new
														ApplicationEventCell(nentity);
														// Default Size for the cell with the new entity
														return vertex;
													}
													else
														
														if (entity.equalsIgnoreCase("ApplicationEventSlots")) {
															ApplicationEventSlots nentity=getOM().createApplicationEventSlots(getMJGraph().getNewId("ApplicationEventSlots"));
															DefaultGraphCell vertex = new
															ApplicationEventSlotsCell(nentity);
															// Default Size for the cell with the new entity
															return vertex;
														}
														else
															
															if (entity.equalsIgnoreCase("MentalStateProcessor")) {
																MentalStateProcessor nentity=getOM().createMentalStateProcessor(getMJGraph().getNewId("MentalStateProcessor"));
																DefaultGraphCell vertex = new
																MentalStateProcessorCell(nentity);
																// Default Size for the cell with the new entity
																return vertex;
															}
															else
																
																if (entity.equalsIgnoreCase("MentalStateManager")) {
																	MentalStateManager nentity=getOM().createMentalStateManager(getMJGraph().getNewId("MentalStateManager"));
																	DefaultGraphCell vertex = new
																	MentalStateManagerCell(nentity);
																	// Default Size for the cell with the new entity
																	return vertex;
																}
																else
																	
																	if (entity.equalsIgnoreCase("MentalState")) {
																		MentalState nentity=getOM().createMentalState(getMJGraph().getNewId("MentalState"));
																		DefaultGraphCell vertex = new
																		MentalStateCell(nentity);
																		// Default Size for the cell with the new entity
																		return vertex;
																	}
																	else
																		
																		if (entity.equalsIgnoreCase("ConditionalMentalState")) {
																			ConditionalMentalState nentity=getOM().createConditionalMentalState(getMJGraph().getNewId("ConditionalMentalState"));
																			DefaultGraphCell vertex = new
																			ConditionalMentalStateCell(nentity);
																			// Default Size for the cell with the new entity
																			return vertex;
																		}
																		else
																			
																			if (entity.equalsIgnoreCase("AutonomousEntityQuery")) {
																				AutonomousEntityQuery nentity=getOM().createAutonomousEntityQuery(getMJGraph().getNewId("AutonomousEntityQuery"));
																				DefaultGraphCell vertex = new
																				AutonomousEntityQueryCell(nentity);
																				// Default Size for the cell with the new entity
																				return vertex;
																			}
																			else
																				
																				if (entity.equalsIgnoreCase("AgentRequirementsQuery")) {
																					AgentRequirementsQuery nentity=getOM().createAgentRequirementsQuery(getMJGraph().getNewId("AgentRequirementsQuery"));
																					DefaultGraphCell vertex = new
																					AgentRequirementsQueryCell(nentity);
																					// Default Size for the cell with the new entity
																					return vertex;
																				}
																				else
																					
																					if (entity.equalsIgnoreCase("ConcreteAgent")) {
																						ConcreteAgent nentity=getOM().createConcreteAgent(getMJGraph().getNewId("ConcreteAgent"));
																						DefaultGraphCell vertex = new
																						ConcreteAgentCell(nentity);
																						// Default Size for the cell with the new entity
																						return vertex;
																					}
																					else
																						
																						if (entity.equalsIgnoreCase("AgentModelBelieve")) {
																							AgentModelBelieve nentity=getOM().createAgentModelBelieve(getMJGraph().getNewId("AgentModelBelieve"));
																							DefaultGraphCell vertex = new
																							AgentModelBelieveCell(nentity);
																							// Default Size for the cell with the new entity
																							return vertex;
																						}
																						else
																							
																							if (entity.equalsIgnoreCase("Conversation")) {
																								Conversation nentity=getOM().createConversation(getMJGraph().getNewId("Conversation"));
																								DefaultGraphCell vertex = new
																								ConversationCell(nentity);
																								// Default Size for the cell with the new entity
																								return vertex;
																							}
																							else
																								
																								if (entity.equalsIgnoreCase("UMLComment")) {
																									UMLComment nentity=getOM().createUMLComment(getMJGraph().getNewId("UMLComment"));
																									DefaultGraphCell vertex = new
																									UMLCommentCell(nentity);
																									// Default Size for the cell with the new entity
																									return vertex;
																								}
																								else
																									
																									if (entity.equalsIgnoreCase("TextNote")) {
																										TextNote nentity=getOM().createTextNote(getMJGraph().getNewId("TextNote"));
																										DefaultGraphCell vertex = new
																										TextNoteCell(nentity);
																										// Default Size for the cell with the new entity
																										return vertex;
																									}
																									else
																										
																										if (entity.equalsIgnoreCase("Application")) {
																											Application nentity=getOM().createApplication(getMJGraph().getNewId("Application"));
																											DefaultGraphCell vertex = new
																											ApplicationCell(nentity);
																											// Default Size for the cell with the new entity
																											return vertex;
																										}
																										else
																											
																											if (entity.equalsIgnoreCase("EnvironmentApplication")) {
																												EnvironmentApplication nentity=getOM().createEnvironmentApplication(getMJGraph().getNewId("EnvironmentApplication"));
																												DefaultGraphCell vertex = new
																												EnvironmentApplicationCell(nentity);
																												// Default Size for the cell with the new entity
																												return vertex;
																											}
																											else
																												
																												if (entity.equalsIgnoreCase("InternalApplication")) {
																													InternalApplication nentity=getOM().createInternalApplication(getMJGraph().getNewId("InternalApplication"));
																													DefaultGraphCell vertex = new
																													InternalApplicationCell(nentity);
																													// Default Size for the cell with the new entity
																													return vertex;
																												}
																												else
																													
																													if (entity.equalsIgnoreCase("RoleWS")) {
																														RoleWS nentity=getOM().createRoleWS(getMJGraph().getNewId("RoleWS"));
																														DefaultGraphCell vertex = new
																														RoleWSCell(nentity);
																														// Default Size for the cell with the new entity
																														return vertex;
																													}
																													else
																														
																														if (entity.equalsIgnoreCase("TaskWS")) {
																															TaskWS nentity=getOM().createTaskWS(getMJGraph().getNewId("TaskWS"));
																															DefaultGraphCell vertex = new
																															TaskWSCell(nentity);
																															// Default Size for the cell with the new entity
																															return vertex;
																														}
																														else
																															
																															if (entity.equalsIgnoreCase("GoalStateWS")) {
																																GoalStateWS nentity=getOM().createGoalStateWS(getMJGraph().getNewId("GoalStateWS"));
																																DefaultGraphCell vertex = new
																																GoalStateWSCell(nentity);
																																// Default Size for the cell with the new entity
																																return vertex;
																															}
																															else
																																
																																if (entity.equalsIgnoreCase("AgentWS")) {
																																	AgentWS nentity=getOM().createAgentWS(getMJGraph().getNewId("AgentWS"));
																																	DefaultGraphCell vertex = new
																																	AgentWSCell(nentity);
																																	// Default Size for the cell with the new entity
																																	return vertex;
																																}
																																else
																																	
																																	if (entity.equalsIgnoreCase("MentalInstanceSpecification")) {
																																		MentalInstanceSpecification nentity=getOM().createMentalInstanceSpecification(getMJGraph().getNewId("MentalInstanceSpecification"));
																																		DefaultGraphCell vertex = new
																																		MentalInstanceSpecificationCell(nentity);
																																		// Default Size for the cell with the new entity
																																		return vertex;
																																	}
																																	else
																																		
																																		throw new ingenias.exception.InvalidEntity("Entity type "+entity+" is not allowed in this diagram"); 
	}
	
	public Dimension getDefaultSize(Entity entity) throws InvalidEntity{
		
		if (entity.getType().equalsIgnoreCase("Agent")) {
			return AgentView.getSize((Agent)entity);      
		}
		else
			
			if (entity.getType().equalsIgnoreCase("Role")) {
				return RoleView.getSize((Role)entity);      
			}
			else
				
				if (entity.getType().equalsIgnoreCase("Goal")) {
					return GoalView.getSize((Goal)entity);      
				}
				else
					
					if (entity.getType().equalsIgnoreCase("Plan")) {
						return PlanView.getSize((Plan)entity);      
					}
					else
						
						if (entity.getType().equalsIgnoreCase("StateGoal")) {
							return StateGoalView.getSize((StateGoal)entity);      
						}
						else
							
							if (entity.getType().equalsIgnoreCase("Fact")) {
								return FactView.getSize((Fact)entity);      
							}
							else
								
								if (entity.getType().equalsIgnoreCase("Task")) {
									return TaskView.getSize((Task)entity);      
								}
								else
									
									if (entity.getType().equalsIgnoreCase("FrameFact")) {
										return FrameFactView.getSize((FrameFact)entity);      
									}
									else
										
										if (entity.getType().equalsIgnoreCase("Believe")) {
											return BelieveView.getSize((Believe)entity);      
										}
										else
											
											if (entity.getType().equalsIgnoreCase("Compromise")) {
												return CompromiseView.getSize((Compromise)entity);      
											}
											else
												
												if (entity.getType().equalsIgnoreCase("GeneralEvent")) {
													return GeneralEventView.getSize((GeneralEvent)entity);      
												}
												else
													
													if (entity.getType().equalsIgnoreCase("ApplicationEvent")) {
														return ApplicationEventView.getSize((ApplicationEvent)entity);      
													}
													else
														
														if (entity.getType().equalsIgnoreCase("ApplicationEventSlots")) {
															return ApplicationEventSlotsView.getSize((ApplicationEventSlots)entity);      
														}
														else
															
															if (entity.getType().equalsIgnoreCase("MentalStateProcessor")) {
																return MentalStateProcessorView.getSize((MentalStateProcessor)entity);      
															}
															else
																
																if (entity.getType().equalsIgnoreCase("MentalStateManager")) {
																	return MentalStateManagerView.getSize((MentalStateManager)entity);      
																}
																else
																	
																	if (entity.getType().equalsIgnoreCase("MentalState")) {
																		return MentalStateView.getSize((MentalState)entity);      
																	}
																	else
																		
																		if (entity.getType().equalsIgnoreCase("ConditionalMentalState")) {
																			return ConditionalMentalStateView.getSize((ConditionalMentalState)entity);      
																		}
																		else
																			
																			if (entity.getType().equalsIgnoreCase("AutonomousEntityQuery")) {
																				return AutonomousEntityQueryView.getSize((AutonomousEntityQuery)entity);      
																			}
																			else
																				
																				if (entity.getType().equalsIgnoreCase("AgentRequirementsQuery")) {
																					return AgentRequirementsQueryView.getSize((AgentRequirementsQuery)entity);      
																				}
																				else
																					
																					if (entity.getType().equalsIgnoreCase("ConcreteAgent")) {
																						return ConcreteAgentView.getSize((ConcreteAgent)entity);      
																					}
																					else
																						
																						if (entity.getType().equalsIgnoreCase("AgentModelBelieve")) {
																							return AgentModelBelieveView.getSize((AgentModelBelieve)entity);      
																						}
																						else
																							
																							if (entity.getType().equalsIgnoreCase("Conversation")) {
																								return ConversationView.getSize((Conversation)entity);      
																							}
																							else
																								
																								if (entity.getType().equalsIgnoreCase("UMLComment")) {
																									return UMLCommentView.getSize((UMLComment)entity);      
																								}
																								else
																									
																									if (entity.getType().equalsIgnoreCase("TextNote")) {
																										return TextNoteView.getSize((TextNote)entity);      
																									}
																									else
																										
																										if (entity.getType().equalsIgnoreCase("Application")) {
																											return ApplicationView.getSize((Application)entity);      
																										}
																										else
																											
																											if (entity.getType().equalsIgnoreCase("EnvironmentApplication")) {
																												return EnvironmentApplicationView.getSize((EnvironmentApplication)entity);      
																											}
																											else
																												
																												if (entity.getType().equalsIgnoreCase("InternalApplication")) {
																													return InternalApplicationView.getSize((InternalApplication)entity);      
																												}
																												else
																													
																													if (entity.getType().equalsIgnoreCase("RoleWS")) {
																														return RoleWSView.getSize((RoleWS)entity);      
																													}
																													else
																														
																														if (entity.getType().equalsIgnoreCase("TaskWS")) {
																															return TaskWSView.getSize((TaskWS)entity);      
																														}
																														else
																															
																															if (entity.getType().equalsIgnoreCase("GoalStateWS")) {
																																return GoalStateWSView.getSize((GoalStateWS)entity);      
																															}
																															else
																																
																																if (entity.getType().equalsIgnoreCase("AgentWS")) {
																																	return AgentWSView.getSize((AgentWS)entity);      
																																}
																																else
																																	
																																	if (entity.getType().equalsIgnoreCase("MentalInstanceSpecification")) {
																																		return MentalInstanceSpecificationView.getSize((MentalInstanceSpecification)entity);      
																																	}
																																	else
																																		
																																		throw new ingenias.exception.InvalidEntity("Entity type "+entity+" is not allowed in this diagram"); 
	    
	}
	
	public DefaultGraphCell insert(Point point, String entity) throws InvalidEntity {
		// CellView information is not available after creating the cell.
		
		// Create a Map that holds the attributes for the Vertex
		Map map = new Hashtable();
		// Snap the Point to the Grid
		point = convert(this.snap(new Point(point)));
		
		// Construct Vertex with no Label
		DefaultGraphCell vertex;
		Dimension size;
		
		vertex=this.createCell(entity);
		size=this.getDefaultSize((Entity)vertex.getUserObject());
		
		
		
		// Add a Bounds Attribute to the Map
		GraphConstants.setBounds(map, new Rectangle(point, size));
		
		// Construct a Map from cells to Maps (for insert)
		Hashtable attributes = new Hashtable();
		// Associate the Vertex with its Attributes
		attributes.put(vertex, map);
		// Insert the Vertex and its Attributes
		this.getModel().insert(new Object[] {vertex},attributes
							   , null, null, null);
		
		Entity newEntity=(Entity) vertex.getUserObject();
		if (prefs.getModelingLanguage()==Preferences.ModelingLanguage.UML)
			newEntity.getPrefs().setView(ViewPreferences.ViewType.UML);
		if (prefs.getModelingLanguage()==Preferences.ModelingLanguage.INGENIAS)
			newEntity.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
		
		return vertex;
	}
	
	
	
	
	public DefaultGraphCell insertDuplicated(Point point, ingenias.editor.entities.Entity
											 entity) {
		// CellView information is not available after creating the cell.
		
		// Create a Map that holds the attributes for the Vertex
		Map map =new Hashtable();
		// Snap the Point to the Grid
		point = convert(this.snap(new Point(point)));
		
		
		// Construct Vertex with no Label
		DefaultGraphCell vertex = null;
		Dimension size = null;
		
		
		if (entity.getClass().equals(Agent.class)) {
			vertex = new AgentCell( (Agent) entity);
			// Default Size for the new Vertex with the new entity within
			size = AgentView.getSize((Agent) entity);
		}
		else
			
			if (entity.getClass().equals(Role.class)) {
				vertex = new RoleCell( (Role) entity);
				// Default Size for the new Vertex with the new entity within
				size = RoleView.getSize((Role) entity);
			}
			else
				
				if (entity.getClass().equals(Goal.class)) {
					vertex = new GoalCell( (Goal) entity);
					// Default Size for the new Vertex with the new entity within
					size = GoalView.getSize((Goal) entity);
				}
				else
					
					if (entity.getClass().equals(Plan.class)) {
						vertex = new PlanCell( (Plan) entity);
						// Default Size for the new Vertex with the new entity within
						size = PlanView.getSize((Plan) entity);
					}
					else
						
						if (entity.getClass().equals(StateGoal.class)) {
							vertex = new StateGoalCell( (StateGoal) entity);
							// Default Size for the new Vertex with the new entity within
							size = StateGoalView.getSize((StateGoal) entity);
						}
						else
							
							if (entity.getClass().equals(Fact.class)) {
								vertex = new FactCell( (Fact) entity);
								// Default Size for the new Vertex with the new entity within
								size = FactView.getSize((Fact) entity);
							}
							else
								
								if (entity.getClass().equals(Task.class)) {
									vertex = new TaskCell( (Task) entity);
									// Default Size for the new Vertex with the new entity within
									size = TaskView.getSize((Task) entity);
								}
								else
									
									if (entity.getClass().equals(FrameFact.class)) {
										vertex = new FrameFactCell( (FrameFact) entity);
										// Default Size for the new Vertex with the new entity within
										size = FrameFactView.getSize((FrameFact) entity);
									}
									else
										
										if (entity.getClass().equals(Believe.class)) {
											vertex = new BelieveCell( (Believe) entity);
											// Default Size for the new Vertex with the new entity within
											size = BelieveView.getSize((Believe) entity);
										}
										else
											
											if (entity.getClass().equals(Compromise.class)) {
												vertex = new CompromiseCell( (Compromise) entity);
												// Default Size for the new Vertex with the new entity within
												size = CompromiseView.getSize((Compromise) entity);
											}
											else
												
												if (entity.getClass().equals(GeneralEvent.class)) {
													vertex = new GeneralEventCell( (GeneralEvent) entity);
													// Default Size for the new Vertex with the new entity within
													size = GeneralEventView.getSize((GeneralEvent) entity);
												}
												else
													
													if (entity.getClass().equals(ApplicationEvent.class)) {
														vertex = new ApplicationEventCell( (ApplicationEvent) entity);
														// Default Size for the new Vertex with the new entity within
														size = ApplicationEventView.getSize((ApplicationEvent) entity);
													}
													else
														
														if (entity.getClass().equals(ApplicationEventSlots.class)) {
															vertex = new ApplicationEventSlotsCell( (ApplicationEventSlots) entity);
															// Default Size for the new Vertex with the new entity within
															size = ApplicationEventSlotsView.getSize((ApplicationEventSlots) entity);
														}
														else
															
															if (entity.getClass().equals(MentalStateProcessor.class)) {
																vertex = new MentalStateProcessorCell( (MentalStateProcessor) entity);
																// Default Size for the new Vertex with the new entity within
																size = MentalStateProcessorView.getSize((MentalStateProcessor) entity);
															}
															else
																
																if (entity.getClass().equals(MentalStateManager.class)) {
																	vertex = new MentalStateManagerCell( (MentalStateManager) entity);
																	// Default Size for the new Vertex with the new entity within
																	size = MentalStateManagerView.getSize((MentalStateManager) entity);
																}
																else
																	
																	if (entity.getClass().equals(MentalState.class)) {
																		vertex = new MentalStateCell( (MentalState) entity);
																		// Default Size for the new Vertex with the new entity within
																		size = MentalStateView.getSize((MentalState) entity);
																	}
																	else
																		
																		if (entity.getClass().equals(ConditionalMentalState.class)) {
																			vertex = new ConditionalMentalStateCell( (ConditionalMentalState) entity);
																			// Default Size for the new Vertex with the new entity within
																			size = ConditionalMentalStateView.getSize((ConditionalMentalState) entity);
																		}
																		else
																			
																			if (entity.getClass().equals(AutonomousEntityQuery.class)) {
																				vertex = new AutonomousEntityQueryCell( (AutonomousEntityQuery) entity);
																				// Default Size for the new Vertex with the new entity within
																				size = AutonomousEntityQueryView.getSize((AutonomousEntityQuery) entity);
																			}
																			else
																				
																				if (entity.getClass().equals(AgentRequirementsQuery.class)) {
																					vertex = new AgentRequirementsQueryCell( (AgentRequirementsQuery) entity);
																					// Default Size for the new Vertex with the new entity within
																					size = AgentRequirementsQueryView.getSize((AgentRequirementsQuery) entity);
																				}
																				else
																					
																					if (entity.getClass().equals(ConcreteAgent.class)) {
																						vertex = new ConcreteAgentCell( (ConcreteAgent) entity);
																						// Default Size for the new Vertex with the new entity within
																						size = ConcreteAgentView.getSize((ConcreteAgent) entity);
																					}
																					else
																						
																						if (entity.getClass().equals(AgentModelBelieve.class)) {
																							vertex = new AgentModelBelieveCell( (AgentModelBelieve) entity);
																							// Default Size for the new Vertex with the new entity within
																							size = AgentModelBelieveView.getSize((AgentModelBelieve) entity);
																						}
																						else
																							
																							if (entity.getClass().equals(Conversation.class)) {
																								vertex = new ConversationCell( (Conversation) entity);
																								// Default Size for the new Vertex with the new entity within
																								size = ConversationView.getSize((Conversation) entity);
																							}
																							else
																								
																								if (entity.getClass().equals(UMLComment.class)) {
																									vertex = new UMLCommentCell( (UMLComment) entity);
																									// Default Size for the new Vertex with the new entity within
																									size = UMLCommentView.getSize((UMLComment) entity);
																								}
																								else
																									
																									if (entity.getClass().equals(TextNote.class)) {
																										vertex = new TextNoteCell( (TextNote) entity);
																										// Default Size for the new Vertex with the new entity within
																										size = TextNoteView.getSize((TextNote) entity);
																									}
																									else
																										
																										if (entity.getClass().equals(Application.class)) {
																											vertex = new ApplicationCell( (Application) entity);
																											// Default Size for the new Vertex with the new entity within
																											size = ApplicationView.getSize((Application) entity);
																										}
																										else
																											
																											if (entity.getClass().equals(EnvironmentApplication.class)) {
																												vertex = new EnvironmentApplicationCell( (EnvironmentApplication) entity);
																												// Default Size for the new Vertex with the new entity within
																												size = EnvironmentApplicationView.getSize((EnvironmentApplication) entity);
																											}
																											else
																												
																												if (entity.getClass().equals(InternalApplication.class)) {
																													vertex = new InternalApplicationCell( (InternalApplication) entity);
																													// Default Size for the new Vertex with the new entity within
																													size = InternalApplicationView.getSize((InternalApplication) entity);
																												}
																												else
																													
																													if (entity.getClass().equals(RoleWS.class)) {
																														vertex = new RoleWSCell( (RoleWS) entity);
																														// Default Size for the new Vertex with the new entity within
																														size = RoleWSView.getSize((RoleWS) entity);
																													}
																													else
																														
																														if (entity.getClass().equals(TaskWS.class)) {
																															vertex = new TaskWSCell( (TaskWS) entity);
																															// Default Size for the new Vertex with the new entity within
																															size = TaskWSView.getSize((TaskWS) entity);
																														}
																														else
																															
																															if (entity.getClass().equals(GoalStateWS.class)) {
																																vertex = new GoalStateWSCell( (GoalStateWS) entity);
																																// Default Size for the new Vertex with the new entity within
																																size = GoalStateWSView.getSize((GoalStateWS) entity);
																															}
																															else
																																
																																if (entity.getClass().equals(AgentWS.class)) {
																																	vertex = new AgentWSCell( (AgentWS) entity);
																																	// Default Size for the new Vertex with the new entity within
																																	size = AgentWSView.getSize((AgentWS) entity);
																																}
																																else
																																	
																																	if (entity.getClass().equals(MentalInstanceSpecification.class)) {
																																		vertex = new MentalInstanceSpecificationCell( (MentalInstanceSpecification) entity);
																																		// Default Size for the new Vertex with the new entity within
																																		size = MentalInstanceSpecificationView.getSize((MentalInstanceSpecification) entity);
																																	}
																																	else
																																		
																																	{}; // Just in case there is no allowed entity in the diagram
		
		if (vertex == null) {
			JOptionPane.showMessageDialog(this,
										  "Object not allowed in this diagram "+this.getID()+":"+ 
										  entity.getId()+":"+entity.getClass().getName()+
										  this.getClass().getName(),"Warning", JOptionPane.WARNING_MESSAGE);    }
		else {
			
			// Add a Bounds Attribute to the Map
			GraphConstants.setBounds(map, new Rectangle(point, size));
			
			// Construct a Map from cells to Maps (for insert)
			Hashtable attributes = new Hashtable();
			// Associate the Vertex with its Attributes
			attributes.put(vertex, map);
			// Insert the Vertex and its Attributes
			this.getModel().insert(new Object[] {vertex},attributes
								   , null, null, null);
		}
		return vertex;
		
	}
	
	
	public synchronized JGraph cloneJGraph(IDEState ids){
		
		
		
		AgentModelModelJGraph jg=new  AgentModelModelJGraph(
															(AgentModelDataEntity) this.mde,name, ids.om,
															new Model(ids),new BasicMarqueeHandler(),ids.prefs); 
		
		this.setSelectionCells(getGraphLayoutCache().getCells(false,true,false,false));
		Action copyaction =new EventRedirectorForGraphCopy(this,this.getTransferHandler().getCopyAction(),null	); 			
		Action pasteaction =new EventRedirectorPasteForGraphCopy(jg,jg.getTransferHandler().getPasteAction(),null	);
		copyaction.actionPerformed(new ActionEvent(this,0,"hello"));		
		pasteaction.actionPerformed(new ActionEvent(this,0,"hello"));
		jg.invalidate();
		jg.doLayout();
		
		return jg;
		
	}
	
	
	public String toString() {
		return this.getID();
	}
	
}
