

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


public class GraphLoadImp1
implements GraphLoad {
	
	/**
	 *  Constructor for the GraphLoad object
	 */
	public GraphLoadImp1() {}
	
	
	private ModelJGraph fromGXL(ObjectManager om, RelationshipManager rm, ModelJGraph graph, Node node, Node nodeView) {
		try {
			
			// Get Graph's Child Nodes (the cells)
			NodeList list = node.getChildNodes();
			// Get Graph's Child Nodes (the views)
			NodeList listView = nodeView.getChildNodes();
			// ConnectionSet for the Insert method
			ConnectionSet cs = new ConnectionSet();
			// Hashtable for the ID lookup (ID to Vertex)
			Hashtable ids = new Hashtable();
			// Hashtable for Attributes (Vertex to Map)
			Hashtable attributes = new Hashtable();
			Vector edges = new Vector();
			Vector edgesAttr = new Vector();
			// Loop Children
			for (int i = 0; i < list.getLength(); i++) {
				// The order is the same in both trees.
				node = list.item(i);
				nodeView = listView.item(i);
				// If Valid Node
				if (node.getAttributes() != null && node.getNodeName() != null) {
					// Fetch Supertype
					String supertype = (String) node.getNodeName();
					// Create Vertex
					if (supertype.equals("node")) {
						String id = node.getAttributes().getNamedItem("id").getNodeValue();
						String type = node.getAttributes().getNamedItem("type").
						getNodeValue();
						DefaultGraphCell vertex = GXLVertex(id, type, graph, om, rm);
						if ( (vertex != null) && ! (vertex instanceof NAryEdge)) {
							// Add ID, Vertex pair to Hashtable
							if (node.getAttributes().getNamedItem("nid") != null) {
								ids.put(node.getAttributes().getNamedItem("nid").getNodeValue(),
										vertex);
							}
							else {
								ids.put(node.getAttributes().getNamedItem("id").getNodeValue(),
										vertex);
								// Add Attributes
							}
							Map vertexAttr = GXLCellView(graph, vertex, ids, nodeView);
							attributes.put(vertex, vertexAttr);
							// Add Vertex to new Cells
							graph.getModel().insert(new Object[] {vertex},attributes,
													cs, null, null);
							//              Log.getInstance().logSYS("loaded " + vertex.getUserObject());
						}
						else {
							if (vertex != null && (vertex instanceof NAryEdge)) {
								edges.add(vertex);
								Vector idscon = getConnectedEntities(node);
								Map vertexAttr = GXLCellView(graph, vertex, ids, nodeView);
								edgesAttr.add(vertexAttr);
								edgesAttr.add(idscon);
								
							}
						}
						// Create Edge
					}
				}
			}
			Enumeration enumeration = edges.elements();
			Enumeration enumeration1 = edgesAttr.elements();
			while (enumeration.hasMoreElements()) {
				NAryEdge ne = (NAryEdge) enumeration.nextElement();
				NAryEdgeEntity ent = (NAryEdgeEntity) ne.getUserObject();
				Map eas = (Map) enumeration1.nextElement();
				Vector idscon = ( (Vector) enumeration1.nextElement());
				DefaultGraphCell gcs[] = null;
				if (idscon.size() > 0) {
					String[] idEnts = ent.getIds();
					gcs = new DefaultGraphCell[idscon.size()];
					
					for (int k = 0; k < idscon.size(); k++) {
						String id = idscon.elementAt(k).toString();
						gcs[k] = (DefaultGraphCell) ids.get(id);
						//this.getGraphCell(graph,id);
						
					}
				}
				else {
					String[] idEnts = ent.getIds();
					gcs = new DefaultGraphCell[idEnts.length];
					
					for (int k = 0; k < idEnts.length; k++) {
						String id = idEnts[k];
						gcs[k] = this.getGraphCell(graph, id);
						
					}
				}
				
				this.connect(graph, gcs, ne, eas);
			}
			return graph;
		}
		catch (Exception e) {
			// Display error message on stderr
			e.printStackTrace();
			return null;
		}
	}
	
	// Convert an CellView represented by a GXL DOM node in a Map.
	// cell is the GraphCell represented by the returned CellView.
	// ids has a mapping from id to vertex.
	
	private Map GXLCellView(JGraph graph, GraphCell cell, Map ids, Node node) {
		
		// Fetch Map attributes.
		Hashtable attrMap = getMap(node);
		// The id attribute is not appliable.
		attrMap.remove("id");
		
		attrMap.remove("icon");
		
		if (attrMap.containsKey("points")) {
			List points = GraphConstants.getPoints(attrMap);
			ArrayList result = new ArrayList();
			// The ports are removed. They are converted to String's.
			// Ports are added employing cell.
			PortView sourceView = (PortView) graph.getGraphLayoutCache().getMapping( (GraphCell) ( (
																									Port) ( (DefaultEdge) cell).getSource()), false);
			PortView targetView = (PortView) graph.getGraphLayoutCache().getMapping( (GraphCell) ( (
																									Port) ( (DefaultEdge) cell).getTarget()), false);
			// Add source.
			result.add(sourceView);
			// Other points are represented as Point's.
			Iterator it = points.iterator();
			while (it.hasNext()) {
				Object point = it.next();
				if (point instanceof Point) {
					result.add(point);
				}
			}
			// Add target.
			result.add(targetView);
			GraphConstants.setPoints(attrMap, result);
		}
		
		if (attrMap.containsKey("lineBegin")) {
			// int values are saved as Strings.
			String lineBegin = (String) attrMap.get("lineBegin");
			GraphConstants.setLineBegin(attrMap, Integer.parseInt(lineBegin));
		}
		
		if (attrMap.containsKey("lineEnd")) {
			// int values are saved as Strings.
			String lineEnd = (String) attrMap.get("lineEnd");
			GraphConstants.setLineEnd(attrMap, Integer.parseInt(lineEnd));
		}
		
		return attrMap;
	}
	
	// Convert a vertex represented by a GXL DOM node in a DefaultGraphCell.
	// ids contains the already processed vertex ids.
	
	private DefaultGraphCell GXLVertex(String id, String type, ModelJGraph graph,
									   ObjectManager om, RelationshipManager rm) {
		
		DefaultGraphCell vertex = null;
		
		ingenias.editor.entities.Entity en = om.getEntity(id, type);
		// if it is registered in the OM, then it is a diagram object
		if (en != null) {
			
			
			
			if (en instanceof ingenias.editor.entities.DecisionNode)
				return  new ingenias.editor.cell.DecisionNodeCell((DecisionNode)en);
			
			if (en instanceof ingenias.editor.entities.TestingPackage)
				return  new ingenias.editor.cell.TestingPackageCell((TestingPackage)en);
			
			if (en instanceof ingenias.editor.entities.MentalState)
				return  new ingenias.editor.cell.MentalStateCell((MentalState)en);
			
			if (en instanceof ingenias.editor.entities.InternalApplication)
				return  new ingenias.editor.cell.InternalApplicationCell((InternalApplication)en);
			
			if (en instanceof ingenias.editor.entities.Goal)
				return  new ingenias.editor.cell.GoalCell((Goal)en);
			
			if (en instanceof ingenias.editor.entities.AgentWS)
				return  new ingenias.editor.cell.AgentWSCell((AgentWS)en);
			
			if (en instanceof ingenias.editor.entities.Fact)
				return  new ingenias.editor.cell.FactCell((Fact)en);
			
			if (en instanceof ingenias.editor.entities.ShareTouple)
				return  new ingenias.editor.cell.ShareToupleCell((ShareTouple)en);
			
			if (en instanceof ingenias.editor.entities.DeploymentUnitByTypeWithInitMS)
				return  new ingenias.editor.cell.DeploymentUnitByTypeWithInitMSCell((DeploymentUnitByTypeWithInitMS)en);
			
			if (en instanceof ingenias.editor.entities.JoinNode)
				return  new ingenias.editor.cell.JoinNodeCell((JoinNode)en);
			
			if (en instanceof ingenias.editor.entities.RuntimeEvent)
				return  new ingenias.editor.cell.RuntimeEventCell((RuntimeEvent)en);
			
			if (en instanceof ingenias.editor.entities.InitialNode)
				return  new ingenias.editor.cell.InitialNodeCell((InitialNode)en);
			
			if (en instanceof ingenias.editor.entities.TextUseCase)
				return  new ingenias.editor.cell.TextUseCaseCell((TextUseCase)en);
			
			if (en instanceof ingenias.editor.entities.RemoteProcedureCall)
				return  new ingenias.editor.cell.RemoteProcedureCallCell((RemoteProcedureCall)en);
			
			if (en instanceof ingenias.editor.entities.Resource)
				return  new ingenias.editor.cell.ResourceCell((Resource)en);
			
			if (en instanceof ingenias.editor.entities.WorkProduct) 
				return  new ingenias.editor.cell.WorkProductCell((WorkProduct)en);
			
			if (en instanceof ingenias.editor.entities.StructuralWP) 
				return  new ingenias.editor.cell.StructuralWPCell((StructuralWP)en);
			
			if (en instanceof ingenias.editor.entities.StructuredWP) 
				return  new ingenias.editor.cell.StructuredWPCell((StructuredWP)en);
			
			if (en instanceof ingenias.editor.entities.FreeWP) 
				return  new ingenias.editor.cell.FreeWPCell((FreeWP)en);
			
			if (en instanceof ingenias.editor.entities.BehaviourWP) 
				return  new ingenias.editor.cell.BehaviourWPCell((BehaviourWP)en);
			
			if (en instanceof ingenias.editor.entities.DPDFSMMat) 
				return  new ingenias.editor.cell.DPDFSMMatCell((DPDFSMMat)en);
			
			if (en instanceof ingenias.editor.entities.DPDFSMMel) 
				return  new ingenias.editor.cell.DPDFSMMelCell((DPDFSMMel)en);
			
			if (en instanceof ingenias.editor.entities.DPDFSMMop) 
				return  new ingenias.editor.cell.DPDFSMMopCell((DPDFSMMop)en);
			
			if (en instanceof ingenias.editor.entities.AgentModelBelieve)
				return  new ingenias.editor.cell.AgentModelBelieveCell((AgentModelBelieve)en);
			
			if (en instanceof ingenias.editor.entities.ActivityFinal)
				return  new ingenias.editor.cell.ActivityFinalCell((ActivityFinal)en);
			
			if (en instanceof ingenias.editor.entities.INGENIASUseCase)
				return  new ingenias.editor.cell.INGENIASUseCaseCell((INGENIASUseCase)en);
			
			if (en instanceof ingenias.editor.entities.TextNote)
				return  new ingenias.editor.cell.TextNoteCell((TextNote)en);
			
			if (en instanceof ingenias.editor.entities.RuntimeFact)
				return  new ingenias.editor.cell.RuntimeFactCell((RuntimeFact)en);
			
			if (en instanceof ingenias.editor.entities.ForkNode)
				return  new ingenias.editor.cell.ForkNodeCell((ForkNode)en);
			
			if (en instanceof ingenias.editor.entities.OrganizationNetwork)
				return  new ingenias.editor.cell.OrganizationNetworkCell((OrganizationNetwork)en);
			
			if (en instanceof ingenias.editor.entities.MessagePassing)
				return  new ingenias.editor.cell.MessagePassingCell((MessagePassing)en);
			
			if (en instanceof ingenias.editor.entities.SubProtocol)
				return  new ingenias.editor.cell.SubProtocolCell((SubProtocol)en);
			
			if (en instanceof ingenias.editor.entities.RuntimeConversation)
				return  new ingenias.editor.cell.RuntimeConversationCell((RuntimeConversation)en);
			
			if (en instanceof ingenias.editor.entities.AUMLComponent)
				return  new ingenias.editor.cell.AUMLComponentCell((AUMLComponent)en);
			
			if (en instanceof ingenias.editor.entities.Organization)
				return  new ingenias.editor.cell.OrganizationCell((Organization)en);
			
			if (en instanceof ingenias.editor.entities.ConditionalMentalState)
				return  new ingenias.editor.cell.ConditionalMentalStateCell((ConditionalMentalState)en);
			
			if (en instanceof ingenias.editor.entities.ApplicationWS)
				return  new ingenias.editor.cell.ApplicationWSCell((ApplicationWS)en);
			
			if (en instanceof ingenias.editor.entities.AUMLSpecification)
				return  new ingenias.editor.cell.AUMLSpecificationCell((AUMLSpecification)en);
			
			if (en instanceof ingenias.editor.entities.Application)
				return  new ingenias.editor.cell.ApplicationCell((Application)en);
			
			if (en instanceof ingenias.editor.entities.DeploymentPackage)
				return  new ingenias.editor.cell.DeploymentPackageCell((DeploymentPackage)en);
			
			if (en instanceof ingenias.editor.entities.Plan)
				return  new ingenias.editor.cell.PlanCell((Plan)en);
			
			if (en instanceof ingenias.editor.entities.AUMLPort)
				return  new ingenias.editor.cell.AUMLPortCell((AUMLPort)en);
			
			if (en instanceof ingenias.editor.entities.INGENIASComponent)
				return  new ingenias.editor.cell.INGENIASComponentCell((INGENIASComponent)en);
			
			if (en instanceof ingenias.editor.entities.OrganizationGroup)
				return  new ingenias.editor.cell.OrganizationGroupCell((OrganizationGroup)en);
			
			if (en instanceof ingenias.editor.entities.IUConcurrence)
				return  new ingenias.editor.cell.IUConcurrenceCell((IUConcurrence)en);
			
			if (en instanceof ingenias.editor.entities.DeploymentUnitByType)
				return  new ingenias.editor.cell.DeploymentUnitByTypeCell((DeploymentUnitByType)en);
			
			if (en instanceof ingenias.editor.entities.IUIterate)
				return  new ingenias.editor.cell.IUIterateCell((IUIterate)en);
			
			if (en instanceof ingenias.editor.entities.AUMLAlternativeRow)
				return  new ingenias.editor.cell.AUMLAlternativeRowCell((AUMLAlternativeRow)en);
			
			if (en instanceof ingenias.editor.entities.Column)
				return  new ingenias.editor.cell.ColumnCell((Column)en);
			
			if (en instanceof ingenias.editor.entities.AutonomousEntityQuery)
				return  new ingenias.editor.cell.AutonomousEntityQueryCell((AutonomousEntityQuery)en);
			
			if (en instanceof ingenias.editor.entities.AUMLContainer)
				return  new ingenias.editor.cell.AUMLContainerCell((AUMLContainer)en);
			
			if (en instanceof ingenias.editor.entities.ConcreteAgent)
				return  new ingenias.editor.cell.ConcreteAgentCell((ConcreteAgent)en);
			
			if (en instanceof ingenias.editor.entities.UMLComment)
				return  new ingenias.editor.cell.UMLCommentCell((UMLComment)en);
			
			if (en instanceof ingenias.editor.entities.AgentRequirementsQuery)
				return  new ingenias.editor.cell.AgentRequirementsQueryCell((AgentRequirementsQuery)en);
			
			if (en instanceof ingenias.editor.entities.UMLSpecification)
				return  new ingenias.editor.cell.UMLSpecificationCell((UMLSpecification)en);
			
			if (en instanceof ingenias.editor.entities.Believe)
				return  new ingenias.editor.cell.BelieveCell((Believe)en);
			
			if (en instanceof ingenias.editor.entities.WorkflowBox)
				return  new ingenias.editor.cell.WorkflowBoxCell((WorkflowBox)en);
			
			if (en instanceof ingenias.editor.entities.DeploymentUnitByTypeEnumInitMS)
				return  new ingenias.editor.cell.DeploymentUnitByTypeEnumInitMSCell((DeploymentUnitByTypeEnumInitMS)en);
			
			if (en instanceof ingenias.editor.entities.GeneralEvent)
				return  new ingenias.editor.cell.GeneralEventCell((GeneralEvent)en);
			
			if (en instanceof ingenias.editor.entities.Compromise)
				return  new ingenias.editor.cell.CompromiseCell((Compromise)en);
			
			if (en instanceof ingenias.editor.entities.Role)
				return  new ingenias.editor.cell.RoleCell((Role)en);
			
			if (en instanceof ingenias.editor.entities.EnvironmentApplication)
				return  new ingenias.editor.cell.EnvironmentApplicationCell((EnvironmentApplication)en);
			
			if (en instanceof ingenias.editor.entities.ApplicationEventSlots)
				return  new ingenias.editor.cell.ApplicationEventSlotsCell((ApplicationEventSlots)en);
			
			if (en instanceof ingenias.editor.entities.Protocol)
				return  new ingenias.editor.cell.ProtocolCell((Protocol)en);
			
			if (en instanceof ingenias.editor.entities.MentalInstanceSpecification)
				return  new ingenias.editor.cell.MentalInstanceSpecificationCell((MentalInstanceSpecification)en);
			
			if (en instanceof ingenias.editor.entities.ActionUML)
				return  new ingenias.editor.cell.ActionUMLCell((ActionUML)en);
			
			if (en instanceof ingenias.editor.entities.InteractionUnit)
				return  new ingenias.editor.cell.InteractionUnitCell((InteractionUnit)en);
			
			if (en instanceof ingenias.editor.entities.GRASIASpecification)
				return  new ingenias.editor.cell.GRASIASpecificationCell((GRASIASpecification)en);
			
			if (en instanceof ingenias.editor.entities.MentalStateProcessor)
				return  new ingenias.editor.cell.MentalStateProcessorCell((MentalStateProcessor)en);
			
			if (en instanceof ingenias.editor.entities.MergeNode)
				return  new ingenias.editor.cell.MergeNodeCell((MergeNode)en);
			
			if (en instanceof ingenias.editor.entities.EndNode)
				return  new ingenias.editor.cell.EndNodeCell((EndNode)en);
			
			if (en instanceof ingenias.editor.entities.FrameFact)
				return  new ingenias.editor.cell.FrameFactCell((FrameFact)en);
			
			if (en instanceof ingenias.editor.entities.Test)
				return  new ingenias.editor.cell.TestCell((Test)en);
			
			if (en instanceof ingenias.editor.entities.Lifeline)
				return  new ingenias.editor.cell.LifelineCell((Lifeline)en);
			
			if (en instanceof ingenias.editor.entities.Interaction)
				return  new ingenias.editor.cell.InteractionCell((Interaction)en);
			
			if (en instanceof ingenias.editor.entities.Agent)
				return  new ingenias.editor.cell.AgentCell((Agent)en);
			
			if (en instanceof ingenias.editor.entities.MentalStateManager)
				return  new ingenias.editor.cell.MentalStateManagerCell((MentalStateManager)en);
			
			if (en instanceof ingenias.editor.entities.INGENIASCodeComponent)
				return  new ingenias.editor.cell.INGENIASCodeComponentCell((INGENIASCodeComponent)en);
			
			if (en instanceof ingenias.editor.entities.CommunicationEvent)
				return  new ingenias.editor.cell.CommunicationEventCell((CommunicationEvent)en);
			
			if (en instanceof ingenias.editor.entities.TaskWS)
				return  new ingenias.editor.cell.TaskWSCell((TaskWS)en);
			
			if (en instanceof ingenias.editor.entities.GoalStateWS)
				return  new ingenias.editor.cell.GoalStateWSCell((GoalStateWS)en);
			
			if (en instanceof ingenias.editor.entities.StateGoal)
				return  new ingenias.editor.cell.StateGoalCell((StateGoal)en);
			
			if (en instanceof ingenias.editor.entities.Conversation)
				return  new ingenias.editor.cell.ConversationCell((Conversation)en);
			
			if (en instanceof ingenias.editor.entities.ApplicationEvent)
				return  new ingenias.editor.cell.ApplicationEventCell((ApplicationEvent)en);
			
			if (en instanceof ingenias.editor.entities.Task)
				return  new ingenias.editor.cell.TaskCell((Task)en);
			
			if (en instanceof ingenias.editor.entities.DeploymentUnitByTypeMSEntity)
				return  new ingenias.editor.cell.DeploymentUnitByTypeMSEntityCell((DeploymentUnitByTypeMSEntity)en);
			
			if (en instanceof ingenias.editor.entities.RoleWS)
				return  new ingenias.editor.cell.RoleWSCell((RoleWS)en);
			
			if (en instanceof ingenias.editor.entities.AUMLAlternativeBox)
				return  new ingenias.editor.cell.AUMLAlternativeBoxCell((AUMLAlternativeBox)en);
			
			if (en instanceof ingenias.editor.entities.Workflow)
				return  new ingenias.editor.cell.WorkflowCell((Workflow)en);
			
			if (en instanceof ingenias.editor.entities.Phase)
				return  new ingenias.editor.cell.PhaseCell((Phase)en);
			
			if (en instanceof ingenias.editor.entities.iPhase)
				return  new ingenias.editor.cell.iPhaseCell((iPhase)en);
			
			if (en instanceof ingenias.editor.entities.Activity)
				return  new ingenias.editor.cell.ActivityCell((Activity)en);
			
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
			
			if (en instanceof DPDFPrecedes)
				return  new DPDFPrecedesEdge((DPDFPrecedes)en);
			
			if (en instanceof ActivityPrecedes)
				return  new ActivityPrecedesEdge((ActivityPrecedes)en);
			
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
			
			if (en instanceof WFContains)
				return  new WFContainsEdge((WFContains)en);
			
			if (en instanceof WPContains)
				return  new WPContainsEdge((WPContains)en);
			
			if (en instanceof WPDepends)
				return  new WPDependsEdge((WPDepends)en);
			
			if (en instanceof UMLRealizes)
				return  new UMLRealizesEdge((UMLRealizes)en);
			
			if (en instanceof WFConnects)
				return  new WFConnectsEdge((WFConnects)en);
			
			if (en instanceof Extends)
				return  new ExtendsEdge((Extends)en);
			
			if (en instanceof Refines)
				return  new RefinesEdge((Refines)en);
			
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
	
	// Convert an edge represented by a GXL DOM node in a DefaultEdge.
	// ids has a mapping from id to vertex.
	
	private DefaultEdge GXLEdge(Map ids, Node node) {
		
		DefaultEdge edge = new DefaultEdge();
		
		// Fetch Map attributes.
		Map attrMap = getMap(node);
		
		// Create Edge with label
		String label = (String) attrMap.get("id");
		// Fetch type
		String type = (String) attrMap.get("type");
		// id and type are not valid JGraph attributes.
		attrMap.remove("id");
		attrMap.remove("type");
		return edge;
	}
	
	private DefaultGraphCell[]
	getEntitiesAlreadyInsertedInRelationshipAndUpdateDGCIds(Object[] selected,
															ingenias.editor.entities.NAryEdgeEntity nEdgeObject) {
		String[] ids = nEdgeObject.getIds();
		Vector newselectedv=new Vector();
		
		
		int i = 0;
		//      for (int i = 0; i < ids.length; i++) {
		for (int j = 0; j < selected.length; j++) {
			Object userObject = ( (DefaultGraphCell) selected[j]).getUserObject();
			/*      Log.getInstance().logSYS("Processing Relationship" +
			 nEdgeObject.getId() + " of type " +
			 nEdgeObject.getType() +
			 " considering " + userObject);*/
			
			try {
				if (userObject != null &&
					userObject instanceof ingenias.editor.entities.Entity) {
					nEdgeObject.searchEntityID( ( (ingenias.editor.entities.Entity)
												 userObject).getId());
					nEdgeObject.updateCell( (DefaultGraphCell) selected[j]);
					newselectedv.add(selected[j]);
					i++;
				}
			}
			catch (NotFound nf) {
				/*        Log.getInstance().logSYS("Processing Relationship" +
				 nEdgeObject.getId() + " of type " +
				 nEdgeObject.getType() +
				 " not found " + userObject);*/
			}
		}
		ids = nEdgeObject.getIds();
		
		// Number of ids in the relationship can be less than initial number
		if (ids.length != i) {
			throw new RuntimeException(
									   "INTERNAL ERROR!!! Length of ids connected in " +
									   nEdgeObject.getId() + " of type " + nEdgeObject.getType() +
									   " a relationship does not match selected default graph cell number. I had " +
									   ids.length + " elements to find and I found " + i);
		}
		DefaultGraphCell[] newSelected = new DefaultGraphCell[ids.length];
		for (int k=0;k<newSelected.length;k++){
			newSelected[k]=(DefaultGraphCell)newselectedv.elementAt(k);
		}
		
		return newSelected;
		
	}
	
	private void connect(ModelJGraph graph, DefaultGraphCell[] selected,
						 NAryEdge nEdge,
						 Map eas) throws NotFound {
		ingenias.editor.entities.NAryEdgeEntity ne = (NAryEdgeEntity)
        nEdge.getUserObject();
		
		DefaultGraphCell[] newSelected = null;
		// N-ary relationship.
		if (nEdge != null) {
			// Role assignations to classes are obtained from NAryEdgeEntity in NAryEdge.
			// NAryEdgeEntity has a list of object ids that have to be in selected.
			// assignations is a Vector of Vectors of Strings where Strings represents roles.
			NAryEdgeEntity nEdgeObject = (NAryEdgeEntity) nEdge.getUserObject();
			// ids of objects connected with nEdge.
			//      String[] ids = nEdgeObject.getIds(); // Not valid yet
			/*    {
			 String idsres = "";
			 for (int k = 0; k < ids.length; k++) {
			 idsres = idsres + ids[k] + ",";
			 }
			 Log.getInstance().logSYS("Processing Relationship" +
			 ne.getId() + " of type " + ne.getType() +
			 " with elems " +
			 idsres +
			 " in graph " + graph.getID());
			 }*/
			
			// Selected objects are reduced to those connected with nEdge
			newSelected = this.
			getEntitiesAlreadyInsertedInRelationshipAndUpdateDGCIds(selected,
																	nEdgeObject);
			
			/*      ids = nEdgeObject.getIds(); // Now valid ones, after the update
			 {
			 String idsres = "";
			 for (int k = 0; k < ids.length; k++) {
			 idsres = idsres + ids[k] + ",";
			 }
			 Log.getInstance().logSYS("Processing Relationship" +
			 ne.getId() + " of type " + ne.getType() +
			 " new ids " +
			 idsres +
			 " in graph " + graph.getID());
			 }*/
			
			// Role assignation to objects is obtained.
			String[] selectedAssignation = new String[newSelected.length];
			for (int i = 0; i < newSelected.length; i++) {
				selectedAssignation[i] = nEdgeObject.getRole(""+newSelected[i].hashCode());
				// Auxiliary edges that will be inserted in the Model.
			}
			try {
				DefaultEdge[] auxiliaryEdges = nEdge.connectionsEdges(newSelected,
																	  selectedAssignation);
				for (int i = 0; i < newSelected.length; i++) {
					RoleEntity re = nEdgeObject.getRoleEntity(""+newSelected[i].hashCode());
					auxiliaryEdges[i].setUserObject(re);
				}
				
				// Connections that will be inserted into the Model.
				ConnectionSet cs = nEdge.connections(selectedAssignation,
													 auxiliaryEdges,
													 getPorts(graph, newSelected));
				// Construct a Map from cells to Maps (for insert).
				Hashtable attributes = new Hashtable();
				// Associate the NAryEdge Vertex with its Attributes.
				attributes.put(nEdge, eas);
				//////////-----------------------------------//////////
				Hashtable edgesAttributes = new Hashtable();
				for (int i = 0; i < selectedAssignation.length; i++) {
					// Create a Map that holds the attributes for the edge
					Map attr = ( (RoleEntity) auxiliaryEdges[i].getUserObject()). getAttributes();
                    
                    // General
                    
					GraphConstants.setLineWidth(attr, 2);
                    
                    /*
                     
                     // Dashed
                     GraphConstants.setDashPattern(attr, new float[] { 6, 6 }); // general
                     
                     // None
                     GraphConstants.setLineBegin(attr, GraphConstants.ARROW_NONE); // source
                     GraphConstants.setLineEnd(attr, GraphConstants.ARROW_NONE); // target
                     
                     // Simple
                     GraphConstants.setLineBegin(attr, GraphConstants.ARROW_NONE); // source
                     GraphConstants.setLineEnd(attr, GraphConstants.ARROW_SIMPLE); // target
                     
                     // Solid
                     GraphConstants.setLineBegin(attr, GraphConstants.ARROW_NONE); // source
                     GraphConstants.setLineEnd(attr, GraphConstants.ARROW_TECHNICAL);
                     GraphConstants.setEndFill(attr, true); // target
                     
                     // Aggregation
                     GraphConstants.setLineBegin(attr, GraphConstants.ARROW_DIAMOND); // source
                     GraphConstants.setBeginFill(attr, true);
                     GraphConstants.setLineEnd(attr, GraphConstants.ARROW_NONE); // target
                     
                     // Composite
                     GraphConstants.setLineBegin(attr, GraphConstants.ARROW_DIAMOND); // source
                     GraphConstants.setBeginFill(attr, false);
                     GraphConstants.setLineEnd(attr, GraphConstants.ARROW_NONE); // target
                     
                     
                    */
                    
					// Particular Relationship Style
					if (selectedAssignation[i].startsWith("ActivityPrecedes")){
						GraphConstants.setDashPattern(attr, new float[] { 6, 6 });
					}
					
					// Source
					if (selectedAssignation[i].indexOf("source") >= 0){
						if (selectedAssignation[i].startsWith("WFContains") ||
							selectedAssignation[i].startsWith("WPContains")){
							GraphConstants.setLineEnd(attr, GraphConstants.ARROW_DIAMOND);				
							GraphConstants.setEndSize(attr, 16);
							GraphConstants.setEndFill(attr, true);
						}
					}
					
					// Target
					if (selectedAssignation[i].indexOf("target") >= 0 ||
						selectedAssignation[i].endsWith("T")) {
						
						GraphConstants.setLineEnd(attr, GraphConstants.ARROW_SIMPLE);
						GraphConstants.setEndSize(attr, 16);
						
						if (selectedAssignation[i].startsWith("DPDFPrecedes")){
							GraphConstants.setLineEnd(attr, GraphConstants.ARROW_TECHNICAL);				
							GraphConstants.setEndFill(attr, true);
						}
						
						if (selectedAssignation[i].startsWith("WFContains") ||
							selectedAssignation[i].startsWith("WPContains")){
							GraphConstants.setLineEnd(attr, GraphConstants.ARROW_NONE);				
						}
						
						if (selectedAssignation[i].startsWith("Extends")){
							GraphConstants.setLineEnd(attr, GraphConstants.ARROW_TECHNICAL);
							GraphConstants.setEndFill(attr, false);
						}
						
						if (selectedAssignation[i].startsWith("UMLAssociation")){
							GraphConstants.setLineEnd(attr, GraphConstants.ARROW_NONE);
						}
						
					}
					GraphConstants.setDisconnectable(attr,false);
					
					GraphConstants.setBendable(attr,false);
					edgesAttributes.put(auxiliaryEdges[i], attr);
				}
				//////////-----------------------------------//////////
				// Insert the Edge and its Attributes. The order matters.
				if (auxiliaryEdges.length >= 2) {
					//        nEdgeObject.updateCells(newSelected);
					graph.getModel().insert(new Object[] {nEdge},attributes
											, null, null, null);
					String inserted = "";
					for (int j = 0; j < auxiliaryEdges.length; j++) {
						inserted = inserted + auxiliaryEdges[j];
					}
					//          Log.getInstance().logSYS("Inserting " + inserted);
					graph.getModel().insert( (Object[]) auxiliaryEdges,edgesAttributes, cs, null,
											null);
					
				}
				else {
					// There was an error. A relationship was found with less than 2 extremes
					ne = (NAryEdgeEntity)
					nEdge.getUserObject();
					String[] tids = ne.getIds();
					String result = "";
					for (int k = 0; k < tids.length; k++) {
						result = result + tids[k] + ",";
					}
					Log.getInstance().logSYS("WARNING Relationship removed:Relationship " +
											 ne.getId() + " of type " + ne.getType() +
											 " has not been saved properly among objects " +
											 result + " in graph " + graph.getID());
				}
			}
			catch (WrongParameters wp) {
				Log.getInstance().logSYS(
										 "WARNING!!! Cannot produce edges for relationship " +
										 ne.getId() + " of type " + ne.getType());
				wp.printStackTrace();
			}
		}
	}
	
	private Object[] getModelPath(Node n, GraphManager gm) {
		Object[] opath = null;
		Vector path = new Vector();
		NodeList packages = n.getChildNodes();
		for (int k = 0; k < packages.getLength(); k++) {
			Node pack = packages.item(k);
			if (pack.getNodeName().equalsIgnoreCase("path")) {
				NodeList packs = pack.getChildNodes();
				for (int j = 0; j < packs.getLength(); j++) {
					Node npack = packs.item(j);
					if (npack.getNodeName().equalsIgnoreCase("package")) {
						String id = npack.getAttributes().getNamedItem("id").getNodeValue().
						toString();
						path.add(id);
					}
				}
				for (int j = 1; j < path.size(); j++) {
					opath = new Object[j];
					for (int l = 0; l < j; l++) {
						opath[l] = path.elementAt(l);
					}
					gm.addPackage(opath, path.elementAt(j).toString());
				}
			}
		}
		return path.toArray();
	}
	
	
	private DefaultGraphCell getGraphCell(ModelJGraph mj, String id) {
		for (int k = 0; k < mj.getModel().getRootCount(); k++) {
			//      System.err.println("k:"+k+mj.getModel().getRootCount());
			DefaultGraphCell dgc = (DefaultGraphCell) mj.getModel().getRootAt(k);
			ingenias.editor.entities.Entity ent = (ingenias.editor.entities.Entity)
			dgc.getUserObject();
			if (ent.getId().equalsIgnoreCase(id)) {
				return dgc;
			}
			//      System.err.println("Identiddad:"+ent.getId());
		}
		//    System.err.println("no pude encontrar " + id);
		return null;
	}
	
	
	private Vector getConnectedEntities(Node n) {
		Vector result = new Vector();
		NodeList nl = n.getChildNodes();
		for (int k = 0; k < nl.getLength(); k++) {
			Node current = nl.item(k);
			if (current.getNodeName().equalsIgnoreCase("connected")) {
				String id = current.getAttributes().getNamedItem("id").getNodeValue();
				result.add(id);
			}
		}
		return result;
	}
	
	public void restoreModels(IDEState ids,GUIResources resources,
							  Document doc) throws CannotLoadDiagram {
		// For compatibility and in case a future different RM is needed
		RelationshipManager rm = new RelationshipManager();
		NodeList models = doc.getElementsByTagName("models").item(0).getChildNodes();
		boolean allrecovered = true;
		String failureMessage = "";
		
		for (int k = 0; k < models.getLength(); k++) {
			Node model = models.item(k);
			String id = "";
			String type = "";
			try {
				if (model.getNodeName().equalsIgnoreCase("model")) {
					id = model.getAttributes().getNamedItem("id").getNodeValue().
					toString();
					Log.getInstance().logSYS("Loading model " + id);
					type = model.getAttributes().getNamedItem("type").getNodeValue().
					toString();
					this.restoreModel(ids, rm, model);
				}
			}
			catch (Exception e) {
				allrecovered = false;
				failureMessage = failureMessage + "\n Error loading model " + id +
				" of type " + type + ". Original error message was \n " +
				e.getMessage();
				e.printStackTrace();
			}
		}
		if (!allrecovered) {
			throw new CannotLoadDiagram(failureMessage);
		}
	}
	
	private void restoreModel(IDEState ids, RelationshipManager rm,
							  Node model) throws ClassNotFoundException,
	IllegalAccessException, InstantiationException, NoSuchMethodException,
	InvocationTargetException {
		String id = model.getAttributes().getNamedItem("id").getNodeValue().
        toString();
		String type = model.getAttributes().getNamedItem("type").getNodeValue().
        toString();
		
		Object[] path = this.getModelPath(model, ids.gm);
		
		Node graph = null;
		Node layout = null;
		NodeList children = model.getChildNodes();
		ModelDataEntity mde = null;
		
		for (int j = 0; j < children.getLength(); j++) {
			
			Node current = children.item(j);
			if (current.getNodeName().equalsIgnoreCase("object")) {
				mde = (ModelDataEntity) PersistenceManager.getOL().restoreObject(ids.om,
																				 ids.gm, current);
			}
			if (current.getNodeName().equalsIgnoreCase("gxl")) {
				NodeList gxls = current.getChildNodes();
				for (int l = 0; l < gxls.getLength(); l++) {
					Node currentgxl = gxls.item(l);
					if (currentgxl.getNodeName().equalsIgnoreCase("graph")) {
						graph = currentgxl;
					}
					if (currentgxl.getNodeName().equalsIgnoreCase("layout")) {
						layout = currentgxl;
					}
				}
			}
		}
		ModelJGraph mjg = null;
		
		if (mde != null) {
			int indmarquee=type.indexOf("ModelJGraph");
			String marqueetype=type.substring(0,indmarquee)+"MarqueeHandler";
			Constructor consmarquee = Class.forName(marqueetype).getConstructor(new Class[]{Editor.class});
			Object marquee=consmarquee.newInstance(new Object[]{ids.editor});
			Class[] conspar = {
                mde.getClass(), ingenias.editor.Editor.class, String.class,ObjectManager.class, Model.class,BasicMarqueeHandler.class};
            Object[] valpar = {
                mde, ids.editor,id,ids.om,new Model(ids),marquee};
			
			Constructor cons= Class.forName(type).getConstructor(conspar);
			mjg = (ModelJGraph) cons.newInstance(valpar);
		}
		else {
			Class[] conspar = {
				ids.editor.getClass()};
			Object[] valpar = {
				ids.editor};
			Constructor cons = Class.forName(type).getConstructor(conspar);
			mjg = (ModelJGraph) cons.newInstance(valpar);
		}
		
		//mjg.setEditor(ids.editor);
		//mjg.setOM(ids.om);
		//mjg.setId(id);
		this.fromGXL(ids.om, rm, mjg, graph, layout);
		ids.gm.addModel(path, id, mjg);
		ids.editor.setEnabled(true);
		
	}
	
	private Object[] GXL2Array(Node node) throws WrongTypedDOMNode {
		if (node.getNodeName().equals("array")) {
			try {
				Hashtable children = new Hashtable();
				
				// Obtain children
				NodeList values = node.getChildNodes();
				for (int k = 0; k < values.getLength(); k++) {
					try {
						children.put(new Integer(k), GXL2Object(values.item(k)));
					}
					catch (WrongTypedDOMNode e) {
						// It is not a valid child.
					}
				}
				
				Object[] array = new Object[children.size()];
				Iterator it = children.keySet().iterator();
				while (it.hasNext()) {
					Integer index = (Integer) it.next();
					array[index.intValue()] = children.get(index);
				}
				// Construct the Array
				return array;
			}
			catch (Exception e) {
				throw new WrongTypedDOMNode(node.toString() + "is a malformed representation of an Object[].");
			}
		}
		else {
			throw new WrongTypedDOMNode(node.toString() +
										"does not represent an Object[]");
		}
	}
	
	
	private List GXL2List(Node node) throws WrongTypedDOMNode {
		if (node.getNodeName().equals("list")) {
			try {
				ArrayList children = new ArrayList();
				
				// Obtain children
				NodeList values = node.getChildNodes();
				int index = 0;
				for (int k = 0; k < values.getLength(); k++) {
					try {
						Object child = GXL2Object(values.item(k));
						children.add(index++, child);
					}
					catch (WrongTypedDOMNode e) {
						// It is not a valid child.
					}
				}
				// Construct the List
				return ( (List) children);
			}
			catch (Exception e) {
				throw new WrongTypedDOMNode(node.toString() +
											"is a malformed representation of an List.");
			}
		}
		else {
			throw new WrongTypedDOMNode(node.toString() +
										"does not represent an List");
		}
	}
	
	private Point GXL2Point(Node node) throws WrongTypedDOMNode {
		if (node.getNodeName().equals("point")) {
			try {
				// Obtain attributes
				int x = (new Integer(node.getAttributes().getNamedItem("x").
									 getNodeValue())).intValue();
				int y = (new Integer(node.getAttributes().getNamedItem("y").
									 getNodeValue())).intValue();
				// Construct the Point
				return new Point(x, y);
			}
			catch (Exception e) {
				throw new WrongTypedDOMNode(node.toString() +
											"is a malformed representation of a java.awt.Point.");
			}
		}
		else {
			throw new WrongTypedDOMNode(node.toString() +
										"does not represent a java.awt.Point.");
		}
	}
	
	private Rectangle GXL2Rectangle(Node node) throws WrongTypedDOMNode {
		if (node.getNodeName().equals("rectangle")) {
			try {
				// Obtain attributes
				int x = (new Integer(node.getAttributes().getNamedItem("x").
									 getNodeValue())).intValue();
				int y = (new Integer(node.getAttributes().getNamedItem("y").
									 getNodeValue())).intValue();
				int width = (new Integer(node.getAttributes().getNamedItem("width").
										 getNodeValue())).intValue();
				int height = (new Integer(node.getAttributes().getNamedItem("height").
										  getNodeValue())).intValue();
				// Construct the Rectangle
				return new Rectangle(x, y, width, height);
			}
			catch (Exception e) {
				throw new WrongTypedDOMNode(node.toString() +
											"is a malformed representation of a java.awt.Rectangle.");
			}
		}
		else {
			throw new WrongTypedDOMNode(node.toString() +
										"does not represent a java.awt.Rectangle.");
		}
	}
	
	private Object GXL2Object(Node node) throws WrongTypedDOMNode {
		Object object = null;
		
		if (node.getNodeName().equals("point")) {
			object = GXL2Point(node);
		}
		else if (node.getNodeName().equals("rectangle")) {
			object = GXL2Rectangle(node);
		}
		else if (node.getNodeName().equals("list")) {
			object = GXL2List(node);
		}
		else if (node.getNodeName().equals("array")) {
			object = GXL2Array(node);
		}
		else if (node.getNodeName().equals("string")) {
			Node labelNode = node.getFirstChild();
			if (labelNode != null) {
				object = (String) labelNode.getNodeValue();
			}
		}
		else if (node.getNodeName().equals("attr")) {
			NodeList values = node.getChildNodes();
			
			for (int k = 0; k < values.getLength(); k++) {
				try {
					Object objectAttr = GXL2Object(values.item(k));
					if (object == null) {
						object = objectAttr;
					}
				}
				catch (WrongTypedDOMNode e) {
				}
			}
			
			if (object == null) {
				throw new WrongTypedDOMNode(node.toString() +
											"does not represent any valid Object.");
			}
			//        if (values.item(k).getNodeName().equals("string")) {
			//          Node labelNode = values.item(k).getFirstChild();
			//          if (labelNode != null)
			//            object = (String) labelNode.getNodeValue();
			//        }
		}
		else {
			throw new WrongTypedDOMNode(node.toString() +
										"does not represent any valid Object.");
		}
		
		return object;
	}
	
	// Fetch Cell Map from Node
	protected Hashtable getMap(Node node) {
		
		Hashtable hashAttr = new Hashtable();
		
		try {
			// Common attributes
			hashAttr.put(new String("id"),
						 node.getAttributes().getNamedItem("id").getNodeValue());
			hashAttr.put(new String("type"),
						 node.getAttributes().getNamedItem("type").getNodeValue());
			// Edge attributes
			hashAttr.put("from",
						 node.getAttributes().getNamedItem("from").getNodeValue());
			hashAttr.put("to", node.getAttributes().getNamedItem("to").getNodeValue());
		}
		catch (Exception e) {
			// If the node is a vertex there is neither from nor to attributes.
		}
		// Node specific attributes
		NodeList children = node.getChildNodes();
		for (int j = 0; j < children.getLength(); j++) {
			Node attr = children.item(j);
			try {
				Object object = GXL2Object(attr);
				hashAttr.put(attr.getAttributes().getNamedItem("name").getNodeValue(),
							 object);
			}
			catch (Exception e) {
				// The node is not a valid attribute.
			}
		}
		//////////    return (lab != null) ? lab : new String("");
		return hashAttr;
	}
	
	// Gives the ports in the model related with GraphCells in vertexList.
	private Port[] getPorts(ModelJGraph graph, Object[] vertexList) {
		
		// Ports of argument vertexs.
		Port[] ports = new Port[vertexList.length];
		// Obtain the model.
		GraphModel model = graph.getModel();
		
		// Iterate over all Objects.
		for (int i = 0; i < vertexList.length; i++) {
			Port objectPort = null;
			// Iterate over all Children
			for (int j = 0; j < model.getChildCount(vertexList[i]); j++) {
				// Fetch the Child of Vertex at Index i
				Object child = model.getChild(vertexList[i], j);
				// Check if Child is a Port
				if (child instanceof Port) {
					
					// Return the Child as a Port
					objectPort = (Port) child;
				}
			}
			ports[i] = objectPort;
		}
		
		return ports;
	}
	
	public static void main(String[] args) {
		GraphLoadImp1 graphLoad1 = new GraphLoadImp1();
	}
	
}




