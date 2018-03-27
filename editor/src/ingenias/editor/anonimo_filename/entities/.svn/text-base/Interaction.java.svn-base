
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

public class Interaction extends InteractionUnit {


  public java.lang.String Nature;





  public Interaction(String id) {
    super(id);
    this.setHelpDesc("<br>Represents an interaction between two or more agents or roles. There can be only one<br>initiator and at least one collaborator. An interaction also details the goal that<br>pursues. This goal should be related with the goals of the participants.<br>");
    this.setHelpRecom("");
  }


      public java.lang.String getNature(){
        return Nature;
      }
       public void setNature(java.lang.String
					Nature){
        this.Nature=Nature;
      }





public void fromMap(Map ht){
super.fromMap(ht);

if (ht.get("Nature") instanceof String)
 this.setNature(ht.get("Nature").toString());



}
public void toMap(Map ht){
super.toMap(ht);

if (this.getNature() instanceof String)
 ht.put("Nature",this.getNature().toString());

}

public String toString(){
if (this.getId()==null ||
    this.getId().toString().equals(""))
 return "Please, define the value of field Id";
else
 return this.getId().toString();
}

}
