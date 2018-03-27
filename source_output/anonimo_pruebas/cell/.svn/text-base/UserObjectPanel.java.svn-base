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
import java.awt.image.*;
import ingenias.editor.entities.*;

public class UserObjectPanel
    extends javax.swing.JPanel {
  Entity uo = null;


  public UserObjectPanel(Entity uo) {
    super();
    this.setUserObject(uo);
    this.setBackground(Color.WHITE);

  }

  public void setUserObject(Entity uo) {
    this.uo = uo;
  }

  public Entity getUserObject() {
    return this.uo;
  }

  /*  public void validate() {
      super.validate();
    }
    public void revalidate() {
       super.revalidate();
    }
    public void repaint(long tm, int x, int y, int width, int height) {
      super.repaint(tm,x,y,width,height);
    }
    public void repaint(Rectangle r) {
      super.repaint(r);
    }
    public void repaint() {
     super.repaint();
    }
   */
  public void paint(Graphics g) {
   g.setXORMode(Color.WHITE);
    super.paint(g);
  }

}