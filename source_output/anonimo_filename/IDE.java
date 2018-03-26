

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

package ingenias.editor;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.html.HTMLFrameHyperlinkEvent;
import javax.swing.tree.*;
import javax.swing.event.*;

import java.awt.event.*;
import java.util.Map;
import java.util.Hashtable;
import ingenias.editor.extension.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;
import java.util.*;
import javax.swing.event.UndoableEditEvent;
import org.jgraph.JGraph;
import org.jgraph.graph.*;
import org.jgraph.event.*;
import java.util.Vector;
import org.jgraph.JGraph;
import org.jgraph.graph.*;
import org.jgraph.event.*;
import org.jgraph.plaf.basic.*;
import ingenias.editor.entities.*;
import java.io.*;

import ingenias.editor.persistence.*;

import java.awt.image.*;
import java.awt.datatransfer.*;
import java.awt.geom.Rectangle2D;
import java.awt.Font;
import ingenias.editor.cell.*;
import ingenias.exception.NullEntity;
import ingenias.generator.browser.BrowserImp;
import ingenias.generator.browser.Graph;
import ingenias.generator.browser.GraphEntity;
import ingenias.editor.models.*;
import ingenias.editor.actions.*;
import ingenias.editor.actions.diagram.AUMLInteractionDiagramActionsFactory;
import ingenias.editor.actions.diagram.WorkProductDiagramActionsFactory;
import ingenias.editor.actions.diagram.PhaseDiagramActionsFactory;
import ingenias.editor.actions.diagram.RoleDiagramActionsFactory;
import ingenias.editor.actions.diagram.ActivityDiagramActionsFactory;
import ingenias.editor.actions.diagram.AgentModelActionsFactory;
import ingenias.editor.actions.diagram.ComponentDiagramActionsFactory;
import ingenias.editor.actions.diagram.DeployDiagramActionsFactory;
import ingenias.editor.actions.diagram.EnvironmentModelActionsFactory;
import ingenias.editor.actions.diagram.InteractionModelActionsFactory;
import ingenias.editor.actions.diagram.OrganizationModelActionsFactory;
import ingenias.editor.actions.diagram.TasksAndGoalsModelActionsFactory;
import ingenias.editor.actions.diagram.UseCaseDiagramActionsFactory;
import ingenias.editor.FontConfiguration;

public class IDE
extends ingenias.editor.IDEAbs {
	
	
	/**
	 *  Constructor for the IDE object
	 */
	public IDE() {
		super();
	}
	
	
	public static void setUIFont (javax.swing.plaf.FontUIResource f){
		//
		// sets the default font for all Swing components.
		// ex. 
		//  setUIFont (new javax.swing.plaf.FontUIResource
		//   ("Serif",Font.ITALIC,12));
		//
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get (key);
			if (value instanceof javax.swing.plaf.FontUIResource)
				UIManager.put (key, f);
        }
	}    
	
	
	public static void main(String args[]) throws Exception {
		
		setUIFont(new javax.swing.plaf.FontUIResource(FontConfiguration.getConfiguration().getGUIFont()));                
		
		
		if (args.length != 0) {			
			if (args[0].equalsIgnoreCase("testing")){
				StaticPreferences.setTesting(true);
			}
		}
		IDEState ids=IDEState.emptyIDEState();
		try {
			ingenias.generator.browser.BrowserImp.initialise(ids);
		}	
		catch (Exception e) {
			e.printStackTrace();
		}	;	
		GUIResources resources=null;
		IDEAbs ide=new IDEAbs();
		resources=ide.getResources();
		Log.initInstance(new PrintWriter(new TextAreaOutputStream(resources.getModuleOutput())),
						 new PrintWriter(new TextAreaOutputStream(resources.getLogs())));
		ide.updateIDEState(ids);
		
		
		
		//ide.initialiseActionHandlers();
		ide.validate();
		ide.pack();
		ide.setVisible(true);
		
		if (args.length != 0 && !args[0].equalsIgnoreCase("testing")) {			
			ids=new LoadFileAction(ide.getIds(),ide.getResources()).loadFileAction(new File(args[0]));
			ide.updateIDEState(ids);
		}
		
		
	}
}



