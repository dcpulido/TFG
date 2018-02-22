

/*
 Copyright (C) 2002 Jorge Gomez Sanz
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

package ingenias.editor;

import ingenias.editor.actions.*;
import ingenias.editor.actions.diagram.*;
import ingenias.editor.entities.*;
import ingenias.editor.events.DiagramChangeHandler;
import ingenias.editor.events.DiagramCreationAction;
import ingenias.editor.*;
import ingenias.editor.models.*;
import ingenias.editor.widget.GraphicsUtils;
import ingenias.editor.editionmode.EmbeddedAndPopupCellEditor;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import org.jgraph.graph.BasicMarqueeHandler;

public class ProjectMenuCreator {
    private IDEState ids=null;  
    private Frame owner=null;
    private GUIResources resources=null; 
    
    public ProjectMenuCreator(IDEState ids,             
                              Frame owner, GUIResources resources
                              ){
        this.ids=ids;       
        this.owner=owner;
        this.resources=resources;
    }
    
    public Vector<DiagramCreationAction> getDiagramCreation(){
        
        Vector<DiagramCreationAction> actions=new Vector<DiagramCreationAction>();
        DiagramCreationAction ma=null;
        
        if (ids.getDiagramFilter().isValidDiagram("WorkProductDiagram")){
            // Menu to add a Phase Diagram instance
            ma=new DiagramCreationAction(){
                public String getActionName(){
                    return "Add WorkProductDiagram";
                }
                public ModelJGraph execute(String diagramName,Object[] path, IDEState ids){
                    WorkProductDiagramModelJGraph mjg =
                    new WorkProductDiagramModelJGraph(new
                                                WorkProductDiagramDataEntity(diagramName), diagramName, ids.om, new Model(ids),
                                                new BasicMarqueeHandler(), ids.prefs );
                    WorkProductDiagramActionsFactory ema=new  WorkProductDiagramActionsFactory(resources,ids);
                    mjg.setUI(new EmbeddedAndPopupCellEditor(ids,resources));
                    MarqueeHandler marquee=new MarqueeHandler(mjg, resources,ids,ema);
                    mjg.setMarqueeHandler(marquee);
                    ids.gm.addModel(path, diagramName, mjg);
                    ids.addNewDiagram(mjg);
                    return mjg;
                }
                public String getIconName() {
                    // TODO Auto-generated method stub
                    return "";
                }
            };
            actions.add(ma);
        }



        if (ids.getDiagramFilter().isValidDiagram("PhaseDiagram")){
            // Menu to add a Phase Diagram instance
            ma=new DiagramCreationAction(){
                public String getActionName(){
                    return "Add PhaseDiagram";
                }
                public ModelJGraph execute(String diagramName,Object[] path, IDEState ids){
                    PhaseDiagramModelJGraph mjg =
                    new PhaseDiagramModelJGraph(new
                                                PhaseDiagramDataEntity(diagramName), diagramName, ids.om, new Model(ids),
                                                new BasicMarqueeHandler(), ids.prefs );
                    PhaseDiagramActionsFactory ema=new  PhaseDiagramActionsFactory(resources,ids);
                    mjg.setUI(new EmbeddedAndPopupCellEditor(ids,resources));
                    MarqueeHandler marquee=new MarqueeHandler(mjg, resources,ids,ema);
                    mjg.setMarqueeHandler(marquee);
                    ids.gm.addModel(path, diagramName, mjg);
                    ids.addNewDiagram(mjg);
                    return mjg;
                }
                public String getIconName() {
                    // TODO Auto-generated method stub
                    return "";
                }
            };
            actions.add(ma);
        }



        if (ids.getDiagramFilter().isValidDiagram("ActivityWPDiagram")){
            // Menu to add a Phase Diagram instance
            ma=new DiagramCreationAction(){
                public String getActionName(){
                    return "Add ActivityWPDiagram";
                }
                public ModelJGraph execute(String diagramName,Object[] path, IDEState ids){
                    ActivityWPDiagramModelJGraph mjg =
                    new ActivityWPDiagramModelJGraph(new
                                                ActivityWPDiagramDataEntity(diagramName), diagramName, ids.om, new Model(ids),
                                                new BasicMarqueeHandler(), ids.prefs );
                    ActivityWPDiagramActionsFactory ema=new  ActivityWPDiagramActionsFactory(resources,ids);
                    mjg.setUI(new EmbeddedAndPopupCellEditor(ids,resources));
                    MarqueeHandler marquee=new MarqueeHandler(mjg, resources,ids,ema);
                    mjg.setMarqueeHandler(marquee);
                    ids.gm.addModel(path, diagramName, mjg);
                    ids.addNewDiagram(mjg);
                    return mjg;
                }
                public String getIconName() {
                    // TODO Auto-generated method stub
                    return "";
                }
            };
            actions.add(ma);
        }




        
        return actions;
    }
    
    public JPopupMenu menuProjectTree(MouseEvent me1) {
        final CommonMenuEntriesActionFactory cme=new CommonMenuEntriesActionFactory(resources,ids);
        JPopupMenu menu = new JPopupMenu();
        final MouseEvent me = me1;
        
        TreePath tp = ids.gm.arbolProyecto.getSelectionPath();
        if (tp != null) {   
            DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) 
            tp.getLastPathComponent();
            
            if (tp != null && dmtn.getUserObject()instanceof String) {
                // Menu to add a EnvironmentModel model instance
                
                if (ids.getDiagramFilter().isValidDiagram("WorkProductDiagram")){
                    menu.add(
                             new AbstractAction("Add WorkProductDiagram") {
                        
                        public void actionPerformed(ActionEvent e) {
                            TreePath tp = ids.gm.arbolProyecto.getSelectionPath();
                            DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) tp.
                            getLastPathComponent();
                            if (tp != null && dmtn.getUserObject()instanceof String) {
                                String diagramName = JOptionPane.showInputDialog(owner,
                                                                                 "Type graph name",
                                                                                 "New graph",
                                                                                 JOptionPane.QUESTION_MESSAGE);
                                if (diagramName != null && ids.gm.existsModel(diagramName)) {
                                    
                                    JOptionPane.showMessageDialog(owner,
                                                                  "There exists a model with the same name. Please, select another",
                                                                  "Warning",
                                                                  JOptionPane.WARNING_MESSAGE);
                                }
                                else
                                    if (diagramName != null) {
                                        WorkProductDiagramModelJGraph mjg =
                                        new WorkProductDiagramModelJGraph(new
                                                                    WorkProductDiagramDataEntity(
                                                                                           diagramName), diagramName, ids.om, new Model(ids),
                                                                    new BasicMarqueeHandler(), ids.prefs );
                                        WorkProductDiagramActionsFactory ema=new  WorkProductDiagramActionsFactory(resources,ids);
                                        mjg.setUI(new EmbeddedAndPopupCellEditor(ids,resources));
                                        MarqueeHandler marquee=new MarqueeHandler(mjg, resources,ids,ema);
                                        mjg.setMarqueeHandler(marquee);
                                        ids.gm.addModel(tp.getPath(), diagramName, mjg);
                                        ids.addNewDiagram(mjg);
                                        
                                    }
                            }
                            
                        }
                    });
                }

                if (ids.getDiagramFilter().isValidDiagram("PhaseDiagram")){
                    menu.add(
                             new AbstractAction("Add PhaseDiagram") {
                        
                        public void actionPerformed(ActionEvent e) {
                            TreePath tp = ids.gm.arbolProyecto.getSelectionPath();
                            DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) tp.
                            getLastPathComponent();
                            if (tp != null && dmtn.getUserObject()instanceof String) {
                                String diagramName = JOptionPane.showInputDialog(owner,
                                                                                 "Type graph name",
                                                                                 "New graph",
                                                                                 JOptionPane.QUESTION_MESSAGE);
                                if (diagramName != null && ids.gm.existsModel(diagramName)) {
                                    
                                    JOptionPane.showMessageDialog(owner,
                                                                  "There exists a model with the same name. Please, select another",
                                                                  "Warning",
                                                                  JOptionPane.WARNING_MESSAGE);
                                }
                                else
                                    if (diagramName != null) {
                                        PhaseDiagramModelJGraph mjg =
                                        new PhaseDiagramModelJGraph(new
                                                                    PhaseDiagramDataEntity(
                                                                                           diagramName), diagramName, ids.om, new Model(ids),
                                                                    new BasicMarqueeHandler(), ids.prefs );
                                        PhaseDiagramActionsFactory ema=new  PhaseDiagramActionsFactory(resources,ids);
                                        mjg.setUI(new EmbeddedAndPopupCellEditor(ids,resources));
                                        MarqueeHandler marquee=new MarqueeHandler(mjg, resources,ids,ema);
                                        mjg.setMarqueeHandler(marquee);
                                        ids.gm.addModel(tp.getPath(), diagramName, mjg);
                                        ids.addNewDiagram(mjg);
                                        
                                    }
                            }
                            
                        }
                    });
                }

                if (ids.getDiagramFilter().isValidDiagram("ActivityWPDiagram")){
                    menu.add(
                             new AbstractAction("Add ActivityWPDiagram") {
                        
                        public void actionPerformed(ActionEvent e) {
                            TreePath tp = ids.gm.arbolProyecto.getSelectionPath();
                            DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode) tp.
                            getLastPathComponent();
                            if (tp != null && dmtn.getUserObject()instanceof String) {
                                String diagramName = JOptionPane.showInputDialog(owner,
                                                                                 "Type graph name",
                                                                                 "New graph",
                                                                                 JOptionPane.QUESTION_MESSAGE);
                                if (diagramName != null && ids.gm.existsModel(diagramName)) {
                                    
                                    JOptionPane.showMessageDialog(owner,
                                                                  "There exists a model with the same name. Please, select another",
                                                                  "Warning",
                                                                  JOptionPane.WARNING_MESSAGE);
                                }
                                else
                                    if (diagramName != null) {
                                        ActivityWPDiagramModelJGraph mjg =
                                        new ActivityWPDiagramModelJGraph(new
                                                                    ActivityWPDiagramDataEntity(
                                                                                           diagramName), diagramName, ids.om, new Model(ids),
                                                                    new BasicMarqueeHandler(), ids.prefs );
                                        ActivityWPDiagramActionsFactory ema=new  ActivityWPDiagramActionsFactory(resources,ids);
                                        mjg.setUI(new EmbeddedAndPopupCellEditor(ids,resources));
                                        MarqueeHandler marquee=new MarqueeHandler(mjg, resources,ids,ema);
                                        mjg.setMarqueeHandler(marquee);
                                        ids.gm.addModel(tp.getPath(), diagramName, mjg);
                                        ids.addNewDiagram(mjg);
                                        
                                    }
                            }
                            
                        }
                    });
                }



            }
        }
        return menu;
    };
    
    
    
}



