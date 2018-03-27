package ingenias.editor.actions;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import ingenias.editor.GUIResources;
import ingenias.editor.IDEState;

public class ForceGCAction {
	private IDEState ids;
	private GUIResources resources;
	
	public ForceGCAction(IDEState ids, GUIResources resources){
		this.ids=ids;
		this.resources=resources;
	}
	
	public void forcegc_actionPerformed(ActionEvent e) {
		long before = Runtime.getRuntime().freeMemory();
		System.gc();
		JOptionPane.showMessageDialog(resources.getMainFrame(),
				"Free memory before:" + before +
				" and now:" +
				Runtime.getRuntime().freeMemory(),
				"Free memory",
				JOptionPane.INFORMATION_MESSAGE);

	}
}
