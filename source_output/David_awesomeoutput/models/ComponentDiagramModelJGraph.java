
/*
    Copyright (C) 2002 Jorge Gomez Sanz, Ruben Fuentes, Juan Pavon

    Modifications over original code from jgraph.sourceforge.net

    This file is part of INGENIAS IDE, a support tool for the INGENIAS
    methodology, availabe at http://grasia.fdi.ucm.es/ingenias or
    http://ingenias.sourceforge.net

    INGENIAS IDE is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    INGENIAS IDE is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with INGENIAS IDE; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

*/
package ingenias.editor.models;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import java.net.URL;

import java.util.Map;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;

import java.util.*;
import java.util.Hashtable;
import java.util.ArrayList;

import org.jgraph.JGraph;
import org.jgraph.graph.*;
import org.jgraph.event.*;
import org.jgraph.plaf.basic.*;

import ingenias.editor.*;
import ingenias.editor.cell.*;
import ingenias.editor.entities.*;
import ingenias.editor.events.*;

import ingenias.exception.InvalidEntity;


public class ComponentDiagramModelJGraph extends ModelJGraph {

  private Preferences prefs;

  public ComponentDiagramModelJGraph(ComponentDiagramDataEntity mde, 
                               String nombre, ObjectManager om, Model
                               m, BasicMarqueeHandler mh, Preferences prefs) {
    super(mde, nombre, m, mh,om);
    this.prefs=prefs;
    
			 
				  ToolTipManager.sharedInstance().registerComponent(this);
				  this.getModel().addGraphModelListener(
				  new ChangeNARYEdgeLocation(this));
				  this.getModel().addGraphModelListener(
        				new ChangeEntityLocation(this));			  
				  

		
    this.getGraphLayoutCache().setFactory(new ingenias.editor.cellfactories.ComponentDiagramCellViewFactory());
  }


  //
  // Adding Tooltips
  //

  // Return Cell Label as a Tooltip
  public String getToolTipText(MouseEvent e) {
    if (e != null) {
      // Fetch Cell under Mousepointer
      Object c = getFirstCellForLocation(e.getX(), e.getY());
      if (c != null) {

        // Convert Cell to String and Return
        return convertValueToString(c);
      }
    }
    return null;
  }





  public JToolBar getPaleta() {
    return toolbar;

  }

  protected void creaToolBar() {
    if (toolbar==null){
    toolbar = new FilteredJToolBar("ComponentDiagram");
    toolbar.setFloatable(false);
    ImageIcon undoIcon = null;
    JButton jb = null;


    Image img_INGENIASComponent =
        ImageLoader.getImage("images/icomponent40.gif");
    undoIcon = new ImageIcon(img_INGENIASComponent);
    Action INGENIASComponent=
        new AbstractAction("INGENIASComponent", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "INGENIASComponent");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    INGENIASComponent.setEnabled(true);
    jb = new JButton(INGENIASComponent);
    jb.setText("");
    jb.setName("INGENIASComponent");	
    jb.setToolTipText("INGENIASComponent");
    toolbar.add(jb);

    Image img_INGENIASCodeComponent =
        ImageLoader.getImage("images/iccomponent40.gif");
    undoIcon = new ImageIcon(img_INGENIASCodeComponent);
    Action INGENIASCodeComponent=
        new AbstractAction("INGENIASCodeComponent", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "INGENIASCodeComponent");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    INGENIASCodeComponent.setEnabled(true);
    jb = new JButton(INGENIASCodeComponent);
    jb.setText("");
    jb.setName("INGENIASCodeComponent");	
    jb.setToolTipText("INGENIASCodeComponent");
    toolbar.add(jb);

    Image img_Application =
        ImageLoader.getImage("images/app40.png");
    undoIcon = new ImageIcon(img_Application);
    Action Application=
        new AbstractAction("Application", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "Application");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    Application.setEnabled(true);
    jb = new JButton(Application);
    jb.setText("");
    jb.setName("Application");	
    jb.setToolTipText("Application");
    toolbar.add(jb);

    Image img_EnvironmentApplication =
        ImageLoader.getImage("images/appe40.png");
    undoIcon = new ImageIcon(img_EnvironmentApplication);
    Action EnvironmentApplication=
        new AbstractAction("EnvironmentApplication", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "EnvironmentApplication");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    EnvironmentApplication.setEnabled(true);
    jb = new JButton(EnvironmentApplication);
    jb.setText("");
    jb.setName("EnvironmentApplication");	
    jb.setToolTipText("EnvironmentApplication");
    toolbar.add(jb);

    Image img_InternalApplication =
        ImageLoader.getImage("images/appi40.png");
    undoIcon = new ImageIcon(img_InternalApplication);
    Action InternalApplication=
        new AbstractAction("InternalApplication", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "InternalApplication");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    InternalApplication.setEnabled(true);
    jb = new JButton(InternalApplication);
    jb.setText("");
    jb.setName("InternalApplication");	
    jb.setToolTipText("InternalApplication");
    toolbar.add(jb);

    Image img_Task =
        ImageLoader.getImage("images/task40.png");
    undoIcon = new ImageIcon(img_Task);
    Action Task=
        new AbstractAction("Task", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "Task");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    Task.setEnabled(true);
    jb = new JButton(Task);
    jb.setText("");
    jb.setName("Task");	
    jb.setToolTipText("Task");
    toolbar.add(jb);

    Image img_Test =
        ImageLoader.getImage("images/depl40.gif");
    undoIcon = new ImageIcon(img_Test);
    Action Test=
        new AbstractAction("Test", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "Test");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    Test.setEnabled(true);
    jb = new JButton(Test);
    jb.setText("");
    jb.setName("Test");	
    jb.setToolTipText("Test");
    toolbar.add(jb);

    Image img_UMLComment =
        ImageLoader.getImage("images/umlcomment40.png");
    undoIcon = new ImageIcon(img_UMLComment);
    Action UMLComment=
        new AbstractAction("UMLComment", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "UMLComment");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    UMLComment.setEnabled(true);
    jb = new JButton(UMLComment);
    jb.setText("");
    jb.setName("UMLComment");	
    jb.setToolTipText("UMLComment");
    toolbar.add(jb);

    }

  }

