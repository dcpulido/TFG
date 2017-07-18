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

    


  public String toString() {
    return this.getID();
  }

}