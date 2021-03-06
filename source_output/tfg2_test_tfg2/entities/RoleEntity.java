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

package ingenias.editor.entities;

import ingenias.editor.StaticPreferences;
import ingenias.editor.entities.Entity;
import java.util.*;
import org.jgraph.graph.GraphConstants;
import java.lang.reflect.*;

public class RoleEntity extends Entity  implements java.io.Serializable {

	private boolean hide=false;
	private Map attributes;
	private int attributeToShow;


	public RoleEntity(String id) {
		super(id);
		attributes=new org.jgraph.graph.AttributeMap();
		GraphConstants.setDisconnectable(attributes,false);
	}


	public void hide(){
		hide=true;
		this.attributeToShow=-1;

	}

	public void show(int attribute){
		hide=false;
		this.attributeToShow=attribute;
	}

	public void show(){
		hide=false;
		this.attributeToShow=0;
	}

	public int getAttributeToShow(){
		return this.attributeToShow;
	}

	public Map getAttributes(){
		return this.attributes;
	}

	public void setAttributes(Map m){
		this.attributes=m;
	}


	public Object getAttribute(int k){
		try {
			//   k=k-1;
			Field[] f=this.getClass().getFields();
			if (k>=f.length || ((k<f.length) && f[k].getName().equalsIgnoreCase("id")))
				return "";
			//    System.err.println("attributo "+k+" "+f[k].get(this));

			if (f[k].get(this)!=null)
				return f[k].get(this);
			else
				return "";
		} catch (Exception e){
			e.printStackTrace();
		}
		return "";
	}

	public String toString(){
		if (StaticPreferences.isTesting())
			return  getId()+":"+getType();

		if (!hide && this.getAttributeToShow()>=0){
			//           System.err.println("showing "+this.getAttribute(this.getAttributeToShow()).toString());
			return this.getAttribute(this.getAttributeToShow()).toString();
		}
		else
			return "";
	}

	public void fromMap(Map ht){
		super.fromMap(ht);
		if (ht.get("attributeToShow")!=null)
			this.attributeToShow=Integer.parseInt(ht.get("attributeToShow").toString());
	}

	public void toMap(Map ht){
		super.toMap(ht);
		ht.put("attributeToShow",""+this.getAttributeToShow());
	}

}