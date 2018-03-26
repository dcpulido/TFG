

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

public class UMLSendsMessage extends NAryEdgeEntity {


  public java.lang.String Order;

  public java.lang.String Message;




  public UMLSendsMessage(String id) {
    super(id);
    ModelEntity em=null;
  }




  
      public java.lang.String getOrder(){
        return Order;
      }
   public void setOrder(java.lang.String
					Order){
        this.Order=Order;
      }

      public java.lang.String getMessage(){
        return Message;
      }
   public void setMessage(java.lang.String
					Message){
        this.Message=Message;
      }


public void fromMap(Map ht){
super.fromMap(ht);

if (ht.get("Order") instanceof String)
 this.setOrder(ht.get("Order").toString());

if (ht.get("Message") instanceof String)
 this.setMessage(ht.get("Message").toString());



}
public void toMap(Map ht){
super.toMap(ht);

if (this.getOrder() instanceof String)
 ht.put("Order",this.getOrder().toString());

if (this.getMessage() instanceof String)
 ht.put("Message",this.getMessage().toString());


}

public String toString(){
 return getId()+":"+getType();
}



}
