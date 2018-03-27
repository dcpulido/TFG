
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

public class RuntimeEvent extends GeneralEvent {




  public TypedVector Stack=new TypedVector(ingenias.editor.entities.StackEntry.class);



  public RuntimeEvent(String id) {
    super(id);
    this.setHelpDesc("<br>				It is a runtime instance of an GeneralEvent<br>			");
    this.setHelpRecom("");
  }




  public void setStack(TypedVector tv){
    this.Stack=tv;
  }

  public String getStack(){
   return Stack.toString();
  }

  public Class getStackType(){
   return Stack.getType();
  }
  public void addStack(ingenias.editor.entities.StackEntry element){
   this.Stack.add(element);
  }

  public void insertStackAt(int pos,ingenias.editor.entities.StackEntry element){
   this.Stack.insert(element,pos);
  }

  public int containsStack(ingenias.editor.entities.StackEntry element){
   return this.Stack.indexOf(element);
  }


  public Enumeration getStackElements(){
   return this.Stack.elements();
  }

  public void removeStackElement(String id){
    Enumeration enumeration=this.getStackElements();
    ingenias.editor.entities.Entity found=null;
    while (enumeration.hasMoreElements() && found==null){
     ingenias.editor.entities.Entity ent=(ingenias.editor.entities.Entity)enumeration.nextElement();
     if (ent.getId().equalsIgnoreCase(id))
      found=ent;
    }
    if (found!=null)
     this.Stack.remove(found);
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
