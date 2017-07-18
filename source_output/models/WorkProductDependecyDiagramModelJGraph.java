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

public class WorkProductDependecyDiagramModelJGraph extends ModelJGraph {

  private Preferences prefs;

  public WorkProductDependecyDiagramModelJGraph(WorkProductDependecyDiagramDataEntity mde, 
                               String nombre, ObjectManager om, Model
                               m, BasicMarqueeHandler mh, Preferences prefs) {
    super(mde, nombre, m, mh,om);
    this.prefs=prefs;
    
             
                  this.getModel().addGraphModelListener(
                        new AUMLDiagramChangesManager(this));
                  ToolTipManager.sharedInstance().registerComponent(this);            
                  
        
    this.getGraphLayoutCache().setFactory(new ingenias.editor.cellfactories.WorkProductDependecyDiagram.CellViewFactory()());
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
            toolbar = new FilteredJToolBar("WorkProductDependecyDiagram");
            toolbar.setFloatable(false);
            ImageIcon undoIcon = null;
            JButton jb = null;
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

                        Image img_Work Product =
            ImageLoader.getImage("");
            undoIcon = new ImageIcon(img_Work Product);
            Action Work Product=
            new AbstractAction("Work Product", undoIcon) {
                public void actionPerformed(ActionEvent e) {
                    try{
                        insert(new Point(0, 0), "Work Product");
                    } catch (InvalidEntity e1) {
                        e1.printStackTrace();
                    }
                }
            };
            Work Product.setEnabled(true);
            jb = new JButton(Work Product);
            jb.setText("");
            jb.setName("Work Product");
            jb.setToolTipText("Work Product");
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

            

        }
    }

  public static Vector<String> getAllowedRelationships(){
        Vector<String> relationships=new   Vector<String>();
        
        relationships.add("Extends");
        
                relationships.add("Extends");
        
                relationships.add("WP Depends");
        
                relationships.add("WP Depends");
        
                relationships.add("WP Depends");
        
                relationships.add("Extends");
        
                relationships.add("Extends");
        
                relationships.add("WP Depends");
        
                relationships.add("Extends");
        
                relationships.add("WP Depends");
        
        
        
        
        return relationships;
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

  getPOssibleRelationships

    


  public String toString() {
    return this.getID();
  }

}
