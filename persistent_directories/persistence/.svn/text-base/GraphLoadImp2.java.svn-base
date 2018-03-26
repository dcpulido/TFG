




/*
    Copyright (C) 2002 Jorge Gomez Sanz, Ruben Fuentes

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
package ingenias.editor.persistence;
import java.lang.reflect.*;
import javax.swing.tree.*;
import org.apache.xerces.parsers.DOMParser;
import org.xml.sax.InputSource;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.OutputStreamWriter;
import java.io.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.*;
import java.util.Map;
import java.util.Hashtable;
import java.util.ArrayList;
import javax.xml.parsers.*;
import org.jgraph.JGraph;
import org.jgraph.graph.*;
import org.w3c.dom.*;
import org.w3c.dom.Document;
import org.w3c.dom.DOMImplementation;
import ingenias.editor.entities.*;
import ingenias.exception.*;
import ingenias.editor.cell.*;
import ingenias.editor.*;


public class GraphLoadImp2 extends GraphLoadImp2Abs
    implements GraphLoad {

  /**
   *  Constructor for the GraphLoad object
   */
  public GraphLoadImp2() {}


  // Convert a vertex represented by a GXL DOM node in a DefaultGraphCell.
  // ids contains the already processed vertex ids.

  protected DefaultGraphCell GXLVertex(String id, String type, ModelJGraph graph,
                                    ObjectManager om, RelationshipManager rm) {

    DefaultGraphCell vertex = null;

    ingenias.editor.entities.Entity en = om.getEntity(id, type);
    // if it is registered in the OM, then it is a diagram object
    if (en != null) {


   	if (en.getClass().equals(ingenias.editor.entities.DecisionNode.class))
	  return  new ingenias.editor.cell.DecisionNodeCell((DecisionNode)en);

   	if (en.getClass().equals(ingenias.editor.entities.TestingPackage.class))
	  return  new ingenias.editor.cell.TestingPackageCell((TestingPackage)en);

   	if (en.getClass().equals(ingenias.editor.entities.MentalState.class))
	  return  new ingenias.editor.cell.MentalStateCell((MentalState)en);

   	if (en.getClass().equals(ingenias.editor.entities.InternalApplication.class))
	  return  new ingenias.editor.cell.InternalApplicationCell((InternalApplication)en);

   	if (en.getClass().equals(ingenias.editor.entities.Goal.class))
	  return  new ingenias.editor.cell.GoalCell((Goal)en);

   	if (en.getClass().equals(ingenias.editor.entities.AgentWS.class))
	  return  new ingenias.editor.cell.AgentWSCell((AgentWS)en);

   	if (en.getClass().equals(ingenias.editor.entities.Fact.class))
	  return  new ingenias.editor.cell.FactCell((Fact)en);

   	if (en.getClass().equals(ingenias.editor.entities.ShareTouple.class))
	  return  new ingenias.editor.cell.ShareToupleCell((ShareTouple)en);

   	if (en.getClass().equals(ingenias.editor.entities.DeploymentUnitByTypeWithInitMS.class))
	  return  new ingenias.editor.cell.DeploymentUnitByTypeWithInitMSCell((DeploymentUnitByTypeWithInitMS)en);

   	if (en.getClass().equals(ingenias.editor.entities.JoinNode.class))
	  return  new ingenias.editor.cell.JoinNodeCell((JoinNode)en);

   	if (en.getClass().equals(ingenias.editor.entities.RuntimeEvent.class))
	  return  new ingenias.editor.cell.RuntimeEventCell((RuntimeEvent)en);

   	if (en.getClass().equals(ingenias.editor.entities.InitialNode.class))
	  return  new ingenias.editor.cell.InitialNodeCell((InitialNode)en);

   	if (en.getClass().equals(ingenias.editor.entities.TextUseCase.class))
	  return  new ingenias.editor.cell.TextUseCaseCell((TextUseCase)en);

   	if (en.getClass().equals(ingenias.editor.entities.RemoteProcedureCall.class))
	  return  new ingenias.editor.cell.RemoteProcedureCallCell((RemoteProcedureCall)en);

   	if (en.getClass().equals(ingenias.editor.entities.Resource.class))
	  return  new ingenias.editor.cell.ResourceCell((Resource)en);

   	if (en.getClass().equals(ingenias.editor.entities.AgentModelBelieve.class))
	  return  new ingenias.editor.cell.AgentModelBelieveCell((AgentModelBelieve)en);

   	if (en.getClass().equals(ingenias.editor.entities.ActivityFinal.class))
	  return  new ingenias.editor.cell.ActivityFinalCell((ActivityFinal)en);

   	if (en.getClass().equals(ingenias.editor.entities.INGENIASUseCase.class))
	  return  new ingenias.editor.cell.INGENIASUseCaseCell((INGENIASUseCase)en);

   	if (en.getClass().equals(ingenias.editor.entities.TextNote.class))
	  return  new ingenias.editor.cell.TextNoteCell((TextNote)en);

   	if (en.getClass().equals(ingenias.editor.entities.RuntimeFact.class))
	  return  new ingenias.editor.cell.RuntimeFactCell((RuntimeFact)en);

   	if (en.getClass().equals(ingenias.editor.entities.ForkNode.class))
	  return  new ingenias.editor.cell.ForkNodeCell((ForkNode)en);

   	if (en.getClass().equals(ingenias.editor.entities.OrganizationNetwork.class))
	  return  new ingenias.editor.cell.OrganizationNetworkCell((OrganizationNetwork)en);

   	if (en.getClass().equals(ingenias.editor.entities.MessagePassing.class))
	  return  new ingenias.editor.cell.MessagePassingCell((MessagePassing)en);

   	if (en.getClass().equals(ingenias.editor.entities.SubProtocol.class))
	  return  new ingenias.editor.cell.SubProtocolCell((SubProtocol)en);

   	if (en.getClass().equals(ingenias.editor.entities.RuntimeConversation.class))
	  return  new ingenias.editor.cell.RuntimeConversationCell((RuntimeConversation)en);

   	if (en.getClass().equals(ingenias.editor.entities.AUMLComponent.class))
	  return  new ingenias.editor.cell.AUMLComponentCell((AUMLComponent)en);

   	if (en.getClass().equals(ingenias.editor.entities.Organization.class))
	  return  new ingenias.editor.cell.OrganizationCell((Organization)en);

   	if (en.getClass().equals(ingenias.editor.entities.ConditionalMentalState.class))
	  return  new ingenias.editor.cell.ConditionalMentalStateCell((ConditionalMentalState)en);

   	if (en.getClass().equals(ingenias.editor.entities.ApplicationWS.class))
	  return  new ingenias.editor.cell.ApplicationWSCell((ApplicationWS)en);

   	if (en.getClass().equals(ingenias.editor.entities.AUMLSpecification.class))
	  return  new ingenias.editor.cell.AUMLSpecificationCell((AUMLSpecification)en);

   	if (en.getClass().equals(ingenias.editor.entities.Application.class))
	  return  new ingenias.editor.cell.ApplicationCell((Application)en);

   	if (en.getClass().equals(ingenias.editor.entities.DeploymentPackage.class))
	  return  new ingenias.editor.cell.DeploymentPackageCell((DeploymentPackage)en);

   	if (en.getClass().equals(ingenias.editor.entities.Plan.class))
	  return  new ingenias.editor.cell.PlanCell((Plan)en);

   	if (en.getClass().equals(ingenias.editor.entities.AUMLPort.class))
	  return  new ingenias.editor.cell.AUMLPortCell((AUMLPort)en);

   	if (en.getClass().equals(ingenias.editor.entities.INGENIASComponent.class))
	  return  new ingenias.editor.cell.INGENIASComponentCell((INGENIASComponent)en);

   	if (en.getClass().equals(ingenias.editor.entities.OrganizationGroup.class))
	  return  new ingenias.editor.cell.OrganizationGroupCell((OrganizationGroup)en);

   	if (en.getClass().equals(ingenias.editor.entities.IUConcurrence.class))
	  return  new ingenias.editor.cell.IUConcurrenceCell((IUConcurrence)en);

   	if (en.getClass().equals(ingenias.editor.entities.DeploymentUnitByType.class))
	  return  new ingenias.editor.cell.DeploymentUnitByTypeCell((DeploymentUnitByType)en);

   	if (en.getClass().equals(ingenias.editor.entities.IUIterate.class))
	  return  new ingenias.editor.cell.IUIterateCell((IUIterate)en);

   	if (en.getClass().equals(ingenias.editor.entities.AUMLAlternativeRow.class))
	  return  new ingenias.editor.cell.AUMLAlternativeRowCell((AUMLAlternativeRow)en);

   	if (en.getClass().equals(ingenias.editor.entities.Column.class))
	  return  new ingenias.editor.cell.ColumnCell((Column)en);

   	if (en.getClass().equals(ingenias.editor.entities.AutonomousEntityQuery.class))
	  return  new ingenias.editor.cell.AutonomousEntityQueryCell((AutonomousEntityQuery)en);

   	if (en.getClass().equals(ingenias.editor.entities.AUMLContainer.class))
	  return  new ingenias.editor.cell.AUMLContainerCell((AUMLContainer)en);

   	if (en.getClass().equals(ingenias.editor.entities.ConcreteAgent.class))
	  return  new ingenias.editor.cell.ConcreteAgentCell((ConcreteAgent)en);

   	if (en.getClass().equals(ingenias.editor.entities.UMLComment.class))
	  return  new ingenias.editor.cell.UMLCommentCell((UMLComment)en);

   	if (en.getClass().equals(ingenias.editor.entities.AgentRequirementsQuery.class))
	  return  new ingenias.editor.cell.AgentRequirementsQueryCell((AgentRequirementsQuery)en);

   	if (en.getClass().equals(ingenias.editor.entities.UMLSpecification.class))
	  return  new ingenias.editor.cell.UMLSpecificationCell((UMLSpecification)en);

   	if (en.getClass().equals(ingenias.editor.entities.Believe.class))
	  return  new ingenias.editor.cell.BelieveCell((Believe)en);

   	if (en.getClass().equals(ingenias.editor.entities.WorkflowBox.class))
	  return  new ingenias.editor.cell.WorkflowBoxCell((WorkflowBox)en);

   	if (en.getClass().equals(ingenias.editor.entities.DeploymentUnitByTypeEnumInitMS.class))
	  return  new ingenias.editor.cell.DeploymentUnitByTypeEnumInitMSCell((DeploymentUnitByTypeEnumInitMS)en);

   	if (en.getClass().equals(ingenias.editor.entities.GeneralEvent.class))
	  return  new ingenias.editor.cell.GeneralEventCell((GeneralEvent)en);

   	if (en.getClass().equals(ingenias.editor.entities.Compromise.class))
	  return  new ingenias.editor.cell.CompromiseCell((Compromise)en);

   	if (en.getClass().equals(ingenias.editor.entities.Role.class))
	  return  new ingenias.editor.cell.RoleCell((Role)en);

   	if (en.getClass().equals(ingenias.editor.entities.EnvironmentApplication.class))
	  return  new ingenias.editor.cell.EnvironmentApplicationCell((EnvironmentApplication)en);

   	if (en.getClass().equals(ingenias.editor.entities.ApplicationEventSlots.class))
	  return  new ingenias.editor.cell.ApplicationEventSlotsCell((ApplicationEventSlots)en);

   	if (en.getClass().equals(ingenias.editor.entities.Protocol.class))
	  return  new ingenias.editor.cell.ProtocolCell((Protocol)en);

   	if (en.getClass().equals(ingenias.editor.entities.MentalInstanceSpecification.class))
	  return  new ingenias.editor.cell.MentalInstanceSpecificationCell((MentalInstanceSpecification)en);

   	if (en.getClass().equals(ingenias.editor.entities.ActionUML.class))
	  return  new ingenias.editor.cell.ActionUMLCell((ActionUML)en);

   	if (en.getClass().equals(ingenias.editor.entities.InteractionUnit.class))
	  return  new ingenias.editor.cell.InteractionUnitCell((InteractionUnit)en);

   	if (en.getClass().equals(ingenias.editor.entities.GRASIASpecification.class))
	  return  new ingenias.editor.cell.GRASIASpecificationCell((GRASIASpecification)en);

   	if (en.getClass().equals(ingenias.editor.entities.MentalStateProcessor.class))
	  return  new ingenias.editor.cell.MentalStateProcessorCell((MentalStateProcessor)en);

   	if (en.getClass().equals(ingenias.editor.entities.MergeNode.class))
	  return  new ingenias.editor.cell.MergeNodeCell((MergeNode)en);

   	if (en.getClass().equals(ingenias.editor.entities.EndNode.class))
	  return  new ingenias.editor.cell.EndNodeCell((EndNode)en);

   	if (en.getClass().equals(ingenias.editor.entities.FrameFact.class))
	  return  new ingenias.editor.cell.FrameFactCell((FrameFact)en);

   	if (en.getClass().equals(ingenias.editor.entities.Test.class))
	  return  new ingenias.editor.cell.TestCell((Test)en);

   	if (en.getClass().equals(ingenias.editor.entities.Lifeline.class))
	  return  new ingenias.editor.cell.LifelineCell((Lifeline)en);

   	if (en.getClass().equals(ingenias.editor.entities.Interaction.class))
	  return  new ingenias.editor.cell.InteractionCell((Interaction)en);

   	if (en.getClass().equals(ingenias.editor.entities.Agent.class))
	  return  new ingenias.editor.cell.AgentCell((Agent)en);

   	if (en.getClass().equals(ingenias.editor.entities.MentalStateManager.class))
	  return  new ingenias.editor.cell.MentalStateManagerCell((MentalStateManager)en);

   	if (en.getClass().equals(ingenias.editor.entities.INGENIASCodeComponent.class))
	  return  new ingenias.editor.cell.INGENIASCodeComponentCell((INGENIASCodeComponent)en);

   	if (en.getClass().equals(ingenias.editor.entities.CommunicationEvent.class))
	  return  new ingenias.editor.cell.CommunicationEventCell((CommunicationEvent)en);

   	if (en.getClass().equals(ingenias.editor.entities.TaskWS.class))
	  return  new ingenias.editor.cell.TaskWSCell((TaskWS)en);

   	if (en.getClass().equals(ingenias.editor.entities.GoalStateWS.class))
	  return  new ingenias.editor.cell.GoalStateWSCell((GoalStateWS)en);

   	if (en.getClass().equals(ingenias.editor.entities.StateGoal.class))
	  return  new ingenias.editor.cell.StateGoalCell((StateGoal)en);

   	if (en.getClass().equals(ingenias.editor.entities.Conversation.class))
	  return  new ingenias.editor.cell.ConversationCell((Conversation)en);

   	if (en.getClass().equals(ingenias.editor.entities.ApplicationEvent.class))
	  return  new ingenias.editor.cell.ApplicationEventCell((ApplicationEvent)en);

   	if (en.getClass().equals(ingenias.editor.entities.Task.class))
	  return  new ingenias.editor.cell.TaskCell((Task)en);

   	if (en.getClass().equals(ingenias.editor.entities.DeploymentUnitByTypeMSEntity.class))
	  return  new ingenias.editor.cell.DeploymentUnitByTypeMSEntityCell((DeploymentUnitByTypeMSEntity)en);

   	if (en.getClass().equals(ingenias.editor.entities.RoleWS.class))
	  return  new ingenias.editor.cell.RoleWSCell((RoleWS)en);

   	if (en.getClass().equals(ingenias.editor.entities.AUMLAlternativeBox.class))
	  return  new ingenias.editor.cell.AUMLAlternativeBoxCell((AUMLAlternativeBox)en);

   	if (en.getClass().equals(ingenias.editor.entities.Workflow.class))
	  return  new ingenias.editor.cell.WorkflowCell((Workflow)en);

    } else {
    // If not, it is a relationship
      en = rm.getRelationship(id);
    if (en==null) return null;

    if (en instanceof AHasMSManager)
     return  new AHasMSManagerEdge((AHasMSManager)en);

    if (en instanceof AGOInconditionalSubordinationRelationshipOrg)
     return  new AGOInconditionalSubordinationRelationshipOrgEdge((AGOInconditionalSubordinationRelationshipOrg)en);

    if (en instanceof GTDecomposes)
     return  new GTDecomposesEdge((GTDecomposes)en);

    if (en instanceof WFResponsible)
     return  new WFResponsibleEdge((WFResponsible)en);

    if (en instanceof CDUsesCode)
     return  new CDUsesCodeEdge((CDUsesCode)en);

    if (en instanceof AGOCondSubordinationRelationshipGroup)
     return  new AGOCondSubordinationRelationshipGroupEdge((AGOCondSubordinationRelationshipGroup)en);

    if (en instanceof OHasMember)
     return  new OHasMemberEdge((OHasMember)en);

    if (en instanceof EPerceivesPolling)
     return  new EPerceivesPollingEdge((EPerceivesPolling)en);

    if (en instanceof WFParticipates)
     return  new WFParticipatesEdge((WFParticipates)en);

    if (en instanceof WFDecomposesWF)
     return  new WFDecomposesWFEdge((WFDecomposesWF)en);

    if (en instanceof UIInitiates)
     return  new UIInitiatesEdge((UIInitiates)en);

    if (en instanceof ContributeNegatively)
     return  new ContributeNegativelyEdge((ContributeNegatively)en);

    if (en instanceof DefinesDeployment)
     return  new DefinesDeploymentEdge((DefinesDeployment)en);

    if (en instanceof WFUsesMethod)
     return  new WFUsesMethodEdge((WFUsesMethod)en);

    if (en instanceof UISelection)
     return  new UISelectionEdge((UISelection)en);

    if (en instanceof EPerceivesNotification)
     return  new EPerceivesNotificationEdge((EPerceivesNotification)en);

    if (en instanceof OHasWF)
     return  new OHasWFEdge((OHasWF)en);

    if (en instanceof ParticipatesInUseCase)
     return  new ParticipatesInUseCaseEdge((ParticipatesInUseCase)en);

    if (en instanceof GTCreates)
     return  new GTCreatesEdge((GTCreates)en);

    if (en instanceof WFCancels)
     return  new WFCancelsEdge((WFCancels)en);

    if (en instanceof AGOInconditionalSubordinationRelationshipGroup)
     return  new AGOInconditionalSubordinationRelationshipGroupEdge((AGOInconditionalSubordinationRelationshipGroup)en);

    if (en instanceof AUMLSendSimple)
     return  new AUMLSendSimpleEdge((AUMLSendSimple)en);

    if (en instanceof GTModifies)
     return  new GTModifiesEdge((GTModifies)en);

    if (en instanceof WFProduces)
     return  new WFProducesEdge((WFProduces)en);

    if (en instanceof GTPursues)
     return  new GTPursuesEdge((GTPursues)en);

    if (en instanceof UseCasePursues)
     return  new UseCasePursuesEdge((UseCasePursues)en);

    if (en instanceof EPerceives)
     return  new EPerceivesEdge((EPerceives)en);

    if (en instanceof ODecomposesWF)
     return  new ODecomposesWFEdge((ODecomposesWF)en);

    if (en instanceof WFFollows)
     return  new WFFollowsEdge((WFFollows)en);

    if (en instanceof WFDecomposes)
     return  new WFDecomposesEdge((WFDecomposes)en);

    if (en instanceof AGOClientServerRelationshipMember)
     return  new AGOClientServerRelationshipMemberEdge((AGOClientServerRelationshipMember)en);

    if (en instanceof WFSpecifiesExecution)
     return  new WFSpecifiesExecutionEdge((WFSpecifiesExecution)en);

    if (en instanceof AInstanceOf)
     return  new AInstanceOfEdge((AInstanceOf)en);

    if (en instanceof AGORelationshipGroup)
     return  new AGORelationshipGroupEdge((AGORelationshipGroup)en);

    if (en instanceof AGORelationshipMember)
     return  new AGORelationshipMemberEdge((AGORelationshipMember)en);

    if (en instanceof AInherits)
     return  new AInheritsEdge((AInherits)en);

    if (en instanceof GTFails)
     return  new GTFailsEdge((GTFails)en);

    if (en instanceof AGOClientServerRelationshipOrg)
     return  new AGOClientServerRelationshipOrgEdge((AGOClientServerRelationshipOrg)en);

    if (en instanceof AGOSubordinationRelationshipOrg)
     return  new AGOSubordinationRelationshipOrgEdge((AGOSubordinationRelationshipOrg)en);

    if (en instanceof GTDepends)
     return  new GTDependsEdge((GTDepends)en);

    if (en instanceof Includes)
     return  new IncludesEdge((Includes)en);

    if (en instanceof IHasSpec)
     return  new IHasSpecEdge((IHasSpec)en);

    if (en instanceof WFPursue)
     return  new WFPursueEdge((WFPursue)en);

    if (en instanceof EResourceBelongsTo)
     return  new EResourceBelongsToEdge((EResourceBelongsTo)en);

    if (en instanceof WFConsumes)
     return  new WFConsumesEdge((WFConsumes)en);

    if (en instanceof Generalizes)
     return  new GeneralizesEdge((Generalizes)en);

    if (en instanceof AHasMSProcessor)
     return  new AHasMSProcessorEdge((AHasMSProcessor)en);

    if (en instanceof AGOSubordinationRelationshipGroup)
     return  new AGOSubordinationRelationshipGroupEdge((AGOSubordinationRelationshipGroup)en);

    if (en instanceof GroupBelongsToOrganization)
     return  new GroupBelongsToOrganizationEdge((GroupBelongsToOrganization)en);

    if (en instanceof AContainsME)
     return  new AContainsMEEdge((AContainsME)en);

    if (en instanceof GTOrDepends)
     return  new GTOrDependsEdge((GTOrDepends)en);

    if (en instanceof AUMLUseProtocol)
     return  new AUMLUseProtocolEdge((AUMLUseProtocol)en);

    if (en instanceof GTAndDepends)
     return  new GTAndDependsEdge((GTAndDepends)en);

    if (en instanceof ODecomposesGroup)
     return  new ODecomposesGroupEdge((ODecomposesGroup)en);

    if (en instanceof IInitiates)
     return  new IInitiatesEdge((IInitiates)en);

    if (en instanceof Contribute)
     return  new ContributeEdge((Contribute)en);

    if (en instanceof AGORelationshipOrg)
     return  new AGORelationshipOrgEdge((AGORelationshipOrg)en);

    if (en instanceof Consumes)
     return  new ConsumesEdge((Consumes)en);

    if (en instanceof AHasMS)
     return  new AHasMSEdge((AHasMS)en);

    if (en instanceof UMLDescribesUseCase)
     return  new UMLDescribesUseCaseEdge((UMLDescribesUseCase)en);

    if (en instanceof IColaborates)
     return  new IColaboratesEdge((IColaborates)en);

    if (en instanceof WFFollowsGuarded)
     return  new WFFollowsGuardedEdge((WFFollowsGuarded)en);

    if (en instanceof GTAffects)
     return  new GTAffectsEdge((GTAffects)en);

    if (en instanceof IAccesses)
     return  new IAccessesEdge((IAccesses)en);

    if (en instanceof UIPrecedes)
     return  new UIPrecedesEdge((UIPrecedes)en);

    if (en instanceof ARoleInheritance)
     return  new ARoleInheritanceEdge((ARoleInheritance)en);

    if (en instanceof AGOInconditionalSubordinationRelationshipMember)
     return  new AGOInconditionalSubordinationRelationshipMemberEdge((AGOInconditionalSubordinationRelationshipMember)en);

    if (en instanceof WFStarts)
     return  new WFStartsEdge((WFStarts)en);

    if (en instanceof UMLSendsMessage)
     return  new UMLSendsMessageEdge((UMLSendsMessage)en);

    if (en instanceof UMLAssociation)
     return  new UMLAssociationEdge((UMLAssociation)en);

    if (en instanceof OHasGroup)
     return  new OHasGroupEdge((OHasGroup)en);

    if (en instanceof WFResponsable)
     return  new WFResponsableEdge((WFResponsable)en);

    if (en instanceof WFContainsTask)
     return  new WFContainsTaskEdge((WFContainsTask)en);

    if (en instanceof UMLRealizes)
     return  new UMLRealizesEdge((UMLRealizes)en);

    if (en instanceof WFConnects)
     return  new WFConnectsEdge((WFConnects)en);

    if (en instanceof Extends)
     return  new ExtendsEdge((Extends)en);

    if (en instanceof GTInherits)
     return  new GTInheritsEdge((GTInherits)en);

    if (en instanceof GTDecomposesAND)
     return  new GTDecomposesANDEdge((GTDecomposesAND)en);

    if (en instanceof WFEnds)
     return  new WFEndsEdge((WFEnds)en);

    if (en instanceof AUMLSelection)
     return  new AUMLSelectionEdge((AUMLSelection)en);

    if (en instanceof UMLAnnotatedElement)
     return  new UMLAnnotatedElementEdge((UMLAnnotatedElement)en);

    if (en instanceof UIColaborates)
     return  new UIColaboratesEdge((UIColaborates)en);

    if (en instanceof WFPlays)
     return  new WFPlaysEdge((WFPlays)en);

    if (en instanceof AGOClientServerRelationshipGroup)
     return  new AGOClientServerRelationshipGroupEdge((AGOClientServerRelationshipGroup)en);

    if (en instanceof GTDestroys)
     return  new GTDestroysEdge((GTDestroys)en);

    if (en instanceof IPursues)
     return  new IPursuesEdge((IPursues)en);

    if (en instanceof ApplicationBelongsTo)
     return  new ApplicationBelongsToEdge((ApplicationBelongsTo)en);

    if (en instanceof AGOSubordinationRelationshipMember)
     return  new AGOSubordinationRelationshipMemberEdge((AGOSubordinationRelationshipMember)en);

    if (en instanceof WSConnects)
     return  new WSConnectsEdge((WSConnects)en);

    if (en instanceof GTDecomposesOR)
     return  new GTDecomposesOREdge((GTDecomposesOR)en);

    if (en instanceof AGOCondSubordinationRelationshipOrg)
     return  new AGOCondSubordinationRelationshipOrgEdge((AGOCondSubordinationRelationshipOrg)en);

    if (en instanceof GTSatisfies)
     return  new GTSatisfiesEdge((GTSatisfies)en);

    if (en instanceof AGOCondSubordinationRelationshipMember)
     return  new AGOCondSubordinationRelationshipMemberEdge((AGOCondSubordinationRelationshipMember)en);

    if (en instanceof WFUses)
     return  new WFUsesEdge((WFUses)en);

    if (en instanceof WFDecides)
     return  new WFDecidesEdge((WFDecides)en);

    if (en instanceof ContributePositively)
     return  new ContributePositivelyEdge((ContributePositively)en);


    }

    return null;
  }


 
}





