package ingenias.editor;

import java.io.PrintWriter;

;

public class Log {
  private static Log instance;

  private static PrintWriter out = null;
  private static PrintWriter error = null;
  private static StringBuffer altbuffer = new StringBuffer();
  

  private Log(PrintWriter all) {
    this.out = all;
    this.error = all;
  }

  private Log(PrintWriter out, PrintWriter error) {
    this.out = out;
    this.error = error;
  }

  public void log(String message) {
    this.out.println(message);
    this.out.flush();
  }

  public void clearError() {
    altbuffer = new StringBuffer();
  }

  public void logERROR(Throwable e) {
    String location = this.getTrace(e);
    if (location.length() == 0) {
      this.logERROR(e.toString());
    }
    else {
      this.logERROR(e.toString() + " located at \n" + location + "\n");
    }
  }

  protected String getTrace(Throwable e) {
    StackTraceElement[] stes = e.getStackTrace();
    StringBuffer result = new StringBuffer();
    int k = 0;
    while (k < stes.length) {
      result.append(stes[k].getFileName() + " at " + stes[k].getLineNumber() +
                    "\n");
    }
    return result.toString();
  }
  
  public void logWARNING(String message, String diagramName, String entity) {
	    Exception e = new Exception();
	    java.lang.StackTraceElement[] stes = e.getStackTrace();
	    StringBuffer trace = new StringBuffer();
	    java.util.Date cdate = new java.util.Date();
	    java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("HH:mm");
	    String sb = df.format(cdate);
	    String location="<a href=\"http://app/"+diagramName+"\">"+diagramName+"</a>";
	    String entityLocation="<a href=\"http://ent/"+entity+"\">"+entity+"</a>";
	     altbuffer.append("[" + sb + "] WARNING:" + message+". Location "+location+","+entityLocation);
	    this.flushErrors();
	  }
  
  public void logWARNING(String message, String diagramName) {
	    Exception e = new Exception();
	    java.lang.StackTraceElement[] stes = e.getStackTrace();
	    StringBuffer trace = new StringBuffer();
	    java.util.Date cdate = new java.util.Date();
	    java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("HH:mm");
	    String sb = df.format(cdate);
	    String location="<a href=\"http://app/"+diagramName+"\">"+diagramName+"</a>";

	     altbuffer.append("[" + sb + "] WARNING:" + message+". Location "+location);
	    this.flushErrors();
	  }

  public void logWARNING(String message) {
    Exception e = new Exception();
    java.lang.StackTraceElement[] stes = e.getStackTrace();
    StringBuffer trace = new StringBuffer();
//    trace.append(stes[stes.length-1].getClassName()+stes[stes.length-1].getLineNumber())
    java.util.Date cdate = new java.util.Date();
    java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("HH:mm");
    String sb = df.format(cdate);
/*    String location = ". Produced by " + stes[1].getFileName() +
        " at line number " + stes[1].getLineNumber() + "\n";
    if (stes[1].getLineNumber() == -1) {

      // No debug information available
      message = message + ". (No debug information available)";
    }
    else {
      message = message + location;

    }*/

      altbuffer.append("[" + sb + "] WARNING:" + message);
    this.flushErrors();
  }
  
 
  public void logERROR(String message) {
    Exception e = new Exception();
    java.lang.StackTraceElement[] stes = e.getStackTrace();
    StringBuffer trace = new StringBuffer();
//    trace.append(stes[stes.length-1].getClassName()+stes[stes.length-1].getLineNumber())
    java.util.Date cdate = new java.util.Date();
    java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("HH:mm");
    String sb = df.format(cdate);
    String location = ". Produced by " + stes[1].getFileName() +
        " at line number " + stes[1].getLineNumber() + "\n";
    if (stes[1].getLineNumber() == -1) {

      // No debug information available
      message = message + ". (No debug information available)";
    }
    else {
      message = message + location;

    }
    altbuffer.append("[" + sb + "] ERROR:" + message);

    this.flushErrors();
  }

  public void logSYS(String message) {
    java.util.Date cdate = new java.util.Date();
    java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("HH:mm");
    String sb = df.format(cdate);

    altbuffer.append("[" + sb + "] " + message);
    this.flushErrors();
  }

  public void println(String arg) {

  }

  public String getErrors() {
    return altbuffer.toString();
  }

  protected void finalize() throws Throwable {

  }

  public void flushErrors() {
    if (error != null) {
      error.println(altbuffer.toString());
      error.flush();
    }
    else {
      out.println(altbuffer.toString());
      out.flush();
    }
    this.clearError();
  }

  public static void initInstance(PrintWriter out) {
    instance = new Log(out);
  }

  public static void initInstance(PrintWriter out, PrintWriter error) {
    instance = new Log(out, error);
  }
  
  public static boolean isInstantiated(){
	  return instance!=null;
  }

  public static Log getInstance() {
    if (instance == null) {
      throw new RuntimeException(
          "You cannot use the Log before initialising it");
    }
    return instance;
  }

  public static void main(String[] args) {
    Log log1 = new Log(null);
  }

public void logERROR(String message, String graphid, String relid) {
	Exception e = new Exception();
    java.lang.StackTraceElement[] stes = e.getStackTrace();
    StringBuffer trace = new StringBuffer();
//    trace.append(stes[stes.length-1].getClassName()+stes[stes.length-1].getLineNumber())
    java.util.Date cdate = new java.util.Date();
    java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("HH:mm");
    String sb = df.format(cdate);
    String diagramLocation="<a href=\"http://app/"+graphid+"\">"+graphid+"</a>";
    String entityLocation="<a href=\"http://ent/"+relid+"\">"+relid+"</a>";

    /*String location = ". Produced by " + stes[1].getFileName() +
        " at line number " + stes[1].getLineNumber() + "\n";
    if (stes[1].getLineNumber() == -1) {
      // No debug information available
      message = message + ". (No debug information available)";
    }
    else {
      message = message + location;

    }*/
    message=message+". Location "+diagramLocation+","+entityLocation;
    altbuffer.append("[" + sb + "] ERROR:" + message);

    this.flushErrors();
	
}

public void debug(String name, String string) {
	
	
}

}