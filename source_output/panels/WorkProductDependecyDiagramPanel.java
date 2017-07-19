
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

public class WorkProductDependecyDiagramPanel extends JGraph {

	public WorkProductDependecyDiagramPanel(WorkProductDependecyDiagramDataEntity mde,
								String nombre, Model
								m, BasicMarqueeHandler mh) {
		super(m, mh);

		this.getGraphLayoutCache().setFactory(new ingenias.editor.cellfactories.WorkProductDependecyDiagramCellViewFactory()());
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

        entities.add("FreeWP");
        
                entities.add("Work Product");
        
                entities.add("CompositeWP");
        
                entities.add("BehavioralWP");
        
                entities.add("StructuredWP");
        
                entities.add("StructuralWP");
        
                
        
        
        return entities;
    }

public DefaultGraphCell createCell(String entity) throws InvalidEntity{
if (entity.equalsIgnoreCase("FreeWP")) {
            FreeWP nentity=new FreeWP(((Model)getModel()).getNewId("FreeWP"));
            DefaultGraphCell vertex = new
            FreeWPCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("Work Product")) {
            Work Product nentity=new Work Product(((Model)getModel()).getNewId("Work Product"));
            DefaultGraphCell vertex = new
            Work ProductCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("CompositeWP")) {
            CompositeWP nentity=new CompositeWP(((Model)getModel()).getNewId("CompositeWP"));
            DefaultGraphCell vertex = new
            CompositeWPCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("BehavioralWP")) {
            BehavioralWP nentity=new BehavioralWP(((Model)getModel()).getNewId("BehavioralWP"));
            DefaultGraphCell vertex = new
            BehavioralWPCell(nentity);
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

        if (entity.equalsIgnoreCase("StructuralWP")) {
            StructuralWP nentity=new StructuralWP(((Model)getModel()).getNewId("StructuralWP"));
            DefaultGraphCell vertex = new
            StructuralWPCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        
       throw new ingenias.exception.InvalidEntity("Entity type "+entity+" is not allowed in this diagram"); 
}

public Dimension getDefaultSize(Entity entity) throws InvalidEntity{
if (entity.getType().equalsIgnoreCase("FreeWP")) {
            return FreeWPView.getSize((FreeWP)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("Work Product")) {
            return Work ProductView.getSize((Work Product)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("CompositeWP")) {
            return CompositeWPView.getSize((CompositeWP)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("BehavioralWP")) {
            return BehavioralWPView.getSize((BehavioralWP)entity);      
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
        
        
if (entity.getClass().equals(FreeWP.class)) {
            vertex = new FreeWPCell( (FreeWP) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((FreeWP) entity);
        }
        else

        if (entity.getClass().equals(Work Product.class)) {
            vertex = new Work ProductCell( (Work Product) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((Work Product) entity);
        }
        else

        if (entity.getClass().equals(CompositeWP.class)) {
            vertex = new CompositeWPCell( (CompositeWP) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((CompositeWP) entity);
        }
        else

        if (entity.getClass().equals(BehavioralWP.class)) {
            vertex = new BehavioralWPCell( (BehavioralWP) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((BehavioralWP) entity);
        }
        else

        if (entity.getClass().equals(StructuredWP.class)) {
            vertex = new StructuredWPCell( (StructuredWP) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((StructuredWP) entity);
        }
        else

        if (entity.getClass().equals(StructuralWP.class)) {
            vertex = new StructuralWPCell( (StructuralWP) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((StructuralWP) entity);
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
