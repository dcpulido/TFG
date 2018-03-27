
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

public class AgentModelCellViewFactory implements CellViewFactory {

public AgentModelCellViewFactory() {}
 

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

   if (userObject.getClass().equals(Role.class)){
           return new RoleView(v);
   }

   if (userObject.getClass().equals(Goal.class)){
           return new GoalView(v);
   }

   if (userObject.getClass().equals(Plan.class)){
           return new PlanView(v);
   }

   if (userObject.getClass().equals(StateGoal.class)){
           return new StateGoalView(v);
   }

   if (userObject.getClass().equals(Fact.class)){
           return new FactView(v);
   }

   if (userObject.getClass().equals(Task.class)){
           return new TaskView(v);
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

   if (userObject.getClass().equals(ApplicationEvent.class)){
           return new ApplicationEventView(v);
   }

   if (userObject.getClass().equals(ApplicationEventSlots.class)){
           return new ApplicationEventSlotsView(v);
   }

   if (userObject.getClass().equals(MentalStateProcessor.class)){
           return new MentalStateProcessorView(v);
   }

   if (userObject.getClass().equals(MentalStateManager.class)){
           return new MentalStateManagerView(v);
   }

   if (userObject.getClass().equals(MentalState.class)){
           return new MentalStateView(v);
   }

   if (userObject.getClass().equals(ConditionalMentalState.class)){
           return new ConditionalMentalStateView(v);
   }

   if (userObject.getClass().equals(AutonomousEntityQuery.class)){
           return new AutonomousEntityQueryView(v);
   }

   if (userObject.getClass().equals(AgentRequirementsQuery.class)){
           return new AgentRequirementsQueryView(v);
   }

   if (userObject.getClass().equals(ConcreteAgent.class)){
           return new ConcreteAgentView(v);
   }

   if (userObject.getClass().equals(AgentModelBelieve.class)){
           return new AgentModelBelieveView(v);
   }

   if (userObject.getClass().equals(Conversation.class)){
           return new ConversationView(v);
   }

   if (userObject.getClass().equals(UMLComment.class)){
           return new UMLCommentView(v);
   }

   if (userObject.getClass().equals(TextNote.class)){
           return new TextNoteView(v);
   }

   if (userObject.getClass().equals(Application.class)){
           return new ApplicationView(v);
   }

   if (userObject.getClass().equals(EnvironmentApplication.class)){
           return new EnvironmentApplicationView(v);
   }

   if (userObject.getClass().equals(InternalApplication.class)){
           return new InternalApplicationView(v);
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

   if (userObject.getClass().equals(AgentWS.class)){
           return new AgentWSView(v);
   }

   if (userObject.getClass().equals(MentalInstanceSpecification.class)){
           return new MentalInstanceSpecificationView(v);
   }


   // Diagram Relationships start here

   if (v.getClass().equals(GTPursuesEdge.class)){
           return new GTPursuesView(v);
   }

   if (v.getClass().equals(AInheritsEdge.class)){
           return new AInheritsView(v);
   }

   if (v.getClass().equals(AHasMSEdge.class)){
           return new AHasMSView(v);
   }

   if (v.getClass().equals(AHasMSManagerEdge.class)){
           return new AHasMSManagerView(v);
   }

   if (v.getClass().equals(AHasMSProcessorEdge.class)){
           return new AHasMSProcessorView(v);
   }

   if (v.getClass().equals(WFResponsableEdge.class)){
           return new WFResponsableView(v);
   }

   if (v.getClass().equals(AInstanceOfEdge.class)){
           return new AInstanceOfView(v);
   }

   if (v.getClass().equals(AContainsMEEdge.class)){
           return new AContainsMEView(v);
   }

   if (v.getClass().equals(WFPlaysEdge.class)){
           return new WFPlaysView(v);
   }

   if (v.getClass().equals(ARoleInheritanceEdge.class)){
           return new ARoleInheritanceView(v);
   }

   if (v.getClass().equals(UMLAnnotatedElementEdge.class)){
           return new UMLAnnotatedElementView(v);
   }

   if (v.getClass().equals(WFUsesEdge.class)){
           return new WFUsesView(v);
   }

   if (v.getClass().equals(EResourceBelongsToEdge.class)){
           return new EResourceBelongsToView(v);
   }

   if (v.getClass().equals(ApplicationBelongsToEdge.class)){
           return new ApplicationBelongsToView(v);
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
