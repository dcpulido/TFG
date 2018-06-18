
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

public class ConditionalMentalState extends MentalState {


  public java.lang.String Condition;





  public ConditionalMentalState(String id) {
    super(id);
    this.setHelpDesc("<br>A mental state that adds extra information about what conditions must satisfy the<br>entities aggregated in a mental state. Entities in a mental state can be labeled. These<br>labels are used inside the mental state condition.<br>");
    this.setHelpRecom("");
  }


      public java.lang.String getCondition(){
        return Condition;
      }
       public void setCondition(java.lang.String
					Condition){
        this.Condition=Condition;
      }





public void fromMap(Map ht){
super.fromMap(ht);

if (ht.get("Condition") instanceof String)
 this.setCondition(ht.get("Condition").toString());



}
public void toMap(Map ht){
super.toMap(ht);

if (this.getCondition() instanceof String)
 ht.put("Condition",this.getCondition().toString());

}

public String toString(){
if (this.getId()==null ||
    this.getId().toString().equals(""))
 return "Please, define the value of field Id";
else
 return this.getId().toString();
}

}