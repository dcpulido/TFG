package ingenias.exception;

// Cannot Join two or Lifelines
public class CannotJoin extends Exception implements java.io.Serializable {

  public CannotJoin(String m) {
    super(m);
  }

}