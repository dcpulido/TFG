package ingenias.editor.events;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import ingenias.editor.cell.NAryEdge;

import org.jgraph.JGraph;
import org.jgraph.graph.DefaultEdge;
import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.DefaultPort;
import org.jgraph.graph.EdgeView;
import org.jgraph.graph.GraphConstants;
import org.jgraph.graph.VertexView;

public class LocationChange {
	public static DefaultGraphCell getNAryEdgeExtreme(DefaultEdge de,
			ingenias.editor.Model m) {

		DefaultGraphCell target = (DefaultGraphCell) ((DefaultPort) de
				.getTarget()).getParent();
		DefaultGraphCell source = (DefaultGraphCell) ((DefaultPort) de
				.getSource()).getParent();
		DefaultGraphCell nary = null;
		if (NAryEdge.class.isAssignableFrom(target.getClass())) {
			nary = target;
		}
		if (NAryEdge.class.isAssignableFrom(source.getClass())) {
			nary = source;
		}
		return nary;
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

	public static Point getCenter(Vector points) {
		Iterator it = points.iterator();
		int x = 0;
		int y = 0;
		while (it.hasNext()) {
			Point point = (Point) it.next();
			x = x + point.x;
			y = y + point.y;
		}
		if (points.size()==0)
			return new Point(0,0);
		return new Point((int) (x / points.size()), (int) (y / points.size()));
	}

	public static void centerNAryEdge(JGraph mjg, ingenias.editor.Model m,
			Hashtable changes, DefaultGraphCell nary) {
		Iterator nedges = m.getEdges(m, new Object[] { nary }).iterator();
		Vector points = new Vector();
		// First a gross estimation of the middle point is obtained
		while (nedges.hasNext()) {
			DefaultEdge edgeline = (DefaultEdge) nedges.next();
			DefaultGraphCell extreme = getCellExtreme(edgeline, m);
			if (GraphConstants.getBounds(extreme.getAttributes()) != null) {
				Rectangle rect = GraphConstants.getBounds(
						extreme.getAttributes()).getBounds().getBounds();
				points.add(new Point((int) rect.getCenterX(), (int) rect
						.getCenterY()));
			}
		}
		Point p = getCenter(points);
		nedges = m.getEdges(m, new Object[] { nary }).iterator();
		points.clear();

		// Gross estimation is recomputed using the perimeter intersection
		// between
		// bounds on vertexes and the gross estimation middle point
		while (nedges.hasNext()) {
			DefaultEdge edgeline = (DefaultEdge) nedges.next();

			EdgeView ev = (EdgeView) mjg.getGraphLayoutCache().getMapping(
					edgeline, false);

			DefaultGraphCell extreme = getCellExtreme(edgeline, m);
			VertexView extremeView = (VertexView) mjg.getGraphLayoutCache()
					.getMapping(extreme, false);
			if (GraphConstants.getBounds(extreme.getAttributes()) != null) {

				Rectangle rect = GraphConstants.getBounds(
						extreme.getAttributes()).getBounds().getBounds();
				Point2D p2d = extremeView.getPerimeterPoint(ev, new Point(
						(int) rect.getCenterX(), (int) rect.getCenterY()), p);
				points.add(new java.awt.Point((int) p2d.getX(), (int) p2d
						.getY()));

			}
		}
		p = getCenter(points);
		Map edgem =null;
		if (changes.containsKey(nary))
			edgem=(Map) changes.get(nary);
		else
		    edgem = nary.getAttributes();

		Rectangle boundsEdge = GraphConstants.getBounds(edgem).getBounds();
		
		p.x = p.x - boundsEdge.width / 2;
		p.y = p.y - boundsEdge.height / 2;
		boundsEdge.setLocation(p);
		GraphConstants.setBounds(edgem, boundsEdge);

		changes.put(nary, edgem);
	}
}
