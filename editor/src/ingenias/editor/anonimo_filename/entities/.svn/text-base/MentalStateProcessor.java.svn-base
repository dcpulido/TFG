
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

public class MentalStateProcessor extends AgentComponent {




  public TypedVector ProcessorDescription=new TypedVector(ingenias.editor.entities.TasksAndGoalsModelModelEntity.class);



  public MentalStateProcessor(String id) {
    super(id);
    this.setHelpDesc("<br>The agent takes decisions basing upon its mental state. There is an entity that supports<br>management of the mental state of the agent (MentalStateManager) and this entity that<br>represents the decision capabilities of the agent. As the MentalStateManager you can<br>describe the MentalStateProcessor using tasks and goals diagrams<br>");
    this.setHelpRecom("");
  }




  public void setProcessorDescription(TypedVector tv){
    this.ProcessorDescription=tv;
  }

  public String getProcessorDescription(){
   return ProcessorDescription.toString();
  }

  public Class getProcessorDescriptionType(){
   return ProcessorDescription.getType();
  }
  public void addProcessorDescription(TasksAndGoalsModelModelEntity element){
   this.ProcessorDescription.add(element);
  }

  public void insertProcessorDescriptionAt(int pos,TasksAndGoalsModelModelEntity element){
   this.ProcessorDescription.insert(element,pos);
  }

  public int containsProcessorDescription(TasksAndGoalsModelModelEntity element){
   return this.ProcessorDescription.indexOf(element);
  }


  public Enumeration getProcessorDescriptionElements(){
   return this.ProcessorDescription.elements();
  }

  public void removeProcessorDescriptionElement(String id){
    Enumeration enumeration=this.getProcessorDescriptionElements();
    ingenias.editor.entities.Entity found=null;
    while (enumeration.hasMoreElements() && found==null){
     ingenias.editor.entities.Entity ent=(ingenias.editor.entities.Entity)enumeration.nextElement();
     if (ent.getId().equalsIgnoreCase(id))
      found=ent;
    }
    if (found!=null)
     this.ProcessorDescription.remove(found);
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
