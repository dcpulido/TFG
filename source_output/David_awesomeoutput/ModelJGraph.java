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

package ingenias.editor;

import ingenias.editor.entities.Entity;
import ingenias.editor.entities.ModelDataEntity;
import ingenias.editor.events.CustomTransferHandler;
import ingenias.exception.InvalidEntity;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;

import org.jgraph.JGraph;
import org.jgraph.graph.BasicMarqueeHandler;
import org.jgraph.graph.CellMapper;
import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.GraphCell;
import org.jgraph.graph.Port;
import org.jgraph.graph.VertexView;
import org.jgraph.plaf.basic.BasicGraphUI;


public abstract class ModelJGraph extends JGraph implements Cloneable{
	protected Action undo, redo, remove, group, ungroup, tofront, toback,
	cut, copy, paste;
	protected FilteredJToolBar toolbar;
	protected String name;
	
	protected ModelDataEntity mde=null;
	
	private ObjectManager om;
	
	static{ 
		// To enable SVG. These definitions are needed to let the UIManager
		// know for this look and feel which ComponentUI are needed
		UIManager.getDefaults().put(new org.swixml.XVBox().getUIClassID(),"org.swixml.XVBox");
		UIManager.getDefaults().put(new JGraph().getUIClassID(),"ingenias.editor.ModelJGraph");
	}
	
	
	public ModelJGraph(ModelDataEntity mde,String nombre,Model m,BasicMarqueeHandler mh, ObjectManager om){
		super(m,mh);
		this.mde=mde;
		this.name=nombre;
		this.setId(name);
		this.om=om;
		if (om==null)
			throw new RuntimeException("IDEState is null  in Model JGraph");
		creaToolBar();
		this.setBackground(Color.white);
		this.setTransferHandler(new CustomTransferHandler(om));
		// this.setTransferHandler(new RelationshipEntityTransferHandler());
	}
	
	public Model getMJGraph(){
		return (Model) this.getModel();
	}
	
	public abstract JGraph cloneJGraph(IDEState ids);
	
	
	public static ComponentUI createUI(JComponent jc){
		return new BasicGraphUI();
	}
	
	protected abstract void creaToolBar();
	
	public JToolBar getPaleta(){ return toolbar;}
	
	//	abstract public DefaultEdge getInstanciaRelacion(String relacion);
	
	public abstract DefaultGraphCell getInstanciaNRelacion(String relacion, GraphCell[] selected);
	
	public abstract DefaultGraphCell createCell(String entity) throws InvalidEntity;
	public abstract Dimension getDefaultSize(Entity entity) throws InvalidEntity;
	
	
	public Object[] getRelacionesPosibles(Port source, Port target) {
		// The general getRelacionesPosibles method only admits a GraphCell[] parameter.
		GraphCell sourceGraphCell = (GraphCell) this.getModel().getParent(source);
		GraphCell targetGraphCell = (GraphCell) this.getModel().getParent(target);
		// The general getRelacionesPosibles method is invoked.
		return this.getPossibleRelationships(new GraphCell[]{sourceGraphCell, targetGraphCell});
	}
	
	abstract public Object[] getPossibleRelationships(GraphCell[] selected);
	
	abstract public DefaultGraphCell insert(Point point, String entity) throws InvalidEntity;
	
	abstract public DefaultGraphCell insertDuplicated(Point point, ingenias.editor.entities.Entity entity);
	
	public String getID(){
		return this.mde.getId();
	}
	
	public void setId(String id){
		this.mde.setId(id);
	}
	
	public ModelDataEntity getProperties(){
		return mde;
	}
	protected Point convert(java.awt.geom.Point2D p2d){
		Point p=new Point((int)p2d.getX(),(int)p2d.getY());
		return p;
	}
	
	
	public VertexView createExternalVertexView(Object v, CellMapper cm){
		return null;
	}
	
	public static java.awt.Point findEmptyPlacePoint(Dimension dim, org.jgraph.JGraph model){
		int j=0;
		int y=30;
		boolean occupied=true;
		while (occupied){
			Rectangle2D clip=new Rectangle(new Point(j,y), dim);
			occupied=model.getGraphLayoutCache().getRoots(clip)!=null  && model.getGraphLayoutCache().getRoots(clip).length!=0;
			
			/*FirstCellForLocation(j, y)!=null ||
			 model.getFirstCellForLocation(j+20, y)!=null ||
			 model.getFirstCellForLocation(j, y+20)!=null ||
			 model.getFirstCellForLocation(j+20, y+20)!=null;*/
			if (occupied){
				j=(int) (j+dim.getWidth());
			}
			if (j>(model.getVisibleRect().x+model.getVisibleRect().width)){
				j=model.getVisibleRect().x;
				y=(int) (y+dim.getHeight());
			}
			
		}
		return new  java.awt.Point(j,y);
		
	}
	
	public static int findEmptyPlace(org.jgraph.JGraph model){
		int j=0;
		int y=30;
		boolean occupied=true;
		while (occupied){
			occupied=model.getFirstCellForLocation(j, y)!=null ||
			model.getFirstCellForLocation(j+20, y)!=null ||
			model.getFirstCellForLocation(j, y+20)!=null ||
			model.getFirstCellForLocation(j+20, y+20)!=null;
			if (occupied){
				j=j+10;
			}
			if (j>(model.getVisibleRect().x+model.getVisibleRect().width)){
				j=model.getVisibleRect().x;
				y=y+20;
			}
			
		}
		return j;
		
	}
	
	protected ObjectManager getOM() {
		return om;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}