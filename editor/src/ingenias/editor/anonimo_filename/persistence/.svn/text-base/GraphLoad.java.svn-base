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

package ingenias.editor.persistence;

import java.lang.reflect.*;
import javax.swing.tree.*;
import org.apache.xerces.parsers.DOMParser;
import org.xml.sax.InputSource;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.*;
import javax.xml.parsers.*;
import org.jgraph.JGraph;
import org.jgraph.graph.*;
import org.w3c.dom.*;
import ingenias.editor.entities.*;
import ingenias.exception.*;
import ingenias.editor.cell.*;
import ingenias.editor.*;

/**
 *  Description of the Class
 *
 *@author     developer
 *@created    7 de agosto de 2003
 */
public interface GraphLoad {

	/**
	 *  Description of the Method
	 * @param resources 
	 *
	 *@param  ed                             Description of Parameter
	 *@param  om                             Description of Parameter
	 *@param  gm                             Description of Parameter
	 *@param  doc                            Description of Parameter
	 *@exception  CannotLoadDiagram          Description of Exception
	 */
	public void restoreModels(IDEState ids,
			GUIResources resources, Document doc) throws CannotLoadDiagram;
}
