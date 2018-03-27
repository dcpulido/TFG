/*
    Copyright (C) 2002 Jorge Gomez Sanz
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

package ingenias.editor.events;

import ingenias.editor.cell.*;
import ingenias.editor.entities.*;

import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;
import java.util.Map;
import java.util.Hashtable;
import org.jgraph.graph.*;
import org.jgraph.*;
import org.jgraph.event.*;
import ingenias.editor.ObservableModel;
import java.util.*;

/**
 *
 * Avoids that an entity gets outta of the screen.
 * It does so by setting X to 1 when X<0 and Y to 1 when Y<0
 *
 */
public class CenterRelationships
    implements org.jgraph.event.GraphModelListener {


  private boolean enabled = true;
  String workingObject = null;
  JGraph graph;

  public CenterRelationships(JGraph graph) {
    this.graph = graph;
  }

  public void graphChanged(org.jgraph.event.GraphModelEvent gme) {
    if (enabled && this.workingObject == null) {
      this.workingObject = "hola";
      this.updateEdges( (ingenias.editor.Model) gme.getSource());
      this.workingObject = null;
    }
  }

  public Point getCenter(Vector points) {
    Iterator it = points.iterator();
    int x = 0;
    int y = 0;
    while (it.hasNext()) {
      Point point = (Point) it.next();
      x = x + point.x;
      y = y + point.y;
    }
    return new Point( (int) (x / points.size()), (int) (y / points.size()));
  }

  private DefaultGraphCell getCellExtreme(Object edge, ingenias.editor.Model m) {
    DefaultEdge de = (DefaultEdge) edge;
    DefaultGraphCell target = (DefaultGraphCell) ( (DefaultPort) m.getTarget(de)).
        getParent();
    DefaultGraphCell source = (DefaultGraphCell) ( (DefaultPort) m.getSource(de)).
        getParent();
    DefaultGraphCell nary = null;
    if (NAryEdge.class.isAssignableFrom(target.getClass())) {
      nary = source;
    }
    if (NAryEdge.class.isAssignableFrom(source.getClass())) {
      nary = target;
    }
    return nary;
  }

  private void updateEdges(ingenias.editor.Model model) {
    Hashtable changes = new Hashtable();
    for (int k = 0; k < model.getRootCount(); k++) {
      if (ingenias.editor.cell.NAryEdge.class.isAssignableFrom(
          model.getRootAt(k).getClass())) {

        DefaultGraphCell dgc = (DefaultGraphCell) model.getRootAt(k);

        Iterator it = model.getEdges(model, new Object[] {dgc}).iterator();

        while (it.hasNext()) {
          DefaultEdge de = (DefaultEdge) it.next();
          DefaultGraphCell nary = dgc;
          Iterator nedges = model.getEdges(model, new Object[] {dgc}).iterator();
          Vector points = new Vector();
          while (nedges.hasNext()) {
            DefaultEdge edgeline = (DefaultEdge) nedges.next();
            DefaultGraphCell extreme = this.getCellExtreme(edgeline, model);
            Rectangle rect = GraphConstants.getBounds(extreme.getAttributes()).
                getBounds().getBounds();
            points.add(new Point( (int) rect.getCenterX(),
                                 (int) rect.getCenterY()));

          }
          Map edgem = nary.getAttributes();
          Point p = this.getCenter(points);
          Rectangle boundsEdge = GraphConstants.getBounds(edgem).getBounds();
	    Rectangle oldvalue=new Rectangle(boundsEdge);
          p.x = p.x - boundsEdge.width / 2;
          p.y = p.y - boundsEdge.height / 2;
	    if (!p.equals(boundsEdge.getLocation())){
           boundsEdge.setLocation(p);
           GraphConstants.setBounds(edgem, boundsEdge);
           changes.put(nary, edgem);
	    }
        }
      }
      if (changes.size()>0)
       model.edit(changes, null, null, null);

    }
  }

}
