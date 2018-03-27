package ingenias.editor;

import java.io.File;

import javax.swing.JMenuItem;


public class VisitedFileMenuItem 
extends JMenuItem {
	
	File visited=null;
	public VisitedFileMenuItem(String s, File visited){
		super(s);
		this.visited=visited;
	}
}