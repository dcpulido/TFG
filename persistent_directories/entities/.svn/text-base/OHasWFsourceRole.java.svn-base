

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

public class OHasWFsourceRole extends RoleEntity {


  public java.lang.String Cardinality;


 static int idCounter=0;

 public OHasWFsourceRole() {
	    super("OHasWFsourceRole"+idCounter);
	    idCounter++;

	  }



  public OHasWFsourceRole(String id) {
    super(id);

  }



      public java.lang.String getCardinality(){
        return Cardinality;
      }
       public void setCardinality(java.lang.String
					Cardinality){
        this.Cardinality=Cardinality;
      }





public void fromMap(Map ht){
super.fromMap(ht);

if (ht.get("Cardinality") instanceof String)
 this.setCardinality(ht.get("Cardinality").toString());



}
public void toMap(Map ht){
super.toMap(ht);

if (this.getCardinality() instanceof String)
 ht.put("Cardinality",encodeutf8Text(this.getCardinality().toString()));

}

}
			