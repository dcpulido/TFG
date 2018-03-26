/*
 *  Copyright (C) 2002 Jorge Gomez Sanz
 *  This file is part of INGENIAS IDE, a support tool for the INGENIAS
 *  methodology, availabe at http://grasia.fdi.ucm.es/ingenias or
 *  http://ingenias.sourceforge.net
 *  INGENIAS IDE is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *  INGENIAS IDE is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU General Public License
 *  along with INGENIAS IDE; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package ingenias.editor.extension;


import ingenias.editor.GUIResources;
import ingenias.editor.ProgressListener;
import ingenias.exception.CannotLoad;
import ingenias.exception.DamagedFormat;
import ingenias.exception.NotInitialised;
import ingenias.exception.UnknowFormat;
import ingenias.generator.browser.Browser;
import java.util.*;
import ingenias.generator.datatemplate.*;
import ingenias.generator.interpreter.TemplateTree;
import ingenias.generator.util.Conversor;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

import ingenias.generator.browser.*;

/**
 *  This interface describe the activation method of tools
 *
 *@author     developer
 *@created    30 November 2003
 */

public abstract class BasicCodeGeneratorImp
extends BasicToolImp
implements BasicCodeGenerator {
	
	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	protected boolean error = false; // An error has been raised. It indicates the process should stop

	Vector templates = new Vector();

	private ProgressListener pl;

	/**
	 *  Creates a code generator that reuses that reuses an existing browser
	 * directly. This constructor is invoked when launching a code generator
	 * from whithin the IDE.
	 */
	public BasicCodeGeneratorImp(Browser browser) {
		super(browser);


	}

	/**
	 *  Creates a code generator that initialises from scratch a browser.
	 * This constructor is invoked when launching a stand alone version
	 */

	public BasicCodeGeneratorImp(String file) throws ingenias.exception.
	UnknowFormat,
	ingenias.exception.DamagedFormat,
	ingenias.exception.CannotLoad {
		super(file);   
		templates = new Vector();
	}

	public BasicCodeGeneratorImp(String file, String[] templateFileArray) throws UnknowFormat, DamagedFormat,
	CannotLoad {
		super(file);
		try {
			for (int k=0;k<templateFileArray.length;k++)
				this.addTemplate(templateFileArray[k]);
			// TODO Auto-generated constructor stub
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public BasicCodeGeneratorImp(String[] templateFileArray, Browser browser) throws UnknowFormat, DamagedFormat,
	CannotLoad {
		super(browser);
		try {
			for (int k=0;k<templateFileArray.length;k++)
				this.addTemplate(templateFileArray[k]);
			// TODO Auto-generated constructor stub
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	/**
	 *  Adds a new template to be processed with data from specification diagrams.
	 *
	 *@param  filePath  The path of the template in the deployment file
	 *@exception  java.io.FileNotFoundException The template was not found
	 */
	public void addTemplate(String filePath, ClassLoader cl) throws java.io.FileNotFoundException {
		if (cl instanceof java.net.URLClassLoader) {
			System.err.println("Loding "+filePath);
			java.net.URL baseURL = ((java.net.URLClassLoader)cl).getResource(filePath);
			if (baseURL == null) {
				try {
					System.err.println("Loading.....");
					new URL(filePath).openStream().close();
					this.templates.add(new URL(filePath));
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
				this.templates.add(baseURL);
			}
			//     System.err.println(baseURL);
		}
		else {
			ClassLoader loader = cl;
			try {
				System.err.println("Loading..... from "+this.getClass().getClassLoader().getClass().getName());
				//new URL(filePath).openStream().close();
				if (loader.getResource(filePath)==null)
					throw new IOException ();
				this.templates.add(loader.getResource(filePath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new java.io.FileNotFoundException(filePath +
				" was not found in the classpath or current jar");
			}
			//throw new java.io.FileNotFoundException(filePath +
			//    " was not found in the classpath or current jar");
		}
	}
	
	public void setProgressListener(ProgressListener pl){
		this.pl=pl;
	}



	/**
	 *  Adds a new template to be processed with data from specification diagrams.
	 *
	 *@param  filePath  The path of the template in the deployment file
	 *@exception  java.io.FileNotFoundException The template was not found
	 */
	public void addTemplate(String filePath) throws java.io.FileNotFoundException {
		if (this.getClass().getClassLoader()instanceof java.net.URLClassLoader) {
			java.net.URL baseURL = ( (java.net.URLClassLoader)this.getClass().
					getClassLoader()).findResource(filePath);
			if (baseURL == null) {
				try {
					System.err.println("Loading.....");
					new URL(filePath).openStream().close();
					this.templates.add(new URL(filePath));
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
				this.templates.add(baseURL);
			}
			//     System.err.println(baseURL);
		}
		else {
			ClassLoader loader = this.getClass().getClassLoader();
			try {
				System.err.println("Loading..... from "+this.getClass().getClassLoader().getClass().getName());
				//new URL(filePath).openStream().close();
				if (loader.getResource(filePath)==null)
					throw new IOException ();
				this.templates.add(loader.getResource(filePath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new java.io.FileNotFoundException(filePath +
				" was not found in the classpath or current jar");
			}
			//throw new java.io.FileNotFoundException(filePath +
			//    " was not found in the classpath or current jar");
		}
	}
	
	public void setProgress(int progress){
		if (pl!=null)
			pl.setCurrentProgress(progress);
	}
	
	



	/**
	 *  Runs the code generator with the templates added
	 *
	 */
	public final void run() {

		setProperties(browser.getState().prop);
		
		Sequences seq = this.generate();
		if (templates.size() == 0) {
			ingenias.editor.Log.getInstance().logERROR(
					"No templates defined. Please check module " + this.getName() +
			" implementation. It should use the method addTemplate");

		}
		Enumeration enumeration = this.templates.elements();
		float increment=50f/this.templates.size();
		int counter=0;
		while (enumeration.hasMoreElements()) {
			java.net.URL temp = (java.net.URL) enumeration.nextElement();
			try {
				if (temp != null) {
					InputStream is = temp.openStream();
					ingenias.generator.interpreter.Codegen.applyArroba(seq.toString(),
							is);

				}

			}        
			catch (ingenias.exception.NotWellFormed nwf) {
				ingenias.editor.Log.getInstance().logERROR("Template " + temp +
				" is not well formed. Please run a XML parser on it");
			}
			catch (Exception e) {
				ingenias.editor.Log.getInstance().logERROR("Error " +
						e.getClass().getName() + ": "+Conversor.replaceInvalidChar(e.getMessage()).replace("\n","<br>")+". The trace is <br>" + Conversor.replaceInvalidChar(this.getTrace(e)).replace("\n","<br>"));
			}
			counter++;
			this.setProgress((int) (50+increment*counter));

		}


	}


	/**
	 *  Runs the code generator with the templates added
	 *
	 */
	public final Hashtable editorrun() {

		Hashtable result=new Hashtable();

		Sequences seq = this.generate();
		if (templates.size() == 0) {
			ingenias.editor.Log.getInstance().logERROR(
					"No templates defined. Please check module " + this.getName() +
			" implementation. It should use the method addTemplate");

		}
		Enumeration enumeration = this.templates.elements();
		float increment=50f/this.templates.size();
		int counter=0;
		while (enumeration.hasMoreElements()) {			
			java.net.URL temp = (java.net.URL) enumeration.nextElement();
			try {
				if (temp != null) {
					InputStream is = temp.openStream();
					TemplateTree instancetags=ingenias.generator.interpreter.Codegen.applyArroba(seq.toString(),
							is);
					result.put(temp.toString(),instancetags);            
				}
			}
			catch (ingenias.exception.NotWellFormed nwf) {
				ingenias.editor.Log.getInstance().logERROR("Template " + temp +
				" is not well formed. Please run a XML parser on it");
			}
			catch (Exception e) {
				ingenias.editor.Log.getInstance().logERROR("Error " +
						e.getClass().getName() + ". The trace is \n" + this.getTrace(e));
			}
			counter++;
			this.setProgress((int) (50+increment*counter));
		}
		return result;

	}

	/**
	 *  Determines whether current diagrams contains the information this code
	 *  generator needs. When there are mistakes, the method uses the log
	 *  facilities to inform of errors.
	 *
	 *@return    true in case there is all the information it needs, false i.o.c.
	 */
	

	/**
	 *  Travel the diagram structure to obtain a Sequences instance with all the
	 *  information needed to perform code generation
	 *
	 *@return    Description of the Returned Value
	 */

	abstract protected Sequences generate();
	
	public boolean verify() {
		error = false;
		if (this.isError() != true) {
			this.generate();
		}

		return this.isError() != true;
	}
	
	public void fatalError(){
	 this.setError(true);
		new Exception("Fatal error triggered").printStackTrace();
	}

}