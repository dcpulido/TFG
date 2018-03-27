package ingenias.editor.actions;

import java.awt.event.ActionEvent;

import ingenias.editor.GUIResources;
import ingenias.editor.IDEState;

public class UndoRedoAction {
	private IDEState ids;
	private GUIResources resources;
	
	public UndoRedoAction(IDEState ids, GUIResources resources){
		this.ids=ids;
		this.resources=resources;
	}
	
	public void undo_actionPerformed(ActionEvent e) {
		ActionEvent e1 = new ActionEvent(this.ids.editor.getGraph(), e.getID(),
				e.getActionCommand(), e.getModifiers());
		if (ids.editor.getGraph()!=null){
			resources.getCommonButtons().getUndo().actionPerformed(e1);
			ids.otherChange();
		}

	}

	public void redo_actionPerformed(ActionEvent e) {
		ActionEvent e1 = new ActionEvent(this.ids.editor.getGraph(), e.getID(),
				e.getActionCommand(), e.getModifiers());
		if (ids.editor.getGraph()!=null){
			resources.getCommonButtons().getRedo().actionPerformed(e1);
			ids.otherChange();
		}
	}
}
