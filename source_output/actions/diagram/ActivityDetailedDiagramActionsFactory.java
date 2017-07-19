

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

package ingenias.editor.actions.diagram;
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
import java.util.Map;
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
import java.lang.reflect.*;
import ingenias.editor.entities.*;
import ingenias.editor.widget.*;
import ingenias.exception.NullEntity;
import ingenias.generator.browser.BrowserImp;
import ingenias.generator.browser.Graph;
import ingenias.generator.browser.GraphEntity;
import ingenias.exception.InvalidEntity;
import ingenias.editor.*;

// MarqueeHandler that Connects Vertices and Displays PopupMenus

public class ActivityDetailedDiagramActionsFactory extends DiagramMenuEntriesActionsFactory  implements java.io.Serializable {
    
    public ActivityDetailedDiagramActionsFactory(GUIResources resources, IDEState state){
        super(resources,state);
    }

protected Vector<AbstractAction> createChangeViewActions(final DefaultGraphCell cell, final ModelJGraph graph) {
        Vector<AbstractAction> possibleViews=new Vector<AbstractAction>();
        final ingenias.editor.entities.Entity ent=((ingenias.editor.entities.Entity)cell.getUserObject());

if (ent.getClass().getName().equals("ingenias.editor.entities.Role")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
            possibleViews.add(new AbstractAction("UML") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.UML);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
                    graph.repaint();
                }
            });
        }
        
        
        if (ent.getClass().getName().equals("ingenias.editor.entities.Role")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
            possibleViews.add(new AbstractAction("INGENIAS") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
                    graph.repaint();
                }
            });
        }

        if (ent.getClass().getName().equals("ingenias.editor.entities.BehavioralWP")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
            possibleViews.add(new AbstractAction("UML") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.UML);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
                    graph.repaint();
                }
            });
        }
        
        
        if (ent.getClass().getName().equals("ingenias.editor.entities.BehavioralWP")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
            possibleViews.add(new AbstractAction("INGENIAS") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
                    graph.repaint();
                }
            });
        }

        if (ent.getClass().getName().equals("ingenias.editor.entities.Task")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
            possibleViews.add(new AbstractAction("UML") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.UML);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
                    graph.repaint();
                }
            });
        }
        
        
        if (ent.getClass().getName().equals("ingenias.editor.entities.Task")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
            possibleViews.add(new AbstractAction("INGENIAS") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
                    graph.repaint();
                }
            });
        }

        if (ent.getClass().getName().equals("ingenias.editor.entities.StructuralWP")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
            possibleViews.add(new AbstractAction("UML") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.UML);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
                    graph.repaint();
                }
            });
        }
        
        
        if (ent.getClass().getName().equals("ingenias.editor.entities.StructuralWP")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
            possibleViews.add(new AbstractAction("INGENIAS") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
                    graph.repaint();
                }
            });
        }

        if (ent.getClass().getName().equals("ingenias.editor.entities.WFConsumed")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
            possibleViews.add(new AbstractAction("UML") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.UML);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
                    graph.repaint();
                }
            });
        }
        
        
        if (ent.getClass().getName().equals("ingenias.editor.entities.WFConsumed")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
            possibleViews.add(new AbstractAction("INGENIAS") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
                    graph.repaint();
                }
            });
        }

        if (ent.getClass().getName().equals("ingenias.editor.entities.CompositeWP")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
            possibleViews.add(new AbstractAction("UML") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.UML);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
                    graph.repaint();
                }
            });
        }
        
        
        if (ent.getClass().getName().equals("ingenias.editor.entities.CompositeWP")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
            possibleViews.add(new AbstractAction("INGENIAS") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
                    graph.repaint();
                }
            });
        }

        if (ent.getClass().getName().equals("ingenias.editor.entities.Activity")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
            possibleViews.add(new AbstractAction("UML") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.UML);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
                    graph.repaint();
                }
            });
        }
        
        
        if (ent.getClass().getName().equals("ingenias.editor.entities.Activity")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
            possibleViews.add(new AbstractAction("INGENIAS") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
                    graph.repaint();
                }
            });
        }

        if (ent.getClass().getName().equals("ingenias.editor.entities.FreeWP")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
            possibleViews.add(new AbstractAction("UML") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.UML);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
                    graph.repaint();
                }
            });
        }
        
        
        if (ent.getClass().getName().equals("ingenias.editor.entities.FreeWP")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
            possibleViews.add(new AbstractAction("INGENIAS") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
                    graph.repaint();
                }
            });
        }

        if (ent.getClass().getName().equals("ingenias.editor.entities.WPProduced")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
            possibleViews.add(new AbstractAction("UML") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.UML);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
                    graph.repaint();
                }
            });
        }
        
        
        if (ent.getClass().getName().equals("ingenias.editor.entities.WPProduced")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
            possibleViews.add(new AbstractAction("INGENIAS") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
                    graph.repaint();
                }
            });
        }

        if (ent.getClass().getName().equals("ingenias.editor.entities.StructuredWP")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
            possibleViews.add(new AbstractAction("UML") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.UML);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
                    graph.repaint();
                }
            });
        }
        
        
        if (ent.getClass().getName().equals("ingenias.editor.entities.StructuredWP")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
            possibleViews.add(new AbstractAction("INGENIAS") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
                    graph.repaint();
                }
            });
        }

        if (ent.getClass().getName().equals("ingenias.editor.entities.Extends")){
            possibleViews.add(new AbstractAction("NOICON") {
                public void actionPerformed(ActionEvent e) {
                    ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON, ent, cell, graph);
                    graph.repaint();
                }
            });
        }
        if (ent.getClass().getName().equals("ingenias.editor.entities.Extends")){
            possibleViews.add(new AbstractAction("INGENIAS") {
                public void actionPerformed(ActionEvent e) {
                    ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS, ent, cell, graph);
                    graph.repaint();
                }
            });
        }
        if (ent.getClass().getName().equals("ingenias.editor.entities.Extends")){
            possibleViews.add(new AbstractAction("LABEL") {
                public void actionPerformed(ActionEvent e) {
                    ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL, ent, cell, graph);
                    graph.repaint();
                }
            });
        }

        if (ent.getClass().getName().equals("ingenias.editor.entities.WPContains")){
            possibleViews.add(new AbstractAction("NOICON") {
                public void actionPerformed(ActionEvent e) {
                    ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON, ent, cell, graph);
                    graph.repaint();
                }
            });
        }
        if (ent.getClass().getName().equals("ingenias.editor.entities.WPContains")){
            possibleViews.add(new AbstractAction("INGENIAS") {
                public void actionPerformed(ActionEvent e) {
                    ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS, ent, cell, graph);
                    graph.repaint();
                }
            });
        }
        if (ent.getClass().getName().equals("ingenias.editor.entities.WPContains")){
            possibleViews.add(new AbstractAction("LABEL") {
                public void actionPerformed(ActionEvent e) {
                    ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL, ent, cell, graph);
                    graph.repaint();
                }
            });
        }

        if (ent.getClass().getName().equals("ingenias.editor.entities.WFProduces")){
            possibleViews.add(new AbstractAction("NOICON") {
                public void actionPerformed(ActionEvent e) {
                    ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON, ent, cell, graph);
                    graph.repaint();
                }
            });
        }
        if (ent.getClass().getName().equals("ingenias.editor.entities.WFProduces")){
            possibleViews.add(new AbstractAction("INGENIAS") {
                public void actionPerformed(ActionEvent e) {
                    ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS, ent, cell, graph);
                    graph.repaint();
                }
            });
        }
        if (ent.getClass().getName().equals("ingenias.editor.entities.WFProduces")){
            possibleViews.add(new AbstractAction("LABEL") {
                public void actionPerformed(ActionEvent e) {
                    ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL, ent, cell, graph);
                    graph.repaint();
                }
            });
        }

        if (ent.getClass().getName().equals("ingenias.editor.entities.WFConsumes")){
            possibleViews.add(new AbstractAction("NOICON") {
                public void actionPerformed(ActionEvent e) {
                    ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON, ent, cell, graph);
                    graph.repaint();
                }
            });
        }
        if (ent.getClass().getName().equals("ingenias.editor.entities.WFConsumes")){
            possibleViews.add(new AbstractAction("INGENIAS") {
                public void actionPerformed(ActionEvent e) {
                    ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS, ent, cell, graph);
                    graph.repaint();
                }
            });
        }
        if (ent.getClass().getName().equals("ingenias.editor.entities.WFConsumes")){
            possibleViews.add(new AbstractAction("LABEL") {
                public void actionPerformed(ActionEvent e) {
                    ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL, ent, cell, graph);
                    graph.repaint();
                }
            });
        }

        if (ent.getClass().getName().equals("ingenias.editor.entities.WFResponsible")){
            possibleViews.add(new AbstractAction("NOICON") {
                public void actionPerformed(ActionEvent e) {
                    ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON, ent, cell, graph);
                    graph.repaint();
                }
            });
        }
        if (ent.getClass().getName().equals("ingenias.editor.entities.WFResponsible")){
            possibleViews.add(new AbstractAction("INGENIAS") {
                public void actionPerformed(ActionEvent e) {
                    ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS, ent, cell, graph);
                    graph.repaint();
                }
            });
        }
        if (ent.getClass().getName().equals("ingenias.editor.entities.WFResponsible")){
            possibleViews.add(new AbstractAction("LABEL") {
                public void actionPerformed(ActionEvent e) {
                    ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL, ent, cell, graph);
                    graph.repaint();
                }
            });
        }

        if (ent.getClass().getName().equals("ingenias.editor.entities.WpContains")){
            possibleViews.add(new AbstractAction("NOICON") {
                public void actionPerformed(ActionEvent e) {
                    ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON, ent, cell, graph);
                    graph.repaint();
                }
            });
        }
        if (ent.getClass().getName().equals("ingenias.editor.entities.WpContains")){
            possibleViews.add(new AbstractAction("INGENIAS") {
                public void actionPerformed(ActionEvent e) {
                    ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS, ent, cell, graph);
                    graph.repaint();
                }
            });
        }
        if (ent.getClass().getName().equals("ingenias.editor.entities.WpContains")){
            possibleViews.add(new AbstractAction("LABEL") {
                public void actionPerformed(ActionEvent e) {
                    ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL, ent, cell, graph);
                    graph.repaint();
                }
            });
        }

        

    return possibleViews;
}

