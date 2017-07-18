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
import ingenias.editor.CommonMenuEntriesActionFactory;
import ingenias.editor.cell.NAryEdge;
import ingenias.editor.entities.Entity;
import ingenias.editor.entities.RoleEntity;
import ingenias.editor.widget.GraphicsUtils;
import ingenias.exception.NotInitialised;
import ingenias.exception.NullEntity;
import ingenias.generator.browser.BrowserImp;
import ingenias.generator.browser.Graph;
import ingenias.generator.browser.GraphEntity;
import ingenias.generator.browser.GraphRelationship;
import ingenias.generator.browser.GraphRelationshipImp;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.Map;
import java.util.Hashtable;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.event.UndoableEditEvent;
import javax.swing.tree.TreePath;

import org.jgraph.JGraph;
import org.jgraph.graph.*;
import org.jgraph.event.*;
import java.util.Vector;
import org.jgraph.JGraph;
import org.jgraph.graph.*;
import org.jgraph.event.*;
import org.jgraph.plaf.basic.*;

//MarqueeHandler that Connects Vertices and Displays PopupMenus


public class MarqueeHandler extends BasicMarqueeHandler  implements java.io.Serializable {


	/*  public Preferences getPref() {
		return pref;
	}*/


	// Holds the Start and the Current Point
	/**
	 *  Description of the Field
	 */
	protected Point start, current;

	// Holds the First and the Current Port
	/**
	 *  Description of the Field
	 */
	protected PortView port, firstPort;

	private ModelJGraph graph;

	private Vector<AbstractAction> additionalActions=new Vector<AbstractAction>(); 
	private CommonMenuEntriesActionFactory af;
	private DiagramMenuEntriesActionsFactory daf;

	private GUIResources resources;

	public MarqueeHandler(ModelJGraph graph, GUIResources resources, IDEState ids, DiagramMenuEntriesActionsFactory daf){
		this.graph=graph;
		this.af=new CommonMenuEntriesActionFactory(resources,ids);
		this.daf=daf;
		this.resources=resources;
	}

	public void addContextualMenuAction(AbstractAction action){
		additionalActions.add(action);
	}


	protected Point convert(java.awt.geom.Point2D p2d){
		Point p=new Point((int)p2d.getX(),(int)p2d.getY());
		return p;
	}

	public static ingenias.editor.cell.NAryEdge getNAryEdge(GraphModel m,DefaultEdge de){
		DefaultPort sourcePort = (DefaultPort) ( (Edge) de).getSource();
		Object source = m.getParent(sourcePort);
		Port targetPort = (Port) ( (Edge) de).getTarget();
		Object target = m.getParent(targetPort);

		if (source instanceof NAryEdge) {
			return (NAryEdge) source;
		}
		if (target instanceof NAryEdge) {
			return (NAryEdge) target;
		}
		return null;

	}

	// Find a Cell at point and Return its first Port as a PortView
	/**
	 *  Gets the targetPortAt attribute of the MarqueeHandler object
	 *
	 *@param  point  Description of Parameter
	 *@return        The targetPortAt value
	 */
	protected PortView getTargetPortAt(Point point) {
		// Find Cell at point (No scaling needed here)
		Object cell = getGraph().getFirstCellForLocation(point.x, point.y);
		// Loop Children to find PortView
		for (int i = 0; i < getGraph().getModel().getChildCount(cell); i++) {
			// Get Child from Model
			Object tmp = getGraph().getModel().getChild(cell, i);
			// Get View for Child using the Graph's View as a Cell Mapper
			tmp = getGraph().getGraphLayoutCache().getMapping(tmp, false);
			// If Child View is a Port View and not equal to First Port
			if (tmp instanceof PortView && tmp != firstPort) {
				// Return as PortView
				return (PortView) tmp;
			}
		}
		// No Port View found
		return getSourcePortAt(point);
	}


	// Use Xor-Mode on getGraph()ics to Paint Connector
	/**
	 *  Description of the Method
	 *
	 *@param  fg  Description of Parameter
	 *@param  bg  Description of Parameter
	 *@param  g   Description of Parameter
	 */
	protected void paintConnector(Color fg, Color bg, Graphics g) {
		// Set Foreground
		g.setColor(fg);
		// Set Xor-Mode Color
		//g.setXORMode(bg);
		// Highlight the Current Port
		paintPort(getGraph().getGraphics());
		// If Valid First Port, Start and Current Point
		if (firstPort != null && start != null && current != null) {
			// Then Draw A Line From Start to Current Point
			g.drawLine(start.x, start.y, current.x, current.y);
		}
	}


