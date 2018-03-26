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

import ingenias.editor.IDEState;
import ingenias.editor.ModelJGraph;
import ingenias.exception.*;

public class GraphAttributeImp
    implements GraphAttribute {

  private Object attribute;
  private String name;
  private ModelJGraph graph;
  private IDEState ids;

  public GraphAttributeImp(String name, Object attribute,
                           ModelJGraph graph, IDEState ids) {
    this.name = name;
    this.attribute = attribute;
    this.graph = graph;
    this.ids=ids;
  }

  public String getSimpleValue() {
    if (attribute == null) {
      return "";
    }
    else {
      return attribute.toString();
    }
  }

  public GraphEntity getEntityValue() throws NullEntity {
    if (attribute == null) {
      throw new NullEntity();
    }
    else {
      return new GraphEntityImp( (ingenias.editor.entities.Entity) attribute,
                                graph,ids);
    }
  }

  public GraphCollection getCollectionValue() throws NullEntity {
    return new GraphCollectionImp( (ingenias.editor.TypedVector) attribute,
                                  graph,ids);
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return attribute.getClass().getName();
  }

  
  protected Object getValue(){
	  return this.attribute;
  }
  
  protected void setValue(Object value){
	   this.attribute=value;
  }
  

}