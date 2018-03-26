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

public class WorkProductDiagramModelJGraph extends ModelJGraph {

  private Preferences prefs;

  public WorkProductDiagramModelJGraph(WorkProductDiagramDataEntity mde, 
                               String nombre, ObjectManager om, Model
                               m, BasicMarqueeHandler mh, Preferences prefs) {
    super(mde, nombre, m, mh,om);
    this.prefs=prefs;
    
             
                  this.getModel().addGraphModelListener(
                        new AUMLDiagramChangesManager(this));
                  ToolTipManager.sharedInstance().registerComponent(this);            
                  
        
    this.getGraphLayoutCache().setFactory(new ingenias.editor.cellfactories.WorkProductDiagram.CellViewFactory());
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
            toolbar = new FilteredJToolBar("WorkProductDiagramDataEntity");
            toolbar.setFloatable(false);
            ImageIcon undoIcon = null;
            JButton jb = null;
            Image img_WorkProduct =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_WorkProduct);
            Action WorkProduct=
            new AbstractAction("WorkProduct", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "WorkProduct");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            WorkProduct.setEnabled(true);
            jb = new JButton(WorkProduct);
            jb.setText("");
            jb.setName("WorkProduct");
            jb.setToolTipText("WorkProduct");
            toolbar.add(jb);