	// Use the Preview Flag to Draw a Highlighted Port
	/**
	 *  Description of the Method
	 *
	 *@param  g  Description of Parameter
	 */
	protected void paintPort(Graphics g) {
		// If Current Port is Valid
		if (port != null) {
			// If Not Floating Port...
			boolean o = (GraphConstants.getOffset(port.getAttributes()) != null);
			// ...Then use Parent's Bounds
			Rectangle r = (o) ? port.getBounds().getBounds() : port.getParentView().getBounds().getBounds();
			// Scale from Model to Screen
			r = getGraph().toScreen(new Rectangle(r)).getBounds();
			// Add Space For the Highlight Border
			r.setBounds(r.x - 3, r.y - 3, r.width + 6, r.height + 6);
			// Paint Port in Preview (=Highlight) Mode
			getGraph().getUI().paintCell(g, port, r, true);
		}
	}

	protected ModelJGraph getGraph(){
		return graph;
	}

	// Override to Gain Control (for PopupMenu and ConnectMode)
	/**
	 *  Gets the forceMarqueeEvent attribute of the MarqueeHandler object
	 *
	 *@param  e  Description of Parameter
	 *@return    The forceMarqueeEvent value
	 */
	public boolean isForceMarqueeEvent(MouseEvent e) {
		// If Right Mouse Button we want to Display the PopupMenu
		if (SwingUtilities.isRightMouseButton(e)) {
			// Return Immediately
			return true;
		}
		// Find and Remember Port
		port = getSourcePortAt(e.getPoint());
		// If Port Found and in ConnectMode (=Ports Visible)
		if (port != null && getGraph().isPortsVisible()) {
			return true;
		}
		// Else Call Superclass
		return super.isForceMarqueeEvent(e);
	}


	/**
	 *  Gets the sourcePortAt attribute of the MarqueeHandler object
	 *
	 *@param  point  Description of Parameter
	 *@return        The sourcePortAt value
	 */
	public PortView getSourcePortAt(Point point) {
		// Scale from Screen to Model
		Point tmp = convert(getGraph().fromScreen(new Point(point)));
		// Find a Port View in Model Coordinates and Remember
		return getGraph().getPortViewAt(tmp.x, tmp.y);
	}


	// Display PopupMenu or Remember Start Location and First Port
	/**
	 *  Description of the Method
	 *
	 *@param  e  Description of Parameter
	 */
	public void mousePressed(final MouseEvent e) {
		
		// If Right Mouse Button
		if (SwingUtilities.isRightMouseButton(e)) {
			// Scale From Screen to Model
			Point loc = convert(getGraph().fromScreen(e.getPoint()));
			// Find Cell in Model Coordinates
			Object cell = getGraph().getFirstCellForLocation(loc.x, loc.y);

			JPopupMenu menu=new JPopupMenu();
		
			if (cell instanceof DefaultEdge){
				menu.add("Relationship");
				menu.addSeparator();
				NAryEdge nary=this.getNAryEdge((Model)(getGraph().getModel()),(DefaultEdge)cell);
				createRelationshipMenu(menu, nary);	
			} 			
			else
				if (cell instanceof NAryEdge){
					menu.add("Relationship");
					menu.addSeparator();
					NAryEdge nary=(NAryEdge)cell;
					createRelationshipMenu(menu, nary);	
				} 

				else {
					if (cell instanceof DefaultGraphCell){
						// Create PopupMenu for the Cell
						menu.add("Entity");
						menu.addSeparator();
						addActionsToPopupMenu(menu,af.createCellActions((DefaultGraphCell)cell, getGraph()));				
						menu.addSeparator();
						menu.add(createMenu("Views",daf.createChangeViewActions((DefaultGraphCell)cell, getGraph())));
						final ingenias.editor.entities.Entity ent=((ingenias.editor.entities.Entity)((DefaultGraphCell)cell).getUserObject());
						Vector<AbstractAction> actions = af.createEntityActions(ent);
						for (AbstractAction action:actions){
							menu.add(action);
						}                        
						menu.add(createMenu("Refinement",af.createCellRefinementActions(ent)));
					} else {
						if (getGraph().getSelectionCells()!=null && getGraph().getSelectionCells().length>1){
							GraphCell[] gc=new GraphCell[getGraph().getSelectionCells().length];
							System.arraycopy(getGraph().getSelectionCells(),0,gc,0,gc.length);
							addActionsToPopupMenu(menu,af.createDiagramIndependentActions(e.getPoint(),
									gc, getGraph()));
						}
						addActionsToPopupMenu(menu,af.createDiagramOperations(getGraph()));
						menu.addSeparator();
						addActionsToPopupMenu(menu,daf.createDiagramSpecificInsertActions(e.getPoint(),graph));	
					}
				}


			// Display PopupMenu
			menu.show(getGraph(), e.getX(), e.getY());

			// Else if in ConnectMode and Remembered Port is Valid
		}
		else if (port != null && !e.isConsumed() && getGraph().isPortsVisible()) {
			// Remember Start Location
			start = convert(getGraph().toScreen(port.getLocation(null)));
			// Remember First Port
			firstPort = port;
			// Consume Event
			e.consume();
		
		}
		else {
			// Call Superclass

		}
		super.mousePressed(e);		
	}


