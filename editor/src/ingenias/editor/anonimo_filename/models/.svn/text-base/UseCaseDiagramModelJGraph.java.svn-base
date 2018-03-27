
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

public class UseCaseDiagramModelJGraph extends ModelJGraph {

  private Preferences prefs;

  public UseCaseDiagramModelJGraph(UseCaseDiagramDataEntity mde, 
                               String nombre, ObjectManager om, Model
                               m, BasicMarqueeHandler mh, Preferences prefs) {
    super(mde, nombre, m, mh,om);
    this.prefs=prefs;
    
			 
				  ToolTipManager.sharedInstance().registerComponent(this);
				  this.getModel().addGraphModelListener(
				  new ChangeNARYEdgeLocation(this));
				  this.getModel().addGraphModelListener(
				  new ChangeEntityLocation(this));			  
				  
		
    this.getGraphLayoutCache().setFactory(new ingenias.editor.cellfactories.UseCaseDiagramCellViewFactory());
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
    toolbar = new FilteredJToolBar("UseCaseDiagram");
    toolbar.setFloatable(false);
    ImageIcon undoIcon = null;
    JButton jb = null;


    Image img_TextUseCase =
        ImageLoader.getImage("images/musecase.gif");
    undoIcon = new ImageIcon(img_TextUseCase);
    Action TextUseCase=
        new AbstractAction("TextUseCase", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "TextUseCase");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    TextUseCase.setEnabled(true);
    jb = new JButton(TextUseCase);
    jb.setText("");
    jb.setName("TextUseCase");	
    jb.setToolTipText("TextUseCase");
    toolbar.add(jb);

    Image img_INGENIASUseCase =
        ImageLoader.getImage("images/miusecase.gif");
    undoIcon = new ImageIcon(img_INGENIASUseCase);
    Action INGENIASUseCase=
        new AbstractAction("INGENIASUseCase", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "INGENIASUseCase");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    INGENIASUseCase.setEnabled(true);
    jb = new JButton(INGENIASUseCase);
    jb.setText("");
    jb.setName("INGENIASUseCase");	
    jb.setToolTipText("INGENIASUseCase");
    toolbar.add(jb);

    Image img_Agent =
        ImageLoader.getImage("images/magent.gif");
    undoIcon = new ImageIcon(img_Agent);
    Action Agent=
        new AbstractAction("Agent", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "Agent");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    Agent.setEnabled(true);
    jb = new JButton(Agent);
    jb.setText("");
    jb.setName("Agent");	
    jb.setToolTipText("Agent");
    toolbar.add(jb);

    Image img_Role =
        ImageLoader.getImage("images/mrole.gif");
    undoIcon = new ImageIcon(img_Role);
    Action Role=
        new AbstractAction("Role", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "Role");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    Role.setEnabled(true);
    jb = new JButton(Role);
    jb.setText("");
    jb.setName("Role");	
    jb.setToolTipText("Role");
    toolbar.add(jb);

    Image img_Interaction =
        ImageLoader.getImage("images/minter.gif");
    undoIcon = new ImageIcon(img_Interaction);
    Action Interaction=
        new AbstractAction("Interaction", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "Interaction");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    Interaction.setEnabled(true);
    jb = new JButton(Interaction);
    jb.setText("");
    jb.setName("Interaction");	
    jb.setToolTipText("Interaction");
    toolbar.add(jb);

    Image img_TextNote =
        ImageLoader.getImage("images/mtext.gif");
    undoIcon = new ImageIcon(img_TextNote);
    Action TextNote=
        new AbstractAction("TextNote", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "TextNote");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    TextNote.setEnabled(true);
    jb = new JButton(TextNote);
    jb.setText("");
    jb.setName("TextNote");	
    jb.setToolTipText("TextNote");
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

    Image img_Goal =
        ImageLoader.getImage("images/mgoal.gif");
    undoIcon = new ImageIcon(img_Goal);
    Action Goal=
        new AbstractAction("Goal", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "Goal");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    Goal.setEnabled(true);
    jb = new JButton(Goal);
    jb.setText("");
    jb.setName("Goal");	
    jb.setToolTipText("Goal");
    toolbar.add(jb);

    Image img_Organization =
        ImageLoader.getImage("images/morg.gif");
    undoIcon = new ImageIcon(img_Organization);
    Action Organization=
        new AbstractAction("Organization", undoIcon) {
      public void actionPerformed(ActionEvent e) {
       try{
        insert(new Point(0, 0), "Organization");
	} catch (InvalidEntity e1) {			
		e1.printStackTrace();
	}
      }
    };
    Organization.setEnabled(true);
    jb = new JButton(Organization);
    jb.setText("");
    jb.setName("Organization");	
    jb.setToolTipText("Organization");
    toolbar.add(jb);

    }

  }

  public static Vector<String> getAllowedRelationships(){
   Vector<String> relationships=new   Vector<String>();


          relationships.add("Extends");

          relationships.add("Includes");

          relationships.add("Generalizes");

          relationships.add("ParticipatesInUseCase");

          relationships.add("UMLDescribesUseCase");

          relationships.add("UMLAssociation");

          relationships.add("UMLAnnotatedElement");

          relationships.add("UseCasePursues");

   return relationships;
  }

  public static Vector<String> getAllowedEntities(){
   Vector<String> entities=new   Vector<String>();


 entities.add("TextUseCase");

 entities.add("INGENIASUseCase");

 entities.add("Agent");

 entities.add("Role");

 entities.add("Interaction");

 entities.add("TextNote");

 entities.add("UMLComment");

 entities.add("Goal");

 entities.add("Organization");

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
        if (ExtendsEdge.acceptConnection(this.getModel(), selected)) {
          v.add("Extends");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (IncludesEdge.acceptConnection(this.getModel(), selected)) {
          v.add("Includes");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (GeneralizesEdge.acceptConnection(this.getModel(), selected)) {
          v.add("Generalizes");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (ParticipatesInUseCaseEdge.acceptConnection(this.getModel(), selected)) {
          v.add("ParticipatesInUseCase");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (UMLDescribesUseCaseEdge.acceptConnection(this.getModel(), selected)) {
          v.add("UMLDescribesUseCase");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (UMLAssociationEdge.acceptConnection(this.getModel(), selected)) {
          v.add("UMLAssociation");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (UMLAnnotatedElementEdge.acceptConnection(this.getModel(), selected)) {
          v.add("UMLAnnotatedElement");
	  }

        // N-ary relationships. Sometimes they can be also binary.
        if (UseCasePursuesEdge.acceptConnection(this.getModel(), selected)) {
          v.add("UseCasePursues");
	  }

      }
      else if (nAryEdgesNum == 1) {

        if (selectedEdge instanceof ExtendsEdge &&
        (ExtendsEdge.acceptConnection(this.getModel(), selected))) {
          v.add("Extends");
        }

        if (selectedEdge instanceof IncludesEdge &&
        (IncludesEdge.acceptConnection(this.getModel(), selected))) {
          v.add("Includes");
        }

        if (selectedEdge instanceof GeneralizesEdge &&
        (GeneralizesEdge.acceptConnection(this.getModel(), selected))) {
          v.add("Generalizes");
        }

        if (selectedEdge instanceof ParticipatesInUseCaseEdge &&
        (ParticipatesInUseCaseEdge.acceptConnection(this.getModel(), selected))) {
          v.add("ParticipatesInUseCase");
        }

        if (selectedEdge instanceof UMLDescribesUseCaseEdge &&
        (UMLDescribesUseCaseEdge.acceptConnection(this.getModel(), selected))) {
          v.add("UMLDescribesUseCase");
        }

        if (selectedEdge instanceof UMLAssociationEdge &&
        (UMLAssociationEdge.acceptConnection(this.getModel(), selected))) {
          v.add("UMLAssociation");
        }

        if (selectedEdge instanceof UMLAnnotatedElementEdge &&
        (UMLAnnotatedElementEdge.acceptConnection(this.getModel(), selected))) {
          v.add("UMLAnnotatedElement");
        }

        if (selectedEdge instanceof UseCasePursuesEdge &&
        (UseCasePursuesEdge.acceptConnection(this.getModel(), selected))) {
          v.add("UseCasePursues");
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

      if (relacion.equalsIgnoreCase("Extends")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof ExtendsEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new ExtendsEdge(new Extends(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("Includes")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof IncludesEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new IncludesEdge(new Includes(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("Generalizes")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof GeneralizesEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new GeneralizesEdge(new Generalizes(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("ParticipatesInUseCase")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof ParticipatesInUseCaseEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new ParticipatesInUseCaseEdge(new ParticipatesInUseCase(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("UMLDescribesUseCase")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof UMLDescribesUseCaseEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new UMLDescribesUseCaseEdge(new UMLDescribesUseCase(getMJGraph().getNewId()));
        }
      }

      if (relacion.equalsIgnoreCase("UMLAssociation")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof UMLAssociationEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new UMLAssociationEdge(new UMLAssociation(getMJGraph().getNewId()));
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

      if (relacion.equalsIgnoreCase("UseCasePursues")) {
        // ResponsibleNEdge already exists.
        if (nAryEdgesNum == 1 && selectedEdge instanceof UseCasePursuesEdge) {
          return selectedEdge;
        }
        // There is no NAryEdges in selected.
        else if (nAryEdgesNum == 0) {
          return new UseCasePursuesEdge(new UseCasePursues(getMJGraph().getNewId()));
        }
      }

    }

    return null;
  }
  
  public DefaultGraphCell createCell(String entity) throws InvalidEntity{
  
    if (entity.equalsIgnoreCase("TextUseCase")) {
    TextUseCase nentity=getOM().createTextUseCase(getMJGraph().getNewId("TextUseCase"));
      DefaultGraphCell vertex = new
          TextUseCaseCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("INGENIASUseCase")) {
    INGENIASUseCase nentity=getOM().createINGENIASUseCase(getMJGraph().getNewId("INGENIASUseCase"));
      DefaultGraphCell vertex = new
          INGENIASUseCaseCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("Agent")) {
    Agent nentity=getOM().createAgent(getMJGraph().getNewId("Agent"));
      DefaultGraphCell vertex = new
          AgentCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("Role")) {
    Role nentity=getOM().createRole(getMJGraph().getNewId("Role"));
      DefaultGraphCell vertex = new
          RoleCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("Interaction")) {
    Interaction nentity=getOM().createInteraction(getMJGraph().getNewId("Interaction"));
      DefaultGraphCell vertex = new
          InteractionCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("TextNote")) {
    TextNote nentity=getOM().createTextNote(getMJGraph().getNewId("TextNote"));
      DefaultGraphCell vertex = new
          TextNoteCell(nentity);
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

    if (entity.equalsIgnoreCase("Goal")) {
    Goal nentity=getOM().createGoal(getMJGraph().getNewId("Goal"));
      DefaultGraphCell vertex = new
          GoalCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

    if (entity.equalsIgnoreCase("Organization")) {
    Organization nentity=getOM().createOrganization(getMJGraph().getNewId("Organization"));
      DefaultGraphCell vertex = new
          OrganizationCell(nentity);
      // Default Size for the cell with the new entity
     return vertex;
    }
    else

	  throw new ingenias.exception.InvalidEntity("Entity type "+entity+" is not allowed in this diagram"); 
  }
  
  public Dimension getDefaultSize(Entity entity) throws InvalidEntity{
    
    if (entity.getType().equalsIgnoreCase("TextUseCase")) {
      return TextUseCaseView.getSize((TextUseCase)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("INGENIASUseCase")) {
      return INGENIASUseCaseView.getSize((INGENIASUseCase)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("Agent")) {
      return AgentView.getSize((Agent)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("Role")) {
      return RoleView.getSize((Role)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("Interaction")) {
      return InteractionView.getSize((Interaction)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("TextNote")) {
      return TextNoteView.getSize((TextNote)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("UMLComment")) {
      return UMLCommentView.getSize((UMLComment)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("Goal")) {
      return GoalView.getSize((Goal)entity);      
    }
    else

    if (entity.getType().equalsIgnoreCase("Organization")) {
      return OrganizationView.getSize((Organization)entity);      
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


    if (entity.getClass().equals(TextUseCase.class)) {
      vertex = new TextUseCaseCell( (TextUseCase) entity);
      // Default Size for the new Vertex with the new entity within
      size = TextUseCaseView.getSize((TextUseCase) entity);
    }
    else

    if (entity.getClass().equals(INGENIASUseCase.class)) {
      vertex = new INGENIASUseCaseCell( (INGENIASUseCase) entity);
      // Default Size for the new Vertex with the new entity within
      size = INGENIASUseCaseView.getSize((INGENIASUseCase) entity);
    }
    else

    if (entity.getClass().equals(Agent.class)) {
      vertex = new AgentCell( (Agent) entity);
      // Default Size for the new Vertex with the new entity within
      size = AgentView.getSize((Agent) entity);
    }
    else

    if (entity.getClass().equals(Role.class)) {
      vertex = new RoleCell( (Role) entity);
      // Default Size for the new Vertex with the new entity within
      size = RoleView.getSize((Role) entity);
    }
    else

    if (entity.getClass().equals(Interaction.class)) {
      vertex = new InteractionCell( (Interaction) entity);
      // Default Size for the new Vertex with the new entity within
      size = InteractionView.getSize((Interaction) entity);
    }
    else

    if (entity.getClass().equals(TextNote.class)) {
      vertex = new TextNoteCell( (TextNote) entity);
      // Default Size for the new Vertex with the new entity within
      size = TextNoteView.getSize((TextNote) entity);
    }
    else

    if (entity.getClass().equals(UMLComment.class)) {
      vertex = new UMLCommentCell( (UMLComment) entity);
      // Default Size for the new Vertex with the new entity within
      size = UMLCommentView.getSize((UMLComment) entity);
    }
    else

    if (entity.getClass().equals(Goal.class)) {
      vertex = new GoalCell( (Goal) entity);
      // Default Size for the new Vertex with the new entity within
      size = GoalView.getSize((Goal) entity);
    }
    else

    if (entity.getClass().equals(Organization.class)) {
      vertex = new OrganizationCell( (Organization) entity);
      // Default Size for the new Vertex with the new entity within
      size = OrganizationView.getSize((Organization) entity);
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

		

		 UseCaseDiagramModelJGraph jg=new  UseCaseDiagramModelJGraph(
				(UseCaseDiagramDataEntity) this.mde,name, ids.om,
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
