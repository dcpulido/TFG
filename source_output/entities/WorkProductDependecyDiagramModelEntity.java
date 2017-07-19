
package ingenias.editor.entities;
import java.util.*;

public class WorkProductDependecyDiagramModelEntity extends ModelEntity {


  public WorkProductDependecyDiagramModelEntity(String id) {
    super(id);
    this.setModelType("WorkProductDependecyDiagram");
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


