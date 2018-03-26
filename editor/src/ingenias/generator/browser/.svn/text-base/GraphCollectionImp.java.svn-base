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

package ingenias.generator.browser;

import java.util.Vector;

import ingenias.editor.IDEState;
import ingenias.editor.ModelJGraph;
import ingenias.editor.TypedVector;
import ingenias.editor.entities.Entity;
import ingenias.exception.InvalidColection;
import ingenias.exception.NullEntity;

import org.jgraph.JGraph;

public class GraphCollectionImp implements GraphCollection {

  TypedVector tv=null;
  ModelJGraph g;
  IDEState ids;

  public GraphCollectionImp(TypedVector tv, ModelJGraph g, IDEState ids) {
    this.tv=tv;
    this.g=g;
    this.ids=ids;
  }

  public int size(){
    return tv.size();
  }

  public GraphEntity getElementAt(int k)  throws NullEntity{
  
		return new GraphEntityImp((Entity)tv.elementAt(k),g,ids);
	
  }

protected TypedVector getValue() {
	// TODO Auto-generated method stub
	return this.tv;
}
  
 


}