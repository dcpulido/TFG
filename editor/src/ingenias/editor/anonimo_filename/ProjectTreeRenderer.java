
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

import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;
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

public class ProjectTreeRenderer extends javax.swing.tree.DefaultTreeCellRenderer{
    // Meta-models icons
    
    static ImageIcon modeloEnvironmentModel=new ImageIcon(ImageLoader.getImage("images/menvdiag.gif"));
    
    static ImageIcon modeloComponentDiagram=new ImageIcon(ImageLoader.getImage("images/musediag.gif"));
    
    static ImageIcon modeloOrganizationModel=new ImageIcon(ImageLoader.getImage("images/morgdiag.gif"));
    
    static ImageIcon modeloTasksAndGoalsModel=new ImageIcon(ImageLoader.getImage("images/mtaskgoal.gif"));
    
    static ImageIcon modeloInteractionModel=new ImageIcon(ImageLoader.getImage("images/minterdiag.gif"));
    
    static ImageIcon modeloActivityDiagram=new ImageIcon(ImageLoader.getImage("images/mtaskWFDiag.png"));
    
    static ImageIcon modeloAgentModel=new ImageIcon(ImageLoader.getImage("images/magdiag.gif"));
    
    static ImageIcon modeloUseCaseDiagram=new ImageIcon(ImageLoader.getImage("images/musediag.png"));
    
    static ImageIcon modeloWorkProductDiagram=new ImageIcon(ImageLoader.getImage("images/mWorkPDiag.png"));

    static ImageIcon modeloActivityWPDiagram=new ImageIcon(ImageLoader.getImage("images/mtaskWFDiag.png"));
    
    static ImageIcon modeloPhaseDiagram=new ImageIcon(ImageLoader.getImage("images/mPhaseDiag.png"));
    
    static ImageIcon modeloRoleDiagram=new ImageIcon(ImageLoader.getImage("images/mactStrDiag.png"));
    
    static ImageIcon modeloDeployDiagram=new ImageIcon(ImageLoader.getImage("images/musediag.gif"));
    
    
    // Object icons
    
    static ImageIcon DecisionNodeIcon=new ImageIcon(ImageLoader.getImage("images/mdecisionnode.png"));
    
    static ImageIcon TestingPackageIcon=new ImageIcon(ImageLoader.getImage("images/mdepl.gif"));
    
    static ImageIcon MentalStateIcon=new ImageIcon(ImageLoader.getImage("images/mmstate.gif"));
    
    static ImageIcon InternalApplicationIcon=new ImageIcon(ImageLoader.getImage("images/mappi.gif"));
    
    static ImageIcon GoalIcon=new ImageIcon(ImageLoader.getImage("images/mgoal.gif"));
    
    static ImageIcon AgentWSIcon=new ImageIcon(ImageLoader.getImage("images/magentws.gif"));
    
    static ImageIcon FactIcon=new ImageIcon(ImageLoader.getImage("images/mfact.png"));
    
    static ImageIcon ShareToupleIcon=new ImageIcon(ImageLoader.getImage("images/miu.gif"));
    
    static ImageIcon DeploymentUnitByTypeWithInitMSIcon=new ImageIcon(ImageLoader.getImage("images/mimtypedepl.gif"));
    
    static ImageIcon JoinNodeIcon=new ImageIcon(ImageLoader.getImage("images/mhforknode.png"));
    
    static ImageIcon RuntimeEventIcon=new ImageIcon(ImageLoader.getImage("images/mffact.png"));
    
    static ImageIcon InitialNodeIcon=new ImageIcon(ImageLoader.getImage("images/mdpdfiNode.png"));
    
    static ImageIcon TextUseCaseIcon=new ImageIcon(ImageLoader.getImage("images/musecase.gif"));
    
    static ImageIcon RemoteProcedureCallIcon=new ImageIcon(ImageLoader.getImage("images/miu.gif"));
    
    static ImageIcon ResourceIcon=new ImageIcon(ImageLoader.getImage("images/mresource.gif"));
    
    static ImageIcon WorkProductIcon=new ImageIcon(ImageLoader.getImage("images/mdpdfcompWP.png"));
    
    static ImageIcon FreeWPIcon=new ImageIcon(ImageLoader.getImage("images/mdpdffreeWP.png"));
    
