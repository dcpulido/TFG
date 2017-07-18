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
        
                entities.add("DPDFSMMel");
        
                
        
        
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

    


  public String toString() {
    return this.getID();
  }

}
