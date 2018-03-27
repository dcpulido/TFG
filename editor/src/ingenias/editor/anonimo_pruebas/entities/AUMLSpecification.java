
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

public class AUMLSpecification extends Specification {


  public ingenias.editor.entities.AUMLInteractionDiagramModelEntity ModelThatContainsSpecification;





  public AUMLSpecification(String id) {
    super(id);
    this.setHelpDesc("<br>A description of an interaction using AUML protocol diagrams. This implementation is still alpha, <br>but it can be used to generate most of the diagrams mentioned in the last draft from AUML.<br>Use this kind of specficiation when you look for a more conventional notation. In principle, <br>AUML diagrams and GRASIA diagrams are equally expressive, but AUML diagrams are harder to<br>parse in order to generate code<br>");
    this.setHelpRecom("");
  }


      public AUMLInteractionDiagramModelEntity getModelThatContainsSpecification(){
        return ModelThatContainsSpecification;
      }
       public void setModelThatContainsSpecification(AUMLInteractionDiagramModelEntity
					ModelThatContainsSpecification){
        this.ModelThatContainsSpecification=ModelThatContainsSpecification;
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
