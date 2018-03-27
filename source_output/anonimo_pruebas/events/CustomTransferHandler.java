package ingenias.editor.events;

import ingenias.editor.ModelJGraph;
import ingenias.editor.ObjectManager;
import ingenias.editor.cell.NAryEdge;
import ingenias.editor.entities.Entity;
import ingenias.editor.filters.DiagramFilter;
import ingenias.editor.filters.FilterManager;

import java.awt.Point;
import java.awt.datatransfer.Transferable;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;

import org.jgraph.JGraph;
import org.jgraph.graph.AttributeMap;
import org.jgraph.graph.CellView;
import org.jgraph.graph.ConnectionSet;
import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.DefaultGraphModel;
import org.jgraph.graph.GraphConstants;
import org.jgraph.graph.GraphLayoutCache;
import org.jgraph.graph.GraphModel;
import org.jgraph.graph.GraphTransferHandler;
import org.jgraph.graph.GraphTransferable;
import org.jgraph.graph.ParentMap;

public class CustomTransferHandler extends GraphTransferHandler{

	private static DiagramFilter defaultFilter;

	static {
		 try {
			defaultFilter=
				FilterManager.obtainDiagramFilter(
						FilterManager.getDefaultFilterFromClassLoader(FilterManager.class.getClassLoader()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	private ObjectManager om;
	
	public CustomTransferHandler(ObjectManager om){
		this.om=om;
	}
	/**
	* This method makes sure, before pasting is done, that pasted entities types
	* are going to be inserted and that they do exist in the target ingenias
	* data model
	* 	  
	*/
	public boolean importData(JComponent comp, Transferable t) {
		System.err.println("editando...");
		try {
			if (comp instanceof JGraph) {
				JGraph graph = (JGraph) comp;
				GraphModel model = graph.getModel();
				GraphLayoutCache cache = graph.getGraphLayoutCache();
				ModelJGraph mjgraph=(ModelJGraph)graph;
				
				if (t.isDataFlavorSupported(GraphTransferable.dataFlavor)
						&& graph.isEnabled()) {
					// May be null
					Point p = graph.getUI().getInsertionLocation();

					// Get Local Machine Flavor
					Object obj = t
							.getTransferData(GraphTransferable.dataFlavor);
					GraphTransferable gt = (GraphTransferable) obj;

					// Get Transferred Cells
					final Object[] cells = gt.getCells();

					// Check if all cells are in the model
					boolean allInModel = true;
					String diagramType=mjgraph.getClass().getSimpleName();
					diagramType=diagramType.substring(0,diagramType.lastIndexOf("Model"));
					for (int i = 0; i < cells.length && allInModel; i++){
						if (cells[i] instanceof DefaultGraphCell &&
								!(cells[i] instanceof NAryEdge)){
							ingenias.editor.entities.Entity ent=
								(Entity) ((DefaultGraphCell)cells[i]).getUserObject();
							System.err.println("Validating "+diagramType+" "+ent.getType()+" "+defaultFilter.isValidEntity(diagramType, ent.getType()));
							allInModel=allInModel && 
							defaultFilter.isValidEntity(diagramType, ent.getType());
						} else 
							if (cells[i] instanceof NAryEdge){
								ingenias.editor.entities.Entity ent=
									(Entity) ((DefaultGraphCell)cells[i]).getUserObject();
					
								allInModel=allInModel && 
								defaultFilter.isValidRelationship(diagramType, ent.getType());
							}						
					}
					if (!allInModel)
						return false;
					else {
						for ( int i = 0; i < cells.length && allInModel; i++){
							final Object currentCell=cells[i];
							Runnable createNewNonExistingEntities=new Runnable(){
							 public void run(){
								 if (currentCell instanceof DefaultGraphCell &&
											!(currentCell instanceof NAryEdge)){
										ingenias.editor.entities.Entity ent=
											(Entity) ((DefaultGraphCell)currentCell).getUserObject();
										if (om.findUserObject(ent.getId()).isEmpty())
											try {
												om.insert(ent);
											} catch (SecurityException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											} catch (IllegalArgumentException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											} catch (NoSuchFieldException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											} catch (NoSuchMethodException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											} catch (IllegalAccessException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											} catch (InvocationTargetException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
								 }
								
							 }
							};
							SwingUtilities.invokeLater(createNewNonExistingEntities);
							 
												
						}	
					}
						
				}
			}
		} catch (Exception exception) {
			// System.err.println("Cannot import: " +
			// exception.getMessage());
			exception.printStackTrace();
		}
		return super.importData(comp, t);
	}

}
