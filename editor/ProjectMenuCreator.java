

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

package ingenias.editor;

import ingenias.editor.actions.*;
import ingenias.editor.actions.diagram.*;
import ingenias.editor.entities.*;
import ingenias.editor.events.DiagramChangeHandler;
import ingenias.editor.events.DiagramCreationAction;
import ingenias.editor.*;
import ingenias.editor.models.*;
import ingenias.editor.widget.GraphicsUtils;
import ingenias.editor.editionmode.EmbeddedAndPopupCellEditor;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import org.jgraph.graph.BasicMarqueeHandler;

public class ProjectMenuCreator {
	private IDEState ids=null;	
	private Frame owner=null;
	private GUIResources resources=null; 
	
	public ProjectMenuCreator(IDEState ids, 			
							  Frame owner, GUIResources resources
							  ){
		this.ids=ids;  		
		this.owner=owner;
		this.resources=resources;
	}
	
	public Vector<DiagramCreationAction> getDiagramCreation(){
		
		Vector<DiagramCreationAction> actions=new Vector<DiagramCreationAction>();
		DiagramCreationAction ma=null;
		
		if (ids.getDiagramFilter().isValidDiagram("PhaseDiagram")){
			// Menu to add a Phase Diagram instance
			ma=new DiagramCreationAction(){
				public String getActionName(){
					return "Add PhaseDiagram";
				}
				public ModelJGraph execute(String diagramName,Object[] path, IDEState ids){
					PhaseDiagramModelJGraph mjg =
					new PhaseDiagramModelJGraph(new
												PhaseDiagramDataEntity(diagramName), diagramName, ids.om, new Model(ids),
												new BasicMarqueeHandler(), ids.prefs );
					PhaseDiagramActionsFactory ema=new  PhaseDiagramActionsFactory(resources,ids);
					mjg.setUI(new EmbeddedAndPopupCellEditor(ids,resources));
					MarqueeHandler marquee=new MarqueeHandler(mjg, resources,ids,ema);
					mjg.setMarqueeHandler(marquee);
					ids.gm.addModel(path, diagramName, mjg);
					ids.addNewDiagram(mjg);
					return mjg;
				}
				public String getIconName() {
					// TODO Auto-generated method stub
					return "images/mPhaseDiag.png";
				}
			};
			actions.add(ma);
		}
		
		if (ids.getDiagramFilter().isValidDiagram("RoleDiagram")){
			// Menu to add a Role Diagram instance
			ma=new DiagramCreationAction(){
				public String getActionName(){
					return "Add ActivityWPDiagram";
				}
				public ModelJGraph execute(String diagramName,Object[] path, IDEState ids){
					RoleDiagramModelJGraph mjg =
					new RoleDiagramModelJGraph(new
											   RoleDiagramDataEntity(diagramName), diagramName, ids.om, new Model(ids),
											   new BasicMarqueeHandler(), ids.prefs );
					RoleDiagramActionsFactory ema=new  RoleDiagramActionsFactory(resources,ids);
					mjg.setUI(new EmbeddedAndPopupCellEditor(ids,resources));
					MarqueeHandler marquee=new MarqueeHandler(mjg, resources,ids,ema);
					mjg.setMarqueeHandler(marquee);
					ids.gm.addModel(path, diagramName, mjg);
					ids.addNewDiagram(mjg);
					return mjg;
				}
				public String getIconName() {
					// TODO Auto-generated method stub
					return "images/mactStrDiag.png";
				}
			};
			actions.add(ma);
		}
		
		if (ids.getDiagramFilter().isValidDiagram("OrganizationModel")){
			// Menu to add a OrganizationModel model instance
			ma=new DiagramCreationAction(){
				public String getActionName(){
					return "Add OrganizationModel";
				}
				public ModelJGraph execute(String diagramName,Object[] path, IDEState ids){
					OrganizationModelModelJGraph mjg =
					new OrganizationModelModelJGraph(new
													 OrganizationModelDataEntity(diagramName), diagramName, ids.om, new Model(ids),
													 new BasicMarqueeHandler(), ids.prefs );
					OrganizationModelActionsFactory ema=new  OrganizationModelActionsFactory(resources,ids);
					mjg.setUI(new EmbeddedAndPopupCellEditor(ids,resources));
					MarqueeHandler marquee=new MarqueeHandler(mjg, resources,ids,ema);
					mjg.setMarqueeHandler(marquee);
					ids.gm.addModel(path, diagramName, mjg);
					ids.addNewDiagram(mjg);
					return mjg;
				}
				public String getIconName() {
					// TODO Auto-generated method stub
					return "images/morgdiag.gif";
				}
			};
			actions.add(ma);
		}
		
		if (ids.getDiagramFilter().isValidDiagram("TasksAndGoalsModel")){
			// Menu to add a TasksAndGoalsModel model instance
			ma=new DiagramCreationAction(){
				public String getActionName(){
					return "Add TasksAndGoalsModel";
				}
				public ModelJGraph execute(String diagramName,Object[] path, IDEState ids){
					TasksAndGoalsModelModelJGraph mjg =
					new TasksAndGoalsModelModelJGraph(new
													  TasksAndGoalsModelDataEntity(diagramName), diagramName, ids.om, new Model(ids),
													  new BasicMarqueeHandler(), ids.prefs );
					TasksAndGoalsModelActionsFactory ema=new  TasksAndGoalsModelActionsFactory(resources,ids);
					mjg.setUI(new EmbeddedAndPopupCellEditor(ids,resources));
					MarqueeHandler marquee=new MarqueeHandler(mjg, resources,ids,ema);
					mjg.setMarqueeHandler(marquee);
					ids.gm.addModel(path, diagramName, mjg);
					ids.addNewDiagram(mjg);
					return mjg;
				}
				public String getIconName() {
					// TODO Auto-generated method stub
					return "images/mtaskgoal.gif";
				}
			};
			actions.add(ma);
		}
		
		if (ids.getDiagramFilter().isValidDiagram("InteractionModel")){
			// Menu to add a InteractionModel model instance
			ma=new DiagramCreationAction(){
				public String getActionName(){
					return "Add InteractionModel";
				}
				public ModelJGraph execute(String diagramName,Object[] path, IDEState ids){
					InteractionModelModelJGraph mjg =
					new InteractionModelModelJGraph(new
													InteractionModelDataEntity(diagramName), diagramName, ids.om, new Model(ids),
													new BasicMarqueeHandler(), ids.prefs );
					InteractionModelActionsFactory ema=new  InteractionModelActionsFactory(resources,ids);
					mjg.setUI(new EmbeddedAndPopupCellEditor(ids,resources));
					MarqueeHandler marquee=new MarqueeHandler(mjg, resources,ids,ema);
					mjg.setMarqueeHandler(marquee);
					ids.gm.addModel(path, diagramName, mjg);
					ids.addNewDiagram(mjg);
					return mjg;
				}
				public String getIconName() {
					// TODO Auto-generated method stub
					return "images/minterdiag.gif";
				}
			};
			actions.add(ma);
		}
		
		if (ids.getDiagramFilter().isValidDiagram("AgentModel")){
			// Menu to add a AgentModel model instance
			ma=new DiagramCreationAction(){
				public String getActionName(){
					return "Add AgentModel";
				}
				public ModelJGraph execute(String diagramName,Object[] path, IDEState ids){
					AgentModelModelJGraph mjg =
					new AgentModelModelJGraph(new
											  AgentModelDataEntity(diagramName), diagramName, ids.om, new Model(ids),
											  new BasicMarqueeHandler(), ids.prefs );
					AgentModelActionsFactory ema=new  AgentModelActionsFactory(resources,ids);
					mjg.setUI(new EmbeddedAndPopupCellEditor(ids,resources));
					MarqueeHandler marquee=new MarqueeHandler(mjg, resources,ids,ema);
					mjg.setMarqueeHandler(marquee);
					ids.gm.addModel(path, diagramName, mjg);
					ids.addNewDiagram(mjg);
					return mjg;
				}
				public String getIconName() {
					// TODO Auto-generated method stub
					return "images/magdiag.gif";
				}
			};
			actions.add(ma);
		}
		
		if (ids.getDiagramFilter().isValidDiagram("EnvironmentModel")){
			// Menu to add a EnvironmentModel model instance
			ma=new DiagramCreationAction(){
				public String getActionName(){
					return "Add EnvironmentModel";
				}
				public ModelJGraph execute(String diagramName,Object[] path, IDEState ids){
					EnvironmentModelModelJGraph mjg =
					new EnvironmentModelModelJGraph(new
													EnvironmentModelDataEntity(diagramName), diagramName, ids.om, new Model(ids),
													new BasicMarqueeHandler(), ids.prefs );
					EnvironmentModelActionsFactory ema=new  EnvironmentModelActionsFactory(resources,ids);
					mjg.setUI(new EmbeddedAndPopupCellEditor(ids,resources));
					MarqueeHandler marquee=new MarqueeHandler(mjg, resources,ids,ema);
					mjg.setMarqueeHandler(marquee);
					ids.gm.addModel(path, diagramName, mjg);
					ids.addNewDiagram(mjg);
					return mjg;
				}
				public String getIconName() {
					// TODO Auto-generated method stub
					return "images/menvdiag.gif";
				}
			};
			actions.add(ma);
		}
		
		if (ids.getDiagramFilter().isValidDiagram("ActivityDiagram")){
			// Menu to add a ActivityDiagram model instance
			ma=new DiagramCreationAction(){
				public String getActionName(){
					return "Add TaskWorkflowDiagram";
				}
				public ModelJGraph execute(String diagramName,Object[] path, IDEState ids){
					ActivityDiagramModelJGraph mjg =
					new ActivityDiagramModelJGraph(new
												   ActivityDiagramDataEntity(diagramName), diagramName, ids.om, new Model(ids),
												   new BasicMarqueeHandler(), ids.prefs );
					ActivityDiagramActionsFactory ema=new  ActivityDiagramActionsFactory(resources,ids);
					mjg.setUI(new EmbeddedAndPopupCellEditor(ids,resources));
					MarqueeHandler marquee=new MarqueeHandler(mjg, resources,ids,ema);
					mjg.setMarqueeHandler(marquee);
					ids.gm.addModel(path, diagramName, mjg);
					ids.addNewDiagram(mjg);
					return mjg;
				}
				public String getIconName() {
					// TODO Auto-generated method stub
					return "images/musediag.gif";
				}
			};
			actions.add(ma);
		}
		
		if (ids.getDiagramFilter().isValidDiagram("UseCaseDiagram")){
			// Menu to add a UseCaseDiagram model instance
			ma=new DiagramCreationAction(){
				public String getActionName(){
					return "Add UseCaseDiagram";
				}
				public ModelJGraph execute(String diagramName,Object[] path, IDEState ids){
					UseCaseDiagramModelJGraph mjg =
					new UseCaseDiagramModelJGraph(new
												  UseCaseDiagramDataEntity(diagramName), diagramName, ids.om, new Model(ids),
												  new BasicMarqueeHandler(), ids.prefs );
					UseCaseDiagramActionsFactory ema=new  UseCaseDiagramActionsFactory(resources,ids);
					mjg.setUI(new EmbeddedAndPopupCellEditor(ids,resources));
					MarqueeHandler marquee=new MarqueeHandler(mjg, resources,ids,ema);
					mjg.setMarqueeHandler(marquee);
					ids.gm.addModel(path, diagramName, mjg);
					ids.addNewDiagram(mjg);
					return mjg;
				}
				public String getIconName() {
					// TODO Auto-generated method stub
					return "images/musediag.gif";
				}
			};
			actions.add(ma);
		}
		
		if (ids.getDiagramFilter().isValidDiagram("ComponentDiagram")){
			// Menu to add a ComponentDiagram model instance
			ma=new DiagramCreationAction(){
				public String getActionName(){
					return "Add ComponentDiagram";
				}
				public ModelJGraph execute(String diagramName,Object[] path, IDEState ids){
					ComponentDiagramModelJGraph mjg =
					new ComponentDiagramModelJGraph(new
													ComponentDiagramDataEntity(diagramName), diagramName, ids.om, new Model(ids),
													new BasicMarqueeHandler(), ids.prefs );
					ComponentDiagramActionsFactory ema=new  ComponentDiagramActionsFactory(resources,ids);
					mjg.setUI(new EmbeddedAndPopupCellEditor(ids,resources));
					MarqueeHandler marquee=new MarqueeHandler(mjg, resources,ids,ema);
					mjg.setMarqueeHandler(marquee);
					ids.gm.addModel(path, diagramName, mjg);
					ids.addNewDiagram(mjg);
					return mjg;
				}
				public String getIconName() {
					// TODO Auto-generated method stub
					return "images/musediag.gif";
				}
			};
			actions.add(ma);
		}
		
		if (ids.getDiagramFilter().isValidDiagram("WorkProductDiagram")){
			// Menu to add a WorkProduct Diagram instance
			ma=new DiagramCreationAction(){
				public String getActionName(){
					return "Add WorkProductDiagram";
				}
				public ModelJGraph execute(String diagramName,Object[] path, IDEState ids){
					WorkProductDiagramModelJGraph mjg =
					new WorkProductDiagramModelJGraph(new
													  WorkProductDiagramDataEntity(diagramName), diagramName, ids.om, new Model(ids),
													  new BasicMarqueeHandler(), ids.prefs );
					WorkProductDiagramActionsFactory ema=new  WorkProductDiagramActionsFactory(resources,ids);
					mjg.setUI(new EmbeddedAndPopupCellEditor(ids,resources));
					MarqueeHandler marquee=new MarqueeHandler(mjg, resources,ids,ema);
					mjg.setMarqueeHandler(marquee);
					ids.gm.addModel(path, diagramName, mjg);
					ids.addNewDiagram(mjg);
					return mjg;
				}
				public String getIconName() {
					// TODO Auto-generated method stub
					return "images/mgroup.gif";
				}
			};
			actions.add(ma);
		}
		
		///*
		if (ids.getDiagramFilter().isValidDiagram("AUMLInteractionDiagram")){
			// Menu to add a AUMLInteractionDiagram model instance
			ma=new DiagramCreationAction(){
				public String getActionName(){
					return "Add AUMLInteractionDiagram";
				}
				public ModelJGraph execute(String diagramName,Object[] path, IDEState ids){
					AUMLInteractionDiagramModelJGraph mjg =
					new AUMLInteractionDiagramModelJGraph(new
														  AUMLInteractionDiagramDataEntity(diagramName), diagramName, ids.om, new Model(ids),
														  new BasicMarqueeHandler(), ids.prefs );
					AUMLInteractionDiagramActionsFactory ema=new  AUMLInteractionDiagramActionsFactory(resources,ids);
					mjg.setUI(new EmbeddedAndPopupCellEditor(ids,resources));
		   	        MarqueeHandler marquee=new MarqueeHandler(mjg, resources,ids,ema);
					mjg.setMarqueeHandler(marquee);
					ids.gm.addModel(path, diagramName, mjg);
					ids.addNewDiagram(mjg);
					return mjg;
				}
				public String getIconName() {
					// TODO Auto-generated method stub
					return "images/musediag.gif";
				}
			};
			actions.add(ma);
		}
		
		//*/
		
		if (ids.getDiagramFilter().isValidDiagram("DeployDiagram")){
			// Menu to add a DeployDiagram model instance
			ma=new DiagramCreationAction(){
				public String getActionName(){
					return "Add DeployDiagram";
				}
				public ModelJGraph execute(String diagramName,Object[] path, IDEState ids){
					DeployDiagramModelJGraph mjg =
					new DeployDiagramModelJGraph(new
												 DeployDiagramDataEntity(diagramName), diagramName, ids.om, new Model(ids),
												 new BasicMarqueeHandler(), ids.prefs );
					DeployDiagramActionsFactory ema=new  DeployDiagramActionsFactory(resources,ids);
					mjg.setUI(new EmbeddedAndPopupCellEditor(ids,resources));
		   	        MarqueeHandler marquee=new MarqueeHandler(mjg, resources,ids,ema);
					mjg.setMarqueeHandler(marquee);
					ids.gm.addModel(path, diagramName, mjg);
					ids.addNewDiagram(mjg);
					return mjg;
				}
				public String getIconName() {
					// TODO Auto-generated method stub
					return "images/musediag.gif";
				}
			};
			actions.add(ma);
		}
		
		return actions;
	}
	
