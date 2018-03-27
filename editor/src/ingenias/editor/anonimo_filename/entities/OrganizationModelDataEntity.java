
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
package ingenias.editor.entities;


import java.util.*;

public class OrganizationModelDataEntity extends ModelDataEntity {
		
	public java.lang.String Description;
	
	public OrganizationModelDataEntity(String id) {
		super(id);
		this.setHelpDesc("The Organization Model defines the structure where agents, resources, tasks and goals relate. This structure includes among other elements: organizations, groups, and workflows. </br> Nevertheless the use of this model differs accordingly to the related process. <ul><li> On a classic UPD approach during the Inception phase it is used to start the definition of the system architecture, reflecting mainly the system structure and workflows. </br> On the Elaboration phase it is improved with two dimensions of decomposition: <ul> <li> A structural definition of the system provided through the identification of its groups and their members. </li> <li> A functional definition established through the identification of workflows and their relationships.</li> </ul> During the Construction phase it is refined with social relationships that influence, among others, visibility and access in code. </li> <li> Following a SCRUM approach, it is not strictly necessary to use it, but it may help to have a global vision of the final solution in what refers to: agents and roles that participate, and responsibilities in the satisfaction of the main goals. Moreover, it may be used to reflect many of the product items proposed in the original Scrum framework. </br> During the Preparation phase, it could be used to provide the responsibilities of the groups, the agents and the roles involved in the satisfaction of the identified goals. </br> On the Sprint phases, during the daily works, it could be refined with social relationships. </li> </ul>");
		this.setHelpRecom("<p>It is recommended the use of the following template, in the Scrum approach, to annotate anyuseful information from the Product Owner, Stakeholders and the Scrum Team. This information usually describes a Product Backlog Item (PBI) </p> <p>Nevertheless this template must be used on the Description of the goal entities, but a better use of it, will include their inclusion on this model at the early stages.</p> <p> <b>TEMPLATE of a PBI</b> <h3>A enumeration of User Stories: </h3> <ol> <li> <dl> <dt> <b>Title of the first</b> </dt><dd><p>Description of the User Story. Here include the text describing it. </dd> <dd> Bugs detected on later stages must be described in the same way as a new user story.</dd> <dd> This text could be also use to annotate technical work associated with the User Story and/or Knowledge adquisition necessary to improve the user story</dd> <dt> <b>Estimated value (0-9):</b> N </dt> <dt> <b>Estimated development cost (in months): </b>X months </dt> <dt> <b>Theme:</b> Chair functionallites </dt> <dt> <b>Type:</b> System goal </dt> <dt> <b>Test acceptance criterias:</b> In order to accept the functionality developped to satisfy this goal the system must: <ol> <li> Manage, got, do, ... </li> <li> Got, recover, manage, do, ... </li> <li> ... </li> </ol> </dt> <dt> <b>State:</b> Estimated </dt></dl></li> <li> <dl> <dt> <b> ... Another User Story ... </b> </dt> </dl></li> <li> ... </li> </ol></p>");
		
	}
	
	public java.lang.String getDescription(){
        return Description;
	}
	
	public void setDescription(java.lang.String Description){
        this.Description = Description;
	}
	
	public void fromMap(Map ht){
		super.fromMap(ht);
		
		if (ht.get("Description") instanceof String)
			this.setDescription(ht.get("Description").toString());
		
	}

	public void toMap(Map ht){
		super.toMap(ht);
		
		if (this.getDescription() instanceof String)
			ht.put("Description", this.getDescription().toString());
		
	}
	
}
