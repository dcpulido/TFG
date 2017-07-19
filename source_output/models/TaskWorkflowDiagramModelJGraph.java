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

public class TaskWorkflowDiagramModelJGraph extends ModelJGraph {

  private Preferences prefs;

  public TaskWorkflowDiagramModelJGraph(TaskWorkflowDiagramDataEntity mde, 
                               String nombre, ObjectManager om, Model
                               m, BasicMarqueeHandler mh, Preferences prefs) {
    super(mde, nombre, m, mh,om);
    this.prefs=prefs;
    
             
                  this.getModel().addGraphModelListener(
                        new AUMLDiagramChangesManager(this));
                  ToolTipManager.sharedInstance().registerComponent(this);            
                  
        
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





  public JToolBar getPaleta() {
    return toolbar;

  }

   protected void creaToolBar() {
        if (toolbar==null){
            toolbar = new FilteredJToolBar("TaskWorkflowDiagram");
            toolbar.setFloatable(false);
            ImageIcon undoIcon = null;
            JButton jb = null;
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

                        Image img_InitialMetaNode =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_InitialMetaNode);
            Action InitialMetaNode=
            new AbstractAction("InitialMetaNode", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "InitialMetaNode");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            InitialMetaNode.setEnabled(true);
            jb = new JButton(InitialMetaNode);
            jb.setText("");
            jb.setName("InitialMetaNode");
            jb.setToolTipText("InitialMetaNode");
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

                        Image img_ForkNode =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_ForkNode);
            Action ForkNode=
            new AbstractAction("ForkNode", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "ForkNode");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            ForkNode.setEnabled(true);
            jb = new JButton(ForkNode);
            jb.setText("");
            jb.setName("ForkNode");
            jb.setToolTipText("ForkNode");
            toolbar.add(jb);

                        Image img_WPProduced =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_WPProduced);
            Action WPProduced=
            new AbstractAction("WPProduced", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "WPProduced");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            WPProduced.setEnabled(true);
            jb = new JButton(WPProduced);
            jb.setText("");
            jb.setName("WPProduced");
            jb.setToolTipText("WPProduced");
            toolbar.add(jb);

