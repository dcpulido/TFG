/*
 *  Copyright (C) 2002 Jorge Gomez Sanz
 *  This file is part of INGENIAS IDE, a support tool for the INGENIAS
 *  methodology, availabe at http://grasia.fdi.ucm.es/ingenias or
 *  http://ingenias.sourceforge.net
 *  INGENIAS IDE is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *  INGENIAS IDE is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU General Public License
 *  along with INGENIAS IDE; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package ingenias.generator.browser;

import ingenias.editor.GUIResources;
import ingenias.editor.IDEState;
import ingenias.exception.NullEntity;

import java.util.*;
import java.io.*;

/**
 *  Implements a Singleton pattern to gain global access to diagrams contained
 *  in a file
 *
 *@author     Jorge J. Gomez-Sanz
 *@created    30 November 2003
 */
public class BrowserImp implements Browser {

	private static Browser browser = null;
	private ingenias.editor.IDEState ids;
        File currentProject=null;

	/**
	 *  Constructor for the BrowserImp object
	 */
	/*private BrowserImp() {
		ids=ingenias.editor.IDEAbs.ide.ids;
				
	}*/
	
	
	public BrowserImp(IDEState ids) {
		this.ids=ids;
		if (ids==null)
			throw new RuntimeException("The ids parameter cannot be null");
	}


	/**
	 *  Constructor for the BrowserImp object
	 *
	 *@param  file           Description of Parameter
	 *@exception  Exception  Description of Exception
	 */
	private BrowserImp(String file) throws ingenias.exception.UnknowFormat, ingenias.exception.DamagedFormat, ingenias.exception.CannotLoad{
		
		ingenias.editor.persistence.PersistenceManager p = new ingenias.editor.persistence.PersistenceManager();
		ids=IDEState.emptyIDEState();
		p.load(file, new GUIResources(),new Properties(),ids);
		/*ingenias.editor.GraphManager.updateCopy(ids.gm);
		ingenias.editor.ObjectManager.updateCopy(ids.om);*/
		
          this.currentProject=new File(file);
	}



	/**
	 *  Obtains all existing graphs
	 *
	 *@return    The graphs value
	 */
	public Graph[] getGraphs() {
		ingenias.editor.GraphManager gm = ids.gm;
		Vector models = gm.getUOModels();
		Graph[] gs = new Graph[models.size()];
		Iterator it = models.iterator();
		int k = 0;
		while (it.hasNext()) {
			ingenias.editor.ModelJGraph model = (ingenias.editor.ModelJGraph) it.next();
			gs[k] = new GraphImp(model,ids);
			k++;
		}

		return gs;
	}


	/**
	 *  Gets the allEntities attribute of the BrowserImp object
	 *
	 *@return    The allEntities value
	 */
	public GraphEntity[] getAllEntities() {
		Graph[] gs = this.getGraphs();
		HashSet entities = new HashSet();
		for (int k = 0; k < gs.length; k++) {
			Graph current = gs[k];
			GraphEntity[] ges=null;
			try {
				ges = current.getEntities();
			} catch (NullEntity e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < ges.length; i++) {
				entities.add(ges[i]);
			}
		}
		Object[] temp = entities.toArray();
		GraphEntity[] result = new GraphEntity[temp.length];
		System.arraycopy(temp, 0, result, 0, temp.length);
		return result;
	}


	// Obtains a graph with a concrete id. If there is no any, it returns null
	/**
	 *  Gets the graph attribute of the BrowserImp object
	 *
	 *@param  id  Description of Parameter
	 *@return     The graph value
	 */
	public Graph getGraph(String id) {
		ingenias.editor.GraphManager gm = ids.gm;
		ingenias.editor.ModelJGraph mg = (ingenias.editor.ModelJGraph) gm.getModel(id);
		if (mg != null) {
			return new GraphImp(mg, ids);
		} else {
			return null;
		}
	}


	/**
	 *  Obtains an instance
	 *
	 *@return    The instance value
	 */
	/*public static Browser getInstance()  throws ingenias.exception.NotInitialised{
		if (browser == null) {
			throw new ingenias.exception.NotInitialised("Browser not initialised. You must call \"initialise\" first");
		} else {
			return browser;
		}
	}*/


	/**
	 *  Initialises the diagram browser with a INGENIAS specification file
	 *
	 *@param  file           Description of Parameter
	 *@exception  Exception  Description of Exception
	 */
	public static Browser initialise(String file) throws
             ingenias.exception.UnknowFormat,
             ingenias.exception.DamagedFormat,
             ingenias.exception.CannotLoad {
                
		browser = new BrowserImp(IDEState.emptyIDEState());
		
		browser = new BrowserImp(file);
		return browser;
                
	}


	/**
         *  Performs an empty initialisation. Only works when there is an already existing
         *  instance of GraphManager
	 *
	 *@exception  Exception  Description of Exception
	 */
	/*public static void initialise() {
		ingenias.editor.GraphManager.getInstance();
		// To check if it is initialised
		browser = new BrowserImp();
		
	}*/
	

	/**
         *  Performs an empty initialisation. Only works when there is an already existing
         *  instance of GraphManager
	 *
	 *@exception  Exception  Description of Exception
	 */
	public static void initialise(IDEState ids) {
		
		// To check if it is initialised
		browser = new BrowserImp(ids);
		
	}
	
	public GraphEntity findEntity(String id){
		GraphEntity[] ents=this.getAllEntities();
		boolean found=false;
		int k=0;
		for (k=0;k<ents.length &&!found;k++){
			found=ents[k].getID().equals(id);
		}
		if (found)
			return ents[k-1];
		else 
			return null;
	}
	
	public ingenias.editor.IDEState getState(){
		return this.ids;
	}
	
	public Graph findFirstEntityOccurrence(String id){
		Graph[] gs=this.getGraphs();
		boolean found=false;
		Graph result=null;
		for (int k=0;k<gs.length && result==null;k++){
			GraphEntity[] entities;
			try {
				entities = gs[k].getEntities();
				for (int j=0;j<entities.length && result==null;j++){
					if (entities[j].getID().equalsIgnoreCase(id)){
						result=gs[k];
					}
				}
			} catch (NullEntity e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
			return result;
		
	}
        
        public File getProjectFilePath(){
            return this.currentProject;
        }



	/**
	 *  Description of the Method
	 *
	 *@param  args           Description of Parameter
	 *@exception  Exception  Description of Exception
	 */
	public static void main(String args[]) throws Exception {
		String file = args[0];
		Browser b = new BrowserImp(file);
		Graph[] gs = b.getGraphs();
		for (int k = 0; k < gs.length; k++) {
			System.err.println(gs[k].getType() + ":" + gs[k].getName());
		}
	}

}
