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
                  
        
    this.getGraphLayoutCache().setFactory(new ingenias.editor.cellfactories.PhaseDiagram.CellViewFactory()());
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
            toolbar = new FilteredJToolBar("PhaseDiagram");
            toolbar.setFloatable(false);
            ImageIcon undoIcon = null;
            JButton jb = null;
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

            

        }
    }

  public static Vector<String> getAllowedRelationships(){
        Vector<String> relationships=new   Vector<String>();
        
        relationships.add("Follows");
        
                relationships.add("Extends");
        
                relationships.add("Follows");
        
                relationships.add("Extends");
        
                relationships.add("Extends");
        
                relationships.add("Follows");
        
                relationships.add("Follows");
        
                relationships.add("Extends");
        
                relationships.add("Extends");
        
                relationships.add("Extends");
        
                relationships.add("Extends");
        
                relationships.add("Extends");
        
                relationships.add("Extends");
        
                relationships.add("Extends");
        
                relationships.add("Follows");
        
                relationships.add("Follows");
        
                relationships.add("Extends");
        
                relationships.add("Extends");
        
                relationships.add("Extends");
        
                relationships.add("Extends");
        
                relationships.add("Extends");
        
                relationships.add("Extends");
        
                relationships.add("Extends");
        
                relationships.add("Extends");
        
                relationships.add("Extends");
        
                relationships.add("Follows");
        
                relationships.add("Follows");
        
        
        
        
        return relationships;
    }

      public static Vector<String> getAllowedEntities(){
        Vector<String> entities=new   Vector<String>();

        entities.add("InitialNode");
        
                entities.add("Process");
        
                entities.add("Activity");
        
                entities.add("EndNode");
        
                entities.add("ActivityKind");
        
                entities.add("ForkNode");
        
                entities.add("InitialMetaNode");
        
                entities.add("JoinNode");
        
                entities.add("iPhase");
        
                entities.add("TerminalMetaNode");
        
                entities.add("DecissionNode");
        
                entities.add("Phase");
        
                
        
        
        return entities;
    }

  getPOssibleRelationships

    


  public String toString() {
    return this.getID();
  }

}