                        Image img_StructuralWP =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_StructuralWP);
            Action StructuralWP=
            new AbstractAction("StructuralWP", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "StructuralWP");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            StructuralWP.setEnabled(true);
            jb = new JButton(StructuralWP);
            jb.setText("");
            jb.setName("StructuralWP");
            jb.setToolTipText("StructuralWP");
            toolbar.add(jb);

                        Image img_BehaviourWP =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_BehaviourWP);
            Action BehaviourWP=
            new AbstractAction("BehaviourWP", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "BehaviourWP");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            BehaviourWP.setEnabled(true);
            jb = new JButton(BehaviourWP);
            jb.setText("");
            jb.setName("BehaviourWP");
            jb.setToolTipText("BehaviourWP");
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

                        Image img_DPDFSMMat =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_DPDFSMMat);
            Action DPDFSMMat=
            new AbstractAction("DPDFSMMat", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "DPDFSMMat");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            DPDFSMMat.setEnabled(true);
            jb = new JButton(DPDFSMMat);
            jb.setText("");
            jb.setName("DPDFSMMat");
            jb.setToolTipText("DPDFSMMat");
            toolbar.add(jb);

                        Image img_FreeWP =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_FreeWP);
            Action FreeWP=
            new AbstractAction("FreeWP", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "FreeWP");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            FreeWP.setEnabled(true);
            jb = new JButton(FreeWP);
            jb.setText("");
            jb.setName("FreeWP");
            jb.setToolTipText("FreeWP");
            toolbar.add(jb);

                        Image img_CompositeWP =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_CompositeWP);
            Action CompositeWP=
            new AbstractAction("CompositeWP", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "CompositeWP");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            CompositeWP.setEnabled(true);
            jb = new JButton(CompositeWP);
            jb.setText("");
            jb.setName("CompositeWP");
            jb.setToolTipText("CompositeWP");
            toolbar.add(jb);

                        Image img_StructuredWP =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_StructuredWP);
            Action StructuredWP=
            new AbstractAction("StructuredWP", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "StructuredWP");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            StructuredWP.setEnabled(true);
            jb = new JButton(StructuredWP);
            jb.setText("");
            jb.setName("StructuredWP");
            jb.setToolTipText("StructuredWP");
            toolbar.add(jb);

                        Image img_DPDFS =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_DPDFS);
            Action DPDFS=
            new AbstractAction("DPDFS", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "DPDFS");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            DPDFS.setEnabled(true);
            jb = new JButton(DPDFS);
            jb.setText("");
            jb.setName("DPDFS");
            jb.setToolTipText("DPDFS");
            toolbar.add(jb);

                        Image img_DPDFSMMop =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_DPDFSMMop);
            Action DPDFSMMop=
            new AbstractAction("DPDFSMMop", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "DPDFSMMop");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            DPDFSMMop.setEnabled(true);
            jb = new JButton(DPDFSMMop);
            jb.setText("");
            jb.setName("DPDFSMMop");
            jb.setToolTipText("DPDFSMMop");
            toolbar.add(jb);

            

        }
    }

  public static Vector<String> getAllowedRelationships(){
        Vector<String> relationships=new   Vector<String>();
        
        relationships.add("WPContains");
        
                relationships.add("none");
        
                relationships.add("QQ");
        
                relationships.add("relates");
        
                relationships.add("QR");
        
                relationships.add("QD");
        
                relationships.add("Extends");
        
                relationships.add("defines");
        
                relationships.add("quotes");
        
        
        
        
        return relationships;
    }

      public static Vector<String> getAllowedEntities(){
        Vector<String> entities=new   Vector<String>();

        entities.add("WorkProduct");
        
                entities.add("StructuralWP");
        
                entities.add("BehaviourWP");
        
                entities.add("DPDFSMMel");
        
                entities.add("DPDFSMMat");
        
                entities.add("FreeWP");
        
                entities.add("CompositeWP");
        
                entities.add("StructuredWP");
        
                entities.add("DPDFS");
        
                entities.add("DPDFSMMop");
        
                
        
        
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
                if (WPContainsEdge.acceptConnection(this.getModel(), selected)) {
                    v.add("WPContains");
                }

                // N-ary relationships. Sometimes they can be also binary.
                if (noneEdge.acceptConnection(this.getModel(), selected)) {
                    v.add("none");
                }

                // N-ary relationships. Sometimes they can be also binary.
                if (QQEdge.acceptConnection(this.getModel(), selected)) {
                    v.add("QQ");
                }

                // N-ary relationships. Sometimes they can be also binary.
                if (relatesEdge.acceptConnection(this.getModel(), selected)) {
                    v.add("relates");
                }

                // N-ary relationships. Sometimes they can be also binary.
                if (QREdge.acceptConnection(this.getModel(), selected)) {
                    v.add("QR");
                }

                // N-ary relationships. Sometimes they can be also binary.
                if (QDEdge.acceptConnection(this.getModel(), selected)) {
                    v.add("QD");
                }

                // N-ary relationships. Sometimes they can be also binary.
                if (ExtendsEdge.acceptConnection(this.getModel(), selected)) {
                    v.add("Extends");
                }

                // N-ary relationships. Sometimes they can be also binary.
                if (definesEdge.acceptConnection(this.getModel(), selected)) {
                    v.add("defines");
                }

                // N-ary relationships. Sometimes they can be also binary.
                if (quotesEdge.acceptConnection(this.getModel(), selected)) {
                    v.add("quotes");
                }       
            }
            else if (nAryEdgesNum == 1) {
if (selectedEdge instanceof WPContainsEdge &&
                    (WPContainsEdge.acceptConnection(this.getModel(), selected))) {
                    v.add("WPContains");
                }
                
                if (selectedEdge instanceof noneEdge &&
                    (noneEdge.acceptConnection(this.getModel(), selected))) {
                    v.add("none");
                }
                
                if (selectedEdge instanceof QQEdge &&
                    (QQEdge.acceptConnection(this.getModel(), selected))) {
                    v.add("QQ");
                }
                
                if (selectedEdge instanceof relatesEdge &&
                    (relatesEdge.acceptConnection(this.getModel(), selected))) {
                    v.add("relates");
                }
                
                if (selectedEdge instanceof QREdge &&
                    (QREdge.acceptConnection(this.getModel(), selected))) {
                    v.add("QR");
                }
                
                if (selectedEdge instanceof QDEdge &&
                    (QDEdge.acceptConnection(this.getModel(), selected))) {
                    v.add("QD");
                }
                
                if (selectedEdge instanceof ExtendsEdge &&
                    (ExtendsEdge.acceptConnection(this.getModel(), selected))) {
                    v.add("Extends");
                }
                
                if (selectedEdge instanceof definesEdge &&
                    (definesEdge.acceptConnection(this.getModel(), selected))) {
                    v.add("defines");
                }
                
                if (selectedEdge instanceof quotesEdge &&
                    (quotesEdge.acceptConnection(this.getModel(), selected))) {
                    v.add("quotes");
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
            
if (relacion.equalsIgnoreCase("WPContains")) {
                // ResponsibleNEdge already exists.
                if (nAryEdgesNum == 1 && selectedEdge instanceof WPContainsEdge) {
                    return selectedEdge;
                }
                // There is no NAryEdges in selected.
                else if (nAryEdgesNum == 0) {
                    return new WPContainsEdge(new WPContains(getMJGraph().getNewId()));
                }
            }
            
            if (relacion.equalsIgnoreCase("none")) {
                // ResponsibleNEdge already exists.
                if (nAryEdgesNum == 1 && selectedEdge instanceof noneEdge) {
                    return selectedEdge;
                }
                // There is no NAryEdges in selected.
                else if (nAryEdgesNum == 0) {
                    return new noneEdge(new none(getMJGraph().getNewId()));
                }
            }
            
            if (relacion.equalsIgnoreCase("QQ")) {
                // ResponsibleNEdge already exists.
                if (nAryEdgesNum == 1 && selectedEdge instanceof QQEdge) {
                    return selectedEdge;
                }
                // There is no NAryEdges in selected.
                else if (nAryEdgesNum == 0) {
                    return new QQEdge(new QQ(getMJGraph().getNewId()));
                }
            }
            
            if (relacion.equalsIgnoreCase("relates")) {
                // ResponsibleNEdge already exists.
                if (nAryEdgesNum == 1 && selectedEdge instanceof relatesEdge) {
                    return selectedEdge;
                }
                // There is no NAryEdges in selected.
                else if (nAryEdgesNum == 0) {
                    return new relatesEdge(new relates(getMJGraph().getNewId()));
                }
            }
            
            if (relacion.equalsIgnoreCase("QR")) {
                // ResponsibleNEdge already exists.
                if (nAryEdgesNum == 1 && selectedEdge instanceof QREdge) {
                    return selectedEdge;
                }
                // There is no NAryEdges in selected.
                else if (nAryEdgesNum == 0) {
                    return new QREdge(new QR(getMJGraph().getNewId()));
                }
            }
            
            if (relacion.equalsIgnoreCase("QD")) {
                // ResponsibleNEdge already exists.
                if (nAryEdgesNum == 1 && selectedEdge instanceof QDEdge) {
                    return selectedEdge;
                }
                // There is no NAryEdges in selected.
                else if (nAryEdgesNum == 0) {
                    return new QDEdge(new QD(getMJGraph().getNewId()));
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
            
            if (relacion.equalsIgnoreCase("defines")) {
                // ResponsibleNEdge already exists.
                if (nAryEdgesNum == 1 && selectedEdge instanceof definesEdge) {
                    return selectedEdge;
                }
                // There is no NAryEdges in selected.
                else if (nAryEdgesNum == 0) {
                    return new definesEdge(new defines(getMJGraph().getNewId()));
                }
            }
            
            if (relacion.equalsIgnoreCase("quotes")) {
                // ResponsibleNEdge already exists.
                if (nAryEdgesNum == 1 && selectedEdge instanceof quotesEdge) {
                    return selectedEdge;
                }
                // There is no NAryEdges in selected.
                else if (nAryEdgesNum == 0) {
                    return new quotesEdge(new quotes(getMJGraph().getNewId()));
                }
            }
            
            
            
        }
        
        return null;
    }

  public DefaultGraphCell createCell(String entity) throws InvalidEntity{
if (entity.equalsIgnoreCase("WorkProduct")) {
            WorkProduct nentity=getOM().createWorkProduct(getMJGraph().getNewId("WorkProduct"));
            DefaultGraphCell vertex = new
            WorkProductCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("StructuralWP")) {
            StructuralWP nentity=getOM().createStructuralWP(getMJGraph().getNewId("StructuralWP"));
            DefaultGraphCell vertex = new
            StructuralWPCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("BehaviourWP")) {
            BehaviourWP nentity=getOM().createBehaviourWP(getMJGraph().getNewId("BehaviourWP"));
            DefaultGraphCell vertex = new
            BehaviourWPCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("DPDFSMMel")) {
            DPDFSMMel nentity=getOM().createDPDFSMMel(getMJGraph().getNewId("DPDFSMMel"));
            DefaultGraphCell vertex = new
            DPDFSMMelCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("DPDFSMMat")) {
            DPDFSMMat nentity=getOM().createDPDFSMMat(getMJGraph().getNewId("DPDFSMMat"));
            DefaultGraphCell vertex = new
            DPDFSMMatCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("FreeWP")) {
            FreeWP nentity=getOM().createFreeWP(getMJGraph().getNewId("FreeWP"));
            DefaultGraphCell vertex = new
            FreeWPCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("CompositeWP")) {
            CompositeWP nentity=getOM().createCompositeWP(getMJGraph().getNewId("CompositeWP"));
            DefaultGraphCell vertex = new
            CompositeWPCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("StructuredWP")) {
            StructuredWP nentity=getOM().createStructuredWP(getMJGraph().getNewId("StructuredWP"));
            DefaultGraphCell vertex = new
            StructuredWPCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("DPDFS")) {
            DPDFS nentity=getOM().createDPDFS(getMJGraph().getNewId("DPDFS"));
            DefaultGraphCell vertex = new
            DPDFSCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("DPDFSMMop")) {
            DPDFSMMop nentity=getOM().createDPDFSMMop(getMJGraph().getNewId("DPDFSMMop"));
            DefaultGraphCell vertex = new
            DPDFSMMopCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        
       throw new ingenias.exception.InvalidEntity("Entity type "+entity+" is not allowed in this diagram"); 
}

  public Dimension getDefaultSize(Entity entity) throws InvalidEntity{
if (entity.getType().equalsIgnoreCase("WorkProduct")) {
            return WorkProductView.getSize((WorkProduct)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("StructuralWP")) {
            return StructuralWPView.getSize((StructuralWP)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("BehaviourWP")) {
            return BehaviourWPView.getSize((BehaviourWP)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("DPDFSMMel")) {
            return DPDFSMMelView.getSize((DPDFSMMel)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("DPDFSMMat")) {
            return DPDFSMMatView.getSize((DPDFSMMat)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("FreeWP")) {
            return FreeWPView.getSize((FreeWP)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("CompositeWP")) {
            return CompositeWPView.getSize((CompositeWP)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("StructuredWP")) {
            return StructuredWPView.getSize((StructuredWP)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("DPDFS")) {
            return DPDFSView.getSize((DPDFS)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("DPDFSMMop")) {
            return DPDFSMMopView.getSize((DPDFSMMop)entity);      
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
        
        
if (entity.getClass().equals(WorkProduct.class)) {
            vertex = new WorkProductCell( (WorkProduct) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((WorkProduct) entity);
        }
        else

        if (entity.getClass().equals(StructuralWP.class)) {
            vertex = new StructuralWPCell( (StructuralWP) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((StructuralWP) entity);
        }
        else

        if (entity.getClass().equals(BehaviourWP.class)) {
            vertex = new BehaviourWPCell( (BehaviourWP) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((BehaviourWP) entity);
        }
        else

        if (entity.getClass().equals(DPDFSMMel.class)) {
            vertex = new DPDFSMMelCell( (DPDFSMMel) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((DPDFSMMel) entity);
        }
        else

        if (entity.getClass().equals(DPDFSMMat.class)) {
            vertex = new DPDFSMMatCell( (DPDFSMMat) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((DPDFSMMat) entity);
        }
        else

        if (entity.getClass().equals(FreeWP.class)) {
            vertex = new FreeWPCell( (FreeWP) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((FreeWP) entity);
        }
        else

        if (entity.getClass().equals(CompositeWP.class)) {
            vertex = new CompositeWPCell( (CompositeWP) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((CompositeWP) entity);
        }
        else

        if (entity.getClass().equals(StructuredWP.class)) {
            vertex = new StructuredWPCell( (StructuredWP) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((StructuredWP) entity);
        }
        else

        if (entity.getClass().equals(DPDFS.class)) {
            vertex = new DPDFSCell( (DPDFS) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((DPDFS) entity);
        }
        else

        if (entity.getClass().equals(DPDFSMMop.class)) {
            vertex = new DPDFSMMopCell( (DPDFSMMop) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((DPDFSMMop) entity);
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