	public JPopupMenu menuProjectTree(MouseEvent me1) {
		final CommonMenuEntriesActionFactory cme=new CommonMenuEntriesActionFactory(resources,ids);
		JPopupMenu menu = new JPopupMenu();
		final MouseEvent me = me1;
		
		TreePath tp = ids.gm.arbolProyecto.getSelectionPath();
		if (tp != null) {   
			DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) 
			tp.getLastPathComponent();
			
			if (tp != null && dmtn.getUserObject()instanceof String) {
				// Menu to add a EnvironmentModel model instance
				
                if (ids.getDiagramFilter().isValidDiagram("PhaseDiagram")){
                    menu.add(
                             new AbstractAction("Add PhaseDiagram") {
                        
                        public void actionPerformed(ActionEvent e) {
                            TreePath tp = ids.gm.arbolProyecto.getSelectionPath();
                            DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) tp.
                            getLastPathComponent();
                            if (tp != null && dmtn.getUserObject()instanceof String) {
                                String diagramName = JOptionPane.showInputDialog(owner,
                                                                                 "Type graph name",
                                                                                 "New graph",
                                                                                 JOptionPane.QUESTION_MESSAGE);
                                if (diagramName != null && ids.gm.existsModel(diagramName)) {
                                    
                                    JOptionPane.showMessageDialog(owner,
                                                                  "There exists a model with the same name. Please, select another",
                                                                  "Warning",
                                                                  JOptionPane.WARNING_MESSAGE);
                                }
                                else
                                    if (diagramName != null) {
                                        PhaseDiagramModelJGraph mjg =
                                        new PhaseDiagramModelJGraph(new
																	PhaseDiagramDataEntity(
																						   diagramName), diagramName, ids.om, new Model(ids),
																	new BasicMarqueeHandler(), ids.prefs );
                                        PhaseDiagramActionsFactory ema=new  PhaseDiagramActionsFactory(resources,ids);
                                        mjg.setUI(new EmbeddedAndPopupCellEditor(ids,resources));
                                        MarqueeHandler marquee=new MarqueeHandler(mjg, resources,ids,ema);
                                        mjg.setMarqueeHandler(marquee);
                                        ids.gm.addModel(tp.getPath(), diagramName, mjg);
                                        ids.addNewDiagram(mjg);
										
                                    }
                            }
                            
                        }
                    });
                }
				
                if (ids.getDiagramFilter().isValidDiagram("RoleDiagram")){
                    menu.add(
                             new AbstractAction("Add ActivityWPDiagram") {
                        
                        public void actionPerformed(ActionEvent e) {
                            TreePath tp = ids.gm.arbolProyecto.getSelectionPath();
                            DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) tp.
                            getLastPathComponent();
                            if (tp != null && dmtn.getUserObject()instanceof String) {
                                String diagramName = JOptionPane.showInputDialog(owner,
                                                                                 "Type graph name",
                                                                                 "New graph",
                                                                                 JOptionPane.QUESTION_MESSAGE);
                                if (diagramName != null && ids.gm.existsModel(diagramName)) {
                                    
                                    JOptionPane.showMessageDialog(owner,
                                                                  "There exists a model with the same name. Please, select another",
                                                                  "Warning",
                                                                  JOptionPane.WARNING_MESSAGE);
                                }
                                else
                                    if (diagramName != null) {
                                        RoleDiagramModelJGraph mjg =
                                        new RoleDiagramModelJGraph(new
																   RoleDiagramDataEntity(
																						 diagramName), diagramName, ids.om, new Model(ids),
																   new BasicMarqueeHandler(), ids.prefs );
                                        RoleDiagramActionsFactory ema=new  RoleDiagramActionsFactory(resources,ids);
                                        mjg.setUI(new EmbeddedAndPopupCellEditor(ids,resources));
                                        MarqueeHandler marquee=new MarqueeHandler(mjg, resources,ids,ema);
                                        mjg.setMarqueeHandler(marquee);
                                        ids.gm.addModel(tp.getPath(), diagramName, mjg);
                                        ids.addNewDiagram(mjg);
										
                                    }
                            }
                            
                        }
                    });
                }
				
