
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

public class InteractionModelModelJGraph extends ModelJGraph {

  private Preferences prefs;

  public InteractionModelModelJGraph(InteractionModelDataEntity mde, 
                               String nombre, ObjectManager om, Model
                               m, BasicMarqueeHandler mh, Preferences prefs) {
    super(mde, nombre, m, mh,om);
    this.prefs=prefs;
    
			 
				  ToolTipManager.sharedInstance().registerComponent(this);
				  this.getModel().addGraphModelListener(
				  new ChangeNARYEdgeLocation(this));
				  this.getModel().addGraphModelListener(
				  new ChangeEntityLocation(this));			  
				  
		
    this.getGraphLayoutCache().setFactory(new ingenias.editor.cellfactories.InteractionModelCellViewFactory());
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
    toolbar = new FilteredJToolBar("InteractionModel");
    toolbar.setFloatable(false);
    ImageIcon undoIcon = null;
    JButton jb = null;


    Image img_Agent =
        ImageLoader.getImage("images/magent.gif");
    undoIcon = new ImageIcon(img_Agent);
    Action Agent=
        new AbstractAction("Agent", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "Agent");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    Agent.setEnabled(true);
    jb = new JButton(Agent);
    jb.setText("");
    jb.setName("Agent");	
    jb.setToolTipText("Agent");
    toolbar.add(jb);

    Image img_AgentWS =
        ImageLoader.getImage("images/magentws.gif");
    undoIcon = new ImageIcon(img_AgentWS);
    Action AgentWS=
        new AbstractAction("AgentWS", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "AgentWS");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    AgentWS.setEnabled(true);
    jb = new JButton(AgentWS);
    jb.setText("");
    jb.setName("AgentWS");	
    jb.setToolTipText("AgentWS");
    toolbar.add(jb);

    Image img_Role =
        ImageLoader.getImage("images/mrole.gif");
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

    Image img_RoleWS =
        ImageLoader.getImage("images/mrolews.gif");
    undoIcon = new ImageIcon(img_RoleWS);
    Action RoleWS=
        new AbstractAction("RoleWS", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "RoleWS");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    RoleWS.setEnabled(true);
    jb = new JButton(RoleWS);
    jb.setText("");
    jb.setName("RoleWS");	
    jb.setToolTipText("RoleWS");
    toolbar.add(jb);

    Image img_Task =
        ImageLoader.getImage("images/mtask.gif");
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

    Image img_TaskWS =
        ImageLoader.getImage("images/mtaskws.gif");
    undoIcon = new ImageIcon(img_TaskWS);
    Action TaskWS=
        new AbstractAction("TaskWS", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "TaskWS");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    TaskWS.setEnabled(true);
    jb = new JButton(TaskWS);
    jb.setText("");
    jb.setName("TaskWS");	
    jb.setToolTipText("TaskWS");
    toolbar.add(jb);

    Image img_Goal =
        ImageLoader.getImage("images/mgoal.gif");
    undoIcon = new ImageIcon(img_Goal);
    Action Goal=
        new AbstractAction("Goal", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "Goal");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    Goal.setEnabled(true);
    jb = new JButton(Goal);
    jb.setText("");
    jb.setName("Goal");	
    jb.setToolTipText("Goal");
    toolbar.add(jb);

    Image img_Interaction =
        ImageLoader.getImage("images/minter.gif");
    undoIcon = new ImageIcon(img_Interaction);
    Action Interaction=
        new AbstractAction("Interaction", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "Interaction");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    Interaction.setEnabled(true);
    jb = new JButton(Interaction);
    jb.setText("");
    jb.setName("Interaction");	
    jb.setToolTipText("Interaction");
    toolbar.add(jb);

    Image img_IUIterate =
        ImageLoader.getImage("images/mit.gif");
    undoIcon = new ImageIcon(img_IUIterate);
    Action IUIterate=
        new AbstractAction("IUIterate", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "IUIterate");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    IUIterate.setEnabled(true);
    jb = new JButton(IUIterate);
    jb.setText("");
    jb.setName("IUIterate");	
    jb.setToolTipText("IUIterate");
    toolbar.add(jb);

    Image img_IUConcurrence =
        ImageLoader.getImage("images/mconc.gif");
    undoIcon = new ImageIcon(img_IUConcurrence);
    Action IUConcurrence=
        new AbstractAction("IUConcurrence", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "IUConcurrence");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    IUConcurrence.setEnabled(true);
    jb = new JButton(IUConcurrence);
    jb.setText("");
    jb.setName("IUConcurrence");	
    jb.setToolTipText("IUConcurrence");
    toolbar.add(jb);

    Image img_InteractionUnit =
        ImageLoader.getImage("images/miu.gif");
    undoIcon = new ImageIcon(img_InteractionUnit);
    Action InteractionUnit=
        new AbstractAction("InteractionUnit", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "InteractionUnit");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    InteractionUnit.setEnabled(true);
    jb = new JButton(InteractionUnit);
    jb.setText("");
    jb.setName("InteractionUnit");	
    jb.setToolTipText("InteractionUnit");
    toolbar.add(jb);

    Image img_UMLSpecification =
        ImageLoader.getImage("images/mumlspec.gif");
    undoIcon = new ImageIcon(img_UMLSpecification);
    Action UMLSpecification=
        new AbstractAction("UMLSpecification", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "UMLSpecification");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    UMLSpecification.setEnabled(true);
    jb = new JButton(UMLSpecification);
    jb.setText("");
    jb.setName("UMLSpecification");	
    jb.setToolTipText("UMLSpecification");
    toolbar.add(jb);

    Image img_AUMLSpecification =
        ImageLoader.getImage("images/maumlspec.gif");
    undoIcon = new ImageIcon(img_AUMLSpecification);
    Action AUMLSpecification=
        new AbstractAction("AUMLSpecification", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "AUMLSpecification");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    AUMLSpecification.setEnabled(true);
    jb = new JButton(AUMLSpecification);
    jb.setText("");
    jb.setName("AUMLSpecification");	
    jb.setToolTipText("AUMLSpecification");
    toolbar.add(jb);

    Image img_GRASIASpecification =
        ImageLoader.getImage("images/mgspec.gif");
    undoIcon = new ImageIcon(img_GRASIASpecification);
    Action GRASIASpecification=
        new AbstractAction("GRASIASpecification", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "GRASIASpecification");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    GRASIASpecification.setEnabled(true);
    jb = new JButton(GRASIASpecification);
    jb.setText("");
    jb.setName("GRASIASpecification");	
    jb.setToolTipText("GRASIASpecification");
    toolbar.add(jb);

    Image img_TextNote =
        ImageLoader.getImage("images/mtext.gif");
    undoIcon = new ImageIcon(img_TextNote);
    Action TextNote=
        new AbstractAction("TextNote", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "TextNote");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    TextNote.setEnabled(true);
    jb = new JButton(TextNote);
    jb.setText("");
    jb.setName("TextNote");	
    jb.setToolTipText("TextNote");
    toolbar.add(jb);

    Image img_UMLComment =
        ImageLoader.getImage("images/mumlcomment.gif");
    undoIcon = new ImageIcon(img_UMLComment);
    Action UMLComment=
        new AbstractAction("UMLComment", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "UMLComment");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    UMLComment.setEnabled(true);
    jb = new JButton(UMLComment);
    jb.setText("");
    jb.setName("UMLComment");	
    jb.setToolTipText("UMLComment");
    toolbar.add(jb);

    }

  }

  public static Vector<String> getAllowedRelationships(){
   Vector<String> relationships=new   Vector<String>();


          relationships.add("IInitiates");

          relationships.add("IColaborates");

          relationships.add("UIInitiates");

          relationships.add("UIColaborates");

          relationships.add("UISelection");

          relationships.add("IPursues");

          relationships.add("GTPursues");

          relationships.add("IHasSpec");

          relationships.add("UIPrecedes");

          relationships.add("UMLSendsMessage");

          relationships.add("UMLAnnotatedElement");

          relationships.add("IAccesses");

   return relationships;
  }

  public static Vector<String> getAllowedEntities(){
   Vector<String> entities=new   Vector<String>();


 entities.add("Agent");

 entities.add("AgentWS");

 entities.add("Role");

 entities.add("RoleWS");

 entities.add("Task");

 entities.add("TaskWS");

 entities.add("Goal");

 entities.add("Interaction");

 entities.add("IUIterate");

 entities.add("IUConcurrence");

 entities.add("InteractionUnit");

 entities.add("UMLSpecification");

 entities.add("AUMLSpecification");

 entities.add("GRASIASpecification");

 entities.add("TextNote");

 entities.add("UMLComment");

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
        if (IInitiatesEdge.acceptConnection(this.getModel(), selected)) {
          v.add("IInitiates");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (IColaboratesEdge.acceptConnection(this.getModel(), selected)) {
          v.add("IColaborates");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (UIInitiatesEdge.acceptConnection(this.getModel(), selected)) {
          v.add("UIInitiates");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (UIColaboratesEdge.acceptConnection(this.getModel(), selected)) {
          v.add("UIColaborates");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (UISelectionEdge.acceptConnection(this.getModel(), selected)) {
          v.add("UISelection");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (IPursuesEdge.acceptConnection(this.getModel(), selected)) {
          v.add("IPursues");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (GTPursuesEdge.acceptConnection(this.getModel(), selected)) {
          v.add("GTPursues");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (IHasSpecEdge.acceptConnection(this.getModel(), selected)) {
          v.add("IHasSpec");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (UIPrecedesEdge.acceptConnection(this.getModel(), selected)) {
          v.add("UIPrecedes");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (UMLSendsMessageEdge.acceptConnection(this.getModel(), selected)) {
          v.add("UMLSendsMessage");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (UMLAnnotatedElementEdge.acceptConnection(this.getModel(), selected)) {
          v.add("UMLAnnotatedElement");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (IAccessesEdge.acceptConnection(this.getModel(), selected)) {
          v.add("IAccesses");
	  }

      }
      else if (nAryEdgesNum == 1) {

        if (selectedEdge instanceof IInitiatesEdge &&
        (IInitiatesEdge.acceptConnection(this.getModel(), selected))) {
          v.add("IInitiates");
        }

        if (selectedEdge instanceof IColaboratesEdge &&
        (IColaboratesEdge.acceptConnection(this.getModel(), selected))) {
          v.add("IColaborates");
        }

        if (selectedEdge instanceof UIInitiatesEdge &&
        (UIInitiatesEdge.acceptConnection(this.getModel(), selected))) {
          v.add("UIInitiates");
        }

        if (selectedEdge instanceof UIColaboratesEdge &&
        (UIColaboratesEdge.acceptConnection(this.getModel(), selected))) {
          v.add("UIColaborates");
        }

        if (selectedEdge instanceof UISelectionEdge &&
        (UISelectionEdge.acceptConnection(this.getModel(), selected))) {
          v.add("UISelection");
        }

        if (selectedEdge instanceof IPursuesEdge &&
        (IPursuesEdge.acceptConnection(this.getModel(), selected))) {
          v.add("IPursues");
        }

        if (selectedEdge instanceof GTPursuesEdge &&
        (GTPursuesEdge.acceptConnection(this.getModel(), selected))) {
          v.add("GTPursues");
        }

        if (selectedEdge instanceof IHasSpecEdge &&
        (IHasSpecEdge.acceptConnection(this.getModel(), selected))) {
          v.add("IHasSpec");
        }

        if (selectedEdge instanceof UIPrecedesEdge &&
        (UIPrecedesEdge.acceptConnection(this.getModel(), selected))) {
          v.add("UIPrecedes");
        }

        if (selectedEdge instanceof UMLSendsMessageEdge &&
        (UMLSendsMessageEdge.acceptConnection(this.getModel(), selected))) {
          v.add("UMLSendsMessage");
        }

        if (selectedEdge instanceof UMLAnnotatedElementEdge &&
        (UMLAnnotatedElementEdge.acceptConnection(this.getModel(), selected))) {
          v.add("UMLAnnotatedElement");
        }

        if (selectedEdge instanceof IAccessesEdge &&
        (IAccessesEdge.acceptConnection(this.getModel(), selected))) {
          v.add("IAccesses");
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

      if (relacion.equalsIgnoreCase("IInitiates")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof IInitiatesEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new IInitiatesEdge(new IInitiates(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("IColaborates")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof IColaboratesEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new IColaboratesEdge(new IColaborates(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("UIInitiates")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof UIInitiatesEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new UIInitiatesEdge(new UIInitiates(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("UIColaborates")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof UIColaboratesEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new UIColaboratesEdge(new UIColaborates(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("UISelection")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof UISelectionEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new UISelectionEdge(new UISelection(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("IPursues")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof IPursuesEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new IPursuesEdge(new IPursues(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("GTPursues")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof GTPursuesEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new GTPursuesEdge(new GTPursues(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("IHasSpec")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof IHasSpecEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new IHasSpecEdge(new IHasSpec(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("UIPrecedes")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof UIPrecedesEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new UIPrecedesEdge(new UIPrecedes(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("UMLSendsMessage")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof UMLSendsMessageEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new UMLSendsMessageEdge(new UMLSendsMessage(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("UMLAnnotatedElement")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof UMLAnnotatedElementEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new UMLAnnotatedElementEdge(new UMLAnnotatedElement(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("IAccesses")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof IAccessesEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new IAccessesEdge(new IAccesses(getMJGraph().getNewId()));
        }
      }

    }

    return null;
  }
  
  public DefaultGraphCell createCell(String entity) throws InvalidEntity{
  
    if (entity.equalsIgnoreCase("Agent")) {
    Agent nentity=getOM().createAgent(getMJGraph().getNewId("Agent"));
      DefaultGraphCell vertex = new
          AgentCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("AgentWS")) {
    AgentWS nentity=getOM().createAgentWS(getMJGraph().getNewId("AgentWS"));
      DefaultGraphCell vertex = new
          AgentWSCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("Role")) {
    Role nentity=getOM().createRole(getMJGraph().getNewId("Role"));
      DefaultGraphCell vertex = new
          RoleCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("RoleWS")) {
    RoleWS nentity=getOM().createRoleWS(getMJGraph().getNewId("RoleWS"));
      DefaultGraphCell vertex = new
          RoleWSCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("Task")) {
    Task nentity=getOM().createTask(getMJGraph().getNewId("Task"));
      DefaultGraphCell vertex = new
          TaskCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("TaskWS")) {
    TaskWS nentity=getOM().createTaskWS(getMJGraph().getNewId("TaskWS"));
      DefaultGraphCell vertex = new
          TaskWSCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("Goal")) {
    Goal nentity=getOM().createGoal(getMJGraph().getNewId("Goal"));
      DefaultGraphCell vertex = new
          GoalCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("Interaction")) {
    Interaction nentity=getOM().createInteraction(getMJGraph().getNewId("Interaction"));
      DefaultGraphCell vertex = new
          InteractionCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("IUIterate")) {
    IUIterate nentity=getOM().createIUIterate(getMJGraph().getNewId("IUIterate"));
      DefaultGraphCell vertex = new
          IUIterateCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("IUConcurrence")) {
    IUConcurrence nentity=getOM().createIUConcurrence(getMJGraph().getNewId("IUConcurrence"));
      DefaultGraphCell vertex = new
          IUConcurrenceCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("InteractionUnit")) {
    InteractionUnit nentity=getOM().createInteractionUnit(getMJGraph().getNewId("InteractionUnit"));
      DefaultGraphCell vertex = new
          InteractionUnitCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("UMLSpecification")) {
    UMLSpecification nentity=getOM().createUMLSpecification(getMJGraph().getNewId("UMLSpecification"));
      DefaultGraphCell vertex = new
          UMLSpecificationCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("AUMLSpecification")) {
    AUMLSpecification nentity=getOM().createAUMLSpecification(getMJGraph().getNewId("AUMLSpecification"));
      DefaultGraphCell vertex = new
          AUMLSpecificationCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("GRASIASpecification")) {
    GRASIASpecification nentity=getOM().createGRASIASpecification(getMJGraph().getNewId("GRASIASpecification"));
      DefaultGraphCell vertex = new
          GRASIASpecificationCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("TextNote")) {
    TextNote nentity=getOM().createTextNote(getMJGraph().getNewId("TextNote"));
      DefaultGraphCell vertex = new
          TextNoteCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("UMLComment")) {
    UMLComment nentity=getOM().createUMLComment(getMJGraph().getNewId("UMLComment"));
      DefaultGraphCell vertex = new
          UMLCommentCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

	  throw new ingenias.exception.InvalidEntity("Entity type "+entity+" is not allowed in this diagram"); 
  }
  
  public Dimension getDefaultSize(Entity entity) throws InvalidEntity{
    
    if (entity.getType().equalsIgnoreCase("Agent")) {
      return AgentView.getSize((Agent)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("AgentWS")) {
      return AgentWSView.getSize((AgentWS)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("Role")) {
      return RoleView.getSize((Role)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("RoleWS")) {
      return RoleWSView.getSize((RoleWS)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("Task")) {
      return TaskView.getSize((Task)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("TaskWS")) {
      return TaskWSView.getSize((TaskWS)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("Goal")) {
      return GoalView.getSize((Goal)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("Interaction")) {
      return InteractionView.getSize((Interaction)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("IUIterate")) {
      return IUIterateView.getSize((IUIterate)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("IUConcurrence")) {
      return IUConcurrenceView.getSize((IUConcurrence)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("InteractionUnit")) {
      return InteractionUnitView.getSize((InteractionUnit)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("UMLSpecification")) {
      return UMLSpecificationView.getSize((UMLSpecification)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("AUMLSpecification")) {
      return AUMLSpecificationView.getSize((AUMLSpecification)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("GRASIASpecification")) {
      return GRASIASpecificationView.getSize((GRASIASpecification)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("TextNote")) {
      return TextNoteView.getSize((TextNote)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("UMLComment")) {
      return UMLCommentView.getSize((UMLComment)entity);      
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


    if (entity.getClass().equals(Agent.class)) {
      vertex = new AgentCell( (Agent) entity);
      // Default Size for the new Vertex with the new entity within
      size = AgentView.getSize((Agent) entity);
    }
    else

    if (entity.getClass().equals(AgentWS.class)) {
      vertex = new AgentWSCell( (AgentWS) entity);
      // Default Size for the new Vertex with the new entity within
      size = AgentWSView.getSize((AgentWS) entity);
    }
    else

    if (entity.getClass().equals(Role.class)) {
      vertex = new RoleCell( (Role) entity);
      // Default Size for the new Vertex with the new entity within
      size = RoleView.getSize((Role) entity);
    }
    else

    if (entity.getClass().equals(RoleWS.class)) {
      vertex = new RoleWSCell( (RoleWS) entity);
      // Default Size for the new Vertex with the new entity within
      size = RoleWSView.getSize((RoleWS) entity);
    }
    else

    if (entity.getClass().equals(Task.class)) {
      vertex = new TaskCell( (Task) entity);
      // Default Size for the new Vertex with the new entity within
      size = TaskView.getSize((Task) entity);
    }
    else

    if (entity.getClass().equals(TaskWS.class)) {
      vertex = new TaskWSCell( (TaskWS) entity);
      // Default Size for the new Vertex with the new entity within
      size = TaskWSView.getSize((TaskWS) entity);
    }
    else

    if (entity.getClass().equals(Goal.class)) {
      vertex = new GoalCell( (Goal) entity);
      // Default Size for the new Vertex with the new entity within
      size = GoalView.getSize((Goal) entity);
    }
    else

    if (entity.getClass().equals(Interaction.class)) {
      vertex = new InteractionCell( (Interaction) entity);
      // Default Size for the new Vertex with the new entity within
      size = InteractionView.getSize((Interaction) entity);
    }
    else

    if (entity.getClass().equals(IUIterate.class)) {
      vertex = new IUIterateCell( (IUIterate) entity);
      // Default Size for the new Vertex with the new entity within
      size = IUIterateView.getSize((IUIterate) entity);
    }
    else

    if (entity.getClass().equals(IUConcurrence.class)) {
      vertex = new IUConcurrenceCell( (IUConcurrence) entity);
      // Default Size for the new Vertex with the new entity within
      size = IUConcurrenceView.getSize((IUConcurrence) entity);
    }
    else

    if (entity.getClass().equals(InteractionUnit.class)) {
      vertex = new InteractionUnitCell( (InteractionUnit) entity);
      // Default Size for the new Vertex with the new entity within
      size = InteractionUnitView.getSize((InteractionUnit) entity);
    }
    else

    if (entity.getClass().equals(UMLSpecification.class)) {
      vertex = new UMLSpecificationCell( (UMLSpecification) entity);
      // Default Size for the new Vertex with the new entity within
      size = UMLSpecificationView.getSize((UMLSpecification) entity);
    }
    else

    if (entity.getClass().equals(AUMLSpecification.class)) {
      vertex = new AUMLSpecificationCell( (AUMLSpecification) entity);
      // Default Size for the new Vertex with the new entity within
      size = AUMLSpecificationView.getSize((AUMLSpecification) entity);
    }
    else

    if (entity.getClass().equals(GRASIASpecification.class)) {
      vertex = new GRASIASpecificationCell( (GRASIASpecification) entity);
      // Default Size for the new Vertex with the new entity within
      size = GRASIASpecificationView.getSize((GRASIASpecification) entity);
    }
    else

    if (entity.getClass().equals(TextNote.class)) {
      vertex = new TextNoteCell( (TextNote) entity);
      // Default Size for the new Vertex with the new entity within
      size = TextNoteView.getSize((TextNote) entity);
    }
    else

    if (entity.getClass().equals(UMLComment.class)) {
      vertex = new UMLCommentCell( (UMLComment) entity);
      // Default Size for the new Vertex with the new entity within
      size = UMLCommentView.getSize((UMLComment) entity);
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

		

		 InteractionModelModelJGraph jg=new  InteractionModelModelJGraph(
				(InteractionModelDataEntity) this.mde,name, ids.om,
				new Model(ids),new BasicMarqueeHandler(),ids.prefs); 

		this.setSelectionCells(getGraphLayoutCache().getCells(false,true,false,false));
		Action copyaction =new EventRedirectorForGraphCopy(this,this.getTransferHandler().getCopyAction(),null	); 			
		Action pasteaction =new EventRedirectorPasteForGraphCopy(jg,jg.getTransferHandler().getPasteAction(),null	);
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
