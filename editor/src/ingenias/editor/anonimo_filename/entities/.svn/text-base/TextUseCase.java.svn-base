
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

public class TextUseCase extends UseCase {


  public java.lang.String Postcondition;

  public java.lang.String Precondition;





  public TextUseCase(String id) {
    super(id);
    this.setHelpDesc("<br>A text use case is an UML use case whose description is supplied as natural language text<br>");
    this.setHelpRecom("");
  }


      public java.lang.String getPostcondition(){
        return Postcondition;
      }
       public void setPostcondition(java.lang.String
					Postcondition){
        this.Postcondition=Postcondition;
      }


      public java.lang.String getPrecondition(){
        return Precondition;
      }
       public void setPrecondition(java.lang.String
					Precondition){
        this.Precondition=Precondition;
      }





public void fromMap(Map ht){
super.fromMap(ht);

if (ht.get("Postcondition") instanceof String)
 this.setPostcondition(ht.get("Postcondition").toString());

if (ht.get("Precondition") instanceof String)
 this.setPrecondition(ht.get("Precondition").toString());



}
public void toMap(Map ht){
super.toMap(ht);

if (this.getPostcondition() instanceof String)
 ht.put("Postcondition",this.getPostcondition().toString());

if (this.getPrecondition() instanceof String)
 ht.put("Precondition",this.getPrecondition().toString());

}

public String toString(){
if (this.getId()==null ||
    this.getId().toString().equals(""))
 return "Please, define the value of field Id";
else
 return this.getId().toString();
}

}
