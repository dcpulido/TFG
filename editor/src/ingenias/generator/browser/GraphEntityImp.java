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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import org.jgraph.graph.*;

import ingenias.editor.IDEState;
import ingenias.editor.ModelJGraph;
import ingenias.editor.TypedVector;
import ingenias.editor.entities.*;
import ingenias.exception.*;
import ingenias.exception.NotFound;

public class GraphEntityImp extends AttributedElementImp implements GraphEntity{

	private IDEState ids;
	private Browser browser;

	public org.jgraph.graph.DefaultGraphCell getDgc() {
		return dgc;
	}

	public void setDgc(org.jgraph.graph.DefaultGraphCell dgc) {
		this.dgc = dgc;
	}

	private ingenias.editor.entities.Entity ent;
	private ModelJGraph graph;
	private org.jgraph.graph.DefaultGraphCell dgc;

	GraphEntityImp(ingenias.editor.entities.Entity ent,  org.jgraph.graph.DefaultGraphCell dgc,
			ModelJGraph graph, IDEState ids) throws NullEntity{
		super(ent,graph,ids);
		if (ent==null) throw new ingenias.exception.NullEntity();
		this.ent=ent;
		this.graph=graph;
		this.dgc=dgc;
		this.ids=ids;
		if (graph==null){
			throw new RuntimeException("Graph is null in entity "+ent+ " when creating a GraphEntityImp");
		}
		if (ids==null)
			throw new RuntimeException("The ids parameter cannot be null");
		browser=new BrowserImp(ids);
	}

	GraphEntityImp(ingenias.editor.entities.Entity ent,
			ModelJGraph graph, IDEState ids) throws NullEntity{
		super(ent,graph,ids);
		if (ent==null) throw new ingenias.exception.NullEntity();
		this.ent=ent;
		this.graph=graph;
		dgc=this.getCell(graph);
		this.ids=ids;
		if (graph==null){
			throw new RuntimeException("Graph is null in entity "+ent+ " when creating a GraphEntityImp");
		}
		if (ids==null)
			throw new RuntimeException("The ids parameter cannot be null");
		this.browser=new BrowserImp(ids);
	}

	private Vector getCells(org.jgraph.JGraph graph){
		int max=graph.getModel().getRootCount();
		Vector v=new Vector();

		boolean found=false;
		int k=0;
		Vector dgcs=new Vector();
		org.jgraph.graph.DefaultGraphCell dgc=null;

		while (k<max){
			Object o=graph.getModel().getRootAt(k);
			if (o instanceof org.jgraph.graph.DefaultGraphCell){
				dgc=(org.jgraph.graph.DefaultGraphCell)o;
				found=((ingenias.editor.entities.Entity)dgc.getUserObject()).getId().equals(ent.getId());
				if (found)
					dgcs.add(dgc);
			}
			k++;
		}

		return dgcs;
	}


	private DefaultGraphCell getCell(org.jgraph.JGraph graph){
		int max=graph.getModel().getRootCount();
		Vector v=new Vector();

		boolean found=false;
		int k=0;
		Vector dgcs=getCells(graph);
		org.jgraph.graph.DefaultGraphCell dgc=null;
		while (k<max &&!found){
			Object o=graph.getModel().getRootAt(k);
			if (o instanceof org.jgraph.graph.DefaultGraphCell){
				dgc=(org.jgraph.graph.DefaultGraphCell)o;
				found=((ingenias.editor.entities.Entity)dgc.getUserObject()).getId().equals(ent.getId());
			}
			k++;
		}

		return dgc;
	}


	private DefaultGraphCell getExtreme(org.jgraph.graph.Edge edge){
		if (!(((DefaultGraphCell)((DefaultPort)edge.getTarget()).getParent()).getUserObject()
				instanceof ingenias.editor.entities.NAryEdgeEntity))
			return (DefaultGraphCell)((DefaultPort)edge.getSource()).getParent();
		else
			return (DefaultGraphCell)((DefaultPort)edge.getTarget()).getParent();
	}




