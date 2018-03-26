
/*
    Copyright (C) 2002 Jorge Gomez Sanz, Ruben Fuentes

    Modifications of original jgraph distribution code (jgraph.sourceforge.ent)

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

package ingenias.editor.cell;

import java.util.Hashtable;
import java.util.Iterator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.jgraph.graph.*;

import ingenias.editor.entities.*;

public class GTCreatesEdge extends NAryEdge {

  // Constructor with data content
  public GTCreatesEdge(GTCreates userObject) {
    super(userObject);
    
     this.addRole("GTCreatessource");
     this.setArity("GTCreatessource",true,1);
     this.setArity("GTCreatessource",false,1);
     
this.addClass("GTCreatessource","ingenias.editor.entities.Task");
     
    
     this.addRole("GTCreatestarget");
     this.setArity("GTCreatestarget",true,1);
     this.setArity("GTCreatestarget",false,2147483647);
     
this.addClass("GTCreatestarget","ingenias.editor.entities.MentalEntity");
     
    
    // Add ports for every role.
    // Roles are obtained from the static roleData.
    Iterator it = this.getRoles().iterator();
    while ( it.hasNext() ) {
      this.add( new DefaultPort( (String) it.next() ) );
    }
  }


  // Connection logic.
  // The connection is acceptable if there is a role assignation to selected classes
  // considering, if they exists, classes already included in the relationship.
  // It works with connecting and disconnecting edges. Therefore, both target
  // and source cells could be null.
  // source is the first selected node and targets are the other.
  // Both source and targets are Vertex.
  // Connects an Agent with a Goal or an Agent with a Goal and a Fact.
   public static boolean acceptConnection(GraphModel model, GraphCell[] selected) {
    // Search for NAryEdges in selected. There is 0 or 1.
    int nAryEdgesNum = 0;
    int edgesNum = 0;
    NAryEdge selectedEdge = null;
    for (int i = 0; i < selected.length; i++)
      if (selected[i] instanceof NAryEdge) {
        nAryEdgesNum++;
        selectedEdge = (NAryEdge) selected[i];
      } else if (selected[i] instanceof DefaultEdge)
        edgesNum++;

    // Some obvious error situations.
    if (nAryEdgesNum > 1 || edgesNum > 0 ||
      !((selectedEdge == null) || (selectedEdge instanceof GTCreatesEdge)))
      return false;

    // n-edge to be considered.
    GTCreatesEdge edge = new GTCreatesEdge( null);
    // If the connection involves an existing n-edge its assignations has to be considered.
    if (nAryEdgesNum == 1 && selectedEdge instanceof GTCreatesEdge)
      edge = (GTCreatesEdge) selectedEdge;
    GraphCell[] newSelected = edge.prepareSelected(selected);
    return (edge.assignRoles(newSelected, false).size() > 0);

  }


// Connection logic.
  // The deletion is acceptable if the resulting relationship is valid.
  // selected are the nodes to removed.
  public boolean acceptRemove(GraphCell[] selected) {
    // All roles considered in the relationship.
    List roles = this.getOrderedRoles();
    // Valid deletion.
    boolean ok = true;
    // Check all roles.
    for (int i = 0; i < roles.size(); i++) {
      String roleName = (String) roles.get(i);
      Integer minAllowedTimes = this.getArity(roleName, true);
      Integer maxAllowedTimes = this.getArity(roleName, false);
      // Objects playing roleName in this relationship.
      GraphCell[] roleObjects = this.getObjects(roleName);
      // newUse is roleObjects number minus those objects in selected (which will be removed).
      int currentUse = roleObjects.length;
      for (int j = 0; j < roleObjects.length; j++)
        for (int k = 0; k < selected.length; k++) {
          // Object to be compared with roleObjects.
          Object object = null;
          // Default Edge.
          if (selected[k] instanceof DefaultEdge) {
	  DefaultPort targetPort = (DefaultPort) ( (DefaultEdge) selected[k] ).getTarget();
	  object = targetPort.getParent();
          // Vertex
          } else if ( (selected[k] instanceof DefaultGraphCell) &&
             !(selected[k] instanceof DefaultPort) ) {
            object = selected[k];
          }
          // If the object is in the deleted list, there is one less object playing the role.
          if ( roleObjects[j].equals(object) )
            currentUse--;
        }
      // Check the role for the deletion.
      ok = ok && (minAllowedTimes.intValue() <= currentUse) &&
        (currentUse <= maxAllowedTimes.intValue());
    }
    return ok;
  }



// Is a list of possible assignations (List) where each assignation
  // is a list (List) of roles (String).
  public List assignRoles(GraphCell[] selectedNodes, boolean allSolutions) {
    // Container for all possible solutions.
    Vector results = new Vector();
    // A specific solution, that is, assignation roles-entities.
    // It has the name of the roles assigned to objects in selectedNodes, that is,
    // the role of selectedNodes[i] in this solution is solution.get(i).
    Vector solution = new Vector();
    // All roles considered in the relationship.
    List roles = this.getOrderedRoles();

    // The goal is to give classes an assignation to roles that makes a solution.
    // Iterate over nodes to assign.
    int nodesIndex = 0;
    String nodeClass = selectedNodes[nodesIndex].getClass().getName();
    Class nodeClassc = ( (DefaultGraphCell) selectedNodes[nodesIndex] ).getUserObject().getClass();
    // Initial capacity for first node.
    solution.add(nodesIndex, null);
    // First role.
    int rolesIndex = this.nextRole(roles, solution, nodesIndex).intValue();
    while ((0 <= nodesIndex) && (allSolutions || results.size() == 0)) {
      boolean roleOK = false;
      String roleName = null;//////////
      while (rolesIndex < roles.size() && !roleOK) {
        // The assignation role-class is checked.
        // The role can be assigned if the current arity is less than
        // the maximun allowed and the object class can play the role.
        roleName = (String) roles.get(rolesIndex);
        if (this.checkAssignation((List) solution, roleName, nodeClassc))
          roleOK = true;
        else
          rolesIndex++;
      }

      // If a role assignation was founded for current node.
      if (roleOK && roleName != null) {
        // The position for the role of nodesIndex is already created. Update the role.
        solution.set(nodesIndex, roleName);
        // Check if there is a solution and add.
        if (checkSolution(selectedNodes, (List) solution)) {
          Vector solutionToAdd = new Vector();
          for (int i = 0; i < solution.size(); i++)
            solutionToAdd.add((String) solution.get(i));
          results.add(solutionToAdd);
        }
        // There are nodes to be assigned.
        if (solution.size() < selectedNodes.length) {
          nodesIndex++;
          solution.add(nodesIndex, null);
        }
      } else {
        // For the current node, possible role assignations has been exhausted.
        // Backtracking is done.
        solution.remove(nodesIndex);
        nodesIndex--;
      }

      // If it is not the end.
      if (nodesIndex >= 0) {
        // Class information for node.
        nodeClass = selectedNodes[nodesIndex].getClass().getName();
        nodeClassc = ( (DefaultGraphCell) selectedNodes[nodesIndex] ).getUserObject().getClass();
        // Assign a new role to the node.
        rolesIndex = this.nextRole(roles, solution, nodesIndex).intValue();
      }
    }
    return results;
  }



  // Returns a DefaultEdge[] related with this n-edge.
  // In selected there can be 0 or 1 n-edge. If there is one is the object itself.
  public DefaultEdge[] connectionsEdges(GraphCell[] selected, String[] roles) {
    // Temporal container for edges that will be inserted into the Model.
    Vector edges = new Vector();
    // Create connections between related objects using this n-edge.
    for (int i = 0; i < selected.length; i++)
      if ( ! (selected[i] instanceof DefaultEdge ||
              selected[i] instanceof NAryEdge ||
              selected[i] instanceof DefaultPort) ){
      
	if (roles[i].equalsIgnoreCase("GTCreatessource")){
 	 edges.add( new DefaultEdge( new GTCreatessourceRole() ) );
	 }
      
	if (roles[i].equalsIgnoreCase("GTCreatestarget")){
 	 edges.add( new DefaultEdge( new GTCreatestargetRole() ) );
	 }
      

      }

    DefaultEdge[] edgesSet = new DefaultEdge[edges.size()];
    for (int i = 0; i < edges.size(); i++)
      edgesSet[i] = (DefaultEdge) edges.get(i);
    return edgesSet;
  }



  // Gives the index of the next role to be assigned to currentNode according to currentSolution.
  private Integer nextRole(List relationshipRoles, List currentSolution, int currentNode) {
    int rolesIndex;
int kk = currentSolution.size();//////////
    if (currentSolution.get(currentNode) == null)  ////////// solution.get(nodeClass) == null)
        rolesIndex = 0;
    // If it was in the solution, try the following role.
    else {
      rolesIndex = 0;
      String previousRole = (String) currentSolution.get(currentNode);
      for (int i = 0; i < relationshipRoles.size(); i++)
        if (previousRole.equals(relationshipRoles.get(i)))
          rolesIndex = i;
      rolesIndex++;
    }

    return (new Integer(rolesIndex));
  }

}
			