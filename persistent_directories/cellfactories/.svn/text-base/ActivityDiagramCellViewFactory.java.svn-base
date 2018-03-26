
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

public class ActivityDiagramCellViewFactory implements CellViewFactory {

public ActivityDiagramCellViewFactory() {}
 

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


   if (userObject.getClass().equals(InitialNode.class)){
           return new InitialNodeView(v);
   }

   if (userObject.getClass().equals(DecisionNode.class)){
           return new DecisionNodeView(v);
   }

   if (userObject.getClass().equals(ForkNode.class)){
           return new ForkNodeView(v);
   }

   if (userObject.getClass().equals(EndNode.class)){
           return new EndNodeView(v);
   }

   if (userObject.getClass().equals(Task.class)){
           return new TaskView(v);
   }

   if (userObject.getClass().equals(Role.class)){
           return new RoleView(v);
   }

   if (userObject.getClass().equals(WorkflowBox.class)){
           return new WorkflowBoxView(v);
   }

   if (userObject.getClass().equals(UMLComment.class)){
           return new UMLCommentView(v);
   }

   if (userObject.getClass().equals(TextNote.class)){
           return new TextNoteView(v);
   }


   // Diagram Relationships start here

   if (v.getClass().equals(UMLAnnotatedElementEdge.class)){
           return new UMLAnnotatedElementView(v);
   }

   if (v.getClass().equals(WFStartsEdge.class)){
           return new WFStartsView(v);
   }

   if (v.getClass().equals(WFEndsEdge.class)){
           return new WFEndsView(v);
   }

   if (v.getClass().equals(WFDecidesEdge.class)){
           return new WFDecidesView(v);
   }

   if (v.getClass().equals(WFFollowsEdge.class)){
           return new WFFollowsView(v);
   }

   if (v.getClass().equals(WFFollowsGuardedEdge.class)){
           return new WFFollowsGuardedView(v);
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