    static ImageIcon StructuralWPIcon=new ImageIcon(ImageLoader.getImage("images/mdpdfstructWP.png"));
    
    static ImageIcon StructuredWPIcon=new ImageIcon(ImageLoader.getImage("images/mdpdfStredWP.png"));
    
    static ImageIcon BehaviourWPIcon=new ImageIcon(ImageLoader.getImage("images/mdpdfbehWP.png"));
    
    static ImageIcon DPDFSMMatIcon=new ImageIcon(ImageLoader.getImage("images/mdpdfSMMat.png"));
    
    static ImageIcon DPDFSMMelIcon=new ImageIcon(ImageLoader.getImage("images/mdpdfSMMel.png"));
    
    static ImageIcon DPDFSMMopIcon=new ImageIcon(ImageLoader.getImage("images/mdpdfSMMop.png"));
    
    static ImageIcon AgentModelBelieveIcon=new ImageIcon(ImageLoader.getImage("images/mabel.gif"));
    
    static ImageIcon ActivityFinalIcon=new ImageIcon(ImageLoader.getImage("images/mfinalnode.gif"));
    
    static ImageIcon INGENIASUseCaseIcon=new ImageIcon(ImageLoader.getImage("images/miusecase.gif"));
    
    static ImageIcon TextNoteIcon=new ImageIcon(ImageLoader.getImage("images/mtext.gif"));
    
    static ImageIcon RuntimeFactIcon=new ImageIcon(ImageLoader.getImage("images/mffact.png"));
    
    static ImageIcon ForkNodeIcon=new ImageIcon(ImageLoader.getImage("images/mforknode.png"));
    
    static ImageIcon OrganizationNetworkIcon=new ImageIcon(ImageLoader.getImage("images/mnetwork.gif"));
    
    static ImageIcon MessagePassingIcon=new ImageIcon(ImageLoader.getImage("images/miu.gif"));
    
    static ImageIcon SubProtocolIcon=new ImageIcon(ImageLoader.getImage("images/prot.png"));
    
    static ImageIcon RuntimeConversationIcon=new ImageIcon(ImageLoader.getImage("images/mconv.png"));
    
    static ImageIcon AUMLComponentIcon=new ImageIcon(ImageLoader.getImage("images/magent.gif"));
    
    static ImageIcon OrganizationIcon=new ImageIcon(ImageLoader.getImage("images/morg.gif"));
    
    static ImageIcon ConditionalMentalStateIcon=new ImageIcon(ImageLoader.getImage("images/mcmstate.gif"));
    
    static ImageIcon ApplicationWSIcon=new ImageIcon(ImageLoader.getImage("images/mapp.gif"));
    
    static ImageIcon AUMLSpecificationIcon=new ImageIcon(ImageLoader.getImage("images/maumlspec.gif"));
    
    static ImageIcon ApplicationIcon=new ImageIcon(ImageLoader.getImage("images/mapp.gif"));
    
    static ImageIcon DeploymentPackageIcon=new ImageIcon(ImageLoader.getImage("images/mdepl.gif"));
    
    static ImageIcon PlanIcon=new ImageIcon(ImageLoader.getImage("images/mplan.gif"));
    
    static ImageIcon AUMLPortIcon=new ImageIcon(ImageLoader.getImage("images/magent.gif"));
    
    static ImageIcon INGENIASComponentIcon=new ImageIcon(ImageLoader.getImage("images/micomponent.gif"));
    
    static ImageIcon OrganizationGroupIcon=new ImageIcon(ImageLoader.getImage("images/mgroup.gif"));
    
    static ImageIcon IUConcurrenceIcon=new ImageIcon(ImageLoader.getImage("images/mconc.gif"));
    
    static ImageIcon DeploymentUnitByTypeIcon=new ImageIcon(ImageLoader.getImage("images/mtypedepl.gif"));
    
    static ImageIcon IUIterateIcon=new ImageIcon(ImageLoader.getImage("images/mit.gif"));
    
    static ImageIcon AUMLAlternativeRowIcon=new ImageIcon(ImageLoader.getImage("images/altr.png"));
    
    static ImageIcon ColumnIcon=new ImageIcon(ImageLoader.getImage("images/col.png"));
    
    static ImageIcon AutonomousEntityQueryIcon=new ImageIcon(ImageLoader.getImage("images/mquery.gif"));
    
