package ingenias.exception;

public class GenerationException extends Exception {

	private int line=0;
	
	
	public GenerationException(String arg0, int line) {
		super(arg0);
		this.line=line;

	}
	
	public int getLine(){
		return line;
	}
	
	
	

}
