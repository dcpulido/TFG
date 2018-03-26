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

package ingenias.generator.interpreter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ingenias.exception.*;
import ingenias.generator.datatemplate.*;





public class SplitHandler {

	/**
	 *  Constructor for the TemplateHandler object
	 *
	 *@param  xmlFile        Description of Parameter
	 *@exception  Exception  Description of Exception
	 */
	public SplitHandler(String xmlFile) throws FileTagEmpty,TextTagEmpty,java.io.IOException,SAXException{
		//  Create a Xerces DOM Parser
		DOMParser parser = new DOMParser();

		//  Parse the Document
		//  and traverse the DOM
		try {
//			parser.setIncludeIgnorableWhitespace(true);
			parser.parse(xmlFile);
			Document document = parser.getDocument();
                        NodeList children=document.getChildNodes();
                        for (int k=0;k<children.getLength();k++){
			 traverse(children.item(k));
                        }
//                        System.err.println("split made");
		}
		catch (SAXException e) {
//			e.printStackTrace();
                        throw e;
                //        System.exit(-1);
		}

                catch (java.io.UTFDataFormatException formatEx){
                  ingenias.editor.Log.getInstance().logERROR("Error interpreting a INGENIAS file");
                  ingenias.editor.Log.getInstance().logERROR("The text contained in "+xmlFile+" contains non UTF-8 characters");
                  ingenias.generator.util.FormatVerifier.verify(xmlFile);
                  throw formatEx;
                }

		catch (IOException e) {

			throw e;
		}
	}


	//  Traverse DOM Tree.  Print out Element Names

	/**
	 *  Description of the Method
	 *
	 *@param  node           Description of Parameter
	 *@return                The text value
	 */

	private StringBuffer getText(Node node) {
		StringBuffer text = new StringBuffer();
		int type = node.getNodeType();
		if (type == Node.ELEMENT_NODE) {
/*			text.append("<").append(node.getNodeName()).append(">");
			NodeList children = node.getChildNodes();
			if (children != null) {
				for (int i = 0; i < children.getLength(); i++) {
					text.append(getText(children.item(i)));
				}
			}
			text.append("</").append(node.getNodeName()).append(">");*/
			return new StringBuffer();
		}
		else {
			return new StringBuffer(node.getNodeValue());
		}
	}
	
	  public static String decodeSpecialSymbols(String text){
		  try {
		  String s=text;
		  s=ingenias.generator.util.Conversor.restoreInvalidChar(text);

		  return  s;
		} catch (Exception uee){
		  uee.printStackTrace();
		}
		return "";
		}


