/*
 Copyright (C) 2002 Jorge Gomez Sanz, Ruben Fuentes
 Modifications over original code from jgraph.sourceforge.net
 This file is part of INGENIAS IDK, a support tool for the INGENIAS
 methodology, availabe at http://grasia.fdi.ucm.es/ingenias or
 http://ingenias.sourceforge.net
 INGENIAS IDK is free software; you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation; either version 2 of the License, or
 (at your option) any later version.
 INGENIAS IDK is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.
 You should have received a copy of the GNU General Public License
 along with INGENIAS IDK; if not, write to the Free Software
 Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package ingenias.editor;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.event.*;
import java.util.*;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;
import java.util.Map;
import java.util.Hashtable;
import java.util.ArrayList;
import javax.swing.event.UndoableEditEvent;
import org.jgraph.JGraph;
import org.jgraph.graph.*;
import org.jgraph.event.*;

import java.util.Vector;
import org.jgraph.JGraph;
import org.jgraph.graph.*;
import org.jgraph.event.*;
import org.jgraph.plaf.basic.*;

import com.languageExplorer.widgets.ScrollableBar;

import ingenias.editor.entities.*;
import ingenias.editor.cell.*;
import ingenias.editor.models.*;
//import ingenias.editor.auml.*;
import ingenias.exception.*;
import ingenias.generator.browser.Browser;
import ingenias.generator.browser.BrowserImp;

import java.io.*;
import java.awt.geom.*;

public class Editor
extends JPanel
implements GraphSelectionListener, java.io.Serializable {

	/*public void setCommonButtons(ButtonToolBar commonButtons) {
		this.commonButtons = commonButtons;
	}*/

	public JPanel getUpperSidePanel() {
		return upperSidePanel;
	}

	// JGraph instance
	/**
	 *  Description of the Field
	 */


	private JTabbedPane graphPanel;

	// Undo Manager
	/**
	 *  Description of the Field
	 */
	protected GraphUndoManager undoManager;

	private JPanel gpan, upperSidePanel;

	protected ObjectManager om = null;

	//	public static final ingenias.editor.events.ChangeNARYEdgeLocation relationshipLocationListener=new ingenias.editor.events.ChangeNARYEdgeLocation();

	protected JComponent modelToolBar = null;
	//	protected ButtonToolBar commonButtons = null;

	public static int idCounter = 0;

	// To make "cut" action not to delete until pasted
	public static final int COPIED = 0;
	public static final int PASTED = 1;
	public static final int NONE = 2;
	public static final int CUT = 3;

	private Preferences prefs;

	private static int state = NONE;

	private AUMLInsertOperations auml=new AUMLInsertOperations();

	private GraphManager gm;

	private Vector<GraphModelListener> graphModelListeners=new 
	Vector<GraphModelListener>();


	public void addGraphModelListener(GraphModelListener gl){
		graphModelListeners.add(gl);
	};

	public static String getNewId(ObjectManager om, GraphManager gm) {
		idCounter=0;

		Vector<NAryEdgeEntity> rels;

		rels = RelationshipManager.getRelationshipsVector(gm);
		HashSet<String> trels=new HashSet<String> ();
		for (NAryEdgeEntity nedge:rels){
			trels.add(nedge.getId());						
		}


		while (trels.contains(""+idCounter) || 
				om.findUserObject(""+idCounter).size()>0 ||
				gm.getModel(""+idCounter)!=null){
			idCounter++;
		}


		return ""+idCounter;
	}
	
	public static String getNewId(Browser browser) {
		return getNewId(browser.getState().om,browser.getState().gm);
	}

	public JTabbedPane getGraphPanel(){
		return graphPanel;
	}

	public void addTabSelectorChangeListener(javax.swing.event.ChangeListener cl){
		graphPanel.addChangeListener(cl);
	}

	//
	// Editor Panel
	//

	// Construct an Editor Panel
	/**
	 *  Constructor for the Editor object
	 */
	public Editor(ObjectManager om, GraphManager gm, Preferences prefs) {
		this.om = om;
		this.gm=gm;
		this.prefs=prefs;
		graphPanel = new JTabbedPaneWithCloseIcons();
		System.err.println(graphPanel.getUI().getClass().getName());
		//graphPanel.setUI(new JTabbedPaneWithCloseIconsUI());
		graphPanel.setName("DiagramsPanel");		
		// Use Border Layout
		setLayout(new BorderLayout());
		// Construct the Graph
		//		graph = new JGraph(new Model(), new MarqueeHandler(this));

		// Construct Command History
		//
		// Create a GraphUndoManager which also Updates the ToolBar
		undoManager =
			new GraphUndoManager() {
			// Override Superclass
			/**
			 *  Description of the Method
			 *
			 *@param  e  Description of Parameter
			 */
			public void undoableEditHappened(UndoableEditEvent e) {
				// First Invoke Superclass
				super.undoableEditHappened(e);
				// Then Update Undo/Redo Buttons
				//updateHistoryButtons();
			}
		};

		// Construct Panel
		//
		// Add a ToolBar
		upperSidePanel = new JPanel();
		upperSidePanel.setLayout(new GridLayout(1, 1));
		//commonButtons = createToolBar();
		//upperSidePanel.add(commonButtons);
		add(upperSidePanel, BorderLayout.NORTH);
		// Add the Graph as Center Component
		this.addTabSelectorChangeListener(new ChangeListener(){

			public void stateChanged(ChangeEvent e) {
				if (graphPanel.getSelectedComponent()!=null){
					graphPanel.getSelectedComponent().invalidate();
					graphPanel.getSelectedComponent().validate();
					graphPanel.getSelectedComponent().repaint();
				}

			}

		});
		add(graphPanel, BorderLayout.CENTER);




	}

	public void closeTab(String name) {
		int size = graphPanel.getTabCount();
		int k = 0;
		String title = "";
		while (k < size && !title.equals(name)) {
			title = graphPanel.getTitleAt(k);
			if (!title.equals(name)) {
				k++;
			}
		}
		System.err.println("trying to remove "+k+" "+graphPanel.getTabCount());
		if (k < size) {
			graphPanel.removeTabAt(k);
			System.err.println("Removed "+k+" "+graphPanel.getTabCount());
		}
	}

	public ModelJGraph getGraph() {
		if (graphPanel.getTabCount()>0){
			JScrollPane comp=(JScrollPane)(graphPanel.getComponentAt(graphPanel.getSelectedIndex()));
			//System.err.println(comp);
			/*if (comp!=null)
			System.err.println("view:"+comp.getViewport().getView());*/
			if (comp!=null && comp.getViewport().getView()!=null){
				//System.err.println(comp.getViewport().getView().getClass().getName());
				return (ModelJGraph)(comp.getViewport().getView());
			} /*else {
			throw new RuntimeException("getGraph returned a null object. This will cause bad behaviors");			
		}
		} else 
			throw new RuntimeException("getGraph returned a null object because there is no graph stored in the editor. This will cause bad behaviors");*/
		} 
		return null;
	}

	// This method can be invoked by pressing the project tree and the state
	// change listener (when the tab changes)
	public synchronized void changeGraph(ModelJGraph graph) {		
		if (graph != null) {
			graph.setPortsVisible(true);

			if (this.graphPanel.indexOfTab(graph.getID()) < 0) {
				this.graphPanel.addTab(graph.getID(),  ProjectTreeRenderer.selectIconByUserObject(graph),new JScrollPane(graph));
				graph.getModel().addGraphModelListener(new GraphModelListener(){
					public void graphChanged(GraphModelEvent e) {
						selectedGraphModelHasChanged(e);
					}
				});
			}
		}

		this.graphPanel.setSelectedIndex(this.graphPanel.indexOfTab(graph.getID()));
		updateBars(graph);

	}


	protected void selectedGraphModelHasChanged(GraphModelEvent e) {
		for (GraphModelListener gml:this.graphModelListeners){
			gml.graphChanged(e);			
		}
	}

	// This method can be invoked by pressing the project tree and the state
	// change listener (when the tab changes)
	public synchronized boolean isOpened(ModelJGraph graph) {

		return 
		(this.graphPanel.indexOfTab(graph.getID()) >= 0);
	}



	public synchronized Vector<String> getOpenedDiagrams(){
		Vector<String> result=new Vector<String>();
		for (int k=0;k<this.graphPanel.getTabCount();k++){
			result.add(this.graphPanel.getTitleAt(k));	
		}
		return result;
	}



	private void updateBars(ModelJGraph graph) {


		// Add Listeners to Graph
		//
		// Register UndoManager with the Model
		GraphModel gm = graph.getModel();
		gm.addUndoableEditListener(undoManager);
		// Update ToolBar based on Selection Changes
		graph.getSelectionModel().addGraphSelectionListener(this);

		// Listen for Delete Keystroke when the Graph has Focus

		// Construct Panel
		//
		// Add a ToolBar
		//		gpan.setLayout(new GridLayout(1,1));
		//		gpan.add(graph);
		upperSidePanel.validate();
		if (this.getTopLevelAncestor()!=null){
			this.getTopLevelAncestor().repaint();
			this.getTopLevelAncestor().validate();
		}
		GraphLayoutCacheListener obs = new ingenias.editor.events.GraphViewChange( (Model) graph.
				getModel());
		//		gpan.setLayout(new GridLayout(1,1));
		//		gpan.add(graph);
		if (graph != null) {
			graph.getGraphLayoutCache().removeGraphLayoutCacheListener(obs);
			graph.getGraphLayoutCache().addGraphLayoutCacheListener(obs);
		}
		this.invalidate();
		this.validate();
		repaint();
		System.gc();
	}

	// Determines if a Cell is a Group
	/**
	 *  Gets the group attribute of the Editor object
	 *
	 *@param  cell  Description of Parameter
	 *@return       The group value
	 */
	public boolean isGroup(Object cell) {
		// Map the Cell to its View
		CellView view = getGraph().getGraphLayoutCache().getMapping(cell, false);
		if (view != null) {
			return!view.isLeaf();
		}
		return false;
	}

	// Insert a new Vertex at point
	/**
	 *  Description of the Method
	 *
	 *@param  point   Description of Parameter
	 *@param  entity  Description of Parameter
	 * @throws InvalidEntity 
	 */
	public void insert(Point point, String entity) throws InvalidEntity {
		DefaultGraphCell newCell;
		/*if (getGraph() instanceof AUMLInteractionDiagramModelJGraph){
			this.auml.insert(point, entity, (ModelJGraph)getGraph(),ids);
		} else {*/
		System.err.println("----------------intentando insertando ----------------");
		newCell=getGraph().insert(point, entity);
		Entity newEntity=(Entity) newCell.getUserObject();
		if (prefs.getModelingLanguage()==Preferences.ModelingLanguage.UML)
			newEntity.getPrefs().setView(ViewPreferences.ViewType.UML);
		if (prefs.getModelingLanguage()==Preferences.ModelingLanguage.INGENIAS)
			newEntity.getPrefs().setView(ViewPreferences.ViewType.INGENIAS);
		System.err.println("----------------insertando ----------------");
		//}		

	}

	public DefaultGraphCell insertDuplicated(Point point, ingenias.editor.entities.Entity
			entity) {

		return getGraph().insertDuplicated(point, entity);

	}

	// Associate the NAryEdge Vertex with its Attributes.
	private Hashtable nEdgeAttributes(NAryEdge nEdge, Point pt) {
		// Create a Map that holds the attributes for the NAryEdge Vertex.
		Map map = new Hashtable();
		// Snap the Point to the Grid.
		Point2D point = getGraph().snap(pt);
		//		GraphConstants.setFontSize(map, 12f);
		//		GraphConstants.setFontName(map, "monospaced");
		// Default Size for the new Vertex.
		/*    Font f = GraphConstants.getFont(map);

		 Dimension size = new Dimension(
		 this.getFontMetrics(f).stringWidth(nEdge.getUserObject().toString())
		 , 20);

		 // Add a Bounds Attribute to the Map.*/
		GraphConstants.setMoveable(map, true);
		GraphConstants.setSizeable(map,true);
		// Construct a Map from cells to Maps (for insert).
		Hashtable attributes = new Hashtable();
		// Associate the NAryEdge Vertex with its Attributes.
		attributes.put(nEdge, map);
		return attributes;
	}




	// Create a Group that Contains the Cells
	/**
	 *  Description of the Method
	 *
	 *@param  cells  Description of Parameter
	 */
	/*public void group(Object[] cells) {
	 // Order Cells by View Layering
	  cells = graph.getGraphLayoutCache().order(cells);
	  // If Any Cells in View
	   if (cells != null && cells.length > 0) {
	   // Create Group Cell
	    int count = getCellCount(graph);
	    DefaultGraphCell group = new DefaultGraphCell(new Integer(count
	    - 1));
	    // Create Change Information
	     java.util.HashMap map = new HashMap();
	     // Insert Child Parent Entries
	      for (int i = 0; i > cells.length; i++) {
	      map.put(cells[i], group);
	      }
	      // Insert into model
	       graph.getModel().insert(new Object[] {group}
	       , map, null,null,null);
	       }
	       }*/

	// Ungroup the Groups in Cells and Select the Children
	/**
	 *  Description of the Method
	 *
	 *@param  cells  Description of Parameter
	 */
	public void ungroup(Object[] cells) {
		// If any Cells
		if (cells != null && cells.length > 0) {
			// List that Holds the Groups
			ArrayList groups = new ArrayList();
			// List that Holds the Children
			ArrayList children = new ArrayList();
			// Loop Cells
			for (int i = 0; i < cells.length; i++) {
				// If Cell is a Group
				if (isGroup(cells[i])) {
					// Add to List of Groups
					groups.add(cells[i]);
					// Loop Children of Cell
					for (int j = 0; j < getGraph().getModel().getChildCount(cells[i]); j++) {
						// Get Child from Model
						Object child = getGraph().getModel().getChild(cells[i], j);
						// If Not Port
						if (! (child instanceof Port)) {
							// Add to Children List
							children.add(child);
						}
					}
				}
			}
			// Remove Groups from Model (Without Children)
			//graph.getModel().remove(groups.toArray());
			// Select Children
			//graph.setSelectionCells(children.toArray());
		}
	}

	// Brings the Specified Cells to Front
	/**
	 *  Description of the Method
	 *
	 *@param  c  Description of Parameter
	 */
	public void toFront(Object[] c) {
		if (c != null && c.length > 0) {
			getGraph().getGraphLayoutCache().toFront(getGraph().getGraphLayoutCache().getMapping(c));
		}
	}

	// Sends the Specified Cells to Back
	/**
	 *  Description of the Method
	 *
	 *@param  c  Description of Parameter
	 */
	/*public void toBack(Object[] c) {
		if (c != null && c.length > 0) {
			getGraph().getGraphLayoutCache().toBack(((JGraph)getGraph()).getMapping(c));
		}
	}*/

	// Undo the last Change to the Model or the View
	/**
	 *  Description of the Method
	 */
	public void undo() {
		try {
			undoManager.undo(getGraph().getGraphLayoutCache());
		}
		catch (Exception ex) {
			System.err.println(ex);
		}
		finally {
			//	updateHistoryButtons();
		}
	}

	// Redo the last Change to the Model or the View
	/**
	 *  Description of the Method
	 */
	public void redo() {
		try {
			undoManager.redo(getGraph().getGraphLayoutCache());
		}
		catch (Exception ex) {
			System.err.println(ex);
		}
		finally {
			//	updateHistoryButtons();
		}
	}

	//
	// Listeners
	//

	// From GraphSelectionListener Interface
	/**
	 *  Description of the Method
	 *
	 *@param  e  Description of Parameter
	 */
	public void valueChanged(GraphSelectionEvent e) {
		// Group Button only Enabled if more than One Cell Selected
		//		group.setEnabled(graph.getSelectionCount() > 1);
		// Update Button States based on Current Selection
		boolean enabled = !getGraph().isSelectionEmpty();
		/*	if (this.commonButtons!=null)
		this.commonButtons.getRemove().setEnabled(enabled);*/
		//		ungroup.setEnabled(enabled);
		//		tofront.setEnabled(enabled);
		//		toback.setEnabled(enabled);
		//copy.setEnabled(enabled);
		//cut.setEnabled(enabled);
	}


	// End of Editor.MyMarqueeHandler



	// Returns the total number of cells in a graph
	/**
	 *  Gets the cellCount attribute of the Editor object
	 *
	 *@param  graph  Description of Parameter
	 *@return        The cellCount value
	 */
	protected int getCellCount(JGraph graph) {
		Object[] cells = graph.getDescendants(graph.getRoots());
		return cells.length;
	}

	// Update Undo/Redo Button State based on Undo Manager
	/**
	 *  Description of the Method
	 */


	//
	// Main
	//

	// Main Method
	/**
	 *  The main program for the Editor class
	 *
	 *@param  args  The command line arguments
	 */
	public static void main(String[] args) {
		// Construct Frame
		JFrame frame = new JFrame("GraphEd");
		// Set Close Operation to Exit
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Add an Editor Panel
		frame.getContentPane().add(new Editor(null,null,null));
		// Fetch URL to Icon Resource
		URL jgraphUrl =
			Editor.class.getClassLoader().getResource("images/jgraph.gif");
		// If Valid URL
		if (jgraphUrl != null) {
			// Load Icon
			ImageIcon jgraphIcon = new ImageIcon(jgraphUrl);
			// Use in Window
			frame.setIconImage(jgraphIcon.getImage());
		}
		// Set Default Size
		frame.setSize(520, 390);
		// Show Frame
		frame.show();
	}




	private void hideRoleLabels() {
		Object[] cells = this.getGraph().getSelectionCells();
		if (cells == null || cells.length == 0) {
			cells = this.getGraph().getRoots();
		}
		for (int k = 0; k < cells.length; k++) {
			Object gc = cells[k];

			if (gc instanceof DefaultEdge) {

				RoleEntity r = (RoleEntity) ( (org.jgraph.graph.DefaultEdge) gc).
				getUserObject();
				r.hide();
			}
		}
		this.getGraph().repaint();
	}

	private void showRoleLabels() {
		Object[] cells = this.getGraph().getSelectionCells();
		if (cells == null || cells.length == 0) {
			cells = this.getGraph().getRoots();
		}
		for (int k = 0; k < cells.length; k++) {
			Object gc = cells[k];
			if (gc instanceof DefaultEdge) {
				RoleEntity r = (RoleEntity) ( (org.jgraph.graph.DefaultEdge) gc).
				getUserObject();
				r.show(r.getAttributeToShow() + 1);

			}
		}

		this.getGraph().repaint();
	}

	/*	public JComboBox getJC(){
		if (this.commonButtons!=null)
		return this.commonButtons.getJc();
		else 
			return null;
	}*/

	public void enableAutomaticLayout() {
		if (this.getGraph()!=null){
			GraphModelListener[] gml = ( (DefaultGraphModel)this.getGraph().getModel()).
			getGraphModelListeners();
			for (int k = 0; k < gml.length; k++) {
				if (ingenias.editor.events.ChangeNARYEdgeLocation.class.isAssignableFrom(
						gml[k].getClass())) {
					( (ingenias.editor.events.ChangeNARYEdgeLocation) gml[k]).
					enableAutomaticAllocation();
				}
				if (ingenias.editor.events.ChangeEntityLocation.class.isAssignableFrom(
						gml[k].getClass())) {
					( (ingenias.editor.events.ChangeEntityLocation) gml[k]).
					enableAutomaticAllocation();
				}

			}
		}

	}

	public void disableAutomaticLayout() {
		if (this.getGraph()!=null){
			GraphModelListener[] gml = ( (DefaultGraphModel)this.getGraph().getModel()).
			getGraphModelListeners();
			for (int k = 0; k < gml.length; k++) {
				if (ingenias.editor.events.ChangeNARYEdgeLocation.class.isAssignableFrom(
						gml[k].getClass())) {
					( (ingenias.editor.events.ChangeNARYEdgeLocation) gml[k]).
					disableAutomaticAllocation();
				}
				if (ingenias.editor.events.ChangeEntityLocation.class.isAssignableFrom(
						gml[k].getClass())) {
					( (ingenias.editor.events.ChangeEntityLocation) gml[k]).
					disableAutomaticAllocation();
				}


			}
		}
	}

	//	Funciones especificas del modelo

	public JToolBar creaPaleta() {
		if (getGraph() != null) {
			return getGraph().getPaleta();
		}
		else {
			return new JToolBar();
		}
	}

	//	******************************************************************
	//	NUEVOS
	//	******************************************************************

	/*  Description of the Method
	 *
	 *@param  nEdge               Description of Parameter
	 *@param  selected            Description of Parameter
	 *@param  currentAssignation  Description of Parameter
	 */
	/*	private void insertRelationshipInManager(NAryEdge nEdge, GraphCell[] selected, java.util.List currentAssignation) {
	 // The NAryEdgeEntity of the relationship is built.
	  NAryEdgeEntity nae = (NAryEdgeEntity) nEdge.getUserObject();
	  for (int i = 0; i < currentAssignation.size(); i++) {
	  if (!(((DefaultGraphCell) selected[i]).getUserObject() instanceof NAryEdgeEntity)) {
	  nae.addObject( ((Entity)( (DefaultGraphCell) selected[i] ).getUserObject()),
	  ((RoleEntity)edges[i].getUserObject()),
	  (String) currentAssignation.get(i),
	  ( ( (DefaultGraphCell) selected[i] ).getUserObject().getClass().getName() ));
	  nae.addObject((Entity) ((DefaultGraphCell) selected[i]).getUserObject(),
	  (String) currentAssignation.get(i),
	  (((DefaultGraphCell) selected[i]).getUserObject().getClass().getName()));
	  }
	  }
	  // Insert the Edge in the relationship manager.
	   // this.rm.addRelationship((Entity) nEdge.getUserObject());
	    }*/

	/**
	 *  Gets the ports attribute of the Editor object
	 *
	 *@param  vertexList  Description of Parameter
	 *@param  portsList   Description of Parameter
	 *@return             The ports value
	 */
	public Port[] getPorts(Object[] vertexList, Map portsList) {

		// Ports of argument vertexs.
		Port[] ports = new Port[vertexList.length];
		// Obtain the model.
		GraphModel model = getGraph().getModel();

		// Iterate over all Objects.
		for (int i = 0; i < vertexList.length; i++) {
			Port objectPort = null;
			if (portsList.get(vertexList[i]) != null &&
					portsList.get(vertexList[i])instanceof Port) {
				objectPort = (Port) portsList.get(vertexList[i]);
			}
			else {
				// Iterate over all Children
				for (int j = 0; j < model.getChildCount(vertexList[i]); j++) {
					// Fetch the Child of Vertex at Index i
					Object child = model.getChild(vertexList[i], j);
					// Check if Child is a Port
					if (child instanceof Port) {
						// Return the Child as a Port
						objectPort = (Port) child;
					}
				}
			}

			ports[i] = objectPort;
		}

		return ports;
	}



	public void writeObject(ObjectOutputStream s) throws IOException {

	}

	public void reloadDiagrams() {		

		JScrollPane comp=null;
		for (int k=0;k<this.graphPanel.getTabCount();k++){
			comp=(JScrollPane)(graphPanel.getComponentAt(k));

			if (comp!=null)
				System.err.println(comp.getClass().getName());
			if (comp!=null && comp.getViewport().getView()!=null){
				//System.err.println(comp.getViewport().getView().getClass().getName());
				ModelJGraph mjg=(ModelJGraph)(comp.getViewport().getView());
				graphPanel.setTitleAt(k, mjg.getName())	;
				System.err.println("cambiando titulo a "+mjg.getName());
			} 
		}
		graphPanel.invalidate();
		graphPanel.repaint();		
	}


}
