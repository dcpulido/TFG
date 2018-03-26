

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

public class UIColaboratessourceRole extends RoleEntity {


  public java.lang.String Timeout;


 static int idCounter=0;

 public UIColaboratessourceRole() {
	    super("UIColaboratessourceRole"+idCounter);
	    idCounter++;

	  }



  public UIColaboratessourceRole(String id) {
    super(id);

  }



      public java.lang.String getTimeout(){
        return Timeout;
      }
       public void setTimeout(java.lang.String
					Timeout){
        this.Timeout=Timeout;
      }





public void fromMap(Map ht){
super.fromMap(ht);

if (ht.get("Timeout") instanceof String)
 this.setTimeout(ht.get("Timeout").toString());



}
public void toMap(Map ht){
super.toMap(ht);

if (this.getTimeout() instanceof String)
 ht.put("Timeout",encodeutf8Text(this.getTimeout().toString()));

}

}
			