package ingenias.exception;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class MultipleInitialPoints extends Exception {

  public MultipleInitialPoints() {
  }

  public MultipleInitialPoints(String message) {
    super(message);
  }

  public MultipleInitialPoints(String message, Throwable cause) {
    super(message, cause);
  }

  public MultipleInitialPoints(Throwable cause) {
    super(cause);
  }
}