




/*
 Copyright (C) 2002 Jorge Gomez Sanz, Ruben Fuentes
 
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
package ingenias.editor.persistence;
import java.lang.reflect.*;
import javax.swing.tree.*;
import org.apache.xerces.parsers.DOMParser;
import org.xml.sax.InputSource;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.io.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.*;

import javax.xml.parsers.*;
import org.jgraph.JGraph;
import org.jgraph.graph.*;
import org.w3c.dom.*;
import ingenias.editor.entities.*;
import ingenias.editor.entities.Entity;
import ingenias.exception.*;
import ingenias.editor.cell.*;
import ingenias.editor.*;

/**
 *  Description of the Class
 *
 *@author     developer
 *@created    7 de agosto de 2003
 */
abstract public class GraphLoadImp2Abs
implements GraphLoad {
	
	/**
	 *  Constructor for the GraphLoad object
	 */
	public GraphLoadImp2Abs() {}
	
	/**
	 *  Description of the Method
	 *
	 *@param  om        Description of Parameter
	 *@param  rm        Description of Parameter
	 *@param  graph     Description of Parameter
	 *@param  node      Description of Parameter
	 *@param  nodeView  Description of Parameter
	 *@return           Description of the Returned Value
	 */
	private ModelJGraph fromGXL(ObjectManager om, RelationshipManager rm, ModelJGraph graph, Node node, Node nodeView) {
		try {
			
			// Get Graph's Child Nodes (the cells)
			NodeList list = node.getChildNodes();
			// Get Graph's Child Nodes (the views)
			NodeList listView = nodeView.getChildNodes();
			// ConnectionSet for the Insert method
			ConnectionSet cs = new ConnectionSet();
			// Hashtable for the ID lookup (ID to Vertex)
			Hashtable ids = new Hashtable();
			// Hashtable for Attributes (Vertex to Map)
			Hashtable attributes = new Hashtable();
			Vector edges = new Vector();
			Vector edgesAttr = new Vector();
			// Loop Children
			for (int i = 0; i < list.getLength(); i++) {
				// The order is the same in both trees.
				node = list.item(i);
				nodeView = listView.item(i);
				// If Valid Node
				if (node.getAttributes() != null && node.getNodeName() != null) {
					// Fetch Supertype
					String supertype = (String) node.getNodeName();
					// Create Vertex
					if (supertype.equals("node")) {
						String id = node.getAttributes().getNamedItem("id").getNodeValue();
						String type = node.getAttributes().getNamedItem("type").
						getNodeValue();
						DefaultGraphCell vertex = GXLVertex(id, type, graph, om, rm);
						if ( (vertex != null) && ! (vertex instanceof NAryEdge)) {
							// Add ID, Vertex pair to Hashtable
							if (node.getAttributes().getNamedItem("nid") != null) {
								ids.put(node.getAttributes().getNamedItem("nid").getNodeValue(),
										vertex);
							}
							else {
								ids.put(node.getAttributes().getNamedItem("id").getNodeValue(),
										vertex);
								// Add Attributes
							}
							Map vertexAttr = GXLCellView(graph, vertex, ids, nodeView);
							attributes.put(vertex, vertexAttr);
							// Add Vertex to new Cells
							try {
								((ModelJGraph)graph).getDefaultSize((Entity)vertex.getUserObject()); 
								// to check if the entity is allowed in the diagram
								//System.out.println("PASO 1");
								graph.getModel().insert(new Object[]{vertex}, attributes, cs, null, null);
							} catch (InvalidEntity ie){
								System.err.println("Error creating node "+id+" of type "+type+" in graph "+graph.getID()+" of type "+graph.getClass().getName()+" \n"+attributes+"\n");
								System.err.println(ie.getMessage());
							}
							catch (Exception ex){
								System.err.println("Error creating node "+id+" of type "+type+" in graph "+graph.getID()+" of type "+graph.getClass().getName()+" \n"+attributes+"\n");
								ex.printStackTrace();
								
							}
							// Log.getInstance().logSYS("loaded "+vertex.getUserObject());
						} else {
							if (vertex != null && (vertex instanceof NAryEdge)) {
								edges.add(vertex);
								Vector idscon = getConnectedEntities(node);
								Map vertexAttr = GXLCellView(graph, vertex, ids, nodeView);
								edgesAttr.add(vertexAttr);
								edgesAttr.add(idscon);
								
							}
						}
						// Create Edge
					}
				}
			}
			Enumeration enumeration = edges.elements();
			Enumeration enumeration1 = edgesAttr.elements();
			while (enumeration.hasMoreElements()) {
				try {
					NAryEdge ne = (NAryEdge) enumeration.nextElement();
					NAryEdgeEntity ent = (NAryEdgeEntity) ne.getUserObject();
					Map eas = (Map) enumeration1.nextElement();
					//System.out.println("attributes from edge:" +eas);
					Vector idscon = ( (Vector) enumeration1.nextElement());
					GraphCell gcs[] = null;
					Hashtable[] attsEdges=null;
					if (idscon.size() > 0) {
						String[] idEnts = ent.getIds();
						gcs = new GraphCell[idscon.size()/2];
						attsEdges=new Hashtable[idscon.size()/2];
						
						for (int k = 0; k < idscon.size()/2; k=k+1) {
							String id = idscon.elementAt(2*k).toString();
							gcs[k] = (GraphCell) ids.get(id);
							//System.out.println("PASO 2: "+k);
							graph.getDefaultSize((Entity)((DefaultGraphCell)gcs[k]).getUserObject()); 
							// to check if the entity is allowed in the diagram
							attsEdges[k]=(Hashtable)idscon.elementAt(2*k+1);
							//System.out.println("Entity: "+id+" "+idEnts);
							//this.getGraphCell(graph,id);
							
						}
					}
					else {
						String[] idEnts = ent.getIds();
						gcs = new GraphCell[idEnts.length];
						for (int k = 0; k < idEnts.length; k++) {
							String id = idEnts[k];
							gcs[k] = this.getGraphCell(graph, id);
							//System.out.println("PASO 3"+k);
							graph.getDefaultSize((Entity)((DefaultGraphCell)gcs[k]).getUserObject()); 
							//System.out.println("Entity: "+id+" "+idEnts);
							// to check if the entity is allowed in the diagram
						}
					}
					
					//System.out.println("Voy a conectar.");
					this.connect(graph, gcs, ne, eas, attsEdges);
					//System.out.println("He conectado.");
				} catch (InvalidEntity ie){
					System.err.println(ie.getMessage());
					//System.out.println("Message: "+ie.getMessage());
				}
			}
			return graph;
		}
		catch (Exception e) {
			// Display error message on stderr
			e.printStackTrace();
			return null;
		}
	}
	
	// Convert an CellView represented by a GXL DOM node in a Map.
	// cell is the GraphCell represented by the returned CellView.
	// ids has a mapping from id to vertex.
	/**
	 *  Description of the Method
	 *
	 *@param  graph  Description of Parameter
	 *@param  cell   Description of Parameter
	 *@param  ids    Description of Parameter
	 *@param  node   Description of Parameter
	 *@return        Description of the Returned Value
	 */
	private Map GXLCellView(JGraph graph, GraphCell cell, Map ids, Node node) {
		
		// Fetch Map attributes.
		Hashtable attrMap = getMap(node);
		// The id attribute is not appliable.
		attrMap.remove("id");
		
		attrMap.remove("icon");
		// Fetch extralabels
		
		if (attrMap.containsKey("points")) {
			List points = GraphConstants.getPoints(attrMap);
			ArrayList result = new ArrayList();
			// The ports are removed. They are converted to String's.
			// Ports are added employing cell.
			PortView sourceView = (PortView) graph.getGraphLayoutCache().getMapping( (GraphCell) ( (
																									Port) ( (DefaultEdge) cell).getSource()), false);
			PortView targetView = (PortView) graph.getGraphLayoutCache().getMapping( (GraphCell) ( (
																									Port) ( (DefaultEdge) cell).getTarget()), false);
			// Add source.
			result.add(sourceView);
			// Other points are represented as Point's.
			Iterator it = points.iterator();
			while (it.hasNext()) {
				Object point = it.next();
				if (point instanceof Point) {
					result.add(point);
				}
			}
			// Add target.
			result.add(targetView);
			GraphConstants.setPoints(attrMap, result);
		}
		
		if (attrMap.containsKey("lineBegin")) {
			// int values are saved as Strings.
			String lineBegin = (String) attrMap.get("lineBegin");
			GraphConstants.setLineBegin(attrMap, Integer.parseInt(lineBegin));
		}
		
		if (attrMap.containsKey("lineEnd")) {
			// int values are saved as Strings.
			String lineEnd = (String) attrMap.get("lineEnd");
			GraphConstants.setLineEnd(attrMap, Integer.parseInt(lineEnd));
		}
		
		return attrMap;
	}
	
	// Convert a vertex represented by a GXL DOM node in a DefaultGraphCell.
	// ids contains the already processed vertex ids.
	/**
	 *  Description of the Method
	 *
	 *@param  id     Description of Parameter
	 *@param  type   Description of Parameter
	 *@param  graph  Description of Parameter
	 *@param  om     Description of Parameter
	 *@param  rm     Description of Parameter
	 *@return        Description of the Returned Value
	 */
	abstract protected  DefaultGraphCell GXLVertex(String id, String type, ModelJGraph graph,
												   ObjectManager om, RelationshipManager rm);
	
	// Convert an edge represented by a GXL DOM node in a DefaultEdge.
	// ids has a mapping from id to vertex.
	/**
	 *  Description of the Method
	 *
	 *@param  ids   Description of Parameter
	 *@param  node  Description of Parameter
	 *@return       Description of the Returned Value
	 */
	/*private DefaultEdge GXLEdge(Map ids, Node node) {
	 
	 DefaultEdge edge = new DefaultEdge();
	 
	 // Fetch Map attributes.
	 Map attrMap = getMap(node);
	 
	 // Create Edge with label
	 String label = (String) attrMap.get("id");
	 // Fetch type
	 String type = (String) attrMap.get("type");
	 
	 
	 // id and type are not valid JGraph attributes.
	 attrMap.remove("id");
	 attrMap.remove("type");
	 return edge;
	 }*/
	
	/**
	 *  Description of the Method
	 *
	 *@param  graph     Description of Parameter
	 *@param  selected  Description of Parameter
	 *@param  nEdge     Description of Parameter
	 *@param  eas       Description of Parameter
	 * @param attsEdges 
	 */
	private void connect(ModelJGraph graph, GraphCell[] selected, NAryEdge nEdge,
						 Map eas, Hashtable[] attsEdges) throws NotFound {
		// N-ary relationship.
		if (nEdge != null) {
			// Role assignations to classes are obtained from NAryEdgeEntity in NAryEdge.
			// NAryEdgeEntity has a list of object ids that have to be in selected.
			// assignations is a Vector of Vectors of Strings where Strings represents roles.
			NAryEdgeEntity nEdgeObject = (NAryEdgeEntity) nEdge.getUserObject();
			// ids of objects connected with nEdge.
			
			// Selected objects are reduced to those connected with nEdge.
			GraphCell[] newSelected = this.getEntitiesAlreadyInsertedInRelationshipAndUpdateDGCIds(selected,nEdgeObject);
			//			String[] ids = nEdgeObject.getIds(); // ids change with previous method
			// Role assignation to objects is obtained.
			String[] selectedAssignation = new String[newSelected.length];
			for (int i = 0; i < newSelected.length; i++) {
				selectedAssignation[i] = nEdgeObject.getRole(""+newSelected[i].hashCode());
				// Auxiliary edges that will be inserted in the Model.
			}
			
			
			try {
				DefaultEdge[] auxiliaryEdges = nEdge.connectionsEdges(newSelected,
																	  selectedAssignation);
				if (auxiliaryEdges.length!=newSelected.length){
					ingenias.editor.entities.NAryEdgeEntity ne = (NAryEdgeEntity)
					nEdge.getUserObject();
					String[] tids = ne.getIds();
					String result = "";
					for (int k = 0; k < selected.length; k++) {
						result = result + ((DefaultGraphCell)selected[k]).getUserObject() + ",";
					}
					Log.getInstance().logSYS("WARNING Relationship removed:Relationship " +
											 ne.getId() + " of type " + ne.getType() +
											 " has not been saved properly among objects " +
											 result + " in graph " + graph.getID());
					nEdge.connectionsEdges(newSelected,
										   selectedAssignation);
					
					
				} else {
					//System.err.println("connecting "+auxiliaryEdges.length+ " "+newSelected.length+ "  "+selected.length);
					Hashtable edgesAttributes = new Hashtable();
					for (int i = 0; i < newSelected.length; i++) {
						RoleEntity re = nEdgeObject.getRoleEntity(""+newSelected[i].hashCode());
						auxiliaryEdges[i].setUserObject(re);
						Object[] labels=(Object[]) attsEdges[i].get("extraLabels");
						Object[] poslabels=(Object[]) attsEdges[i].get("extraLabelPositions");
						if (labels !=null && poslabels!=null){
							Map attr = auxiliaryEdges[0].getAttributes();
							GraphConstants.setExtraLabels(attr, labels);
							Point2D.Double[] points=new Point2D.Double[poslabels.length];
							for (int j=0;j<points.length;j++){
								points[j]=(Point2D.Double)poslabels[j];
								//System.err.println("Storing in point "+points[j]);
							}
							GraphConstants.setExtraLabelPositions(attr, points);
							
						}
					}
					
					
					// Connections that will be inserted into the Model. This method
					// associates an edge with the naryedgeentity and the extreme.
					// It is assumed that selectedAssignation, auxiliaryEdges, and ports
					// are consistent in order
					ConnectionSet cs = nEdge.connections(selectedAssignation,
														 auxiliaryEdges,
														 getPorts(graph, newSelected));
					// Construct a Map from cells to Maps (for insert).
					Hashtable attributes = new Hashtable();
					// Associate the NAryEdge Vertex with its Attributes.
					attributes.put(nEdge, eas);
					
					
					//////////			-----------------------------------//////////
					
					/*if (labels !=null && poslabels!=null){
					 Map attr = auxiliaryEdges[0].getAttributes();
					 GraphConstants.setExtraLabels(attr, labels);
					 Point[] points=new Point[poslabels.length];
					 for (int j=0;j<points.length;j++){
					 points[j]=(Point)poslabels[j];
					 System.err.println("Storing in point "+points[j]);
					 }
					 GraphConstants.setExtraLabelPositions(attr, points);
					 }*/
					
					for (int i = 0; i < selectedAssignation.length; i++) {
						// Create a Map that holds the attributes for the edge
						Map attr = auxiliaryEdges[i].getAttributes();
                        
                        // General
                        
						GraphConstants.setLineWidth(attr, 2);
                        
                        /*
                         
                         // Dashed
                         GraphConstants.setDashPattern(attr, new float[] { 6, 6 }); // general

                         // None
                         GraphConstants.setLineBegin(attr, GraphConstants.ARROW_NONE); // source
                         GraphConstants.setLineEnd(attr, GraphConstants.ARROW_NONE); // target
                         
                         // Simple
                         GraphConstants.setLineBegin(attr, GraphConstants.ARROW_NONE); // source
                         GraphConstants.setLineEnd(attr, GraphConstants.ARROW_SIMPLE); // target
                         
                         // Solid
                         GraphConstants.setLineBegin(attr, GraphConstants.ARROW_NONE); // source
                         GraphConstants.setLineEnd(attr, GraphConstants.ARROW_TECHNICAL);
                         GraphConstants.setEndFill(attr, true); // target
                         
                         // Aggregation
                         GraphConstants.setLineBegin(attr, GraphConstants.ARROW_DIAMOND); // source
                         GraphConstants.setBeginFill(attr, true);
                         GraphConstants.setLineEnd(attr, GraphConstants.ARROW_NONE); // target
                         
                         // Composite
                         GraphConstants.setLineBegin(attr, GraphConstants.ARROW_DIAMOND); // source
                         GraphConstants.setBeginFill(attr, false);
                         GraphConstants.setLineEnd(attr, GraphConstants.ARROW_NONE); // target
                         
                         
                        */
                        
						// Particular dashed line for Activity precedence relationship
						
						if (selectedAssignation[i].startsWith("ActivityPrecedes") ||
							selectedAssignation[i].startsWith("WPDepends")){
							GraphConstants.setDashPattern(attr, new float[] { 6, 6 });
						}
                        
						// Source
						if (selectedAssignation[i].indexOf("source") >= 0){
							if (selectedAssignation[i].startsWith("WFContains") ||
								selectedAssignation[i].startsWith("WPContains")) {
								GraphConstants.setLineEnd(attr, GraphConstants.ARROW_DIAMOND);				
								GraphConstants.setEndSize(attr, 16);
								GraphConstants.setEndFill(attr, true);
							}
						}
						
						// Target
						if (selectedAssignation[i].indexOf("target") >= 0 ||
							selectedAssignation[i].endsWith("T")) {
							
							GraphConstants.setLineEnd(attr, GraphConstants.ARROW_SIMPLE);
							GraphConstants.setEndSize(attr, 16);
							
							if (selectedAssignation[i].startsWith("Extends")){
								GraphConstants.setLineEnd(attr, GraphConstants.ARROW_TECHNICAL);				
								GraphConstants.setEndFill(attr, false);
							}
							
							if (selectedAssignation[i].startsWith("UMLAssociation")){
								GraphConstants.setLineEnd(attr, GraphConstants.ARROW_NONE);
								GraphConstants.setEndFill(attr, false);
							}
							
							if (selectedAssignation[i].startsWith("DPDFPrecedes")){
								GraphConstants.setLineEnd(attr, GraphConstants.ARROW_TECHNICAL);
								GraphConstants.setEndFill(attr, true);
							}
							
							if (selectedAssignation[i].startsWith("WFContains") ||
								selectedAssignation[i].startsWith("WPContains")){
								GraphConstants.setLineEnd(attr, GraphConstants.ARROW_NONE);				
							}
							
						}
						GraphConstants.setDisconnectable(attr,false);
						
						GraphConstants.setBendable(attr,false);
						
						edgesAttributes.put(auxiliaryEdges[i], attr);
						
					}
					
					//////////			-----------------------------------//////////
					// Insert the Edge and its Attributes. The order matters.
					if (auxiliaryEdges.length >= 2) {
						graph.getModel().insert(new Object[] {nEdge},attributes,
												null, null, null);
						graph.getModel().insert( (Object[]) auxiliaryEdges, edgesAttributes,cs, null,
												null);
					}
					else {
						ingenias.editor.entities.NAryEdgeEntity ne = (NAryEdgeEntity)
						nEdge.getUserObject();
						String[] tids = ne.getIds();
						String result = "";
						for (int k = 0; k < tids.length; k++) {
							result = result + tids[k] + ",";
						}
						Log.getInstance().logSYS("WARNING Relationship removed:Relationship " +
												 ne.getId() + " of type " + ne.getType() +
												 " has not been saved properly among objects " +
												 result + " in graph " + graph.getID());
					}
				}
				
			}catch (WrongParameters wp){
				Log.getInstance().logSYS(
										 "WARNING!!! Cannot produce edges for relationship " +
										 nEdgeObject.getId() + " of type " + nEdgeObject.getType());
				wp.printStackTrace();
				
			}
			
		}
	}
	
	/**
	 *  Gets the modelPath attribute of the GraphLoad object
	 *
	 *@param  n   Description of Parameter
	 *@param  gm  Description of Parameter
	 * @param modelIds 
	 *@return     The modelPath value
	 */
	private Object[] getModelPath(Node n, GraphManager gm) {
		Object[] opath = null;
		Vector path = new Vector();
		NodeList packages = n.getChildNodes();
		for (int k = 0; k < packages.getLength(); k++) {
			Node pack = packages.item(k);
			if (pack.getNodeName().equalsIgnoreCase("path")) {
				NodeList packs = pack.getChildNodes();
				for (int j = 0; j < packs.getLength(); j++) {
					Node npack = packs.item(j);
					if (npack.getNodeName().equalsIgnoreCase("package")) {
						String id = npack.getAttributes().getNamedItem("id").getNodeValue().
						toString();
						path.add(id);
					}
				}
				for (int j = 1; j < path.size(); j++) {
					opath = new Object[j];
					for (int l = 0; l < j; l++) {
						opath[l] = path.elementAt(l);
					}
					
					gm.addPackage(opath, path.elementAt(j).toString());
				}
			}
		}
		return path.toArray();
	}
	
	/**
	 *  Gets the graphCell attribute of the GraphLoad object
	 *
	 *@param  mj  Description of Parameter
	 *@param  id  Description of Parameter
	 *@return     The graphCell value
	 */
	private GraphCell getGraphCell(ModelJGraph mj, String id) {
		for (int k = 0; k < mj.getModel().getRootCount(); k++) {
			//		System.err.println("k:"+k+mj.getModel().getRootCount());
			DefaultGraphCell dgc = (DefaultGraphCell) mj.getModel().getRootAt(k);
			ingenias.editor.entities.Entity ent = (ingenias.editor.entities.Entity)
			dgc.getUserObject();
			if (ent.getId().equalsIgnoreCase(id)) {
				return dgc;
			}
			//		System.err.println("Identiddad:"+ent.getId());
		}
		//	System.err.println("no pude encontrar " + id);
		return null;
	}
	
	/**
	 *  Gets the connectedEntities attribute of the GraphLoad object
	 *
	 *@param  n  Description of Parameter
	 *@return    The connectedEntities value
	 */
	private Vector getConnectedEntities(Node n) {
		Vector result = new Vector();
		NodeList nl = n.getChildNodes();
		for (int k = 0; k < nl.getLength(); k++) {
			Node current = nl.item(k);
			if (current.getNodeName().equalsIgnoreCase("connected")) {
				String id = current.getAttributes().getNamedItem("id").getNodeValue();
				result.add(id);
				Hashtable hashAttr =new Hashtable();
				retrieveNodeGenericAttributes(current, hashAttr);
				result.add(hashAttr);
			}
		}
		//System.err.println("connected to "+n.getAttributes().getNamedItem("id").getNodeValue()+" "+ result.size());
		return result;
	}
	
	/**
	 *  Description of the Method
	 *
	 *@param  ed                             Description of Parameter
	 *@param  om                             Description of Parameter
	 *@param  rm                             Description of Parameter
	 *@param  gm                             Description of Parameter
	 *@param  doc                            Description of Parameter
	 *@exception  ClassNotFoundException     Description of Exception
	 *@exception  IllegalAccessException     Description of Exception
	 *@exception  InstantiationException     Description of Exception
	 *@exception  NoSuchMethodException      Description of Exception
	 *@exception  InvocationTargetException  Description of Exception
	 */
	public void restoreModels(IDEState ids,GUIResources resources,
							  Document doc) throws CannotLoadDiagram {
		// For compatibility and in case a future different RM is needed
		RelationshipManager rm = new RelationshipManager();
		NodeList models = doc.getElementsByTagName("models").item(0).getChildNodes();
		boolean allrecovered=true;
		String failureMessage="";
		float increment=60f/models.getLength();
		float initialValue=resources.getProgressBarValue();
		for (int k = 0; k < models.getLength(); k++) {
			Node model = models.item(k);			
			resources.setCurrentProgress((int)(initialValue+increment*k));
			//System.out.println("Progreso "+resources.getProgressBarValue());
			String id="";
			String type="";
			try {
				if (model.getNodeName().equalsIgnoreCase("model")) {
					id = model.getAttributes().getNamedItem("id").getNodeValue().
					toString();
					Log.getInstance().logSYS("Loading model "+id);
					type = model.getAttributes().getNamedItem("type").getNodeValue().
					toString();
					this.restoreModel(ids,resources,rm, model);
				}
			} catch (Exception e){
				allrecovered=false;
				failureMessage=failureMessage+"\n Error loading model "+ id+
				" of type "+type+". Original error message was \n "+e.getMessage();
				e.printStackTrace();
			}
		}
		if (!allrecovered)
			throw new CannotLoadDiagram(failureMessage);
	}
	
	private void restoreModel(IDEState ids,GUIResources resources,RelationshipManager rm,
							  Node model) throws ClassNotFoundException,
	IllegalAccessException, InstantiationException, NoSuchMethodException,
	InvocationTargetException{
		String id = model.getAttributes().getNamedItem("id").getNodeValue().toString();
		String type = model.getAttributes().getNamedItem("type").getNodeValue().toString();
		//System.out.println("Modelo con Id: "+id+" y type: "+type);
		
		Object[] path = this.getModelPath(model, ids.gm);
		
		Node graph = null;
		Node layout = null;
		NodeList children = model.getChildNodes();
		ModelDataEntity mde = null;
		
		for (int j = 0; j < children.getLength(); j++) {
			
			Node current = children.item(j);
			if (current.getNodeName().equalsIgnoreCase("object")) {
				mde = (ModelDataEntity) PersistenceManager.getOL().restoreObject(ids.om,ids.gm, current);
			}
			if (current.getNodeName().equalsIgnoreCase("gxl")) {
				NodeList gxls = current.getChildNodes();
				for (int l = 0; l < gxls.getLength(); l++) {
					Node currentgxl = gxls.item(l);
					if (currentgxl.getNodeName().equalsIgnoreCase("graph")) {
						graph = currentgxl;
					}
					if (currentgxl.getNodeName().equalsIgnoreCase("layout")) {
						layout = currentgxl;
					}
				}
			}
		}
		ModelJGraph mjg = null;
		
		int indmarquee=type.indexOf("ModelJGraph");
		int inStartTypeTag=type.lastIndexOf(".");
		type="ingenias.editor.models"+type.substring(inStartTypeTag,indmarquee)+"ModelJGraph";
		
		if (mde != null) {
			indmarquee=type.indexOf("ModelJGraph");
			inStartTypeTag=type.lastIndexOf(".");
			String actionFactoryName="ingenias.editor.actions.diagram"+type.substring(inStartTypeTag,indmarquee)+"ActionsFactory";
			
			Class[] consparFactory = {GUIResources.class, IDEState.class};		        
			Object[] valparFactory = {resources,ids};
			Class[] consparModel = {mde.getClass(), String.class,ObjectManager.class, Model.class,BasicMarqueeHandler.class, Preferences.class};      
			Object[] valparModel = {mde,id,ids.om,new Model(ids),new BasicMarqueeHandler(), ids.prefs};		
			
			Constructor cons= Class.forName(type).getConstructor(consparModel);
			mjg = (ModelJGraph) cons.newInstance(valparModel);
			
			Constructor consmarquee = Class.forName(actionFactoryName).getConstructor(consparFactory);
			DiagramMenuEntriesActionsFactory actionFactory=(DiagramMenuEntriesActionsFactory) consmarquee.newInstance(valparFactory);
			MarqueeHandler marquee=new MarqueeHandler(mjg,resources,ids,actionFactory);
			mjg.setMarqueeHandler(marquee);
			
		}
		else {
			Class[] conspar = {
				ids.editor.getClass()};
			Object[] valpar = {
				ids.editor};
			Constructor cons = Class.forName(type).getConstructor(conspar);
			mjg = (ModelJGraph) cons.newInstance(valpar);
		}
		
		//mjg.setEditor(ids.editor);
		//   mjg.setOM(ids.om);
		//mjg.setId(id);
		this.fromGXL(ids.om, rm, mjg, graph, layout);
		ids.gm.addModel(path, id, mjg);
		ids.editor.setEnabled(true);
		
	}
	
	
	/**
	 *  Description of the Method
	 *
	 *@param  node                   Description of Parameter
	 *@return                        Description of the Returned Value
	 *@exception  WrongTypedDOMNode  Description of Exception
	 */
	private Object[] GXL2Array(Node node) throws WrongTypedDOMNode {
		//  System.err.println("init array");
		if (node.getNodeName().equals("array")) {
			try {
				Vector children = new Vector();
				
				// Obtain children
				NodeList values = node.getChildNodes();
				for (int k = 0; k < values.getLength(); k++) {
					try {
						children.add(GXL2Object(values.item(k)));
					}
					catch (WrongTypedDOMNode e) {
						// It is not a valid child.
					}
				}
				// System.err.println("retrieved array "+children.size());
				
				// System.err.println("end array");
				// Construct the Array
				return children.toArray();
			}
			catch (Exception e) {
				e.printStackTrace();
				throw new WrongTypedDOMNode(node.toString() +
											"is a malformed representation of an Object[].");
			}
		}
		else {
			new WrongTypedDOMNode(node.toString() +
								  "does not represent an Object[]").printStackTrace();
			throw new WrongTypedDOMNode(node.toString() +
										"does not represent an Object[]");
		}
	}
	
	/**
	 *  Description of the Method
	 *
	 *@param  node                   Description of Parameter
	 *@return                        Description of the Returned Value
	 *@exception  WrongTypedDOMNode  Description of Exception
	 */
	private List GXL2List(Node node) throws WrongTypedDOMNode {
		if (node.getNodeName().equals("list")) {
			try {
				ArrayList children = new ArrayList();
				
				// Obtain children
				NodeList values = node.getChildNodes();
				int index = 0;
				for (int k = 0; k < values.getLength(); k++) {
					try {
						Object child = GXL2Object(values.item(k));
						children.add(index++, child);
					}
					catch (WrongTypedDOMNode e) {
						// It is not a valid child.
					}
				}
				// Construct the List
				return ( (List) children);
			}
			catch (Exception e) {
				throw new WrongTypedDOMNode(node.toString() +
											"is a malformed representation of an List.");
			}
		}
		else {
			throw new WrongTypedDOMNode(node.toString() +
										"does not represent an List");
		}
	}
	
	/**
	 *  Description of the Method
	 *
	 *@param  node                   Description of Parameter
	 *@return                        Description of the Returned Value
	 *@exception  WrongTypedDOMNode  Description of Exception
	 */
	private Point2D.Double GXL2Point(Node node) throws WrongTypedDOMNode {
		if (node.getNodeName().equals("point")) {
			try {
				// Obtain attributes
				double x = (new Double(node.getAttributes().getNamedItem("x").
									   getNodeValue())).doubleValue();
				double y = (new Double(node.getAttributes().getNamedItem("y").
									   getNodeValue())).doubleValue();
				// Construct the Point
				return new Point2D.Double(x, y);
			}
			catch (Exception e) {
				throw new WrongTypedDOMNode(node.toString() +
											"is a malformed representation of a java.awt.Point.");
			}
		}
		else {
			throw new WrongTypedDOMNode(node.toString() +
										"does not represent a java.awt.Point.");
		}
	}
	
	/**
	 *  Description of the Method
	 *
	 *@param  node                   Description of Parameter
	 *@return                        Description of the Returned Value
	 *@exception  WrongTypedDOMNode  Description of Exception
	 */
	private Rectangle GXL2Rectangle(Node node) throws WrongTypedDOMNode {
		if (node.getNodeName().equals("rectangle")) {
			try {
				// Obtain attributes
				int x = (new Integer(node.getAttributes().getNamedItem("x").
									 getNodeValue())).intValue();
				int y = (new Integer(node.getAttributes().getNamedItem("y").
									 getNodeValue())).intValue();
				int width = (new Integer(node.getAttributes().getNamedItem("width").
										 getNodeValue())).intValue();
				int height = (new Integer(node.getAttributes().getNamedItem("height").
										  getNodeValue())).intValue();
				// Construct the Rectangle
				return new Rectangle(x, y, width, height);
			}
			catch (Exception e) {
				throw new WrongTypedDOMNode(node.toString() +
											"is a malformed representation of a java.awt.Rectangle.");
			}
		}
		else {
			throw new WrongTypedDOMNode(node.toString() +
										"does not represent a java.awt.Rectangle.");
		}
	}
	
	
	
	/**
	 *  Description of the Method
	 *
	 *@param  node                   Description of Parameter
	 *@return                        Description of the Returned Value
	 *@exception  WrongTypedDOMNode  Description of Exception
	 */
	private Object GXL2Object(Node node) throws WrongTypedDOMNode {
		Object object = null;
		//System.err.println("Procssing "+node.getNodeName());
		if (node.getNodeName().equals("point")) {
			object = GXL2Point(node);
		}
		else if (node.getNodeName().equals("rectangle")) {
			object = GXL2Rectangle(node);
		}
		else if (node.getNodeName().equals("list")) {
			object = GXL2List(node);
		}
		else if (node.getNodeName().equals("array")) {
			object = GXL2Array(node);
		}
		else if (node.getNodeName().equals("string")) {
			object = GXL2String(node);
		}
		else if (node.getNodeName().equals("attr")) {
			NodeList values = node.getChildNodes();
			
			for (int k = 0; k < values.getLength(); k++) {
				try {
					Object objectAttr = GXL2Object(values.item(k));
					if (object == null) {
						object = objectAttr;
					}
				}
				catch (WrongTypedDOMNode e) {
				}
			}
			
			if (object == null) {
				throw new WrongTypedDOMNode(node.toString() +
											"does not represent any valid Object.");
			}
			//		if (values.item(k).getNodeName().equals("string")) {
			//		Node labelNode = values.item(k).getFirstChild();
			//		if (labelNode != null)
			//		object = (String) labelNode.getNodeValue();
			//		}
		}
		else {
			throw new WrongTypedDOMNode(node.toString() +
										"does not represent any valid Object.");
		}
		
		return object;
	}
	
	private Object GXL2String(Node node) {
		Node labelNode = node.getFirstChild();
		if (labelNode != null) {
			return (String) labelNode.getNodeValue();
		}
		return null;
	}
	
	private DefaultGraphCell[]
	getEntitiesAlreadyInsertedInRelationshipAndUpdateDGCIds(Object[] selected,
															ingenias.editor.entities.NAryEdgeEntity nEdgeObject) {
		ingenias.editor.entities.NAryEdgeEntity ne = nEdgeObject;
		String[] ids = nEdgeObject.getIds();
		Vector<DefaultGraphCell> newselectedv=new Vector<DefaultGraphCell>();
		
		//	System.err.println("connecting ..."+nEdgeObject.getType());
		int i = 0;
		for (int k = 0; k < ids.length; k++) {			
			//	System.err.println("Looking for "+ids[k]);
			for (int j = 0; j < selected.length; j++) {
				Entity userObject = (ingenias.editor.entities.Entity) ( (DefaultGraphCell) selected[j]).getUserObject();			
				try {
					if (userObject != null &&
						userObject.equals(nEdgeObject.getEntity(ids[k]))) {
						nEdgeObject.updateCell(ids[k], "" + selected[j].hashCode());
						// Old id's are prefixed "old" to avoid collision among old id's and new ones
						newselectedv.add((DefaultGraphCell) selected[j]);
						//		System.err.println("Found  "+ids[k]);
						i++;
					}
				}
				catch (NotFound nf) {
				}
				catch (AlreadyExists ae) {
					Log.getInstance().logSYS("WARNING!!!! Relationship" +
											 nEdgeObject.getId() + " of type " +
											 nEdgeObject.getType() +
											 " already contains an id " +
											 selected[j].hashCode());
					
				}
			}
		}
		ids = nEdgeObject.getIds();
		
		// Number of ids in the relationship can be less than initial number
		if (ids.length != i) {
			throw new RuntimeException(
									   "INTERNAL ERROR!!! Length of ids connected in " +
									   nEdgeObject.getId() + " of type " + nEdgeObject.getType() +
									   " a relationship does not match selected default graph cell number. I had " +
									   ids.length + " elements to find and I found " + i);
		}
		DefaultGraphCell[] newSelected = new DefaultGraphCell[ids.length];
		for (int k=0;k<newSelected.length;k++){
			newSelected[k]=(DefaultGraphCell)newselectedv.elementAt(k);
		}
		
		return newSelected;
		
	}
	
	
	//Fetch Cell Map from Node
	protected Hashtable getMap(Node node) {
		
		Hashtable hashAttr = new Hashtable();
		
		try {
			// Common attributes
			hashAttr.put(new String("id"),
						 node.getAttributes().getNamedItem("id").getNodeValue());
			hashAttr.put(new String("type"),
						 node.getAttributes().getNamedItem("type").getNodeValue());
			// Edge attributes
			hashAttr.put("from",
						 node.getAttributes().getNamedItem("from").getNodeValue());
			hashAttr.put("to", node.getAttributes().getNamedItem("to").getNodeValue());
		}
		catch (Exception e) {
			// If the node is a vertex there is neither from nor to attributes.
		}
		// Node specific attributes
		retrieveNodeGenericAttributes(node, hashAttr);
		// System.err.println(node.getAttributes().getNamedItem("id").getNodeValue()+ " Retrieved "+hashAttr+ " "+hashAttr.size());
		//////////return (lab != null) ? lab : new String("");
		return hashAttr;
	}
	
	private void retrieveNodeGenericAttributes(Node node, Hashtable hashAttr) {
		NodeList children = node.getChildNodes();
		for (int j = 0; j < children.getLength(); j++) {
			Node attr = children.item(j);
			try {
				//  System.err.println("analizing "+attr.getAttributes().getNamedItem("name").getNodeValue());
				Object object = GXL2Object(attr);
				// System.err.println("analisys finished for "+attr.getAttributes().getNamedItem("name").getNodeValue());
				hashAttr.put(attr.getAttributes().getNamedItem("name").getNodeValue(),
							 object);
				// System.err.println("after analysis "+hashAttr+" and inserted "+attr.getAttributes().getNamedItem("name").getNodeValue());
			}
			catch (Exception e) {
				// The node is not a valid attribute.
			}
		}
	}
	
	//Gives the ports in the model related with GraphCells in vertexList.
	private Port[] getPorts(ModelJGraph graph, Object[] vertexList) {
		
		// Ports of argument vertexs.
		Port[] ports = new Port[vertexList.length];
		// Obtain the model.
		GraphModel model = graph.getModel();
		
		// Iterate over all Objects.
		for (int i = 0; i < vertexList.length; i++) {
			Port objectPort = null;
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
			ports[i] = objectPort;
		}
		
		return ports;
	}
	
	/**
	 *  The main program for the GraphLoad class
	 *
	 *@param  args  The command line arguments
	 */
	public static void main(String[] args) {
		GraphLoadImp1 graphLoad1 = new GraphLoadImp1();
	}
	
}





