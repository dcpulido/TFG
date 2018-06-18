package ingenias.editor.actions;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;

import ingenias.editor.GUIResources;
import ingenias.editor.Help;
import ingenias.editor.IDEState;

public class OpenManualAction {
	private IDEState ids;
	private GUIResources resources;
	
	public OpenManualAction(IDEState ids, GUIResources resources){
		this.ids=ids;
		this.resources=resources;
	}
	
	public void manual_actionPerformed(ActionEvent e) {
		Help h = new Help();
		h.loadHelp("doc/index.htm");
		h.pack();
		h.setExtendedState(JFrame.MAXIMIZED_BOTH);
		h.show();
	}
}
