package ingenias.editor;
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
import java.awt.geom.Rectangle2D;
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
import ingenias.editor.entities.*;
import ingenias.editor.cell.*;
import ingenias.editor.cell.auml.ColumnGroupCell;
import ingenias.editor.cell.auml.LifelineGroupCell;
import ingenias.editor.cell.auml.ProtocolGroupCell;
import ingenias.editor.events.*;
import java.util.*;
public class AUMLInsertOperations {

	private Lifeline locateLifeline(Column col, ModelJGraph m) {
		Lifeline result = null;
		for (int k = 0; k < m.getModel().getRootCount(); k++) {
			if (m.getModel().getRootAt(k)instanceof LifelineCell) {
				LifelineCell llc = (LifelineCell) m.getModel().getRootAt(k);
				Lifeline ll = (Lifeline) llc.getUserObject();
				Enumeration enume = ll.getChildrenElements();
				while (enume.hasMoreElements()) {
					Object current = enume.nextElement();
					if (col.equals(current)) {
						return ll;
					}
				}
			}
		}
		return result;
	}

	public DefaultGraphCell insert(Point point, String entity, ModelJGraph model, IDEState ids) {
		boolean canIInsert = true;
		// Create a Map that holds the attributes for the Vertex
		Map map = new Hashtable();
		// Snap the Point to the Grid
		point = model.convert(model.snap(new Point(point)));

		// Construct Vertex with no Label
		DefaultGraphCell vertex = null;
		Dimension size = null;

		if (entity.equalsIgnoreCase("Protocol")) {
			vertex = new
			ProtocolCell(ids.om.createProtocol( ((Model)model.getModel()).getNewId("Protocol")));
			vertex.removeAllChildren();
			// Default Size for the new Vertex
			size = new Dimension(300, 250);
			// Add a Bounds Attribute to the Map
			GraphConstants.setBounds(map, new Rectangle(new Point(0,0), size));
			GraphConstants.setSizeable(map, false);
			GraphConstants.setSelectable(map, false);
			//GraphConstants.setMoveable(map, false);

			// GraphConstants.setAbsolute(map, false);
			// Construct a Map from cells to Maps (for insert)
			Hashtable attributes = new Hashtable();
			// Associate the Vertex with its Attributes
			attributes.put(vertex, map);

			model.getModel().insert(attributes.keySet().toArray()
					, attributes
					, null, null, null); // To ensure that grouped object exist
			attributes=new Hashtable();
			ParentMap pm=new ParentMap();
			ProtocolGroupCell pgroup=new ProtocolGroupCell();
			pgroup.add(vertex);
			pm.addEntry(vertex,pgroup);
			Hashtable gatts= new Hashtable();
			GraphConstants.setBounds(gatts, new Rectangle(point, size));			  
			GraphConstants.setSizeable(gatts, false);


			attributes.put(pgroup,gatts);
			// Insert the Vertex and its Attributes
			model.getModel().insert(attributes.keySet().toArray()
					, attributes
					, null, pm, null);

		}
		else

			if (entity.equalsIgnoreCase("Lifeline")) {
				Object[] selectedCells = model.getSelectionCells();
				canIInsert = (selectedCells.length == 1 && (
						selectedCells[0] instanceof ingenias.editor.cell.auml.ProtocolGroupCell));
				if (canIInsert) {
					ProtocolGroupCell protocolGroupCell = ((ingenias.editor.cell.auml.ProtocolGroupCell) selectedCells[0]);

					ProtocolCell protocolcell = (ProtocolCell) protocolGroupCell.getChildAt(0);

					Protocol selectedProtocol = ( (Protocol) protocolcell.getUserObject());
					int portCount = 1;
					int initialColHeight=20;

					if (selectedProtocol.getChildrenElements().hasMoreElements()) {
						Lifeline previousLL = (Lifeline) selectedProtocol.getChildrenElements().
						nextElement();
						portCount = countPorts( (Column) previousLL.getChildrenElements().
								nextElement());
						Column otherCol = (Column) previousLL.getChildrenElements().
						nextElement();
						DefaultGraphCell otherColCell = AUMLDiagramChangesManager.getCellFromUserObject(otherCol, model.getRoots());

						initialColHeight =(int) GraphConstants.getBounds(otherColCell.getAttributes()).getHeight();

					}

					Lifeline ll = ids.om.createLifeline( ((Model)model.getModel()).getNewId("Lifeline"));

					ll.setParent(selectedProtocol);
					selectedProtocol.addChildren(ll);

					// constrained to a selected protocol
					vertex = new
					LifelineCell(ll);
					vertex.removeAllChildren();
					Hashtable attributes = new Hashtable();



					//Setting location and size attributes of lifeline, columns, and ports

					size = new Dimension(100,50);
					Rectangle protocolB = GraphConstants.getBounds(protocolcell.
							getAttributes()).getBounds();
					Point origPoint = new Point(protocolB.getLocation().x + 10,
							protocolB.getLocation().y + 40);

					ParentMap pm=new ParentMap();


					Object cell1 = model.getFirstCellForLocation(origPoint.x,
							origPoint.y + 2);
					Object cell2 = model.getFirstCellForLocation(origPoint.x + size.width,
							origPoint.y + 2);
					Object cell3 = model.getFirstCellForLocation(origPoint.x +
							size.width / 2, origPoint.y + 2);

					Object lastCell = null;
					boolean found = false;
					while (!found) {
						found = (cell1 == null && cell2 == null && cell3 == null) ||
						(cell1 instanceof ProtocolCell &&
								cell2 instanceof ProtocolCell &&
								cell3 instanceof ProtocolCell);

						if (!found) {
							origPoint.x = origPoint.x + 40;
							cell1 = model.getNextCellForLocation(cell1, origPoint.x,
									origPoint.y + 2);
							cell2 = model.getNextCellForLocation(cell2, origPoint.x + size.width,
									origPoint.y + 2);
							cell3 = model.getNextCellForLocation(cell3,
									origPoint.x + size.width / 2,
									origPoint.y + 2);
						}
					}

					DefaultGraphCell colCell = this.createCol(portCount, (LifelineCell) vertex,ll,origPoint,size, attributes,initialColHeight,pm);

					GraphConstants.setBounds(map,
							new Rectangle(origPoint, size));

					/*
					 */
					 model.getModel().toBack(selectedCells);
					// Construct a Map from cells to Maps (for insert)

					// Associate the Vertex with its Attributes
					attributes.put(vertex, map);


					// Insert the Vertex and its Attributes

					LifelineGroupCell group=new LifelineGroupCell();


					pm.addEntry(group,protocolGroupCell)  ;     
					pm.addEntry(vertex, group);
					pm.addEntry(colCell, group);



					Hashtable groupatts=new Hashtable();

					GraphConstants.setBounds(groupatts,  new Rectangle(origPoint, size).union((Rectangle) GraphConstants.getBounds((Map) attributes.get(colCell))));
					GraphConstants.setChildrenSelectable(groupatts,  false);


					attributes.put(group,groupatts);		  


					model.getModel().insert(attributes.keySet().toArray()
							, attributes
							, null,pm, null);

					attributes=new Hashtable();
					AttributeMap attsProt = protocolGroupCell.getAttributes();
					AttributeMap attsProtCell=protocolcell.getAttributes();

					Rectangle2D origLoc = GraphConstants.getBounds(attsProt);
					origLoc.setFrame(origLoc.getMinX(),origLoc.getMinY(), Math.max(origLoc.getWidth(),Math.abs(origLoc.getMinX()-origPoint.getX()-size.width)),origLoc.getHeight());		       

					GraphConstants.setBounds(attsProt,origLoc );
					GraphConstants.setBounds(attsProtCell,origLoc);
					attributes.put(protocolcell,attsProtCell);
					attributes.put( protocolGroupCell,attsProt);

					model.getModel().edit(attributes, null,null, null);
					model.getGraphLayoutCache().toFront(new Object[]{group});



				}
			}
			else
				if (entity.equalsIgnoreCase("Column")) {
					// Cannot be inserted
					vertex = new
					ColumnCell(ids.om.createColumn(((Model)model.getModel()).getNewId("Column")));
					// Default Size for the new Vertex
					size = ColumnView.getSize();
					// Add a Bounds Attribute to the Map
					GraphConstants.setBounds(map, new Rectangle(point, size));

				}
				else
					if (entity.equalsIgnoreCase("AUMLAlternativeBox")) {
						vertex = new
						AUMLAlternativeBoxCell(ids.om.createAUMLAlternativeBox(
								((Model)model.getModel()).getNewId( "AUMLAlternativeBox")));
						// Default Size for the new Vertex
						size = AUMLAlternativeBoxView.getSize();
						// Add a Bounds Attribute to the Map
						GraphConstants.setBounds(map, new Rectangle(point, size));
						// Construct a Map from cells to Maps (for insert)
						Hashtable attributes = new Hashtable();
						// Associate the Vertex with its Attributes
						attributes.put(vertex, map);
						// Insert the Vertex and its Attributes
						model.getModel().insert(new Object[] {vertex}
						, attributes
						, null, null, null);

					}
					else

						if (entity.equalsIgnoreCase("AUMLAlternativeRow")) {
							Object[] selectedCells = model.getSelectionCells();
							canIInsert = (selectedCells.length == 1 && (
									selectedCells[0] instanceof ingenias.editor.cell.
									AUMLAlternativeBoxCell));
							if (canIInsert) {
								AUMLAlternativeBoxCell aabc = (AUMLAlternativeBoxCell) selectedCells[0];
								AUMLAlternativeBox aab = (AUMLAlternativeBox) aabc.getUserObject();

								AUMLAlternativeRow aar = ids.om.createAUMLAlternativeRow(
										((Model)model.getModel()).getNewId("AUMLAlternativeRow"));

								AUMLAlternativeRowCell aarc = new AUMLAlternativeRowCell(aar);
								aarc.removeAllChildren();

								Enumeration enume = aab.getChildrenElements();
								AUMLAlternativeRow current = (AUMLAlternativeRow) enume.nextElement();
								enume = current.getChildrenElements();
								Vector columns = new Vector();
								Vector newColumns = new Vector();
								Vector newColumnsCell = new Vector();
								Hashtable newElements = new Hashtable();

								while (enume.hasMoreElements()) {

									Column existentColumn = (Column) enume.nextElement();
									Column col = ids.om.createColumn(((Model)model.getModel()).getNewId("Column"));
									ColumnCell cc = new ColumnCell(col);
									cc.removeAllChildren();
									Lifeline ll = this.locateLifeline(existentColumn,model);

									int insertIndex = this.getInsertionIndex(ll, aab);

									ll.insertChildrenAt(insertIndex, col);
									col.setParent(ll);
									aar.addChildren(col);

									Point lastColPos = getLastColPos(aab, ll,model);

									AUMLPort aumlp = ids.om.createAUMLPort(((Model)model.getModel()).getNewId("port"));
									AUMLPortCell aumlpc = new AUMLPortCell(aumlp);
									col.addChildren(aumlp);
									aumlp.setParent(col);

									Map m = new Hashtable();
									/*          GraphConstants.setBounds(m,
		                                             new Rectangle(lastColPos,
		               new Dimension(30, 15)));*/
									newElements.put(cc, m);
									m = new Hashtable();
									/*          GraphConstants.setBounds(m,
		                                             new Rectangle(lastColPos,
		               new Dimension(30, 15)));*/
									newElements.put(aumlpc, m);

									newColumnsCell.add(cc);
									newColumnsCell.add(aumlpc);
								}

								aab.addChildren(aar); // I add the row after the loop
								// so that inside, the last row is the one containing
								// columns
								aar.setParent(aab);

								Map m = new Hashtable();
								GraphConstants.setBounds(m,
										this.computeAlternativeRowSize(aar,
												model));
								newElements.put(aarc, m);
								newColumnsCell.add(aarc);

								size = AUMLAlternativeRowView.getSize();
								GraphConstants.setBounds(map, new Rectangle(point, size));

								model.getModel().insert(newColumnsCell.toArray()
										, newElements
										, null, null, null);

							}

						}
						else

							if (entity.equalsIgnoreCase("TextNote")) {

								vertex = new
								TextNoteCell(ids.om.createTextNote( ((Model)model.getModel()).getNewId("TextNote")));
								// Default Size for the new Vertex
								size = TextNoteView.getSize();
								// Add a Bounds Attribute to the Map
								GraphConstants.setBounds(map, new Rectangle(point, size));
								// Construct a Map from cells to Maps (for insert)
								Hashtable attributes = new Hashtable();
								// Associate the Vertex with its Attributes
								attributes.put(vertex, map);
								// Insert the Vertex and its Attributes
								model.getModel().insert(new Object[] {vertex}
								, attributes
								, null, null, null);

							}
							else

							{
								// Add a Bounds Attribute to the Map

								vertex = new DefaultGraphCell();
								// Default Size for the new Vertex
								size = new Dimension(0, 0);
								// Add a Bounds Attribute to the Map
								GraphConstants.setBounds(map, new Rectangle(point, size));

							}
		return vertex;

	}

