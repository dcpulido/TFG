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

public class PhaseDiagramModelJGraph extends ModelJGraph {

  private Preferences prefs;

  public PhaseDiagramModelJGraph(PhaseDiagramDataEntity mde, 
                               String nombre, ObjectManager om, Model
                               m, BasicMarqueeHandler mh, Preferences prefs) {
    super(mde, nombre, m, mh,om);
    this.prefs=prefs;
    
             
                  this.getModel().addGraphModelListener(
                        new AUMLDiagramChangesManager(this));
                  ToolTipManager.sharedInstance().registerComponent(this);            
                  
        
    this.getGraphLayoutCache().setFactory(new ingenias.editor.cellfactories.PhaseDiagram.CellViewFactory());
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
            toolbar = new FilteredJToolBar("PhaseDiagramDataEntity");
            toolbar.setFloatable(false);
            ImageIcon undoIcon = null;
            JButton jb = null;
            Image img_Node =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_Node);
            Action Node=
            new AbstractAction("Node", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "Node");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            Node.setEnabled(true);
            jb = new JButton(Node);
            jb.setText("");
            jb.setName("Node");
            jb.setToolTipText("Node");
            toolbar.add(jb);

                        Image img_DecisionNode =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_DecisionNode);
            Action DecisionNode=
            new AbstractAction("DecisionNode", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "DecisionNode");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            DecisionNode.setEnabled(true);
            jb = new JButton(DecisionNode);
            jb.setText("");
            jb.setName("DecisionNode");
            jb.setToolTipText("DecisionNode");
            toolbar.add(jb);

                        Image img_Process =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_Process);
            Action Process=
            new AbstractAction("Process", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "Process");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            Process.setEnabled(true);
            jb = new JButton(Process);
            jb.setText("");
            jb.setName("Process");
            jb.setToolTipText("Process");
            toolbar.add(jb);

                        Image img_Phase =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_Phase);
            Action Phase=
            new AbstractAction("Phase", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "Phase");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            Phase.setEnabled(true);
            jb = new JButton(Phase);
            jb.setText("");
            jb.setName("Phase");
            jb.setToolTipText("Phase");
            toolbar.add(jb);

                        Image img_Activity =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_Activity);
            Action Activity=
            new AbstractAction("Activity", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "Activity");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            Activity.setEnabled(true);
            jb = new JButton(Activity);
            jb.setText("");
            jb.setName("Activity");
            jb.setToolTipText("Activity");
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

                        Image img_iPhase =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_iPhase);
            Action iPhase=
            new AbstractAction("iPhase", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "iPhase");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            iPhase.setEnabled(true);
            jb = new JButton(iPhase);
            jb.setText("");
            jb.setName("iPhase");
            jb.setToolTipText("iPhase");
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
        
        relationships.add("FollowsGuarded");
        
                relationships.add("Extends");
        
                relationships.add("Follows");
        
        
        
        
        return relationships;
    }

      public static Vector<String> getAllowedEntities(){
        Vector<String> entities=new   Vector<String>();

        entities.add("Node");
        
                entities.add("DecisionNode");
        
                entities.add("Process");
        
                entities.add("Phase");
        
                entities.add("Activity");
        
                entities.add("InitialNode");
        
                entities.add("iPhase");
        
                entities.add("ForkNode");
        
                entities.add("EndNode");
        
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
                if (FollowsGuardedEdge.acceptConnection(this.getModel(), selected)) {
                    v.add("FollowsGuarded");
                }

                // N-ary relationships. Sometimes they can be also binary.
                if (ExtendsEdge.acceptConnection(this.getModel(), selected)) {
                    v.add("Extends");
                }

                // N-ary relationships. Sometimes they can be also binary.
                if (FollowsEdge.acceptConnection(this.getModel(), selected)) {
                    v.add("Follows");
                }       
            }
            else if (nAryEdgesNum == 1) {
if (selectedEdge instanceof FollowsGuardedEdge &&
                    (FollowsGuardedEdge.acceptConnection(this.getModel(), selected))) {
                    v.add("FollowsGuarded");
                }
                
                if (selectedEdge instanceof ExtendsEdge &&
                    (ExtendsEdge.acceptConnection(this.getModel(), selected))) {
                    v.add("Extends");
                }
                
                if (selectedEdge instanceof FollowsEdge &&
                    (FollowsEdge.acceptConnection(this.getModel(), selected))) {
                    v.add("Follows");
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
            
if (relacion.equalsIgnoreCase("FollowsGuarded")) {
                // ResponsibleNEdge already exists.
                if (nAryEdgesNum == 1 && selectedEdge instanceof FollowsGuardedEdge) {
                    return selectedEdge;
                }
                // There is no NAryEdges in selected.
                else if (nAryEdgesNum == 0) {
                    return new FollowsGuardedEdge(new FollowsGuarded(getMJGraph().getNewId()));
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
            
            
            
        }
        
        return null;
    }

  public DefaultGraphCell createCell(String entity) throws InvalidEntity{
if (entity.equalsIgnoreCase("Node")) {
            Node nentity=getOM().createNode(getMJGraph().getNewId("Node"));
            DefaultGraphCell vertex = new
            NodeCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("DecisionNode")) {
            DecisionNode nentity=getOM().createDecisionNode(getMJGraph().getNewId("DecisionNode"));
            DefaultGraphCell vertex = new
            DecisionNodeCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("Process")) {
            Process nentity=getOM().createProcess(getMJGraph().getNewId("Process"));
            DefaultGraphCell vertex = new
            ProcessCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("Phase")) {
            Phase nentity=getOM().createPhase(getMJGraph().getNewId("Phase"));
            DefaultGraphCell vertex = new
            PhaseCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("Activity")) {
            Activity nentity=getOM().createActivity(getMJGraph().getNewId("Activity"));
            DefaultGraphCell vertex = new
            ActivityCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("InitialNode")) {
            InitialNode nentity=getOM().createInitialNode(getMJGraph().getNewId("InitialNode"));
            DefaultGraphCell vertex = new
            InitialNodeCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("iPhase")) {
            iPhase nentity=getOM().createiPhase(getMJGraph().getNewId("iPhase"));
            DefaultGraphCell vertex = new
            iPhaseCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("ForkNode")) {
            ForkNode nentity=getOM().createForkNode(getMJGraph().getNewId("ForkNode"));
            DefaultGraphCell vertex = new
            ForkNodeCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("EndNode")) {
            EndNode nentity=getOM().createEndNode(getMJGraph().getNewId("EndNode"));
            DefaultGraphCell vertex = new
            EndNodeCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        if (entity.equalsIgnoreCase("JoinNode")) {
            JoinNode nentity=getOM().createJoinNode(getMJGraph().getNewId("JoinNode"));
            DefaultGraphCell vertex = new
            JoinNodeCell(nentity);
            // Default Size for the cell with the new entity
            return vertex;
        }
        else

        
       throw new ingenias.exception.InvalidEntity("Entity type "+entity+" is not allowed in this diagram"); 
}

  public Dimension getDefaultSize(Entity entity) throws InvalidEntity{
if (entity.getType().equalsIgnoreCase("Node")) {
            return NodeView.getSize((Node)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("DecisionNode")) {
            return DecisionNodeView.getSize((DecisionNode)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("Process")) {
            return ProcessView.getSize((Process)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("Phase")) {
            return PhaseView.getSize((Phase)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("Activity")) {
            return ActivityView.getSize((Activity)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("InitialNode")) {
            return InitialNodeView.getSize((InitialNode)entity);      
        }
        else

        if (entity.getType().equalsIgnoreCase("iPhase")) {
            return iPhaseView.getSize((iPhase)entity);      
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
        
        
if (entity.getClass().equals(Node.class)) {
            vertex = new NodeCell( (Node) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((Node) entity);
        }
        else

        if (entity.getClass().equals(DecisionNode.class)) {
            vertex = new DecisionNodeCell( (DecisionNode) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((DecisionNode) entity);
        }
        else

        if (entity.getClass().equals(Process.class)) {
            vertex = new ProcessCell( (Process) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((Process) entity);
        }
        else

        if (entity.getClass().equals(Phase.class)) {
            vertex = new PhaseCell( (Phase) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((Phase) entity);
        }
        else

        if (entity.getClass().equals(Activity.class)) {
            vertex = new ActivityCell( (Activity) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((Activity) entity);
        }
        else

        if (entity.getClass().equals(InitialNode.class)) {
            vertex = new InitialNodeCell( (InitialNode) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((InitialNode) entity);
        }
        else

        if (entity.getClass().equals(iPhase.class)) {
            vertex = new iPhaseCell( (iPhase) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((iPhase) entity);
        }
        else

        if (entity.getClass().equals(ForkNode.class)) {
            vertex = new ForkNodeCell( (ForkNode) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((ForkNode) entity);
        }
        else

        if (entity.getClass().equals(EndNode.class)) {
            vertex = new EndNodeCell( (EndNode) entity);
            // Default Size for the new Vertex with the new entity within
            size = AgentView.getSize((EndNode) entity);
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
