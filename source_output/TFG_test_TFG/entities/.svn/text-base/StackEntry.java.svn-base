
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

public class StackEntry extends INGENIASObject {


  public java.lang.String Operation;

  public java.lang.String Time;

  public java.lang.String Resposible;

  public java.lang.String Place;





  public StackEntry(String id) {
    super(id);
    this.setHelpDesc("<br>				Stack information<br>			");
    this.setHelpRecom("");
  }


      public java.lang.String getOperation(){
        return Operation;
      }
       public void setOperation(java.lang.String
					Operation){
        this.Operation=Operation;
      }


      public java.lang.String getTime(){
        return Time;
      }
       public void setTime(java.lang.String
					Time){
        this.Time=Time;
      }


      public java.lang.String getResposible(){
        return Resposible;
      }
       public void setResposible(java.lang.String
					Resposible){
        this.Resposible=Resposible;
      }


      public java.lang.String getPlace(){
        return Place;
      }
       public void setPlace(java.lang.String
					Place){
        this.Place=Place;
      }





public void fromMap(Map ht){
super.fromMap(ht);

if (ht.get("Operation") instanceof String)
 this.setOperation(ht.get("Operation").toString());

if (ht.get("Time") instanceof String)
 this.setTime(ht.get("Time").toString());

if (ht.get("Resposible") instanceof String)
 this.setResposible(ht.get("Resposible").toString());

if (ht.get("Place") instanceof String)
 this.setPlace(ht.get("Place").toString());



}
public void toMap(Map ht){
super.toMap(ht);

if (this.getOperation() instanceof String)
 ht.put("Operation",this.getOperation().toString());

if (this.getTime() instanceof String)
 ht.put("Time",this.getTime().toString());

if (this.getResposible() instanceof String)
 ht.put("Resposible",this.getResposible().toString());

if (this.getPlace() instanceof String)
 ht.put("Place",this.getPlace().toString());

}

public String toString(){
if (this.getId()==null ||
    this.getId().toString().equals(""))
 return "Please, define the value of field Id";
else
 return this.getId().toString();
}

}
