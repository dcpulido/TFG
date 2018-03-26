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

import javax.swing.text.Position;


public class Tag{
	public Tag(String name, int start, int end){
		this.name=name;
		this.start=start;
		this.end=end;
	}
	
	public String name;
	public String altname;
	public int start;
	public int end;
	
	public String xpath;
	
	public Position posStart;
	public Position posEnd;
	
	public String entityID=null;
	public String attID=null;
	public boolean fts;
	
	public String toString(){
		String result=name+":("+start+"-"+end+")";
		if (this.posEnd!=null && this.posStart!=null)
			result=result+":("+this.posStart.getOffset()+"-"+this.posEnd.getOffset()+")";
		return result;
	}
}

