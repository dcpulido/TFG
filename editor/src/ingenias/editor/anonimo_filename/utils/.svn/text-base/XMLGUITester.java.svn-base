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

package ingenias.editor.utils;

import java.awt.BorderLayout;
import java.io.FileInputStream;

import javax.swing.JFrame;

import org.swixml.SwingEngine;


public class XMLGUITester {


  public static void main(String args[]) throws Exception {
    String result="";
    SwingEngine se = ingenias.editor.cell.SWIRenderer.getSWIEngine();
//    se.getTaglib().registerTag("dashedpanel",ingenias.editor.rendererxml.DashedBorderPanel.class);
    FileInputStream fis =  new FileInputStream(args[0]);
    StringBuffer sb = new StringBuffer();
    int read = 0;
    while (read != -1) {
      read = fis.read();
      if (read != -1) {
        sb.append( (char) read);
      }
    }
    ;
    fis.close();

    result = sb.toString();
    result = result.replaceAll("##", "<");
    result = result.replaceAll("#", ">");
    JFrame jf=new JFrame();
    jf.getContentPane().setLayout(new BorderLayout());
    jf.getContentPane().add(se.render(new java.io.StringReader(result)), BorderLayout.CENTER);
    jf.pack();
    jf.show();
;
  }
}