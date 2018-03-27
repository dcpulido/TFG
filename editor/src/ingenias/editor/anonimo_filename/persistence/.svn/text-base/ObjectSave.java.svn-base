

package ingenias.editor.persistence;
import java.lang.reflect.*;
import javax.swing.tree.*;
import org.apache.xerces.parsers.DOMParser;
import org.xml.sax.InputSource;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
//import java.awt.image.*;
import java.io.OutputStreamWriter;
import java.io.*;
//import java.awt.*;
//import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
//import javax.swing.event.*;
//import javax.swing.*;
//import java.awt.event.*;
//import java.awt.Rectangle;
//import java.awt.Color;
//import java.net.URL;
import java.util.*;
import java.util.Map;
import java.util.Hashtable;
import java.util.ArrayList;
//import javax.swing.*;
//import javax.swing.event.UndoableEditEvent;
import javax.xml.parsers.*;

import org.jgraph.JGraph;
import org.jgraph.graph.*;
//import org.jgraph.event.*;
//import java.util.Vector;
//import org.jgraph.event.*;
//import org.jgraph.plaf.basic.*;
import org.w3c.dom.*;
import org.w3c.dom.Document;
import org.w3c.dom.DOMImplementation;

import ingenias.editor.entities.*;
import ingenias.exception.*;
import ingenias.editor.cell.*;
import ingenias.editor.*;

public class ObjectSave extends ObjectSaveAbs{

