
package ingenias.editor.entities;
import java.util.*;

public class InteractionModelModelEntity extends ModelEntity {


  public InteractionModelModelEntity(String id) {
    super(id);
    this.setModelType("InteractionModel");
  }

public void fromMap(Map ht){
super.fromMap(ht);
}

public void toMap(Map ht){
super.toMap(ht);
}


public String toString(){
if (getModelID()==null)
 return "";
else
 return getModelID();
}

}