  public static Vector<String> getAllowedRelationships(){
   Vector<String> relationships=new   Vector<String>();


          relationships.add("CDUsesCode");

          relationships.add("UMLRealizes");

          relationships.add("UMLAnnotatedElement");

   return relationships;
  }

  public static Vector<String> getAllowedEntities(){
   Vector<String> entities=new   Vector<String>();


 entities.add("INGENIASComponent");

 entities.add("INGENIASCodeComponent");

 entities.add("Application");

 entities.add("EnvironmentApplication");

 entities.add("InternalApplication");

 entities.add("Task");

 entities.add("Test");

 entities.add("UMLComment");

   return entities;
  }

  // Gets the name of the possible relationships for the selected GraphCells.
  // A relationship can be binary (DefaultEdge) or n-ary (NAryEdge).
  // The requested action is slightly different depending on selected items.
  // According to the number of Edges in selected, the action can be:
  // 0 => Propose a relationship between selected according included classes.
  // 1 and it is NAryEdge => The class of that NAryEdge if it is possible according implements java.io.Serializable
  //      current cardinality and included classes..
  // other cases => Error, no relationships are allowed.
  public Object[] getPossibleRelationships(GraphCell[] selected) {
    // Possible relationships initialization.
    Vector v = new Vector();

    // Search for NAryEdges in selected.
    int nAryEdgesNum = 0;
    int edgesNum = 0;
    NAryEdge selectedEdge = null;
    for (int i = 0; i < selected.length; i++) {
      if (selected[i] instanceof NAryEdge) {
        nAryEdgesNum++;
        selectedEdge = (NAryEdge) selected[i];
      }
      else if (selected[i] instanceof DefaultEdge) {
        edgesNum++;

        // Connections are only possible with two or more elements and without binary edges.
      }
    }
    if (selected.length >= 2 && edgesNum == 0) {

      // The number of NAryEdges is considered.
      if (nAryEdgesNum == 0) {
        // acceptConnection methods only admits vertex parameters.
        // Binary relationships.

        // N-ary relationships. Sometimes they can be also binary.
        if (CDUsesCodeEdge.acceptConnection(this.getModel(), selected)) {
          v.add("CDUsesCode");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (UMLRealizesEdge.acceptConnection(this.getModel(), selected)) {
          v.add("UMLRealizes");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (UMLAnnotatedElementEdge.acceptConnection(this.getModel(), selected)) {
          v.add("UMLAnnotatedElement");
	  }

      }
      else if (nAryEdgesNum == 1) {

        if (selectedEdge instanceof CDUsesCodeEdge &&
        (CDUsesCodeEdge.acceptConnection(this.getModel(), selected))) {
          v.add("CDUsesCode");
        }

        if (selectedEdge instanceof UMLRealizesEdge &&
        (UMLRealizesEdge.acceptConnection(this.getModel(), selected))) {
          v.add("UMLRealizes");
        }

        if (selectedEdge instanceof UMLAnnotatedElementEdge &&
        (UMLAnnotatedElementEdge.acceptConnection(this.getModel(), selected))) {
          v.add("UMLAnnotatedElement");
        }

      }
    }

    return v.toArray();
  }

  public DefaultGraphCell getInstanciaNRelacion(String relacion,
                                                GraphCell[] selected) {

    // Search for NAryEdges in selected.
    int nAryEdgesNum = 0;
    int edgesNum = 0;
    NAryEdge selectedEdge = null;
    for (int i = 0; i < selected.length; i++) {
      if (selected[i] instanceof NAryEdge) {
        nAryEdgesNum++;
        selectedEdge = (NAryEdge) selected[i];
      }
      else if (selected[i] instanceof DefaultEdge) {
        edgesNum++;

      }
    }
    if (nAryEdgesNum <= 1 && edgesNum == 0) {

      if (relacion.equalsIgnoreCase("CDUsesCode")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof CDUsesCodeEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new CDUsesCodeEdge(new CDUsesCode(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("UMLRealizes")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof UMLRealizesEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new UMLRealizesEdge(new UMLRealizes(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("UMLAnnotatedElement")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof UMLAnnotatedElementEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new UMLAnnotatedElementEdge(new UMLAnnotatedElement(getMJGraph().getNewId()));
        }
      }

    }

    return null;
  }
  
  public DefaultGraphCell createCell(String entity) throws InvalidEntity{
  
    if (entity.equalsIgnoreCase("INGENIASComponent")) {
    INGENIASComponent nentity=getOM().createINGENIASComponent(getMJGraph().getNewId("INGENIASComponent"));
      DefaultGraphCell vertex = new
          INGENIASComponentCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("INGENIASCodeComponent")) {
    INGENIASCodeComponent nentity=getOM().createINGENIASCodeComponent(getMJGraph().getNewId("INGENIASCodeComponent"));
      DefaultGraphCell vertex = new
          INGENIASCodeComponentCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("Application")) {
    Application nentity=getOM().createApplication(getMJGraph().getNewId("Application"));
      DefaultGraphCell vertex = new
          ApplicationCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("EnvironmentApplication")) {
    EnvironmentApplication nentity=getOM().createEnvironmentApplication(getMJGraph().getNewId("EnvironmentApplication"));
      DefaultGraphCell vertex = new
          EnvironmentApplicationCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("InternalApplication")) {
    InternalApplication nentity=getOM().createInternalApplication(getMJGraph().getNewId("InternalApplication"));
      DefaultGraphCell vertex = new
          InternalApplicationCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("Task")) {
    Task nentity=getOM().createTask(getMJGraph().getNewId("Task"));
      DefaultGraphCell vertex = new
          TaskCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("Test")) {
    Test nentity=getOM().createTest(getMJGraph().getNewId("Test"));
      DefaultGraphCell vertex = new
          TestCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("UMLComment")) {
    UMLComment nentity=getOM().createUMLComment(getMJGraph().getNewId("UMLComment"));
      DefaultGraphCell vertex = new
          UMLCommentCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

	  throw new ingenias.exception.InvalidEntity("Entity type "+entity+" is not allowed in this diagram"); 
  }
  
  public Dimension getDefaultSize(Entity entity) throws InvalidEntity{
    
    if (entity.getType().equalsIgnoreCase("INGENIASComponent")) {
      return INGENIASComponentView.getSize((INGENIASComponent)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("INGENIASCodeComponent")) {
      return INGENIASCodeComponentView.getSize((INGENIASCodeComponent)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("Application")) {
      return ApplicationView.getSize((Application)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("EnvironmentApplication")) {
      return EnvironmentApplicationView.getSize((EnvironmentApplication)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("InternalApplication")) {
      return InternalApplicationView.getSize((InternalApplication)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("Task")) {
      return TaskView.getSize((Task)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("Test")) {
      return TestView.getSize((Test)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("UMLComment")) {
      return UMLCommentView.getSize((UMLComment)entity);      
    }
    else

    throw new ingenias.exception.InvalidEntity("Entity type "+entity+" is not allowed in this diagram"); 
	    
  }

  public DefaultGraphCell insert(Point point, String entity) throws InvalidEntity {
  // CellView information is not available after creating the cell.

    // Create a Map that holds the attributes for the Vertex
    Map map = new Hashtable();
    // Snap the Point to the Grid
    point = convert(this.snap(new Point(point)));

    // Construct Vertex with no Label
    DefaultGraphCell vertex;
    Dimension size;

    vertex=this.createCell(entity);
    size=this.getDefaultSize((Entity)vertex.getUserObject());



    // Add a Bounds Attribute to the Map
    GraphConstants.setBounds(map, new Rectangle(point, size));

    // Construct a Map from cells to Maps (for insert)
    Hashtable attributes = new Hashtable();
    // Associate the Vertex with its Attributes
    attributes.put(vertex, map);
    // Insert the Vertex and its Attributes
    this.getModel().insert(new Object[] {vertex},attributes
                           , null, null, null);

	Entity newEntity=(Entity) vertex.getUserObject();
	if (prefs.getModelingLanguage()==Preferences.ModelingLanguage.UML)
		newEntity.getPrefs().setView(ViewPreferences.ViewType.UML);
	if (prefs.getModelingLanguage()==Preferences.ModelingLanguage.INGENIAS)
		newEntity.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);

    return vertex;
  }

  


public DefaultGraphCell insertDuplicated(Point point, ingenias.editor.entities.Entity
                               entity) {
    // CellView information is not available after creating the cell.

    // Create a Map that holds the attributes for the Vertex
    Map map =new Hashtable();
    // Snap the Point to the Grid
    point = convert(this.snap(new Point(point)));
   

    // Construct Vertex with no Label
    DefaultGraphCell vertex = null;
    Dimension size = null;


    if (entity.getClass().equals(INGENIASComponent.class)) {
      vertex = new INGENIASComponentCell( (INGENIASComponent) entity);
      // Default Size for the new Vertex with the new entity within
      size = INGENIASComponentView.getSize((INGENIASComponent) entity);
    }
    else

    if (entity.getClass().equals(INGENIASCodeComponent.class)) {
      vertex = new INGENIASCodeComponentCell( (INGENIASCodeComponent) entity);
      // Default Size for the new Vertex with the new entity within
      size = INGENIASCodeComponentView.getSize((INGENIASCodeComponent) entity);
    }
    else

    if (entity.getClass().equals(Application.class)) {
      vertex = new ApplicationCell( (Application) entity);
      // Default Size for the new Vertex with the new entity within
      size = ApplicationView.getSize((Application) entity);
    }
    else

    if (entity.getClass().equals(EnvironmentApplication.class)) {
      vertex = new EnvironmentApplicationCell( (EnvironmentApplication) entity);
      // Default Size for the new Vertex with the new entity within
      size = EnvironmentApplicationView.getSize((EnvironmentApplication) entity);
    }
    else

    if (entity.getClass().equals(InternalApplication.class)) {
      vertex = new InternalApplicationCell( (InternalApplication) entity);
      // Default Size for the new Vertex with the new entity within
      size = InternalApplicationView.getSize((InternalApplication) entity);
    }
    else

    if (entity.getClass().equals(Task.class)) {
      vertex = new TaskCell( (Task) entity);
      // Default Size for the new Vertex with the new entity within
      size = TaskView.getSize((Task) entity);
    }
    else

    if (entity.getClass().equals(Test.class)) {
      vertex = new TestCell( (Test) entity);
      // Default Size for the new Vertex with the new entity within
      size = TestView.getSize((Test) entity);
    }
    else

    if (entity.getClass().equals(UMLComment.class)) {
      vertex = new UMLCommentCell( (UMLComment) entity);
      // Default Size for the new Vertex with the new entity within
      size = UMLCommentView.getSize((UMLComment) entity);
    }
    else

   {}; // Just in case there is no allowed entity in the diagram

    if (vertex == null) {
JOptionPane.showMessageDialog(this,
		 "Object not allowed in this diagram "+this.getID()+":"+ 
		 entity.getId()+":"+entity.getClass().getName()+
		 this.getClass().getName(),"Warning", JOptionPane.WARNING_MESSAGE);    }
    else {

      // Add a Bounds Attribute to the Map
      GraphConstants.setBounds(map, new Rectangle(point, size));

      // Construct a Map from cells to Maps (for insert)
      Hashtable attributes = new Hashtable();
      // Associate the Vertex with its Attributes
      attributes.put(vertex, map);
      // Insert the Vertex and its Attributes
      this.getModel().insert(new Object[] {vertex},attributes
                             , null, null, null);
    }
   return vertex;

  }


 public synchronized JGraph cloneJGraph(IDEState ids){

		

		 ComponentDiagramModelJGraph jg=new  ComponentDiagramModelJGraph(
				(ComponentDiagramDataEntity) this.mde,name, ids.om,
				new Model(ids),new BasicMarqueeHandler(),ids.prefs); 

		this.setSelectionCells(getGraphLayoutCache().getCells(false,true,false,false));
		Action copyaction =new EventRedirectorForGraphCopy(this,this.getTransferHandler().getCopyAction(),null	); 			
		Action pasteaction =new EventRedirectorPasteForGraphCopy(jg,jg.getTransferHandler().getPasteAction(),null	);
		copyaction.actionPerformed(new ActionEvent(this,0,"hello"));		
		pasteaction.actionPerformed(new ActionEvent(this,0,"hello"));
		jg.invalidate();
		jg.doLayout();
		
		return jg;

	}


  public String toString() {
    return this.getID();
  }

}
