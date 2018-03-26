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

import ingenias.editor.Editor;
import ingenias.editor.IDEState;
import ingenias.editor.Model;
import ingenias.editor.ModelJGraph;
import ingenias.editor.entities.Entity;
import ingenias.editor.entities.EnvironmentModelDataEntity;
import ingenias.exception.InvalidGraph;
import ingenias.exception.NullEntity;

import java.util.*;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.jgraph.JGraph;
import org.jgraph.graph.BasicMarqueeHandler;

import java.awt.BorderLayout;
import java.awt.Container;

class GraphImp
extends AttributedElementImp
implements Graph {

	private ingenias.editor.ModelJGraph mjg;
	private IDEState ids;

	GraphImp(ingenias.editor.ModelJGraph mjg, IDEState ids) {
		super(mjg.getProperties(), mjg,ids);
		this.mjg = mjg;
		this.ids=ids;
	}

	public String getName() {
		return mjg.getID();
	}

	public String getType() {
		String name = mjg.getClass().getName();
		int endName = name.lastIndexOf("Model");
		int startName = name.lastIndexOf(".") + 1;
		name = name.substring(startName, endName);
		return name;
	}

	public String[] getPath() {
		try {
			return ids.gm.getModelPath(this.
					getName());
		}
		catch (ingenias.exception.NotFound nf) {
			nf.printStackTrace();
		}
		return null;

	}

	public GraphRelationship[] getRelationships() {
		int max = mjg.getModel().getRootCount();
		Vector v = new Vector();

		boolean found = false;
		int k = 0;
		org.jgraph.graph.DefaultGraphCell dgc = null;
		while (k < max) {
			Object o = mjg.getModel().getRootAt(k);
			if (org.jgraph.graph.DefaultGraphCell.class.isAssignableFrom(o.getClass())) {
				dgc = (org.jgraph.graph.DefaultGraphCell) o;
				if (ingenias.editor.entities.NAryEdgeEntity.class.isAssignableFrom(dgc.
						getUserObject().getClass())) {
					ingenias.editor.entities.NAryEdgeEntity ne =
						(ingenias.editor.entities.NAryEdgeEntity) dgc.getUserObject();

					v.add(new GraphRelationshipImp(ne, mjg,ids));
				}

			}
			k++;
		}

		GraphRelationship[] result = new GraphRelationship[v.size()];
		for (k = 0; k < result.length; k++) {
			result[k] = (GraphRelationship) v.elementAt(k);
		}

		return result;

	}


	public GraphEntity[] getEntitiesWithDuplicates()  throws NullEntity{ 
		int max = mjg.getModel().getRootCount();
		java.util.Vector v = new java.util.Vector();

		boolean found = false;
		int k = 0;
		org.jgraph.graph.DefaultGraphCell dgc = null;
		while (k < max) {
			Object o = mjg.getModel().getRootAt(k);
			if (o instanceof org.jgraph.graph.DefaultGraphCell) {
				dgc = (org.jgraph.graph.DefaultGraphCell) o;
				if (! (dgc.getUserObject()instanceof ingenias.editor.entities.
						NAryEdgeEntity) &&
						! (dgc.getUserObject()instanceof ingenias.editor.entities.
								RoleEntity)) {
					ingenias.editor.entities.Entity ne =
						(ingenias.editor.entities.Entity) dgc.getUserObject();
					GraphEntity ge=null;

					ge = new GraphEntityImp(ne, dgc,mjg,ids);


					v.add(ge);

				}

			}
			k++;
		}

		GraphEntity[] result = new GraphEntity[v.size()];
		Iterator it = v.iterator();
		k = 0;
		while (it.hasNext()) {
			result[k] = (GraphEntity) it.next();
			k++;
		}
		//	    System.err.println("terminado con" +result.length);
		return result;  
	}


	public GraphEntity[] getEntities() throws NullEntity {
		int max = mjg.getModel().getRootCount();
		java.util.Vector v = new java.util.Vector();

		boolean found = false;
		int k = 0;
		org.jgraph.graph.DefaultGraphCell dgc = null;
		while (k < max) {
			Object o = mjg.getModel().getRootAt(k);
			if (o instanceof org.jgraph.graph.DefaultGraphCell) {
				dgc = (org.jgraph.graph.DefaultGraphCell) o;
				if (! (dgc.getUserObject()instanceof ingenias.editor.entities.
						NAryEdgeEntity) &&
						! (dgc.getUserObject()instanceof ingenias.editor.entities.
								RoleEntity)) {
					ingenias.editor.entities.Entity ne =
						(ingenias.editor.entities.Entity) dgc.getUserObject();
					GraphEntity ge=null;

					ge = new GraphEntityImp(ne, mjg,ids);

					if (!v.contains(ge)) {
						v.add(ge);
					}
				}

			}
			k++;
		}

		GraphEntity[] result = new GraphEntity[v.size()];
		Iterator it = v.iterator();
		k = 0;
		while (it.hasNext()) {
			result[k] = (GraphEntity) it.next();
			k++;
		}
		//    System.err.println("terminado con" +result.length);
		return result;
	}

	private void createSubFolders(File f) {
		if (!f.exists()) {
			createSubFolders(new File(f.getParent()));
			try {
				f.createNewFile();
			}
			catch (IOException ioe) {
				ioe.printStackTrace();
			}

		}

	}

	public void generateImage(String filename) {
		File target = new File(filename);
		new File(target.getParent()).mkdirs();

		JPanel temp=new JPanel(new BorderLayout());
		JGraph njg=this.mjg.cloneJGraph(ids);
		temp.add(njg,BorderLayout.CENTER);
		njg.setSelectionCells(new Object[0]);
		ingenias.editor.export.Diagram2SVG.diagram2SVG(temp, target,"png");
		

	}

	public ingenias.editor.ModelJGraph getGraph() {
		return this.mjg;
	}


}
