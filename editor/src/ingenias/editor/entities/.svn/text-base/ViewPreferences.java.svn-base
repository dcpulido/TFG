package ingenias.editor.entities;

import ingenias.exception.WrongConversion;

public class ViewPreferences implements java.io.Serializable{
	ViewType view=ViewType.INGENIAS;
	
	public enum ViewType {NOICON,UML,INGENIAS,LABEL;

	public ViewType fromString(String string) throws WrongConversion {
		if (string.toLowerCase().equals("label")){
			return ViewType.LABEL;
		}
		if (string.toLowerCase().equals("ingenias")){
			return ViewType.INGENIAS; 
		}
		
		if (string.toLowerCase().equals("uml")){
			return ViewType.UML;
		}
		if (string.toLowerCase().equals("noicon")){
			return ViewType.NOICON;
		}
		throw new ingenias.exception.WrongConversion();
	}}

	public ViewType getView() {
		return view;
	}

	public void setView(ViewType view) {
		this.view = view;
	};

}
