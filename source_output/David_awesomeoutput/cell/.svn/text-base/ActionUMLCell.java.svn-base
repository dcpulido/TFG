
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
import org.jgraph.graph.*;
import ingenias.editor.entities.*;
public class ActionUMLCell extends  DefaultGraphCell {
  // Empty Constructor
  public ActionUMLCell(ActionUML userObject) {
    super(userObject); ////////// Por quç¯¯ne esto el ejemplo de JGraph.
    // Add a Port
    DefaultPort port = new DefaultPort(userObject);
    this.add(port);
  }
  public String toString(){
   return this.getUserObject().toString();
  }
}