protected Vector<AbstractAction> createDiagramSpecificInsertActions(final Point pt, final ModelJGraph graph) {
        Vector<AbstractAction> nobjects=new Vector<AbstractAction>();

        nobjects.add(
                     new AbstractAction("Insert Role") {
            public void actionPerformed(ActionEvent ev) {
                try {
                    graph.insert(pt, "Role");
                } catch (InvalidEntity e) {                     
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(graph, "Object type Role is not allowed in this diagram",
                                                  "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        nobjects.add(
                     new AbstractAction("Insert BehavioralWP") {
            public void actionPerformed(ActionEvent ev) {
                try {
                    graph.insert(pt, "BehavioralWP");
                } catch (InvalidEntity e) {                     
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(graph, "Object type BehavioralWP is not allowed in this diagram",
                                                  "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        nobjects.add(
                     new AbstractAction("Insert Task") {
            public void actionPerformed(ActionEvent ev) {
                try {
                    graph.insert(pt, "Task");
                } catch (InvalidEntity e) {                     
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(graph, "Object type Task is not allowed in this diagram",
                                                  "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        nobjects.add(
                     new AbstractAction("Insert StructuralWP") {
            public void actionPerformed(ActionEvent ev) {
                try {
                    graph.insert(pt, "StructuralWP");
                } catch (InvalidEntity e) {                     
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(graph, "Object type StructuralWP is not allowed in this diagram",
                                                  "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        nobjects.add(
                     new AbstractAction("Insert WFConsumed") {
            public void actionPerformed(ActionEvent ev) {
                try {
                    graph.insert(pt, "WFConsumed");
                } catch (InvalidEntity e) {                     
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(graph, "Object type WFConsumed is not allowed in this diagram",
                                                  "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        nobjects.add(
                     new AbstractAction("Insert CompositeWP") {
            public void actionPerformed(ActionEvent ev) {
                try {
                    graph.insert(pt, "CompositeWP");
                } catch (InvalidEntity e) {                     
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(graph, "Object type CompositeWP is not allowed in this diagram",
                                                  "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        nobjects.add(
                     new AbstractAction("Insert Activity") {
            public void actionPerformed(ActionEvent ev) {
                try {
                    graph.insert(pt, "Activity");
                } catch (InvalidEntity e) {                     
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(graph, "Object type Activity is not allowed in this diagram",
                                                  "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        nobjects.add(
                     new AbstractAction("Insert FreeWP") {
            public void actionPerformed(ActionEvent ev) {
                try {
                    graph.insert(pt, "FreeWP");
                } catch (InvalidEntity e) {                     
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(graph, "Object type FreeWP is not allowed in this diagram",
                                                  "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        nobjects.add(
                     new AbstractAction("Insert WPProduced") {
            public void actionPerformed(ActionEvent ev) {
                try {
                    graph.insert(pt, "WPProduced");
                } catch (InvalidEntity e) {                     
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(graph, "Object type WPProduced is not allowed in this diagram",
                                                  "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        nobjects.add(
                     new AbstractAction("Insert StructuredWP") {
            public void actionPerformed(ActionEvent ev) {
                try {
                    graph.insert(pt, "StructuredWP");
                } catch (InvalidEntity e) {                     
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(graph, "Object type StructuredWP is not allowed in this diagram",
                                                  "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });



    return nobjects;
}

}