	/**
	 *  Description of the Method
	 *
	 *@param  node           Description of Parameter
	 *@exception  Exception  Description of Exception
	 */
	private void traverse(Node node) throws FileTagEmpty,TextTagEmpty,java.io.IOException{
		int type = node.getNodeType();
		if (type == Node.ELEMENT_NODE) {
			if (node.getNodeName().equalsIgnoreCase("saveto")) {
				NodeList nl = node.getChildNodes();
//                                System.err.println("Saving ...");
				/*
				 *  if (nl.item(0).getNodeType() != Node.ENTITY_NODE ){
				 *  /||
				 *  /   nl.getLength()!=2) {
				 *  throw new Exception(" At " + node +  nl.getLength()+". There must be two tags inside a <saveto>: a <file>FILENAME</file> and <text>TEXTTOWRITE</text>");
				 *  }
				 */
				String fid = null;
				StringBuffer text = new StringBuffer();
                                boolean overwrite=true;
				int k = 0;
				while ((fid == null || text.length()==0) && k < nl.getLength()) {
					if (nl.item(k).getNodeName().equalsIgnoreCase("file") && nl.item(k).getChildNodes().getLength() >= 1) {
						fid = nl.item(k).getChildNodes().item(0).getNodeValue();
/*                                                System.err.println("entro!!!"+nl.item(k).getChildNodes().getLength());
                                                for (int _j=0;_j<nl.item(k).getChildNodes().getLength();_j++){
                                                  System.err.println(nl.item(k).getChildNodes().item(_j).getNodeValue());
                                                }
                                               if (nl.item(k).getChildNodes().getLength()>1)
                                                System.exit(1);
                                                System.err.println("has attr "+nl.item(k).hasAttributes()+nl.item(k).getNodeName());*/
                                                if (nl.item(k).getAttributes().getNamedItem("overwrite")!=null)
                                                 overwrite=nl.item(k).getAttributes().getNamedItem("overwrite").getNodeValue().equalsIgnoreCase("yes");
					}
					if (nl.item(k).getNodeName().equalsIgnoreCase("text") && nl.item(k).getChildNodes().getLength() >= 1) {
						for (int j = 0; j < nl.item(k).getChildNodes().getLength(); j++) {
							text.append(getText(nl.item(k).getChildNodes().item(j)));
						}
					}

					k = k + 1;
				}

				if (fid == null) {
					throw new FileTagEmpty(" At " + node + ". First tag must be <file>FILENAME</file> and now it is " + nl.item(1).getNodeName());
				}
				if (text.length()==0) {
					throw new TextTagEmpty(" At " + node + ". Second tag must be <text>TEXTTOWRITE</text> and now it is " + nl.item(3).getNodeName());
				}




				fid = fid.replace('\n', ' ').trim();


				try {
					File f = new File(fid);
                                        if (!f.exists() || overwrite){
                                          ingenias.editor.Log.getInstance().logSYS("-------------"+f);
//                                        new File(f.getParent()).mkdirs();
                                        ingenias.editor.Log.getInstance().logSYS("writing to "+fid);
                                        this.createPath(f);
					FileOutputStream fos = new FileOutputStream(fid);
					PrintWriter pw = new PrintWriter(fos);
                                        // converts any &lt;, &amp;, &gt; &quot; &apos to their original symbols
					pw.print(decodeSpecialSymbols(text.toString()));
//					pw.print(text.replaceAll("&lt;","<").replaceAll("&gt;",">"));
					pw.flush();
					pw.close();
                                        } else
                                         ingenias.editor.Log.getInstance().logWARNING("I won't overwrite file "+fid);
				}
				catch (IOException ioe) {
//					ioe.printStackTrace();
					throw new java.io.IOException("At " + node + ". Could not execute a <saveto> tag. It was not possible to write in the file " + fid);
				}

			}

			if (node.getNodeName().equalsIgnoreCase("program")) {
				NodeList children = node.getChildNodes();
				if (children != null) {
					for (int i = 0; i < children.getLength(); i++) {
						traverse(children.item(i));
					}
				}
			}

		}
	}

        private void createPath(File f) throws IOException{
          new File(f.getParent()).mkdirs();
        }


	/**
	 *  The main program for the SplitHandler class
	 *
	 *@param  args           The command line arguments
	 *@exception  Exception  Description of Exception
	 */
	public static void main(String[] args) throws Exception {
/*		Vector td = new Vector();
		td.add(new TemplateDataVar("hola", "adios"));
		Vector gt = new Vector();
		gt.add(new TemplateDataVar("goal", "A"));
		TemplateDataRepeat tdr = new TemplateDataRepeat("goaltask", gt);
		td.add(tdr);
		gt = new Vector();
		gt.add(new TemplateDataVar("goal", "B"));
		tdr = new TemplateDataRepeat("goaltask", gt);
		td.add(tdr);
		PrintWriter pw = new PrintWriter(new FileOutputStream("/home/developer/tmp/p"));

		TemplateHandler basicDOM = new TemplateHandler("/home/developer/gen/codegen/plantillas/reglas3.ilr", td, pw);

		pw.flush();
		pw.close();*/

		SplitHandler sd = new SplitHandler(args[0]);
	}

}

