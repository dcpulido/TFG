package ingenias.editor;


import java.awt.Point;
import java.util.Vector;

import javax.swing.AbstractAction;

import org.jgraph.graph.DefaultGraphCell;

public abstract class DiagramMenuEntriesActionsFactory {
	 private GUIResources resources;
	private IDEState state;
	protected abstract Vector<AbstractAction> createChangeViewActions(final DefaultGraphCell cell, final ModelJGraph graph);
     public DiagramMenuEntriesActionsFactory(GUIResources resources, IDEState state){
    	 this.resources=resources;
    	 this.state=state;
     }
          
	abstract protected Vector<AbstractAction> createDiagramSpecificInsertActions(Point point, ModelJGraph graph) ;
}