	private void createRelationshipMenu(JPopupMenu menu, NAryEdge nary) {
		String typeOfRelationship=((ingenias.editor.entities.NAryEdgeEntity)nary.getUserObject()).getType();
		Vector<String> roles=new Vector<String>(nary.getRoles());
		addActionsToPopupMenu(menu,af.createCellActions(nary, getGraph()));		
		menu.addSeparator();
		menu.add(createMenu("views",daf.createChangeViewActions(nary, graph)));

		for (int k=0;k<roles.size();k++){
			DefaultEdge[] edgesPerRole=nary.getRoleEdges(roles.elementAt(k));					
			if (edgesPerRole.length>1){
				for (int j=0;j<edgesPerRole.length;j++){
					Vector<AbstractAction> edgeMenuActions = af.createEdgeActions(
							nary.getRoleEdges(roles.elementAt(k))[j], getGraph());
					menu.add(createMenu("role:"+roles.elementAt(k),edgeMenuActions));
				}
			} else {
				if (edgesPerRole.length==1){
					Vector<AbstractAction> edgeMenuActions = af.createEdgeActions(nary.getRoleEdges(roles.elementAt(k))[0], getGraph());
					menu.add(createMenu("role:"+roles.elementAt(k),edgeMenuActions));
				} 
			}


		}
	}


	private JMenu createMenu(String name, Vector<AbstractAction> actions) {
		Iterator<AbstractAction> it=actions.iterator();
		JMenu menu=new JMenu(name);
		while (it.hasNext()){
			menu.add(it.next());
		}
		// TODO Auto-generated method stub
		return menu;
	}


	private void addActionsToPopupMenu(JPopupMenu menu, Vector<AbstractAction> actions) {
		Iterator<AbstractAction> it=actions.iterator();
		while (it.hasNext()){
			menu.add(it.next());
		}
	}





	// Find Port under Mouse and Repaint Connector
	/**
	 *  Description of the Method
	 *
	 *@param  e  Description of Parameter
	 */
	public void mouseDragged(MouseEvent e) {
		// If remembered Start Point is Valid
		if (start != null && !e.isConsumed()) {
			// Fetch getGraph()ics from Graph
			Graphics g = getGraph().getGraphics();
			// Xor-Paint the old Connector (Hide old Connector)
			paintConnector(Color.black, getGraph().getBackground(), g);
			// Reset Remembered Port
			port = getTargetPortAt(e.getPoint());
			// If Port was found then Point to Port Location
			if (port != null) {
				current = convert(getGraph().toScreen(port.getLocation(null)));
			}
			// Else If no Port was found then Point to Mouse Location
			else {
				current = convert(getGraph().snap(e.getPoint()));
			}
			// Xor-Paint the new Connector
			paintConnector(getGraph().getBackground(), Color.black, g);
			// Consume Event
			e.consume();
		}
		// Call Superclass
		super.mouseDragged(e);
	}


	// Connect the First Port and the Current Port in the Graph or Repaint
	/**
	 *  Description of the Method
	 *
	 *@param  e  Description of Parameter
	 */
	public void mouseReleased(MouseEvent e) {
		// If Valid Event, Current and First Port
		if (e != null && !e.isConsumed() && port != null && firstPort != null &&
				firstPort != port) {
			final PortView firstPortBackup=firstPort;
			final PortView portBackup=port;
			Runnable connectThread=new Runnable(){
				public void run(){
					// Then Establish Connection
					RelationshipManager.connect((Port) firstPortBackup.getCell(), (Port) portBackup.getCell(),graph);					
				}
			};
			SwingUtilities.invokeLater(connectThread);
			// Consume Event
			e.consume();
			// Else Repaint the Graph
		}
		// Reset Global Vars
		firstPort = port = null;
		start = current = null;
		// Call Superclass
		super.mouseReleased(e);
		if (getGraph()!=null){
			
			getGraph().invalidate();
			getGraph().revalidate();
		   getGraph().repaint();
		}
	}


	// Show Special Cursor if Over Port
	/**
	 *  Description of the Method
	 *
	 *@param  e  Description of Parameter
	 */
	public void mouseMoved(MouseEvent e) {		
		// Check Mode and Find Port
		if (e != null && getGraph()!=null && getSourcePortAt(e.getPoint()) != null &&
				!e.isConsumed() && getGraph().isPortsVisible()) {
			// Set Cusor on Graph (Automatically Reset)
			getGraph().setCursor(new Cursor(Cursor.HAND_CURSOR));
			// Consume Event
			e.consume();
		}
		// Call Superclass
		super.mouseReleased(e);
	}






}
