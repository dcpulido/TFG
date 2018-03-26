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


import java.util.Vector;

/**
 * This class is similar to ingenias.generator.datatemplate.Repeat class. It differs in the
 * references to a parent repeat node which is used to find var entities easily.
 * 
 * @author jj
 *
 */
public class TemplateDataRepeat {

	/**
	 *  Description of the Field
	 */
	public String id;
	/**
	 *  Description of the Field
	 */
	public Vector body;

        public TemplateDataRepeat parent=null;


	/**
	 *  Constructor for the TemplateDataRepeat object
	 *
	 *@param  id    Description of Parameter
	 *@param  body  Description of Parameter
	 */
	public TemplateDataRepeat(String id, Vector body, TemplateDataRepeat parent) {
		this.id = id;

		this.body = body;
                this.parent=parent;

	}


	/**
	 *  Description of the Method
	 *
	 *@param  o  Description of Parameter
	 *@return    Description of the Returned Value
	 */
	public boolean equals(Object o) {
		if (o instanceof TemplateDataRepeat) {
			TemplateDataRepeat tdr = (TemplateDataRepeat) o;
			return tdr.id.equalsIgnoreCase(id);
		}
		else {
			return super.equals(o);
		}
	}

        public TemplateDataRepeat getParent(){
           return parent;
        }

        public TemplateDataVar findVar(String id){
          if (body.indexOf(new TemplateDataVar(id,""))==-1){
            if (parent !=null)
               return parent.findVar(id);
            else
               return null;
          } else
             return (TemplateDataVar)(body.elementAt(body.indexOf(new TemplateDataVar(id,""))));
        }
}