    static ImageIcon AUMLContainerIcon=new ImageIcon(ImageLoader.getImage("images/magent.gif"));
    
    static ImageIcon ConcreteAgentIcon=new ImageIcon(ImageLoader.getImage("images/mcaquery.gif"));
    
    static ImageIcon UMLCommentIcon=new ImageIcon(ImageLoader.getImage("images/mumlcomment.gif"));
    
    static ImageIcon AgentRequirementsQueryIcon=new ImageIcon(ImageLoader.getImage("images/mrquery.gif"));
    
    static ImageIcon UMLSpecificationIcon=new ImageIcon(ImageLoader.getImage("images/mumlspec.gif"));
    
    static ImageIcon BelieveIcon=new ImageIcon(ImageLoader.getImage("images/mbel.gif"));
    
    static ImageIcon WorkflowBoxIcon=new ImageIcon(ImageLoader.getImage("images/mworkflow.gif"));
    
    static ImageIcon DeploymentUnitByTypeEnumInitMSIcon=new ImageIcon(ImageLoader.getImage("images/mimtypedepl.gif"));
    
    static ImageIcon GeneralEventIcon=new ImageIcon(ImageLoader.getImage("images/mevent.gif"));
    
    static ImageIcon CompromiseIcon=new ImageIcon(ImageLoader.getImage("images/mcomp.gif"));
    
    static ImageIcon RoleIcon=new ImageIcon(ImageLoader.getImage("images/mrole.png"));
    
    static ImageIcon EnvironmentApplicationIcon=new ImageIcon(ImageLoader.getImage("images/mappe.gif"));
    
    static ImageIcon ApplicationEventSlotsIcon=new ImageIcon(ImageLoader.getImage("images/meventas.gif"));
    
    static ImageIcon ProtocolIcon=new ImageIcon(ImageLoader.getImage("images/prot.png"));
    
    static ImageIcon MentalInstanceSpecificationIcon=new ImageIcon(ImageLoader.getImage("images/mmispec.gif"));
    
    static ImageIcon ActionUMLIcon=new ImageIcon(ImageLoader.getImage("images/miusecase.gif"));
    
    static ImageIcon InteractionUnitIcon=new ImageIcon(ImageLoader.getImage("images/miu.gif"));
    
    static ImageIcon GRASIASpecificationIcon=new ImageIcon(ImageLoader.getImage("images/mgspec.gif"));
    
    static ImageIcon MentalStateProcessorIcon=new ImageIcon(ImageLoader.getImage("images/mproc.gif"));
    
    static ImageIcon MergeNodeIcon=new ImageIcon(ImageLoader.getImage("images/mdecisionnode.png"));
    
    static ImageIcon EndNodeIcon=new ImageIcon(ImageLoader.getImage("images/mdpdfeNode.png"));
    
    static ImageIcon FrameFactIcon=new ImageIcon(ImageLoader.getImage("images/mffact.png"));
    
    static ImageIcon TestIcon=new ImageIcon(ImageLoader.getImage("images/mdepl.gif"));
    
    static ImageIcon LifelineIcon=new ImageIcon(ImageLoader.getImage("images/col.png"));
    
    static ImageIcon InteractionIcon=new ImageIcon(ImageLoader.getImage("images/minter.gif"));
    
    static ImageIcon AgentIcon=new ImageIcon(ImageLoader.getImage("images/magent.gif"));
    
    static ImageIcon MentalStateManagerIcon=new ImageIcon(ImageLoader.getImage("images/mman.gif"));
    
    static ImageIcon INGENIASCodeComponentIcon=new ImageIcon(ImageLoader.getImage("images/miccomponent.gif"));
    
    static ImageIcon CommunicationEventIcon=new ImageIcon(ImageLoader.getImage("images/meventa.gif"));
    
    static ImageIcon TaskWSIcon=new ImageIcon(ImageLoader.getImage("images/mtaskws.gif"));
    
    static ImageIcon GoalStateWSIcon=new ImageIcon(ImageLoader.getImage("images/mgoalstatews.png"));
    
    static ImageIcon StateGoalIcon=new ImageIcon(ImageLoader.getImage("images/msgoal.gif"));
    
    static ImageIcon ConversationIcon=new ImageIcon(ImageLoader.getImage("images/mconv.png"));
    
