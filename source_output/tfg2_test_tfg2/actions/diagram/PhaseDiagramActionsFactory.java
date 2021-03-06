

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

public class PhaseDiagramActionsFactory extends DiagramMenuEntriesActionsFactory  implements java.io.Serializable {
    
    public PhaseDiagramActionsFactory(GUIResources resources, IDEState state){
        super(resources,state);
    }

protected Vector<AbstractAction> createChangeViewActions(final DefaultGraphCell cell, final ModelJGraph graph) {
        Vector<AbstractAction> possibleViews=new Vector<AbstractAction>();
        final ingenias.editor.entities.Entity ent=((ingenias.editor.entities.Entity)cell.getUserObject());

if (ent.getClass().getName().equals("ingenias.editor.entities.Node")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
            possibleViews.add(new AbstractAction("UML") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.UML);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
                    graph.repaint();
                }
            });
        }
        
        
        if (ent.getClass().getName().equals("ingenias.editor.entities.Node")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
            possibleViews.add(new AbstractAction("INGENIAS") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
                    graph.repaint();
                }
            });
        }

        if (ent.getClass().getName().equals("ingenias.editor.entities.DecisionNode")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
            possibleViews.add(new AbstractAction("UML") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.UML);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
                    graph.repaint();
                }
            });
        }
        
        
        if (ent.getClass().getName().equals("ingenias.editor.entities.DecisionNode")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
            possibleViews.add(new AbstractAction("INGENIAS") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
                    graph.repaint();
                }
            });
        }

        if (ent.getClass().getName().equals("ingenias.editor.entities.Process")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
            possibleViews.add(new AbstractAction("UML") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.UML);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
                    graph.repaint();
                }
            });
        }
        
        
        if (ent.getClass().getName().equals("ingenias.editor.entities.Process")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
            possibleViews.add(new AbstractAction("INGENIAS") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
                    graph.repaint();
                }
            });
        }

        if (ent.getClass().getName().equals("ingenias.editor.entities.Phase")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
            possibleViews.add(new AbstractAction("UML") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.UML);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
                    graph.repaint();
                }
            });
        }
        
        
        if (ent.getClass().getName().equals("ingenias.editor.entities.Phase")){
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

        if (ent.getClass().getName().equals("ingenias.editor.entities.InitialNode")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
            possibleViews.add(new AbstractAction("UML") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.UML);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
                    graph.repaint();
                }
            });
        }
        
        
        if (ent.getClass().getName().equals("ingenias.editor.entities.InitialNode")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
            possibleViews.add(new AbstractAction("INGENIAS") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
                    graph.repaint();
                }
            });
        }

        if (ent.getClass().getName().equals("ingenias.editor.entities.iPhase")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
            possibleViews.add(new AbstractAction("UML") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.UML);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
                    graph.repaint();
                }
            });
        }
        
        
        if (ent.getClass().getName().equals("ingenias.editor.entities.iPhase")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
            possibleViews.add(new AbstractAction("INGENIAS") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
                    graph.repaint();
                }
            });
        }

        if (ent.getClass().getName().equals("ingenias.editor.entities.ForkNode")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
            possibleViews.add(new AbstractAction("UML") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.UML);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
                    graph.repaint();
                }
            });
        }
        
        
        if (ent.getClass().getName().equals("ingenias.editor.entities.ForkNode")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
            possibleViews.add(new AbstractAction("INGENIAS") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
                    graph.repaint();
                }
            });
        }

        if (ent.getClass().getName().equals("ingenias.editor.entities.EndNode")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
            possibleViews.add(new AbstractAction("UML") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.UML);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
                    graph.repaint();
                }
            });
        }
        
        
        if (ent.getClass().getName().equals("ingenias.editor.entities.EndNode")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
            possibleViews.add(new AbstractAction("INGENIAS") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
                    graph.repaint();
                }
            });
        }

        if (ent.getClass().getName().equals("ingenias.editor.entities.JoinNode")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.UML;
            possibleViews.add(new AbstractAction("UML") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.UML);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.UML);
                    graph.repaint();
                }
            });
        }
        
        
        if (ent.getClass().getName().equals("ingenias.editor.entities.JoinNode")){
            final ViewPreferences.ViewType current1=ViewPreferences.ViewType.INGENIAS;
            possibleViews.add(new AbstractAction("INGENIAS") {
                public void actionPerformed(ActionEvent e) {                
                    ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
                    //ingenias.editor.cell.TextUseCaseRenderer.setCurrent(ViewPreferences.ViewType.INGENIAS);
                    graph.repaint();
                }
            });
        }

        if (ent.getClass().getName().equals("ingenias.editor.entities.FollowsGuarded")){
            possibleViews.add(new AbstractAction("NOICON") {
                public void actionPerformed(ActionEvent e) {
                    ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON, ent, cell, graph);
                    graph.repaint();
                }
            });
        }
        if (ent.getClass().getName().equals("ingenias.editor.entities.FollowsGuarded")){
            possibleViews.add(new AbstractAction("INGENIAS") {
                public void actionPerformed(ActionEvent e) {
                    ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS, ent, cell, graph);
                    graph.repaint();
                }
            });
        }
        if (ent.getClass().getName().equals("ingenias.editor.entities.FollowsGuarded")){
            possibleViews.add(new AbstractAction("LABEL") {
                public void actionPerformed(ActionEvent e) {
                    ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.LABEL, ent, cell, graph);
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

        if (ent.getClass().getName().equals("ingenias.editor.entities.Follows")){
            possibleViews.add(new AbstractAction("NOICON") {
                public void actionPerformed(ActionEvent e) {
                    ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.NOICON, ent, cell, graph);
                    graph.repaint();
                }
            });
        }
        if (ent.getClass().getName().equals("ingenias.editor.entities.Follows")){
            possibleViews.add(new AbstractAction("INGENIAS") {
                public void actionPerformed(ActionEvent e) {
                    ingenias.editor.cell.RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS, ent, cell, graph);
                    graph.repaint();
                }
            });
        }
        if (ent.getClass().getName().equals("ingenias.editor.entities.Follows")){
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
                     new AbstractAction("Insert Node") {
            public void actionPerformed(ActionEvent ev) {
                try {
                    graph.insert(pt, "Node");
                } catch (InvalidEntity e) {                     
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(graph, "Object type Node is not allowed in this diagram",
                                                  "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        nobjects.add(
                     new AbstractAction("Insert DecisionNode") {
            public void actionPerformed(ActionEvent ev) {
                try {
                    graph.insert(pt, "DecisionNode");
                } catch (InvalidEntity e) {                     
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(graph, "Object type DecisionNode is not allowed in this diagram",
                                                  "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        nobjects.add(
                     new AbstractAction("Insert Process") {
            public void actionPerformed(ActionEvent ev) {
                try {
                    graph.insert(pt, "Process");
                } catch (InvalidEntity e) {                     
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(graph, "Object type Process is not allowed in this diagram",
                                                  "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        nobjects.add(
                     new AbstractAction("Insert Phase") {
            public void actionPerformed(ActionEvent ev) {
                try {
                    graph.insert(pt, "Phase");
                } catch (InvalidEntity e) {                     
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(graph, "Object type Phase is not allowed in this diagram",
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
                     new AbstractAction("Insert InitialNode") {
            public void actionPerformed(ActionEvent ev) {
                try {
                    graph.insert(pt, "InitialNode");
                } catch (InvalidEntity e) {                     
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(graph, "Object type InitialNode is not allowed in this diagram",
                                                  "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        nobjects.add(
                     new AbstractAction("Insert iPhase") {
            public void actionPerformed(ActionEvent ev) {
                try {
                    graph.insert(pt, "iPhase");
                } catch (InvalidEntity e) {                     
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(graph, "Object type iPhase is not allowed in this diagram",
                                                  "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        nobjects.add(
                     new AbstractAction("Insert ForkNode") {
            public void actionPerformed(ActionEvent ev) {
                try {
                    graph.insert(pt, "ForkNode");
                } catch (InvalidEntity e) {                     
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(graph, "Object type ForkNode is not allowed in this diagram",
                                                  "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        nobjects.add(
                     new AbstractAction("Insert EndNode") {
            public void actionPerformed(ActionEvent ev) {
                try {
                    graph.insert(pt, "EndNode");
                } catch (InvalidEntity e) {                     
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(graph, "Object type EndNode is not allowed in this diagram",
                                                  "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        nobjects.add(
                     new AbstractAction("Insert JoinNode") {
            public void actionPerformed(ActionEvent ev) {
                try {
                    graph.insert(pt, "JoinNode");
                } catch (InvalidEntity e) {                     
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(graph, "Object type JoinNode is not allowed in this diagram",
                                                  "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });



    return nobjects;
}

}