  public void saveObject(ingenias.editor.entities.Entity en, OutputStreamWriter os) throws
      IOException {
    String _name1 = ingenias.editor.entities.Entity.encodeutf8Text(en.getId());
    os.write( "<object id=\"" + _name1 + "\" type=\"" + en.getClass().getName() +
               "\">\n");
    Enumeration enumeration = null;

    
        if (en instanceof ingenias.editor.entities.DecisionNode){
          ingenias.editor.entities.DecisionNode nen=(ingenias.editor.entities.DecisionNode)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.FileSpecPatternMapping){
          ingenias.editor.entities.FileSpecPatternMapping nen=(ingenias.editor.entities.FileSpecPatternMapping)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.TestingPackage){
          ingenias.editor.entities.TestingPackage nen=(ingenias.editor.entities.TestingPackage)en;
	  String _name;
          
          _name=ingenias.editor.entities.Entity.encodeutf8Text("TestingDeployment");
          os.write("<objectproperty id=\""+_name+"\">\n");
          if (nen.getTestingDeployment()!=null)
           saveObject(nen.getTestingDeployment(),os);
          os.write("</objectproperty>\n");
          
          
          os.write("<objectproperty id=\"Tests\" collection=\"true\">\n");
             enumeration=nen.getTestsElements();
          while (enumeration.hasMoreElements()){
            ingenias.editor.entities.Entity next=(ingenias.editor.entities.Entity)enumeration.nextElement();
           saveObject(next,os);
          }
          os.write("</objectproperty>\n");
          
          os.write("<objectproperty id=\"Parameters\" collection=\"true\">\n");
             enumeration=nen.getParametersElements();
          while (enumeration.hasMoreElements()){
            ingenias.editor.entities.Entity next=(ingenias.editor.entities.Entity)enumeration.nextElement();
           saveObject(next,os);
          }
          os.write("</objectproperty>\n");
          
        }
        
        if (en instanceof ingenias.editor.entities.MethodParameter){
          ingenias.editor.entities.MethodParameter nen=(ingenias.editor.entities.MethodParameter)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.MentalState){
          ingenias.editor.entities.MentalState nen=(ingenias.editor.entities.MentalState)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.InternalApplication){
          ingenias.editor.entities.InternalApplication nen=(ingenias.editor.entities.InternalApplication)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.FileSpecMapping){
          ingenias.editor.entities.FileSpecMapping nen=(ingenias.editor.entities.FileSpecMapping)en;
	  String _name;
          
          _name=ingenias.editor.entities.Entity.encodeutf8Text("Entity");
          os.write("<objectproperty id=\""+_name+"\">\n");
          if (nen.getEntity()!=null)
           saveObject(nen.getEntity(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
        if (en instanceof ingenias.editor.entities.Parameter){
          ingenias.editor.entities.Parameter nen=(ingenias.editor.entities.Parameter)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.Goal){
          ingenias.editor.entities.Goal nen=(ingenias.editor.entities.Goal)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.AgentWS){
          ingenias.editor.entities.AgentWS nen=(ingenias.editor.entities.AgentWS)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.Fact){
          ingenias.editor.entities.Fact nen=(ingenias.editor.entities.Fact)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.AOPMentalStatePattern){
          ingenias.editor.entities.AOPMentalStatePattern nen=(ingenias.editor.entities.AOPMentalStatePattern)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.ShareTouple){
          ingenias.editor.entities.ShareTouple nen=(ingenias.editor.entities.ShareTouple)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.DeploymentUnitByTypeWithInitMS){
          ingenias.editor.entities.DeploymentUnitByTypeWithInitMS nen=(ingenias.editor.entities.DeploymentUnitByTypeWithInitMS)en;
	  String _name;
          
          _name=ingenias.editor.entities.Entity.encodeutf8Text("InitialState");
          os.write("<objectproperty id=\""+_name+"\">\n");
          if (nen.getInitialState()!=null)
           saveObject(nen.getInitialState(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
        if (en instanceof ingenias.editor.entities.JoinNode){
          ingenias.editor.entities.JoinNode nen=(ingenias.editor.entities.JoinNode)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.Slot){
          ingenias.editor.entities.Slot nen=(ingenias.editor.entities.Slot)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.RuntimeEvent){
          ingenias.editor.entities.RuntimeEvent nen=(ingenias.editor.entities.RuntimeEvent)en;
	  String _name;
          
          
          os.write("<objectproperty id=\"Stack\" collection=\"true\">\n");
             enumeration=nen.getStackElements();
          while (enumeration.hasMoreElements()){
            ingenias.editor.entities.Entity next=(ingenias.editor.entities.Entity)enumeration.nextElement();
           saveObject(next,os);
          }
          os.write("</objectproperty>\n");
          
        }
        
        if (en instanceof ingenias.editor.entities.InitialNode){
          ingenias.editor.entities.InitialNode nen=(ingenias.editor.entities.InitialNode)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.Method){
          ingenias.editor.entities.Method nen=(ingenias.editor.entities.Method)en;
	  String _name;
          
          
          os.write("<objectproperty id=\"Parameter\" collection=\"true\">\n");
             enumeration=nen.getParameterElements();
          while (enumeration.hasMoreElements()){
            ingenias.editor.entities.Entity next=(ingenias.editor.entities.Entity)enumeration.nextElement();
           saveObject(next,os);
          }
          os.write("</objectproperty>\n");
          
        }
        
        if (en instanceof ingenias.editor.entities.TextUseCase){
          ingenias.editor.entities.TextUseCase nen=(ingenias.editor.entities.TextUseCase)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.RemoteProcedureCall){
          ingenias.editor.entities.RemoteProcedureCall nen=(ingenias.editor.entities.RemoteProcedureCall)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.MentalEntity){
          ingenias.editor.entities.MentalEntity nen=(ingenias.editor.entities.MentalEntity)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.Resource){
          ingenias.editor.entities.Resource nen=(ingenias.editor.entities.Resource)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.AgentModelBelieve){
          ingenias.editor.entities.AgentModelBelieve nen=(ingenias.editor.entities.AgentModelBelieve)en;
	  String _name;
          
          
          os.write("<objectproperty id=\"Believed\" collection=\"true\">\n");
             enumeration=nen.getBelievedElements();
          while (enumeration.hasMoreElements()){
            ingenias.editor.entities.Entity next=(ingenias.editor.entities.Entity)enumeration.nextElement();
           saveObject(next,os);
          }
          os.write("</objectproperty>\n");
          
        }
        
        if (en instanceof ingenias.editor.entities.ActivityFinal){
          ingenias.editor.entities.ActivityFinal nen=(ingenias.editor.entities.ActivityFinal)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.INGENIASUseCase){
          ingenias.editor.entities.INGENIASUseCase nen=(ingenias.editor.entities.INGENIASUseCase)en;
	  String _name;
          
          
          os.write("<objectproperty id=\"Postcondition\" collection=\"true\">\n");
             enumeration=nen.getPostconditionElements();
          while (enumeration.hasMoreElements()){
            ingenias.editor.entities.Entity next=(ingenias.editor.entities.Entity)enumeration.nextElement();
           saveObject(next,os);
          }
          os.write("</objectproperty>\n");
          
          os.write("<objectproperty id=\"Scenarios\" collection=\"true\">\n");
             enumeration=nen.getScenariosElements();
          while (enumeration.hasMoreElements()){
            ingenias.editor.entities.Entity next=(ingenias.editor.entities.Entity)enumeration.nextElement();
           saveObject(next,os);
          }
          os.write("</objectproperty>\n");
          
          os.write("<objectproperty id=\"Precondition\" collection=\"true\">\n");
             enumeration=nen.getPreconditionElements();
          while (enumeration.hasMoreElements()){
            ingenias.editor.entities.Entity next=(ingenias.editor.entities.Entity)enumeration.nextElement();
           saveObject(next,os);
          }
          os.write("</objectproperty>\n");
          
        }
        
        if (en instanceof ingenias.editor.entities.GRASIAAgentDescription){
          ingenias.editor.entities.GRASIAAgentDescription nen=(ingenias.editor.entities.GRASIAAgentDescription)en;
	  String _name;
          
          _name=ingenias.editor.entities.Entity.encodeutf8Text("DescriptionWithAgentModel");
          os.write("<objectproperty id=\""+_name+"\">\n");
          if (nen.getDescriptionWithAgentModel()!=null)
           saveObject(nen.getDescriptionWithAgentModel(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
        if (en instanceof ingenias.editor.entities.TextNote){
          ingenias.editor.entities.TextNote nen=(ingenias.editor.entities.TextNote)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.RuntimeFact){
          ingenias.editor.entities.RuntimeFact nen=(ingenias.editor.entities.RuntimeFact)en;
	  String _name;
          
          
          os.write("<objectproperty id=\"Stack\" collection=\"true\">\n");
             enumeration=nen.getStackElements();
          while (enumeration.hasMoreElements()){
            ingenias.editor.entities.Entity next=(ingenias.editor.entities.Entity)enumeration.nextElement();
           saveObject(next,os);
          }
          os.write("</objectproperty>\n");
          
        }
        
        if (en instanceof ingenias.editor.entities.ForkNode){
          ingenias.editor.entities.ForkNode nen=(ingenias.editor.entities.ForkNode)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.OrganizationNetwork){
          ingenias.editor.entities.OrganizationNetwork nen=(ingenias.editor.entities.OrganizationNetwork)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.UseCase){
          ingenias.editor.entities.UseCase nen=(ingenias.editor.entities.UseCase)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.MessagePassing){
          ingenias.editor.entities.MessagePassing nen=(ingenias.editor.entities.MessagePassing)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.SubProtocol){
          ingenias.editor.entities.SubProtocol nen=(ingenias.editor.entities.SubProtocol)en;
	  String _name;
          
          _name=ingenias.editor.entities.Entity.encodeutf8Text("Protocol");
          os.write("<objectproperty id=\""+_name+"\">\n");
          if (nen.getProtocol()!=null)
           saveObject(nen.getProtocol(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
        if (en instanceof ingenias.editor.entities.RuntimeConversation){
          ingenias.editor.entities.RuntimeConversation nen=(ingenias.editor.entities.RuntimeConversation)en;
	  String _name;
          
          _name=ingenias.editor.entities.Entity.encodeutf8Text("Interaction");
          os.write("<objectproperty id=\""+_name+"\">\n");
          if (nen.getInteraction()!=null)
           saveObject(nen.getInteraction(),os);
          os.write("</objectproperty>\n");
          
          _name=ingenias.editor.entities.Entity.encodeutf8Text("ParentConversation");
          os.write("<objectproperty id=\""+_name+"\">\n");
          if (nen.getParentConversation()!=null)
           saveObject(nen.getParentConversation(),os);
          os.write("</objectproperty>\n");
          
          
          os.write("<objectproperty id=\"Stack\" collection=\"true\">\n");
             enumeration=nen.getStackElements();
          while (enumeration.hasMoreElements()){
            ingenias.editor.entities.Entity next=(ingenias.editor.entities.Entity)enumeration.nextElement();
           saveObject(next,os);
          }
          os.write("</objectproperty>\n");
          
          os.write("<objectproperty id=\"ChildConversation\" collection=\"true\">\n");
             enumeration=nen.getChildConversationElements();
          while (enumeration.hasMoreElements()){
            ingenias.editor.entities.Entity next=(ingenias.editor.entities.Entity)enumeration.nextElement();
           saveObject(next,os);
          }
          os.write("</objectproperty>\n");
          
        }
        
        if (en instanceof ingenias.editor.entities.SlotValueSpecification){
          ingenias.editor.entities.SlotValueSpecification nen=(ingenias.editor.entities.SlotValueSpecification)en;
	  String _name;
          
          _name=ingenias.editor.entities.Entity.encodeutf8Text("Slot");
          os.write("<objectproperty id=\""+_name+"\">\n");
          if (nen.getSlot()!=null)
           saveObject(nen.getSlot(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
        if (en instanceof ingenias.editor.entities.INGENIASObject){
          ingenias.editor.entities.INGENIASObject nen=(ingenias.editor.entities.INGENIASObject)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.AUMLComponent){
          ingenias.editor.entities.AUMLComponent nen=(ingenias.editor.entities.AUMLComponent)en;
	  String _name;
          
          _name=ingenias.editor.entities.Entity.encodeutf8Text("Parent");
          os.write("<objectproperty id=\""+_name+"\">\n");
          if (nen.getParent()!=null)
           saveObject(nen.getParent(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
        if (en instanceof ingenias.editor.entities.NaturalLanguageAgentDescription){
          ingenias.editor.entities.NaturalLanguageAgentDescription nen=(ingenias.editor.entities.NaturalLanguageAgentDescription)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.Organization){
          ingenias.editor.entities.Organization nen=(ingenias.editor.entities.Organization)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.ConditionalMentalState){
          ingenias.editor.entities.ConditionalMentalState nen=(ingenias.editor.entities.ConditionalMentalState)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.ApplicationWS){
          ingenias.editor.entities.ApplicationWS nen=(ingenias.editor.entities.ApplicationWS)en;
	  String _name;
          
          _name=ingenias.editor.entities.Entity.encodeutf8Text("UsesServiceRole");
          os.write("<objectproperty id=\""+_name+"\">\n");
          if (nen.getUsesServiceRole()!=null)
           saveObject(nen.getUsesServiceRole(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
        if (en instanceof ingenias.editor.entities.AUMLSpecification){
          ingenias.editor.entities.AUMLSpecification nen=(ingenias.editor.entities.AUMLSpecification)en;
	  String _name;
          
          _name=ingenias.editor.entities.Entity.encodeutf8Text("ModelThatContainsSpecification");
          os.write("<objectproperty id=\""+_name+"\">\n");
          if (nen.getModelThatContainsSpecification()!=null)
           saveObject(nen.getModelThatContainsSpecification(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
        if (en instanceof ingenias.editor.entities.Application){
          ingenias.editor.entities.Application nen=(ingenias.editor.entities.Application)en;
	  String _name;
          
          
          os.write("<objectproperty id=\"Methods\" collection=\"true\">\n");
             enumeration=nen.getMethodsElements();
          while (enumeration.hasMoreElements()){
            ingenias.editor.entities.Entity next=(ingenias.editor.entities.Entity)enumeration.nextElement();
           saveObject(next,os);
          }
          os.write("</objectproperty>\n");
          
        }
        
        if (en instanceof ingenias.editor.entities.DeploymentPackage){
          ingenias.editor.entities.DeploymentPackage nen=(ingenias.editor.entities.DeploymentPackage)en;
	  String _name;
          
          
          os.write("<objectproperty id=\"Parameters\" collection=\"true\">\n");
             enumeration=nen.getParametersElements();
          while (enumeration.hasMoreElements()){
            ingenias.editor.entities.Entity next=(ingenias.editor.entities.Entity)enumeration.nextElement();
           saveObject(next,os);
          }
          os.write("</objectproperty>\n");
          
          os.write("<objectproperty id=\"AgentsDeployed\" collection=\"true\">\n");
             enumeration=nen.getAgentsDeployedElements();
          while (enumeration.hasMoreElements()){
            ingenias.editor.entities.Entity next=(ingenias.editor.entities.Entity)enumeration.nextElement();
           saveObject(next,os);
          }
          os.write("</objectproperty>\n");
          
        }
        
        if (en instanceof ingenias.editor.entities.Plan){
          ingenias.editor.entities.Plan nen=(ingenias.editor.entities.Plan)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.UMLComponent){
          ingenias.editor.entities.UMLComponent nen=(ingenias.editor.entities.UMLComponent)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.AUMLPort){
          ingenias.editor.entities.AUMLPort nen=(ingenias.editor.entities.AUMLPort)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.INGENIASComponent){
          ingenias.editor.entities.INGENIASComponent nen=(ingenias.editor.entities.INGENIASComponent)en;
	  String _name;
          
          
          os.write("<objectproperty id=\"Files\" collection=\"true\">\n");
             enumeration=nen.getFilesElements();
          while (enumeration.hasMoreElements()){
            ingenias.editor.entities.Entity next=(ingenias.editor.entities.Entity)enumeration.nextElement();
           saveObject(next,os);
          }
          os.write("</objectproperty>\n");
          
        }
        
        if (en instanceof ingenias.editor.entities.OrganizationGroup){
          ingenias.editor.entities.OrganizationGroup nen=(ingenias.editor.entities.OrganizationGroup)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.IUConcurrence){
          ingenias.editor.entities.IUConcurrence nen=(ingenias.editor.entities.IUConcurrence)en;
	  String _name;
          
          
          os.write("<objectproperty id=\"InteractionUnits\" collection=\"true\">\n");
             enumeration=nen.getInteractionUnitsElements();
          while (enumeration.hasMoreElements()){
            ingenias.editor.entities.Entity next=(ingenias.editor.entities.Entity)enumeration.nextElement();
           saveObject(next,os);
          }
          os.write("</objectproperty>\n");
          
        }
        
        if (en instanceof ingenias.editor.entities.DeploymentUnitByType){
          ingenias.editor.entities.DeploymentUnitByType nen=(ingenias.editor.entities.DeploymentUnitByType)en;
	  String _name;
          
          _name=ingenias.editor.entities.Entity.encodeutf8Text("AgentTypeDeployed");
          os.write("<objectproperty id=\""+_name+"\">\n");
          if (nen.getAgentTypeDeployed()!=null)
           saveObject(nen.getAgentTypeDeployed(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
        if (en instanceof ingenias.editor.entities.IUIterate){
          ingenias.editor.entities.IUIterate nen=(ingenias.editor.entities.IUIterate)en;
	  String _name;
          
          
          os.write("<objectproperty id=\"InteractionUnits\" collection=\"true\">\n");
             enumeration=nen.getInteractionUnitsElements();
          while (enumeration.hasMoreElements()){
            ingenias.editor.entities.Entity next=(ingenias.editor.entities.Entity)enumeration.nextElement();
           saveObject(next,os);
          }
          os.write("</objectproperty>\n");
          
        }
        
        if (en instanceof ingenias.editor.entities.InformationMentalEntity){
          ingenias.editor.entities.InformationMentalEntity nen=(ingenias.editor.entities.InformationMentalEntity)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.AUMLAlternativeRow){
          ingenias.editor.entities.AUMLAlternativeRow nen=(ingenias.editor.entities.AUMLAlternativeRow)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.Column){
          ingenias.editor.entities.Column nen=(ingenias.editor.entities.Column)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.AutonomousEntityQuery){
          ingenias.editor.entities.AutonomousEntityQuery nen=(ingenias.editor.entities.AutonomousEntityQuery)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.AUMLContainer){
          ingenias.editor.entities.AUMLContainer nen=(ingenias.editor.entities.AUMLContainer)en;
	  String _name;
          
          
          os.write("<objectproperty id=\"Children\" collection=\"true\">\n");
             enumeration=nen.getChildrenElements();
          while (enumeration.hasMoreElements()){
            ingenias.editor.entities.Entity next=(ingenias.editor.entities.Entity)enumeration.nextElement();
           saveObject(next,os);
          }
          os.write("</objectproperty>\n");
          
        }
        
        if (en instanceof ingenias.editor.entities.ConcreteAgent){
          ingenias.editor.entities.ConcreteAgent nen=(ingenias.editor.entities.ConcreteAgent)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.UMLComment){
          ingenias.editor.entities.UMLComment nen=(ingenias.editor.entities.UMLComment)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.AgentRequirementsQuery){
          ingenias.editor.entities.AgentRequirementsQuery nen=(ingenias.editor.entities.AgentRequirementsQuery)en;
	  String _name;
          
          _name=ingenias.editor.entities.Entity.encodeutf8Text("Requirements");
          os.write("<objectproperty id=\""+_name+"\">\n");
          if (nen.getRequirements()!=null)
           saveObject(nen.getRequirements(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
        if (en instanceof ingenias.editor.entities.UMLSpecification){
          ingenias.editor.entities.UMLSpecification nen=(ingenias.editor.entities.UMLSpecification)en;
	  String _name;
          
          _name=ingenias.editor.entities.Entity.encodeutf8Text("ModelThatContainsSpecification");
          os.write("<objectproperty id=\""+_name+"\">\n");
          if (nen.getModelThatContainsSpecification()!=null)
           saveObject(nen.getModelThatContainsSpecification(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
        if (en instanceof ingenias.editor.entities.Believe){
          ingenias.editor.entities.Believe nen=(ingenias.editor.entities.Believe)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.WorkflowBox){
          ingenias.editor.entities.WorkflowBox nen=(ingenias.editor.entities.WorkflowBox)en;
	  String _name;
          
          _name=ingenias.editor.entities.Entity.encodeutf8Text("Workflow");
          os.write("<objectproperty id=\""+_name+"\">\n");
          if (nen.getWorkflow()!=null)
           saveObject(nen.getWorkflow(),os);
          os.write("</objectproperty>\n");
          
          _name=ingenias.editor.entities.Entity.encodeutf8Text("Role");
          os.write("<objectproperty id=\""+_name+"\">\n");
          if (nen.getRole()!=null)
           saveObject(nen.getRole(),os);
          os.write("</objectproperty>\n");
          
          
          os.write("<objectproperty id=\"Tasks\" collection=\"true\">\n");
             enumeration=nen.getTasksElements();
          while (enumeration.hasMoreElements()){
            ingenias.editor.entities.Entity next=(ingenias.editor.entities.Entity)enumeration.nextElement();
           saveObject(next,os);
          }
          os.write("</objectproperty>\n");
          
        }
        
        if (en instanceof ingenias.editor.entities.AgentComponent){
          ingenias.editor.entities.AgentComponent nen=(ingenias.editor.entities.AgentComponent)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.GRASIAMentalStatePattern){
          ingenias.editor.entities.GRASIAMentalStatePattern nen=(ingenias.editor.entities.GRASIAMentalStatePattern)en;
	  String _name;
          
          _name=ingenias.editor.entities.Entity.encodeutf8Text("DescriptionWithAgentModel");
          os.write("<objectproperty id=\""+_name+"\">\n");
          if (nen.getDescriptionWithAgentModel()!=null)
           saveObject(nen.getDescriptionWithAgentModel(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
        if (en instanceof ingenias.editor.entities.DeploymentUnitByTypeEnumInitMS){
          ingenias.editor.entities.DeploymentUnitByTypeEnumInitMS nen=(ingenias.editor.entities.DeploymentUnitByTypeEnumInitMS)en;
	  String _name;
          
          
          os.write("<objectproperty id=\"InitialState\" collection=\"true\">\n");
             enumeration=nen.getInitialStateElements();
          while (enumeration.hasMoreElements()){
            ingenias.editor.entities.Entity next=(ingenias.editor.entities.Entity)enumeration.nextElement();
           saveObject(next,os);
          }
          os.write("</objectproperty>\n");
          
        }
        
        if (en instanceof ingenias.editor.entities.Autonomous_entity){
          ingenias.editor.entities.Autonomous_entity nen=(ingenias.editor.entities.Autonomous_entity)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.GeneralEvent){
          ingenias.editor.entities.GeneralEvent nen=(ingenias.editor.entities.GeneralEvent)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.Compromise){
          ingenias.editor.entities.Compromise nen=(ingenias.editor.entities.Compromise)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.Role){
          ingenias.editor.entities.Role nen=(ingenias.editor.entities.Role)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.ControlMentalEntity){
          ingenias.editor.entities.ControlMentalEntity nen=(ingenias.editor.entities.ControlMentalEntity)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.EnvironmentApplication){
          ingenias.editor.entities.EnvironmentApplication nen=(ingenias.editor.entities.EnvironmentApplication)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.ApplicationEventSlots){
          ingenias.editor.entities.ApplicationEventSlots nen=(ingenias.editor.entities.ApplicationEventSlots)en;
	  String _name;
          
          
          os.write("<objectproperty id=\"Slots\" collection=\"true\">\n");
             enumeration=nen.getSlotsElements();
          while (enumeration.hasMoreElements()){
            ingenias.editor.entities.Entity next=(ingenias.editor.entities.Entity)enumeration.nextElement();
           saveObject(next,os);
          }
          os.write("</objectproperty>\n");
          
        }
        
        if (en instanceof ingenias.editor.entities.AgentDescription){
          ingenias.editor.entities.AgentDescription nen=(ingenias.editor.entities.AgentDescription)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.MentalStatePattern){
          ingenias.editor.entities.MentalStatePattern nen=(ingenias.editor.entities.MentalStatePattern)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.Protocol){
          ingenias.editor.entities.Protocol nen=(ingenias.editor.entities.Protocol)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.MentalInstanceSpecification){
          ingenias.editor.entities.MentalInstanceSpecification nen=(ingenias.editor.entities.MentalInstanceSpecification)en;
	  String _name;
          
          _name=ingenias.editor.entities.Entity.encodeutf8Text("InstanceType");
          os.write("<objectproperty id=\""+_name+"\">\n");
          if (nen.getInstanceType()!=null)
           saveObject(nen.getInstanceType(),os);
          os.write("</objectproperty>\n");
          
          
          os.write("<objectproperty id=\"SlotsValues\" collection=\"true\">\n");
             enumeration=nen.getSlotsValuesElements();
          while (enumeration.hasMoreElements()){
            ingenias.editor.entities.Entity next=(ingenias.editor.entities.Entity)enumeration.nextElement();
           saveObject(next,os);
          }
          os.write("</objectproperty>\n");
          
        }
        
        if (en instanceof ingenias.editor.entities.ActionUML){
          ingenias.editor.entities.ActionUML nen=(ingenias.editor.entities.ActionUML)en;
	  String _name;
          
          
          os.write("<objectproperty id=\"Tasks\" collection=\"true\">\n");
             enumeration=nen.getTasksElements();
          while (enumeration.hasMoreElements()){
            ingenias.editor.entities.Entity next=(ingenias.editor.entities.Entity)enumeration.nextElement();
           saveObject(next,os);
          }
          os.write("</objectproperty>\n");
          
        }
        
        if (en instanceof ingenias.editor.entities.StackEntry){
          ingenias.editor.entities.StackEntry nen=(ingenias.editor.entities.StackEntry)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.InteractionUnit){
          ingenias.editor.entities.InteractionUnit nen=(ingenias.editor.entities.InteractionUnit)en;
	  String _name;
          
          
          os.write("<objectproperty id=\"TransferredInfo\" collection=\"true\">\n");
             enumeration=nen.getTransferredInfoElements();
          while (enumeration.hasMoreElements()){
            ingenias.editor.entities.Entity next=(ingenias.editor.entities.Entity)enumeration.nextElement();
           saveObject(next,os);
          }
          os.write("</objectproperty>\n");
          
        }
        
        if (en instanceof ingenias.editor.entities.GRASIASpecification){
          ingenias.editor.entities.GRASIASpecification nen=(ingenias.editor.entities.GRASIASpecification)en;
	  String _name;
          
          _name=ingenias.editor.entities.Entity.encodeutf8Text("ModelThatContainsSpecification");
          os.write("<objectproperty id=\""+_name+"\">\n");
          if (nen.getModelThatContainsSpecification()!=null)
           saveObject(nen.getModelThatContainsSpecification(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
        if (en instanceof ingenias.editor.entities.UMLClass){
          ingenias.editor.entities.UMLClass nen=(ingenias.editor.entities.UMLClass)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.MentalStateProcessor){
          ingenias.editor.entities.MentalStateProcessor nen=(ingenias.editor.entities.MentalStateProcessor)en;
	  String _name;
          
          
          os.write("<objectproperty id=\"ProcessorDescription\" collection=\"true\">\n");
             enumeration=nen.getProcessorDescriptionElements();
          while (enumeration.hasMoreElements()){
            ingenias.editor.entities.Entity next=(ingenias.editor.entities.Entity)enumeration.nextElement();
           saveObject(next,os);
          }
          os.write("</objectproperty>\n");
          
        }
        
        if (en instanceof ingenias.editor.entities.MergeNode){
          ingenias.editor.entities.MergeNode nen=(ingenias.editor.entities.MergeNode)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.EndNode){
          ingenias.editor.entities.EndNode nen=(ingenias.editor.entities.EndNode)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.FrameFact){
          ingenias.editor.entities.FrameFact nen=(ingenias.editor.entities.FrameFact)en;
	  String _name;
          
          
          os.write("<objectproperty id=\"Slots\" collection=\"true\">\n");
             enumeration=nen.getSlotsElements();
          while (enumeration.hasMoreElements()){
            ingenias.editor.entities.Entity next=(ingenias.editor.entities.Entity)enumeration.nextElement();
           saveObject(next,os);
          }
          os.write("</objectproperty>\n");
          
        }
        
        if (en instanceof ingenias.editor.entities.Test){
          ingenias.editor.entities.Test nen=(ingenias.editor.entities.Test)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.Lifeline){
          ingenias.editor.entities.Lifeline nen=(ingenias.editor.entities.Lifeline)en;
	  String _name;
          
          _name=ingenias.editor.entities.Entity.encodeutf8Text("Agent");
          os.write("<objectproperty id=\""+_name+"\">\n");
          if (nen.getAgent()!=null)
           saveObject(nen.getAgent(),os);
          os.write("</objectproperty>\n");
          
          _name=ingenias.editor.entities.Entity.encodeutf8Text("Role");
          os.write("<objectproperty id=\""+_name+"\">\n");
          if (nen.getRole()!=null)
           saveObject(nen.getRole(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
        if (en instanceof ingenias.editor.entities.SymbolicMentalStatePattern){
          ingenias.editor.entities.SymbolicMentalStatePattern nen=(ingenias.editor.entities.SymbolicMentalStatePattern)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.PROLOGAgentDescription){
          ingenias.editor.entities.PROLOGAgentDescription nen=(ingenias.editor.entities.PROLOGAgentDescription)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.Interaction){
          ingenias.editor.entities.Interaction nen=(ingenias.editor.entities.Interaction)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.Specification){
          ingenias.editor.entities.Specification nen=(ingenias.editor.entities.Specification)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.Agent){
          ingenias.editor.entities.Agent nen=(ingenias.editor.entities.Agent)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.MentalStateManager){
          ingenias.editor.entities.MentalStateManager nen=(ingenias.editor.entities.MentalStateManager)en;
	  String _name;
          
          
          os.write("<objectproperty id=\"ManagerDescription\" collection=\"true\">\n");
             enumeration=nen.getManagerDescriptionElements();
          while (enumeration.hasMoreElements()){
            ingenias.editor.entities.Entity next=(ingenias.editor.entities.Entity)enumeration.nextElement();
           saveObject(next,os);
          }
          os.write("</objectproperty>\n");
          
        }
        
        if (en instanceof ingenias.editor.entities.INGENIASCodeComponent){
          ingenias.editor.entities.INGENIASCodeComponent nen=(ingenias.editor.entities.INGENIASCodeComponent)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.UMLClassifier){
          ingenias.editor.entities.UMLClassifier nen=(ingenias.editor.entities.UMLClassifier)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.CommunicationEvent){
          ingenias.editor.entities.CommunicationEvent nen=(ingenias.editor.entities.CommunicationEvent)en;
	  String _name;
          
          _name=ingenias.editor.entities.Entity.encodeutf8Text("InteractionUnit");
          os.write("<objectproperty id=\""+_name+"\">\n");
          if (nen.getInteractionUnit()!=null)
           saveObject(nen.getInteractionUnit(),os);
          os.write("</objectproperty>\n");
          
          _name=ingenias.editor.entities.Entity.encodeutf8Text("Interaction");
          os.write("<objectproperty id=\""+_name+"\">\n");
          if (nen.getInteraction()!=null)
           saveObject(nen.getInteraction(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
        if (en instanceof ingenias.editor.entities.TaskWS){
          ingenias.editor.entities.TaskWS nen=(ingenias.editor.entities.TaskWS)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.ObjectSlot){
          ingenias.editor.entities.ObjectSlot nen=(ingenias.editor.entities.ObjectSlot)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.GoalStateWS){
          ingenias.editor.entities.GoalStateWS nen=(ingenias.editor.entities.GoalStateWS)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.StateGoal){
          ingenias.editor.entities.StateGoal nen=(ingenias.editor.entities.StateGoal)en;
	  String _name;
          
          _name=ingenias.editor.entities.Entity.encodeutf8Text("LinkedGoal");
          os.write("<objectproperty id=\""+_name+"\">\n");
          if (nen.getLinkedGoal()!=null)
           saveObject(nen.getLinkedGoal(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
        if (en instanceof ingenias.editor.entities.Conversation){
          ingenias.editor.entities.Conversation nen=(ingenias.editor.entities.Conversation)en;
	  String _name;
          
          _name=ingenias.editor.entities.Entity.encodeutf8Text("Interaction");
          os.write("<objectproperty id=\""+_name+"\">\n");
          if (nen.getInteraction()!=null)
           saveObject(nen.getInteraction(),os);
          os.write("</objectproperty>\n");
          
          
          os.write("<objectproperty id=\"CurrentContent\" collection=\"true\">\n");
             enumeration=nen.getCurrentContentElements();
          while (enumeration.hasMoreElements()){
            ingenias.editor.entities.Entity next=(ingenias.editor.entities.Entity)enumeration.nextElement();
           saveObject(next,os);
          }
          os.write("</objectproperty>\n");
          
        }
        
        if (en instanceof ingenias.editor.entities.ApplicationEvent){
          ingenias.editor.entities.ApplicationEvent nen=(ingenias.editor.entities.ApplicationEvent)en;
	  String _name;
          
          _name=ingenias.editor.entities.Entity.encodeutf8Text("Source");
          os.write("<objectproperty id=\""+_name+"\">\n");
          if (nen.getSource()!=null)
           saveObject(nen.getSource(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
        if (en instanceof ingenias.editor.entities.Task){
          ingenias.editor.entities.Task nen=(ingenias.editor.entities.Task)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.DeploymentUnitByTypeMSEntity){
          ingenias.editor.entities.DeploymentUnitByTypeMSEntity nen=(ingenias.editor.entities.DeploymentUnitByTypeMSEntity)en;
	  String _name;
          
          _name=ingenias.editor.entities.Entity.encodeutf8Text("InitialState");
          os.write("<objectproperty id=\""+_name+"\">\n");
          if (nen.getInitialState()!=null)
           saveObject(nen.getInitialState(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
        if (en instanceof ingenias.editor.entities.RoleWS){
          ingenias.editor.entities.RoleWS nen=(ingenias.editor.entities.RoleWS)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.AUMLAlternativeBox){
          ingenias.editor.entities.AUMLAlternativeBox nen=(ingenias.editor.entities.AUMLAlternativeBox)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.Workflow){
          ingenias.editor.entities.Workflow nen=(ingenias.editor.entities.Workflow)en;
	  String _name;
          
          
        }
        
        if (en instanceof ingenias.editor.entities.UMLObject){
          ingenias.editor.entities.UMLObject nen=(ingenias.editor.entities.UMLObject)en;
	  String _name;
          
          
        }
        

        
         if (en.getClass().equals(ingenias.editor.entities.EnvironmentModelDataEntity.class)){
          ingenias.editor.entities.EnvironmentModelDataEntity nen=(ingenias.editor.entities.EnvironmentModelDataEntity)en;
	 String _name;
	
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.ComponentDiagramDataEntity.class)){
          ingenias.editor.entities.ComponentDiagramDataEntity nen=(ingenias.editor.entities.ComponentDiagramDataEntity)en;
	 String _name;
	
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.OrganizationModelDataEntity.class)){
          ingenias.editor.entities.OrganizationModelDataEntity nen=(ingenias.editor.entities.OrganizationModelDataEntity)en;
	 String _name;
	
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.TasksAndGoalsModelDataEntity.class)){
          ingenias.editor.entities.TasksAndGoalsModelDataEntity nen=(ingenias.editor.entities.TasksAndGoalsModelDataEntity)en;
	 String _name;
	
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.InteractionModelDataEntity.class)){
          ingenias.editor.entities.InteractionModelDataEntity nen=(ingenias.editor.entities.InteractionModelDataEntity)en;
	 String _name;
	
          _name=ingenias.editor.entities.Entity.encodeutf8Text("InteractionConsidered");
          os.write("<objectproperty id=\""+_name+"\">\n");
          if (nen.getInteractionConsidered()!=null)
           saveObject(nen.getInteractionConsidered(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.ActivityDiagramDataEntity.class)){
          ingenias.editor.entities.ActivityDiagramDataEntity nen=(ingenias.editor.entities.ActivityDiagramDataEntity)en;
	 String _name;
	
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.AgentModelDataEntity.class)){
          ingenias.editor.entities.AgentModelDataEntity nen=(ingenias.editor.entities.AgentModelDataEntity)en;
	 String _name;
	
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.UseCaseDiagramDataEntity.class)){
          ingenias.editor.entities.UseCaseDiagramDataEntity nen=(ingenias.editor.entities.UseCaseDiagramDataEntity)en;
	 String _name;
	
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.AUMLInteractionDiagramDataEntity.class)){
          ingenias.editor.entities.AUMLInteractionDiagramDataEntity nen=(ingenias.editor.entities.AUMLInteractionDiagramDataEntity)en;
	 String _name;
	
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.DeployDiagramDataEntity.class)){
          ingenias.editor.entities.DeployDiagramDataEntity nen=(ingenias.editor.entities.DeployDiagramDataEntity)en;
	 String _name;
	
          
        }
        

        
         if (en.getClass().equals(ingenias.editor.entities.AHasMSManager.class)){
          ingenias.editor.entities.AHasMSManager nen=(ingenias.editor.entities.AHasMSManager)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.AGOInconditionalSubordinationRelationshipOrg.class)){
          ingenias.editor.entities.AGOInconditionalSubordinationRelationshipOrg nen=(ingenias.editor.entities.AGOInconditionalSubordinationRelationshipOrg)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.GTDecomposes.class)){
          ingenias.editor.entities.GTDecomposes nen=(ingenias.editor.entities.GTDecomposes)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.WFResponsible.class)){
          ingenias.editor.entities.WFResponsible nen=(ingenias.editor.entities.WFResponsible)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.CDUsesCode.class)){
          ingenias.editor.entities.CDUsesCode nen=(ingenias.editor.entities.CDUsesCode)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.AGOCondSubordinationRelationshipGroup.class)){
          ingenias.editor.entities.AGOCondSubordinationRelationshipGroup nen=(ingenias.editor.entities.AGOCondSubordinationRelationshipGroup)en;
          
          os.write("<objectproperty id=\"Condition\">\n");
          if (nen.getCondition()!=null)
           saveObject(nen.getCondition(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.OHasMember.class)){
          ingenias.editor.entities.OHasMember nen=(ingenias.editor.entities.OHasMember)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.EPerceivesPolling.class)){
          ingenias.editor.entities.EPerceivesPolling nen=(ingenias.editor.entities.EPerceivesPolling)en;
          
          os.write("<objectproperty id=\"Event\">\n");
          if (nen.getEvent()!=null)
           saveObject(nen.getEvent(),os);
          os.write("</objectproperty>\n");
          
          os.write("<objectproperty id=\"ApplicationMethod\">\n");
          if (nen.getApplicationMethod()!=null)
           saveObject(nen.getApplicationMethod(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.WFParticipates.class)){
          ingenias.editor.entities.WFParticipates nen=(ingenias.editor.entities.WFParticipates)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.WFDecomposesWF.class)){
          ingenias.editor.entities.WFDecomposesWF nen=(ingenias.editor.entities.WFDecomposesWF)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.UIInitiates.class)){
          ingenias.editor.entities.UIInitiates nen=(ingenias.editor.entities.UIInitiates)en;
          
          os.write("<objectproperty id=\"Condition\">\n");
          if (nen.getCondition()!=null)
           saveObject(nen.getCondition(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.ContributeNegatively.class)){
          ingenias.editor.entities.ContributeNegatively nen=(ingenias.editor.entities.ContributeNegatively)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.DefinesDeployment.class)){
          ingenias.editor.entities.DefinesDeployment nen=(ingenias.editor.entities.DefinesDeployment)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.WFUsesMethod.class)){
          ingenias.editor.entities.WFUsesMethod nen=(ingenias.editor.entities.WFUsesMethod)en;
          
          os.write("<objectproperty id=\"ApplicationMethod\">\n");
          if (nen.getApplicationMethod()!=null)
           saveObject(nen.getApplicationMethod(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.UISelection.class)){
          ingenias.editor.entities.UISelection nen=(ingenias.editor.entities.UISelection)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.EPerceivesNotification.class)){
          ingenias.editor.entities.EPerceivesNotification nen=(ingenias.editor.entities.EPerceivesNotification)en;
          
          os.write("<objectproperty id=\"Event\">\n");
          if (nen.getEvent()!=null)
           saveObject(nen.getEvent(),os);
          os.write("</objectproperty>\n");
          
          os.write("<objectproperty id=\"ApplicationMethod\">\n");
          if (nen.getApplicationMethod()!=null)
           saveObject(nen.getApplicationMethod(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.OHasWF.class)){
          ingenias.editor.entities.OHasWF nen=(ingenias.editor.entities.OHasWF)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.ParticipatesInUseCase.class)){
          ingenias.editor.entities.ParticipatesInUseCase nen=(ingenias.editor.entities.ParticipatesInUseCase)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.GTCreates.class)){
          ingenias.editor.entities.GTCreates nen=(ingenias.editor.entities.GTCreates)en;
          
          os.write("<objectproperty id=\"Condition\">\n");
          if (nen.getCondition()!=null)
           saveObject(nen.getCondition(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.WFCancels.class)){
          ingenias.editor.entities.WFCancels nen=(ingenias.editor.entities.WFCancels)en;
          
          os.write("<objectproperty id=\"Condition\">\n");
          if (nen.getCondition()!=null)
           saveObject(nen.getCondition(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.AGOInconditionalSubordinationRelationshipGroup.class)){
          ingenias.editor.entities.AGOInconditionalSubordinationRelationshipGroup nen=(ingenias.editor.entities.AGOInconditionalSubordinationRelationshipGroup)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.AUMLSendSimple.class)){
          ingenias.editor.entities.AUMLSendSimple nen=(ingenias.editor.entities.AUMLSendSimple)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.GTModifies.class)){
          ingenias.editor.entities.GTModifies nen=(ingenias.editor.entities.GTModifies)en;
          
          os.write("<objectproperty id=\"Condition\">\n");
          if (nen.getCondition()!=null)
           saveObject(nen.getCondition(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.WFProduces.class)){
          ingenias.editor.entities.WFProduces nen=(ingenias.editor.entities.WFProduces)en;
          
          os.write("<objectproperty id=\"Condition\">\n");
          if (nen.getCondition()!=null)
           saveObject(nen.getCondition(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.GTPursues.class)){
          ingenias.editor.entities.GTPursues nen=(ingenias.editor.entities.GTPursues)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.UseCasePursues.class)){
          ingenias.editor.entities.UseCasePursues nen=(ingenias.editor.entities.UseCasePursues)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.EPerceives.class)){
          ingenias.editor.entities.EPerceives nen=(ingenias.editor.entities.EPerceives)en;
          
          os.write("<objectproperty id=\"Event\">\n");
          if (nen.getEvent()!=null)
           saveObject(nen.getEvent(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.ODecomposesWF.class)){
          ingenias.editor.entities.ODecomposesWF nen=(ingenias.editor.entities.ODecomposesWF)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.WFFollows.class)){
          ingenias.editor.entities.WFFollows nen=(ingenias.editor.entities.WFFollows)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.WFDecomposes.class)){
          ingenias.editor.entities.WFDecomposes nen=(ingenias.editor.entities.WFDecomposes)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.AGOClientServerRelationshipMember.class)){
          ingenias.editor.entities.AGOClientServerRelationshipMember nen=(ingenias.editor.entities.AGOClientServerRelationshipMember)en;
          
          os.write("<objectproperty id=\"OfferedGoalService\">\n");
          if (nen.getOfferedGoalService()!=null)
           saveObject(nen.getOfferedGoalService(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.WFSpecifiesExecution.class)){
          ingenias.editor.entities.WFSpecifiesExecution nen=(ingenias.editor.entities.WFSpecifiesExecution)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.AInstanceOf.class)){
          ingenias.editor.entities.AInstanceOf nen=(ingenias.editor.entities.AInstanceOf)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.AGORelationshipGroup.class)){
          ingenias.editor.entities.AGORelationshipGroup nen=(ingenias.editor.entities.AGORelationshipGroup)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.AGORelationshipMember.class)){
          ingenias.editor.entities.AGORelationshipMember nen=(ingenias.editor.entities.AGORelationshipMember)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.AInherits.class)){
          ingenias.editor.entities.AInherits nen=(ingenias.editor.entities.AInherits)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.GTFails.class)){
          ingenias.editor.entities.GTFails nen=(ingenias.editor.entities.GTFails)en;
          
          os.write("<objectproperty id=\"FailureCondition\">\n");
          if (nen.getFailureCondition()!=null)
           saveObject(nen.getFailureCondition(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.AGOClientServerRelationshipOrg.class)){
          ingenias.editor.entities.AGOClientServerRelationshipOrg nen=(ingenias.editor.entities.AGOClientServerRelationshipOrg)en;
          
          os.write("<objectproperty id=\"OfferedGoalService\">\n");
          if (nen.getOfferedGoalService()!=null)
           saveObject(nen.getOfferedGoalService(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.AGOSubordinationRelationshipOrg.class)){
          ingenias.editor.entities.AGOSubordinationRelationshipOrg nen=(ingenias.editor.entities.AGOSubordinationRelationshipOrg)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.GTDepends.class)){
          ingenias.editor.entities.GTDepends nen=(ingenias.editor.entities.GTDepends)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.Includes.class)){
          ingenias.editor.entities.Includes nen=(ingenias.editor.entities.Includes)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.IHasSpec.class)){
          ingenias.editor.entities.IHasSpec nen=(ingenias.editor.entities.IHasSpec)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.WFPursue.class)){
          ingenias.editor.entities.WFPursue nen=(ingenias.editor.entities.WFPursue)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.EResourceBelongsTo.class)){
          ingenias.editor.entities.EResourceBelongsTo nen=(ingenias.editor.entities.EResourceBelongsTo)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.WFConsumes.class)){
          ingenias.editor.entities.WFConsumes nen=(ingenias.editor.entities.WFConsumes)en;
          
          os.write("<objectproperty id=\"Condition\">\n");
          if (nen.getCondition()!=null)
           saveObject(nen.getCondition(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.Generalizes.class)){
          ingenias.editor.entities.Generalizes nen=(ingenias.editor.entities.Generalizes)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.AHasMSProcessor.class)){
          ingenias.editor.entities.AHasMSProcessor nen=(ingenias.editor.entities.AHasMSProcessor)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.AGOSubordinationRelationshipGroup.class)){
          ingenias.editor.entities.AGOSubordinationRelationshipGroup nen=(ingenias.editor.entities.AGOSubordinationRelationshipGroup)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.GroupBelongsToOrganization.class)){
          ingenias.editor.entities.GroupBelongsToOrganization nen=(ingenias.editor.entities.GroupBelongsToOrganization)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.AContainsME.class)){
          ingenias.editor.entities.AContainsME nen=(ingenias.editor.entities.AContainsME)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.GTOrDepends.class)){
          ingenias.editor.entities.GTOrDepends nen=(ingenias.editor.entities.GTOrDepends)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.AUMLUseProtocol.class)){
          ingenias.editor.entities.AUMLUseProtocol nen=(ingenias.editor.entities.AUMLUseProtocol)en;
          
          os.write("<objectproperty id=\"Protocol\">\n");
          if (nen.getProtocol()!=null)
           saveObject(nen.getProtocol(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.GTAndDepends.class)){
          ingenias.editor.entities.GTAndDepends nen=(ingenias.editor.entities.GTAndDepends)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.ODecomposesGroup.class)){
          ingenias.editor.entities.ODecomposesGroup nen=(ingenias.editor.entities.ODecomposesGroup)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.IInitiates.class)){
          ingenias.editor.entities.IInitiates nen=(ingenias.editor.entities.IInitiates)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.Contribute.class)){
          ingenias.editor.entities.Contribute nen=(ingenias.editor.entities.Contribute)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.AGORelationshipOrg.class)){
          ingenias.editor.entities.AGORelationshipOrg nen=(ingenias.editor.entities.AGORelationshipOrg)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.Consumes.class)){
          ingenias.editor.entities.Consumes nen=(ingenias.editor.entities.Consumes)en;
          
          os.write("<objectproperty id=\"Condition\">\n");
          if (nen.getCondition()!=null)
           saveObject(nen.getCondition(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.AHasMS.class)){
          ingenias.editor.entities.AHasMS nen=(ingenias.editor.entities.AHasMS)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.UMLDescribesUseCase.class)){
          ingenias.editor.entities.UMLDescribesUseCase nen=(ingenias.editor.entities.UMLDescribesUseCase)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.IColaborates.class)){
          ingenias.editor.entities.IColaborates nen=(ingenias.editor.entities.IColaborates)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.WFFollowsGuarded.class)){
          ingenias.editor.entities.WFFollowsGuarded nen=(ingenias.editor.entities.WFFollowsGuarded)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.GTAffects.class)){
          ingenias.editor.entities.GTAffects nen=(ingenias.editor.entities.GTAffects)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.IAccesses.class)){
          ingenias.editor.entities.IAccesses nen=(ingenias.editor.entities.IAccesses)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.UIPrecedes.class)){
          ingenias.editor.entities.UIPrecedes nen=(ingenias.editor.entities.UIPrecedes)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.ARoleInheritance.class)){
          ingenias.editor.entities.ARoleInheritance nen=(ingenias.editor.entities.ARoleInheritance)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.AGOInconditionalSubordinationRelationshipMember.class)){
          ingenias.editor.entities.AGOInconditionalSubordinationRelationshipMember nen=(ingenias.editor.entities.AGOInconditionalSubordinationRelationshipMember)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.WFStarts.class)){
          ingenias.editor.entities.WFStarts nen=(ingenias.editor.entities.WFStarts)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.UMLSendsMessage.class)){
          ingenias.editor.entities.UMLSendsMessage nen=(ingenias.editor.entities.UMLSendsMessage)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.UMLAssociation.class)){
          ingenias.editor.entities.UMLAssociation nen=(ingenias.editor.entities.UMLAssociation)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.OHasGroup.class)){
          ingenias.editor.entities.OHasGroup nen=(ingenias.editor.entities.OHasGroup)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.WFResponsable.class)){
          ingenias.editor.entities.WFResponsable nen=(ingenias.editor.entities.WFResponsable)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.WFContainsTask.class)){
          ingenias.editor.entities.WFContainsTask nen=(ingenias.editor.entities.WFContainsTask)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.UMLRealizes.class)){
          ingenias.editor.entities.UMLRealizes nen=(ingenias.editor.entities.UMLRealizes)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.WFConnects.class)){
          ingenias.editor.entities.WFConnects nen=(ingenias.editor.entities.WFConnects)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.Extends.class)){
          ingenias.editor.entities.Extends nen=(ingenias.editor.entities.Extends)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.GTInherits.class)){
          ingenias.editor.entities.GTInherits nen=(ingenias.editor.entities.GTInherits)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.GTDecomposesAND.class)){
          ingenias.editor.entities.GTDecomposesAND nen=(ingenias.editor.entities.GTDecomposesAND)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.WFEnds.class)){
          ingenias.editor.entities.WFEnds nen=(ingenias.editor.entities.WFEnds)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.AUMLSelection.class)){
          ingenias.editor.entities.AUMLSelection nen=(ingenias.editor.entities.AUMLSelection)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.UMLAnnotatedElement.class)){
          ingenias.editor.entities.UMLAnnotatedElement nen=(ingenias.editor.entities.UMLAnnotatedElement)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.UIColaborates.class)){
          ingenias.editor.entities.UIColaborates nen=(ingenias.editor.entities.UIColaborates)en;
          
          os.write("<objectproperty id=\"Condition\">\n");
          if (nen.getCondition()!=null)
           saveObject(nen.getCondition(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.WFPlays.class)){
          ingenias.editor.entities.WFPlays nen=(ingenias.editor.entities.WFPlays)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.AGOClientServerRelationshipGroup.class)){
          ingenias.editor.entities.AGOClientServerRelationshipGroup nen=(ingenias.editor.entities.AGOClientServerRelationshipGroup)en;
          
          os.write("<objectproperty id=\"OfferedGoalService\">\n");
          if (nen.getOfferedGoalService()!=null)
           saveObject(nen.getOfferedGoalService(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.GTDestroys.class)){
          ingenias.editor.entities.GTDestroys nen=(ingenias.editor.entities.GTDestroys)en;
          
          os.write("<objectproperty id=\"Condition\">\n");
          if (nen.getCondition()!=null)
           saveObject(nen.getCondition(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.IPursues.class)){
          ingenias.editor.entities.IPursues nen=(ingenias.editor.entities.IPursues)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.ApplicationBelongsTo.class)){
          ingenias.editor.entities.ApplicationBelongsTo nen=(ingenias.editor.entities.ApplicationBelongsTo)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.AGOSubordinationRelationshipMember.class)){
          ingenias.editor.entities.AGOSubordinationRelationshipMember nen=(ingenias.editor.entities.AGOSubordinationRelationshipMember)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.WSConnects.class)){
          ingenias.editor.entities.WSConnects nen=(ingenias.editor.entities.WSConnects)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.GTDecomposesOR.class)){
          ingenias.editor.entities.GTDecomposesOR nen=(ingenias.editor.entities.GTDecomposesOR)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.AGOCondSubordinationRelationshipOrg.class)){
          ingenias.editor.entities.AGOCondSubordinationRelationshipOrg nen=(ingenias.editor.entities.AGOCondSubordinationRelationshipOrg)en;
          
          os.write("<objectproperty id=\"Condition\">\n");
          if (nen.getCondition()!=null)
           saveObject(nen.getCondition(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.GTSatisfies.class)){
          ingenias.editor.entities.GTSatisfies nen=(ingenias.editor.entities.GTSatisfies)en;
          
          os.write("<objectproperty id=\"SatisfactionCondition\">\n");
          if (nen.getSatisfactionCondition()!=null)
           saveObject(nen.getSatisfactionCondition(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.AGOCondSubordinationRelationshipMember.class)){
          ingenias.editor.entities.AGOCondSubordinationRelationshipMember nen=(ingenias.editor.entities.AGOCondSubordinationRelationshipMember)en;
          
          os.write("<objectproperty id=\"Condition\">\n");
          if (nen.getCondition()!=null)
           saveObject(nen.getCondition(),os);
          os.write("</objectproperty>\n");
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.WFUses.class)){
          ingenias.editor.entities.WFUses nen=(ingenias.editor.entities.WFUses)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.WFDecides.class)){
          ingenias.editor.entities.WFDecides nen=(ingenias.editor.entities.WFDecides)en;
          
          
        }
        
         if (en.getClass().equals(ingenias.editor.entities.ContributePositively.class)){
          ingenias.editor.entities.ContributePositively nen=(ingenias.editor.entities.ContributePositively)en;
          
          
        }
        



    Hashtable ht = new Hashtable();
    en.toMap(ht);
    saveMap(ht, os);
    os.write( "</object>\n");
  }



 

}
