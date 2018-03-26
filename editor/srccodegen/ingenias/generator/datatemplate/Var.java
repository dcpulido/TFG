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

package ingenias.generator.datatemplate;

import java.io.UnsupportedEncodingException;


public class Var {
	String id;
	String value;

	/**
	 * The id of the entity where the "value" comes from
	 */

	public String entityID="";

	/**
	 * The id of the attribute of the entity where  the "value" comes from
	 */

	public String attID="";

	public Var(String id,String value){
		this.id=id;

		this.value=value;
		if (value==null || id==null)
			throw new RuntimeException("Null value when creating a VAR");
	}

	/**
	 *  Constructor for the TemplateDataVar object with information about the origin 
	 *  of the information. This is a information which is not always accesible. An
	 *  example of such situation is the combination of information extracted from
	 *  two different entities and combined into one, and, in general, any information
	 *  that has suffered any kind of transformation since it was extracted.
	 *
	 *@param  id     Description of Parameter
	 *@param  value  Description of Parameter
	 */
	public Var(String id, String v, String entityID, String attID) {
		this.id = id;
		this.entityID=entityID;
		this.attID=attID;
		
		this.value = v;
		if (value==null || id==null)
			throw new RuntimeException("Null value when creating a VAR");
	}

	public String toString(){
		String value="<v id=\""+id+"\" entityID=\""+ingenias.generator.util.Conversor.replaceInvalidCharsForID(this.entityID)+"\" attID=\""+attID +"\" >"+
		ingenias.generator.util.Conversor.replaceInvalidChar(this.value)+"</v>\n";
		return value;
		
	}
}