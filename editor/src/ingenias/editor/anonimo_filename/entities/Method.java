
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

public class Method extends INGENIASObject {


  public java.lang.String Result;

  public java.lang.String Name;



  public TypedVector Parameter=new TypedVector(ingenias.editor.entities.MethodParameter.class);



  public Method(String id) {
    super(id);
    this.setHelpDesc("<br>A conventional object method<br>");
    this.setHelpRecom("");
  }


      public java.lang.String getResult(){
        return Result;
      }
       public void setResult(java.lang.String
					Result){
        this.Result=Result;
      }


      public java.lang.String getName(){
        return Name;
      }
       public void setName(java.lang.String
					Name){
        this.Name=Name;
      }




  public void setParameter(TypedVector tv){
    this.Parameter=tv;
  }

  public String getParameter(){
   return Parameter.toString();
  }

  public Class getParameterType(){
   return Parameter.getType();
  }
  public void addParameter(ingenias.editor.entities.MethodParameter element){
   this.Parameter.add(element);
  }

  public void insertParameterAt(int pos,ingenias.editor.entities.MethodParameter element){
   this.Parameter.insert(element,pos);
  }

  public int containsParameter(ingenias.editor.entities.MethodParameter element){
   return this.Parameter.indexOf(element);
  }


  public Enumeration getParameterElements(){
   return this.Parameter.elements();
  }

  public void removeParameterElement(String id){
    Enumeration enumeration=this.getParameterElements();
    ingenias.editor.entities.Entity found=null;
    while (enumeration.hasMoreElements() && found==null){
     ingenias.editor.entities.Entity ent=(ingenias.editor.entities.Entity)enumeration.nextElement();
     if (ent.getId().equalsIgnoreCase(id))
      found=ent;
    }
    if (found!=null)
     this.Parameter.remove(found);
  }



public void fromMap(Map ht){
super.fromMap(ht);

if (ht.get("Result") instanceof String)
 this.setResult(ht.get("Result").toString());

if (ht.get("Name") instanceof String)
 this.setName(ht.get("Name").toString());



}
public void toMap(Map ht){
super.toMap(ht);

if (this.getResult() instanceof String)
 ht.put("Result",this.getResult().toString());

if (this.getName() instanceof String)
 ht.put("Name",this.getName().toString());

}

public String toString(){
if (this.getName()==null ||
    this.getName().toString().equals(""))
 return "Please, define the value of field Name";
else
 return this.getName().toString();
}

}
