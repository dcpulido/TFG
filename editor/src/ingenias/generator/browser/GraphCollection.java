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

 import ingenias.editor.TypedVector;
 import ingenias.editor.entities.Entity;
import ingenias.exception.NullEntity;

import org.jgraph.JGraph;

 // It represents a collection of GraphEntities
 public interface GraphCollection {

   // It tells how many elements are there in the collection
   public int size();

   // It tells what is the k-th element
   public GraphEntity getElementAt(int k)  throws NullEntity;

}