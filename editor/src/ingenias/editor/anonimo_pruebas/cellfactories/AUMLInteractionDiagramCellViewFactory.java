
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

public class AUMLInteractionDiagramCellViewFactory implements CellViewFactory {

public AUMLInteractionDiagramCellViewFactory() {}
 

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


   if (userObject.getClass().equals(Protocol.class)){
           return new ProtocolView(v);
   }

   if (userObject.getClass().equals(SubProtocol.class)){
           return new SubProtocolView(v);
   }

   if (userObject.getClass().equals(Lifeline.class)){
           return new LifelineView(v);
   }

   if (userObject.getClass().equals(Column.class)){
           return new ColumnView(v);
   }

   if (userObject.getClass().equals(AUMLPort.class)){
           return new AUMLPortView(v);
   }

   if (userObject.getClass().equals(AUMLAlternativeBox.class)){
           return new AUMLAlternativeBoxView(v);
   }

   if (userObject.getClass().equals(AUMLAlternativeRow.class)){
           return new AUMLAlternativeRowView(v);
   }

   if (userObject.getClass().equals(TextNote.class)){
           return new TextNoteView(v);
   }

   if (userObject.getClass().equals(UMLComment.class)){
           return new UMLCommentView(v);
   }


   // Diagram Relationships start here

   if (v.getClass().equals(AUMLSendSimpleEdge.class)){
           return new AUMLSendSimpleView(v);
   }

   if (v.getClass().equals(AUMLSelectionEdge.class)){
           return new AUMLSelectionView(v);
   }

   if (v.getClass().equals(AUMLUseProtocolEdge.class)){
           return new AUMLUseProtocolView(v);
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