    static ImageIcon ApplicationEventIcon=new ImageIcon(ImageLoader.getImage("images/meventa.gif"));
    
    static ImageIcon TaskIcon=new ImageIcon(ImageLoader.getImage("images/mtask.gif"));
    
    static ImageIcon DeploymentUnitByTypeMSEntityIcon=new ImageIcon(ImageLoader.getImage("images/mimtypedepl.gif"));
    
    static ImageIcon RoleWSIcon=new ImageIcon(ImageLoader.getImage("images/mrolews.gif"));
    
    static ImageIcon AUMLAlternativeBoxIcon=new ImageIcon(ImageLoader.getImage("images/altb.png"));
    
    static ImageIcon WorkflowIcon=new ImageIcon(ImageLoader.getImage("images/mworkflow.gif"));
    
    static ImageIcon ConventionalFolderIcon=new ImageIcon(ImageLoader.getImage("images/folder.png"));
    
    static ImageIcon RootFolderIcon=new ImageIcon(ImageLoader.getImage("images/world.png"));
    
    
    public ProjectTreeRenderer() {
        
        super();
        
    }
    
    
    public Component getTreeCellRendererComponent(
                                                  JTree tree,
                                                  Object value,
                                                  boolean sel,
                                                  boolean expanded,
                                                  boolean leaf,
                                                  int row,
                                                  boolean hasFocus) {
        
        super.getTreeCellRendererComponent(
                                           tree, value, sel,
                                           expanded, leaf, row,
                                           hasFocus);
        ImageIcon img=this.selectIcon(value);
        if (row==0)
            img=RootFolderIcon;
        
        if (img!=null) {
            setIcon(img);
            return this;
        } else
            return super.getTreeCellRendererComponent(tree,value,sel,expanded,leaf,row,hasFocus);
    }
    
    
    
    public static ImageIcon selectIcon(Object value) {
        DefaultMutableTreeNode node =
        (DefaultMutableTreeNode)value;
        return selectIconByUserObject(node.getUserObject());
    }
    
