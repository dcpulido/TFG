package ingenias.editor;

import java.util.Vector;

import ingenias.editor.filters.DiagramFilter;

import javax.swing.*;

public class FilteredJToolBar extends JToolBar {

	private DiagramFilter filter=null;
	Vector<JButton> originalButtons= new Vector<JButton>();
	private String diagramType;
	private Object lastFilter;

	public FilteredJToolBar(String diagramType){
		super(JToolBar.VERTICAL);
		this.diagramType=diagramType;
	}

	public DiagramFilter getFilter() {
		return filter;
	}


	public void applyFilter(DiagramFilter filter){
		if (originalButtons.isEmpty()){
			int k=0;
			while (this.getComponentAtIndex(k)!=null){
				if (this.getComponentAtIndex(k) instanceof JButton){
					originalButtons.add((JButton) this.getComponentAtIndex(k));
				}
				k=k+1;
			}				
		}
		if (lastFilter==null || !lastFilter.equals(filter)){
			lastFilter=filter;
			this.removeAll();
			for (JButton button:originalButtons){
				if (filter.isValidEntity(diagramType, button.getName())){
					this.add(button);
				}
			}
			this.invalidate();
			this.validate();
			this.repaint();	
		}
	}			

}
