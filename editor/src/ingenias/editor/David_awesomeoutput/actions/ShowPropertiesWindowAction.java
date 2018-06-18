package ingenias.editor.actions;

import ingenias.editor.GUIResources;
import ingenias.editor.IDEState;
import ingenias.editor.PropertiesWindow;
import ingenias.editor.utils.DialogWindows;

import java.awt.event.ActionEvent;

public class ShowPropertiesWindowAction {

	private IDEState ids;
	private GUIResources resources;


	public ShowPropertiesWindowAction(IDEState ids, GUIResources resources){
		this.ids=ids;
		this.resources=resources;		
	}

	public void properties_actionPerformed(ActionEvent e) {
		PropertiesWindow pw = new PropertiesWindow(ids.prop);
		pw.setSize(350, 300);
		pw.setLocation(DialogWindows.getCenter(pw.getSize(),resources.getMainFrame()));
		pw.setVisible(true);
	}
}
