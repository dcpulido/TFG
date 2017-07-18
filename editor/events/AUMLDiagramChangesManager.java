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

package ingenias.editor.events;

import ingenias.editor.cell.*;
import ingenias.editor.cell.auml.LifelineGroupCell;
import ingenias.editor.cell.auml.ProtocolGroupCell;
import ingenias.editor.entities.*;

import java.awt.*;

import javax.swing.*;
import javax.swing.plaf.basic.BasicMenuUI.ChangeHandler;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Hashtable;
import java.util.Set;
import java.util.Vector;

import org.jgraph.graph.*;
import org.jgraph.*;
import org.jgraph.event.*;


import ingenias.editor.ModelJGraph;
import ingenias.editor.ObservableModel;
import java.util.*;

/**
 *
 * Avoids that an entity gets outta of the screen.
 * It does so by setting X to 1 when X<0 and Y to 1 when Y<0
 *
 */
public class AUMLDiagramChangesManager
implements org.jgraph.event.GraphModelListener {

	public final int COL_SEPARATOR = 5;
	public static boolean enabled = true;
	JGraph graph;
	private Hashtable<Entity,DefaultGraphCell> userObjects = new Hashtable<Entity,DefaultGraphCell>();
	private Object workingObject = null;
	private boolean duringChange = false;
	private int cont=0;
	private int cont1=0;
	private Hashtable<Entity,Rectangle2D> cellLocation= new Hashtable<Entity,Rectangle2D>();
	Vector<ingenias.editor.events.ChangeHandler> eventprocessors = new Vector<ingenias.editor.events.ChangeHandler>();

	private void updateTable(GraphModelEvent gme) {
		if (gme.getChange().getInserted() != null) {
			for (int k = 0; k < gme.getChange().getInserted().length; k++) {
				DefaultGraphCell dgc = (DefaultGraphCell) gme.getChange().getInserted()[k];
				userObjects.put( (Entity)(dgc.getUserObject()), dgc);
				CellView[] views = this.graph.getGraphLayoutCache().getMapping(new Object[]{dgc});
				// cellLocation.put((Entity)(dgc.getUserObject()), views[0].getBounds());
			}
		}
		if (gme.getChange().getRemoved() != null) {
			for (int k = 0; k < gme.getChange().getRemoved().length; k++) {
				DefaultGraphCell dgc = (DefaultGraphCell) gme.getChange().getRemoved()[k];
				userObjects.remove(  dgc.getUserObject());
				cellLocation.remove( dgc.getUserObject());
			}
		}
	}

	public void portsToFront(ingenias.editor.Model m){
		Enumeration enumeration=userObjects.keys();
		Vector v=new Vector();
		while (enumeration.hasMoreElements()){
			Object current=enumeration.nextElement();
			if (current instanceof ingenias.editor.cell.AUMLPortCell){
				v.add(current);
			}
		}
		m.toFront(v.toArray());
	}

	public Enumeration getUserObjects() {
		return userObjects.keys();
	}

	public  static DefaultGraphCell getCellFromUserObject(Object obj, Object[] roots) {		
		DefaultGraphCell found=null;
		for (Object root:roots){
			if (root instanceof DefaultGraphCell){
				if (((DefaultGraphCell)root).getUserObject()!=null &&
						((DefaultGraphCell)root).getUserObject().equals(obj))
					found=(DefaultGraphCell)root;
				else {
					DefaultGraphCell temp = getCellFromUserObject(obj,((DefaultGraphCell) root).getChildren().toArray());
					if (temp!=null)
						found=temp;
				}
			}
		}
		return found;
	}



	public AUMLDiagramChangesManager(JGraph graph) {
		this.graph = graph;    
		//this.addEventProcessor(new ManageAlternatives(graph));
		//this.addEventProcessor(new ManageUseProtocol(graph));
		//this.addEventProcessor(new RemoveDependent(graph));
		//  this.addEventProcessor(new KeepLifeLineInsideProtocol(graph));
		//this.addEventProcessor(new CenterRelationships(graph));
		//this.addEventProcessor(new ResizeColumns(graph));
		//this.addEventProcessor(new MoveAlternatives(graph));
		//this.addEventProcessor(new MoveSubProtocol(graph));

		// this.addEventProcessor(new ChangeEntityLocation(graph));
		// this.addEventProcessor(new ResizeRelationships(graph));
	}

	public void translateCells(Object[] cells, Hashtable nested,double delayX, double delayY) {
		CellView[] views = graph.getGraphLayoutCache().getMapping(cells);
		Rectangle2D treeBounds = graph.getGraphLayoutCache().getBounds(views);
		if (treeBounds!=null){			
			for (int i = 0; i < cells.length; i++) {
				if (cells[i] instanceof DefaultGraphCell && graph.getAttributes(cells[i])!=null &&
						graph.getAttributes(cells[i]).get("bounds")!=null){
					Rectangle2D cellRect = (Rectangle2D)graph.getAttributes(cells[i]).get("bounds");
					Double newX = cellRect.getX() + delayX;
					Double newY = cellRect.getY() + delayY;
					Map map = ((DefaultGraphCell)cells[i]).getAttributes();
					GraphConstants.setBounds(map, new Rectangle2D.Double(newX, newY, cellRect.getWidth(), cellRect.getHeight()));		       
					nested.put(cells[i], map);
					translateCells(((DefaultGraphCell)cells[i]).getChildren().toArray(),nested,delayX,delayY);
				}
			}
		}

	} 

	public static DefaultGraphCell getCellExtreme(Object edge,
			ingenias.editor.Model m) {
		DefaultEdge de = (DefaultEdge) edge;

		DefaultGraphCell target = (DefaultGraphCell) ((DefaultPort) m
				.getTarget(de)).getParent();
		DefaultGraphCell source = (DefaultGraphCell) ((DefaultPort) m
				.getSource(de)).getParent();
		DefaultGraphCell nary = null;
		if (NAryEdge.class.isAssignableFrom(target.getClass())) {
			nary = source;
		}
		if (NAryEdge.class.isAssignableFrom(source.getClass())) {
			nary = target;
		}
		return nary;
	}


	public void graphChanged(final org.jgraph.event.GraphModelEvent gme) {
		Thread t=new Thread(){
			public void run(){
				if (!isSendUMLAdded(gme).isEmpty()){
					System.out.println("opcion3");
					Vector<AUMLSendSimpleEdge> messages = isSendUMLAdded(gme);
					ParentMap pm=new ParentMap(); 
					for (AUMLSendSimpleEdge message:messages){
						if (message.getParent()==null){
							Iterator nedges = ((ingenias.editor.Model)graph.getModel()).getEdges(graph.getModel(), new Object[] { message }).iterator();
							Vector points = new Vector();
							// First a gross estimation of the middle point is obtained
							while (nedges.hasNext()) {
								DefaultEdge edgeline = (DefaultEdge) nedges.next();
								DefaultGraphCell extreme = getCellExtreme(edgeline, (ingenias.editor.Model)graph.getModel());
								System.err.println("en "+extreme);
								while (extreme.getParent()!=null){
									System.err.println("en "+extreme);
									extreme=(DefaultGraphCell) extreme.getParent();
								}
								pm.addEntry(message, extreme);
								System.err.println("agregando "+extreme.getClass().getName());

							}
						}

					}
					if (pm.size()>0){
						graph.getGraphLayoutCache().edit(null, null, pm, null);
						SwingUtilities.invokeLater(new Runnable(){
							public void run(){
								graph.repaint();
							}
						});
					}
				} else
				if (!getLifelineModified(gme).isEmpty()){
					System.err.println("opcion 1");
					boolean changed=false;
					Vector<LifelineGroupCell> modified = getLifelineModified(gme);
					LifelineGroupCell ll = modified.firstElement();
					ProtocolGroupCell protocolCell=(ProtocolGroupCell) ll.getParent();			
					AttributeMap attsLL = ll.getAttributes();				
					AttributeMap attsProt = protocolCell.getAttributes();
					Rectangle2D sizeProt = GraphConstants.getBounds(attsProt);
					Rectangle2D sizeLL = GraphConstants.getBounds(attsLL);
					Hashtable changes=new Hashtable();
					if (sizeLL.getMinY()!=sizeProt.getMinY()+40){
						translateCells(new Object[]{ll},changes,0,(sizeProt.getMinY()+40)-sizeLL.getMinY());
						System.out.println("cambio 1");
						changed=true;
					} else 						
						if (sizeLL.getMaxX()>sizeProt.getMaxX()){								
							CellView[] views = graph.getGraphLayoutCache().getMapping(new Object[]{ll});
							translateCells(new Object[]{ll},changes, (sizeProt.getMaxX()-10)-sizeLL.getMaxX(), 0);
							changed=true;
							System.out.println("cambio 2");
						} else								
							if (sizeLL.getMinX()<sizeProt.getMinX()){									
								translateCells(new Object[]{ll},changes,(sizeProt.getMinX()+10)- sizeLL.getMinX(), 0);
								changed=true;
								System.out.println("cambio 3");
							}



					if (changed){
						graph.getGraphLayoutCache().edit(changes, null, null, null);
						SwingUtilities.invokeLater(new Runnable(){
							public void run(){
								graph.repaint();
							}
						});
					}
					System.err.println("fin opcion 1");
					Object[] roots = graph.getRoots();

					if (roots.length>0)
						for(Object root:roots){
							if (root instanceof ProtocolGroupCell)
								graph.getGraphLayoutCache().toBack(new Object[]{root});
						}

				} else 
					if (!getProtocolModified(gme).isEmpty() ){						
						System.err.println("fin opcion 2");
						Object[] roots = graph.getRoots();

						for(Object root:roots){
							if (root instanceof ProtocolGroupCell)
								graph.getGraphLayoutCache().toBack(new Object[]{root});
						}

					} else 
						if (!getNewLifelineAdded(gme).isEmpty()){
							// Do nothing
						} else 
							if (!getNewAlternativeAdded(gme).isEmpty()){
								// Do nothing								
							}  
								 else 

									if (!isSendUMLModified(gme).isEmpty()){
										Vector<AUMLSendSimpleEdge> messages = isSendUMLModified(gme);	
										Hashtable changes=new Hashtable();
										for (AUMLSendSimpleEdge message:messages){
											if (message.getParent()!=null){
												System.err.println("opcion4");
												AttributeMap atts=message.getAttributes();
												Set<DefaultEdge> nedges = ((ingenias.editor.Model)graph.getModel()).getEdges(graph.getModel(), new Object[] { message });
												DefaultEdge edge1=(DefaultEdge) nedges.toArray()[0];
												DefaultEdge edge2=(DefaultEdge) nedges.toArray()[1];
												DefaultGraphCell extreme1 = getCellExtreme(edge1, (ingenias.editor.Model)graph.getModel());
												AttributeMap attsExt1 = extreme1.getAttributes();
												Rectangle2D locaExt1 = GraphConstants.getBounds(attsExt1);
												DefaultGraphCell extreme2 = getCellExtreme(edge2, (ingenias.editor.Model)graph.getModel());
												AttributeMap attsExt2 = extreme2.getAttributes();
												Rectangle2D locaExt2 = GraphConstants.getBounds(attsExt2);

												Rectangle nrect = (Rectangle) GraphConstants.getBounds(atts);
												Point oldLoc = nrect.getLocation();
												Point nloc=new Point(
														(int)((locaExt1.getMinX()+locaExt2.getMinX())/2),
														(int)((locaExt1.getMinY()+locaExt2.getMinY())/2));
												if (!nloc.equals(oldLoc)){
													nrect.setLocation(nloc);
													GraphConstants.setBounds(atts,nrect);
													changes.put(message,atts);
												}
											}
											if (changes.size()>0){
												graph.getGraphLayoutCache().edit(changes, null, null, null);
												SwingUtilities.invokeLater(new Runnable(){
													public void run(){
														graph.repaint();
													}
												});
											}
										}
									}
			}

			private void reallocateColumn(Lifeline ll, Rectangle2D sizeLL, Hashtable changes) {
				Column col=(Column) ll.getChildrenElements().nextElement();
				ColumnCell colCell=(ColumnCell) getCellFromUserObject(col,graph.getRoots());
				AttributeMap colAtts = colCell.getAttributes();
				Rectangle2D colLoc = GraphConstants.getBounds(colAtts);
				colLoc.setRect(sizeLL.getCenterX()-colLoc.getWidth()/2,sizeLL.getMaxY(),colLoc.getWidth(),colLoc.getHeight());
				GraphConstants.setBounds(colAtts, colLoc);
				changes.put(colCell,colAtts);
			}

			private Vector<AUMLSendSimpleEdge> isSendUMLAdded(GraphModelEvent gme) {				
				Object[] newElements = gme.getChange().getInserted();
				boolean found=false;
				Vector<AUMLSendSimpleEdge> result=new Vector<AUMLSendSimpleEdge>(); 
				Object o;
				if (newElements!=null)
					for (int k=0;k<newElements.length && !found;k=k+1){
						o=newElements[k];
						found=found|| (o instanceof AUMLSendSimpleEdge);
						if (found)
							result.add((AUMLSendSimpleEdge) o);
					}
				return result;
			}

			private Vector<AUMLSendSimpleEdge> isSendUMLModified(GraphModelEvent gme) {				
				Object[] newElements = gme.getChange().getChanged();
				boolean found=false;
				Vector<AUMLSendSimpleEdge> result=new Vector<AUMLSendSimpleEdge>(); 
				Object o;
				if (newElements!=null)
					for (int k=0;k<newElements.length && !found;k=k+1){
						o=newElements[k];
						found=found|| (o instanceof AUMLSendSimpleEdge);
						if (found)
							result.add((AUMLSendSimpleEdge) o);
					}
				return result;
			}

			private Vector<AUMLAlternativeBoxCell> getNewAlternativeAdded(GraphModelEvent gme) {
				Object[] newElements = gme.getChange().getInserted();
				boolean found=false;
				Vector<AUMLAlternativeBoxCell> result=new Vector<AUMLAlternativeBoxCell>(); 
				Object o;
				if (newElements!=null)
					for (int k=0;k<newElements.length && !found;k=k+1){
						o=newElements[k];
						found=found|| (o instanceof AUMLAlternativeBoxCell);
						if (found)
							result.add((AUMLAlternativeBoxCell) o);
					}
				return result;
			}

			private Vector<LifelineCell> getNewLifelineAdded(GraphModelEvent gme) {
				Object[] newElements = gme.getChange().getInserted();
				boolean found=false;
				Vector<LifelineCell> result=new Vector<LifelineCell>(); 
				Object o;
				if (newElements!=null)
					for (int k=0;k<newElements.length && !found;k=k+1){
						o=newElements[k];
						found=found|| (o instanceof LifelineCell);
						if (found)
							result.add((LifelineCell) o);
					}
				return result;
			}

			private Vector<ProtocolCell> getProtocolModified(GraphModelEvent gme) {
				Object[] newElements = gme.getChange().getChanged();
				boolean found=false;
				Vector<ProtocolCell> result=new Vector<ProtocolCell>();
				Object o;
				if (newElements!=null)
					for (int k=0;k<newElements.length && !found;k=k+1){
						o=newElements[k];
						found=found || (o instanceof ProtocolCell);
						if (found)
							result.add((ProtocolCell) o);
					}
				return result;
			}

			private Vector<LifelineGroupCell> getLifelineModified(GraphModelEvent gme) {
				Object[] newElements = gme.getChange().getChanged();
				boolean found=false;
				Vector<LifelineGroupCell> result=new Vector<LifelineGroupCell>(); 
				Object o;
				if (newElements!=null)
					for (int k=0;k<newElements.length && !found;k=k+1){
						o=newElements[k];						
						found=found|| (o instanceof LifelineGroupCell);
						if (found)
							result.add((LifelineGroupCell) o);
					}
				return result;
			};
		};
		t.start();

	}

}
