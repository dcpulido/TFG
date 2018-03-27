
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

public class OrganizationModelCellViewFactory implements CellViewFactory {

public OrganizationModelCellViewFactory() {}
 

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

   if (userObject.getClass().equals(Organization.class)){
           return new OrganizationView(v);
   }

   if (userObject.getClass().equals(OrganizationGroup.class)){
           return new OrganizationGroupView(v);
   }

   if (userObject.getClass().equals(OrganizationNetwork.class)){
           return new OrganizationNetworkView(v);
   }

   if (userObject.getClass().equals(Role.class)){
           return new RoleView(v);
   }

   if (userObject.getClass().equals(Resource.class)){
           return new ResourceView(v);
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

   if (userObject.getClass().equals(Task.class)){
           return new TaskView(v);
   }

   if (userObject.getClass().equals(Plan.class)){
           return new PlanView(v);
   }

   if (userObject.getClass().equals(Workflow.class)){
           return new WorkflowView(v);
   }

   if (userObject.getClass().equals(Interaction.class)){
           return new InteractionView(v);
   }

   if (userObject.getClass().equals(Goal.class)){
           return new GoalView(v);
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

   if (userObject.getClass().equals(GeneralEvent.class)){
           return new GeneralEventView(v);
   }

   if (userObject.getClass().equals(ApplicationEvent.class)){
           return new ApplicationEventView(v);
   }

   if (userObject.getClass().equals(ApplicationEventSlots.class)){
           return new ApplicationEventSlotsView(v);
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

   if (userObject.getClass().equals(TextNote.class)){
           return new TextNoteView(v);
   }

   if (userObject.getClass().equals(UMLComment.class)){
           return new UMLCommentView(v);
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

   if (userObject.getClass().equals(WorkflowBox.class)){
           return new WorkflowBoxView(v);
   }


   // Diagram Relationships start here

   if (v.getClass().equals(UMLAnnotatedElementEdge.class)){
           return new UMLAnnotatedElementView(v);
   }

   if (v.getClass().equals(EResourceBelongsToEdge.class)){
           return new EResourceBelongsToView(v);
   }

   if (v.getClass().equals(OHasGroupEdge.class)){
           return new OHasGroupView(v);
   }

   if (v.getClass().equals(OHasMemberEdge.class)){
           return new OHasMemberView(v);
   }

   if (v.getClass().equals(OHasWFEdge.class)){
           return new OHasWFView(v);
   }

   if (v.getClass().equals(ODecomposesGroupEdge.class)){
           return new ODecomposesGroupView(v);
   }

   if (v.getClass().equals(ODecomposesWFEdge.class)){
           return new ODecomposesWFView(v);
   }

   if (v.getClass().equals(GTPursuesEdge.class)){
           return new GTPursuesView(v);
   }

   if (v.getClass().equals(WFConnectsEdge.class)){
           return new WFConnectsView(v);
   }

   if (v.getClass().equals(WFUsesEdge.class)){
           return new WFUsesView(v);
   }

   if (v.getClass().equals(WFContainsTaskEdge.class)){
           return new WFContainsTaskView(v);
   }

   if (v.getClass().equals(WFConsumesEdge.class)){
           return new WFConsumesView(v);
   }

   if (v.getClass().equals(ConsumesEdge.class)){
           return new ConsumesView(v);
   }

   if (v.getClass().equals(WFDecomposesEdge.class)){
           return new WFDecomposesView(v);
   }

   if (v.getClass().equals(WFProducesEdge.class)){
           return new WFProducesView(v);
   }

   if (v.getClass().equals(AGORelationshipGroupEdge.class)){
           return new AGORelationshipGroupView(v);
   }

   if (v.getClass().equals(AGORelationshipMemberEdge.class)){
           return new AGORelationshipMemberView(v);
   }

   if (v.getClass().equals(AGORelationshipOrgEdge.class)){
           return new AGORelationshipOrgView(v);
   }

   if (v.getClass().equals(AGOSubordinationRelationshipGroupEdge.class)){
           return new AGOSubordinationRelationshipGroupView(v);
   }

   if (v.getClass().equals(AGOSubordinationRelationshipMemberEdge.class)){
           return new AGOSubordinationRelationshipMemberView(v);
   }

   if (v.getClass().equals(AGOSubordinationRelationshipOrgEdge.class)){
           return new AGOSubordinationRelationshipOrgView(v);
   }

   if (v.getClass().equals(AGOCondSubordinationRelationshipGroupEdge.class)){
           return new AGOCondSubordinationRelationshipGroupView(v);
   }

   if (v.getClass().equals(AGOCondSubordinationRelationshipMemberEdge.class)){
           return new AGOCondSubordinationRelationshipMemberView(v);
   }

   if (v.getClass().equals(AGOCondSubordinationRelationshipOrgEdge.class)){
           return new AGOCondSubordinationRelationshipOrgView(v);
   }

   if (v.getClass().equals(AGOInconditionalSubordinationRelationshipGroupEdge.class)){
           return new AGOInconditionalSubordinationRelationshipGroupView(v);
   }

   if (v.getClass().equals(AGOInconditionalSubordinationRelationshipMemberEdge.class)){
           return new AGOInconditionalSubordinationRelationshipMemberView(v);
   }

   if (v.getClass().equals(AGOInconditionalSubordinationRelationshipOrgEdge.class)){
           return new AGOInconditionalSubordinationRelationshipOrgView(v);
   }

   if (v.getClass().equals(AGOClientServerRelationshipGroupEdge.class)){
           return new AGOClientServerRelationshipGroupView(v);
   }

   if (v.getClass().equals(AGOClientServerRelationshipMemberEdge.class)){
           return new AGOClientServerRelationshipMemberView(v);
   }

   if (v.getClass().equals(AGOClientServerRelationshipOrgEdge.class)){
           return new AGOClientServerRelationshipOrgView(v);
   }

   if (v.getClass().equals(WFSpecifiesExecutionEdge.class)){
           return new WFSpecifiesExecutionView(v);
   }

   if (v.getClass().equals(WFResponsableEdge.class)){
           return new WFResponsableView(v);
   }

   if (v.getClass().equals(WFParticipatesEdge.class)){
           return new WFParticipatesView(v);
   }

   if (v.getClass().equals(WFPlaysEdge.class)){
           return new WFPlaysView(v);
   }

   if (v.getClass().equals(WFDecomposesWFEdge.class)){
           return new WFDecomposesWFView(v);
   }

   if (v.getClass().equals(UMLAnnotatedElementEdge.class)){
           return new UMLAnnotatedElementView(v);
   }

   if (v.getClass().equals(WSConnectsEdge.class)){
           return new WSConnectsView(v);
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
