
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

public class MethodParameter extends INGENIASObject {


  public java.lang.String Name;

  public java.lang.String Type;





  public MethodParameter(String id) {
    super(id);
    this.setHelpDesc("<br>A method parameter<br>");
    this.setHelpRecom("");
  }


      public java.lang.String getName(){
        return Name;
      }
       public void setName(java.lang.String
					Name){
        this.Name=Name;
      }


      public java.lang.String getType(){
        return Type;
      }
       public void setType(java.lang.String
					Type){
        this.Type=Type;
      }





public void fromMap(Map ht){
super.fromMap(ht);

if (ht.get("Name") instanceof String)
 this.setName(ht.get("Name").toString());

if (ht.get("Type") instanceof String)
 this.setType(ht.get("Type").toString());



}
public void toMap(Map ht){
super.toMap(ht);

if (this.getName() instanceof String)
 ht.put("Name",this.getName().toString());

if (this.getType() instanceof String)
 ht.put("Type",this.getType().toString());

}

public String toString(){
if (this.getName()==null ||
    this.getName().toString().equals(""))
 return "Please, define the value of field Name";
else
 return this.getName().toString();
}

}