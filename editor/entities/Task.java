
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

package ingenias.editor.entities;

import java.util.*;
import ingenias.editor.TypedVector;

public class Task extends AgentComponent {
	public Task(String id) {
		super(id);
		this.setHelpDesc("<br>Tasks is the encapsulation of actions or non-distributable algorithms. Tasks can use<br>Applications and resources. Tasks generate changes in the mental state of the agent that<br>executes them. Changes consist of: (a) modifying, creating or destroying mental<br>entities; or (b) changes in the perception of the world by acting over applications<br>(applications act over the world producing events, that are perceived by the agent).<br>Though tasks can be also assigned to roles, at the end, it will belong to an agent.<br>");
		this.setHelpRecom("");
	}
	
	public void fromMap(Map ht){
		super.fromMap(ht);
	}
	public void toMap(Map ht){
		super.toMap(ht);
		
	}
	
	public String toString(){
		if (this.getId()==null ||
			this.getId().toString().equals(""))
			return "Please, define the value of field Id";
		else
			return this.getId().toString();
	}
	
}
