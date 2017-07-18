package ingenias.editor.events;

import ingenias.editor.Editor;
import ingenias.editor.cell.NAryEdge;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import org.jgraph.JGraph;
import org.jgraph.graph.DefaultEdge;
import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.DefaultPort;
import org.jgraph.graph.GraphModel;

/**
 *  Description of the Class
 *
 *@author     developer
 *@created    29 de septiembre de 2002
 */
class EventRedirectorCut
extends EventRedirector
implements java.io.Serializable {


	// Construct the "Wrapper" Action
	/**
	 *  Constructor for the EventRedirector object
	 *
	 *@param  a  Description of Parameter
	 * @param editor TODO
	 */
	public EventRedirectorCut(Editor editor, Action a, ImageIcon icon) {
		super(editor,a,icon);
		
	}

	public Action getAction() {
		return action;
	}

	
	// Redirect the Actionevent. It extends the selection so that whenever a relationship is selected (part or whole), the whole relationships and extremes are selected as well

	public void actionPerformed(ActionEvent e) {
		
		super.actionPerformed(e);
		
		EventRedirectorPaste.setPastedCut(this.editor.getGraph().getSelectionCells(),this.editor.getGraph());

	}

}