package ingenias.editor.actions;

import java.awt.event.ActionEvent;

import ingenias.editor.GUIResources;
import ingenias.editor.IDEState;

public class CopyObjectToClipboardAction {
	private IDEState ids;
	private GUIResources resources;
	
	public CopyObjectToClipboardAction(IDEState ids, GUIResources resources){
		this.ids=ids;
		this.resources=resources;
	}
	
	public void copy_actionPerformed(ActionEvent e) {
		ActionEvent e1 = new ActionEvent(this.ids.editor.getGraph(), e.getID(),
				e.getActionCommand(), e.getModifiers());
		if (ids.editor.getGraph()!=null) {
			(this.ids.editor.getGraph().getTransferHandler().getCopyAction()).
			actionPerformed(e1);			
		}
	}

}