    public static String getIconNameByUserObject(Object userObject) {
        if (userObject.getClass().equals(String.class))
            return "images/folder.png";
        
        
        
        if (userObject.getClass().equals(DecisionNode.class))
            return "images/mdecisionnode.png";
        
        if (userObject.getClass().equals(TestingPackage.class))
            return "images/mdepl.gif";
        
        if (userObject.getClass().equals(MentalState.class))
            return "images/mmstate.gif";
        
        if (userObject.getClass().equals(InternalApplication.class))
            return "images/mappi.gif";
        
        if (userObject.getClass().equals(Goal.class))
            return "images/mgoal.gif";
        
        if (userObject.getClass().equals(AgentWS.class))
            return "images/magentws.gif";
        
        if (userObject.getClass().equals(Fact.class))
            return "images/mfact.png";
        
        if (userObject.getClass().equals(ShareTouple.class))
            return "images/miu.gif";
        
        if (userObject.getClass().equals(DeploymentUnitByTypeWithInitMS.class))
            return "images/mimtypedepl.gif";
        
        if (userObject.getClass().equals(JoinNode.class))
            return "images/mhforknode.png";
        
        if (userObject.getClass().equals(RuntimeEvent.class))
            return "images/mffact.png";
        
        if (userObject.getClass().equals(InitialNode.class))
            return "images/mdpdfiNode.png";
        
        if (userObject.getClass().equals(TextUseCase.class))
            return "images/musecase.gif";
        
        if (userObject.getClass().equals(RemoteProcedureCall.class))
            return "images/miu.gif";
        
        if (userObject.getClass().equals(Resource.class))
            return "images/mresource.gif";
        
        if (userObject.getClass().equals(WorkProduct.class))
            return "images/mdpdfcompWP.png";
        
        if (userObject.getClass().equals(FreeWP.class))
            return "images/mdpdffreeWP.png";
        
        if (userObject.getClass().equals(BehaviourWP.class))
            return "images/mdpdfbehWP.png";
        
        if (userObject.getClass().equals(StructuredWP.class))
            return "images/mdpdfStredWP.png";
        
        if (userObject.getClass().equals(StructuralWP.class))
            return "images/mdpdfstructWP.png";
        
        if (userObject.getClass().equals(DPDFSMMat.class))
            return "images/mdpdfSMMat.png";
        
        if (userObject.getClass().equals(DPDFSMMel.class))
            return "images/mdpdfSMMel.png";
        
        if (userObject.getClass().equals(DPDFSMMop.class))
            return "images/mdpdfSMMop.png";
        
        if (userObject.getClass().equals(AgentModelBelieve.class))
            return "images/mabel.gif";
        
        if (userObject.getClass().equals(ActivityFinal.class))
            return "images/mfinalnode.gif";
        
        if (userObject.getClass().equals(INGENIASUseCase.class))
            return "images/miusecase.gif";
        
        if (userObject.getClass().equals(TextNote.class))
            return "images/mtext.gif";
        
        if (userObject.getClass().equals(RuntimeFact.class))
            return "images/mffact.png";
        
        if (userObject.getClass().equals(ForkNode.class))
            return "images/mforknode.png";
        
        if (userObject.getClass().equals(OrganizationNetwork.class))
            return "images/mnetwork.gif";
        
        if (userObject.getClass().equals(MessagePassing.class))
            return "images/miu.gif";
        
        if (userObject.getClass().equals(SubProtocol.class))
            return "images/prot.png";
        
        if (userObject.getClass().equals(RuntimeConversation.class))
            return "images/mconv.png";
        
        if (userObject.getClass().equals(AUMLComponent.class))
            return "images/magent.gif";
        
        if (userObject.getClass().equals(Organization.class))
            return "images/morg.gif";
        
        if (userObject.getClass().equals(ConditionalMentalState.class))
            return "images/mcmstate.gif";
        
        if (userObject.getClass().equals(ApplicationWS.class))
            return "images/mapp.gif";
        
        if (userObject.getClass().equals(AUMLSpecification.class))
            return "images/maumlspec.gif";
        
        if (userObject.getClass().equals(Application.class))
            return "images/mapp.gif";
        
        if (userObject.getClass().equals(DeploymentPackage.class))
            return "images/mdepl.gif";
        
        if (userObject.getClass().equals(Plan.class))
            return "images/mplan.gif";
        
        if (userObject.getClass().equals(AUMLPort.class))
            return "images/magent.gif";
        
        if (userObject.getClass().equals(INGENIASComponent.class))
            return "images/micomponent.gif";
        
        if (userObject.getClass().equals(OrganizationGroup.class))
            return "images/mgroup.gif";
        
        if (userObject.getClass().equals(IUConcurrence.class))
            return "images/mconc.gif";
        
        if (userObject.getClass().equals(DeploymentUnitByType.class))
            return "images/mtypedepl.gif";
        
        if (userObject.getClass().equals(IUIterate.class))
            return "images/mit.gif";
        
        if (userObject.getClass().equals(AUMLAlternativeRow.class))
            return "images/altr.png";
        
        if (userObject.getClass().equals(Column.class))
            return "images/col.png";
        
        if (userObject.getClass().equals(AutonomousEntityQuery.class))
            return "images/mquery.gif";
        
        if (userObject.getClass().equals(AUMLContainer.class))
            return "images/magent.gif";
        
        if (userObject.getClass().equals(ConcreteAgent.class))
            return "images/mcaquery.gif";
        
        if (userObject.getClass().equals(UMLComment.class))
            return "images/mumlcomment.gif";
        
        if (userObject.getClass().equals(AgentRequirementsQuery.class))
            return "images/mrquery.gif";
        
        if (userObject.getClass().equals(UMLSpecification.class))
            return "images/mumlspec.gif";
        
        if (userObject.getClass().equals(Believe.class))
            return "images/mbel.gif";
        
        if (userObject.getClass().equals(WorkflowBox.class))
            return "images/mworkflow.gif";
        
        if (userObject.getClass().equals(DeploymentUnitByTypeEnumInitMS.class))
            return "images/mimtypedepl.gif";
        
        if (userObject.getClass().equals(GeneralEvent.class))
            return "images/mevent.gif";
        
        if (userObject.getClass().equals(Compromise.class))
            return "images/mcomp.gif";
        
        if (userObject.getClass().equals(Role.class))
            return "images/mrole.png";
        
        if (userObject.getClass().equals(EnvironmentApplication.class))
            return "images/mappe.gif";
        
        if (userObject.getClass().equals(ApplicationEventSlots.class))
            return "images/meventas.gif";
        
        if (userObject.getClass().equals(Protocol.class))
            return "images/prot.png";
        
        if (userObject.getClass().equals(MentalInstanceSpecification.class))
            return "images/mmispec.gif";
        
        if (userObject.getClass().equals(ActionUML.class))
            return "images/miusecase.gif";
        
        if (userObject.getClass().equals(InteractionUnit.class))
            return "images/miu.gif";
        
        if (userObject.getClass().equals(GRASIASpecification.class))
            return "images/mgspec.gif";
        
        if (userObject.getClass().equals(MentalStateProcessor.class))
            return "images/mproc.gif";
        
        if (userObject.getClass().equals(MergeNode.class))
            return "images/mdecisionnode.png";
        
        if (userObject.getClass().equals(EndNode.class))
            return "images/mdpdfeNode.png";
        
        if (userObject.getClass().equals(FrameFact.class))
            return "images/mffact.png";
        
        if (userObject.getClass().equals(Test.class))
            return "images/mdepl.gif";
        
        if (userObject.getClass().equals(Lifeline.class))
            return "images/col.png";
        
        if (userObject.getClass().equals(Interaction.class))
            return "images/minter.gif";
        
        if (userObject.getClass().equals(Agent.class))
            return "images/magent.gif";
        
        if (userObject.getClass().equals(MentalStateManager.class))
            return "images/mman.gif";
        
        if (userObject.getClass().equals(INGENIASCodeComponent.class))
            return "images/miccomponent.gif";
        
        if (userObject.getClass().equals(CommunicationEvent.class))
            return "images/meventa.gif";
        
        if (userObject.getClass().equals(TaskWS.class))
            return "images/mtaskws.gif";
        
        if (userObject.getClass().equals(GoalStateWS.class))
            return "images/mgoalstatews.png";
        
        if (userObject.getClass().equals(StateGoal.class))
            return "images/msgoal.gif";
        
        if (userObject.getClass().equals(Conversation.class))
            return "images/mconv.png";
        
        if (userObject.getClass().equals(ApplicationEvent.class))
            return "images/meventa.gif";
        
        if (userObject.getClass().equals(Task.class))
            return "images/mtask.gif";
        
        if (userObject.getClass().equals(DeploymentUnitByTypeMSEntity.class))
            return "images/mimtypedepl.gif";
        
        if (userObject.getClass().equals(RoleWS.class))
            return "images/mrolews.gif";
        
        if (userObject.getClass().equals(AUMLAlternativeBox.class))
            return "images/altb.png";
        
        if (userObject.getClass().equals(Workflow.class))
            return "images/mworkflow.gif";
        
        
        
        if (userObject.getClass().equals(ingenias.editor.models.WorkProductDiagramModelJGraph.class))
            return "";
        if (userObject.getClass().equals(ingenias.editor.models.PhaseDiagramModelJGraph.class))
            return "";
        if (userObject.getClass().equals(ingenias.editor.models.ActivityWPDiagramModelJGraph.class))
            return "";

        
        return null;
    }
    
