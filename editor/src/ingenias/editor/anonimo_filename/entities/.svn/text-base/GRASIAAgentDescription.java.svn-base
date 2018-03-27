
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

public class GRASIAAgentDescription extends AgentDescription {


  public ingenias.editor.entities.AgentModelModelEntity DescriptionWithAgentModel;





  public GRASIAAgentDescription(String id) {
    super(id);
    this.setHelpDesc("<br>Contains a reference to an agent model. With this model you describe conditions of goal<br>satisfaction or failure, and interaction collaboration. Usually, this is achieved<br>associating mental states to an instance of ConcreteAgent or<br>AutonomousEntityQuery. This instance should be understood as the<br>executor of the task or the performer or colaborator in an interaction unit. You also<br>can use common associations in these diagrams to represent abilities required or other<br>qualities.<br>");
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