	private HashSet getRelationshipsFromAGraph(ingenias.editor.ModelJGraph graph){
		//		System.err.println("studying "+graph.getID());
		int max=graph.getModel().getRootCount();
		HashSet v=new HashSet();
		Enumeration dgcs=this.getCells(graph).elements();
		while (dgcs.hasMoreElements()){

			DefaultGraphCell dgc=(DefaultGraphCell)dgcs.nextElement();

			if (dgc!=null && dgc.getChildren()!=null){
				Iterator ports=dgc.getChildren().iterator();
				while (ports.hasNext()){
					Object port=ports.next();
					Iterator it=graph.getModel().edges(port);

					while (it.hasNext()){
						org.jgraph.graph.Edge current=
							(org.jgraph.graph.Edge)it.next();
						DefaultGraphCell extr=this.getExtreme(current);
						ingenias.editor.entities.NAryEdgeEntity nary=
							(ingenias.editor.entities.NAryEdgeEntity)extr.getUserObject();
						//						System.err.println("adding "+nary.getType());
						v.add(new GraphRelationshipImp(nary,graph,ids));
					}


				}
			}
		}
		return v;


	}

	public Vector getAllRelationships(){
		HashSet result=new HashSet();
		Graph[] g=null;

		g = browser.getGraphs();

		for (int k=0;k<g.length;k++){
			HashSet rel=this.getRelationshipsFromAGraph(((GraphImp)g[k]).getGraph());
			result.addAll(rel);
		}
		return new Vector(result);
	}




	public GraphRelationship[] getRelationships(){

		int max=graph.getModel().getRootCount();

		Vector v=new Vector();

		Iterator ports=dgc.getChildren().iterator();
		while (ports.hasNext()){
			Object port=ports.next();
			Iterator it=graph.getModel().edges(port);

			while (it.hasNext()){

				org.jgraph.graph.Edge current=
					(org.jgraph.graph.Edge)it.next();
				DefaultGraphCell extr=this.getExtreme(current);

				ingenias.editor.entities.NAryEdgeEntity nary=
					(ingenias.editor.entities.NAryEdgeEntity)extr.getUserObject();
				v.add(nary);
			}

		}

		GraphRelationship[] result=new GraphRelationship[v.size()];
		for (int k=0;k<result.length;k++){
			result[k]=new GraphRelationshipImp((NAryEdgeEntity)v.elementAt(k),graph,ids);
		}

		return result;
	}

	public String getID(){
		return ent.getId();
	}

	public String getType(){
		String name=ent.getClass().getName();
		int endName=name.length();//lastIndexOf("Entity");
		int startName=name.lastIndexOf(".")+1;
		name=name.substring(startName,endName);
		return name;

	}

	public boolean equals(Object o){
		if (o instanceof GraphEntityImp){
			return ((GraphEntityImp)o).ent.getId().equalsIgnoreCase(ent.getId());
		}
		else return super.equals(o);
	}

	public String toString(){
		return ent.getType()+":"+ent.getId();
	}

	public int hashCode(){
		return this.ent.hashCode();
	}

	public void setAttribute(GraphAttribute ga) throws InvalidAttribute{
		try {
			GraphAttribute oldga=this.getAttributeByName(ga.getName());
			((GraphAttributeImp)oldga).setValue(((GraphAttributeImp)ga).getValue());
			Object nvalue=((GraphAttributeImp)ga).getValue();
			System.err.println(nvalue.getClass());
			if (nvalue instanceof GraphCollection){
				nvalue=((GraphCollectionImp)nvalue).getValue();
				Class nvalueclass=((TypedVector)nvalue).getType();
				Class entclass=this.ent.getClass();
				Method m=entclass.getMethod("add"+ga.getName(),
						new Class[]{nvalueclass});
				TypedVector tv=(TypedVector)nvalue;
				for (int k=0;k<tv.size();k++){
					m.invoke(ent,new Object[]{tv.elementAt(k)});
				}
			} else {
				if (nvalue instanceof GraphEntity){
					nvalue=((GraphEntityImp)nvalue).getEntity();	
				}
				Class entclass=this.ent.getClass();
				Method m=entclass.getMethod("set"+ga.getName(),
						new Class[]{nvalue.getClass()});

				m.invoke(ent,new Object[]{nvalue});
			}
		} catch (NotFound e) {				
			throw new InvalidAttribute(e);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new InvalidAttribute(e);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new InvalidAttribute(e);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new InvalidAttribute(e);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new InvalidAttribute(e);
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new InvalidAttribute(e);
		}	
	}

	protected Entity getEntity(){
		return this.ent;
	}



}