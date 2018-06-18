package ingenias.editor.events;

import ingenias.editor.entities.Entity;

import java.awt.geom.Rectangle2D;
import java.util.Hashtable;

import org.jgraph.graph.DefaultGraphCell;

public interface ChangeHandler {

	
	public void handleChange(org.jgraph.event.GraphModelEvent gme,
			Hashtable<Entity,DefaultGraphCell> userObjects,
			Hashtable<Entity,Rectangle2D> cellLocation );
}
