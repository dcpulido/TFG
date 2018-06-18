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

import ingenias.editor.ProjectProperty;
import ingenias.generator.interpreter.TemplateTree;

import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;

/**
 *  This interface describe the activation method of tools
 *
 *@author     Jorge J. Gomez-Sanz
 *@created    30 November 2003
 */
public interface BasicTool {

	/**
	 *  A description of the purpose of this tool
	 *
	 *@return    The description
	 */
	public String getDescription();


	/**
	 *  The name of this tool. This name will be included in the INGENIAS
         *  tool
	 *
	 *@return    The name
	 */
	public String getName();


	/**
	 *  Enables the tool by providing an interface to traverse graphs defined with
	 *  the IDE
	 *
	 */
	public void run();
	


	/**
	 *  Obtains the properties associated with this tool. Each property is a tuple
	 *  (String key, ProjectProperty value)
	 *
	 *@return    Properties needed by this tool
	 */
	public Properties getProperties();
	
	/**
	 * It obtains a property given its id 
	 * 
	 * @param id The id of the property
	 * @return the property or null if none exist
	 */
	public ProjectProperty getProperty(String id);
	
	/**
	 * It adds a new property 
	 * 
	 * @param pp The property to add
	 * 
	 */
	public void putProperty(ProjectProperty pp);


	/**
	 *  It provides the tool with the configuration properties it needs
	 *
	 *@param  p  Properties supplied
	 */
	public void setProperties(Properties p);

}
