package ingenias.editor.actions;

import ingenias.editor.GUIResources;
import ingenias.editor.IDEState;
import ingenias.editor.persistence.PersistenceManager;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

public class ExitAction {
	private IDEState ids;
	private GUIResources resources;

	public ExitAction(IDEState ids, GUIResources resources){
		this.ids=ids;
		this.resources=resources;
	}

	public void exit_actionPerformed() {
		int result = JOptionPane.OK_OPTION;
		if (ids.isChanged()) {
			result = JOptionPane.showConfirmDialog(resources.getMainFrame(),
					"If you exit, you will loose all changes. Are you sure?",
					"Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		}

		long ctime = System.currentTimeMillis();
		//StatsManager.saveSession(ctime,initTime);

		if (result == JOptionPane.OK_OPTION) {
			new PersistenceManager().savePreferences(ids);
			resources.getMainFrame().setVisible(false);
			System.exit(0);
		}
	}
}
