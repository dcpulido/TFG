
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

public class ObjectSlot extends Slot {


  public java.lang.Object ObjectValue;





  public ObjectSlot(String id) {
    super(id);
    this.setHelpDesc("<br>				It is a common slot used only in Frame Fact entity. Each slot could be interpreted in the implementation as an<br>				attribute in an object or as a CLIPS slot in a CLIPS fact.<br>			");
    this.setHelpRecom("");
  }


      public java.lang.Object getObjectValue(){
        return ObjectValue;
      }
       public void setObjectValue(java.lang.Object
					ObjectValue){
        this.ObjectValue=ObjectValue;
      }





public void fromMap(Map ht){
super.fromMap(ht);



}
public void toMap(Map ht){
super.toMap(ht);

}

public String toString(){
if (this.getName()==null ||
    this.getName().toString().equals(""))
 return "Please, define the value of field Name";
else
 return this.getName().toString();
}

}
