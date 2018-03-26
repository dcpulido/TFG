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

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.CharBuffer;
import java.util.*;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Sequences {

	private Vector body=new Vector();

	public void addRepeat(Repeat r){
		body.add(r);
	}

	public void addVar(Var v){
		body.add(v);
	}

	public String toString(){
		String ctype="<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n";
		String result=ctype+"<sequences>\n";
		Enumeration enumeration=body.elements();
		while (enumeration.hasMoreElements()){
			result=result+enumeration.nextElement().toString();
		}

		result=result+"</sequences>\n";

		java.io.ByteArrayOutputStream ba=new java.io.ByteArrayOutputStream();
		OutputStreamWriter osw;
		try {
			osw = new OutputStreamWriter(ba,"ISO-8859-1");
			osw.write(result);
			osw.close();
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			result=new String(ba.toByteArray(),"ISO-8859-1");
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		return result;
	}

	public static void main(String args[]) throws SAXException, IOException{
		String cadena="<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n<v>qué</v>";
		CharBuffer result = java.nio.CharBuffer.wrap(cadena.toCharArray());
		cadena=new String(java.nio.charset.Charset.forName("ISO-8859-1").newEncoder().encode(result).array(), "ISO-8859-1");
		DOMParser parser = new DOMParser();
		//  Parse the Document
		//  and traverse the DOM
		System.err.println(cadena);
		//	parser.setIncludeIgnorableWhitespace(false);
		parser.parse(new org.xml.sax.InputSource(new java.io.
				StringBufferInputStream(cadena)));
		Document document = parser.getDocument();

	}
}