	private int getInsertionIndex(Lifeline ll, AUMLAlternativeBox aab) {
		Enumeration rows = aab.getChildrenElements();
		AUMLContainer last = null;
		int insertionPoint = -1;
		while (rows.hasMoreElements()) {
			last = (AUMLContainer) rows.nextElement();
		}
		Enumeration cols = last.getChildrenElements();
		boolean found = false;
		Column col = null;
		while (cols.hasMoreElements() && insertionPoint == -1) {
			col = (Column) cols.nextElement();
			insertionPoint = ll.containsChildren(col);
		}

		if (insertionPoint != -1) {
			return insertionPoint + 1;
		}
		else {
			return insertionPoint;
		}

	}

	private Rectangle computeAlternativeRowSize(AUMLAlternativeRow ar,
			JGraph model) {

		Enumeration enume = ar.getChildrenElements();
		Rectangle rect = new Rectangle();
		rect.x = Integer.MAX_VALUE;
		rect.y = Integer.MAX_VALUE;
		rect.width = Integer.MIN_VALUE;
		rect.height = Integer.MIN_VALUE;
		while (enume.hasMoreElements()) {
			Column col = (Column) enume.nextElement();
			ColumnCell cc = (ColumnCell) AUMLDiagramChangesManager.
			getCellFromUserObject(col, model.getRoots());
			if (cc != null && cc.getAttributes() != null &&
					GraphConstants.getBounds(cc.getAttributes()) != null) {
				Rectangle ccbounds =
					GraphConstants.getBounds(cc.getAttributes()).getBounds();
				rect.x = Math.min(ccbounds.x, rect.x);
				rect.y = Math.min(ccbounds.y, rect.y);
				rect.height = Math.max(ccbounds.height, rect.height);
				rect.width = Math.max(ccbounds.x + ccbounds.width, rect.x + rect.width) -
				rect.x;
			}

		}
		return rect;
	}

