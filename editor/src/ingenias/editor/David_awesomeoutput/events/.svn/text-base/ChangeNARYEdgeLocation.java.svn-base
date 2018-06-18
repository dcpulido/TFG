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

import ingenias.editor.Model;
import ingenias.editor.ModelJGraph;
import ingenias.editor.cell.*;
import ingenias.editor.entities.Entity;
import ingenias.editor.entities.ViewPreferences;

import java.awt.*;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.util.*;

import org.jgraph.graph.*;
import org.jgraph.*;
import org.jgraph.event.*;

/**
 * This class reallocates a n-ary edge so the central point of the
 * set of ports that it inter-connects. The position is calculated
 * by adding the (x,y) of each port and dividing by the number of
 * ports
 */
public class ChangeNARYEdgeLocation
    implements org.jgraph.event.GraphModelListener {
  private Object workingObject = null;
  private boolean enabled = true;
  private int counter = 0;
  JGraph graph = null;

  public ChangeNARYEdgeLocation(JGraph graph) {
    this.graph = graph;
  }

  public void graphChanged(org.jgraph.event.GraphModelEvent gme) {
    
   if (enabled && (gme.getChange().getInserted()==null
                    ||gme.getChange().getInserted().length==0 )) {
	   
      Map old = gme.getChange().getPreviousAttributes();
      Map newAt = gme.getChange().getAttributes();
      if (old != null) {
        Iterator keys = old.keySet().iterator();
        while (keys.hasNext()) {
          Object current = keys.next();
          Map oluomap = (Map) old.get(current);
          Map newuomap = (Map) newAt.get(current);
          if ((GraphConstants.getBounds(oluomap)==null ||GraphConstants.getBounds(newuomap)==null) ){
        	if (gme.getSource() instanceof NAryEdge)  
        	  this.processChange(gme.getSource());
          } else {
          Rectangle rect1 = GraphConstants.getBounds(oluomap).getBounds();
          Rectangle rect2 = GraphConstants.getBounds(newuomap).getBounds();

          if (((rect1 == null || rect2 == null || !rect1.equals(rect2))) &&
        		  gme.getSource() instanceof NAryEdge) {
            this.processChange( gme.getSource());
          }
          }

        }
      }
    }

  }

  public void processChange(Object naryedge) {
	  NAryEdge nary = (NAryEdge)naryedge;
	  Hashtable changes = new Hashtable();
	  LocationChange.centerNAryEdge(graph, (Model)graph.getModel(), changes, nary);
	  if (changes.size()>0){
		  graph.getModel().edit(changes, null, null, null);
		  System.err.println("Cambiando ...");
	  }
	 
  }
  
  public void disableAutomaticAllocation() {
		enabled = false;
	}

	public void enableAutomaticAllocation() {
		enabled = true;
	}

}
