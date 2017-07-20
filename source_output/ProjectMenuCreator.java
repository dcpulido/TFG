

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
        
        if (ids.getDiagramFilter().isValidDiagram("WorkProductContentDiagram")){
            // Menu to add a Phase Diagram instance
            ma=new DiagramCreationAction(){
                public String getActionName(){
                    return "Add WorkProductContentDiagram";
                }
                public ModelJGraph execute(String diagramName,Object[] path, IDEState ids){
                    WorkProductContentDiagramModelJGraph mjg =
                    new WorkProductContentDiagramModelJGraph(new
                                                WorkProductContentDiagramDataEntity(diagramName), diagramName, ids.om, new Model(ids),
                                                new BasicMarqueeHandler(), ids.prefs );
                    WorkProductContentDiagramActionsFactory ema=new  WorkProductContentDiagramActionsFactory(resources,ids);
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



        if (ids.getDiagramFilter().isValidDiagram("MetaModelDiagram")){
            // Menu to add a Phase Diagram instance
            ma=new DiagramCreationAction(){
                public String getActionName(){
                    return "Add MetaModelDiagram";
                }
                public ModelJGraph execute(String diagramName,Object[] path, IDEState ids){
                    MetaModelDiagramModelJGraph mjg =
                    new MetaModelDiagramModelJGraph(new
                                                MetaModelDiagramDataEntity(diagramName), diagramName, ids.om, new Model(ids),
                                                new BasicMarqueeHandler(), ids.prefs );
                    MetaModelDiagramActionsFactory ema=new  MetaModelDiagramActionsFactory(resources,ids);
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



        if (ids.getDiagramFilter().isValidDiagram("ActivityDetailedDiagram")){
            // Menu to add a Phase Diagram instance
            ma=new DiagramCreationAction(){
                public String getActionName(){
                    return "Add ActivityDetailedDiagram";
                }
                public ModelJGraph execute(String diagramName,Object[] path, IDEState ids){
                    ActivityDetailedDiagramModelJGraph mjg =
                    new ActivityDetailedDiagramModelJGraph(new
                                                ActivityDetailedDiagramDataEntity(diagramName), diagramName, ids.om, new Model(ids),
                                                new BasicMarqueeHandler(), ids.prefs );
                    ActivityDetailedDiagramActionsFactory ema=new  ActivityDetailedDiagramActionsFactory(resources,ids);
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



        if (ids.getDiagramFilter().isValidDiagram("WorkProductStructureDiagram")){
            // Menu to add a Phase Diagram instance
            ma=new DiagramCreationAction(){
                public String getActionName(){
                    return "Add WorkProductStructureDiagram";
                }
                public ModelJGraph execute(String diagramName,Object[] path, IDEState ids){
                    WorkProductStructureDiagramModelJGraph mjg =
                    new WorkProductStructureDiagramModelJGraph(new
                                                WorkProductStructureDiagramDataEntity(diagramName), diagramName, ids.om, new Model(ids),
                                                new BasicMarqueeHandler(), ids.prefs );
                    WorkProductStructureDiagramActionsFactory ema=new  WorkProductStructureDiagramActionsFactory(resources,ids);
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



        if (ids.getDiagramFilter().isValidDiagram("WorkProductDependecyDiagram")){
            // Menu to add a Phase Diagram instance
            ma=new DiagramCreationAction(){
                public String getActionName(){
                    return "Add WorkProductDependecyDiagram";
                }
                public ModelJGraph execute(String diagramName,Object[] path, IDEState ids){
                    WorkProductDependecyDiagramModelJGraph mjg =
                    new WorkProductDependecyDiagramModelJGraph(new
                                                WorkProductDependecyDiagramDataEntity(diagramName), diagramName, ids.om, new Model(ids),
                                                new BasicMarqueeHandler(), ids.prefs );
                    WorkProductDependecyDiagramActionsFactory ema=new  WorkProductDependecyDiagramActionsFactory(resources,ids);
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



        if (ids.getDiagramFilter().isValidDiagram("TaskWorkflowDiagram")){
            // Menu to add a Phase Diagram instance
            ma=new DiagramCreationAction(){
                public String getActionName(){
                    return "Add TaskWorkflowDiagram";
                }
                public ModelJGraph execute(String diagramName,Object[] path, IDEState ids){
                    TaskWorkflowDiagramModelJGraph mjg =
                    new TaskWorkflowDiagramModelJGraph(new
                                                TaskWorkflowDiagramDataEntity(diagramName), diagramName, ids.om, new Model(ids),
                                                new BasicMarqueeHandler(), ids.prefs );
                    TaskWorkflowDiagramActionsFactory ema=new  TaskWorkflowDiagramActionsFactory(resources,ids);
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
                
                if (ids.getDiagramFilter().isValidDiagram("WorkProductContentDiagram")){
                    menu.add(
                             new AbstractAction("Add WorkProductContentDiagram") {
                        
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
                                        WorkProductContentDiagramModelJGraph mjg =
                                        new WorkProductContentDiagramModelJGraph(new
                                                                    WorkProductContentDiagramDataEntity(
                                                                                           diagramName), diagramName, ids.om, new Model(ids),
                                                                    new BasicMarqueeHandler(), ids.prefs );
                                        WorkProductContentDiagramActionsFactory ema=new  WorkProductContentDiagramActionsFactory(resources,ids);
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

                if (ids.getDiagramFilter().isValidDiagram("MetaModelDiagram")){
                    menu.add(
                             new AbstractAction("Add MetaModelDiagram") {
                        
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
                                        MetaModelDiagramModelJGraph mjg =
                                        new MetaModelDiagramModelJGraph(new
                                                                    MetaModelDiagramDataEntity(
                                                                                           diagramName), diagramName, ids.om, new Model(ids),
                                                                    new BasicMarqueeHandler(), ids.prefs );
                                        MetaModelDiagramActionsFactory ema=new  MetaModelDiagramActionsFactory(resources,ids);
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

                if (ids.getDiagramFilter().isValidDiagram("ActivityDetailedDiagram")){
                    menu.add(
                             new AbstractAction("Add ActivityDetailedDiagram") {
                        
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
                                        ActivityDetailedDiagramModelJGraph mjg =
                                        new ActivityDetailedDiagramModelJGraph(new
                                                                    ActivityDetailedDiagramDataEntity(
                                                                                           diagramName), diagramName, ids.om, new Model(ids),
                                                                    new BasicMarqueeHandler(), ids.prefs );
                                        ActivityDetailedDiagramActionsFactory ema=new  ActivityDetailedDiagramActionsFactory(resources,ids);
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

                if (ids.getDiagramFilter().isValidDiagram("WorkProductStructureDiagram")){
                    menu.add(
                             new AbstractAction("Add WorkProductStructureDiagram") {
                        
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
                                        WorkProductStructureDiagramModelJGraph mjg =
                                        new WorkProductStructureDiagramModelJGraph(new
                                                                    WorkProductStructureDiagramDataEntity(
                                                                                           diagramName), diagramName, ids.om, new Model(ids),
                                                                    new BasicMarqueeHandler(), ids.prefs );
                                        WorkProductStructureDiagramActionsFactory ema=new  WorkProductStructureDiagramActionsFactory(resources,ids);
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

                if (ids.getDiagramFilter().isValidDiagram("WorkProductDependecyDiagram")){
                    menu.add(
                             new AbstractAction("Add WorkProductDependecyDiagram") {
                        
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
                                        WorkProductDependecyDiagramModelJGraph mjg =
                                        new WorkProductDependecyDiagramModelJGraph(new
                                                                    WorkProductDependecyDiagramDataEntity(
                                                                                           diagramName), diagramName, ids.om, new Model(ids),
                                                                    new BasicMarqueeHandler(), ids.prefs );
                                        WorkProductDependecyDiagramActionsFactory ema=new  WorkProductDependecyDiagramActionsFactory(resources,ids);
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

                if (ids.getDiagramFilter().isValidDiagram("TaskWorkflowDiagram")){
                    menu.add(
                             new AbstractAction("Add TaskWorkflowDiagram") {
                        
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
                                        TaskWorkflowDiagramModelJGraph mjg =
                                        new TaskWorkflowDiagramModelJGraph(new
                                                                    TaskWorkflowDiagramDataEntity(
                                                                                           diagramName), diagramName, ids.om, new Model(ids),
                                                                    new BasicMarqueeHandler(), ids.prefs );
                                        TaskWorkflowDiagramActionsFactory ema=new  TaskWorkflowDiagramActionsFactory(resources,ids);
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



