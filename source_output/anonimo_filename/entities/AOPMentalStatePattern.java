
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

public class AOPMentalStatePattern extends SymbolicMentalStatePattern {


  public java.lang.String AOPExpression;





  public AOPMentalStatePattern(String id) {
    super(id);
    this.setHelpDesc("<br>The mental state of the agent is expressed the Agent0 language. This language in described in the Agent Oriented Programming paper from Shoham. No syntax is verified.<br>");
    this.setHelpRecom("");
  }


      public java.lang.String getAOPExpression(){
        return AOPExpression;
      }
       public void setAOPExpression(java.lang.String
					AOPExpression){
        this.AOPExpression=AOPExpression;
      }





public void fromMap(Map ht){
super.fromMap(ht);

if (ht.get("AOPExpression") instanceof String)
 this.setAOPExpression(ht.get("AOPExpression").toString());



}
public void toMap(Map ht){
super.toMap(ht);

if (this.getAOPExpression() instanceof String)
 ht.put("AOPExpression",this.getAOPExpression().toString());

}

public String toString(){
if (this.getId()==null ||
    this.getId().toString().equals(""))
 return "Please, define the value of field Id";
else
 return this.getId().toString();
}

}
