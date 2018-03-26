
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
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.Map;
import java.util.Hashtable;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;
import java.util.*;
import java.util.Hashtable;
import java.util.ArrayList;
import javax.swing.event.UndoableEditEvent;
import org.jgraph.JGraph;
import org.jgraph.graph.*;
import org.jgraph.event.*;
import java.util.Vector;
import org.jgraph.JGraph;
import org.jgraph.graph.*;
import org.jgraph.event.*;
import org.jgraph.plaf.basic.*;
import ingenias.editor.entities.*;
import ingenias.editor.cell.*;
import ingenias.editor.events.*;
import ingenias.exception.InvalidEntity;
import ingenias.editor.*;

public class DeployDiagramModelJGraph extends ModelJGraph {

  private Preferences prefs;

  public DeployDiagramModelJGraph(DeployDiagramDataEntity mde, 
                               String nombre, ObjectManager om, Model
                               m, BasicMarqueeHandler mh, Preferences prefs) {
    super(mde, nombre, m, mh,om);
    this.prefs=prefs;
    
			 
				  ToolTipManager.sharedInstance().registerComponent(this);
				  this.getModel().addGraphModelListener(
				  new ChangeNARYEdgeLocation(this));
				  this.getModel().addGraphModelListener(
				  new ChangeEntityLocation(this));			  
				  
		
    this.getGraphLayoutCache().setFactory(new ingenias.editor.cellfactories.DeployDiagramCellViewFactory());
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
    toolbar = new FilteredJToolBar("DeployDiagram");
    toolbar.setFloatable(false);
    ImageIcon undoIcon = null;
    JButton jb = null;


    Image img_TestingPackage =
        ImageLoader.getImage("images/mdepl.gif");
    undoIcon = new ImageIcon(img_TestingPackage);
    Action TestingPackage=
        new AbstractAction("TestingPackage", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "TestingPackage");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    TestingPackage.setEnabled(true);
    jb = new JButton(TestingPackage);
    jb.setText("");
    jb.setName("TestingPackage");	
    jb.setToolTipText("TestingPackage");
    toolbar.add(jb);

    Image img_DeploymentPackage =
        ImageLoader.getImage("images/mdepl.gif");
    undoIcon = new ImageIcon(img_DeploymentPackage);
    Action DeploymentPackage=
        new AbstractAction("DeploymentPackage", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "DeploymentPackage");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    DeploymentPackage.setEnabled(true);
    jb = new JButton(DeploymentPackage);
    jb.setText("");
    jb.setName("DeploymentPackage");	
    jb.setToolTipText("DeploymentPackage");
    toolbar.add(jb);

    Image img_INGENIASComponent =
        ImageLoader.getImage("images/micomponent.gif");
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

    Image img_Application =
        ImageLoader.getImage("images/mapp.gif");
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
        ImageLoader.getImage("images/mappe.gif");
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
        ImageLoader.getImage("images/mappi.gif");
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

    Image img_UMLComment =
        ImageLoader.getImage("images/mumlcomment.gif");
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

    Image img_DeploymentUnitByType =
        ImageLoader.getImage("images/mtypedepl.gif");
    undoIcon = new ImageIcon(img_DeploymentUnitByType);
    Action DeploymentUnitByType=
        new AbstractAction("DeploymentUnitByType", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "DeploymentUnitByType");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    DeploymentUnitByType.setEnabled(true);
    jb = new JButton(DeploymentUnitByType);
    jb.setText("");
    jb.setName("DeploymentUnitByType");	
    jb.setToolTipText("DeploymentUnitByType");
    toolbar.add(jb);

    Image img_DeploymentUnitByTypeEnumInitMS =
        ImageLoader.getImage("images/mimtypedepl.gif");
    undoIcon = new ImageIcon(img_DeploymentUnitByTypeEnumInitMS);
    Action DeploymentUnitByTypeEnumInitMS=
        new AbstractAction("DeploymentUnitByTypeEnumInitMS", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "DeploymentUnitByTypeEnumInitMS");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    DeploymentUnitByTypeEnumInitMS.setEnabled(true);
    jb = new JButton(DeploymentUnitByTypeEnumInitMS);
    jb.setText("");
    jb.setName("DeploymentUnitByTypeEnumInitMS");	
    jb.setToolTipText("DeploymentUnitByTypeEnumInitMS");
    toolbar.add(jb);

    Image img_DeploymentUnitByTypeMSEntity =
        ImageLoader.getImage("images/mimtypedepl.gif");
    undoIcon = new ImageIcon(img_DeploymentUnitByTypeMSEntity);
    Action DeploymentUnitByTypeMSEntity=
        new AbstractAction("DeploymentUnitByTypeMSEntity", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "DeploymentUnitByTypeMSEntity");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    DeploymentUnitByTypeMSEntity.setEnabled(true);
    jb = new JButton(DeploymentUnitByTypeMSEntity);
    jb.setText("");
    jb.setName("DeploymentUnitByTypeMSEntity");	
    jb.setToolTipText("DeploymentUnitByTypeMSEntity");
    toolbar.add(jb);

    }

  }

  public static Vector<String> getAllowedRelationships(){
   Vector<String> relationships=new   Vector<String>();


          relationships.add("UMLAnnotatedElement");

          relationships.add("DefinesDeployment");

   return relationships;
  }

  public static Vector<String> getAllowedEntities(){
   Vector<String> entities=new   Vector<String>();


 entities.add("TestingPackage");

 entities.add("DeploymentPackage");

 entities.add("INGENIASComponent");

 entities.add("Application");

 entities.add("EnvironmentApplication");

 entities.add("InternalApplication");

 entities.add("UMLComment");

 entities.add("DeploymentUnitByType");

 entities.add("DeploymentUnitByTypeEnumInitMS");

 entities.add("DeploymentUnitByTypeMSEntity");

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
        if (UMLAnnotatedElementEdge.acceptConnection(this.getModel(), selected)) {
          v.add("UMLAnnotatedElement");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (DefinesDeploymentEdge.acceptConnection(this.getModel(), selected)) {
          v.add("DefinesDeployment");
	  }

      }
      else if (nAryEdgesNum == 1) {

        if (selectedEdge instanceof UMLAnnotatedElementEdge &&
        (UMLAnnotatedElementEdge.acceptConnection(this.getModel(), selected))) {
          v.add("UMLAnnotatedElement");
        }

        if (selectedEdge instanceof DefinesDeploymentEdge &&
        (DefinesDeploymentEdge.acceptConnection(this.getModel(), selected))) {
          v.add("DefinesDeployment");
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

      if (relacion.equalsIgnoreCase("DefinesDeployment")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof DefinesDeploymentEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new DefinesDeploymentEdge(new DefinesDeployment(getMJGraph().getNewId()));
        }
      }

    }

    return null;
  }
  
  public DefaultGraphCell createCell(String entity) throws InvalidEntity{
  
    if (entity.equalsIgnoreCase("TestingPackage")) {
    TestingPackage nentity=getOM().createTestingPackage(getMJGraph().getNewId("TestingPackage"));
      DefaultGraphCell vertex = new
          TestingPackageCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("DeploymentPackage")) {
    DeploymentPackage nentity=getOM().createDeploymentPackage(getMJGraph().getNewId("DeploymentPackage"));
      DefaultGraphCell vertex = new
          DeploymentPackageCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("INGENIASComponent")) {
    INGENIASComponent nentity=getOM().createINGENIASComponent(getMJGraph().getNewId("INGENIASComponent"));
      DefaultGraphCell vertex = new
          INGENIASComponentCell(nentity);
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

    if (entity.equalsIgnoreCase("UMLComment")) {
    UMLComment nentity=getOM().createUMLComment(getMJGraph().getNewId("UMLComment"));
      DefaultGraphCell vertex = new
          UMLCommentCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("DeploymentUnitByType")) {
    DeploymentUnitByType nentity=getOM().createDeploymentUnitByType(getMJGraph().getNewId("DeploymentUnitByType"));
      DefaultGraphCell vertex = new
          DeploymentUnitByTypeCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("DeploymentUnitByTypeEnumInitMS")) {
    DeploymentUnitByTypeEnumInitMS nentity=getOM().createDeploymentUnitByTypeEnumInitMS(getMJGraph().getNewId("DeploymentUnitByTypeEnumInitMS"));
      DefaultGraphCell vertex = new
          DeploymentUnitByTypeEnumInitMSCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("DeploymentUnitByTypeMSEntity")) {
    DeploymentUnitByTypeMSEntity nentity=getOM().createDeploymentUnitByTypeMSEntity(getMJGraph().getNewId("DeploymentUnitByTypeMSEntity"));
      DefaultGraphCell vertex = new
          DeploymentUnitByTypeMSEntityCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

	  throw new ingenias.exception.InvalidEntity("Entity type "+entity+" is not allowed in this diagram"); 
  }
  
  public Dimension getDefaultSize(Entity entity) throws InvalidEntity{
    
    if (entity.getType().equalsIgnoreCase("TestingPackage")) {
      return TestingPackageView.getSize((TestingPackage)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("DeploymentPackage")) {
      return DeploymentPackageView.getSize((DeploymentPackage)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("INGENIASComponent")) {
      return INGENIASComponentView.getSize((INGENIASComponent)entity);      
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

    if (entity.getType().equalsIgnoreCase("UMLComment")) {
      return UMLCommentView.getSize((UMLComment)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("DeploymentUnitByType")) {
      return DeploymentUnitByTypeView.getSize((DeploymentUnitByType)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("DeploymentUnitByTypeEnumInitMS")) {
      return DeploymentUnitByTypeEnumInitMSView.getSize((DeploymentUnitByTypeEnumInitMS)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("DeploymentUnitByTypeMSEntity")) {
      return DeploymentUnitByTypeMSEntityView.getSize((DeploymentUnitByTypeMSEntity)entity);      
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


    if (entity.getClass().equals(TestingPackage.class)) {
      vertex = new TestingPackageCell( (TestingPackage) entity);
      // Default Size for the new Vertex with the new entity within
      size = TestingPackageView.getSize((TestingPackage) entity);
    }
    else

    if (entity.getClass().equals(DeploymentPackage.class)) {
      vertex = new DeploymentPackageCell( (DeploymentPackage) entity);
      // Default Size for the new Vertex with the new entity within
      size = DeploymentPackageView.getSize((DeploymentPackage) entity);
    }
    else

    if (entity.getClass().equals(INGENIASComponent.class)) {
      vertex = new INGENIASComponentCell( (INGENIASComponent) entity);
      // Default Size for the new Vertex with the new entity within
      size = INGENIASComponentView.getSize((INGENIASComponent) entity);
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

    if (entity.getClass().equals(UMLComment.class)) {
      vertex = new UMLCommentCell( (UMLComment) entity);
      // Default Size for the new Vertex with the new entity within
      size = UMLCommentView.getSize((UMLComment) entity);
    }
    else

    if (entity.getClass().equals(DeploymentUnitByType.class)) {
      vertex = new DeploymentUnitByTypeCell( (DeploymentUnitByType) entity);
      // Default Size for the new Vertex with the new entity within
      size = DeploymentUnitByTypeView.getSize((DeploymentUnitByType) entity);
    }
    else

    if (entity.getClass().equals(DeploymentUnitByTypeEnumInitMS.class)) {
      vertex = new DeploymentUnitByTypeEnumInitMSCell( (DeploymentUnitByTypeEnumInitMS) entity);
      // Default Size for the new Vertex with the new entity within
      size = DeploymentUnitByTypeEnumInitMSView.getSize((DeploymentUnitByTypeEnumInitMS) entity);
    }
    else

    if (entity.getClass().equals(DeploymentUnitByTypeMSEntity.class)) {
      vertex = new DeploymentUnitByTypeMSEntityCell( (DeploymentUnitByTypeMSEntity) entity);
      // Default Size for the new Vertex with the new entity within
      size = DeploymentUnitByTypeMSEntityView.getSize((DeploymentUnitByTypeMSEntity) entity);
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

		

		 DeployDiagramModelJGraph jg=new  DeployDiagramModelJGraph(
				(DeployDiagramDataEntity) this.mde,name, ids.om,
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
