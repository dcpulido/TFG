package ingenias.editor.events;


import ingenias.editor.ModelJGraph;

public interface DiagramChangeHandler {

	 void addNewDiagram(ModelJGraph mjg);

	void addNewPackage(Object[] path, String nombre);

	void diagramRenamed(ModelJGraph mjg);

	void diagramDeleted(ModelJGraph mj);

	void diagramPropertiesChanged(ModelJGraph mjg);

	void packageRenamed(String newName);
	
	void otherChange();
}