	private ColumnGroupCell createCol(int ports, LifelineCell llc, Lifeline ll, Point origPoint,
			Dimension size,Map attributes,
			int initialColHeight, ParentMap pm) {
		Column col = null;//IDEAbs.ide.ids.om.createColumn(((Model)model.getModel()).getNewId("Column"));

		ColumnCell colcell = new ColumnCell(col);
		// to avoid drawing the column port
		colcell.removeAllChildren();
		ll.addChildren(col);
		col.setParent(ll);

		ColumnGroupCell cgc=new ColumnGroupCell(col.getId()); 

		pm.addEntry(colcell, cgc);
		Hashtable gmap=new Hashtable();
		GraphConstants.setBounds(gmap,new Rectangle(origPoint.x + 10 +
				(size.width / 2) - 15,
				origPoint.y + 10 +
				(int) size.getHeight(),
				30, initialColHeight));

		attributes.put(cgc, gmap);

		Map m1 = new Hashtable();
		GraphConstants.setBounds(m1,
				new Rectangle(origPoint.x + 10 +
						(size.width / 2) - 15,
						origPoint.y + 10 +
						(int) size.getHeight(),
						30, initialColHeight));

		attributes.put(colcell, m1);
		for (int k = 0; k < ports; k++) {

			AUMLPort port = null;//IDEAbs.ide.ids.om.createAUMLPort(((Model)model.getModel()).getNewId("port"));
			port.setParent(col);
			col.addChildren(port);
			AUMLPortCell aumlport = new AUMLPortCell(port);

			Map m2 = new Hashtable();
			GraphConstants.setBounds(m2,
					new Rectangle(origPoint.x + 10 +
							(size.width / 2) - 2,
							origPoint.y + 10 +
							(int) size.getHeight()+initialColHeight/(ports+1),
							2, 2));

			attributes.put(aumlport, m2);
			pm.addEntry(aumlport, cgc);
		}
		return cgc;


	}

