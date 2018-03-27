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
//import java.awt.image.*;
import java.io.OutputStreamWriter;
import java.io.*;
//import java.awt.*;
//import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
//import javax.swing.event.*;
//import javax.swing.*;
//import java.awt.event.*;
//import java.awt.Rectangle;
//import java.awt.Color;
//import java.net.URL;
import java.util.*;
import java.util.Map;
import java.util.Hashtable;
import java.util.ArrayList;
//import javax.swing.*;
//import javax.swing.event.UndoableEditEvent;
import javax.xml.parsers.*;

import org.jgraph.JGraph;
import org.jgraph.graph.*;

import org.w3c.dom.*;
import org.w3c.dom.Document;
import org.w3c.dom.DOMImplementation;

import ingenias.editor.entities.*;
import ingenias.exception.*;
import ingenias.editor.cell.*;

import ingenias.editor.*;

public interface PropertyLoad {
  public void restoreProperty(ObjectManager om, GraphManager gm, Node current,
                              ingenias.editor.entities.Entity en) throws
                                      ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
                                      InstantiationException, InvocationTargetException
;
}