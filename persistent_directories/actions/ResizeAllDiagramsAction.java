package ingenias.editor.actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.geom.Rectangle2D;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;

import org.jgraph.graph.CellView;
import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.GraphConstants;
import org.jgraph.graph.GraphModel;

import ingenias.editor.GUIResources;
import ingenias.editor.IDEState;
import ingenias.editor.ModelJGraph;
import ingenias.editor.cell.RenderComponentManager;
import ingenias.editor.entities.Entity;

public class ResizeAllDiagramsAction {
	private IDEState ids;
	private GUIResources resources;
	
	public ResizeAllDiagramsAction(IDEState ids, GUIResources resources){
		this.ids=ids;
		this.resources=resources;
	}
	
	public void resizeAllDiagrams_actionPerformed(ActionEvent e) {
		
		Vector<ModelJGraph> diagrams=this.ids.gm.getUOModels();
		for (int j=0;j<diagrams.size();j++){
			GraphModel gm=diagrams.elementAt(j).getModel();
			for (int k=0;k<gm.getRootCount();k++){
				DefaultGraphCell dgc = (DefaultGraphCell) gm.getRootAt(k);
				Object userobject=dgc.getUserObject();
				CellView currentview=diagrams.elementAt(j).getGraphLayoutCache().getMapping(dgc,false);	
				Entity ent=(Entity)dgc.getUserObject();
				if (ent!=null &&
						RenderComponentManager.retrievePanel(ent.getType(),ent.getPrefs().getView())!=null){
					Dimension dim=RenderComponentManager.getSize(ent,ent.getType(),ent.getPrefs().getView());


					if (dim!=null){
						Map attributes=dgc.getAttributes();
						Rectangle2D loc=GraphConstants.getBounds(attributes);			  
						loc.setRect(loc.getX(),loc.getY(),dim.getWidth(),dim.getHeight());					 
						GraphConstants.setBounds(attributes,loc);			  
						Map nmap=new Hashtable();
						nmap.put(dgc,attributes);
						diagrams.elementAt(j).getModel().edit(nmap,null,null,null);
						diagrams.elementAt(j).repaint();	
					}
				}
			}
		}
	}
}
