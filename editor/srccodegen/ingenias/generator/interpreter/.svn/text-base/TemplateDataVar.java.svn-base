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



public class TemplateDataVar {
	/**
	 *  Description of the Field
	 */
	public String id;
	/**
	 *  The value stored by the variable
	 */
	public String value;
	
	/**
	 * The id of the entity where the "value" comes from
	 */
	
	public String entityID="";
	
	/**
	 * The id of the attribute of the entity where  the "value" comes from
	 */
	
	public String attID="";
	
	/**
	 * Does this variable refer to a free text section?
	 */
	//public boolean fts=false;


	/**
	 *  Constructor for the TemplateDataVar object
	 *
	 *@param  id     Description of Parameter
	 *@param  value  Description of Parameter
	 */
	public TemplateDataVar(String id, String value) {
		this.id = id;

                try {
                  value=ingenias.generator.util.Conversor.replaceInvalidChar(value);
		this.value = value;
                } catch (Exception e){
                 e.printStackTrace();
                }
	}
	
	public TemplateDataVar(String id, String value, String entityID, String attID) {
		this.id = id;
		this.entityID=entityID;
		this.attID=attID;
		//this.fts=fts;

                try {
                  value=ingenias.generator.util.Conversor.replaceInvalidChar(value);
		this.value = value;
                } catch (Exception e){
                 e.printStackTrace();
                }
	}
	




	/**
	 *  Description of the Method
	 *
	 *@param  o  Description of Parameter
	 *@return    Description of the Returned Value
	 */
	public boolean equals(Object o) {
		if (o instanceof TemplateDataVar) {
			TemplateDataVar tdv = (TemplateDataVar) o;
			return tdv.id.equalsIgnoreCase(id);
		}
		else {
			return super.equals(o);
		}
	}

        public String toString(){
          return "("+this.id+" , "+value+")";
        }

        public static void main(String args[]) throws Exception{

        }
}