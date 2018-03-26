
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
package ingenias.editor.panels;

import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.event.UndoableEditEvent;

import java.net.URL;

import java.util.Map;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Vector;

import org.jgraph.JGraph;
import org.jgraph.graph.*;
import org.jgraph.event.*;
import org.jgraph.plaf.basic.*;

import ingenias.editor.entities.*;
import ingenias.editor.cell.*;
import ingenias.editor.events.*;
import ingenias.editor.*;

import ingenias.exception.InvalidEntity;

public class AgentModelPanel extends JGraph {
	
	public AgentModelPanel(AgentModelDataEntity mde, 
						   String nombre, Model
						   m, BasicMarqueeHandler mh) {
		super(m, mh);
		
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
	
	public static Vector<String> getAllowedEntities(){
		Vector<String> entities=new   Vector<String>();
		
		
		entities.add("Agent");
		
		entities.add("Role");
		
		entities.add("Goal");
		
		entities.add("Plan");
		
		entities.add("StateGoal");
		
		entities.add("Fact");
		
		entities.add("Task");
		
		entities.add("FrameFact");
		
		entities.add("Believe");
		
		entities.add("Compromise");
		
		entities.add("GeneralEvent");
		
		entities.add("ApplicationEvent");
		
		entities.add("ApplicationEventSlots");
		
		entities.add("MentalStateProcessor");
		
		entities.add("MentalStateManager");
		
		entities.add("MentalState");
		
		entities.add("ConditionalMentalState");
		
		entities.add("AutonomousEntityQuery");
		
		entities.add("AgentRequirementsQuery");
		
		entities.add("ConcreteAgent");
		
		entities.add("AgentModelBelieve");
		
		entities.add("Conversation");
		
		entities.add("UMLComment");
		
		entities.add("TextNote");
		
		entities.add("Application");
		
		entities.add("EnvironmentApplication");
		
		entities.add("InternalApplication");
		
		entities.add("RoleWS");
		
		entities.add("TaskWS");
		
		entities.add("GoalStateWS");
		
		entities.add("AgentWS");
		
		entities.add("MentalInstanceSpecification");
		
		return entities;
	}
	
	
	
	public DefaultGraphCell createCell(String entity) throws InvalidEntity{
		
		if (entity.equalsIgnoreCase("Agent")) {
			Agent nentity=new Agent(((Model)getModel()).getNewId("Agent"));
			DefaultGraphCell vertex = new
			AgentCell(nentity);
			// Default Size for the cell with the new entity
			return vertex;
		}
		else
			
			if (entity.equalsIgnoreCase("Role")) {
				Role nentity=new Role(((Model)getModel()).getNewId("Role"));
				DefaultGraphCell vertex = new
				RoleCell(nentity);
				// Default Size for the cell with the new entity
				return vertex;
			}
			else
				
				if (entity.equalsIgnoreCase("Goal")) {
					Goal nentity=new Goal(((Model)getModel()).getNewId("Goal"));
					DefaultGraphCell vertex = new
					GoalCell(nentity);
					// Default Size for the cell with the new entity
					return vertex;
				}
				else
					
					if (entity.equalsIgnoreCase("Plan")) {
						Plan nentity=new Plan(((Model)getModel()).getNewId("Plan"));
						DefaultGraphCell vertex = new
						PlanCell(nentity);
						// Default Size for the cell with the new entity
						return vertex;
					}
					else
						
						if (entity.equalsIgnoreCase("StateGoal")) {
							StateGoal nentity=new StateGoal(((Model)getModel()).getNewId("StateGoal"));
							DefaultGraphCell vertex = new
							StateGoalCell(nentity);
							// Default Size for the cell with the new entity
							return vertex;
						}
						else
							
							if (entity.equalsIgnoreCase("Fact")) {
								Fact nentity=new Fact(((Model)getModel()).getNewId("Fact"));
								DefaultGraphCell vertex = new
								FactCell(nentity);
								// Default Size for the cell with the new entity
								return vertex;
							}
							else
								
								if (entity.equalsIgnoreCase("Task")) {
									Task nentity=new Task(((Model)getModel()).getNewId("Task"));
									DefaultGraphCell vertex = new
									TaskCell(nentity);
									// Default Size for the cell with the new entity
									return vertex;
								}
								else
									
									if (entity.equalsIgnoreCase("FrameFact")) {
										FrameFact nentity=new FrameFact(((Model)getModel()).getNewId("FrameFact"));
										DefaultGraphCell vertex = new
										FrameFactCell(nentity);
										// Default Size for the cell with the new entity
										return vertex;
									}
									else
										
										if (entity.equalsIgnoreCase("Believe")) {
											Believe nentity=new Believe(((Model)getModel()).getNewId("Believe"));
											DefaultGraphCell vertex = new
											BelieveCell(nentity);
											// Default Size for the cell with the new entity
											return vertex;
										}
										else
											
											if (entity.equalsIgnoreCase("Compromise")) {
												Compromise nentity=new Compromise(((Model)getModel()).getNewId("Compromise"));
												DefaultGraphCell vertex = new
												CompromiseCell(nentity);
												// Default Size for the cell with the new entity
												return vertex;
											}
											else
												
												if (entity.equalsIgnoreCase("GeneralEvent")) {
													GeneralEvent nentity=new GeneralEvent(((Model)getModel()).getNewId("GeneralEvent"));
													DefaultGraphCell vertex = new
													GeneralEventCell(nentity);
													// Default Size for the cell with the new entity
													return vertex;
												}
												else
													
													if (entity.equalsIgnoreCase("ApplicationEvent")) {
														ApplicationEvent nentity=new ApplicationEvent(((Model)getModel()).getNewId("ApplicationEvent"));
														DefaultGraphCell vertex = new
														ApplicationEventCell(nentity);
														// Default Size for the cell with the new entity
														return vertex;
													}
													else
														
														if (entity.equalsIgnoreCase("ApplicationEventSlots")) {
															ApplicationEventSlots nentity=new ApplicationEventSlots(((Model)getModel()).getNewId("ApplicationEventSlots"));
															DefaultGraphCell vertex = new
															ApplicationEventSlotsCell(nentity);
															// Default Size for the cell with the new entity
															return vertex;
														}
														else
															
															if (entity.equalsIgnoreCase("MentalStateProcessor")) {
																MentalStateProcessor nentity=new MentalStateProcessor(((Model)getModel()).getNewId("MentalStateProcessor"));
																DefaultGraphCell vertex = new
																MentalStateProcessorCell(nentity);
																// Default Size for the cell with the new entity
																return vertex;
															}
															else
																
																if (entity.equalsIgnoreCase("MentalStateManager")) {
																	MentalStateManager nentity=new MentalStateManager(((Model)getModel()).getNewId("MentalStateManager"));
																	DefaultGraphCell vertex = new
																	MentalStateManagerCell(nentity);
																	// Default Size for the cell with the new entity
																	return vertex;
																}
																else
																	
																	if (entity.equalsIgnoreCase("MentalState")) {
																		MentalState nentity=new MentalState(((Model)getModel()).getNewId("MentalState"));
																		DefaultGraphCell vertex = new
																		MentalStateCell(nentity);
																		// Default Size for the cell with the new entity
																		return vertex;
																	}
																	else
																		
																		if (entity.equalsIgnoreCase("ConditionalMentalState")) {
																			ConditionalMentalState nentity=new ConditionalMentalState(((Model)getModel()).getNewId("ConditionalMentalState"));
																			DefaultGraphCell vertex = new
																			ConditionalMentalStateCell(nentity);
																			// Default Size for the cell with the new entity
																			return vertex;
																		}
																		else
																			
																			if (entity.equalsIgnoreCase("AutonomousEntityQuery")) {
																				AutonomousEntityQuery nentity=new AutonomousEntityQuery(((Model)getModel()).getNewId("AutonomousEntityQuery"));
																				DefaultGraphCell vertex = new
																				AutonomousEntityQueryCell(nentity);
																				// Default Size for the cell with the new entity
																				return vertex;
																			}
																			else
																				
																				if (entity.equalsIgnoreCase("AgentRequirementsQuery")) {
																					AgentRequirementsQuery nentity=new AgentRequirementsQuery(((Model)getModel()).getNewId("AgentRequirementsQuery"));
																					DefaultGraphCell vertex = new
																					AgentRequirementsQueryCell(nentity);
																					// Default Size for the cell with the new entity
																					return vertex;
																				}
																				else
																					
																					if (entity.equalsIgnoreCase("ConcreteAgent")) {
																						ConcreteAgent nentity=new ConcreteAgent(((Model)getModel()).getNewId("ConcreteAgent"));
																						DefaultGraphCell vertex = new
																						ConcreteAgentCell(nentity);
																						// Default Size for the cell with the new entity
																						return vertex;
																					}
																					else
																						
																						if (entity.equalsIgnoreCase("AgentModelBelieve")) {
																							AgentModelBelieve nentity=new AgentModelBelieve(((Model)getModel()).getNewId("AgentModelBelieve"));
																							DefaultGraphCell vertex = new
																							AgentModelBelieveCell(nentity);
																							// Default Size for the cell with the new entity
																							return vertex;
																						}
																						else
																							
																							if (entity.equalsIgnoreCase("Conversation")) {
																								Conversation nentity=new Conversation(((Model)getModel()).getNewId("Conversation"));
																								DefaultGraphCell vertex = new
																								ConversationCell(nentity);
																								// Default Size for the cell with the new entity
																								return vertex;
																							}
																							else
																								
																								if (entity.equalsIgnoreCase("UMLComment")) {
																									UMLComment nentity=new UMLComment(((Model)getModel()).getNewId("UMLComment"));
																									DefaultGraphCell vertex = new
																									UMLCommentCell(nentity);
																									// Default Size for the cell with the new entity
																									return vertex;
																								}
																								else
																									
																									if (entity.equalsIgnoreCase("TextNote")) {
																										TextNote nentity=new TextNote(((Model)getModel()).getNewId("TextNote"));
																										DefaultGraphCell vertex = new
																										TextNoteCell(nentity);
																										// Default Size for the cell with the new entity
																										return vertex;
																									}
																									else
																										
																										if (entity.equalsIgnoreCase("Application")) {
																											Application nentity=new Application(((Model)getModel()).getNewId("Application"));
																											DefaultGraphCell vertex = new
																											ApplicationCell(nentity);
																											// Default Size for the cell with the new entity
																											return vertex;
																										}
																										else
																											
																											if (entity.equalsIgnoreCase("EnvironmentApplication")) {
																												EnvironmentApplication nentity=new EnvironmentApplication(((Model)getModel()).getNewId("EnvironmentApplication"));
																												DefaultGraphCell vertex = new
																												EnvironmentApplicationCell(nentity);
																												// Default Size for the cell with the new entity
																												return vertex;
																											}
																											else
																												
																												if (entity.equalsIgnoreCase("InternalApplication")) {
																													InternalApplication nentity=new InternalApplication(((Model)getModel()).getNewId("InternalApplication"));
																													DefaultGraphCell vertex = new
																													InternalApplicationCell(nentity);
																													// Default Size for the cell with the new entity
																													return vertex;
																												}
																												else
																													
																													if (entity.equalsIgnoreCase("RoleWS")) {
																														RoleWS nentity=new RoleWS(((Model)getModel()).getNewId("RoleWS"));
																														DefaultGraphCell vertex = new
																														RoleWSCell(nentity);
																														// Default Size for the cell with the new entity
																														return vertex;
																													}
																													else
																														
																														if (entity.equalsIgnoreCase("TaskWS")) {
																															TaskWS nentity=new TaskWS(((Model)getModel()).getNewId("TaskWS"));
																															DefaultGraphCell vertex = new
																															TaskWSCell(nentity);
																															// Default Size for the cell with the new entity
																															return vertex;
																														}
																														else
																															
																															if (entity.equalsIgnoreCase("GoalStateWS")) {
																																GoalStateWS nentity=new GoalStateWS(((Model)getModel()).getNewId("GoalStateWS"));
																																DefaultGraphCell vertex = new
																																GoalStateWSCell(nentity);
																																// Default Size for the cell with the new entity
																																return vertex;
																															}
																															else
																																
																																if (entity.equalsIgnoreCase("AgentWS")) {
																																	AgentWS nentity=new AgentWS(((Model)getModel()).getNewId("AgentWS"));
																																	DefaultGraphCell vertex = new
																																	AgentWSCell(nentity);
																																	// Default Size for the cell with the new entity
																																	return vertex;
																																}
																																else
																																	
																																	if (entity.equalsIgnoreCase("MentalInstanceSpecification")) {
																																		MentalInstanceSpecification nentity=new MentalInstanceSpecification(((Model)getModel()).getNewId("MentalInstanceSpecification"));
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
		return vertex;
	}
	
	
	
	
	public DefaultGraphCell insertDuplicated(Point point, ingenias.editor.entities.Entity
											 entity) {
		// CellView information is not available after creating the cell.
		
		// Create a Map that holds the attributes for the Vertex
		Map map =new Hashtable();
		// Snap the Point to the Grid
		
		
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
			System.err.println(
							   "Object not allowed in AgentModel diagram :"+ 
							   entity.getId()+":"+entity.getClass().getName()+
							   this.getClass().getName());    }
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
	
	
}
