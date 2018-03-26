
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

public class MentalInstanceSpecification extends INGENIASObject {


  public ingenias.editor.entities.MentalEntity InstanceType;



  public TypedVector SlotsValues=new TypedVector(ingenias.editor.entities.SlotValueSpecification.class);



  public MentalInstanceSpecification(String id) {
    super(id);
    this.setHelpDesc("<br>				Sometimes, the model needs to refer to an instance of the model. For those cases, an InstanceSpecification is needed.<br>			");
    this.setHelpRecom("");
  }


      public ingenias.editor.entities.MentalEntity getInstanceType(){
        return InstanceType;
      }
       public void setInstanceType(ingenias.editor.entities.MentalEntity
					InstanceType){
        this.InstanceType=InstanceType;
      }




  public void setSlotsValues(TypedVector tv){
    this.SlotsValues=tv;
  }

  public String getSlotsValues(){
   return SlotsValues.toString();
  }

  public Class getSlotsValuesType(){
   return SlotsValues.getType();
  }
  public void addSlotsValues(ingenias.editor.entities.SlotValueSpecification element){
   this.SlotsValues.add(element);
  }

  public void insertSlotsValuesAt(int pos,ingenias.editor.entities.SlotValueSpecification element){
   this.SlotsValues.insert(element,pos);
  }

  public int containsSlotsValues(ingenias.editor.entities.SlotValueSpecification element){
   return this.SlotsValues.indexOf(element);
  }


  public Enumeration getSlotsValuesElements(){
   return this.SlotsValues.elements();
  }

  public void removeSlotsValuesElement(String id){
    Enumeration enumeration=this.getSlotsValuesElements();
    ingenias.editor.entities.Entity found=null;
    while (enumeration.hasMoreElements() && found==null){
     ingenias.editor.entities.Entity ent=(ingenias.editor.entities.Entity)enumeration.nextElement();
     if (ent.getId().equalsIgnoreCase(id))
      found=ent;
    }
    if (found!=null)
     this.SlotsValues.remove(found);
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
