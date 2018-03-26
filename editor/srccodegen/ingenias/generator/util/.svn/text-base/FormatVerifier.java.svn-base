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
import java.io.*;
import java.nio.charset.*;
import java.nio.*;


public class FormatVerifier {
  public static void verify(String file){
    StringBuffer sb = new StringBuffer();
    try {
      InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
      isr.markSupported();
      int cont = 0;
      boolean error=false;
      int line=1;
      int chars=0;
      while (cont != -1 && !error) {
        cont = isr.read();
        if (cont != -1){
          char nc=(char)cont;
          if (nc=='\n') {line++;chars=1;} else chars++;
          sb.append(nc);
          try {
            CharBuffer cb=Charset.forName("UTF8").newDecoder().onMalformedInput(
                CodingErrorAction.REPORT).decode(ByteBuffer.wrap(sb.toString().getBytes()));
          }catch  (MalformedInputException mie){
//              System.err.println(sb.toString());
              ingenias.editor.Log.getInstance().logERROR("ERROR parsing. Not in UTF-8 "+line+":"+chars);

              error=true;
          }

        }
      }
      isr.close();
//    System.err.println(sb.toString());


    }
    catch (Exception uee) {
      ingenias.editor.Log.getInstance().logERROR(uee.getMessage());
    }

  }
  public static void main(String[] args) {
    ingenias.editor.Log.initInstance(new PrintWriter(System.err));
   verify(args[0]);
   System.exit(0);
  }
}