
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

public class WorkProductContentDiagramPanel extends JGraph {

	public WorkProductContentDiagramPanel(WorkProductContentDiagramDataEntity mde,
								String nombre, Model
								m, BasicMarqueeHandler mh) {
		super(m, mh);

		this.getGraphLayoutCache().setFactory(new ingenias.editor.cellfactories.WorkProductContentDiagramCellViewFactory()());
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

        entities.add("DPDFSMMel");
        
                entities.add("Relation");
        
                entities.add("MetaElemento");
        
                entities.add("Atributo");
        
                entities.add("Operacion");
        
                
        
        
        return entities;
    }

public DefaultGraphCell createCell(String entity) throws InvalidEntity{
if (entity.equalsIgnoreCase("DPDFSMMel")) {
            DPDFSMMel nentity=new DPDFSMMel(((Model)getModel()).getNewId("DPDFSMMel"));
            DefaultGraphCell vertex = new
            DPDFSMMelCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("Relation")) {
            Relation nentity=new Relation(((Model)getModel()).getNewId("Relation"));
            DefaultGraphCell vertex = new
            RelationCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("MetaElemento")) {
            MetaElemento nentity=new MetaElemento(((Model)getModel()).getNewId("MetaElemento"));
            DefaultGraphCell vertex = new
            MetaElementoCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("Atributo")) {
            Atributo nentity=new Atributo(((Model)getModel()).getNewId("Atributo"));
            DefaultGraphCell vertex = new
            AtributoCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("Operacion")) {
            Operacion nentity=new Operacion(((Model)getModel()).getNewId("Operacion"));
            DefaultGraphCell vertex = new
            OperacionCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        
       throw new ingenias.exception.InvalidEntity("Entity type "+entity+" is not allowed in this diagram"); 
}

public Dimension getDefaultSize(Entity entity) throws InvalidEntity{
if (entity.getType().equalsIgnoreCase("DPDFSMMel")) {
            return DPDFSMMelView.getSize((DPDFSMMel)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("Relation")) {
            return RelationView.getSize((Relation)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("MetaElemento")) {
            return MetaElementoView.getSize((MetaElemento)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("Atributo")) {
            return AtributoView.getSize((Atributo)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("Operacion")) {
            return OperacionView.getSize((Operacion)entity);      
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
        
        
if (entity.getClass().equals(DPDFSMMel.class)) {
            vertex = new DPDFSMMelCell( (DPDFSMMel) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((DPDFSMMel) entity);
        }
        else

        if (entity.getClass().equals(Relation.class)) {
            vertex = new RelationCell( (Relation) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((Relation) entity);
        }
        else

        if (entity.getClass().equals(MetaElemento.class)) {
            vertex = new MetaElementoCell( (MetaElemento) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((MetaElemento) entity);
        }
        else

        if (entity.getClass().equals(Atributo.class)) {
            vertex = new AtributoCell( (Atributo) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((Atributo) entity);
        }
        else

        if (entity.getClass().equals(Operacion.class)) {
            vertex = new OperacionCell( (Operacion) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((Operacion) entity);
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
