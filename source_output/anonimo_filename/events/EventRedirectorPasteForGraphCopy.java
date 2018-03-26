package ingenias.editor.events;

import ingenias.editor.cell.NAryEdge;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

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
public class EventRedirectorPasteForGraphCopy
extends EventRedirectorForGraphCopy
implements java.io.Serializable {
	
	private static Object[] pastedCutObjects;
	private static JGraph pastedCutModel;

	/**
	 *  Description of the Field
	 */
	protected Action action;
	
	// Construct the "Wrapper" Action
	/**
	 *  Constructor for the EventRedirector object
	 *
	 *@param  a  Description of Parameter
	 * @param editor TODO
	 */
	public EventRedirectorPasteForGraphCopy(JGraph editor, Action a, ImageIcon icon) {
		super(editor,a,icon);
		
	}
	
	

	@Override
	protected void firePropertyChange(String arg0, Object arg1, Object arg2) {
		// TODO Auto-generated method stub
		super.firePropertyChange(arg0, arg1, arg2);
		System.err.println("disparado "+arg0);
	}



	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		new Thread(){
			public void run(){
				try {
					Thread.currentThread().sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (pastedCutObjects!=null && pastedCutModel!=null){	
					pastedCutObjects = pastedCutModel.getDescendants(pastedCutObjects);
					pastedCutModel.getModel().remove(pastedCutObjects);
					pastedCutObjects=null;
					JOptionPane.showMessageDialog(null, "pegado aux");  
				}		
			}
		}.start();
		
		
	
	}



	public static void setPastedCut(Object[] objs, JGraph graph) {
		
		pastedCutObjects=objs;
		pastedCutModel=graph;
		
	}
}