	private Vector getLifelineCols(Lifeline ll) {
		Enumeration enume = ll.getChildrenElements();
		Vector result = new Vector();
		while (enume.hasMoreElements()) {
			result.add(enume.nextElement());
		}
		return result;
	}

	private Point getLastColPos(AUMLAlternativeBox ab, Lifeline ll, JGraph model) {
		Enumeration enume = ab.getChildrenElements();
		Vector llcols = this.getLifelineCols(ll);
		Point result = new Point(0, 0);
		while (enume.hasMoreElements()) {
			AUMLContainer auml = (AUMLContainer) enume.nextElement();
			Enumeration colsenum = auml.getChildrenElements();
			while (colsenum.hasMoreElements()) {
				AUMLComponent component = (AUMLComponent) colsenum.nextElement();
				if (llcols.contains(component)) {
					DefaultGraphCell dgc = (DefaultGraphCell) ingenias.editor.events.
					AUMLDiagramChangesManager.getCellFromUserObject(component, model.getRoots());
					if (dgc != null) {
						Rectangle rect = GraphConstants.getBounds(dgc.getAttributes()).
						getBounds();
						result.y = Math.max(result.y, rect.y + rect.height);
						result.x = Math.max(result.x, rect.x);
					}
				}
			}
		}
		return result;
	}

	private int countPorts(Column col) {
		int result = 0;
		Enumeration enume = col.getChildrenElements();
		while (enume.hasMoreElements()) {
			enume.nextElement();
			result++;
		}
		return result;
	}
}
