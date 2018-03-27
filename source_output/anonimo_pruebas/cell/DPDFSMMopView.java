
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

public class DPDFSMMop extends AgentComponent {


  public java.lang.String CurrentValue;

  public java.lang.String MinValue;

  public java.lang.String MaxValue;





  public DPDFSMMop(String id) {
    super(id);
    this.setHelpDesc("<br>Describes a  according to TAEMS notation. Opposite to TAEMS, there is no<br>distinction between consumable and non-consumable .<br>");
    this.setHelpRecom("");
  }


      public java.lang.String getCurrentValue(){
        return CurrentValue;
      }
       public void setCurrentValue(java.lang.String
                    CurrentValue){
        this.CurrentValue=CurrentValue;
      }


      public java.lang.String getMinValue(){
        return MinValue;
      }
       public void setMinValue(java.lang.String
                    MinValue){
        this.MinValue=MinValue;
      }


      public java.lang.String getMaxValue(){
        return MaxValue;
      }
       public void setMaxValue(java.lang.String
                    MaxValue){
        this.MaxValue=MaxValue;
      }





public void fromMap(Map ht){
super.fromMap(ht);

if (ht.get("CurrentValue") instanceof String)
 this.setCurrentValue(ht.get("CurrentValue").toString());

if (ht.get("MinValue") instanceof String)
 this.setMinValue(ht.get("MinValue").toString());

if (ht.get("MaxValue") instanceof String)
 this.setMaxValue(ht.get("MaxValue").toString());



}
public void toMap(Map ht){
super.toMap(ht);

if (this.getCurrentValue() instanceof String)
 ht.put("CurrentValue",this.getCurrentValue().toString());

if (this.getMinValue() instanceof String)
 ht.put("MinValue",this.getMinValue().toString());

if (this.getMaxValue() instanceof String)
 ht.put("MaxValue",this.getMaxValue().toString());

}

public String toString(){
if (this.getId()==null ||
    this.getId().toString().equals(""))
 return "Please, define the value of field Id";
else
 return this.getId().toString();
}

}
