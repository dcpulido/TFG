package ingenias.exception;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author sin atribuir
 * @version 1.0
 */

public class NotWellFormed extends Exception {

  public NotWellFormed() {
  }

  public NotWellFormed(String message) {
    super(message);
  }

  public NotWellFormed(String message, Throwable cause) {
    super(message, cause);
  }

  public NotWellFormed(Throwable cause) {
    super(cause);
  }
}