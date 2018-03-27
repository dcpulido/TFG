
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

public class GRASIAMentalStatePattern extends SymbolicMentalStatePattern {


  public ingenias.editor.entities.AgentModelModelEntity DescriptionWithAgentModel;





  public GRASIAMentalStatePattern(String id) {
    super(id);
    this.setHelpDesc("<br>Describes an agent mental state using agent models. In these models you are expected to have only an instance of AutonomousEntityQuery associated with a mental state, and this mental state with required mental entities. Another alternative is to have a conditional mental state entity that allows to express conditions over identified mental entities<br>");
    this.setHelpRecom("");
  }


      public AgentModelModelEntity getDescriptionWithAgentModel(){
        return DescriptionWithAgentModel;
      }
       public void setDescriptionWithAgentModel(AgentModelModelEntity
					DescriptionWithAgentModel){
        this.DescriptionWithAgentModel=DescriptionWithAgentModel;
      }





public void fromMap(Map ht){
super.fromMap(ht);



}
public void toMap(Map ht){
super.toMap(ht);

}

public String toString(){
if (this.getId()==null ||
    this.getId().toString().equals(""))
 return "Please, define the value of field Id";
else
 return this.getId().toString();
}

}
