
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

public class InteractionUnit extends INGENIASObject {


  public java.lang.String SpeechAct;

  public java.lang.String Timeout;



  public TypedVector TransferredInfo=new TypedVector(ingenias.editor.entities.MentalEntity.class);



  public InteractionUnit(String id) {
    super(id);
    this.setHelpDesc("<br>Interaction among actors can be described in terms of units of interaction. A unit of interaction can be a message passing,<br>a shared tuple read/write, a remote method invocation, an action over the environment,...<br>This entity serves as an abstraction of all the existing ways an agent can interact with another.<br>To characterize interaction units, the user can associate an speech act with each interaction.<br>			");
    this.setHelpRecom("");
  }


      public java.lang.String getSpeechAct(){
        return SpeechAct;
      }
       public void setSpeechAct(java.lang.String
					SpeechAct){
        this.SpeechAct=SpeechAct;
      }


      public java.lang.String getTimeout(){
        return Timeout;
      }
       public void setTimeout(java.lang.String
					Timeout){
        this.Timeout=Timeout;
      }




  public void setTransferredInfo(TypedVector tv){
    this.TransferredInfo=tv;
  }

  public String getTransferredInfo(){
   return TransferredInfo.toString();
  }

  public Class getTransferredInfoType(){
   return TransferredInfo.getType();
  }
  public void addTransferredInfo(ingenias.editor.entities.MentalEntity element){
   this.TransferredInfo.add(element);
  }

  public void insertTransferredInfoAt(int pos,ingenias.editor.entities.MentalEntity element){
   this.TransferredInfo.insert(element,pos);
  }

  public int containsTransferredInfo(ingenias.editor.entities.MentalEntity element){
   return this.TransferredInfo.indexOf(element);
  }


  public Enumeration getTransferredInfoElements(){
   return this.TransferredInfo.elements();
  }

  public void removeTransferredInfoElement(String id){
    Enumeration enumeration=this.getTransferredInfoElements();
    ingenias.editor.entities.Entity found=null;
    while (enumeration.hasMoreElements() && found==null){
     ingenias.editor.entities.Entity ent=(ingenias.editor.entities.Entity)enumeration.nextElement();
     if (ent.getId().equalsIgnoreCase(id))
      found=ent;
    }
    if (found!=null)
     this.TransferredInfo.remove(found);
  }



public void fromMap(Map ht){
super.fromMap(ht);

if (ht.get("SpeechAct") instanceof String)
 this.setSpeechAct(ht.get("SpeechAct").toString());

if (ht.get("Timeout") instanceof String)
 this.setTimeout(ht.get("Timeout").toString());



}
public void toMap(Map ht){
super.toMap(ht);

if (this.getSpeechAct() instanceof String)
 ht.put("SpeechAct",this.getSpeechAct().toString());

if (this.getTimeout() instanceof String)
 ht.put("Timeout",this.getTimeout().toString());

}

public String toString(){
if (this.getId()==null ||
    this.getId().toString().equals(""))
 return "Please, define the value of field Id";
else
 return this.getId().toString();
}

}
