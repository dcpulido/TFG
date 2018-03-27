
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

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.event.UndoableEditEvent;

import java.util.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;

import javax.swing.*;

import java.net.URL;

import org.jgraph.JGraph;
import org.jgraph.graph.*;
import org.jgraph.event.*;
import org.jgraph.plaf.basic.*;

import ingenias.editor.*;
import ingenias.editor.cell.*;
import ingenias.editor.entities.*;
import ingenias.editor.events.*;
import ingenias.exception.InvalidEntity;


public class OrganizationModelModelJGraph extends ModelJGraph {
	
	private Preferences prefs;
	
	public OrganizationModelModelJGraph(OrganizationModelDataEntity mde, 
										String nombre, ObjectManager om, Model
										m, BasicMarqueeHandler mh, Preferences prefs) {
		super(mde, nombre, m, mh,om);
		this.prefs=prefs;
		
		
		ToolTipManager.sharedInstance().registerComponent(this);
		this.getModel().addGraphModelListener(
											  new ChangeNARYEdgeLocation(this));
		this.getModel().addGraphModelListener(
											  new ChangeEntityLocation(this));			  
		
		
		this.getGraphLayoutCache().setFactory(new ingenias.editor.cellfactories.OrganizationModelCellViewFactory());
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
			toolbar = new FilteredJToolBar("OrganizationModel");
			toolbar.setFloatable(false);
			ImageIcon undoIcon = null;
			JButton jb = null;
			
			//agent
			//org
			//group
			//network
			//role
			//resource
			//app
			//appe
			//appi
			//task
			
			Image img_Agent = ImageLoader.getImage("images/agent40.gif");
			undoIcon = new ImageIcon(img_Agent);
			Action Agent=
			new AbstractAction("Agent", undoIcon) {
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
			
			Image img_Organization = ImageLoader.getImage("images/org40.gif");
			undoIcon = new ImageIcon(img_Organization);
			Action Organization=
			new AbstractAction("Organization", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "Organization");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			Organization.setEnabled(true);
			jb = new JButton(Organization);
			jb.setText("");
			jb.setName("Organization");	
			jb.setToolTipText("Organization");
			toolbar.add(jb);
			
			Image img_OrganizationGroup =
			ImageLoader.getImage("images/group40.gif");
			undoIcon = new ImageIcon(img_OrganizationGroup);
			Action OrganizationGroup=
			new AbstractAction("OrganizationGroup", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "OrganizationGroup");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			OrganizationGroup.setEnabled(true);
			jb = new JButton(OrganizationGroup);
			jb.setText("");
			jb.setName("OrganizationGroup");	
			jb.setToolTipText("OrganizationGroup");
			toolbar.add(jb);
			
			Image img_OrganizationNetwork =
			ImageLoader.getImage("images/network40.gif");
			undoIcon = new ImageIcon(img_OrganizationNetwork);
			Action OrganizationNetwork=
			new AbstractAction("OrganizationNetwork", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "OrganizationNetwork");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			OrganizationNetwork.setEnabled(true);
			jb = new JButton(OrganizationNetwork);
			jb.setText("");
			jb.setName("OrganizationNetwork");	
			jb.setToolTipText("OrganizationNetwork");
			toolbar.add(jb);
			
			Image img_Role = ImageLoader.getImage("images/role40.png");
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
			
			Image img_Workflow =
			ImageLoader.getImage("images/workflow40.gif");
			undoIcon = new ImageIcon(img_Workflow);
			Action Workflow=
			new AbstractAction("Workflow", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "Workflow");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			Workflow.setEnabled(true);
			jb = new JButton(Workflow);
			jb.setText("");
			jb.setName("Workflow");	
			jb.setToolTipText("Workflow");
			toolbar.add(jb);
			
			Image img_Interaction =
			ImageLoader.getImage("images/inter40.png");
			undoIcon = new ImageIcon(img_Interaction);
			Action Interaction=
			new AbstractAction("Interaction", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "Interaction");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			Interaction.setEnabled(true);
			jb = new JButton(Interaction);
			jb.setText("");
			jb.setName("Interaction");	
			jb.setToolTipText("Interaction");
			toolbar.add(jb);
			
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
			
			Image img_Task = ImageLoader.getImage("images/task40.png");
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
			
			Image img_Resource = ImageLoader.getImage("images/resource40.png");
			undoIcon = new ImageIcon(img_Resource);
			Action Resource=
			new AbstractAction("Resource", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "Resource");
					} catch (InvalidEntity e1) {
						e1.printStackTrace();
					}
				}
			};
			Resource.setEnabled(true);
			jb = new JButton(Resource);
			jb.setText("");
			jb.setName("Resource");
			jb.setToolTipText("Resource");
			toolbar.add(jb);
			
			Image img_Application = ImageLoader.getImage("images/app40.png");
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
			
			Image img_EnvironmentApplication = ImageLoader.getImage("images/appe40.png");
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
			
			Image img_InternalApplication = ImageLoader.getImage("images/appi40.png");
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
			
			Image img_GeneralEvent =
			ImageLoader.getImage("images/event40.gif");
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
			
			Image img_WorkflowBox =
			ImageLoader.getImage("images/workflow40.gif");
			undoIcon = new ImageIcon(img_WorkflowBox);
			Action WorkflowBox=
			new AbstractAction("WorkflowBox", undoIcon) {
				public void actionPerformed(ActionEvent e) {
					try{
						insert(new Point(0, 0), "WorkflowBox");
					} catch (InvalidEntity e1) {			
						e1.printStackTrace();
					}
				}
			};
			WorkflowBox.setEnabled(true);
			jb = new JButton(WorkflowBox);
			jb.setText("");
			jb.setName("WorkflowBox");	
			jb.setToolTipText("WorkflowBox");
			toolbar.add(jb);
			
		}
		
	}
	
	public static Vector<String> getAllowedRelationships(){
		Vector<String> relationships=new   Vector<String>();
		
		
		relationships.add("UMLAnnotatedElement");
		
		relationships.add("EResourceBelongsTo");
		
		relationships.add("OHasGroup");
		
		relationships.add("OHasMember");
		
		relationships.add("OHasWF");
		
		relationships.add("ODecomposesGroup");
		
		relationships.add("ODecomposesWF");
		
		relationships.add("GTPursues");
		
		relationships.add("WFConnects");
		
		relationships.add("WFUses");
		
		relationships.add("WFContainsTask");
		
		relationships.add("WFContains");
		
		relationships.add("WFConsumes");
		
		relationships.add("Consumes");
		
		relationships.add("WFDecomposes");
		
		relationships.add("WFProduces");
		
		relationships.add("AGORelationshipGroup");
		
		relationships.add("AGORelationshipMember");
		
		relationships.add("AGORelationshipOrg");
		
		relationships.add("AGOSubordinationRelationshipGroup");
		
		relationships.add("AGOSubordinationRelationshipMember");
		
		relationships.add("AGOSubordinationRelationshipOrg");
		
		relationships.add("AGOCondSubordinationRelationshipGroup");
		
		relationships.add("AGOCondSubordinationRelationshipMember");
		
		relationships.add("AGOCondSubordinationRelationshipOrg");
		
		relationships.add("AGOInconditionalSubordinationRelationshipGroup");
		
		relationships.add("AGOInconditionalSubordinationRelationshipMember");
		
		relationships.add("AGOInconditionalSubordinationRelationshipOrg");
		
		relationships.add("AGOClientServerRelationshipGroup");
		
		relationships.add("AGOClientServerRelationshipMember");
		
		relationships.add("AGOClientServerRelationshipOrg");
		
		relationships.add("WFSpecifiesExecution");
		
		relationships.add("WFResponsable");
		
		relationships.add("WFParticipates");
		
		relationships.add("WFPlays");
		
		relationships.add("WFDecomposesWF");
		
		relationships.add("UMLAnnotatedElement");
		
		relationships.add("WSConnects");
		
		return relationships;
	}
	
	public static Vector<String> getAllowedEntities(){
		Vector<String> entities=new   Vector<String>();
		
		
		entities.add("Agent");
		
		entities.add("Organization");
		
		entities.add("OrganizationGroup");
		
		entities.add("OrganizationNetwork");
		
		entities.add("Role");
		
		entities.add("Resource");
		
		entities.add("Application");
		
		entities.add("EnvironmentApplication");
		
		entities.add("InternalApplication");
		
		entities.add("Task");
		
		entities.add("Plan");
		
		entities.add("Workflow");
		
		entities.add("Interaction");
		
		entities.add("Goal");
		
		entities.add("Fact");
		
		entities.add("FrameFact");
		
		entities.add("Believe");
		
		entities.add("GeneralEvent");
		
		entities.add("ApplicationEvent");
		
		entities.add("ApplicationEventSlots");
		
		entities.add("AutonomousEntityQuery");
		
		entities.add("AgentRequirementsQuery");
		
		entities.add("ConcreteAgent");
		
		entities.add("TextNote");
		
		entities.add("UMLComment");
		
		entities.add("RoleWS");
		
		entities.add("TaskWS");
		
		entities.add("GoalStateWS");
		
		entities.add("AgentWS");
		
		entities.add("WorkflowBox");
		
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
				if (UMLAnnotatedElementEdge.acceptConnection(this.getModel(), selected)) {
					v.add("UMLAnnotatedElement");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (EResourceBelongsToEdge.acceptConnection(this.getModel(), selected)) {
					v.add("EResourceBelongsTo");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (OHasGroupEdge.acceptConnection(this.getModel(), selected)) {
					v.add("OHasGroup");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (OHasMemberEdge.acceptConnection(this.getModel(), selected)) {
					v.add("OHasMember");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (OHasWFEdge.acceptConnection(this.getModel(), selected)) {
					v.add("OHasWF");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (ODecomposesGroupEdge.acceptConnection(this.getModel(), selected)) {
					v.add("ODecomposesGroup");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (ODecomposesWFEdge.acceptConnection(this.getModel(), selected)) {
					v.add("ODecomposesWF");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (GTPursuesEdge.acceptConnection(this.getModel(), selected)) {
					v.add("GTPursues");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (WFConnectsEdge.acceptConnection(this.getModel(), selected)) {
					v.add("WFConnects");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (WFUsesEdge.acceptConnection(this.getModel(), selected)) {
					v.add("WFUses");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (WFContainsTaskEdge.acceptConnection(this.getModel(), selected)) {
					v.add("WFContainsTask");
				}
				
				if (WFContainsEdge.acceptConnection(this.getModel(), selected)) {
					v.add("WFContains");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (WFConsumesEdge.acceptConnection(this.getModel(), selected)) {
					v.add("WFConsumes");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (ConsumesEdge.acceptConnection(this.getModel(), selected)) {
					v.add("Consumes");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (WFDecomposesEdge.acceptConnection(this.getModel(), selected)) {
					v.add("WFDecomposes");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (WFProducesEdge.acceptConnection(this.getModel(), selected)) {
					v.add("WFProduces");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (AGORelationshipGroupEdge.acceptConnection(this.getModel(), selected)) {
					v.add("AGORelationshipGroup");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (AGORelationshipMemberEdge.acceptConnection(this.getModel(), selected)) {
					v.add("AGORelationshipMember");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (AGORelationshipOrgEdge.acceptConnection(this.getModel(), selected)) {
					v.add("AGORelationshipOrg");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (AGOSubordinationRelationshipGroupEdge.acceptConnection(this.getModel(), selected)) {
					v.add("AGOSubordinationRelationshipGroup");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (AGOSubordinationRelationshipMemberEdge.acceptConnection(this.getModel(), selected)) {
					v.add("AGOSubordinationRelationshipMember");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (AGOSubordinationRelationshipOrgEdge.acceptConnection(this.getModel(), selected)) {
					v.add("AGOSubordinationRelationshipOrg");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (AGOCondSubordinationRelationshipGroupEdge.acceptConnection(this.getModel(), selected)) {
					v.add("AGOCondSubordinationRelationshipGroup");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (AGOCondSubordinationRelationshipMemberEdge.acceptConnection(this.getModel(), selected)) {
					v.add("AGOCondSubordinationRelationshipMember");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (AGOCondSubordinationRelationshipOrgEdge.acceptConnection(this.getModel(), selected)) {
					v.add("AGOCondSubordinationRelationshipOrg");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (AGOInconditionalSubordinationRelationshipGroupEdge.acceptConnection(this.getModel(), selected)) {
					v.add("AGOInconditionalSubordinationRelationshipGroup");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (AGOInconditionalSubordinationRelationshipMemberEdge.acceptConnection(this.getModel(), selected)) {
					v.add("AGOInconditionalSubordinationRelationshipMember");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (AGOInconditionalSubordinationRelationshipOrgEdge.acceptConnection(this.getModel(), selected)) {
					v.add("AGOInconditionalSubordinationRelationshipOrg");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (AGOClientServerRelationshipGroupEdge.acceptConnection(this.getModel(), selected)) {
					v.add("AGOClientServerRelationshipGroup");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (AGOClientServerRelationshipMemberEdge.acceptConnection(this.getModel(), selected)) {
					v.add("AGOClientServerRelationshipMember");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (AGOClientServerRelationshipOrgEdge.acceptConnection(this.getModel(), selected)) {
					v.add("AGOClientServerRelationshipOrg");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (WFSpecifiesExecutionEdge.acceptConnection(this.getModel(), selected)) {
					v.add("WFSpecifiesExecution");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (WFResponsableEdge.acceptConnection(this.getModel(), selected)) {
					v.add("WFResponsable");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (WFParticipatesEdge.acceptConnection(this.getModel(), selected)) {
					v.add("WFParticipates");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (WFPlaysEdge.acceptConnection(this.getModel(), selected)) {
					v.add("WFPlays");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (WFDecomposesWFEdge.acceptConnection(this.getModel(), selected)) {
					v.add("WFDecomposesWF");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (UMLAnnotatedElementEdge.acceptConnection(this.getModel(), selected)) {
					v.add("UMLAnnotatedElement");
				}
				
				// N-ary relationships. Sometimes they can be also binary.
				if (WSConnectsEdge.acceptConnection(this.getModel(), selected)) {
					v.add("WSConnects");
				}
				
			}
			else if (nAryEdgesNum == 1) {
				
				if (selectedEdge instanceof UMLAnnotatedElementEdge &&
					(UMLAnnotatedElementEdge.acceptConnection(this.getModel(), selected))) {
					v.add("UMLAnnotatedElement");
				}
				
				if (selectedEdge instanceof EResourceBelongsToEdge &&
					(EResourceBelongsToEdge.acceptConnection(this.getModel(), selected))) {
					v.add("EResourceBelongsTo");
				}
				
				if (selectedEdge instanceof OHasGroupEdge &&
					(OHasGroupEdge.acceptConnection(this.getModel(), selected))) {
					v.add("OHasGroup");
				}
				
				if (selectedEdge instanceof OHasMemberEdge &&
					(OHasMemberEdge.acceptConnection(this.getModel(), selected))) {
					v.add("OHasMember");
				}
				
				if (selectedEdge instanceof OHasWFEdge &&
					(OHasWFEdge.acceptConnection(this.getModel(), selected))) {
					v.add("OHasWF");
				}
				
				if (selectedEdge instanceof ODecomposesGroupEdge &&
					(ODecomposesGroupEdge.acceptConnection(this.getModel(), selected))) {
					v.add("ODecomposesGroup");
				}
				
				if (selectedEdge instanceof ODecomposesWFEdge &&
					(ODecomposesWFEdge.acceptConnection(this.getModel(), selected))) {
					v.add("ODecomposesWF");
				}
				
				if (selectedEdge instanceof GTPursuesEdge &&
					(GTPursuesEdge.acceptConnection(this.getModel(), selected))) {
					v.add("GTPursues");
				}
				
				if (selectedEdge instanceof WFConnectsEdge &&
					(WFConnectsEdge.acceptConnection(this.getModel(), selected))) {
					v.add("WFConnects");
				}
				
				if (selectedEdge instanceof WFUsesEdge &&
					(WFUsesEdge.acceptConnection(this.getModel(), selected))) {
					v.add("WFUses");
				}
				
				if (selectedEdge instanceof WFContainsTaskEdge &&
					(WFContainsTaskEdge.acceptConnection(this.getModel(), selected))) {
					v.add("WFContainsTask");
				}
				
				if (selectedEdge instanceof WFContainsEdge &&
					(WFContainsEdge.acceptConnection(this.getModel(), selected))) {
					v.add("WFContains");
				}
				
				if (selectedEdge instanceof WFConsumesEdge &&
					(WFConsumesEdge.acceptConnection(this.getModel(), selected))) {
					v.add("WFConsumes");
				}
				
				if (selectedEdge instanceof ConsumesEdge &&
					(ConsumesEdge.acceptConnection(this.getModel(), selected))) {
					v.add("Consumes");
				}
				
				if (selectedEdge instanceof WFDecomposesEdge &&
					(WFDecomposesEdge.acceptConnection(this.getModel(), selected))) {
					v.add("WFDecomposes");
				}
				
				if (selectedEdge instanceof WFProducesEdge &&
					(WFProducesEdge.acceptConnection(this.getModel(), selected))) {
					v.add("WFProduces");
				}
				
				if (selectedEdge instanceof AGORelationshipGroupEdge &&
					(AGORelationshipGroupEdge.acceptConnection(this.getModel(), selected))) {
					v.add("AGORelationshipGroup");
				}
				
				if (selectedEdge instanceof AGORelationshipMemberEdge &&
					(AGORelationshipMemberEdge.acceptConnection(this.getModel(), selected))) {
					v.add("AGORelationshipMember");
				}
				
				if (selectedEdge instanceof AGORelationshipOrgEdge &&
					(AGORelationshipOrgEdge.acceptConnection(this.getModel(), selected))) {
					v.add("AGORelationshipOrg");
				}
				
				if (selectedEdge instanceof AGOSubordinationRelationshipGroupEdge &&
					(AGOSubordinationRelationshipGroupEdge.acceptConnection(this.getModel(), selected))) {
					v.add("AGOSubordinationRelationshipGroup");
				}
				
				if (selectedEdge instanceof AGOSubordinationRelationshipMemberEdge &&
					(AGOSubordinationRelationshipMemberEdge.acceptConnection(this.getModel(), selected))) {
					v.add("AGOSubordinationRelationshipMember");
				}
				
				if (selectedEdge instanceof AGOSubordinationRelationshipOrgEdge &&
					(AGOSubordinationRelationshipOrgEdge.acceptConnection(this.getModel(), selected))) {
					v.add("AGOSubordinationRelationshipOrg");
				}
				
				if (selectedEdge instanceof AGOCondSubordinationRelationshipGroupEdge &&
					(AGOCondSubordinationRelationshipGroupEdge.acceptConnection(this.getModel(), selected))) {
					v.add("AGOCondSubordinationRelationshipGroup");
				}
				
				if (selectedEdge instanceof AGOCondSubordinationRelationshipMemberEdge &&
					(AGOCondSubordinationRelationshipMemberEdge.acceptConnection(this.getModel(), selected))) {
					v.add("AGOCondSubordinationRelationshipMember");
				}
				
				if (selectedEdge instanceof AGOCondSubordinationRelationshipOrgEdge &&
					(AGOCondSubordinationRelationshipOrgEdge.acceptConnection(this.getModel(), selected))) {
					v.add("AGOCondSubordinationRelationshipOrg");
				}
				
				if (selectedEdge instanceof AGOInconditionalSubordinationRelationshipGroupEdge &&
					(AGOInconditionalSubordinationRelationshipGroupEdge.acceptConnection(this.getModel(), selected))) {
					v.add("AGOInconditionalSubordinationRelationshipGroup");
				}
				
				if (selectedEdge instanceof AGOInconditionalSubordinationRelationshipMemberEdge &&
					(AGOInconditionalSubordinationRelationshipMemberEdge.acceptConnection(this.getModel(), selected))) {
					v.add("AGOInconditionalSubordinationRelationshipMember");
				}
				
				if (selectedEdge instanceof AGOInconditionalSubordinationRelationshipOrgEdge &&
					(AGOInconditionalSubordinationRelationshipOrgEdge.acceptConnection(this.getModel(), selected))) {
					v.add("AGOInconditionalSubordinationRelationshipOrg");
				}
				
				if (selectedEdge instanceof AGOClientServerRelationshipGroupEdge &&
					(AGOClientServerRelationshipGroupEdge.acceptConnection(this.getModel(), selected))) {
					v.add("AGOClientServerRelationshipGroup");
				}
				
				if (selectedEdge instanceof AGOClientServerRelationshipMemberEdge &&
					(AGOClientServerRelationshipMemberEdge.acceptConnection(this.getModel(), selected))) {
					v.add("AGOClientServerRelationshipMember");
				}
				
				if (selectedEdge instanceof AGOClientServerRelationshipOrgEdge &&
					(AGOClientServerRelationshipOrgEdge.acceptConnection(this.getModel(), selected))) {
					v.add("AGOClientServerRelationshipOrg");
				}
				
				if (selectedEdge instanceof WFSpecifiesExecutionEdge &&
					(WFSpecifiesExecutionEdge.acceptConnection(this.getModel(), selected))) {
					v.add("WFSpecifiesExecution");
				}
				
				if (selectedEdge instanceof WFResponsableEdge &&
					(WFResponsableEdge.acceptConnection(this.getModel(), selected))) {
					v.add("WFResponsable");
				}
				
				if (selectedEdge instanceof WFParticipatesEdge &&
					(WFParticipatesEdge.acceptConnection(this.getModel(), selected))) {
					v.add("WFParticipates");
				}
				
				if (selectedEdge instanceof WFPlaysEdge &&
					(WFPlaysEdge.acceptConnection(this.getModel(), selected))) {
					v.add("WFPlays");
				}
				
				if (selectedEdge instanceof WFDecomposesWFEdge &&
					(WFDecomposesWFEdge.acceptConnection(this.getModel(), selected))) {
					v.add("WFDecomposesWF");
				}
				
				if (selectedEdge instanceof UMLAnnotatedElementEdge &&
					(UMLAnnotatedElementEdge.acceptConnection(this.getModel(), selected))) {
					v.add("UMLAnnotatedElement");
				}
				
				if (selectedEdge instanceof WSConnectsEdge &&
					(WSConnectsEdge.acceptConnection(this.getModel(), selected))) {
					v.add("WSConnects");
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
			
			if (relacion.equalsIgnoreCase("OHasGroup")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof OHasGroupEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new OHasGroupEdge(new OHasGroup(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("OHasMember")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof OHasMemberEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new OHasMemberEdge(new OHasMember(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("OHasWF")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof OHasWFEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new OHasWFEdge(new OHasWF(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("ODecomposesGroup")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof ODecomposesGroupEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new ODecomposesGroupEdge(new ODecomposesGroup(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("ODecomposesWF")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof ODecomposesWFEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new ODecomposesWFEdge(new ODecomposesWF(getMJGraph().getNewId()));
				}
			}
			
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
			
			if (relacion.equalsIgnoreCase("WFConnects")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof WFConnectsEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new WFConnectsEdge(new WFConnects(getMJGraph().getNewId()));
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
			
			if (relacion.equalsIgnoreCase("WFContainsTask")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof WFContainsTaskEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new WFContainsTaskEdge(new WFContainsTask(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("WFContains")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof WFContainsEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new WFContainsEdge(new WFContains(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("WFConsumes")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof WFConsumesEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new WFConsumesEdge(new WFConsumes(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("Consumes")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof ConsumesEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new ConsumesEdge(new Consumes(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("WFDecomposes")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof WFDecomposesEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new WFDecomposesEdge(new WFDecomposes(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("WFProduces")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof WFProducesEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new WFProducesEdge(new WFProduces(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("AGORelationshipGroup")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof AGORelationshipGroupEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new AGORelationshipGroupEdge(new AGORelationshipGroup(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("AGORelationshipMember")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof AGORelationshipMemberEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new AGORelationshipMemberEdge(new AGORelationshipMember(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("AGORelationshipOrg")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof AGORelationshipOrgEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new AGORelationshipOrgEdge(new AGORelationshipOrg(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("AGOSubordinationRelationshipGroup")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof AGOSubordinationRelationshipGroupEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new AGOSubordinationRelationshipGroupEdge(new AGOSubordinationRelationshipGroup(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("AGOSubordinationRelationshipMember")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof AGOSubordinationRelationshipMemberEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new AGOSubordinationRelationshipMemberEdge(new AGOSubordinationRelationshipMember(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("AGOSubordinationRelationshipOrg")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof AGOSubordinationRelationshipOrgEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new AGOSubordinationRelationshipOrgEdge(new AGOSubordinationRelationshipOrg(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("AGOCondSubordinationRelationshipGroup")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof AGOCondSubordinationRelationshipGroupEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new AGOCondSubordinationRelationshipGroupEdge(new AGOCondSubordinationRelationshipGroup(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("AGOCondSubordinationRelationshipMember")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof AGOCondSubordinationRelationshipMemberEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new AGOCondSubordinationRelationshipMemberEdge(new AGOCondSubordinationRelationshipMember(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("AGOCondSubordinationRelationshipOrg")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof AGOCondSubordinationRelationshipOrgEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new AGOCondSubordinationRelationshipOrgEdge(new AGOCondSubordinationRelationshipOrg(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("AGOInconditionalSubordinationRelationshipGroup")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof AGOInconditionalSubordinationRelationshipGroupEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new AGOInconditionalSubordinationRelationshipGroupEdge(new AGOInconditionalSubordinationRelationshipGroup(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("AGOInconditionalSubordinationRelationshipMember")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof AGOInconditionalSubordinationRelationshipMemberEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new AGOInconditionalSubordinationRelationshipMemberEdge(new AGOInconditionalSubordinationRelationshipMember(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("AGOInconditionalSubordinationRelationshipOrg")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof AGOInconditionalSubordinationRelationshipOrgEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new AGOInconditionalSubordinationRelationshipOrgEdge(new AGOInconditionalSubordinationRelationshipOrg(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("AGOClientServerRelationshipGroup")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof AGOClientServerRelationshipGroupEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new AGOClientServerRelationshipGroupEdge(new AGOClientServerRelationshipGroup(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("AGOClientServerRelationshipMember")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof AGOClientServerRelationshipMemberEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new AGOClientServerRelationshipMemberEdge(new AGOClientServerRelationshipMember(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("AGOClientServerRelationshipOrg")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof AGOClientServerRelationshipOrgEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new AGOClientServerRelationshipOrgEdge(new AGOClientServerRelationshipOrg(getMJGraph().getNewId()));
				}
			}
			
			if (relacion.equalsIgnoreCase("WFSpecifiesExecution")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof WFSpecifiesExecutionEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new WFSpecifiesExecutionEdge(new WFSpecifiesExecution(getMJGraph().getNewId()));
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
			
			if (relacion.equalsIgnoreCase("WFParticipates")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof WFParticipatesEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new WFParticipatesEdge(new WFParticipates(getMJGraph().getNewId()));
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
			
			if (relacion.equalsIgnoreCase("WFDecomposesWF")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof WFDecomposesWFEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new WFDecomposesWFEdge(new WFDecomposesWF(getMJGraph().getNewId()));
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
			
			if (relacion.equalsIgnoreCase("WSConnects")) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1 && selectedEdge instanceof WSConnectsEdge) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					return new WSConnectsEdge(new WSConnects(getMJGraph().getNewId()));
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
			
			if (entity.equalsIgnoreCase("Organization")) {
				Organization nentity=getOM().createOrganization(getMJGraph().getNewId("Organization"));
				DefaultGraphCell vertex = new
				OrganizationCell(nentity);
				// Default Size for the cell with the new entity
				return vertex;
			}
			else
				
				if (entity.equalsIgnoreCase("OrganizationGroup")) {
					OrganizationGroup nentity=getOM().createOrganizationGroup(getMJGraph().getNewId("OrganizationGroup"));
					DefaultGraphCell vertex = new
					OrganizationGroupCell(nentity);
					// Default Size for the cell with the new entity
					return vertex;
				}
				else
					
					if (entity.equalsIgnoreCase("OrganizationNetwork")) {
						OrganizationNetwork nentity=getOM().createOrganizationNetwork(getMJGraph().getNewId("OrganizationNetwork"));
						DefaultGraphCell vertex = new
						OrganizationNetworkCell(nentity);
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
							
							if (entity.equalsIgnoreCase("Resource")) {
								Resource nentity=getOM().createResource(getMJGraph().getNewId("Resource"));
								DefaultGraphCell vertex = new
								ResourceCell(nentity);
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
											
											if (entity.equalsIgnoreCase("Task")) {
												Task nentity=getOM().createTask(getMJGraph().getNewId("Task"));
												DefaultGraphCell vertex = new
												TaskCell(nentity);
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
													
													if (entity.equalsIgnoreCase("Workflow")) {
														Workflow nentity=getOM().createWorkflow(getMJGraph().getNewId("Workflow"));
														DefaultGraphCell vertex = new
														WorkflowCell(nentity);
														// Default Size for the cell with the new entity
														return vertex;
													}
													else
														
														if (entity.equalsIgnoreCase("Interaction")) {
															Interaction nentity=getOM().createInteraction(getMJGraph().getNewId("Interaction"));
															DefaultGraphCell vertex = new
															InteractionCell(nentity);
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
																
																if (entity.equalsIgnoreCase("Fact")) {
																	Fact nentity=getOM().createFact(getMJGraph().getNewId("Fact"));
																	DefaultGraphCell vertex = new
																	FactCell(nentity);
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
																									
																									if (entity.equalsIgnoreCase("TextNote")) {
																										TextNote nentity=getOM().createTextNote(getMJGraph().getNewId("TextNote"));
																										DefaultGraphCell vertex = new
																										TextNoteCell(nentity);
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
																															
																															if (entity.equalsIgnoreCase("WorkflowBox")) {
																																WorkflowBox nentity=getOM().createWorkflowBox(getMJGraph().getNewId("WorkflowBox"));
																																DefaultGraphCell vertex = new
																																WorkflowBoxCell(nentity);
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
			
			if (entity.getType().equalsIgnoreCase("Organization")) {
				return OrganizationView.getSize((Organization)entity);      
			}
			else
				
				if (entity.getType().equalsIgnoreCase("OrganizationGroup")) {
					return OrganizationGroupView.getSize((OrganizationGroup)entity);      
				}
				else
					
					if (entity.getType().equalsIgnoreCase("OrganizationNetwork")) {
						return OrganizationNetworkView.getSize((OrganizationNetwork)entity);      
					}
					else
						
						if (entity.getType().equalsIgnoreCase("Role")) {
							return RoleView.getSize((Role)entity);      
						}
						else
							
							if (entity.getType().equalsIgnoreCase("Resource")) {
								return ResourceView.getSize((Resource)entity);      
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
											
											if (entity.getType().equalsIgnoreCase("Task")) {
												return TaskView.getSize((Task)entity);      
											}
											else
												
												if (entity.getType().equalsIgnoreCase("Plan")) {
													return PlanView.getSize((Plan)entity);      
												}
												else
													
													if (entity.getType().equalsIgnoreCase("Workflow")) {
														return WorkflowView.getSize((Workflow)entity);      
													}
													else
														
														if (entity.getType().equalsIgnoreCase("Interaction")) {
															return InteractionView.getSize((Interaction)entity);      
														}
														else
															
															if (entity.getType().equalsIgnoreCase("Goal")) {
																return GoalView.getSize((Goal)entity);      
															}
															else
																
																if (entity.getType().equalsIgnoreCase("Fact")) {
																	return FactView.getSize((Fact)entity);      
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
																									
																									if (entity.getType().equalsIgnoreCase("TextNote")) {
																										return TextNoteView.getSize((TextNote)entity);      
																									}
																									else
																										
																										if (entity.getType().equalsIgnoreCase("UMLComment")) {
																											return UMLCommentView.getSize((UMLComment)entity);      
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
																															
																															if (entity.getType().equalsIgnoreCase("WorkflowBox")) {
																																return WorkflowBoxView.getSize((WorkflowBox)entity);      
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
			
			if (entity.getClass().equals(Organization.class)) {
				vertex = new OrganizationCell( (Organization) entity);
				// Default Size for the new Vertex with the new entity within
				size = OrganizationView.getSize((Organization) entity);
			}
			else
				
				if (entity.getClass().equals(OrganizationGroup.class)) {
					vertex = new OrganizationGroupCell( (OrganizationGroup) entity);
					// Default Size for the new Vertex with the new entity within
					size = OrganizationGroupView.getSize((OrganizationGroup) entity);
				}
				else
					
					if (entity.getClass().equals(OrganizationNetwork.class)) {
						vertex = new OrganizationNetworkCell( (OrganizationNetwork) entity);
						// Default Size for the new Vertex with the new entity within
						size = OrganizationNetworkView.getSize((OrganizationNetwork) entity);
					}
					else
						
						if (entity.getClass().equals(Role.class)) {
							vertex = new RoleCell( (Role) entity);
							// Default Size for the new Vertex with the new entity within
							size = RoleView.getSize((Role) entity);
						}
						else
							
							if (entity.getClass().equals(Resource.class)) {
								vertex = new ResourceCell( (Resource) entity);
								// Default Size for the new Vertex with the new entity within
								size = ResourceView.getSize((Resource) entity);
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
											
											if (entity.getClass().equals(Task.class)) {
												vertex = new TaskCell( (Task) entity);
												// Default Size for the new Vertex with the new entity within
												size = TaskView.getSize((Task) entity);
											}
											else
												
												if (entity.getClass().equals(Plan.class)) {
													vertex = new PlanCell( (Plan) entity);
													// Default Size for the new Vertex with the new entity within
													size = PlanView.getSize((Plan) entity);
												}
												else
													
													if (entity.getClass().equals(Workflow.class)) {
														vertex = new WorkflowCell( (Workflow) entity);
														// Default Size for the new Vertex with the new entity within
														size = WorkflowView.getSize((Workflow) entity);
													}
													else
														
														if (entity.getClass().equals(Interaction.class)) {
															vertex = new InteractionCell( (Interaction) entity);
															// Default Size for the new Vertex with the new entity within
															size = InteractionView.getSize((Interaction) entity);
														}
														else
															
															if (entity.getClass().equals(Goal.class)) {
																vertex = new GoalCell( (Goal) entity);
																// Default Size for the new Vertex with the new entity within
																size = GoalView.getSize((Goal) entity);
															}
															else
																
																if (entity.getClass().equals(Fact.class)) {
																	vertex = new FactCell( (Fact) entity);
																	// Default Size for the new Vertex with the new entity within
																	size = FactView.getSize((Fact) entity);
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
																									
																									if (entity.getClass().equals(TextNote.class)) {
																										vertex = new TextNoteCell( (TextNote) entity);
																										// Default Size for the new Vertex with the new entity within
																										size = TextNoteView.getSize((TextNote) entity);
																									}
																									else
																										
																										if (entity.getClass().equals(UMLComment.class)) {
																											vertex = new UMLCommentCell( (UMLComment) entity);
																											// Default Size for the new Vertex with the new entity within
																											size = UMLCommentView.getSize((UMLComment) entity);
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
																															
																															if (entity.getClass().equals(WorkflowBox.class)) {
																																vertex = new WorkflowBoxCell( (WorkflowBox) entity);
																																// Default Size for the new Vertex with the new entity within
																																size = WorkflowBoxView.getSize((WorkflowBox) entity);
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
		
		
		
		OrganizationModelModelJGraph jg=new  OrganizationModelModelJGraph(
																		  (OrganizationModelDataEntity) this.mde,name, ids.om,
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
