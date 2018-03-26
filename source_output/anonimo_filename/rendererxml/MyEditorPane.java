package ingenias.editor.rendererxml;

import java.io.IOException;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.html.HTMLEditorKit;

public class MyEditorPane extends JEditorPane {

	public MyEditorPane() {
		super();
		setEditorKit(new HTMLEditorKit());
		//StyledEditorKit editor = new StyledEditorKit();		
		setBorder(BorderFactory.createEtchedBorder());
	}

	public MyEditorPane(String type, String text) {
		super(type, "<html><font size=\"24\">"+text+"</font></html>");
		setEditorKit(new HTMLEditorKit());
		setBorder(BorderFactory.createEtchedBorder());
	}

	public MyEditorPane(String url) throws IOException {
		super(url);
		setEditorKit(new StyledEditorKit());
		setBorder(BorderFactory.createEtchedBorder());
	}

	public MyEditorPane(URL url) throws IOException {
		super(url);
		setEditorKit(new StyledEditorKit());
		setBorder(BorderFactory.createEtchedBorder());
	}

}
