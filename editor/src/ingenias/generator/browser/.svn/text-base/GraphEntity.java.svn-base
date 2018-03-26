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

import ingenias.exception.InvalidAttribute;

import java.util.*;

//It represents an entity in a diagram. It can contain attributes.
public interface GraphEntity  extends AttributedElement{
	
	// Obtains all relationships of an entity in the diagram from which
	// this entity was extracted
	public GraphRelationship[] getRelationships();
	
	// Obtains all relationships in which this entity participates
	// no matter what is the diagram
	public Vector getAllRelationships();
	
	// Obtains the id of the entity
	public String getID();
	
	// Obtains the type of the entity
	public String getType();
	
	
	/**
	 * sets the value of an attribute to "ga"
	 * @param ga Attribute to be updated
	 * @throws InvalidAttribute the attribute pased as
	 *  value was not an original attribute of this entity
	 *  
	 */
	public void setAttribute(GraphAttribute ga) throws InvalidAttribute;
	
}