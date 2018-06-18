package ingenias.editor.extension;

import ingenias.editor.AudioPlayer;
import ingenias.editor.GUIResources;
import ingenias.editor.IDEState;
import ingenias.editor.IDEUpdater;
import ingenias.editor.Log;
import ingenias.editor.actions.HistoryManager;
import ingenias.editor.utils.DialogWindows;

import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JWindow;

public class ManageExtensions {

	private IDEState ids;
	private GUIResources resources;

	public ManageExtensions(IDEState ids, GUIResources resources){
		this.ids=ids;
		this.resources=resources;
	}

	public void addToolEntry(ingenias.editor.extension.BasicTool bt) {		
		Log.getInstance().logSYS("Added new module with name \"" + bt.getName() +
		"\"");
		JMenuItem nentry = new JMenuItem(bt.getName());
		nentry.setToolTipText(bt.getDescription());
		resources.getTools().add(nentry);
		HistoryManager.updateProperties(bt.getProperties(),ids);
		final BasicTool bt1 = bt;
		final Frame jf = resources.getMainFrame();
		nentry.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				new RunToolSwingTask(bt1,ids,resources).execute();
				System.gc();
			}
		});
	}
	public void removeEntry(ingenias.editor.extension.BasicTool bt) {
		int k = 0;
		boolean found = false;
		JMenu entry = null;
		while (!found && k < resources.getCodeGenerator().getItemCount()) {
			entry = (JMenu) resources.getCodeGenerator().getItem(k);
			found = entry.getText().equals(bt.getName());
			if (!found) {
				k = k + 1;
			}
		}
		;
		if (found) {
			resources.getCodeGenerator().remove(k);
		}
		found = false;
		JMenuItem tentry = null;
		k = 0;
		while (!found && k < resources.getTools().getItemCount()) {
			tentry = (JMenuItem) resources.getTools().getItem(k);
			found = tentry.getText().equals(bt.getName());
			if (!found) {
				k = k + 1;
			}
		}
		;
		if (found) {
			resources.getTools().remove(k);
		}
	}

	public void addCGEntry(ingenias.editor.extension.BasicCodeGenerator bcg) {
		Log.getInstance().logSYS("Added new module with name \"" + bcg.getName() +
		"\"");
		JMenu nentry = new JMenu(bcg.getName());
		JMenuItem generate = new JMenuItem("generate");
		nentry.add(generate);
		nentry.setToolTipText(bcg.getDescription());
		resources.getCodeGenerator().add(nentry);

		HistoryManager.updateProperties(bcg.getProperties(),ids);
		final BasicCodeGenerator bcg1 = bcg;
		final Frame jf = resources.getMainFrame();

		generate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				new RunCodeGeneratorSwingTask(bcg1,ids,resources).execute();
				System.gc();
			}
		});

	}

	public void stopManager() {
		// TODO Auto-generated method stub

	}
}
