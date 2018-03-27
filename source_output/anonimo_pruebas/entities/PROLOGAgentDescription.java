
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

public class PROLOGAgentDescription extends AgentDescription {


  public java.lang.String PROLOGDescription;





  public PROLOGAgentDescription(String id) {
    super(id);
    this.setHelpDesc("<br>Provides an prolog based description of an agent. There is no syntax check here. This means that we assume that you write down prolog code. This kind of descriptions is used to represent conditions of goal satisfaction or failure, and interaction collaboration.<br>");
    this.setHelpRecom("");
  }


      public java.lang.String getPROLOGDescription(){
        return PROLOGDescription;
      }
       public void setPROLOGDescription(java.lang.String
					PROLOGDescription){
        this.PROLOGDescription=PROLOGDescription;
      }





public void fromMap(Map ht){
super.fromMap(ht);

if (ht.get("PROLOGDescription") instanceof String)
 this.setPROLOGDescription(ht.get("PROLOGDescription").toString());



}
public void toMap(Map ht){
super.toMap(ht);

if (this.getPROLOGDescription() instanceof String)
 ht.put("PROLOGDescription",this.getPROLOGDescription().toString());

}

public String toString(){
if (this.getId()==null ||
    this.getId().toString().equals(""))
 return "Please, define the value of field Id";
else
 return this.getId().toString();
}

}
