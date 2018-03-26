package ingenias.editor.rendererxml;

import java.io.IOException;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;
import java.awt.Font;
import ingenias.editor.FontConfiguration;

public class MyTextPane extends JTextPane {

	public MyTextPane() {
		super();
                this.setFont(FontConfiguration.getConfiguration().getStandardFont());
	}

	public MyTextPane(StyledDocument sd) {
		super(sd);
                this.setFont(FontConfiguration.getConfiguration().getStandardFont());
	}

}
