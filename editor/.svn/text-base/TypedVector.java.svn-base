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

import java.util.*;


public class TypedVector extends Vector  implements java.io.Serializable {
  private Class type;

  public TypedVector(Class type) {
    this.type=type;
  }

  public ListIterator listIterator() {
    /**@todo Implement this java.util.List abstract method*/
      ListIterator li= new ListIterator(){

            int current=0;
            public boolean hasNext() {
                
                return current<size()-1;
            }

            public Object next() {                   
                return elementAt(current++);
             
            }

            public boolean hasPrevious() {
                return current>0;
            }

            public Object previous() {
                return elementAt(current--);
            }

            public int nextIndex() {
                current=current+1;
                return current;
            }

            public int previousIndex() {
                current--;
                return current;
            }

            public void remove() {
                removeElementAt(current);
            }

            public void set(Object e) {
                setElementAt(e, current);
            }

            public void add(Object e) {
                add(e);
            }
        };    
        return li;
  }

  public Iterator iterator() {
   return super.iterator();
  }



  public Class getType(){
    return type;
  }

  public boolean add(Object object) {
   if (!type.isAssignableFrom(object.getClass()))
     throw new ingenias.exception.BadElementClass();
   return super.add(object);
   /*boolean found=false;
   for (int k=0;k<this.size() && !found;k++){
    found=this.elementAt(k).equals(object);
   }
   if (true)
    return super.add(object);
   else
    return false;*/
  }
  
  public boolean addWithDuplicate(Object object) {
	   if (!type.isAssignableFrom(object.getClass()))
	     throw new ingenias.exception.BadElementClass();

	    return super.add(object);
	  }

  public void insert(Object object,int pos) {
   if (!type.isAssignableFrom(object.getClass()))
     throw new ingenias.exception.BadElementClass();

   boolean found=false;
   for (int k=0;k<this.size() && !found;k++){
    found=this.elementAt(k).toString().equals(object.toString());
   }
   if (!found)
    super.insertElementAt(object,pos);
  }

  public void addElement(Object object) {
   if (!type.isAssignableFrom(object.getClass()))
     throw new ingenias.exception.BadElementClass();

   boolean found=false;
   for (int k=0;k<this.size() && !found;k++){
    found=this.elementAt(k).toString().equals(object.toString());
   }
   if (!found)
    super.add(object);
  }

  public String toString(){
    StringBuffer sb=new StringBuffer();
    sb.append("<ul>");
     for (int k=0;k<this.size();k++){
       sb.append("<li> "+this.elementAt(k).toString()+"</li>\n");
     }
     sb.append("</ul>");

 /*   sb.append("<ul>");
    for (int k=0;k<this.size();k++){
      sb.append("<li>"+this.elementAt(k).toString()+"</li>");
    }
    sb.append("</ul>");*/
    return sb.toString();
  }

}
