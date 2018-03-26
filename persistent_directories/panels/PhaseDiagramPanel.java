
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

public class PhaseDiagramPanel extends JGraph {
	
	public PhaseDiagramPanel(PhaseDiagramDataEntity mde,
							 String nombre, Model
							 m, BasicMarqueeHandler mh) {
		super(m, mh);
		
		this.getGraphLayoutCache().setFactory(new ingenias.editor.cellfactories.PhaseDiagramCellViewFactory());
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
	
	public static Vector<String> getAllowedEntities() {
		Vector<String> entities=new   Vector<String>();
		
		
		entities.add("InitialNode");
		
		entities.add("EndNode");
		
		entities.add("Phase");
		
		entities.add("iPhase");
		
		entities.add("Activity");
		
		entities.add("DecisionNode");
		
		entities.add("ForkNode");
		
		entities.add("JoinNode");
		
		entities.add("TextNote");
		
		entities.add("UMLComment");
		
		return entities;
	}
	
	public DefaultGraphCell createCell(String entity) throws InvalidEntity {
		
		if (entity.equalsIgnoreCase("InitialNode")) {
			InitialNode nentity=new InitialNode(((Model)getModel()).getNewId("InitialNode"));
			DefaultGraphCell vertex = new
			InitialNodeCell(nentity);
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
				
				if (entity.equalsIgnoreCase("Phase")) {
					Phase nentity=new Phase(((Model)getModel()).getNewId("Phase"));
					DefaultGraphCell vertex = new
					PhaseCell(nentity);
					// Default Size for the cell with the new entity
					return vertex;
				}
				else
					
					if (entity.equalsIgnoreCase("iPhase")) {
						iPhase nentity=new iPhase(((Model)getModel()).getNewId("iPhase"));
						DefaultGraphCell vertex = new
						iPhaseCell(nentity);
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
									
									if (entity.equalsIgnoreCase("JoinNode")) {
										JoinNode nentity=new JoinNode(((Model)getModel()).getNewId("JoinNode"));
										DefaultGraphCell vertex = new
										JoinNodeCell(nentity);
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
	
	public Dimension getDefaultSize(Entity entity) throws InvalidEntity {
		
		if (entity.getType().equalsIgnoreCase("InitialNode")) {
			return InitialNodeView.getSize((InitialNode)entity);      
		}
		else
			
			if (entity.getType().equalsIgnoreCase("EndNode")) {
				return EndNodeView.getSize((EndNode)entity);      
			}
			else
				
				if (entity.getType().equalsIgnoreCase("Phase")) {
					return PhaseView.getSize((Phase)entity);      
				}
				else
					
					if (entity.getType().equalsIgnoreCase("iPhase")) {
						return iPhaseView.getSize((iPhase)entity);      
					}
					else
						
						if (entity.getType().equalsIgnoreCase("Activity")) {
							return ActivityView.getSize((Activity)entity);      
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
									
									if (entity.getType().equalsIgnoreCase("JoinNode")) {
										return JoinNodeView.getSize((JoinNode)entity);      
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
		
		vertex = this.createCell(entity);
		size = this.getDefaultSize((Entity)vertex.getUserObject());
		
		
		
		// Add a Bounds Attribute to the Map
		GraphConstants.setBounds(map, new Rectangle(point, size));
		
		// Construct a Map from cells to Maps (for insert)
		Hashtable attributes = new Hashtable();
		// Associate the Vertex with its Attributes
		attributes.put(vertex, map);
		// Insert the Vertex and its Attributes
		this.getModel().insert(new Object[] {vertex}, attributes, null, null, null);
		return vertex;
	}
	
	public DefaultGraphCell insertDuplicated(Point point, ingenias.editor.entities.Entity entity) {
		// CellView information is not available after creating the cell.
		
		// Create a Map that holds the attributes for the Vertex
		Map map =new Hashtable();
		// Snap the Point to the Grid
		
		
		// Construct Vertex with no Label
		DefaultGraphCell vertex = null;
		Dimension size = null;
		
		
		if (entity.getClass().equals(InitialNode.class)) {
			vertex = new InitialNodeCell( (InitialNode) entity);
			// Default Size for the new Vertex with the new entity within
			size = InitialNodeView.getSize((InitialNode) entity);
		}
		else
			
			if (entity.getClass().equals(EndNode.class)) {
				vertex = new EndNodeCell( (EndNode) entity);
				// Default Size for the new Vertex with the new entity within
				size = EndNodeView.getSize((EndNode) entity);
			}
			else
				
				if (entity.getClass().equals(Phase.class)) {
					vertex = new PhaseCell( (Phase) entity);
					// Default Size for the new Vertex with the new entity within
					size = PhaseView.getSize((Phase) entity);
				}
				else
					
					if (entity.getClass().equals(iPhase.class)) {
						vertex = new iPhaseCell( (iPhase) entity);
						// Default Size for the new Vertex with the new entity within
						size = iPhaseView.getSize((iPhase) entity);
					}
					else
						
						if (entity.getClass().equals(Activity.class)) {
							vertex = new ActivityCell( (Activity) entity);
							// Default Size for the new Vertex with the new entity within
							size = ActivityView.getSize((Activity) entity);
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
									
									if (entity.getClass().equals(JoinNode.class)) {
										vertex = new JoinNodeCell( (JoinNode) entity);
										// Default Size for the new Vertex with the new entity within
										size = JoinNodeView.getSize((JoinNode) entity);
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
							   "Object not allowed in PhaseDiagram diagram :"+ 
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
