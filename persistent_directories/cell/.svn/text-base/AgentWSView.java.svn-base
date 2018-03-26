
/*
    Copyright (C) 2002 Jorge Gomez Sanz, Ruben Fuentes

    Modifications over JGRAPH original code


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

import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;
import java.util.Map;
import org.jgraph.graph.*;
import org.jgraph.*;
import ingenias.editor.entities.*;

// Define the View for an AgentCell
public class AgentWSView extends VertexView {

  public static AgentWSRenderer renderer = new AgentWSRenderer();

  // Constructor for Superclass
  // cell es un AgentCell
  public AgentWSView(Object cell) {
    super(cell);
  }


  public CellViewRenderer getRenderer() {
    try {
          return this.renderer;
        }
        catch (Exception e) {
          e.printStackTrace();
          ingenias.editor.Log.getInstance().log(e.getMessage());
        }

    return renderer;
  }

  public java.awt.Component getRendererComponent(JGraph jg,boolean b1, boolean b2, boolean b3){
   CellViewRenderer renderer=null;
    try {
           ingenias.editor.entities.AgentWS ent=(ingenias.editor.entities.AgentWS)((DefaultGraphCell)this.getCell()).getUserObject();
          this.renderer.setEntity(ent);
          JPanel uop=(JPanel)this.renderer.getRendererComponent(null,this,false,false,false);
          return (Component)uop;
        }
        catch (Exception e) {
          e.printStackTrace();
          ingenias.editor.Log.getInstance().log("WARNING!!!"+e.getMessage());
        }
        return super.getRendererComponent(jg,b1,b2,b3);

 }

  // Default AgentView Size.
  static public Dimension getSize() {
    return renderer.getSize();
  }

  // Default size with entity ent inside
  static public Dimension getSize(AgentWS ent) {
    renderer.setEntity(ent);
    return renderer.getSize();
  }



}
