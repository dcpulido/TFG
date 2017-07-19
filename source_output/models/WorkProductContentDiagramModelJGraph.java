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
import java.util.*;
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

public class WorkProductContentDiagramModelJGraph extends ModelJGraph {

  private Preferences prefs;

  public WorkProductContentDiagramModelJGraph(WorkProductContentDiagramDataEntity mde, 
                               String nombre, ObjectManager om, Model
                               m, BasicMarqueeHandler mh, Preferences prefs) {
    super(mde, nombre, m, mh,om);
    this.prefs=prefs;
    
             
                  this.getModel().addGraphModelListener(
                        new AUMLDiagramChangesManager(this));
                  ToolTipManager.sharedInstance().registerComponent(this);            
                  
        
    this.getGraphLayoutCache().setFactory(new ingenias.editor.cellfactories.WorkProductContentDiagram.CellViewFactory()());
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
            toolbar = new FilteredJToolBar("WorkProductContentDiagram");
            toolbar.setFloatable(false);
            ImageIcon undoIcon = null;
            JButton jb = null;
            Image img_DPDFSMMel =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_DPDFSMMel);
            Action DPDFSMMel=
            new AbstractAction("DPDFSMMel", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "DPDFSMMel");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            DPDFSMMel.setEnabled(true);
            jb = new JButton(DPDFSMMel);
            jb.setText("");
            jb.setName("DPDFSMMel");
            jb.setToolTipText("DPDFSMMel");
            toolbar.add(jb);

