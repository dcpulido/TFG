/*
 *  Copyright (C) 2007 Jorge Gomez Sanz
 *  This file is part of INGENIAS IDE, a support tool for the INGENIAS
 *  methodology, availabe at http://grasia.fdi.ucm.es/ingenias or
 *  http://ingenias.sourceforge.net
 *  INGENIAS Development Kit is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *  INGENIAS Development Kit is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU General Public License
 *  along with INGENIAS Development Kit; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package ingenias.module;

import ingenias.editor.ProjectProperty;
import ingenias.exception.NullEntity;
import ingenias.generator.browser.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 *  This class uploads code from tasks back into the 
 *
 *@author     Jorge Gomez
 *@created    14 of December of 2003
 */
public class CodeUploader extends ingenias.editor.extension.BasicToolImp {

	/**
	 *  Initialises the class with a file containing a INGENIAS specification
	 *
	 *@param  file           Path to file containing INGENIAS specification
	 *@exception  Exception  Error accessing any file or malformed XML exception
	 */

	public CodeUploader(String file) throws Exception {
		super(file);
	}

	/**
	 *  Initialises the class giving access to diagrams in run-time
	 **/

	public CodeUploader(Browser browser) throws Exception {
		super(browser);
	}



	/**
	 *  Gets the description of this module
	 *
	 *@return    The description
	 */
	public String getDescription() {
		return "This module uploads code embedded in taks up into the model";
	}


	/**
	 *  Gets the name of this module
	 *
	 *@return    The name
	 */
	public String getName() {
		return "CodeUploader";
	}


	/**
	 *  It opens the different files generated under the ingenias/jade/components folder looking
	 *  for specific tags. These tags mark the beginning and the end of the modification
	 */
	public void run() {
		try {
			String folderForTasks=((ProjectProperty) this.getProperties().get("Ingenias Agent Framework generator:jadeproject")).value+"/"+
			((ProjectProperty) this.getProperties().get("Ingenias Agent Framework generator:jadeout")).value+"/ingenias/jade/components/";
			System.err.println(folderForTasks);
			File folderDir=new File(folderForTasks);
			File[] taskFiles=folderDir.listFiles();
			for (File task:taskFiles){
				if (task.isFile()){
					String content=getContent(task);
					int indexStart=content.indexOf("//#start_node:");
					int indexEnd=content.indexOf("//#end_node");
					if (indexStart>-1 && indexEnd>-1 && content.indexOf("<--",indexStart)>-1){
						String nodeid=content.substring(indexStart+"//#start_node:".length(), content.indexOf(" <--",indexStart));
						GraphEntity entity=browser.findEntity(nodeid);
						if (entity!=null){
							int indexStartCode=content.indexOf("\n",indexStart)+1;
							String code=content.substring(indexStartCode,indexEnd-1);
							Graph g=browser.findFirstEntityOccurrence(nodeid);
							System.err.println("node:"+nodeid);
							System.err.println(g+":"+entity);
							GraphAttributeFactory.createDefaultGraphFactory(browser);
							GraphAttributeFactory gaf = GraphAttributeFactory.createDefaultGraphFactory(browser);
							entity.setAttribute(gaf.createAttribute("Code", code,g));
							System.err.println(entity.getAttributeByName("Code").getSimpleValue());
							browser.getState().setChanged(true);														
						}
					}
				}
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}


	private String getContent(File task) {

		FileInputStream fis;
		try {
			fis = new FileInputStream(task);
			int read=0;
			byte[] bytesRead=new byte[100];
			StringBuffer sb=new StringBuffer(); 
			while (read>-1){
				try {
					read=fis.read(bytesRead);
					for (int k=0;k<read;k++){
						sb.append((char)bytesRead[k]);
					}
				} catch (IOException e) {

					e.printStackTrace();
				}

			}
			return sb.toString();
		} catch (FileNotFoundException e1) {			
			e1.printStackTrace();
		}

		return "";
	}

	/**
	 *  This module defines no properties
	 *
	 *@return    Empty properties
	 */
	public Vector<ProjectProperty> defaultProperties() {
		Vector<ProjectProperty> result=new Vector<ProjectProperty>();

		return result;
	}


	/**
	 *  Generates an stats report from a INGENIAS specification file (1st param)
	 *
	 *@param  args           Arguments typed in the command line. Only first one is attended
	 *@exception  Exception  Sth went wrong
	 */
	public static void main(String args[]) throws Exception {
		ingenias.editor.Log.initInstance(new java.io.PrintWriter(System.err));


		// Prints the result
		System.exit(0);
	}



}
