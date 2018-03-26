package ingenias.editor;

import javax.swing.tree.DefaultTreeModel;

import ingenias.editor.events.DiagramChangeHandler;

public class IDEChangesHandler implements DiagramChangeHandler{
	
	private IDEState ids;
	
	private GUIResources resources;
	
	public IDEChangesHandler(IDEState ids, GUIResources resources){
		this.ids=ids;
		this.resources=resources;
	}
	
	public void addNewDiagram(ModelJGraph mjg) {
		ids.setChanged(true);
		resources.setChanged();
		System.err.println("Reloading everything");
		ids.gm.reload();		
		ids.editor.reloadDiagrams();
		resources.getArbolProyectos().repaint();		
	}
	
	public void addNewPackage(Object[] path, String nombre) {
		ids.setChanged(true);
		resources.setChanged();
		System.err.println("Reloading everything");
		ids.gm.reload();		
		ids.editor.reloadDiagrams();
		resources.getArbolProyectos().repaint();		
		
	}
	
	public void diagramDeleted(ModelJGraph mj) {
		ids.setChanged(true);
		resources.setChanged();
		System.err.println("Reloading everything");
		ids.gm.reload();		
		ids.editor.reloadDiagrams();
		resources.getArbolProyectos().repaint();				
	}
	
	public void diagramPropertiesChanged(ModelJGraph mjg) {
		ids.setChanged(true);
		resources.setChanged();
		System.err.println("Reloading everything");
		ids.gm.reload();		
		ids.editor.reloadDiagrams();
		resources.getArbolProyectos().repaint();		
	}
	
	public void diagramRenamed(ModelJGraph mjg) {
		ids.setChanged(true);
		resources.setChanged();
		System.err.println("Reloading everything");
		ids.gm.reload();		
		ids.editor.reloadDiagrams();
		resources.getArbolProyectos().repaint();		
	}
	
	public void packageRenamed(String result) {
		ids.setChanged(true);
		resources.setChanged();
		ids.gm.reload();			
		resources.getArbolObjetos().repaint();
	}
	
	public void otherChange() {
		ids.setChanged(true);		
		resources.setChanged();		
	}
	
}
