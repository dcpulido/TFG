package ingenias.editor.filters;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.JCheckBoxMenuItem;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;



public class FilterManager {

	public static DiagramFilter getINGENIASConfiguration(ClassLoader cl){
		
		DiagramFilter defaultFilter=null;
		try {
			defaultFilter = obtainDiagramFilter(getDefaultFilterFromClassLoader(cl));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return defaultFilter;
	}
	
	public static InputStream getDefaultFilterFromClassLoader(ClassLoader cl) throws java.io.FileNotFoundException {
		String filePath="configs/default.xml";
		InputStream filterIS=null;
		if (cl instanceof java.net.URLClassLoader) {					
			java.net.URL baseURL = ((java.net.URLClassLoader)cl).getResource(filePath);
			if (baseURL == null) {
				try {
					System.err.println("Loading.....");
					new URL(filePath).openStream().close();
					filterIS=new URL(filePath).openStream();
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new java.io.FileNotFoundException(filePath +
					" was not found in the classpath or current jar");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new java.io.FileNotFoundException(filePath +
					" was not found in the classpath or current jar");
				}

			}
			else {
				try {
					filterIS=baseURL.openStream();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					filterIS=new FileInputStream(filePath);					
				}
			 
			}
			//     System.err.println(baseURL);
		}
		else {
			ClassLoader loader = cl;
			try {
				System.err.println("Loading..... from "+cl.getClass().getName());
				//new URL(filePath).openStream().close();
				if (loader.getResource(filePath)==null)
					throw new IOException ();
				return loader.getResourceAsStream(filePath);				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new java.io.FileNotFoundException(filePath +
				" was not found in the classpath or current jar");
			}
			//throw new java.io.FileNotFoundException(filePath +
			//    " was not found in the classpath or current jar");
		}
		return filterIS;
	}


	public static Vector<DiagramFilter> listAvailableConfigurations(){
		Vector<DiagramFilter>  list=new  Vector<DiagramFilter> ();
		File configs=new File("configs");
		if (!configs.exists())
			throw new RuntimeException("configs folder does not exist. Please, create one with that name");
		File[] containedConfigs=configs.listFiles();
		for (File config:containedConfigs){			
			if (config.isFile() && (config.getName().endsWith(".xml") || config.getName().endsWith(".XML"))){				 
				list.add(obtainDiagramFilter(config.getAbsolutePath()));				
			}
		
		}
		return list;
	}
	
	public static ingenias.editor.filters.DiagramFilter obtainDiagramFilter(InputStream xmlConfiguration){
		DiagramFilter df=new DiagramFilter();
		Hashtable<String,Vector<String>> tempAllowedEntities=new Hashtable<String,Vector<String>>();
		Hashtable<String,Vector<String>> tempAllowedRelationships=new Hashtable<String,Vector<String>>();
		try {
			org.apache.xerces.parsers.DOMParser parser = new org.apache.xerces.parsers.DOMParser();		
			parser.parse(new InputSource(xmlConfiguration));
			Document doc = parser.getDocument();
			NodeList nl = doc.getElementsByTagName("name");
			String filterName=nl.item(0).getChildNodes().item(0).getNodeValue();
			df.setName(filterName);
			df.setCurrentAllowedEntities(tempAllowedEntities);
			df.setCurrentAllowedRelationships(tempAllowedRelationships);

			nl = doc.getElementsByTagName("diagram");
			for (int k=0;k<nl.getLength();k++){
				Node node=nl.item(k);
				String diagramName=node.getAttributes().getNamedItem("name").getNodeValue();
				NodeList entityNodes=node.getChildNodes();
				Vector<String> entities=new Vector<String>();
				Vector<String> relationships=new Vector<String>();
				for (int indexEnt=0;indexEnt<entityNodes.getLength();indexEnt++){
					if (entityNodes.item(indexEnt).getNodeName().equalsIgnoreCase("entity")){
						Node entity=entityNodes.item(indexEnt);
						entities.add(entity.getChildNodes().item(0).getNodeValue());		
					}
					if (entityNodes.item(indexEnt).getNodeName().equalsIgnoreCase("relationship")){
						Node relationship=entityNodes.item(indexEnt);
						relationships.add(relationship.getChildNodes().item(0).getNodeValue());		
					}
				}
				tempAllowedEntities.put(diagramName, entities);
				tempAllowedRelationships.put(diagramName,relationships);
			}			
							
			return df;
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static ingenias.editor.filters.DiagramFilter obtainDiagramFilter(String xmlConfiguration){		
		try {
			return obtainDiagramFilter(new FileInputStream(xmlConfiguration));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static void main(String args[]){
		System.err.println(listAvailableConfigurations());
	}


}