                        Image img_BehavioralWP =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_BehavioralWP);
            Action BehavioralWP=
            new AbstractAction("BehavioralWP", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "BehavioralWP");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            BehavioralWP.setEnabled(true);
            jb = new JButton(BehavioralWP);
            jb.setText("");
            jb.setName("BehavioralWP");
            jb.setToolTipText("BehavioralWP");
            toolbar.add(jb);

                        Image img_EndNode =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_EndNode);
            Action EndNode=
            new AbstractAction("EndNode", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "EndNode");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            EndNode.setEnabled(true);
            jb = new JButton(EndNode);
            jb.setText("");
            jb.setName("EndNode");
            jb.setToolTipText("EndNode");
            toolbar.add(jb);

                        Image img_WFConsumed =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_WFConsumed);
            Action WFConsumed=
            new AbstractAction("WFConsumed", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "WFConsumed");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            WFConsumed.setEnabled(true);
            jb = new JButton(WFConsumed);
            jb.setText("");
            jb.setName("WFConsumed");
            jb.setToolTipText("WFConsumed");
            toolbar.add(jb);

                        Image img_TerminalMetaNode =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_TerminalMetaNode);
            Action TerminalMetaNode=
            new AbstractAction("TerminalMetaNode", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "TerminalMetaNode");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            TerminalMetaNode.setEnabled(true);
            jb = new JButton(TerminalMetaNode);
            jb.setText("");
            jb.setName("TerminalMetaNode");
            jb.setToolTipText("TerminalMetaNode");
            toolbar.add(jb);

                        Image img_Task =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_Task);
            Action Task=
            new AbstractAction("Task", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "Task");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            Task.setEnabled(true);
            jb = new JButton(Task);
            jb.setText("");
            jb.setName("Task");
            jb.setToolTipText("Task");
            toolbar.add(jb);

                        Image img_Role =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_Role);
            Action Role=
            new AbstractAction("Role", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "Role");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            Role.setEnabled(true);
            jb = new JButton(Role);
            jb.setText("");
            jb.setName("Role");
            jb.setToolTipText("Role");
            toolbar.add(jb);

                        Image img_InitialNode =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_InitialNode);
            Action InitialNode=
            new AbstractAction("InitialNode", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "InitialNode");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            InitialNode.setEnabled(true);
            jb = new JButton(InitialNode);
            jb.setText("");
            jb.setName("InitialNode");
            jb.setToolTipText("InitialNode");
            toolbar.add(jb);

                        Image img_ActivityKind =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_ActivityKind);
            Action ActivityKind=
            new AbstractAction("ActivityKind", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "ActivityKind");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            ActivityKind.setEnabled(true);
            jb = new JButton(ActivityKind);
            jb.setText("");
            jb.setName("ActivityKind");
            jb.setToolTipText("ActivityKind");
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

                        Image img_DecissionNode =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_DecissionNode);
            Action DecissionNode=
            new AbstractAction("DecissionNode", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "DecissionNode");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            DecissionNode.setEnabled(true);
            jb = new JButton(DecissionNode);
            jb.setText("");
            jb.setName("DecissionNode");
            jb.setToolTipText("DecissionNode");
            toolbar.add(jb);

                        Image img_JoinNode =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_JoinNode);
            Action JoinNode=
            new AbstractAction("JoinNode", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "JoinNode");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            JoinNode.setEnabled(true);
            jb = new JButton(JoinNode);
            jb.setText("");
            jb.setName("JoinNode");
            jb.setToolTipText("JoinNode");
            toolbar.add(jb);

            

        }
    }

  public static Vector<String> getAllowedRelationships(){
        Vector<String> relationships=new   Vector<String>();
        
        relationships.add("Extends");
        
                relationships.add("Follows");
        
                relationships.add("WFResponsible");
        
                relationships.add("WFConsumes");
        
                relationships.add("WFProduces");
        
        
        
        
        return relationships;
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
                if (ExtendsEdge.acceptConnection(this.getModel(), selected)) {
                    v.add("Extends");
                }

                // N-ary relationships. Sometimes they can be also binary.
                if (FollowsEdge.acceptConnection(this.getModel(), selected)) {
                    v.add("Follows");
                }

                // N-ary relationships. Sometimes they can be also binary.
                if (WFResponsibleEdge.acceptConnection(this.getModel(), selected)) {
                    v.add("WFResponsible");
                }

                // N-ary relationships. Sometimes they can be also binary.
                if (WFConsumesEdge.acceptConnection(this.getModel(), selected)) {
                    v.add("WFConsumes");
                }

                // N-ary relationships. Sometimes they can be also binary.
                if (WFProducesEdge.acceptConnection(this.getModel(), selected)) {
                    v.add("WFProduces");
                }       
            }
            else if (nAryEdgesNum == 1) {
if (selectedEdge instanceof ExtendsEdge &&
                    (ExtendsEdge.acceptConnection(this.getModel(), selected))) {
                    v.add("Extends");
                }
                
                if (selectedEdge instanceof FollowsEdge &&
                    (FollowsEdge.acceptConnection(this.getModel(), selected))) {
                    v.add("Follows");
                }
                
                if (selectedEdge instanceof WFResponsibleEdge &&
                    (WFResponsibleEdge.acceptConnection(this.getModel(), selected))) {
                    v.add("WFResponsible");
                }
                
                if (selectedEdge instanceof WFConsumesEdge &&
                    (WFConsumesEdge.acceptConnection(this.getModel(), selected))) {
                    v.add("WFConsumes");
                }
                
                if (selectedEdge instanceof WFProducesEdge &&
                    (WFProducesEdge.acceptConnection(this.getModel(), selected))) {
                    v.add("WFProduces");
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
            
            if (relacion.equalsIgnoreCase("Follows")) {
                // ResponsibleNEdge already exists.
                if (nAryEdgesNum == 1 && selectedEdge instanceof FollowsEdge) {
                    return selectedEdge;
                }
                // There is no NAryEdges in selected.
                else if (nAryEdgesNum == 0) {
                    return new FollowsEdge(new Follows(getMJGraph().getNewId()));
                }
            }
            
            if (relacion.equalsIgnoreCase("WFResponsible")) {
                // ResponsibleNEdge already exists.
                if (nAryEdgesNum == 1 && selectedEdge instanceof WFResponsibleEdge) {
                    return selectedEdge;
                }
                // There is no NAryEdges in selected.
                else if (nAryEdgesNum == 0) {
                    return new WFResponsibleEdge(new WFResponsible(getMJGraph().getNewId()));
                }
            }
            
            if (relacion.equalsIgnoreCase("WFConsumes")) {
                // ResponsibleNEdge already exists.
                if (nAryEdgesNum == 1 && selectedEdge instanceof WFConsumesEdge) {
                    return selectedEdge;
                }
                // There is no NAryEdges in selected.
                else if (nAryEdgesNum == 0) {
                    return new WFConsumesEdge(new WFConsumes(getMJGraph().getNewId()));
                }
            }
            
            if (relacion.equalsIgnoreCase("WFProduces")) {
                // ResponsibleNEdge already exists.
                if (nAryEdgesNum == 1 && selectedEdge instanceof WFProducesEdge) {
                    return selectedEdge;
                }
                // There is no NAryEdges in selected.
                else if (nAryEdgesNum == 0) {
                    return new WFProducesEdge(new WFProduces(getMJGraph().getNewId()));
                }
            }
            
            
            
        }
        
        return null;
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
