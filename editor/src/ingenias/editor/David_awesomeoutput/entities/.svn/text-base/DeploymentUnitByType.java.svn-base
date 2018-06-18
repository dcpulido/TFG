
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

package ingenias.editor.entities;

import java.util.*;
import ingenias.editor.TypedVector;

public class DeploymentUnitByType extends INGENIASObject {


  public java.lang.String NumberInstances;

  public ingenias.editor.entities.Agent AgentTypeDeployed;





  public DeploymentUnitByType(String id) {
    super(id);
    this.setHelpDesc("<br>A deploy unit is an entity that defines how many instances of agents will exist in the final system<br>");
    this.setHelpRecom("");
  }


      public java.lang.String getNumberInstances(){
        return NumberInstances;
      }
       public void setNumberInstances(java.lang.String
					NumberInstances){
        this.NumberInstances=NumberInstances;
      }


      public ingenias.editor.entities.Agent getAgentTypeDeployed(){
        return AgentTypeDeployed;
      }
       public void setAgentTypeDeployed(ingenias.editor.entities.Agent
					AgentTypeDeployed){
        this.AgentTypeDeployed=AgentTypeDeployed;
      }





public void fromMap(Map ht){
super.fromMap(ht);

if (ht.get("NumberInstances") instanceof String)
 this.setNumberInstances(ht.get("NumberInstances").toString());



}
public void toMap(Map ht){
super.toMap(ht);

if (this.getNumberInstances() instanceof String)
 ht.put("NumberInstances",this.getNumberInstances().toString());

}

public String toString(){
if (this.getId()==null ||
    this.getId().toString().equals(""))
 return "Please, define the value of field Id";
else
 return this.getId().toString();
}

}
