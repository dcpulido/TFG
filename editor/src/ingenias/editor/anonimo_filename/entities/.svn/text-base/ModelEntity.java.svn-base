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

package ingenias.editor.entities;
import java.util.*;


public class ModelEntity extends Entity  implements java.io.Serializable {

  public String modelID;
  public String modelType;

  public ModelEntity(String id) {
    super(id);
  }

  public String getModelID(){
    return modelID;
  }

  public void setModelID(String modelID){
    this.modelID=modelID;
  }

  public void setModelType(String modelType){
    this.modelType=modelType;
  }

  public String getModelType(){
    return this.modelType;
  }


public void fromMap(Map ht){
super.fromMap(ht);
if (ht.get("ModelID")!=null)
 this.setModelID(ht.get("ModelID").toString());
if (ht.get("ModelType")!=null)
this.setModelType(ht.get("ModelType").toString());


}

public void toMap(Map ht){
super.toMap(ht);
if (modelID!=null)
ht.put("ModelID",modelID);
if (modelType!=null)
ht.put("ModelType",modelType);


}

}