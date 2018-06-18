
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

public class INGENIASUseCase extends UseCase {




  public TypedVector Postcondition=new TypedVector(ingenias.editor.entities.AgentModelModelEntity.class);

  public TypedVector Scenarios=new TypedVector(ingenias.editor.entities.InteractionModelModelEntity.class);

  public TypedVector Precondition=new TypedVector(ingenias.editor.entities.AgentModelModelEntity.class);



  public INGENIASUseCase(String id) {
    super(id);
    this.setHelpDesc("<br>This use case is configured with information about preconditions and postconditions, as well as information of the different interactions that may appear<br>");
    this.setHelpRecom("");
  }




  public void setPostcondition(TypedVector tv){
    this.Postcondition=tv;
  }

  public String getPostcondition(){
   return Postcondition.toString();
  }

  public Class getPostconditionType(){
   return Postcondition.getType();
  }
  public void addPostcondition(AgentModelModelEntity element){
   this.Postcondition.add(element);
  }

  public void insertPostconditionAt(int pos,AgentModelModelEntity element){
   this.Postcondition.insert(element,pos);
  }

  public int containsPostcondition(AgentModelModelEntity element){
   return this.Postcondition.indexOf(element);
  }


  public Enumeration getPostconditionElements(){
   return this.Postcondition.elements();
  }

  public void removePostconditionElement(String id){
    Enumeration enumeration=this.getPostconditionElements();
    ingenias.editor.entities.Entity found=null;
    while (enumeration.hasMoreElements() && found==null){
     ingenias.editor.entities.Entity ent=(ingenias.editor.entities.Entity)enumeration.nextElement();
     if (ent.getId().equalsIgnoreCase(id))
      found=ent;
    }
    if (found!=null)
     this.Postcondition.remove(found);
  }


  public void setScenarios(TypedVector tv){
    this.Scenarios=tv;
  }

  public String getScenarios(){
   return Scenarios.toString();
  }

  public Class getScenariosType(){
   return Scenarios.getType();
  }
  public void addScenarios(InteractionModelModelEntity element){
   this.Scenarios.add(element);
  }

  public void insertScenariosAt(int pos,InteractionModelModelEntity element){
   this.Scenarios.insert(element,pos);
  }

  public int containsScenarios(InteractionModelModelEntity element){
   return this.Scenarios.indexOf(element);
  }


  public Enumeration getScenariosElements(){
   return this.Scenarios.elements();
  }

  public void removeScenariosElement(String id){
    Enumeration enumeration=this.getScenariosElements();
    ingenias.editor.entities.Entity found=null;
    while (enumeration.hasMoreElements() && found==null){
     ingenias.editor.entities.Entity ent=(ingenias.editor.entities.Entity)enumeration.nextElement();
     if (ent.getId().equalsIgnoreCase(id))
      found=ent;
    }
    if (found!=null)
     this.Scenarios.remove(found);
  }


  public void setPrecondition(TypedVector tv){
    this.Precondition=tv;
  }

  public String getPrecondition(){
   return Precondition.toString();
  }

  public Class getPreconditionType(){
   return Precondition.getType();
  }
  public void addPrecondition(AgentModelModelEntity element){
   this.Precondition.add(element);
  }

  public void insertPreconditionAt(int pos,AgentModelModelEntity element){
   this.Precondition.insert(element,pos);
  }

  public int containsPrecondition(AgentModelModelEntity element){
   return this.Precondition.indexOf(element);
  }


  public Enumeration getPreconditionElements(){
   return this.Precondition.elements();
  }

  public void removePreconditionElement(String id){
    Enumeration enumeration=this.getPreconditionElements();
    ingenias.editor.entities.Entity found=null;
    while (enumeration.hasMoreElements() && found==null){
     ingenias.editor.entities.Entity ent=(ingenias.editor.entities.Entity)enumeration.nextElement();
     if (ent.getId().equalsIgnoreCase(id))
      found=ent;
    }
    if (found!=null)
     this.Precondition.remove(found);
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
