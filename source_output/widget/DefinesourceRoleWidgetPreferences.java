

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

package ingenias.editor.widget;
import org.jgraph.graph.*;
import java.util.*;

public class DefinesourceRoleWidgetPreferences extends EntityWidgetPreferences {

  Hashtable preferredWidget=new Hashtable();
  Hashtable defaultValues=new Hashtable();


  public DefinesourceRoleWidgetPreferences() {
  super();
  String[] preferredOrder={""};
  this.setPreferredOrder(preferredOrder);
  Vector result=null;
  
  };



  

  public Object getWidget(String attName)  throws IllegalAccessException,InstantiationException{
   Class result=null;
   ConfigurableWidget instance=null;
   if (preferredWidget.get(attName)!=null)
    result= ((Class)preferredWidget.get(attName));
   else
    return (super.getWidget(attName));
   if (result!=null){
    instance=(ConfigurableWidget)result.newInstance();
    Vector values=(Vector)defaultValues.get(attName);
    instance.setDefaultValues(values);  
   }
   return instance;
  }

  public void configureWidget(ConfigurableWidget cw){
 
  }



}


