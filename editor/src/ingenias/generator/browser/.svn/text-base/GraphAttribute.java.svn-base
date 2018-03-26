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

import ingenias.exception.*;

// This is the interface for an attribute belonging to an
// class implementing the AttributedElement interface
public interface GraphAttribute {

  /* static final int _GRAPH_ENTITY=0;
   static final int _STRING=1;*/
  // Obtains the value of this attribute considering it as an string
  public String getSimpleValue();

  // Obtains the value of this attribute considering it as a GraphEntity
  // If the attribute is set to null, a NullEntity exception will be thrown
  public GraphEntity getEntityValue() throws NullEntity;

  // If this type is a collection, it obtains all associated instances
  // If the attribute is set to null, a NullEntity exception will be thrown
  public GraphCollection getCollectionValue() throws NullEntity;

  // Name of the attribute
  public String getName();

  // Type of the attribute
  public String getType();

}