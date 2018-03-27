
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

public class TasksAndGoalsModelModelJGraph extends ModelJGraph {

  private Preferences prefs;

  public TasksAndGoalsModelModelJGraph(TasksAndGoalsModelDataEntity mde, 
                               String nombre, ObjectManager om, Model
                               m, BasicMarqueeHandler mh, Preferences prefs) {
    super(mde, nombre, m, mh,om);
    this.prefs=prefs;
    
			 
				  ToolTipManager.sharedInstance().registerComponent(this);
				  this.getModel().addGraphModelListener(
				  new ChangeNARYEdgeLocation(this));
				  this.getModel().addGraphModelListener(
				  new ChangeEntityLocation(this));			  
				  			
		
    this.getGraphLayoutCache().setFactory(new ingenias.editor.cellfactories.TasksAndGoalsModelCellViewFactory());
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
    toolbar = new FilteredJToolBar("TasksAndGoalsModel");
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

    Image img_AgentModelBelieve =
        ImageLoader.getImage("images/mabel.gif");
    undoIcon = new ImageIcon(img_AgentModelBelieve);
    Action AgentModelBelieve=
        new AbstractAction("AgentModelBelieve", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "AgentModelBelieve");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    AgentModelBelieve.setEnabled(true);
    jb = new JButton(AgentModelBelieve);
    jb.setText("");
    jb.setName("AgentModelBelieve");	
    jb.setToolTipText("AgentModelBelieve");
    toolbar.add(jb);

    Image img_ApplicationEvent =
        ImageLoader.getImage("images/meventa.gif");
    undoIcon = new ImageIcon(img_ApplicationEvent);
    Action ApplicationEvent=
        new AbstractAction("ApplicationEvent", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "ApplicationEvent");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    ApplicationEvent.setEnabled(true);
    jb = new JButton(ApplicationEvent);
    jb.setText("");
    jb.setName("ApplicationEvent");	
    jb.setToolTipText("ApplicationEvent");
    toolbar.add(jb);

    Image img_ApplicationEventSlots =
        ImageLoader.getImage("images/meventas.gif");
    undoIcon = new ImageIcon(img_ApplicationEventSlots);
    Action ApplicationEventSlots=
        new AbstractAction("ApplicationEventSlots", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "ApplicationEventSlots");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    ApplicationEventSlots.setEnabled(true);
    jb = new JButton(ApplicationEventSlots);
    jb.setText("");
    jb.setName("ApplicationEventSlots");	
    jb.setToolTipText("ApplicationEventSlots");
    toolbar.add(jb);

    Image img_Application =
        ImageLoader.getImage("images/mapp.gif");
    undoIcon = new ImageIcon(img_Application);
    Action Application=
        new AbstractAction("Application", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "Application");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    Application.setEnabled(true);
    jb = new JButton(Application);
    jb.setText("");
    jb.setName("Application");	
    jb.setToolTipText("Application");
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

    Image img_StateGoal =
        ImageLoader.getImage("images/msgoal.gif");
    undoIcon = new ImageIcon(img_StateGoal);
    Action StateGoal=
        new AbstractAction("StateGoal", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "StateGoal");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    StateGoal.setEnabled(true);
    jb = new JButton(StateGoal);
    jb.setText("");
    jb.setName("StateGoal");	
    jb.setToolTipText("StateGoal");
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

    Image img_Resource =
        ImageLoader.getImage("images/mresource.gif");
    undoIcon = new ImageIcon(img_Resource);
    Action Resource=
        new AbstractAction("Resource", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "Resource");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    Resource.setEnabled(true);
    jb = new JButton(Resource);
    jb.setText("");
    jb.setName("Resource");	
    jb.setToolTipText("Resource");
    toolbar.add(jb);

    Image img_Fact =
        ImageLoader.getImage("images/mfact.gif");
    undoIcon = new ImageIcon(img_Fact);
    Action Fact=
        new AbstractAction("Fact", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "Fact");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    Fact.setEnabled(true);
    jb = new JButton(Fact);
    jb.setText("");
    jb.setName("Fact");	
    jb.setToolTipText("Fact");
    toolbar.add(jb);

    Image img_FrameFact =
        ImageLoader.getImage("images/mffact.gif");
    undoIcon = new ImageIcon(img_FrameFact);
    Action FrameFact=
        new AbstractAction("FrameFact", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "FrameFact");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    FrameFact.setEnabled(true);
    jb = new JButton(FrameFact);
    jb.setText("");
    jb.setName("FrameFact");	
    jb.setToolTipText("FrameFact");
    toolbar.add(jb);

    Image img_Believe =
        ImageLoader.getImage("images/mbel.gif");
    undoIcon = new ImageIcon(img_Believe);
    Action Believe=
        new AbstractAction("Believe", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "Believe");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    Believe.setEnabled(true);
    jb = new JButton(Believe);
    jb.setText("");
    jb.setName("Believe");	
    jb.setToolTipText("Believe");
    toolbar.add(jb);

    Image img_Compromise =
        ImageLoader.getImage("images/mcomp.gif");
    undoIcon = new ImageIcon(img_Compromise);
    Action Compromise=
        new AbstractAction("Compromise", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "Compromise");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    Compromise.setEnabled(true);
    jb = new JButton(Compromise);
    jb.setText("");
    jb.setName("Compromise");	
    jb.setToolTipText("Compromise");
    toolbar.add(jb);

    Image img_GeneralEvent =
        ImageLoader.getImage("images/mevent.gif");
    undoIcon = new ImageIcon(img_GeneralEvent);
    Action GeneralEvent=
        new AbstractAction("GeneralEvent", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "GeneralEvent");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    GeneralEvent.setEnabled(true);
    jb = new JButton(GeneralEvent);
    jb.setText("");
    jb.setName("GeneralEvent");	
    jb.setToolTipText("GeneralEvent");
    toolbar.add(jb);

    Image img_CommunicationEvent =
        ImageLoader.getImage("images/meventa.gif");
    undoIcon = new ImageIcon(img_CommunicationEvent);
    Action CommunicationEvent=
        new AbstractAction("CommunicationEvent", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "CommunicationEvent");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    CommunicationEvent.setEnabled(true);
    jb = new JButton(CommunicationEvent);
    jb.setText("");
    jb.setName("CommunicationEvent");	
    jb.setToolTipText("CommunicationEvent");
    toolbar.add(jb);

    Image img_EnvironmentApplication =
        ImageLoader.getImage("images/mappe.gif");
    undoIcon = new ImageIcon(img_EnvironmentApplication);
    Action EnvironmentApplication=
        new AbstractAction("EnvironmentApplication", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "EnvironmentApplication");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    EnvironmentApplication.setEnabled(true);
    jb = new JButton(EnvironmentApplication);
    jb.setText("");
    jb.setName("EnvironmentApplication");	
    jb.setToolTipText("EnvironmentApplication");
    toolbar.add(jb);

    Image img_InternalApplication =
        ImageLoader.getImage("images/mappi.gif");
    undoIcon = new ImageIcon(img_InternalApplication);
    Action InternalApplication=
        new AbstractAction("InternalApplication", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "InternalApplication");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    InternalApplication.setEnabled(true);
    jb = new JButton(InternalApplication);
    jb.setText("");
    jb.setName("InternalApplication");	
    jb.setToolTipText("InternalApplication");
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

    Image img_Plan =
        ImageLoader.getImage("images/mplan.gif");
    undoIcon = new ImageIcon(img_Plan);
    Action Plan=
        new AbstractAction("Plan", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "Plan");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    Plan.setEnabled(true);
    jb = new JButton(Plan);
    jb.setText("");
    jb.setName("Plan");	
    jb.setToolTipText("Plan");
    toolbar.add(jb);

    Image img_Conversation =
        ImageLoader.getImage("images/mconv.png");
    undoIcon = new ImageIcon(img_Conversation);
    Action Conversation=
        new AbstractAction("Conversation", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "Conversation");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    Conversation.setEnabled(true);
    jb = new JButton(Conversation);
    jb.setText("");
    jb.setName("Conversation");	
    jb.setToolTipText("Conversation");
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

    Image img_Workflow =
        ImageLoader.getImage("images/mworkflow.gif");
    undoIcon = new ImageIcon(img_Workflow);
    Action Workflow=
        new AbstractAction("Workflow", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "Workflow");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    Workflow.setEnabled(true);
    jb = new JButton(Workflow);
    jb.setText("");
    jb.setName("Workflow");	
    jb.setToolTipText("Workflow");
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

    Image img_GoalStateWS =
        ImageLoader.getImage("images/mgoalstatews.png");
    undoIcon = new ImageIcon(img_GoalStateWS);
    Action GoalStateWS=
        new AbstractAction("GoalStateWS", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "GoalStateWS");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    GoalStateWS.setEnabled(true);
    jb = new JButton(GoalStateWS);
    jb.setText("");
    jb.setName("GoalStateWS");	
    jb.setToolTipText("GoalStateWS");
    toolbar.add(jb);

    Image img_ApplicationWS =
        ImageLoader.getImage("images/mapp.gif");
    undoIcon = new ImageIcon(img_ApplicationWS);
    Action ApplicationWS=
        new AbstractAction("ApplicationWS", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "ApplicationWS");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    ApplicationWS.setEnabled(true);
    jb = new JButton(ApplicationWS);
    jb.setText("");
    jb.setName("ApplicationWS");	
    jb.setToolTipText("ApplicationWS");
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

    }

  }

  public static Vector<String> getAllowedRelationships(){
   Vector<String> relationships=new   Vector<String>();


          relationships.add("GTPursues");

          relationships.add("GTCreates");

          relationships.add("GTAffects");

          relationships.add("GTDestroys");

          relationships.add("GTModifies");

          relationships.add("GTFails");

          relationships.add("GTSatisfies");

          relationships.add("WFResponsable");

          relationships.add("WFConsumes");

          relationships.add("Consumes");

          relationships.add("WFUses");

          relationships.add("WFUsesMethod");

          relationships.add("WFProduces");

          relationships.add("GTDecomposes");

          relationships.add("GTDecomposesAND");

          relationships.add("GTDecomposesOR");

          relationships.add("GTDepends");

          relationships.add("GTInherits");

          relationships.add("GTAndDepends");

          relationships.add("GTOrDepends");

          relationships.add("WFDecomposes");

          relationships.add("Contribute");

          relationships.add("ContributePositively");

          relationships.add("ContributeNegatively");

          relationships.add("UMLAnnotatedElement");

          relationships.add("WFParticipates");

          relationships.add("WFCancels");

          relationships.add("IAccesses");

   return relationships;
  }

  public static Vector<String> getAllowedEntities(){
   Vector<String> entities=new   Vector<String>();


 entities.add("Agent");

 entities.add("AgentModelBelieve");

 entities.add("ApplicationEvent");

 entities.add("ApplicationEventSlots");

 entities.add("Application");

 entities.add("AgentWS");

 entities.add("Role");

 entities.add("Goal");

 entities.add("StateGoal");

 entities.add("Task");

 entities.add("Resource");

 entities.add("Fact");

 entities.add("FrameFact");

 entities.add("Believe");

 entities.add("Compromise");

 entities.add("GeneralEvent");

 entities.add("CommunicationEvent");

 entities.add("EnvironmentApplication");

 entities.add("InternalApplication");

 entities.add("TextNote");

 entities.add("Plan");

 entities.add("Conversation");

 entities.add("UMLComment");

 entities.add("Workflow");

 entities.add("RoleWS");

 entities.add("TaskWS");

 entities.add("GoalStateWS");

 entities.add("ApplicationWS");

 entities.add("Interaction");

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
        if (GTPursuesEdge.acceptConnection(this.getModel(), selected)) {
          v.add("GTPursues");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (GTCreatesEdge.acceptConnection(this.getModel(), selected)) {
          v.add("GTCreates");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (GTAffectsEdge.acceptConnection(this.getModel(), selected)) {
          v.add("GTAffects");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (GTDestroysEdge.acceptConnection(this.getModel(), selected)) {
          v.add("GTDestroys");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (GTModifiesEdge.acceptConnection(this.getModel(), selected)) {
          v.add("GTModifies");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (GTFailsEdge.acceptConnection(this.getModel(), selected)) {
          v.add("GTFails");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (GTSatisfiesEdge.acceptConnection(this.getModel(), selected)) {
          v.add("GTSatisfies");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (WFResponsableEdge.acceptConnection(this.getModel(), selected)) {
          v.add("WFResponsable");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (WFConsumesEdge.acceptConnection(this.getModel(), selected)) {
          v.add("WFConsumes");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (ConsumesEdge.acceptConnection(this.getModel(), selected)) {
          v.add("Consumes");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (WFUsesEdge.acceptConnection(this.getModel(), selected)) {
          v.add("WFUses");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (WFUsesMethodEdge.acceptConnection(this.getModel(), selected)) {
          v.add("WFUsesMethod");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (WFProducesEdge.acceptConnection(this.getModel(), selected)) {
          v.add("WFProduces");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (GTDecomposesEdge.acceptConnection(this.getModel(), selected)) {
          v.add("GTDecomposes");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (GTDecomposesANDEdge.acceptConnection(this.getModel(), selected)) {
          v.add("GTDecomposesAND");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (GTDecomposesOREdge.acceptConnection(this.getModel(), selected)) {
          v.add("GTDecomposesOR");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (GTDependsEdge.acceptConnection(this.getModel(), selected)) {
          v.add("GTDepends");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (GTInheritsEdge.acceptConnection(this.getModel(), selected)) {
          v.add("GTInherits");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (GTAndDependsEdge.acceptConnection(this.getModel(), selected)) {
          v.add("GTAndDepends");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (GTOrDependsEdge.acceptConnection(this.getModel(), selected)) {
          v.add("GTOrDepends");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (WFDecomposesEdge.acceptConnection(this.getModel(), selected)) {
          v.add("WFDecomposes");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (ContributeEdge.acceptConnection(this.getModel(), selected)) {
          v.add("Contribute");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (ContributePositivelyEdge.acceptConnection(this.getModel(), selected)) {
          v.add("ContributePositively");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (ContributeNegativelyEdge.acceptConnection(this.getModel(), selected)) {
          v.add("ContributeNegatively");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (UMLAnnotatedElementEdge.acceptConnection(this.getModel(), selected)) {
          v.add("UMLAnnotatedElement");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (WFParticipatesEdge.acceptConnection(this.getModel(), selected)) {
          v.add("WFParticipates");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (WFCancelsEdge.acceptConnection(this.getModel(), selected)) {
          v.add("WFCancels");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (IAccessesEdge.acceptConnection(this.getModel(), selected)) {
          v.add("IAccesses");
	  }

      }
      else if (nAryEdgesNum == 1) {

        if (selectedEdge instanceof GTPursuesEdge &&
        (GTPursuesEdge.acceptConnection(this.getModel(), selected))) {
          v.add("GTPursues");
        }

        if (selectedEdge instanceof GTCreatesEdge &&
        (GTCreatesEdge.acceptConnection(this.getModel(), selected))) {
          v.add("GTCreates");
        }

        if (selectedEdge instanceof GTAffectsEdge &&
        (GTAffectsEdge.acceptConnection(this.getModel(), selected))) {
          v.add("GTAffects");
        }

        if (selectedEdge instanceof GTDestroysEdge &&
        (GTDestroysEdge.acceptConnection(this.getModel(), selected))) {
          v.add("GTDestroys");
        }

        if (selectedEdge instanceof GTModifiesEdge &&
        (GTModifiesEdge.acceptConnection(this.getModel(), selected))) {
          v.add("GTModifies");
        }

        if (selectedEdge instanceof GTFailsEdge &&
        (GTFailsEdge.acceptConnection(this.getModel(), selected))) {
          v.add("GTFails");
        }

        if (selectedEdge instanceof GTSatisfiesEdge &&
        (GTSatisfiesEdge.acceptConnection(this.getModel(), selected))) {
          v.add("GTSatisfies");
        }

        if (selectedEdge instanceof WFResponsableEdge &&
        (WFResponsableEdge.acceptConnection(this.getModel(), selected))) {
          v.add("WFResponsable");
        }

        if (selectedEdge instanceof WFConsumesEdge &&
        (WFConsumesEdge.acceptConnection(this.getModel(), selected))) {
          v.add("WFConsumes");
        }

        if (selectedEdge instanceof ConsumesEdge &&
        (ConsumesEdge.acceptConnection(this.getModel(), selected))) {
          v.add("Consumes");
        }

        if (selectedEdge instanceof WFUsesEdge &&
        (WFUsesEdge.acceptConnection(this.getModel(), selected))) {
          v.add("WFUses");
        }

        if (selectedEdge instanceof WFUsesMethodEdge &&
        (WFUsesMethodEdge.acceptConnection(this.getModel(), selected))) {
          v.add("WFUsesMethod");
        }

        if (selectedEdge instanceof WFProducesEdge &&
        (WFProducesEdge.acceptConnection(this.getModel(), selected))) {
          v.add("WFProduces");
        }

        if (selectedEdge instanceof GTDecomposesEdge &&
        (GTDecomposesEdge.acceptConnection(this.getModel(), selected))) {
          v.add("GTDecomposes");
        }

        if (selectedEdge instanceof GTDecomposesANDEdge &&
        (GTDecomposesANDEdge.acceptConnection(this.getModel(), selected))) {
          v.add("GTDecomposesAND");
        }

        if (selectedEdge instanceof GTDecomposesOREdge &&
        (GTDecomposesOREdge.acceptConnection(this.getModel(), selected))) {
          v.add("GTDecomposesOR");
        }

        if (selectedEdge instanceof GTDependsEdge &&
        (GTDependsEdge.acceptConnection(this.getModel(), selected))) {
          v.add("GTDepends");
        }

        if (selectedEdge instanceof GTInheritsEdge &&
        (GTInheritsEdge.acceptConnection(this.getModel(), selected))) {
          v.add("GTInherits");
        }

        if (selectedEdge instanceof GTAndDependsEdge &&
        (GTAndDependsEdge.acceptConnection(this.getModel(), selected))) {
          v.add("GTAndDepends");
        }

        if (selectedEdge instanceof GTOrDependsEdge &&
        (GTOrDependsEdge.acceptConnection(this.getModel(), selected))) {
          v.add("GTOrDepends");
        }

        if (selectedEdge instanceof WFDecomposesEdge &&
        (WFDecomposesEdge.acceptConnection(this.getModel(), selected))) {
          v.add("WFDecomposes");
        }

        if (selectedEdge instanceof ContributeEdge &&
        (ContributeEdge.acceptConnection(this.getModel(), selected))) {
          v.add("Contribute");
        }

        if (selectedEdge instanceof ContributePositivelyEdge &&
        (ContributePositivelyEdge.acceptConnection(this.getModel(), selected))) {
          v.add("ContributePositively");
        }

        if (selectedEdge instanceof ContributeNegativelyEdge &&
        (ContributeNegativelyEdge.acceptConnection(this.getModel(), selected))) {
          v.add("ContributeNegatively");
        }

        if (selectedEdge instanceof UMLAnnotatedElementEdge &&
        (UMLAnnotatedElementEdge.acceptConnection(this.getModel(), selected))) {
          v.add("UMLAnnotatedElement");
        }

        if (selectedEdge instanceof WFParticipatesEdge &&
        (WFParticipatesEdge.acceptConnection(this.getModel(), selected))) {
          v.add("WFParticipates");
        }

        if (selectedEdge instanceof WFCancelsEdge &&
        (WFCancelsEdge.acceptConnection(this.getModel(), selected))) {
          v.add("WFCancels");
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

      if (relacion.equalsIgnoreCase("GTCreates")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof GTCreatesEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new GTCreatesEdge(new GTCreates(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("GTAffects")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof GTAffectsEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new GTAffectsEdge(new GTAffects(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("GTDestroys")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof GTDestroysEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new GTDestroysEdge(new GTDestroys(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("GTModifies")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof GTModifiesEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new GTModifiesEdge(new GTModifies(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("GTFails")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof GTFailsEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new GTFailsEdge(new GTFails(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("GTSatisfies")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof GTSatisfiesEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new GTSatisfiesEdge(new GTSatisfies(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("WFResponsable")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof WFResponsableEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new WFResponsableEdge(new WFResponsable(getMJGraph().getNewId()));
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

      if (relacion.equalsIgnoreCase("Consumes")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof ConsumesEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new ConsumesEdge(new Consumes(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("WFUses")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof WFUsesEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new WFUsesEdge(new WFUses(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("WFUsesMethod")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof WFUsesMethodEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new WFUsesMethodEdge(new WFUsesMethod(getMJGraph().getNewId()));
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

      if (relacion.equalsIgnoreCase("GTDecomposes")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof GTDecomposesEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new GTDecomposesEdge(new GTDecomposes(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("GTDecomposesAND")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof GTDecomposesANDEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new GTDecomposesANDEdge(new GTDecomposesAND(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("GTDecomposesOR")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof GTDecomposesOREdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new GTDecomposesOREdge(new GTDecomposesOR(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("GTDepends")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof GTDependsEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new GTDependsEdge(new GTDepends(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("GTInherits")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof GTInheritsEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new GTInheritsEdge(new GTInherits(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("GTAndDepends")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof GTAndDependsEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new GTAndDependsEdge(new GTAndDepends(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("GTOrDepends")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof GTOrDependsEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new GTOrDependsEdge(new GTOrDepends(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("WFDecomposes")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof WFDecomposesEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new WFDecomposesEdge(new WFDecomposes(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("Contribute")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof ContributeEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new ContributeEdge(new Contribute(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("ContributePositively")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof ContributePositivelyEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new ContributePositivelyEdge(new ContributePositively(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("ContributeNegatively")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof ContributeNegativelyEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new ContributeNegativelyEdge(new ContributeNegatively(getMJGraph().getNewId()));
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

      if (relacion.equalsIgnoreCase("WFParticipates")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof WFParticipatesEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new WFParticipatesEdge(new WFParticipates(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("WFCancels")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof WFCancelsEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new WFCancelsEdge(new WFCancels(getMJGraph().getNewId()));
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

    if (entity.equalsIgnoreCase("AgentModelBelieve")) {
    AgentModelBelieve nentity=getOM().createAgentModelBelieve(getMJGraph().getNewId("AgentModelBelieve"));
      DefaultGraphCell vertex = new
          AgentModelBelieveCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("ApplicationEvent")) {
    ApplicationEvent nentity=getOM().createApplicationEvent(getMJGraph().getNewId("ApplicationEvent"));
      DefaultGraphCell vertex = new
          ApplicationEventCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("ApplicationEventSlots")) {
    ApplicationEventSlots nentity=getOM().createApplicationEventSlots(getMJGraph().getNewId("ApplicationEventSlots"));
      DefaultGraphCell vertex = new
          ApplicationEventSlotsCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("Application")) {
    Application nentity=getOM().createApplication(getMJGraph().getNewId("Application"));
      DefaultGraphCell vertex = new
          ApplicationCell(nentity);
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

    if (entity.equalsIgnoreCase("Goal")) {
    Goal nentity=getOM().createGoal(getMJGraph().getNewId("Goal"));
      DefaultGraphCell vertex = new
          GoalCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("StateGoal")) {
    StateGoal nentity=getOM().createStateGoal(getMJGraph().getNewId("StateGoal"));
      DefaultGraphCell vertex = new
          StateGoalCell(nentity);
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

    if (entity.equalsIgnoreCase("Resource")) {
    Resource nentity=getOM().createResource(getMJGraph().getNewId("Resource"));
      DefaultGraphCell vertex = new
          ResourceCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("Fact")) {
    Fact nentity=getOM().createFact(getMJGraph().getNewId("Fact"));
      DefaultGraphCell vertex = new
          FactCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("FrameFact")) {
    FrameFact nentity=getOM().createFrameFact(getMJGraph().getNewId("FrameFact"));
      DefaultGraphCell vertex = new
          FrameFactCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("Believe")) {
    Believe nentity=getOM().createBelieve(getMJGraph().getNewId("Believe"));
      DefaultGraphCell vertex = new
          BelieveCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("Compromise")) {
    Compromise nentity=getOM().createCompromise(getMJGraph().getNewId("Compromise"));
      DefaultGraphCell vertex = new
          CompromiseCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("GeneralEvent")) {
    GeneralEvent nentity=getOM().createGeneralEvent(getMJGraph().getNewId("GeneralEvent"));
      DefaultGraphCell vertex = new
          GeneralEventCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("CommunicationEvent")) {
    CommunicationEvent nentity=getOM().createCommunicationEvent(getMJGraph().getNewId("CommunicationEvent"));
      DefaultGraphCell vertex = new
          CommunicationEventCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("EnvironmentApplication")) {
    EnvironmentApplication nentity=getOM().createEnvironmentApplication(getMJGraph().getNewId("EnvironmentApplication"));
      DefaultGraphCell vertex = new
          EnvironmentApplicationCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("InternalApplication")) {
    InternalApplication nentity=getOM().createInternalApplication(getMJGraph().getNewId("InternalApplication"));
      DefaultGraphCell vertex = new
          InternalApplicationCell(nentity);
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

    if (entity.equalsIgnoreCase("Plan")) {
    Plan nentity=getOM().createPlan(getMJGraph().getNewId("Plan"));
      DefaultGraphCell vertex = new
          PlanCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("Conversation")) {
    Conversation nentity=getOM().createConversation(getMJGraph().getNewId("Conversation"));
      DefaultGraphCell vertex = new
          ConversationCell(nentity);
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

    if (entity.equalsIgnoreCase("Workflow")) {
    Workflow nentity=getOM().createWorkflow(getMJGraph().getNewId("Workflow"));
      DefaultGraphCell vertex = new
          WorkflowCell(nentity);
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

    if (entity.equalsIgnoreCase("TaskWS")) {
    TaskWS nentity=getOM().createTaskWS(getMJGraph().getNewId("TaskWS"));
      DefaultGraphCell vertex = new
          TaskWSCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("GoalStateWS")) {
    GoalStateWS nentity=getOM().createGoalStateWS(getMJGraph().getNewId("GoalStateWS"));
      DefaultGraphCell vertex = new
          GoalStateWSCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("ApplicationWS")) {
    ApplicationWS nentity=getOM().createApplicationWS(getMJGraph().getNewId("ApplicationWS"));
      DefaultGraphCell vertex = new
          ApplicationWSCell(nentity);
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

	  throw new ingenias.exception.InvalidEntity("Entity type "+entity+" is not allowed in this diagram"); 
  }
  
  public Dimension getDefaultSize(Entity entity) throws InvalidEntity{
    
    if (entity.getType().equalsIgnoreCase("Agent")) {
      return AgentView.getSize((Agent)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("AgentModelBelieve")) {
      return AgentModelBelieveView.getSize((AgentModelBelieve)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("ApplicationEvent")) {
      return ApplicationEventView.getSize((ApplicationEvent)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("ApplicationEventSlots")) {
      return ApplicationEventSlotsView.getSize((ApplicationEventSlots)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("Application")) {
      return ApplicationView.getSize((Application)entity);      
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

    if (entity.getType().equalsIgnoreCase("Goal")) {
      return GoalView.getSize((Goal)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("StateGoal")) {
      return StateGoalView.getSize((StateGoal)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("Task")) {
      return TaskView.getSize((Task)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("Resource")) {
      return ResourceView.getSize((Resource)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("Fact")) {
      return FactView.getSize((Fact)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("FrameFact")) {
      return FrameFactView.getSize((FrameFact)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("Believe")) {
      return BelieveView.getSize((Believe)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("Compromise")) {
      return CompromiseView.getSize((Compromise)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("GeneralEvent")) {
      return GeneralEventView.getSize((GeneralEvent)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("CommunicationEvent")) {
      return CommunicationEventView.getSize((CommunicationEvent)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("EnvironmentApplication")) {
      return EnvironmentApplicationView.getSize((EnvironmentApplication)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("InternalApplication")) {
      return InternalApplicationView.getSize((InternalApplication)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("TextNote")) {
      return TextNoteView.getSize((TextNote)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("Plan")) {
      return PlanView.getSize((Plan)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("Conversation")) {
      return ConversationView.getSize((Conversation)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("UMLComment")) {
      return UMLCommentView.getSize((UMLComment)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("Workflow")) {
      return WorkflowView.getSize((Workflow)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("RoleWS")) {
      return RoleWSView.getSize((RoleWS)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("TaskWS")) {
      return TaskWSView.getSize((TaskWS)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("GoalStateWS")) {
      return GoalStateWSView.getSize((GoalStateWS)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("ApplicationWS")) {
      return ApplicationWSView.getSize((ApplicationWS)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("Interaction")) {
      return InteractionView.getSize((Interaction)entity);      
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

    if (entity.getClass().equals(AgentModelBelieve.class)) {
      vertex = new AgentModelBelieveCell( (AgentModelBelieve) entity);
      // Default Size for the new Vertex with the new entity within
      size = AgentModelBelieveView.getSize((AgentModelBelieve) entity);
    }
    else

    if (entity.getClass().equals(ApplicationEvent.class)) {
      vertex = new ApplicationEventCell( (ApplicationEvent) entity);
      // Default Size for the new Vertex with the new entity within
      size = ApplicationEventView.getSize((ApplicationEvent) entity);
    }
    else

    if (entity.getClass().equals(ApplicationEventSlots.class)) {
      vertex = new ApplicationEventSlotsCell( (ApplicationEventSlots) entity);
      // Default Size for the new Vertex with the new entity within
      size = ApplicationEventSlotsView.getSize((ApplicationEventSlots) entity);
    }
    else

    if (entity.getClass().equals(Application.class)) {
      vertex = new ApplicationCell( (Application) entity);
      // Default Size for the new Vertex with the new entity within
      size = ApplicationView.getSize((Application) entity);
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

    if (entity.getClass().equals(Goal.class)) {
      vertex = new GoalCell( (Goal) entity);
      // Default Size for the new Vertex with the new entity within
      size = GoalView.getSize((Goal) entity);
    }
    else

    if (entity.getClass().equals(StateGoal.class)) {
      vertex = new StateGoalCell( (StateGoal) entity);
      // Default Size for the new Vertex with the new entity within
      size = StateGoalView.getSize((StateGoal) entity);
    }
    else

    if (entity.getClass().equals(Task.class)) {
      vertex = new TaskCell( (Task) entity);
      // Default Size for the new Vertex with the new entity within
      size = TaskView.getSize((Task) entity);
    }
    else

    if (entity.getClass().equals(Resource.class)) {
      vertex = new ResourceCell( (Resource) entity);
      // Default Size for the new Vertex with the new entity within
      size = ResourceView.getSize((Resource) entity);
    }
    else

    if (entity.getClass().equals(Fact.class)) {
      vertex = new FactCell( (Fact) entity);
      // Default Size for the new Vertex with the new entity within
      size = FactView.getSize((Fact) entity);
    }
    else

    if (entity.getClass().equals(FrameFact.class)) {
      vertex = new FrameFactCell( (FrameFact) entity);
      // Default Size for the new Vertex with the new entity within
      size = FrameFactView.getSize((FrameFact) entity);
    }
    else

    if (entity.getClass().equals(Believe.class)) {
      vertex = new BelieveCell( (Believe) entity);
      // Default Size for the new Vertex with the new entity within
      size = BelieveView.getSize((Believe) entity);
    }
    else

    if (entity.getClass().equals(Compromise.class)) {
      vertex = new CompromiseCell( (Compromise) entity);
      // Default Size for the new Vertex with the new entity within
      size = CompromiseView.getSize((Compromise) entity);
    }
    else

    if (entity.getClass().equals(GeneralEvent.class)) {
      vertex = new GeneralEventCell( (GeneralEvent) entity);
      // Default Size for the new Vertex with the new entity within
      size = GeneralEventView.getSize((GeneralEvent) entity);
    }
    else

    if (entity.getClass().equals(CommunicationEvent.class)) {
      vertex = new CommunicationEventCell( (CommunicationEvent) entity);
      // Default Size for the new Vertex with the new entity within
      size = CommunicationEventView.getSize((CommunicationEvent) entity);
    }
    else

    if (entity.getClass().equals(EnvironmentApplication.class)) {
      vertex = new EnvironmentApplicationCell( (EnvironmentApplication) entity);
      // Default Size for the new Vertex with the new entity within
      size = EnvironmentApplicationView.getSize((EnvironmentApplication) entity);
    }
    else

    if (entity.getClass().equals(InternalApplication.class)) {
      vertex = new InternalApplicationCell( (InternalApplication) entity);
      // Default Size for the new Vertex with the new entity within
      size = InternalApplicationView.getSize((InternalApplication) entity);
    }
    else

    if (entity.getClass().equals(TextNote.class)) {
      vertex = new TextNoteCell( (TextNote) entity);
      // Default Size for the new Vertex with the new entity within
      size = TextNoteView.getSize((TextNote) entity);
    }
    else

    if (entity.getClass().equals(Plan.class)) {
      vertex = new PlanCell( (Plan) entity);
      // Default Size for the new Vertex with the new entity within
      size = PlanView.getSize((Plan) entity);
    }
    else

    if (entity.getClass().equals(Conversation.class)) {
      vertex = new ConversationCell( (Conversation) entity);
      // Default Size for the new Vertex with the new entity within
      size = ConversationView.getSize((Conversation) entity);
    }
    else

    if (entity.getClass().equals(UMLComment.class)) {
      vertex = new UMLCommentCell( (UMLComment) entity);
      // Default Size for the new Vertex with the new entity within
      size = UMLCommentView.getSize((UMLComment) entity);
    }
    else

    if (entity.getClass().equals(Workflow.class)) {
      vertex = new WorkflowCell( (Workflow) entity);
      // Default Size for the new Vertex with the new entity within
      size = WorkflowView.getSize((Workflow) entity);
    }
    else

    if (entity.getClass().equals(RoleWS.class)) {
      vertex = new RoleWSCell( (RoleWS) entity);
      // Default Size for the new Vertex with the new entity within
      size = RoleWSView.getSize((RoleWS) entity);
    }
    else

    if (entity.getClass().equals(TaskWS.class)) {
      vertex = new TaskWSCell( (TaskWS) entity);
      // Default Size for the new Vertex with the new entity within
      size = TaskWSView.getSize((TaskWS) entity);
    }
    else

    if (entity.getClass().equals(GoalStateWS.class)) {
      vertex = new GoalStateWSCell( (GoalStateWS) entity);
      // Default Size for the new Vertex with the new entity within
      size = GoalStateWSView.getSize((GoalStateWS) entity);
    }
    else

    if (entity.getClass().equals(ApplicationWS.class)) {
      vertex = new ApplicationWSCell( (ApplicationWS) entity);
      // Default Size for the new Vertex with the new entity within
      size = ApplicationWSView.getSize((ApplicationWS) entity);
    }
    else

    if (entity.getClass().equals(Interaction.class)) {
      vertex = new InteractionCell( (Interaction) entity);
      // Default Size for the new Vertex with the new entity within
      size = InteractionView.getSize((Interaction) entity);
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

		

		 TasksAndGoalsModelModelJGraph jg=new  TasksAndGoalsModelModelJGraph(
				(TasksAndGoalsModelDataEntity) this.mde,name, ids.om,
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