                        Image img_Relation =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_Relation);
            Action Relation=
            new AbstractAction("Relation", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "Relation");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            Relation.setEnabled(true);
            jb = new JButton(Relation);
            jb.setText("");
            jb.setName("Relation");
            jb.setToolTipText("Relation");
            toolbar.add(jb);

                        Image img_MetaElemento =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_MetaElemento);
            Action MetaElemento=
            new AbstractAction("MetaElemento", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "MetaElemento");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            MetaElemento.setEnabled(true);
            jb = new JButton(MetaElemento);
            jb.setText("");
            jb.setName("MetaElemento");
            jb.setToolTipText("MetaElemento");
            toolbar.add(jb);

                        Image img_Atributo =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_Atributo);
            Action Atributo=
            new AbstractAction("Atributo", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "Atributo");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            Atributo.setEnabled(true);
            jb = new JButton(Atributo);
            jb.setText("");
            jb.setName("Atributo");
            jb.setToolTipText("Atributo");
            toolbar.add(jb);

                        Image img_Operacion =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_Operacion);
            Action Operacion=
            new AbstractAction("Operacion", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "Operacion");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            Operacion.setEnabled(true);
            jb = new JButton(Operacion);
            jb.setText("");
            jb.setName("Operacion");
            jb.setToolTipText("Operacion");
            toolbar.add(jb);

            

        }
    }

  public static Vector<String> getAllowedRelationships(){
        Vector<String> relationships=new   Vector<String>();
        
        relationships.add("Quote Relationship");
        
                relationships.add("Extends");
        
                relationships.add("Quote");
        
                relationships.add("Relate");
        
                relationships.add("Define");
        
        
        
        
        return relationships;
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
                if (Quote RelationshipEdge.acceptConnection(this.getModel(), selected)) {
                    v.add("Quote Relationship");
                }

                // N-ary relationships. Sometimes they can be also binary.
                if (ExtendsEdge.acceptConnection(this.getModel(), selected)) {
                    v.add("Extends");
                }

                // N-ary relationships. Sometimes they can be also binary.
                if (QuoteEdge.acceptConnection(this.getModel(), selected)) {
                    v.add("Quote");
                }

                // N-ary relationships. Sometimes they can be also binary.
                if (RelateEdge.acceptConnection(this.getModel(), selected)) {
                    v.add("Relate");
                }

                // N-ary relationships. Sometimes they can be also binary.
                if (DefineEdge.acceptConnection(this.getModel(), selected)) {
                    v.add("Define");
                }       
            }
            else if (nAryEdgesNum == 1) {
if (selectedEdge instanceof Quote RelationshipEdge &&
                    (Quote RelationshipEdge.acceptConnection(this.getModel(), selected))) {
                    v.add("Quote Relationship");
                }
                
                if (selectedEdge instanceof ExtendsEdge &&
                    (ExtendsEdge.acceptConnection(this.getModel(), selected))) {
                    v.add("Extends");
                }
                
                if (selectedEdge instanceof QuoteEdge &&
                    (QuoteEdge.acceptConnection(this.getModel(), selected))) {
                    v.add("Quote");
                }
                
                if (selectedEdge instanceof RelateEdge &&
                    (RelateEdge.acceptConnection(this.getModel(), selected))) {
                    v.add("Relate");
                }
                
                if (selectedEdge instanceof DefineEdge &&
                    (DefineEdge.acceptConnection(this.getModel(), selected))) {
                    v.add("Define");
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
            
if (relacion.equalsIgnoreCase("Quote Relationship")) {
                // ResponsibleNEdge already exists.
                if (nAryEdgesNum == 1 && selectedEdge instanceof Quote RelationshipEdge) {
                    return selectedEdge;
                }
                // There is no NAryEdges in selected.
                else if (nAryEdgesNum == 0) {
                    return new Quote RelationshipEdge(new Quote Relationship(getMJGraph().getNewId()));
                }
            }
            
            if (relacion.equalsIgnoreCase("Extends")) {
                // ResponsibleNEdge already exists.
                if (nAryEdgesNum == 1 && selectedEdge instanceof ExtendsEdge) {
                    return selectedEdge;
                }
                // There is no NAryEdges in selected.
                else if (nAryEdgesNum == 0) {
                    return new ExtendsEdge(new Extends(getMJGraph().getNewId()));
                }
            }
            
            if (relacion.equalsIgnoreCase("Quote")) {
                // ResponsibleNEdge already exists.
                if (nAryEdgesNum == 1 && selectedEdge instanceof QuoteEdge) {
                    return selectedEdge;
                }
                // There is no NAryEdges in selected.
                else if (nAryEdgesNum == 0) {
                    return new QuoteEdge(new Quote(getMJGraph().getNewId()));
                }
            }
            
            if (relacion.equalsIgnoreCase("Relate")) {
                // ResponsibleNEdge already exists.
                if (nAryEdgesNum == 1 && selectedEdge instanceof RelateEdge) {
                    return selectedEdge;
                }
                // There is no NAryEdges in selected.
                else if (nAryEdgesNum == 0) {
                    return new RelateEdge(new Relate(getMJGraph().getNewId()));
                }
            }
            
            if (relacion.equalsIgnoreCase("Define")) {
                // ResponsibleNEdge already exists.
                if (nAryEdgesNum == 1 && selectedEdge instanceof DefineEdge) {
                    return selectedEdge;
                }
                // There is no NAryEdges in selected.
                else if (nAryEdgesNum == 0) {
                    return new DefineEdge(new Define(getMJGraph().getNewId()));
                }
            }
            
            
            
        }
        
        return null;
    }

  public DefaultGraphCell createCell(String entity) throws InvalidEntity{
if (entity.equalsIgnoreCase("DPDFSMMel")) {
            DPDFSMMel nentity=getOM().$createname(getMJGraph().getNewId("DPDFSMMel"));
            DefaultGraphCell vertex = new
            DPDFSMMelCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("Relation")) {
            Relation nentity=getOM().$createname(getMJGraph().getNewId("Relation"));
            DefaultGraphCell vertex = new
            RelationCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("MetaElemento")) {
            MetaElemento nentity=getOM().$createname(getMJGraph().getNewId("MetaElemento"));
            DefaultGraphCell vertex = new
            MetaElementoCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("Atributo")) {
            Atributo nentity=getOM().$createname(getMJGraph().getNewId("Atributo"));
            DefaultGraphCell vertex = new
            AtributoCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("Operacion")) {
            Operacion nentity=getOM().$createname(getMJGraph().getNewId("Operacion"));
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


  public synchronized JGraph cloneJGraph(IDEState ids){
        
        
        
        AgentModelModelJGraph jg=new  AgentModelModelJGraph(
                                                            (AgentModelDataEntity) this.mde,name, ids.om,
                                                            new Model(ids),new BasicMarqueeHandler(),ids.prefs); 
        
        this.setSelectionCells(getGraphLayoutCache().getCells(false,true,false,false));
        Action copyaction =new EventRedirectorForGraphCopy(this,this.getTransferHandler().getCopyAction(),null  );          
        Action pasteaction =new EventRedirectorPasteForGraphCopy(jg,jg.getTransferHandler().getPasteAction(),null   );
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
