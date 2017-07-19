
package ingenias.editor.entities;
import java.util.*;

public class WorkProductStructureDiagramModelEntity extends ModelEntity {


  public WorkProductStructureDiagramModelEntity(String id) {
    super(id);
    this.setModelType("WorkProductStructureDiagram");
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


