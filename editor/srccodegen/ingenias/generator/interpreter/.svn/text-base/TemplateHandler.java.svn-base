/*
 Copyright (C) 2002 Jorge Gomez Sanz
 This file is part of INGENIAS IDE, a support tool for the INGENIAS
 methodology, availabe at http://grasia.fdi.ucm.es/ingenias or
 http://ingenias.sourceforge.net
 INGENIAS IDE is free software; you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation; either version 2 of the License, or
 (at your option) any later version.
 142
 INGENIAS IDE is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.
 You should have received a copy of the GNU General Public License
 along with INGENIAS IDE; if not, write to the Free Software
 Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package ingenias.generator.interpreter;

import ingenias.exception.GenerationException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;
import java.util.Vector;


import org.apache.xerces.parsers.DOMParser;
import org.jdom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import dom.DOMAddLines;

public class TemplateHandler {
	private static PrintWriter pw;
	private static String filename = "";
	
	public static void process(String template, Vector templateData,
			PrintWriter pw, TemplateTree tags) throws
			IOException,SAXException,GenerationException {
		//  Create a Xerces DOM Parser
		TemplateHandler.pw = pw;
		DOMAddLines parser = new DOMAddLines(template);
		
		java.awt.Point p = new java.awt.Point(0, 0);
		
		//  Parse the Document
		//  and traverse the DOM
		try {
		//	parser.parse(new org.xml.sax.InputSource(new FileInputStream(template)));
			//parser.set
			parser.setErrorHandler(new org.xml.sax.ErrorHandler() {
				public void fatalError(org.xml.sax.SAXParseException spe) {
					ingenias.editor.Log.getInstance().logERROR("Parser error at " +
							spe.getLineNumber() + ":" + spe.getColumnNumber() + " " +
							spe.getMessage());
				}
				
				public void error(org.xml.sax.SAXParseException spe) {
					ingenias.editor.Log.getInstance().logERROR("Parser error at " +
							spe.getLineNumber() + ":" + spe.getColumnNumber() + " " +
							spe.getMessage());
				}
				
				public void warning(org.xml.sax.SAXParseException spe) {
					ingenias.editor.Log.getInstance().logERROR("Warning at " +
							spe.getLineNumber() + ":" + spe.getColumnNumber() + " " +
							spe.getMessage());
					
				}
				
			});
			
			Document document = parser.getDocument();
			traverse(document.getElementsByTagName("program").item(0), templateData, null,
					tags,new Vector(), p, 0);
		}
		catch (GenerationException gen){
			gen.printStackTrace();			
			System.err.println("Evaluated template");
			StringBuffer content=new StringBuffer();
			BufferedReader fis= new BufferedReader(new FileReader(template)); 
			String line="";
			int counter=1;			
			while(line!=null) { 
				line= fis.readLine();
				if (line!=null){
					if (counter==gen.getLine())
						content=content.append(line);
				 counter++;
				 
				}
			}
			throw new GenerationException(
					gen.getMessage()+"\n. Error found in template "+template+" at line "+gen.getLine()+" which contains \n"+content,
					gen.getLine());
			
	
			
	
		}
	}
	
	/**
	 *  Description of the Method
	 *
	 *@param  node           Description of Parameter
	 *@param  templateData   Description of Parameter
	 *@exception  Exception  Description of Exception
	 */
	private static void traverse(Node node,
			Vector templateData,
			TemplateDataRepeat tdr,
			TemplateTree tags,Vector alreadyVisited,
			java.awt.Point pos, int times) throws
			GenerationException {
		
		int type = node.getNodeType();
		if (type == Node.ELEMENT_NODE) {
			if (node.getNodeName().equalsIgnoreCase("repeat")) {
				String id = node.getAttributes().getNamedItem("id").getNodeValue();
				Vector filtered = filterRepeat(templateData, id);
				times=count(alreadyVisited,"repeat id=\"" + id + "\"");
				String tname="repeat id=\"" + id + "_"+times+"\"";
				alreadyVisited.add("repeat id=\"" + id + "\"");
				if (filtered.size() > 0) {
					Enumeration enumeration = filtered.elements();
					while (enumeration.hasMoreElements()) {
						TemplateDataRepeat current = (TemplateDataRepeat) enumeration.nextElement();
						Vector ntd = current.body;
						ntd.add(current);
						ntd.addAll(filterVarTemplates(templateData));
						NodeList children = node.getChildNodes();
						if (children != null) {
							Tag t = new Tag(tname,
									pos.x,0);
							TemplateTree repeattree=new TemplateTree(t);
							tags.addChildren(repeattree);              
							alreadyVisited=new Vector();
							for (int i = 0; i < children.getLength(); i++) {
								traverse(children.item(i), ntd, current, repeattree, alreadyVisited, pos,times);
							}
							t.end = pos.x;
						
						}
					}
				} else {
					Tag t = new Tag(tname,
							pos.x,pos.x);               
					tags.addChildren(new TemplateTree(t));          
					
				}
				
			}
			else
				if (node.getNodeName().equalsIgnoreCase("v")) {
					
					if (node.getChildNodes().getLength() != 1) {
						;
						throw new GenerationException(" At tag " + node +" in line "+((String ) ((Node) node).getUserData("startLine"))+
						". There must be only one word withing <v> tags", 
						new Integer(((String ) ((Node) node).getUserData("startLine"))).intValue());
					}
					if (node.getChildNodes().item(0).getNodeType() != Node.TEXT_NODE) {
												
						throw new GenerationException(" At tag " + node.getNodeName() +" in line "+
								((String ) ((Node) node).getUserData("startLine"))+" "+
						". There must be only plain text withing <v> tags",
						new Integer(((String ) ((Node) node).getUserData("startLine"))).intValue());
					}
					String varname = node.getChildNodes().item(0).getNodeValue();
					TemplateDataVar tdv = null;
					
					tdv = filterVar(templateData, varname);
					
					if (tdr != null && tdv == null) {
						tdv = tdr.findVar(varname);
						
					}
					if (tdv != null) {
						Tag t = new Tag("v id=\"" + varname + "\"",
								pos.x,0);
						if (tdv.entityID!=null && !tdv.entityID.equals("")){
							t.entityID=tdv.entityID;
							
						}
						if (tdv.attID!=null && !tdv.attID.equals(""))
							t.attID=tdv.attID;
						if (node.getAttributes().getNamedItem("fts")!=null &&
								!node.getAttributes().getNamedItem("fts").getNodeValue().equals("")){
				        	t.fts=node.getAttributes().getNamedItem("fts").getNodeValue().equals("true");
					
						}
						tags.addChildren(new TemplateTree(t));
						pw.print(tdv.value);
						pos.x = pos.x + tdv.value.length();
						t.end = pos.x;
					}
				}
				else {
					printNode(pw, node);
					NodeList children = node.getChildNodes();
					if (children != null) {
						alreadyVisited=new Vector();
						for (int i = 0; i < children.getLength(); i++) {
							if (children.item(i).getNodeName().toLowerCase().equals("file")) {
								StringWriter sw=new StringWriter();
								PrintWriter pwold=pw;
								pw=new PrintWriter(sw);
								NodeList filechildren=children.item(i).getChildNodes();
								for (int j=0;j<filechildren.getLength();j++){
									traverse(filechildren.item(j), templateData, tdr, new TemplateTree(new Tag("",0,0)),
											new Vector(),new java.awt.Point(),0);
								}
								filename=sw.toString();
								pw=pwold;
								traverse(children.item(i), templateData, tdr, new TemplateTree(new Tag("",0,0)),
										new Vector(),new java.awt.Point(),0);
							}
							else {
								if (children.item(i).getNodeName().toLowerCase().equals("text")) {
									
									File f=new File(filename);                
									TemplateTree instance=new TemplateTree(f); 
									pos=new java.awt.Point(0,0);
									Tag t = new Tag("repeat id=\"fakerepeat\"",
											pos.x,0);
									TemplateTree fakerepeat=new TemplateTree(t);
									instance.addChildren(fakerepeat); 
									tags.addChildren(instance);
									
									traverse(children.item(i), templateData, tdr, fakerepeat,
											alreadyVisited,pos,0);
									t.end = pos.x-1;
									//instance.add(new Tag("/repeat",-1,-1));
									//tags.add(instance);
								}
								else {
									traverse(children.item(i), templateData, tdr, tags, alreadyVisited,pos,0);
								}
							}
							
						}
					}
					pw.print("</" + node.getNodeName() + ">");
				}
			
		}
		if (type == Node.TEXT_NODE) {
			String value = node.getNodeValue();
			pos.x = pos.x + value.length(); // pos has to be incremented right before the conversion
			
			try {
				value = ingenias.generator.util.Conversor.replaceInvalidChar(value);
			}
			catch (Exception e) {
				e.printStackTrace();
			}      
			pw.print(value);
		}
	}
	
	/**
	 * @param alreadyVisited
	 * @param string
	 * @return
	 */
	private static int count(Vector alreadyVisited, String string) {
		int counter=0;
		for (int k=0;k<alreadyVisited.size();k++)
			if (alreadyVisited.elementAt(k).toString().equals(string))
				counter++;
		return counter;
	}
	
	private static void printNode(PrintWriter pw, Node n) {
		pw.print("<" + n.getNodeName() + " ");
		org.w3c.dom.NamedNodeMap nnm = n.getAttributes();
		for (int k = 0; k < nnm.getLength(); k++) {
			pw.print(nnm.item(k).getNodeName() + "=\"" + nnm.item(k).getNodeValue() +
			"\" ");
		}
		pw.print(">");
		pw.flush();
	}
	
	/**
	 *  Description of the Method
	 *
	 *@param  templateData  Description of Parameter
	 *@param  id            Description of Parameter
	 *@return               Description of the Returned Value
	 */
	private static Vector filterRepeat(Vector templateData, String id) {
		Enumeration enumeration = templateData.elements();
		TemplateDataRepeat tdr = new TemplateDataRepeat(id, null, null);
		Vector result = new Vector();
		while (enumeration.hasMoreElements()) {
			Object next = enumeration.nextElement();
			if (next.equals(tdr)) {
				result.add(next);
			}
		}
		return result;
	}
	
	/**
	 *  Description of the Method
	 *
	 *@param  templateData  Description of Parameter
	 *@param  id            Description of Parameter
	 *@return               Description of the Returned Value
	 */
	
	private static Vector filterVarTemplates(Vector templateData) {
		Enumeration enumeration = templateData.elements();
		Vector result = new Vector();
		while (enumeration.hasMoreElements()) {
			Object next = enumeration.nextElement();
			if (next instanceof TemplateDataVar) {
				result.add(next);
			}
		}
		return result;
		
	}
	
	private static TemplateDataVar filterVar(Vector templateData, String id) {
		Enumeration enumeration = templateData.elements();
		TemplateDataVar tdr = new TemplateDataVar(id, "");
		TemplateDataVar result = null;
		boolean found = false;
		while (enumeration.hasMoreElements() && !found) {
			Object next = enumeration.nextElement();
			found = next.equals(tdr);
			if (found) {
				result = (TemplateDataVar) next;
			}
		}
		return result;
		
	}
	
	/**
	 *  The main program for the TemplateHandler class
	 *
	 *@param  args           The command line arguments
	 *@exception  Exception  Description of Exception
	 */
	public static void main(String[] args) throws Exception {
	}
	
}
