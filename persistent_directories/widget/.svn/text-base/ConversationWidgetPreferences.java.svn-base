

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

public class ConversationWidgetPreferences extends InformationMentalEntityWidgetPreferences {

  Hashtable preferredWidget=new Hashtable();
  Hashtable defaultValues=new Hashtable();


  public ConversationWidgetPreferences() {
  super();
  String[] preferredOrder={"Interaction","ParticipantsSearch","Initiator","Collaborators","Description",""};
  this.setPreferredOrder(preferredOrder);
   Vector result=null;
  
   preferredWidget.put("PlayedRole",ingenias.editor.widget.CustomJTextField.class);
   result=new Vector();
   
   defaultValues.put("PlayedRole",result);
  
   preferredWidget.put("State",ingenias.editor.widget.CustomJTextField.class);
   result=new Vector();
   
   defaultValues.put("State",result);
  
   preferredWidget.put("Initiator",ingenias.editor.widget.CustomJTextField.class);
   result=new Vector();
   
   defaultValues.put("Initiator",result);
  
   preferredWidget.put("ParticipantsSearch",ingenias.editor.widget.CustomJComboBox.class);
   result=new Vector();
   
   result.add("Automatic");
   
   result.add("Manual");
   
   defaultValues.put("ParticipantsSearch",result);
  
   preferredWidget.put("ConversationID",ingenias.editor.widget.CustomJTextField.class);
   result=new Vector();
   
   defaultValues.put("ConversationID",result);
  
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

//   cw.setDefaultValues(result);
  }
}


