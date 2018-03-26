/*
    Copyright (C) 2002 Jorge Gomez Sanz

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

package ingenias.generator.datatemplate;

import ingenias.generator.interpreter.TemplateDataRepeat;
import ingenias.generator.interpreter.TemplateDataVar;

import java.util.*;

public class Repeat {
  Vector body=new Vector();
  String id;

  public Repeat(String id){
    this.id=id;
  }

  public void add(Repeat r){
    this.body.add(r);
  }

  public void add(Var v){
    this.body.add(v);
  }

  public String toString(){
    String result="<repeat id=\""+ingenias.generator.util.Conversor.replaceInvalidCharsForID(id)+"\">\n";
    Enumeration enumeration=this.body.elements();
    while (enumeration.hasMoreElements()){
      Object elem=enumeration.nextElement();
      result=result+elem.toString();
    }
    result=result+"</repeat>\n";
    return result;
  }
  


}