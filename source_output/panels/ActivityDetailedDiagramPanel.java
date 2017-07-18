
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
import ingenias.editor.entities.*;
import ingenias.editor.cell.*;
import ingenias.editor.events.*;
import ingenias.exception.InvalidEntity;
import ingenias.editor.*;

public class ActivityDetailedDiagramPanel extends JGraph {

	public ActivityDetailedDiagramPanel(ActivityDetailedDiagramDataEntity mde,
								String nombre, Model
								m, BasicMarqueeHandler mh) {
		super(m, mh);

		this.getGraphLayoutCache().setFactory(new ingenias.editor.cellfactories.ActivityDetailedDiagram.CellViewFactory()());
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


		entities.add("InitialNode");

		entities.add("DecisionNode");

		entities.add("ForkNode");

		entities.add("EndNode");

		entities.add("Task");

		entities.add("Role");

		entities.add("RoleWS");

		entities.add("Activity");

		entities.add("TaskWS");

		entities.add("WorkProduct");

		entities.add("BehaviourWP");

		entities.add("StructuredWP");

		entities.add("StructuralWP");

		entities.add("FreeWP");

		entities.add("TextNote");

		entities.add("UMLComment");

		return entities;
	}



	public DefaultGraphCell createCell(String entity) throws InvalidEntity{

		if (entity.equalsIgnoreCase("RoleWS")) {
			RoleWS nentity=new RoleWS(((Model)getModel()).getNewId("RoleWS"));
			DefaultGraphCell vertex = new
			RoleWSCell(nentity);
			// Default Size for the cell with the new entity
			return vertex;
		}
		else

			if (entity.equalsIgnoreCase("Activity")) {
				Activity nentity=new Activity(((Model)getModel()).getNewId("Activity"));
				DefaultGraphCell vertex = new
				ActivityCell(nentity);
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

					if (entity.equalsIgnoreCase("WorkProduct")) {
						WorkProduct nentity=new WorkProduct(((Model)getModel()).getNewId("WorkProduct"));
						DefaultGraphCell vertex = new
						WorkProductCell(nentity);
						// Default Size for the cell with the new entity
						return vertex;
					}
					else

						if (entity.equalsIgnoreCase("FreeWP")) {
							FreeWP nentity=new FreeWP(((Model)getModel()).getNewId("FreeWP"));
							DefaultGraphCell vertex = new
							FreeWPCell(nentity);
							// Default Size for the cell with the new entity
							return vertex;
						}
						else

							if (entity.equalsIgnoreCase("BehaviourWP")) {
								BehaviourWP nentity=new BehaviourWP(((Model)getModel()).getNewId("BehaviourWP"));
								DefaultGraphCell vertex = new
								BehaviourWPCell(nentity);
								// Default Size for the cell with the new entity
								return vertex;
							}
							else

								if (entity.equalsIgnoreCase("StructuralWP")) {
									StructuralWP nentity=new StructuralWP(((Model)getModel()).getNewId("StructuralWP"));
									DefaultGraphCell vertex = new
									StructuralWPCell(nentity);
									// Default Size for the cell with the new entity
									return vertex;
								}
								else

									if (entity.equalsIgnoreCase("StructuredWP")) {
										StructuredWP nentity=new StructuredWP(((Model)getModel()).getNewId("StructuredWP"));
										DefaultGraphCell vertex = new
										StructuredWPCell(nentity);
										// Default Size for the cell with the new entity
										return vertex;
									}
									else

										if (entity.equalsIgnoreCase("InitialNode")) {
											InitialNode nentity=new InitialNode(((Model)getModel()).getNewId("InitialNode"));
											DefaultGraphCell vertex = new
											InitialNodeCell(nentity);
											// Default Size for the cell with the new entity
											return vertex;
										}
										else

											if (entity.equalsIgnoreCase("DecisionNode")) {
												DecisionNode nentity=new DecisionNode(((Model)getModel()).getNewId("DecisionNode"));
												DefaultGraphCell vertex = new
												DecisionNodeCell(nentity);
												// Default Size for the cell with the new entity
												return vertex;
											}
											else

												if (entity.equalsIgnoreCase("ForkNode")) {
													ForkNode nentity=new ForkNode(((Model)getModel()).getNewId("ForkNode"));
													DefaultGraphCell vertex = new
													ForkNodeCell(nentity);
													// Default Size for the cell with the new entity
													return vertex;
												}
												else

													if (entity.equalsIgnoreCase("EndNode")) {
														EndNode nentity=new EndNode(((Model)getModel()).getNewId("EndNode"));
														DefaultGraphCell vertex = new
														EndNodeCell(nentity);
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

															if (entity.equalsIgnoreCase("Role")) {
																Role nentity=new Role(((Model)getModel()).getNewId("Role"));
																DefaultGraphCell vertex = new
																RoleCell(nentity);
																// Default Size for the cell with the new entity
																return vertex;
															}
															else

																if (entity.equalsIgnoreCase("WorkflowBox")) {
																	WorkflowBox nentity=new WorkflowBox(((Model)getModel()).getNewId("WorkflowBox"));
																	DefaultGraphCell vertex = new
																	WorkflowBoxCell(nentity);
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

																			throw new ingenias.exception.InvalidEntity("Entity type "+entity+" is not allowed in this diagram");
	}

	public Dimension getDefaultSize(Entity entity) throws InvalidEntity{

		if (entity.getType().equalsIgnoreCase("RoleWS")) {
			return RoleWSView.getSize((RoleWS)entity);
		}
		else

			if (entity.getType().equalsIgnoreCase("Activity")) {
				return ActivityView.getSize((Activity)entity);
			}
			else

				if (entity.getType().equalsIgnoreCase("TaskWS")) {
					return TaskWSView.getSize((TaskWS)entity);
				}
				else

					if (entity.getType().equalsIgnoreCase("WorkProduct")) {
						return WorkProductView.getSize((WorkProduct)entity);
					}
					else

						if (entity.getType().equalsIgnoreCase("FreeWP")) {
							return FreeWPView.getSize((FreeWP)entity);
						}
						else

							if (entity.getType().equalsIgnoreCase("BehaviourWP")) {
								return BehaviourWPView.getSize((BehaviourWP)entity);
							}
							else

								if (entity.getType().equalsIgnoreCase("StructuredWP")) {
									return StructuredWPView.getSize((StructuredWP)entity);
								}
								else

									if (entity.getType().equalsIgnoreCase("StructuralWP")) {
										return StructuralWPView.getSize((StructuralWP)entity);
									}
									else

										if (entity.getType().equalsIgnoreCase("InitialNode")) {
											return InitialNodeView.getSize((InitialNode)entity);
										}
										else

											if (entity.getType().equalsIgnoreCase("DecisionNode")) {
												return DecisionNodeView.getSize((DecisionNode)entity);
											}
											else

												if (entity.getType().equalsIgnoreCase("ForkNode")) {
													return ForkNodeView.getSize((ForkNode)entity);
												}
												else

													if (entity.getType().equalsIgnoreCase("EndNode")) {
														return EndNodeView.getSize((EndNode)entity);
													}
													else

														if (entity.getType().equalsIgnoreCase("Task")) {
															return TaskView.getSize((Task)entity);
														}
														else

															if (entity.getType().equalsIgnoreCase("Role")) {
																return RoleView.getSize((Role)entity);
															}
															else

																if (entity.getType().equalsIgnoreCase("WorkflowBox")) {
																	return WorkflowBoxView.getSize((WorkflowBox)entity);
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


		if (entity.getClass().equals(RoleWS.class)) {
			vertex = new RoleWSCell( (RoleWS) entity);
			// Default Size for the new Vertex with the new entity within
			size = RoleWSView.getSize((RoleWS) entity);
		}
		else

			if (entity.getClass().equals(Activity.class)) {
				vertex = new ActivityCell( (Activity) entity);
				// Default Size for the new Vertex with the new entity within
				size = ActivityView.getSize((Activity) entity);
			}
			else

				if (entity.getClass().equals(TaskWS.class)) {
					vertex = new TaskWSCell( (TaskWS) entity);
					// Default Size for the new Vertex with the new entity within
					size = TaskWSView.getSize((TaskWS) entity);
				}
				else

					if (entity.getClass().equals(WorkProduct.class)) {
						vertex = new WorkProductCell( (WorkProduct) entity);
						// Default Size for the new Vertex with the new entity within
						size = WorkProductView.getSize((WorkProduct) entity);
					}
					else

						if (entity.getClass().equals(FreeWP.class)) {
							vertex = new FreeWPCell( (FreeWP) entity);
							// Default Size for the new Vertex with the new entity within
							size = FreeWPView.getSize((FreeWP) entity);
						}
						else

							if (entity.getClass().equals(BehaviourWP.class)) {
								vertex = new BehaviourWPCell( (BehaviourWP) entity);
								// Default Size for the new Vertex with the new entity within
								size = BehaviourWPView.getSize((BehaviourWP) entity);
							}
							else

								if (entity.getClass().equals(StructuralWP.class)) {
									vertex = new StructuralWPCell( (StructuralWP) entity);
									// Default Size for the new Vertex with the new entity within
									size = StructuralWPView.getSize((StructuralWP) entity);
								}
								else

									if (entity.getClass().equals(StructuredWP.class)) {
										vertex = new StructuredWPCell( (StructuredWP) entity);
										// Default Size for the new Vertex with the new entity within
										size = StructuredWPView.getSize((StructuredWP) entity);
									}
									else

										if (entity.getClass().equals(InitialNode.class)) {
											vertex = new InitialNodeCell( (InitialNode) entity);
											// Default Size for the new Vertex with the new entity within
											size = InitialNodeView.getSize((InitialNode) entity);
										}
										else

											if (entity.getClass().equals(DecisionNode.class)) {
												vertex = new DecisionNodeCell( (DecisionNode) entity);
												// Default Size for the new Vertex with the new entity within
												size = DecisionNodeView.getSize((DecisionNode) entity);
											}
											else

												if (entity.getClass().equals(ForkNode.class)) {
													vertex = new ForkNodeCell( (ForkNode) entity);
													// Default Size for the new Vertex with the new entity within
													size = ForkNodeView.getSize((ForkNode) entity);
												}
												else

													if (entity.getClass().equals(EndNode.class)) {
														vertex = new EndNodeCell( (EndNode) entity);
														// Default Size for the new Vertex with the new entity within
														size = EndNodeView.getSize((EndNode) entity);
													}
													else

														if (entity.getClass().equals(Task.class)) {
															vertex = new TaskCell( (Task) entity);
															// Default Size for the new Vertex with the new entity within
															size = TaskView.getSize((Task) entity);
														}
														else

															if (entity.getClass().equals(Role.class)) {
																vertex = new RoleCell( (Role) entity);
																// Default Size for the new Vertex with the new entity within
																size = RoleView.getSize((Role) entity);
															}
															else

																if (entity.getClass().equals(WorkflowBox.class)) {
																	vertex = new WorkflowBoxCell( (WorkflowBox) entity);
																	// Default Size for the new Vertex with the new entity within
																	size = WorkflowBoxView.getSize((WorkflowBox) entity);
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

																		{}; // Just in case there is no allowed entity in the diagram

		if (vertex == null) {
			System.err.println(
							   "Object not allowed in ActivityDetailedDiagram diagram :"+
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
