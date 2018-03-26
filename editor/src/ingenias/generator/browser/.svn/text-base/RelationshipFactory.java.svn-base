
/*
 Copyright (C) 2007 Jorge Gomez Sanz

 This file is part of INGENIAS Development Kit, a support tool for the INGENIAS
 methodology, availabe at http://grasia.fdi.ucm.es/ingenias or
 http://ingenias.sourceforge.net

 INGENIAS Development Kit is free software; you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation; either version 2 of the License, or
 (at your option) any later version.

 INGENIAS Development Kit is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with INGENIAS Development Kit; if not, write to the Free Software
 Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

 */

package ingenias.generator.browser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import org.jgraph.graph.DefaultEdge;
import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.GraphCell;

import ingenias.editor.Editor;
import ingenias.editor.cell.*;
import ingenias.editor.entities.*;

public class RelationshipFactory  {

	public static DefaultGraphCell getNRelationshipInstance(String relationshipName,
			GraphCell[] extremes, Browser browser) {

		// Search for NAryEdges in selected.
		int nAryEdgesNum = 0;
		int edgesNum = 0;
		NAryEdge selectedEdge = null;
		for (int i = 0; i < extremes.length; i++) {
			if (extremes[i] instanceof NAryEdge) {
				nAryEdgesNum++;
				selectedEdge = (NAryEdge) extremes[i];
			} else if (extremes[i] instanceof DefaultEdge) {
				edgesNum++;

			}
		}
		if (nAryEdgesNum <= 1 && edgesNum == 0) {
				// ResponsibleNEdge already exists.
				if (nAryEdgesNum == 1) {
					return selectedEdge;
				}
				// There is no NAryEdges in selected.
				else if (nAryEdgesNum == 0) {
					Class relEntity;
					try {
						relEntity = Class.forName(relationshipName);
						Constructor relEntityCons = relEntity.getConstructor(new Class[]{String.class});					
						Object relEntityInstance = relEntityCons.newInstance(new Object[]{Editor.getNewId(browser)});					
						Class edgeEntity=Class.forName(relationshipName+"Edge");
						Constructor edgeEntityCons = edgeEntity.getConstructor(new Class[]{relEntity});
						Object edgeEntityIns = edgeEntityCons.newInstance(new Object[]{relEntityInstance});
						return (DefaultGraphCell)edgeEntityIns;
					} catch (ClassNotFoundException e) {						
						e.printStackTrace();
					} catch (SecurityException e) {
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
					
				}
			}
		
		return null;
	}
}
