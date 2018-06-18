package ingenias.editor.actions;

import java.awt.event.ActionEvent;
import java.util.Vector;

import ingenias.editor.GUIResources;
import ingenias.editor.IDEState;
import ingenias.editor.entities.Entity;
import ingenias.editor.entities.ViewPreferences;

public class SwitchViewsAction {
	private IDEState ids;
	private GUIResources resources;
	
	public SwitchViewsAction(IDEState ids, GUIResources resources){
		this.ids=ids;
		this.resources=resources;
	}
	
	public void switchUMLView_actionPerformed(ActionEvent e) {
		this.enableUMLView_actionPerformed(e);
		Vector<Entity> entities=this.ids.om.getAllObjects();
		for (int k=0;k<entities.size();k++){
			entities.elementAt(k).getPrefs().setView(ViewPreferences.ViewType.UML);
		}

	}
	public void switchINGENIASView_actionPerformed(ActionEvent e) {
		this.enableINGENIASView_actionPerformed(e);
		Vector<Entity> entities=this.ids.om.getAllObjects();
		for (int k=0;k<entities.size();k++){
			entities.elementAt(k).getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
		}
	}
	
	public void enableUMLView_actionPerformed(ActionEvent e) {
		ids.prefs.setModelingLanguage(ingenias.editor.Preferences.ModelingLanguage.UML);
		resources.getEnableUMLView().setSelected(true);

		/*Enumeration rels=RelationshipManager.getRelationships(this.ids.gm);
	   Enumeration relscells=RelationshipManager.getRelationshipsCells(this.ids.gm);
	   Enumeration relsmodels=RelationshipManager.getRelationshipsModels(this.ids.gm);
	   while (rels.hasMoreElements()){
		   Entity ent=(Entity)rels.nextElement();
		   NAryEdge cell=(NAryEdge)relscells.nextElement();
		   ModelJGraph mjg=(ModelJGraph)relsmodels.nextElement();
		   ent.getPrefs().setView(ViewPreferences.ViewType.UML);
		   RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.UML,ent,cell,mjg);
	   }*/
	}

	public void enableINGENIASView_actionPerformed(ActionEvent e) {
		ids.prefs.setModelingLanguage(ingenias.editor.Preferences.ModelingLanguage.INGENIAS);
		resources.getEnableINGENIASView().setSelected(true);
		/*Enumeration rels=RelationshipManager.getRelationships(this.ids.gm);
		Enumeration relscells=RelationshipManager.getRelationshipsCells(this.ids.gm);
		Enumeration relsmodels=RelationshipManager.getRelationshipsModels(this.ids.gm);
		while (rels.hasMoreElements()){
			Entity ent=(Entity)rels.nextElement();
			NAryEdge cell=(NAryEdge)relscells.nextElement();
			ModelJGraph mjg=(ModelJGraph)relsmodels.nextElement();
			ent.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
			RenderComponentManager.setRelationshipView(ViewPreferences.ViewType.INGENIAS,ent,cell,mjg);
		}*/
	}
}
