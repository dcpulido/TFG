package ingenias.editor.actions;

import java.awt.event.ActionEvent;

import ingenias.editor.GUIResources;
import ingenias.editor.IDEState;

public class PasteObjectFromClipboardAction {
	private IDEState ids;
	private GUIResources resources;
	
	public PasteObjectFromClipboardAction(IDEState ids, GUIResources resources){
		this.ids=ids;
		this.resources=resources;
	}
	
	public void paste_actionPerformed(ActionEvent e) {
		ActionEvent e1 = new ActionEvent(this.ids.editor.getGraph(), e.getID(),
				e.getActionCommand(), e.getModifiers());
		if (ids.editor.getGraph()!=null) {
			(this.ids.editor.getGraph().getTransferHandler().getPasteAction()).
			actionPerformed(e1);
			ids.otherChange();
		}	
	}
}
