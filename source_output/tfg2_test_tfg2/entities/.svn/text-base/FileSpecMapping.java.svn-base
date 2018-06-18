
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

public class FileSpecMapping extends UMLClassifier {


  public ingenias.editor.entities.INGENIASObject Entity;

  public java.lang.String File;





  public FileSpecMapping(String id) {
    super(id);
    this.setHelpDesc("<br>It is a common slot used only in Frame Fact entity. Each slot could be interpreted in the implementation as an<br>attribute in an object or as a CLIPS slot in a CLIPS fact.<br>");
    this.setHelpRecom("");
  }


      public ingenias.editor.entities.INGENIASObject getEntity(){
        return Entity;
      }
       public void setEntity(ingenias.editor.entities.INGENIASObject
					Entity){
        this.Entity=Entity;
      }


      public java.lang.String getFile(){
        return File;
      }
       public void setFile(java.lang.String
					File){
        this.File=File;
      }





public void fromMap(Map ht){
super.fromMap(ht);

if (ht.get("File") instanceof String)
 this.setFile(ht.get("File").toString());



}
public void toMap(Map ht){
super.toMap(ht);

if (this.getFile() instanceof String)
 ht.put("File",this.getFile().toString());

}

public String toString(){
if (this.getEntity()==null ||
    this.getEntity().toString().equals(""))
 return "Please, define the value of field Entity";
else
 return this.getEntity().toString();
}

}
