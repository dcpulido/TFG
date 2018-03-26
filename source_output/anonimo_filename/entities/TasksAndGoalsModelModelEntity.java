
package ingenias.editor.entities;
import java.util.*;

public class TasksAndGoalsModelModelEntity extends ModelEntity {


  public TasksAndGoalsModelModelEntity(String id) {
    super(id);
    this.setModelType("TasksAndGoalsModel");
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


