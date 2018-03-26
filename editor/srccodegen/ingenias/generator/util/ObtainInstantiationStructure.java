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

package ingenias.generator.util;

import java.io.FileInputStream;
import java.io.PrintWriter;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class ObtainInstantiationStructure {

  public static String getStructure(String program) throws Exception {
    DOMParser parser = new DOMParser();
//  Parse the Document
//  and traverse the DOM
    parser.parse(new InputSource(new java.io.StringBufferInputStream(program)));

    Document doc = parser.getDocument();
    NodeList nl = doc.getElementsByTagName("program");
    if (nl.getLength() == 0) {
      throw new RuntimeException("There is no <program> tag");
    }

    Node programNode = nl.item(0);
    return getNodes(0, programNode);

  }

  public static String getNodes(int depth, Node n) {
    StringBuffer result = new StringBuffer();
    NodeList nl = n.getChildNodes();
    for (int k = 0; k < nl.getLength(); k++) {
      if (nl.item(k).getNodeName().toLowerCase().equals("repeat")) {
        String indentation = " ";
        for (int j = 0; j < depth; j++) {
          indentation = indentation + " ";
        }
        result.append(indentation + nl.item(k).getNodeName() + " id = " +
                      nl.item(k).getAttributes().getNamedItem("id").
                      getNodeValue()+"\n");
      }
      if (nl.item(k).getNodeName().toLowerCase().equals("v")) {
        String indentation = " ";
        for (int j = 0; j < depth; j++) {
          indentation = indentation + " ";
        }
        result.append(indentation + " v " +
                      nl.item(k).getChildNodes().item(0).getNodeValue()+"\n");
      }
      if (nl.item(k).hasChildNodes())
      result.append(getNodes(depth + 1, nl.item(k)));
    }
    return result.toString();
  }

  public static void main(String[] args) throws Exception {
        ingenias.editor.Log.initInstance(new PrintWriter(System.err));
    ObtainInstantiationStructure obtainInstantiationStructure1 = new
        ObtainInstantiationStructure();
    if (args.length != 1) {
      System.err.println(
          "Wrong format!!!!\n ObtainInstantiationStructure filename");
    }
    else {
      FileInputStream fis = new FileInputStream(args[0]);
      int read = fis.read();
      StringBuffer sb = new StringBuffer();
      while (read != -1) {
        sb.append( (char) read);
        read = fis.read();
      }
      fis.close();

      System.out.println(getStructure(Conversor.convertArrobaFormat(sb.toString())));
    }

  }

}