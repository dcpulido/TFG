package ingenias.editor;

import ingenias.editor.actions.ConvertUtils;
import ingenias.editor.cell.NAryEdge;
import ingenias.editor.entities.Entity;
import ingenias.editor.entities.ModelDataEntity;
import ingenias.editor.entities.RoleEntity;
import ingenias.editor.widget.GraphicsUtils;
import ingenias.exception.NotInitialised;
import ingenias.exception.NullEntity;
import ingenias.generator.browser.BrowserImp;
import ingenias.generator.browser.Graph;
import ingenias.generator.browser.GraphEntity;
import ingenias.generator.browser.GraphRelationshipImp;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.lang.reflect.Field;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import org.jgraph.graph.DefaultEdge;
import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.GraphCell;
import org.jgraph.graph.GraphModel;

public class CommonMenuEntriesActionFactory {
	
	private GUIResources resources;
	private IDEState state;
	private BrowserImp browser=null;
	
	public CommonMenuEntriesActionFactory(GUIResources resources, IDEState state){
		this.resources=resources;
		this.state=state;
		browser=new BrowserImp(state);
	}
	
	public Vector<AbstractAction> createEdgeActions(final DefaultEdge defaultEdge,
													final ModelJGraph graph) {
		Vector<AbstractAction> actions=new Vector<AbstractAction>();
		final RoleEntity re=(RoleEntity)(defaultEdge.getUserObject());
		Field[] fs=re.getClass().getFields();
		if (fs.length>1)
			actions.add(
						new AbstractAction("Edit") {
				public void actionPerformed(ActionEvent e) {
					System.err.println("clase cell"+defaultEdge.getClass()+" "+defaultEdge.getUserObject());
					graph.startEditingAtCell(defaultEdge);
					
				}
			});
		if (fs.length>1)
			actions.add(
						new AbstractAction("Hide fields") {
				
				public void actionPerformed(ActionEvent e) {
					re.hide();
				}
			});
		for (int k=0;k<fs.length;k++){
			if (!fs[k].getName().equalsIgnoreCase("id")){
				final int j=k;
				// Edit
				actions.add(
							new AbstractAction("Show field "+fs[k].getName()) {
					
					public void actionPerformed(ActionEvent e) {
						re.show(j);
					}
				});
				
			}}
		return actions;
		
	}
	
	
	public Vector<AbstractAction> createCellActions(final DefaultGraphCell cell,
													final ModelJGraph graph) {
		Vector<AbstractAction> actions=new Vector<AbstractAction>();
		//		Help
		
		actions.add(
					new AbstractAction("Help") {
			public void actionPerformed(ActionEvent e) {
				CellHelpWindow chw= new CellHelpWindow();
				
				ingenias.editor.entities.Entity ent=((ingenias.editor.entities.Entity)cell.getUserObject());
				chw.setDescription(ent.getHelpDesc());
				chw.setRec(ent.getHelpRecom());
				chw.setSize(350,300);						
				chw.setLocation(GraphicsUtils.getCenter(graph,chw.getSize()));
				chw.show();
			}
		});
		
		
		
		// Edit
		actions.add(
					new AbstractAction("Edit") {
			public void actionPerformed(ActionEvent e) {
				graph.startEditingAtCell(cell);
				
			}
		});
		return actions;
	}
	
