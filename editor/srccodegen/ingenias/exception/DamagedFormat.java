package ingenias.exception;

public class DamagedFormat extends Exception {

  public DamagedFormat() {
  }

  public DamagedFormat(String message) {
    super(message);
  }

  public DamagedFormat(String message, Throwable cause) {
    super(message, cause);
  }

  public DamagedFormat(Throwable cause) {
    super(cause);
  }
  public static void main(String[] args) {
    DamagedFormat damagedFormat1 = new DamagedFormat();
  }
}