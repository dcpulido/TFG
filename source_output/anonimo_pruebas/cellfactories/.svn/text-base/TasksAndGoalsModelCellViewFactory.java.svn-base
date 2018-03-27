
/*null
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
package ingenias.editor.cellfactories;

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
import ingenias.editor.entities.*;
import ingenias.editor.cell.*;
import ingenias.editor.events.*;

public class TasksAndGoalsModelCellViewFactory implements CellViewFactory {

public TasksAndGoalsModelCellViewFactory() {}
 

 	public CellView createView(GraphModel model, Object cell) {
		
			CellView view = null;
			if (model.isPort(cell))
				view = new PortView(cell);
			else if (model.isEdge(cell))
				view = createEdgeView(cell);
			else
				view = createVertexView(cell);
			return view;
		}

  // Modificar agregando nuevas clases VIEW segun se vayan a?endo

  protected VertexView createVertexView(Object v) {
    Object userObject = ( (DefaultGraphCell) v).getUserObject();

   // Diagram Objects start here


   if (userObject.getClass().equals(Agent.class)){
           return new AgentView(v);
   }

   if (userObject.getClass().equals(AgentModelBelieve.class)){
           return new AgentModelBelieveView(v);
   }

   if (userObject.getClass().equals(ApplicationEvent.class)){
           return new ApplicationEventView(v);
   }

   if (userObject.getClass().equals(ApplicationEventSlots.class)){
           return new ApplicationEventSlotsView(v);
   }

   if (userObject.getClass().equals(Application.class)){
           return new ApplicationView(v);
   }

   if (userObject.getClass().equals(AgentWS.class)){
           return new AgentWSView(v);
   }

   if (userObject.getClass().equals(Role.class)){
           return new RoleView(v);
   }

   if (userObject.getClass().equals(Goal.class)){
           return new GoalView(v);
   }

   if (userObject.getClass().equals(StateGoal.class)){
           return new StateGoalView(v);
   }

   if (userObject.getClass().equals(Task.class)){
           return new TaskView(v);
   }

   if (userObject.getClass().equals(Resource.class)){
           return new ResourceView(v);
   }

   if (userObject.getClass().equals(Fact.class)){
           return new FactView(v);
   }

   if (userObject.getClass().equals(FrameFact.class)){
           return new FrameFactView(v);
   }

   if (userObject.getClass().equals(Believe.class)){
           return new BelieveView(v);
   }

   if (userObject.getClass().equals(Compromise.class)){
           return new CompromiseView(v);
   }

   if (userObject.getClass().equals(GeneralEvent.class)){
           return new GeneralEventView(v);
   }

   if (userObject.getClass().equals(CommunicationEvent.class)){
           return new CommunicationEventView(v);
   }

   if (userObject.getClass().equals(EnvironmentApplication.class)){
           return new EnvironmentApplicationView(v);
   }

   if (userObject.getClass().equals(InternalApplication.class)){
           return new InternalApplicationView(v);
   }

   if (userObject.getClass().equals(TextNote.class)){
           return new TextNoteView(v);
   }

   if (userObject.getClass().equals(Plan.class)){
           return new PlanView(v);
   }

   if (userObject.getClass().equals(Conversation.class)){
           return new ConversationView(v);
   }

   if (userObject.getClass().equals(UMLComment.class)){
           return new UMLCommentView(v);
   }

   if (userObject.getClass().equals(Workflow.class)){
           return new WorkflowView(v);
   }

   if (userObject.getClass().equals(RoleWS.class)){
           return new RoleWSView(v);
   }

   if (userObject.getClass().equals(TaskWS.class)){
           return new TaskWSView(v);
   }

   if (userObject.getClass().equals(GoalStateWS.class)){
           return new GoalStateWSView(v);
   }

   if (userObject.getClass().equals(ApplicationWS.class)){
           return new ApplicationWSView(v);
   }

   if (userObject.getClass().equals(Interaction.class)){
           return new InteractionView(v);
   }


   // Diagram Relationships start here

   if (v.getClass().equals(GTPursuesEdge.class)){
           return new GTPursuesView(v);
   }

   if (v.getClass().equals(GTCreatesEdge.class)){
           return new GTCreatesView(v);
   }

   if (v.getClass().equals(GTAffectsEdge.class)){
           return new GTAffectsView(v);
   }

   if (v.getClass().equals(GTDestroysEdge.class)){
           return new GTDestroysView(v);
   }

   if (v.getClass().equals(GTModifiesEdge.class)){
           return new GTModifiesView(v);
   }

   if (v.getClass().equals(GTFailsEdge.class)){
           return new GTFailsView(v);
   }

   if (v.getClass().equals(GTSatisfiesEdge.class)){
           return new GTSatisfiesView(v);
   }

   if (v.getClass().equals(WFResponsableEdge.class)){
           return new WFResponsableView(v);
   }

   if (v.getClass().equals(WFConsumesEdge.class)){
           return new WFConsumesView(v);
   }

   if (v.getClass().equals(ConsumesEdge.class)){
           return new ConsumesView(v);
   }

   if (v.getClass().equals(WFUsesEdge.class)){
           return new WFUsesView(v);
   }

   if (v.getClass().equals(WFUsesMethodEdge.class)){
           return new WFUsesMethodView(v);
   }

   if (v.getClass().equals(WFProducesEdge.class)){
           return new WFProducesView(v);
   }

   if (v.getClass().equals(GTDecomposesEdge.class)){
           return new GTDecomposesView(v);
   }

   if (v.getClass().equals(GTDecomposesANDEdge.class)){
           return new GTDecomposesANDView(v);
   }

   if (v.getClass().equals(GTDecomposesOREdge.class)){
           return new GTDecomposesORView(v);
   }

   if (v.getClass().equals(GTDependsEdge.class)){
           return new GTDependsView(v);
   }

   if (v.getClass().equals(GTInheritsEdge.class)){
           return new GTInheritsView(v);
   }

   if (v.getClass().equals(GTAndDependsEdge.class)){
           return new GTAndDependsView(v);
   }

   if (v.getClass().equals(GTOrDependsEdge.class)){
           return new GTOrDependsView(v);
   }

   if (v.getClass().equals(WFDecomposesEdge.class)){
           return new WFDecomposesView(v);
   }

   if (v.getClass().equals(ContributeEdge.class)){
           return new ContributeView(v);
   }

   if (v.getClass().equals(ContributePositivelyEdge.class)){
           return new ContributePositivelyView(v);
   }

   if (v.getClass().equals(ContributeNegativelyEdge.class)){
           return new ContributeNegativelyView(v);
   }

   if (v.getClass().equals(UMLAnnotatedElementEdge.class)){
           return new UMLAnnotatedElementView(v);
   }

   if (v.getClass().equals(WFParticipatesEdge.class)){
           return new WFParticipatesView(v);
   }

   if (v.getClass().equals(WFCancelsEdge.class)){
           return new WFCancelsView(v);
   }

   if (v.getClass().equals(IAccessesEdge.class)){
           return new IAccessesView(v);
   }


    return null;
  }

  protected EdgeView createEdgeView(Object v) {
  return new EdgeView(v);

//         if (v instanceof ExecuteEdge){
//           return new ExecuteView(v,this,cm);
//         }

  }

 


}
