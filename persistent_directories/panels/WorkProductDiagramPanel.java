
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

public class WorkProductDiagramPanel extends JGraph {
	
	public WorkProductDiagramPanel(WorkProductDiagramDataEntity mde,
								   String nombre, Model
								   m, BasicMarqueeHandler mh) {
		super(m, mh);
		
		this.getGraphLayoutCache().setFactory(new ingenias.editor.cellfactories.WorkProductDiagramCellViewFactory());
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
		
		
		entities.add("RoleWS");
		
		entities.add("TaskWS");
		
		entities.add("Resource");
		
		entities.add("InitialNode");
		
		entities.add("DecisionNode");
		
		entities.add("ForkNode");
		
		entities.add("EndNode");
		
		entities.add("Protocol");
		
		entities.add("SubProtocol");
		
		entities.add("Lifeline");
		
		entities.add("Column");
		
		entities.add("AUMLPort");
		
		entities.add("AUMLAlternativeBox");
		
		entities.add("AUMLAlternativeRow");
		
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
			if (entity.equalsIgnoreCase("TaskWS")) {
				TaskWS nentity=new TaskWS(((Model)getModel()).getNewId("TaskWS"));
				DefaultGraphCell vertex = new
				TaskWSCell(nentity);
				// Default Size for the cell with the new entity
				return vertex;
			}
			else
				if (entity.equalsIgnoreCase("Resource")) {
					Resource nentity=new Resource(((Model)getModel()).getNewId("Resource"));
					DefaultGraphCell vertex = new
					ResourceCell(nentity);
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
									if (entity.equalsIgnoreCase("Protocol")) {
										Protocol nentity=new Protocol(((Model)getModel()).getNewId("Protocol"));
										DefaultGraphCell vertex = new
										ProtocolCell(nentity);
										// Default Size for the cell with the new entity
										return vertex;
									}
									else
										
										if (entity.equalsIgnoreCase("SubProtocol")) {
											SubProtocol nentity=new SubProtocol(((Model)getModel()).getNewId("SubProtocol"));
											DefaultGraphCell vertex = new
											SubProtocolCell(nentity);
											// Default Size for the cell with the new entity
											return vertex;
										}
										else
											
											if (entity.equalsIgnoreCase("Lifeline")) {
												Lifeline nentity=new Lifeline(((Model)getModel()).getNewId("Lifeline"));
												DefaultGraphCell vertex = new
												LifelineCell(nentity);
												// Default Size for the cell with the new entity
												return vertex;
											}
											else
												
												if (entity.equalsIgnoreCase("Column")) {
													Column nentity=new Column(((Model)getModel()).getNewId("Column"));
													DefaultGraphCell vertex = new
													ColumnCell(nentity);
													// Default Size for the cell with the new entity
													return vertex;
												}
												else
													
													if (entity.equalsIgnoreCase("AUMLPort")) {
														AUMLPort nentity=new AUMLPort(((Model)getModel()).getNewId("AUMLPort"));
														DefaultGraphCell vertex = new
														AUMLPortCell(nentity);
														// Default Size for the cell with the new entity
														return vertex;
													}
													else
														
														if (entity.equalsIgnoreCase("AUMLAlternativeBox")) {
															AUMLAlternativeBox nentity=new AUMLAlternativeBox(((Model)getModel()).getNewId("AUMLAlternativeBox"));
															DefaultGraphCell vertex = new
															AUMLAlternativeBoxCell(nentity);
															// Default Size for the cell with the new entity
															return vertex;
														}
														else
															
															if (entity.equalsIgnoreCase("AUMLAlternativeRow")) {
																AUMLAlternativeRow nentity=new AUMLAlternativeRow(((Model)getModel()).getNewId("AUMLAlternativeRow"));
																DefaultGraphCell vertex = new
																AUMLAlternativeRowCell(nentity);
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
																	
																	if (entity.equalsIgnoreCase("UMLComment")) {
																		UMLComment nentity=new UMLComment(((Model)getModel()).getNewId("UMLComment"));
																		DefaultGraphCell vertex = new
																		UMLCommentCell(nentity);
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
			if (entity.getType().equalsIgnoreCase("TaskWS")) {
				return TaskWSView.getSize((TaskWS)entity);      
			}
			else
				if (entity.getType().equalsIgnoreCase("Resource")) {
					return ResourceView.getSize((Resource)entity);      
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
									if (entity.getType().equalsIgnoreCase("Protocol")) {
										return ProtocolView.getSize((Protocol)entity);      
									}
									else
										
										if (entity.getType().equalsIgnoreCase("SubProtocol")) {
											return SubProtocolView.getSize((SubProtocol)entity);      
										}
										else
											
											if (entity.getType().equalsIgnoreCase("Lifeline")) {
												return LifelineView.getSize((Lifeline)entity);      
											}
											else
												
												if (entity.getType().equalsIgnoreCase("Column")) {
													return ColumnView.getSize((Column)entity);      
												}
												else
													
													if (entity.getType().equalsIgnoreCase("AUMLPort")) {
														return AUMLPortView.getSize((AUMLPort)entity);      
													}
													else
														
														if (entity.getType().equalsIgnoreCase("AUMLAlternativeBox")) {
															return AUMLAlternativeBoxView.getSize((AUMLAlternativeBox)entity);      
														}
														else
															
															if (entity.getType().equalsIgnoreCase("AUMLAlternativeRow")) {
																return AUMLAlternativeRowView.getSize((AUMLAlternativeRow)entity);      
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
			if (entity.getClass().equals(TaskWS.class)) {
				vertex = new TaskWSCell( (TaskWS) entity);
				// Default Size for the new Vertex with the new entity within
				size = TaskWSView.getSize((TaskWS) entity);
			}
			else
				if (entity.getClass().equals(Resource.class)) {
					vertex = new ResourceCell( (Resource) entity);
					// Default Size for the new Vertex with the new entity within
					size = ResourceView.getSize((Resource) entity);
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
									if (entity.getClass().equals(Protocol.class)) {
			vertex = new ProtocolCell( (Protocol) entity);
			// Default Size for the new Vertex with the new entity within
			size = ProtocolView.getSize((Protocol) entity);
		}
		else			
			if (entity.getClass().equals(SubProtocol.class)) {
				vertex = new SubProtocolCell( (SubProtocol) entity);
				// Default Size for the new Vertex with the new entity within
				size = SubProtocolView.getSize((SubProtocol) entity);
			}
			else
				
				if (entity.getClass().equals(Lifeline.class)) {
					vertex = new LifelineCell( (Lifeline) entity);
					// Default Size for the new Vertex with the new entity within
					size = LifelineView.getSize((Lifeline) entity);
				}
				else
					
					if (entity.getClass().equals(Column.class)) {
						vertex = new ColumnCell( (Column) entity);
						// Default Size for the new Vertex with the new entity within
						size = ColumnView.getSize((Column) entity);
					}
					else
						
						if (entity.getClass().equals(AUMLPort.class)) {
							vertex = new AUMLPortCell( (AUMLPort) entity);
							// Default Size for the new Vertex with the new entity within
							size = AUMLPortView.getSize((AUMLPort) entity);
						}
						else
							
							if (entity.getClass().equals(AUMLAlternativeBox.class)) {
								vertex = new AUMLAlternativeBoxCell( (AUMLAlternativeBox) entity);
								// Default Size for the new Vertex with the new entity within
								size = AUMLAlternativeBoxView.getSize((AUMLAlternativeBox) entity);
							}
							else
								
								if (entity.getClass().equals(AUMLAlternativeRow.class)) {
									vertex = new AUMLAlternativeRowCell( (AUMLAlternativeRow) entity);
									// Default Size for the new Vertex with the new entity within
									size = AUMLAlternativeRowView.getSize((AUMLAlternativeRow) entity);
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
											
										{}; // Just in case there is no allowed entity in the diagram
		
		if (vertex == null) {
			System.err.println(
							   "Object not allowed in WorkProductDiagram diagram :"+ 
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
