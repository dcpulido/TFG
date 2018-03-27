

/*
    Copyright (C) 2002 Jorge Gomez Sanz, Ruben Fuentes

    Modifications of original jgraph distribution code (jgraph.sourceforge.ent)

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

package ingenias.editor.cell;


import org.jgraph.JGraph;
import org.jgraph.graph.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.beans.*;
import java.io.*;
import java.util.*;
import ingenias.editor.entities.*;
import ingenias.editor.entities.*;
import org.swixml.SwingEngine;
import ingenias.editor.entities.Entity;

public class WFEndsRenderer extends VertexRenderer implements CellViewRenderer{


private static ViewPreferences.ViewType current = ViewPreferences.ViewType.INGENIAS;


  static {
   try {

    	ViewPreferences.ViewType index=ViewPreferences.ViewType.INGENIAS;
	index=ViewPreferences.ViewType.INGENIAS;
	
	
	index=ViewPreferences.ViewType.NOICON;
	RenderComponentManager.loadRenderFile("WFEnds",
	index,"/ingenias/editor/rendererxml/WFEndsNOICONPanel.xml");
	
	index=ViewPreferences.ViewType.INGENIAS;
	RenderComponentManager.loadRenderFile("WFEnds",
	index,"/ingenias/editor/rendererxml/WFEndsINGENIASPanel.xml");
	
	index=ViewPreferences.ViewType.LABEL;
	RenderComponentManager.loadRenderFile("WFEnds",
	index,"/ingenias/editor/rendererxml/WFEndsLABELPanel.xml");
	
	
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }


  }


    /**
     * Constructs a renderer that may be used to render vertices.
     */
     public WFEndsRenderer() {
    }

    public Dimension getSize() {
    return RenderComponentManager.getSize("WFEnds",current);
    }

    public boolean supportsAttribute(Object key) {
    	return true;
        }

 public static void setEntity(WFEnds ent){
 Map currentMap=(Map)  RenderComponentManager.retrieveIDs("WFEnds",ent.getPrefs().getView());

	

      
      
    
  }
  	public Component getRendererComponent(JGraph graph,
			CellView view, boolean sel,
			boolean focus, boolean preview)
	{
	return RenderComponentManager.retrievePanel("WFEnds",this.current);
		
	}
	
	public static JPanel setCurrent(ViewPreferences.ViewType c) {
	
		current = ViewPreferences.ViewType.INGENIAS;
	
		return (JPanel) RenderComponentManager.retrievePanel("WFEnds",c);
	}



}


			