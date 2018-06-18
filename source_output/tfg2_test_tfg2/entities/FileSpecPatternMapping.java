
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

public class FileSpecPatternMapping extends FileSpecMapping {


  public java.lang.String Pattern;





  public FileSpecPatternMapping(String id) {
    super(id);
    this.setHelpDesc("<br>It adds to FileSpecMapping the possibility of declaring a singleton pattern, meaning that the associated file appears as a singleton.<br>");
    this.setHelpRecom("");
  }


      public java.lang.String getPattern(){
        return Pattern;
      }
       public void setPattern(java.lang.String
					Pattern){
        this.Pattern=Pattern;
      }





public void fromMap(Map ht){
super.fromMap(ht);

if (ht.get("Pattern") instanceof String)
 this.setPattern(ht.get("Pattern").toString());



}
public void toMap(Map ht){
super.toMap(ht);

if (this.getPattern() instanceof String)
 ht.put("Pattern",this.getPattern().toString());

}

public String toString(){
if (this.getEntity()==null ||
    this.getEntity().toString().equals(""))
 return "Please, define the value of field Entity";
else
 return this.getEntity().toString();
}

}
