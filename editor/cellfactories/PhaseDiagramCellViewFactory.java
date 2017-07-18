
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

public class PhaseDiagramCellViewFactory implements CellViewFactory {
	
	public PhaseDiagramCellViewFactory() {}
	
	
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
		
		if (userObject.getClass().equals(EndNode.class)){
			return new EndNodeView(v);
		}
		
		if (userObject.getClass().equals(Phase.class)){
			return new PhaseView(v);
		}
		
		if (userObject.getClass().equals(iPhase.class)){
			return new iPhaseView(v);
		}
		
		if (userObject.getClass().equals(Activity.class)){
			return new ActivityView(v);
		}
		
		if (userObject.getClass().equals(DecisionNode.class)){
			return new DecisionNodeView(v);
		}
		
		if (userObject.getClass().equals(ForkNode.class)){
			return new ForkNodeView(v);
		}
		
		if (userObject.getClass().equals(JoinNode.class)){
			return new JoinNodeView(v);
		}
		
		if (userObject.getClass().equals(TextNote.class)){
			return new TextNoteView(v);
		}
		
		if (userObject.getClass().equals(UMLComment.class)){
			return new UMLCommentView(v);
		}
		
		
		// Diagram Relationships start here
		
		if (v.getClass().equals(DPDFPrecedesEdge.class)){
			return new DPDFPrecedesView(v);
		}
		
		if (v.getClass().equals(ActivityPrecedesEdge.class)){
			return new ActivityPrecedesView(v);
		}
		
		/*if (v.getClass().equals(AInheritsEdge.class)){
		 return new AInheritsView(v);
		 }
		 
		 if (v.getClass().equals(AHasMSEdge.class)){
		 return new AHasMSView(v);
		 }
		 
		 if (v.getClass().equals(AHasMSManagerEdge.class)){
		 return new AHasMSManagerView(v);
		 }
		 
		 if (v.getClass().equals(AHasMSProcessorEdge.class)){
		 return new AHasMSProcessorView(v);
		 }
		 
		 if (v.getClass().equals(WFResponsableEdge.class)){
		 return new WFResponsableView(v);
		 }
		 
		 if (v.getClass().equals(AInstanceOfEdge.class)){
		 return new AInstanceOfView(v);
		 }
		 
		 if (v.getClass().equals(AContainsMEEdge.class)){
		 return new AContainsMEView(v);
		 }
		 
		 if (v.getClass().equals(WFPlaysEdge.class)){
		 return new WFPlaysView(v);
		 }
		 
		 if (v.getClass().equals(ARoleInheritanceEdge.class)){
		 return new ARoleInheritanceView(v);
		 }
		 */
		if (v.getClass().equals(UMLAnnotatedElementEdge.class)){
			return new UMLAnnotatedElementView(v);
		}
		
		/*if (v.getClass().equals(WFUsesEdge.class)){
		 return new WFUsesView(v);
		 }
		 
		 if (v.getClass().equals(EResourceBelongsToEdge.class)){
		 return new EResourceBelongsToView(v);
		 }
		 
		 if (v.getClass().equals(ApplicationBelongsToEdge.class)){
		 return new ApplicationBelongsToView(v);
		 }
		 */
		
		return null;
	}
	
	protected EdgeView createEdgeView(Object v) {
		return new EdgeView(v);
		
		//         if (v instanceof ExecuteEdge){
		//           return new ExecuteView(v,this,cm);
		//         }
		
	}
	
	
	
	
}
