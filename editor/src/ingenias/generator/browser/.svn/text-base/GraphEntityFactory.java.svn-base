package ingenias.generator.browser;
/*
 Copyright (C) 2005 Jorge Gomez Sanz
 
 This file is part of INGENIAS Development Kit (IDK), a support tool for the INGENIAS
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
 along with IDK; if not, write to the Free Software
 Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 
 */
import ingenias.editor.Editor;
import ingenias.editor.IDE;
import ingenias.editor.IDEState;
import ingenias.editor.Log;
import ingenias.editor.Model;
import ingenias.editor.ModelJGraph;
import ingenias.editor.ObjectManager;
import ingenias.editor.TypedVector;
import ingenias.editor.cell.NAryEdge;
import ingenias.editor.cell.RenderComponentManager;
import ingenias.editor.entities.Entity;
import ingenias.editor.entities.NAryEdgeEntity;
import ingenias.editor.entities.RoleEntity;
import ingenias.exception.InvalidAttribute;
import ingenias.exception.InvalidColection;
import ingenias.exception.InvalidEntity;
import ingenias.exception.InvalidGraph;
import ingenias.exception.NotInitialised;
import ingenias.exception.NullEntity;
import ingenias.exception.WrongParameters;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;

import javax.swing.JOptionPane;

import org.jgraph.JGraph;
import org.jgraph.graph.BasicMarqueeHandler;
import org.jgraph.graph.ConnectionSet;
import org.jgraph.graph.DefaultEdge;
import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.GraphCell;
import org.jgraph.graph.GraphConstants;
import org.jgraph.graph.GraphModel;
import org.jgraph.graph.Port;

public class GraphEntityFactory {
	private IDEState ids;
	
	public static GraphEntityFactory createDefaultEmptyGraphFactory(){
		return new GraphEntityFactory(IDEState.emptyIDEState());
	}
	
	public static GraphEntityFactory createDefaultGraphFactory(Browser browser) throws NotInitialised{
		return new GraphEntityFactory(browser.getState());
	}
	
	public GraphEntityFactory(IDEState ids){
		this.ids=ids;	
	}
	

	
	private boolean isGraphicalEntity(String entType){
		try {
			Class renderer=Class.forName("ingenias.editor.cell."+entType+"Renderer");
			return true;
		} catch (ClassNotFoundException e) {
			return false;
		}
		
	}
	
	public void removeEntity(String id)  throws InvalidEntity{
		Vector result=this.ids.om.findUserObject(id);
		if (result.size()>0){
			this.ids.om.removeEntity((Entity) result.firstElement());
			System.err.println("removed "+id);
		}
		
	}

	

	public  GraphEntity reuseEntity(String id,Graph diagram) throws InvalidEntity{
		try {
			if (this.ids.om.findUserObject(id).size()==0){
				throw new InvalidEntity();
			}
			Entity result= (Entity) this.ids.om.findUserObject(id).firstElement();
			//((GraphEntityImp)BrowserImp.getInstance().findEntity(id)).getEntity();
			GraphEntityImp gei=new GraphEntityImp(result,((GraphImp)diagram).getGraph(),ids);
			if (this.isGraphicalEntity(result.getType())){
				
				ModelJGraph jg=((GraphImp)diagram).getGraph();
				
				Rectangle visible = new Rectangle(new Point(0,0),jg.getSize());
				
				Point cpoint=new Point(visible.x,visible.y);
				
				boolean found=true;
				while (found){
					while (found && cpoint.x<600) {
						cpoint.x = cpoint.x + 20;
						found= jg.getFirstCellForLocation(cpoint.x, cpoint.y)!=null
						|| jg.getFirstCellForLocation(cpoint.x+40, cpoint.y)!=null
						|| jg.getFirstCellForLocation(cpoint.x+40, cpoint.y+40)!=null
						|| jg.getFirstCellForLocation(cpoint.x, cpoint.y+40)!=null;									
					}
					if (found){ 
						cpoint.y = cpoint.y + 20;
						cpoint.x=0;
					}
					
				}
				
				if (found)
					cpoint=new Point(0,0);
				
				DefaultGraphCell cell = jg.insertDuplicated(cpoint,(Entity)result);
			}
			
			return gei; 
		} catch (NullEntity e) {

			e.printStackTrace();
			throw new InvalidEntity();
		} catch (SecurityException e) {

			e.printStackTrace();
			throw new InvalidEntity();
		} catch (IllegalArgumentException e) {

			e.printStackTrace();
			throw new InvalidEntity();
		}
	}

	public  GraphEntity createEntity(String entType, String id,Graph diagram) throws InvalidEntity{
		try {
			Method m = ids.om.getClass().getMethod("create"+entType,new Class[]{String.class});
			Entity result=(Entity)(m.invoke(ids.om,new Object[]{id}));
		
			if (this.isGraphicalEntity(entType)){
				
				ModelJGraph jg=((GraphImp)diagram).getGraph();
				
				Rectangle visible = new Rectangle(new Point(0,0),jg.getSize());
				
				Point cpoint=new Point(visible.x,visible.y);
				
				boolean found=true;
				while (found){
					while (found && cpoint.x<600) {
						cpoint.x = cpoint.x + 20;
						found= jg.getFirstCellForLocation(cpoint.x, cpoint.y)!=null
						|| jg.getFirstCellForLocation(cpoint.x+40, cpoint.y)!=null
						|| jg.getFirstCellForLocation(cpoint.x+40, cpoint.y+40)!=null
						|| jg.getFirstCellForLocation(cpoint.x, cpoint.y+40)!=null;									
					}
					if (found){ 
						cpoint.y = cpoint.y + 20;
						cpoint.x=0;
					}
					
				}
				
				if (found)
					cpoint=new Point(0,0);
				
				DefaultGraphCell cell = jg.insertDuplicated(cpoint,(Entity)result);
			}
			GraphEntityImp gei=new GraphEntityImp(result,((GraphImp)diagram).getGraph(),ids);
			
			return gei; 
		} catch (NullEntity e) {

			e.printStackTrace();
			throw new InvalidEntity();
		} catch (SecurityException e) {

			e.printStackTrace();
			throw new InvalidEntity();
		} catch (NoSuchMethodException e) {

			e.printStackTrace();
			throw new InvalidEntity();
		} catch (IllegalArgumentException e) {

			e.printStackTrace();
			throw new InvalidEntity();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
			throw new InvalidEntity();
		} catch (InvocationTargetException e) {

			e.printStackTrace();
			throw new InvalidEntity();
		}
	}

	public Entity createEntityWithoutDiagram(String entType, String id) {
		Method m;
		try {
			m = ids.om.getClass().getMethod("create"+entType,new Class[]{String.class});
			Entity result=(Entity)(m.invoke(ids.om,new Object[]{id}));
			return result;
		} catch (SecurityException e) {
			
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	
}