    public static ImageIcon selectIconByUserObject(Object userObject) {
        
        if (userObject.getClass().equals(String.class))
            return ConventionalFolderIcon;
        
        
        
        if (userObject.getClass().equals(DecisionNode.class))
            return DecisionNodeIcon;
        
        if (userObject.getClass().equals(TestingPackage.class))
            return TestingPackageIcon;
        
        if (userObject.getClass().equals(MentalState.class))
            return MentalStateIcon;
        
        if (userObject.getClass().equals(InternalApplication.class))
            return InternalApplicationIcon;
        
        if (userObject.getClass().equals(Goal.class))
            return GoalIcon;
        
        if (userObject.getClass().equals(AgentWS.class))
            return AgentWSIcon;
        
        if (userObject.getClass().equals(Fact.class))
            return FactIcon;
        
        if (userObject.getClass().equals(ShareTouple.class))
            return ShareToupleIcon;
        
        if (userObject.getClass().equals(DeploymentUnitByTypeWithInitMS.class))
            return DeploymentUnitByTypeWithInitMSIcon;
        
        if (userObject.getClass().equals(JoinNode.class))
            return JoinNodeIcon;
        
        if (userObject.getClass().equals(RuntimeEvent.class))
            return RuntimeEventIcon;
        
        if (userObject.getClass().equals(InitialNode.class))
            return InitialNodeIcon;
        
        if (userObject.getClass().equals(TextUseCase.class))
            return TextUseCaseIcon;
        
        if (userObject.getClass().equals(RemoteProcedureCall.class))
            return RemoteProcedureCallIcon;
        
        if (userObject.getClass().equals(Resource.class))
            return ResourceIcon;
        
        if (userObject.getClass().equals(WorkProduct.class))
            return WorkProductIcon;
        
        if (userObject.getClass().equals(FreeWP.class))
            return FreeWPIcon;
        
        if (userObject.getClass().equals(BehaviourWP.class))
            return BehaviourWPIcon;
        
        if (userObject.getClass().equals(StructuralWP.class))
            return StructuralWPIcon;
        
        if (userObject.getClass().equals(StructuredWP.class))
            return StructuredWPIcon;
        
        if (userObject.getClass().equals(DPDFSMMat.class))
            return DPDFSMMatIcon;
        
        if (userObject.getClass().equals(DPDFSMMel.class))
            return DPDFSMMelIcon;
        
        if (userObject.getClass().equals(DPDFSMMop.class))
            return DPDFSMMopIcon;
        
        if (userObject.getClass().equals(AgentModelBelieve.class))
            return AgentModelBelieveIcon;
        
        if (userObject.getClass().equals(ActivityFinal.class))
            return ActivityFinalIcon;
        
        if (userObject.getClass().equals(INGENIASUseCase.class))
            return INGENIASUseCaseIcon;
        
        if (userObject.getClass().equals(TextNote.class))
            return TextNoteIcon;
        
        if (userObject.getClass().equals(RuntimeFact.class))
            return RuntimeFactIcon;
        
        if (userObject.getClass().equals(ForkNode.class))
            return ForkNodeIcon;
        
        if (userObject.getClass().equals(OrganizationNetwork.class))
            return OrganizationNetworkIcon;
        
        if (userObject.getClass().equals(MessagePassing.class))
            return MessagePassingIcon;
        
        if (userObject.getClass().equals(SubProtocol.class))
            return SubProtocolIcon;
        
        if (userObject.getClass().equals(RuntimeConversation.class))
            return RuntimeConversationIcon;
        
        if (userObject.getClass().equals(AUMLComponent.class))
            return AUMLComponentIcon;
        
        if (userObject.getClass().equals(Organization.class))
            return OrganizationIcon;
        
        if (userObject.getClass().equals(ConditionalMentalState.class))
            return ConditionalMentalStateIcon;
        
        if (userObject.getClass().equals(ApplicationWS.class))
            return ApplicationWSIcon;
        
        if (userObject.getClass().equals(AUMLSpecification.class))
            return AUMLSpecificationIcon;
        
        if (userObject.getClass().equals(Application.class))
            return ApplicationIcon;
        
        if (userObject.getClass().equals(DeploymentPackage.class))
            return DeploymentPackageIcon;
        
        if (userObject.getClass().equals(Plan.class))
            return PlanIcon;
        
        if (userObject.getClass().equals(AUMLPort.class))
            return AUMLPortIcon;
        
        if (userObject.getClass().equals(INGENIASComponent.class))
            return INGENIASComponentIcon;
        
        if (userObject.getClass().equals(OrganizationGroup.class))
            return OrganizationGroupIcon;
        
        if (userObject.getClass().equals(IUConcurrence.class))
            return IUConcurrenceIcon;
        
        if (userObject.getClass().equals(DeploymentUnitByType.class))
            return DeploymentUnitByTypeIcon;
        
        if (userObject.getClass().equals(IUIterate.class))
            return IUIterateIcon;
        
        if (userObject.getClass().equals(AUMLAlternativeRow.class))
            return AUMLAlternativeRowIcon;
        
        if (userObject.getClass().equals(Column.class))
            return ColumnIcon;
        
        if (userObject.getClass().equals(AutonomousEntityQuery.class))
            return AutonomousEntityQueryIcon;
        
        if (userObject.getClass().equals(AUMLContainer.class))
            return AUMLContainerIcon;
        
        if (userObject.getClass().equals(ConcreteAgent.class))
            return ConcreteAgentIcon;
        
        if (userObject.getClass().equals(UMLComment.class))
            return UMLCommentIcon;
        
        if (userObject.getClass().equals(AgentRequirementsQuery.class))
            return AgentRequirementsQueryIcon;
        
        if (userObject.getClass().equals(UMLSpecification.class))
            return UMLSpecificationIcon;
        
        if (userObject.getClass().equals(Believe.class))
            return BelieveIcon;
        
        if (userObject.getClass().equals(WorkflowBox.class))
            return WorkflowBoxIcon;
        
        if (userObject.getClass().equals(DeploymentUnitByTypeEnumInitMS.class))
            return DeploymentUnitByTypeEnumInitMSIcon;
        
        if (userObject.getClass().equals(GeneralEvent.class))
            return GeneralEventIcon;
        
        if (userObject.getClass().equals(Compromise.class))
            return CompromiseIcon;
        
        if (userObject.getClass().equals(Role.class))
            return RoleIcon;
        
        if (userObject.getClass().equals(EnvironmentApplication.class))
            return EnvironmentApplicationIcon;
        
        if (userObject.getClass().equals(ApplicationEventSlots.class))
            return ApplicationEventSlotsIcon;
        
        if (userObject.getClass().equals(Protocol.class))
            return ProtocolIcon;
        
        if (userObject.getClass().equals(MentalInstanceSpecification.class))
            return MentalInstanceSpecificationIcon;
        
        if (userObject.getClass().equals(ActionUML.class))
            return ActionUMLIcon;
        
        if (userObject.getClass().equals(InteractionUnit.class))
            return InteractionUnitIcon;
        
        if (userObject.getClass().equals(GRASIASpecification.class))
            return GRASIASpecificationIcon;
        
        if (userObject.getClass().equals(MentalStateProcessor.class))
            return MentalStateProcessorIcon;
        
        if (userObject.getClass().equals(MergeNode.class))
            return MergeNodeIcon;
        
        if (userObject.getClass().equals(EndNode.class))
            return EndNodeIcon;
        
        if (userObject.getClass().equals(FrameFact.class))
            return FrameFactIcon;
        
        if (userObject.getClass().equals(Test.class))
            return TestIcon;
        
        if (userObject.getClass().equals(Lifeline.class))
            return LifelineIcon;
        
        if (userObject.getClass().equals(Interaction.class))
            return InteractionIcon;
        
        if (userObject.getClass().equals(Agent.class))
            return AgentIcon;
        
        if (userObject.getClass().equals(MentalStateManager.class))
            return MentalStateManagerIcon;
        
        if (userObject.getClass().equals(INGENIASCodeComponent.class))
            return INGENIASCodeComponentIcon;
        
        if (userObject.getClass().equals(CommunicationEvent.class))
            return CommunicationEventIcon;
        
        if (userObject.getClass().equals(TaskWS.class))
            return TaskWSIcon;
        
        if (userObject.getClass().equals(GoalStateWS.class))
            return GoalStateWSIcon;
        
        if (userObject.getClass().equals(StateGoal.class))
            return StateGoalIcon;
        
        if (userObject.getClass().equals(Conversation.class))
            return ConversationIcon;
        
        if (userObject.getClass().equals(ApplicationEvent.class))
            return ApplicationEventIcon;
        
        if (userObject.getClass().equals(Task.class))
            return TaskIcon;
        
        if (userObject.getClass().equals(DeploymentUnitByTypeMSEntity.class))
            return DeploymentUnitByTypeMSEntityIcon;
        
        if (userObject.getClass().equals(RoleWS.class))
            return RoleWSIcon;
        
        if (userObject.getClass().equals(AUMLAlternativeBox.class))
            return AUMLAlternativeBoxIcon;
        
        if (userObject.getClass().equals(Workflow.class))
            return WorkflowIcon;
        
        
        
        if (userObject.getClass().equals(ingenias.editor.models.WorkProductDiagramModelJGraph.class))
            return modeloWorkProductDiagram;

        if (userObject.getClass().equals(ingenias.editor.models.PhaseDiagramModelJGraph.class))
            return modeloPhaseDiagram;

        if (userObject.getClass().equals(ingenias.editor.models.ActivityWPDiagramModelJGraph.class))
            return modeloActivityWPDiagram;


        
        return null;
    }
    
}


