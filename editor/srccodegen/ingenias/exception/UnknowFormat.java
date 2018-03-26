package ingenias.exception;

public class UnknowFormat extends Exception {

  public UnknowFormat() {
  }

  public UnknowFormat(String message) {
    super(message);
  }

  public UnknowFormat(String message, Throwable cause) {
    super(message, cause);
  }

  public UnknowFormat(Throwable cause) {
    super(cause);
  }
  public static void main(String[] args) {
    UnknowFormat unkownFormat1 = new UnknowFormat();
  }
}