				if (ids.getDiagramFilter().isValidDiagram("OrganizationModel")){
					menu.add(
							 new AbstractAction("Add OrganizationModel") {
						
						public void actionPerformed(ActionEvent e) {
							TreePath tp = ids.gm.arbolProyecto.getSelectionPath();
							DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) tp.
							getLastPathComponent();
							if (tp != null && dmtn.getUserObject()instanceof String) {
								String diagramName = JOptionPane.showInputDialog(owner,
																				 "Type graph name",
																				 "New graph",
																				 JOptionPane.QUESTION_MESSAGE);
								if (diagramName != null && ids.gm.existsModel(diagramName)) {
									
									JOptionPane.showMessageDialog(owner,
																  "There exists a model with the same name. Please, select another",
																  "Warning",
																  JOptionPane.WARNING_MESSAGE);
								}
								else
									if (diagramName != null) {
										OrganizationModelModelJGraph mjg =
										new OrganizationModelModelJGraph(new
																		 OrganizationModelDataEntity(
																									 diagramName), diagramName, ids.om, new Model(ids),
																		 new BasicMarqueeHandler(), ids.prefs );
										OrganizationModelActionsFactory ema=new  OrganizationModelActionsFactory(resources,ids);
										mjg.setUI(new EmbeddedAndPopupCellEditor(ids,resources));
										MarqueeHandler marquee=new MarqueeHandler(mjg, resources,ids,ema);
										mjg.setMarqueeHandler(marquee);
										ids.gm.addModel(tp.getPath(), diagramName, mjg);
										ids.addNewDiagram(mjg);
										
									}
							}
							
						}
					});
				}
				
                if (ids.getDiagramFilter().isValidDiagram("AgentModel")){
                    menu.add(
                             new AbstractAction("Add AgentModel") {
                        
                        public void actionPerformed(ActionEvent e) {
                            TreePath tp = ids.gm.arbolProyecto.getSelectionPath();
                            DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) tp.
                            getLastPathComponent();
                            if (tp != null && dmtn.getUserObject()instanceof String) {
                                String diagramName = JOptionPane.showInputDialog(owner,
                                                                                 "Type graph name",
                                                                                 "New graph",
                                                                                 JOptionPane.QUESTION_MESSAGE);
                                if (diagramName != null && ids.gm.existsModel(diagramName)) {
                                    
                                    JOptionPane.showMessageDialog(owner,
                                                                  "There exists a model with the same name. Please, select another",
                                                                  "Warning",
                                                                  JOptionPane.WARNING_MESSAGE);
                                }
                                else
                                    if (diagramName != null) {
                                        AgentModelModelJGraph mjg =
                                        new AgentModelModelJGraph(new
                                                                  AgentModelDataEntity(
                                                                                       diagramName), diagramName, ids.om, new Model(ids),
                                                                  new BasicMarqueeHandler(), ids.prefs );
                                        AgentModelActionsFactory ema=new  AgentModelActionsFactory(resources,ids);
                                        mjg.setUI(new EmbeddedAndPopupCellEditor(ids,resources));
                                        MarqueeHandler marquee=new MarqueeHandler(mjg, resources,ids,ema);
                                        mjg.setMarqueeHandler(marquee);
                                        ids.gm.addModel(tp.getPath(), diagramName, mjg);
                                        ids.addNewDiagram(mjg);
										
                                    }
                            }
                            
                        }
                    });
                }
                
				if (ids.getDiagramFilter().isValidDiagram("TasksAndGoalsModel")){
					menu.add(
							 new AbstractAction("Add TasksAndGoalsModel") {
						
						public void actionPerformed(ActionEvent e) {
							TreePath tp = ids.gm.arbolProyecto.getSelectionPath();
							DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) tp.
							getLastPathComponent();
							if (tp != null && dmtn.getUserObject()instanceof String) {
								String diagramName = JOptionPane.showInputDialog(owner,
																				 "Type graph name",
																				 "New graph",
																				 JOptionPane.QUESTION_MESSAGE);
								if (diagramName != null && ids.gm.existsModel(diagramName)) {
									
									JOptionPane.showMessageDialog(owner,
																  "There exists a model with the same name. Please, select another",
																  "Warning",
																  JOptionPane.WARNING_MESSAGE);
								}
								else
									if (diagramName != null) {
										TasksAndGoalsModelModelJGraph mjg =
										new TasksAndGoalsModelModelJGraph(new
																		  TasksAndGoalsModelDataEntity(
																									   diagramName), diagramName, ids.om, new Model(ids),
																		  new BasicMarqueeHandler(), ids.prefs );
										TasksAndGoalsModelActionsFactory ema=new  TasksAndGoalsModelActionsFactory(resources,ids);
										mjg.setUI(new EmbeddedAndPopupCellEditor(ids,resources));
										MarqueeHandler marquee=new MarqueeHandler(mjg, resources,ids,ema);
										mjg.setMarqueeHandler(marquee);
										ids.gm.addModel(tp.getPath(), diagramName, mjg);
										ids.addNewDiagram(mjg);
										
									}
							}
							
						}
					});
				}
				
				if (ids.getDiagramFilter().isValidDiagram("InteractionModel")){
					menu.add(
							 new AbstractAction("Add InteractionModel") {
						
						public void actionPerformed(ActionEvent e) {
							TreePath tp = ids.gm.arbolProyecto.getSelectionPath();
							DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) tp.
							getLastPathComponent();
							if (tp != null && dmtn.getUserObject()instanceof String) {
								String diagramName = JOptionPane.showInputDialog(owner,
																				 "Type graph name",
																				 "New graph",
																				 JOptionPane.QUESTION_MESSAGE);
								if (diagramName != null && ids.gm.existsModel(diagramName)) {
									
									JOptionPane.showMessageDialog(owner,
																  "There exists a model with the same name. Please, select another",
																  "Warning",
																  JOptionPane.WARNING_MESSAGE);
								}
								else
									if (diagramName != null) {
										InteractionModelModelJGraph mjg =
										new InteractionModelModelJGraph(new
																		InteractionModelDataEntity(
																								   diagramName), diagramName, ids.om, new Model(ids),
																		new BasicMarqueeHandler(), ids.prefs );
										InteractionModelActionsFactory ema=new  InteractionModelActionsFactory(resources,ids);
										mjg.setUI(new EmbeddedAndPopupCellEditor(ids,resources));
										MarqueeHandler marquee=new MarqueeHandler(mjg, resources,ids,ema);
										mjg.setMarqueeHandler(marquee);
										ids.gm.addModel(tp.getPath(), diagramName, mjg);
										ids.addNewDiagram(mjg);
										
									}
							}
							
						}
					});
				}
				
                if (ids.getDiagramFilter().isValidDiagram("EnvironmentModel")){
                    menu.add(
                             new AbstractAction("Add EnvironmentModel") {
                        
                        public void actionPerformed(ActionEvent e) {
                            TreePath tp = ids.gm.arbolProyecto.getSelectionPath();
                            DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) tp.
                            getLastPathComponent();
                            if (tp != null && dmtn.getUserObject()instanceof String) {
                                String diagramName = JOptionPane.showInputDialog(owner,
                                                                                 "Type graph name",
                                                                                 "New graph",
                                                                                 JOptionPane.QUESTION_MESSAGE);
                                if (diagramName != null && ids.gm.existsModel(diagramName)) {
                                    
                                    JOptionPane.showMessageDialog(owner,
                                                                  "There exists a model with the same name. Please, select another",
                                                                  "Warning",
                                                                  JOptionPane.WARNING_MESSAGE);
                                }
                                else
                                    if (diagramName != null) {
                                        EnvironmentModelModelJGraph mjg =
                                        new EnvironmentModelModelJGraph(new
                                                                        EnvironmentModelDataEntity(
                                                                                                   diagramName), diagramName, ids.om, new Model(ids),
                                                                        new BasicMarqueeHandler(), ids.prefs );
                                        EnvironmentModelActionsFactory ema=new  EnvironmentModelActionsFactory(resources,ids);
                                        mjg.setUI(new EmbeddedAndPopupCellEditor(ids,resources));
                                        MarqueeHandler marquee=new MarqueeHandler(mjg, resources,ids,ema);
                                        mjg.setMarqueeHandler(marquee);
                                        ids.gm.addModel(tp.getPath(), diagramName, mjg);
                                        ids.addNewDiagram(mjg);
										
                                    }
                            }
                            
                        }
                    });
                }
                
                if (ids.getDiagramFilter().isValidDiagram("UseCaseDiagram")){
                    menu.add(
                             new AbstractAction("Add UseCaseDiagram") {
                        
                        public void actionPerformed(ActionEvent e) {
                            TreePath tp = ids.gm.arbolProyecto.getSelectionPath();
                            DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) tp.
                            getLastPathComponent();
                            if (tp != null && dmtn.getUserObject()instanceof String) {
                                String diagramName = JOptionPane.showInputDialog(owner,
                                                                                 "Type graph name",
                                                                                 "New graph",
                                                                                 JOptionPane.QUESTION_MESSAGE);
                                if (diagramName != null && ids.gm.existsModel(diagramName)) {
                                    
                                    JOptionPane.showMessageDialog(owner,
                                                                  "There exists a model with the same name. Please, select another",
                                                                  "Warning",
                                                                  JOptionPane.WARNING_MESSAGE);
                                }
                                else
                                    if (diagramName != null) {
                                        UseCaseDiagramModelJGraph mjg =
                                        new UseCaseDiagramModelJGraph(new
                                                                      UseCaseDiagramDataEntity(
                                                                                               diagramName), diagramName, ids.om, new Model(ids),
                                                                      new BasicMarqueeHandler(), ids.prefs );
                                        UseCaseDiagramActionsFactory ema=new  UseCaseDiagramActionsFactory(resources,ids);
                                        mjg.setUI(new EmbeddedAndPopupCellEditor(ids,resources));
                                        MarqueeHandler marquee=new MarqueeHandler(mjg, resources,ids,ema);
                                        mjg.setMarqueeHandler(marquee);
                                        ids.gm.addModel(tp.getPath(), diagramName, mjg);
                                        ids.addNewDiagram(mjg);
										
                                    }
                            }
                            
                        }
                    });
                }
                
                if (ids.getDiagramFilter().isValidDiagram("ComponentDiagram")){
                    menu.add(
                             new AbstractAction("Add ComponentDiagram") {
                        
                        public void actionPerformed(ActionEvent e) {
                            TreePath tp = ids.gm.arbolProyecto.getSelectionPath();
                            DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) tp.
                            getLastPathComponent();
                            if (tp != null && dmtn.getUserObject()instanceof String) {
                                String diagramName = JOptionPane.showInputDialog(owner,
                                                                                 "Type graph name",
                                                                                 "New graph",
                                                                                 JOptionPane.QUESTION_MESSAGE);
                                if (diagramName != null && ids.gm.existsModel(diagramName)) {
                                    
                                    JOptionPane.showMessageDialog(owner,
                                                                  "There exists a model with the same name. Please, select another",
                                                                  "Warning",
                                                                  JOptionPane.WARNING_MESSAGE);
                                }
                                else
                                    if (diagramName != null) {
                                        ComponentDiagramModelJGraph mjg =
                                        new ComponentDiagramModelJGraph(new
                                                                        ComponentDiagramDataEntity(
                                                                                                   diagramName), diagramName, ids.om, new Model(ids),
                                                                        new BasicMarqueeHandler(), ids.prefs );
                                        ComponentDiagramActionsFactory ema=new  ComponentDiagramActionsFactory(resources,ids);
                                        mjg.setUI(new EmbeddedAndPopupCellEditor(ids,resources));
                                        MarqueeHandler marquee=new MarqueeHandler(mjg, resources,ids,ema);
                                        mjg.setMarqueeHandler(marquee);
                                        ids.gm.addModel(tp.getPath(), diagramName, mjg);
                                        ids.addNewDiagram(mjg);
										
                                    }
                            }
                            
                        }
                    });
                }
                
                if (ids.getDiagramFilter().isValidDiagram("DeployDiagram")){
                    menu.add(
                             new AbstractAction("Add DeployDiagram") {
                        
                        public void actionPerformed(ActionEvent e) {
                            TreePath tp = ids.gm.arbolProyecto.getSelectionPath();
                            DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) tp.
                            getLastPathComponent();
                            if (tp != null && dmtn.getUserObject()instanceof String) {
                                String diagramName = JOptionPane.showInputDialog(owner,
                                                                                 "Type graph name",
                                                                                 "New graph",
                                                                                 JOptionPane.QUESTION_MESSAGE);
                                if (diagramName != null && ids.gm.existsModel(diagramName)) {
                                    
                                    JOptionPane.showMessageDialog(owner,
                                                                  "There exists a model with the same name. Please, select another",
                                                                  "Warning",
                                                                  JOptionPane.WARNING_MESSAGE);
                                }
                                else
                                    if (diagramName != null) {
                                        DeployDiagramModelJGraph mjg =
                                        new DeployDiagramModelJGraph(new
                                                                     DeployDiagramDataEntity(
                                                                                             diagramName), diagramName, ids.om, new Model(ids),
                                                                     new BasicMarqueeHandler(), ids.prefs );
                                        DeployDiagramActionsFactory ema=new  DeployDiagramActionsFactory(resources,ids);
                                        mjg.setUI(new EmbeddedAndPopupCellEditor(ids,resources));
                                        MarqueeHandler marquee=new MarqueeHandler(mjg, resources,ids,ema);
                                        mjg.setMarqueeHandler(marquee);
                                        ids.gm.addModel(tp.getPath(), diagramName, mjg);
                                        ids.addNewDiagram(mjg);
										
                                    }
                            }
                            
                        }
                    });
                }
                
				if (ids.getDiagramFilter().isValidDiagram("ActivityDiagram")){
					menu.add(
							 new AbstractAction("Add TaskWorkflowDiagram") {
						
						public void actionPerformed(ActionEvent e) {
							TreePath tp = ids.gm.arbolProyecto.getSelectionPath();
							DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) tp.
							getLastPathComponent();
							if (tp != null && dmtn.getUserObject()instanceof String) {
								String diagramName = JOptionPane.showInputDialog(owner,
																				 "Type graph name",
																				 "New graph",
																				 JOptionPane.QUESTION_MESSAGE);
								if (diagramName != null && ids.gm.existsModel(diagramName)) {
									
									JOptionPane.showMessageDialog(owner,
																  "There exists a model with the same name. Please, select another",
																  "Warning",
																  JOptionPane.WARNING_MESSAGE);
								}
								else
									if (diagramName != null) {
										ActivityDiagramModelJGraph mjg =
										new ActivityDiagramModelJGraph(new
																	   ActivityDiagramDataEntity(
																								 diagramName), diagramName, ids.om, new Model(ids),
																	   new BasicMarqueeHandler(), ids.prefs );
										ActivityDiagramActionsFactory ema=new  ActivityDiagramActionsFactory(resources,ids);
										mjg.setUI(new EmbeddedAndPopupCellEditor(ids,resources));
										MarqueeHandler marquee=new MarqueeHandler(mjg, resources,ids,ema);
										mjg.setMarqueeHandler(marquee);
										ids.gm.addModel(tp.getPath(), diagramName, mjg);
										ids.addNewDiagram(mjg);
										
									}
							}
							
						}
					});
				}
				
                if (ids.getDiagramFilter().isValidDiagram("WorkProductDiagram")){
                    menu.add(
                             new AbstractAction("Add WorkProductDiagram") {
                        
                        public void actionPerformed(ActionEvent e) {
                            TreePath tp = ids.gm.arbolProyecto.getSelectionPath();
                            DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) tp.
                            getLastPathComponent();
                            if (tp != null && dmtn.getUserObject()instanceof String) {
                                String diagramName = JOptionPane.showInputDialog(owner,
                                                                                 "Type graph name",
                                                                                 "New graph",
                                                                                 JOptionPane.QUESTION_MESSAGE);
                                if (diagramName != null && ids.gm.existsModel(diagramName)) {
                                    
                                    JOptionPane.showMessageDialog(owner,
                                                                  "There exists a model with the same name. Please, select another",
                                                                  "Warning",
                                                                  JOptionPane.WARNING_MESSAGE);
                                }
                                else
                                    if (diagramName != null) {
                                        WorkProductDiagramModelJGraph mjg =
                                        new WorkProductDiagramModelJGraph(new
																		  WorkProductDiagramDataEntity(
																									   diagramName), diagramName, ids.om, new Model(ids),
																		  new BasicMarqueeHandler(), ids.prefs );
                                        WorkProductDiagramActionsFactory ema=new  WorkProductDiagramActionsFactory(resources,ids);
                                        mjg.setUI(new EmbeddedAndPopupCellEditor(ids,resources));
                                        MarqueeHandler marquee=new MarqueeHandler(mjg, resources,ids,ema);
                                        mjg.setMarqueeHandler(marquee);
                                        ids.gm.addModel(tp.getPath(), diagramName, mjg);
                                        ids.addNewDiagram(mjg);
										
                                    }
                            }
                            
                        }
                    });
                }
				
                ///*
                
				if (ids.getDiagramFilter().isValidDiagram("AUMLInteractionDiagram")){
					menu.add(
							 new AbstractAction("Add AUMLInteractionDiagram") {
						
						public void actionPerformed(ActionEvent e) {
							TreePath tp = ids.gm.arbolProyecto.getSelectionPath();
							DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) tp.
							getLastPathComponent();
							if (tp != null && dmtn.getUserObject()instanceof String) {
								String diagramName = JOptionPane.showInputDialog(owner,
																				 "Type graph name",
																				 "New graph",
																				 JOptionPane.QUESTION_MESSAGE);
								if (diagramName != null && ids.gm.existsModel(diagramName)) {
									
									JOptionPane.showMessageDialog(owner,
																  "There exists a model with the same name. Please, select another",
																  "Warning",
																  JOptionPane.WARNING_MESSAGE);
								}
								else
									if (diagramName != null) {
										AUMLInteractionDiagramModelJGraph mjg =
										new AUMLInteractionDiagramModelJGraph(new
																			  AUMLInteractionDiagramDataEntity(
																											   diagramName), diagramName, ids.om, new Model(ids),
																			  new BasicMarqueeHandler(), ids.prefs );
										AUMLInteractionDiagramActionsFactory ema=new  AUMLInteractionDiagramActionsFactory(resources,ids);
										mjg.setUI(new EmbeddedAndPopupCellEditor(ids,resources));
										MarqueeHandler marquee=new MarqueeHandler(mjg, resources,ids,ema);
										mjg.setMarqueeHandler(marquee);
										ids.gm.addModel(tp.getPath(), diagramName, mjg);
										ids.addNewDiagram(mjg);
										
									}
							}
							
						}
					});
				}
				
				//*/
				
				menu.add(new AbstractAction("Add package") {
					
					public void actionPerformed(ActionEvent e) {
						TreePath tp = ids.gm.arbolProyecto.getSelectionPath();
						if (tp != null) {
							String nombre =
							JOptionPane.showInputDialog(owner,
														"Type a new package's name",
														"New package",
														JOptionPane.QUESTION_MESSAGE);
							if (nombre != null) {
								ids.gm.addPackage(tp.getPath(), nombre);
								
								ids.gm.arbolProyecto.repaint();
								ids.gm.arbolProyecto.expandPath(tp);
								ids.gm.arbolProyecto.scrollPathToVisible(tp);
								ids.addNewPackage(tp.getPath(),nombre);
								
							}
						}
					}
				});
			} 
			else {
				
				// Edit Project Tree Browser Elements
				
				menu.add(
						 new AbstractAction("Edit diagram properties") {
					public void actionPerformed(ActionEvent e) {
						TreePath tp = ids.gm.arbolProyecto.getSelectionPath();
						if (tp != null) {
							
							DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) tp.
							getLastPathComponent();
							
							Object uo = dmtn.getUserObject();
							
							if (!String.class.isAssignableFrom(uo.getClass())) {
								boolean duplicated = true;
								while (duplicated) {
									ModelDataEntity mde = ( (ModelJGraph) uo).getProperties();
									
									ingenias.editor.editiondialog.GeneralEditionFrame gef = new ingenias.
									editor.editiondialog.GeneralEditionFrame(ids.editor, ids.om, ids.gm, owner,
																			 "Edit diagram properties",
																			 mde);
									ModelJGraph mjg =
									ids.gm.getModel(mde.getId());
									//	              Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
									gef.setLocation(GraphicsUtils.getCenter(resources.getMainFrame(),gef.getSize()));
									gef.pack();
									gef.show();
									duplicated =
									ids.gm.isDuplicated(mde.getId());
									if (duplicated) {
										JOptionPane.showMessageDialog(owner,
																	  "There exists a model with the same name. Please, select another",
																	  "Warning", JOptionPane.WARNING_MESSAGE);
									} else {
										ids.gm.arbolProyecto.storeTreeExpansionPaths();
										( (DefaultTreeModel) ids.gm.arbolProyecto.getModel()).reload();
										ids.gm.arbolProyecto.restoreTreeExpansionPath();
										ids.diagramPropertiesChanged(mjg);
										
									}
								}
								
							}
						}
					}
				});
			}
			if (tp.getPathCount()>1){
				menu.add(new AbstractAction("rename") {
					public void actionPerformed(ActionEvent e) {
						TreePath tp = ids.gm.arbolProyecto.getSelectionPath();
						if (tp != null) {
							DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) tp.
							getLastPathComponent();
							Object uo = dmtn.getUserObject();
							
							String result = JOptionPane.showInputDialog(owner,
																		"Type in the new name", 
																		uo.toString());
							if (result != null && !result.equals("")) {
								if (String.class.isAssignableFrom(uo.getClass())) {
									dmtn.setUserObject(result);
									
									ids.setChanged(true);
									ids.packageRenamed(result);											
								}
								else {
									if (ids.gm.existsModel(result)) {
										JOptionPane.showMessageDialog(owner,
																	  "There exists a model with the same name. Please, select another",
																	  "Warning",
																	  JOptionPane.WARNING_MESSAGE);
									}
									else {
										
										ModelJGraph mjg = (ModelJGraph) uo;
										mjg.setId(result);
										mjg.setName(result);
										ids.diagramRenamed(mjg);		
									}
								}
							}
						}
					}
				});
				
				menu.add(
						 new AbstractAction("remove package/model") {
					
					public void actionPerformed(ActionEvent e) {
						TreePath tp = ids.gm.arbolProyecto.getSelectionPath();
						if (tp != null) {
							int result = JOptionPane.showConfirmDialog(owner,
																	   "This will remove permanently " + tp.getLastPathComponent() +
																	   ". Are you sure?",
																	   "removing package", JOptionPane.YES_NO_OPTION);
							if (result == JOptionPane.OK_OPTION) {
								ModelJGraph mj = ids.gm.getModel(tp.getPath());
								if (mj != null) {
									ids.editor.closeTab(mj.getID());
								}
								ids.gm.arbolProyecto.storeTreeExpansionPaths();
								ids.gm.removePackage(tp.getPath());
								
								( (DefaultTreeModel) ids.gm.arbolProyecto.getModel()).reload();
								ids.gm.arbolProyecto.repaint();
								ids.gm.arbolProyecto.restoreTreeExpansionPath();
								ids.diagramDeleted(mj);  
							}
						}
					}
				});
			}
		}
		return menu;
	};
	
	
	
}



