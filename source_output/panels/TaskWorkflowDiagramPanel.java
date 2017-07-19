
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

public class TaskWorkflowDiagramPanel extends JGraph {

	public TaskWorkflowDiagramPanel(TaskWorkflowDiagramDataEntity mde,
								String nombre, Model
								m, BasicMarqueeHandler mh) {
		super(m, mh);

		this.getGraphLayoutCache().setFactory(new ingenias.editor.cellfactories.TaskWorkflowDiagram.CellViewFactory()());
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

        entities.add("StructuralWP");
        
                entities.add("InitialMetaNode");
        
                entities.add("FreeWP");
        
                entities.add("ForkNode");
        
                entities.add("WPProduced");
        
                entities.add("BehavioralWP");
        
                entities.add("EndNode");
        
                entities.add("WFConsumed");
        
                entities.add("TerminalMetaNode");
        
                entities.add("Task");
        
                entities.add("Role");
        
                entities.add("InitialNode");
        
                entities.add("ActivityKind");
        
                entities.add("StructuredWP");
        
                entities.add("CompositeWP");
        
                entities.add("DecissionNode");
        
                entities.add("JoinNode");
        
                
        
        
        return entities;
    }

public DefaultGraphCell createCell(String entity) throws InvalidEntity{
if (entity.equalsIgnoreCase("StructuralWP")) {
            StructuralWP nentity=getOM().$createname(getMJGraph().getNewId("StructuralWP"));
            DefaultGraphCell vertex = new
            StructuralWPCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("InitialMetaNode")) {
            InitialMetaNode nentity=getOM().$createname(getMJGraph().getNewId("InitialMetaNode"));
            DefaultGraphCell vertex = new
            InitialMetaNodeCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("FreeWP")) {
            FreeWP nentity=getOM().$createname(getMJGraph().getNewId("FreeWP"));
            DefaultGraphCell vertex = new
            FreeWPCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("ForkNode")) {
            ForkNode nentity=getOM().$createname(getMJGraph().getNewId("ForkNode"));
            DefaultGraphCell vertex = new
            ForkNodeCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("WPProduced")) {
            WPProduced nentity=getOM().$createname(getMJGraph().getNewId("WPProduced"));
            DefaultGraphCell vertex = new
            WPProducedCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("BehavioralWP")) {
            BehavioralWP nentity=getOM().$createname(getMJGraph().getNewId("BehavioralWP"));
            DefaultGraphCell vertex = new
            BehavioralWPCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("EndNode")) {
            EndNode nentity=getOM().$createname(getMJGraph().getNewId("EndNode"));
            DefaultGraphCell vertex = new
            EndNodeCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("WFConsumed")) {
            WFConsumed nentity=getOM().$createname(getMJGraph().getNewId("WFConsumed"));
            DefaultGraphCell vertex = new
            WFConsumedCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("TerminalMetaNode")) {
            TerminalMetaNode nentity=getOM().$createname(getMJGraph().getNewId("TerminalMetaNode"));
            DefaultGraphCell vertex = new
            TerminalMetaNodeCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("Task")) {
            Task nentity=getOM().$createname(getMJGraph().getNewId("Task"));
            DefaultGraphCell vertex = new
            TaskCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("Role")) {
            Role nentity=getOM().$createname(getMJGraph().getNewId("Role"));
            DefaultGraphCell vertex = new
            RoleCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("InitialNode")) {
            InitialNode nentity=getOM().$createname(getMJGraph().getNewId("InitialNode"));
            DefaultGraphCell vertex = new
            InitialNodeCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("ActivityKind")) {
            ActivityKind nentity=getOM().$createname(getMJGraph().getNewId("ActivityKind"));
            DefaultGraphCell vertex = new
            ActivityKindCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("StructuredWP")) {
            StructuredWP nentity=getOM().$createname(getMJGraph().getNewId("StructuredWP"));
            DefaultGraphCell vertex = new
            StructuredWPCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("CompositeWP")) {
            CompositeWP nentity=getOM().$createname(getMJGraph().getNewId("CompositeWP"));
            DefaultGraphCell vertex = new
            CompositeWPCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("DecissionNode")) {
            DecissionNode nentity=getOM().$createname(getMJGraph().getNewId("DecissionNode"));
            DefaultGraphCell vertex = new
            DecissionNodeCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("JoinNode")) {
            JoinNode nentity=getOM().$createname(getMJGraph().getNewId("JoinNode"));
            DefaultGraphCell vertex = new
            JoinNodeCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        
       throw new ingenias.exception.InvalidEntity("Entity type "+entity+" is not allowed in this diagram"); 
}

public Dimension getDefaultSize(Entity entity) throws InvalidEntity{
if (entity.getType().equalsIgnoreCase("StructuralWP")) {
            return StructuralWPView.getSize((StructuralWP)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("InitialMetaNode")) {
            return InitialMetaNodeView.getSize((InitialMetaNode)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("FreeWP")) {
            return FreeWPView.getSize((FreeWP)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("ForkNode")) {
            return ForkNodeView.getSize((ForkNode)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("WPProduced")) {
            return WPProducedView.getSize((WPProduced)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("BehavioralWP")) {
            return BehavioralWPView.getSize((BehavioralWP)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("EndNode")) {
            return EndNodeView.getSize((EndNode)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("WFConsumed")) {
            return WFConsumedView.getSize((WFConsumed)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("TerminalMetaNode")) {
            return TerminalMetaNodeView.getSize((TerminalMetaNode)entity);      
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

        if (entity.getType().equalsIgnoreCase("InitialNode")) {
            return InitialNodeView.getSize((InitialNode)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("ActivityKind")) {
            return ActivityKindView.getSize((ActivityKind)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("StructuredWP")) {
            return StructuredWPView.getSize((StructuredWP)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("CompositeWP")) {
            return CompositeWPView.getSize((CompositeWP)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("DecissionNode")) {
            return DecissionNodeView.getSize((DecissionNode)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("JoinNode")) {
            return JoinNodeView.getSize((JoinNode)entity);      
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
        point = convert(this.snap(new Point(point)));
        
        
        // Construct Vertex with no Label
        DefaultGraphCell vertex = null;
        Dimension size = null;
        
        
if (entity.getClass().equals(StructuralWP.class)) {
            vertex = new StructuralWPCell( (StructuralWP) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((StructuralWP) entity);
        }
        else

        if (entity.getClass().equals(InitialMetaNode.class)) {
            vertex = new InitialMetaNodeCell( (InitialMetaNode) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((InitialMetaNode) entity);
        }
        else

        if (entity.getClass().equals(FreeWP.class)) {
            vertex = new FreeWPCell( (FreeWP) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((FreeWP) entity);
        }
        else

        if (entity.getClass().equals(ForkNode.class)) {
            vertex = new ForkNodeCell( (ForkNode) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((ForkNode) entity);
        }
        else

        if (entity.getClass().equals(WPProduced.class)) {
            vertex = new WPProducedCell( (WPProduced) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((WPProduced) entity);
        }
        else

        if (entity.getClass().equals(BehavioralWP.class)) {
            vertex = new BehavioralWPCell( (BehavioralWP) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((BehavioralWP) entity);
        }
        else

        if (entity.getClass().equals(EndNode.class)) {
            vertex = new EndNodeCell( (EndNode) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((EndNode) entity);
        }
        else

        if (entity.getClass().equals(WFConsumed.class)) {
            vertex = new WFConsumedCell( (WFConsumed) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((WFConsumed) entity);
        }
        else

        if (entity.getClass().equals(TerminalMetaNode.class)) {
            vertex = new TerminalMetaNodeCell( (TerminalMetaNode) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((TerminalMetaNode) entity);
        }
        else

        if (entity.getClass().equals(Task.class)) {
            vertex = new TaskCell( (Task) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((Task) entity);
        }
        else

        if (entity.getClass().equals(Role.class)) {
            vertex = new RoleCell( (Role) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((Role) entity);
        }
        else

        if (entity.getClass().equals(InitialNode.class)) {
            vertex = new InitialNodeCell( (InitialNode) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((InitialNode) entity);
        }
        else

        if (entity.getClass().equals(ActivityKind.class)) {
            vertex = new ActivityKindCell( (ActivityKind) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((ActivityKind) entity);
        }
        else

        if (entity.getClass().equals(StructuredWP.class)) {
            vertex = new StructuredWPCell( (StructuredWP) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((StructuredWP) entity);
        }
        else

        if (entity.getClass().equals(CompositeWP.class)) {
            vertex = new CompositeWPCell( (CompositeWP) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((CompositeWP) entity);
        }
        else

        if (entity.getClass().equals(DecissionNode.class)) {
            vertex = new DecissionNodeCell( (DecissionNode) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((DecissionNode) entity);
        }
        else

        if (entity.getClass().equals(JoinNode.class)) {
            vertex = new JoinNodeCell( (JoinNode) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((JoinNode) entity);
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
}