	public Vector<AbstractAction> createEntityActions(final Entity ent) {
		Vector<AbstractAction> actions=new Vector<AbstractAction>();
		final BrowserImp bimp=new BrowserImp(state);
		actions.add(
					new AbstractAction("Search occurrences") {				
			public void actionPerformed(ActionEvent e) {
				StringBuffer result=new StringBuffer();
				result.append("Diagrams found:<ul>");
				Graph[] graphs=bimp.getGraphs();
				for (int k=0;k<graphs.length;k++){
					GraphEntity[] ges;
					try { 
						ges = graphs[k].getEntities();
						boolean found=false;
						for (int j=0;j<ges.length &&!found;j++){
							found=ges[j].getID().equals(ent.getId());
						}
						if (found){
							
							result.append("<li><a href=\"http://app/"+graphs[k].getName()+"/"+ent.getId()+"\">"+graphs[k].getName()+"</a>");
						}
					} catch (NullEntity e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				result.append("</ul>");
				resources.getSearchDiagramPanel().setText(result.toString());
				resources.focusSearchPane();
				
				
			}
		});			
		return actions;
		
	}
	
	// This is the initial method to make the refinement action asociated to an entity element
	
	public Vector<AbstractAction> createCellRefinementActions(final Entity ent) {
		Vector<AbstractAction> actions=new Vector<AbstractAction>();
		
		Vector v=ObjectManager.getInheritors(ent.getClass());
		if (v.size()>0){
			
			for (int k = 0; k < v.size(); k++) {
				final Class current = (Class) v.elementAt(k);
				actions.add(new AbstractAction(current.getName().substring(current.getName().lastIndexOf(".")+1,current.getName().length())) {
					public void actionPerformed(ActionEvent e) {
						// Any of the following must be changed in order to perform the creation of a new package and a new Diagram
						Log.getInstance().logERROR("Creating a new Package for the selected entity: ");
						try {
							Vector<GraphRelationshipImp> rels = 
							browser.findEntity(ent.getId()).getAllRelationships();
							Entity newent = ConvertUtils.convert(state,ent.getId(), ent.getType(),
																 current);
							for (int j=0;j<rels.size();j++){
								rels.elementAt(j).getNAryEdge().replace(ent.getId(),newent);
							}
							Vector<ModelJGraph> models = state.gm.getUOModels();
							for (int j=0;j<models.size();j++){
								GraphModel mjg = models.elementAt(j).getModel();
								for (int l=0;l<mjg.getRootCount();l++){
									if (((DefaultGraphCell)mjg.getRootAt(l)).getUserObject().equals(ent)){
										((DefaultGraphCell)mjg.getRootAt(l)).setUserObject(newent);
										Log.getInstance().logERROR("Replaced in model "+models.elementAt(j).getName());
									}
								}
							}
							
							
							
						}
						catch (Exception e1) {
							e1.printStackTrace();
							Log.getInstance().log(e1.getMessage());
						}
					}
				});
			}
		}
		
		
		return actions;
		
	}
	
	public Vector<AbstractAction> createDiagramIndependentActions(final Point point,
																  final GraphCell[] selected, final ModelJGraph graph) {
		Vector<AbstractAction> actions=new Vector<AbstractAction>();
		actions.add(
					new AbstractAction("Connect") {
			
			public void actionPerformed(ActionEvent e) {
				new Thread(){
					public void run(){
						RelationshipManager.connect(point, selected,graph);		
					}
				}.start();
			}
		});
		return actions;
		
	}
	
	public Vector<AbstractAction> createDiagramOperations(final ModelJGraph graph) {
		Vector<AbstractAction> actions=new Vector<AbstractAction>();
		actions.add(
					new AbstractAction("Show in project view") {
			
			public void actionPerformed(ActionEvent e) {
				
				locateAndScrollToObject(state,graph.getName());
			}
		});
		// Edit
		// Edit
		actions.add(
					new AbstractAction("Edit diagram properties") {
			public void actionPerformed(ActionEvent e) {
				
				boolean duplicated = true;
				while (duplicated) {
					ModelDataEntity mde =  graph.getProperties();
					
					ingenias.editor.editiondialog.GeneralEditionFrame gef = new ingenias.
					editor.editiondialog.GeneralEditionFrame(state.editor, state.om, state.gm, resources.getMainFrame(),
															 "Edit diagram properties",
															 mde);
					ModelJGraph mjg =
					state.gm.getModel(mde.getId());
					//	              Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
					gef.setLocation(GraphicsUtils.getCenter(resources.getMainFrame(),gef.getSize()));
					gef.pack();
					gef.setVisible(true);
					duplicated =
					state.gm.isDuplicated(mde.getId());
					if (duplicated) {
						JOptionPane.showMessageDialog(resources.getMainFrame(),
													  "There exists a model with the same name. Please, select another",
													  "Warning", JOptionPane.WARNING_MESSAGE);
					} else {						
						mjg.setName(mde.getId());
						state.gm.arbolProyecto.storeTreeExpansionPaths();
						( (DefaultTreeModel) state.gm.arbolProyecto.getModel()).reload();
						state.gm.arbolProyecto.restoreTreeExpansionPath();																					
						state.diagramPropertiesChanged(mjg);
					}
				}
				
				
			}
		});
		actions.add(
					new AbstractAction("rename") {
			
			public void actionPerformed(ActionEvent e) {
				
				
				String result = JOptionPane.showInputDialog(resources.getMainFrame(),
															"Type in the new name", 
															graph.getID());
				if (result != null && !result.equals("")) {							
					if (state.gm.existsModel(result)) {
						JOptionPane.showMessageDialog(resources.getMainFrame(),
													  "There exists a model with the same name. Please, select another",
													  "Warning",
													  JOptionPane.WARNING_MESSAGE);
					} else {										
						graph.setId(result);
						graph.setName(result);														
						state.diagramRenamed(graph);		
					}
				}
			}
		});
		
		
		return actions;	
	}
	
	public void locateAndScrollToObject(IDEState ids, String id) {
		
		TreePath foundpath=ids.gm.findModelTreePath(id);
		
		if (foundpath!=null){
			
			TreePath tp=(TreePath)foundpath;
			resources.getArbolProyectos().expandPath(tp);	  
			resources.getArbolProyectos().scrollPathToVisible(tp);			
			resources.getArbolProyectos().setSelectionPath(tp);
			
			
		}
	}
	
	
}
