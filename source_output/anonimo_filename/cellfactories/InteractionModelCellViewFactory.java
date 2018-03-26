
/*null
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
package ingenias.editor.cellfactories;

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
import java.util.Map;
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

public class InteractionModelCellViewFactory implements CellViewFactory {

public InteractionModelCellViewFactory() {}
 

 	public CellView createView(GraphModel model, Object cell) {
		
			CellView view = null;
			if (model.isPort(cell))
				view = new PortView(cell);
			else if (model.isEdge(cell))
				view = createEdgeView(cell);
			else
				view = createVertexView(cell);
			return view;
		}

  // Modificar agregando nuevas clases VIEW segun se vayan a?endo

  protected VertexView createVertexView(Object v) {
    Object userObject = ( (DefaultGraphCell) v).getUserObject();

   // Diagram Objects start here


   if (userObject.getClass().equals(Agent.class)){
           return new AgentView(v);
   }

   if (userObject.getClass().equals(AgentWS.class)){
           return new AgentWSView(v);
   }

   if (userObject.getClass().equals(Role.class)){
           return new RoleView(v);
   }

   if (userObject.getClass().equals(RoleWS.class)){
           return new RoleWSView(v);
   }

   if (userObject.getClass().equals(Task.class)){
           return new TaskView(v);
   }

   if (userObject.getClass().equals(TaskWS.class)){
           return new TaskWSView(v);
   }

   if (userObject.getClass().equals(Goal.class)){
           return new GoalView(v);
   }

   if (userObject.getClass().equals(Interaction.class)){
           return new InteractionView(v);
   }

   if (userObject.getClass().equals(IUIterate.class)){
           return new IUIterateView(v);
   }

   if (userObject.getClass().equals(IUConcurrence.class)){
           return new IUConcurrenceView(v);
   }

   if (userObject.getClass().equals(InteractionUnit.class)){
           return new InteractionUnitView(v);
   }

   if (userObject.getClass().equals(UMLSpecification.class)){
           return new UMLSpecificationView(v);
   }

   if (userObject.getClass().equals(AUMLSpecification.class)){
           return new AUMLSpecificationView(v);
   }

   if (userObject.getClass().equals(GRASIASpecification.class)){
           return new GRASIASpecificationView(v);
   }

   if (userObject.getClass().equals(TextNote.class)){
           return new TextNoteView(v);
   }

   if (userObject.getClass().equals(UMLComment.class)){
           return new UMLCommentView(v);
   }


   // Diagram Relationships start here

   if (v.getClass().equals(IInitiatesEdge.class)){
           return new IInitiatesView(v);
   }

   if (v.getClass().equals(IColaboratesEdge.class)){
           return new IColaboratesView(v);
   }

   if (v.getClass().equals(UIInitiatesEdge.class)){
           return new UIInitiatesView(v);
   }

   if (v.getClass().equals(UIColaboratesEdge.class)){
           return new UIColaboratesView(v);
   }

   if (v.getClass().equals(UISelectionEdge.class)){
           return new UISelectionView(v);
   }

   if (v.getClass().equals(IPursuesEdge.class)){
           return new IPursuesView(v);
   }

   if (v.getClass().equals(GTPursuesEdge.class)){
           return new GTPursuesView(v);
   }

   if (v.getClass().equals(IHasSpecEdge.class)){
           return new IHasSpecView(v);
   }

   if (v.getClass().equals(UIPrecedesEdge.class)){
           return new UIPrecedesView(v);
   }

   if (v.getClass().equals(UMLSendsMessageEdge.class)){
           return new UMLSendsMessageView(v);
   }

   if (v.getClass().equals(UMLAnnotatedElementEdge.class)){
           return new UMLAnnotatedElementView(v);
   }

   if (v.getClass().equals(IAccessesEdge.class)){
           return new IAccessesView(v);
   }


    return null;
  }

  protected EdgeView createEdgeView(Object v) {
  return new EdgeView(v);

//         if (v instanceof ExecuteEdge){
//           return new ExecuteView(v,this,cm);
//         }

  }

 


}
