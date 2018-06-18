/*
    Copyright (C) 2002 Jorge Gomez Sanz, Ruben Fuentes
    Modifications over original code from Jon Barrileaux.
    It has been significantly modified to enhance drawing speed.
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

public class NAryViewRenderer
    implements CellViewRenderer, Serializable {

  /** Cache the current graph for drawing. */
  transient protected JGraph graph;

  /** Cache the current shape for drawing. */
  transient protected VertexView view;

  /** Cached hasFocus and selected value. */
  transient protected boolean hasFocus, selected, preview, opaque;

  /** Cached default foreground and default background. */
  transient protected Color defaultForeground, defaultBackground, bordercolor;

  /** Cached borderwidth. */
  transient protected int borderWidth;

  public static JTextArea renderer = new JTextArea();

  /**
   * Constructs a renderer that may be used to render vertices.
   */

  public NAryViewRenderer() {
    defaultForeground = UIManager.getColor("Tree.textForeground");
    defaultBackground = UIManager.getColor("Tree.textBackground");
  }

  public boolean supportsAttribute(Object key) {
    return true;
  }

  public Component getRendererComponent(JGraph graph,
                                        CellView view, boolean sel,
                                        boolean focus, boolean preview) {
    //   renderer.setText("hola");
   // renderer.setLineWrap(true);
    if (view instanceof VertexView) {
      this.view = (VertexView) view;
      //setComponentOrientation(graph.getComponentOrientation());
      if (graph.getEditingCell() != view.getCell()) {
        Object label = ( (DefaultGraphCell) view.getCell()).getUserObject();

        if (label != null) {
          renderer.setText(label.toString());
          return renderer;
        }

      }

      this.graph = graph;
      this.hasFocus = focus;
      this.selected = sel;
      this.preview = preview;

      return renderer;
    }
    return null;

  }

  public static void main(String args[]) {
    JFrame j = new JFrame();

    j.pack(); ;
    j.show();

  }

}
