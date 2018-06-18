
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

public class StateGoal extends Goal {


  public java.lang.String State;

  public ingenias.editor.entities.Goal LinkedGoal;





  public StateGoal(String id) {
    super(id);
    this.setHelpDesc("<br>This specialization of Goal is associated with a state that represents the lifecycle<br>of a goal according to INGENIAS. <br>- Satisfied: means that this goal has been achieved<br>- Failed: means that this goal could not be achieved<br>- Pending: the goal has been activated and is waiting for possible refinements<br>- Refined: the goal has been refined into different subgoals. SubGoals are determined with <br>- Solving: there is a task that can satisfy this goal and it has been executed<br>Field Goal refers to the goal that is being described.<br>");
    this.setHelpRecom("");
  }


      public java.lang.String getState(){
        return State;
      }
       public void setState(java.lang.String
					State){
        this.State=State;
      }


      public ingenias.editor.entities.Goal getLinkedGoal(){
        return LinkedGoal;
      }
       public void setLinkedGoal(ingenias.editor.entities.Goal
					LinkedGoal){
        this.LinkedGoal=LinkedGoal;
      }





public void fromMap(Map ht){
super.fromMap(ht);

if (ht.get("State") instanceof String)
 this.setState(ht.get("State").toString());



}
public void toMap(Map ht){
super.toMap(ht);

if (this.getState() instanceof String)
 ht.put("State",this.getState().toString());

}

public String toString(){
if (this.getId()==null ||
    this.getId().toString().equals(""))
 return "Please, define the value of field Id";
else
 return this.getId().toString();
}

}
