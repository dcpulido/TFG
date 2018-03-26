
/*
    Copyright (C) 2002 Jorge Gomez Sanz, Ruben Fuentes, Juan Pavon

    Modifications over original code from original version
    by Antony Miguel http://forum.java.sun.com/profile.jsp?user=8025


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

import java.lang.reflect.*;
import java.io.*;
import java.net.*;
import com.mtp.pounder.Player;
/**
 *
 * <p>Automatic class loader: </p>
 * <p>A class that loads automatically all jar libraries under lib folder and runs
 * the INGENIAS EDITOR</p>
 */
public class Runme {
  public Runme(){};

  private static final Class[] parameters = new Class[] {
      URL.class};

  public static void addFile(String s) throws IOException {
    File f = new File(s);
    addFile(f);
  } //end method

  public static void addFile(File f) throws IOException {
    addURL(f.toURL());
  } //end method

  public static void addURL(URL u) throws IOException {

    URLClassLoader sysloader = (URLClassLoader) ClassLoader.
        getSystemClassLoader();

    Class sysclass = URLClassLoader.class;

    try {
      Method method = sysclass.getDeclaredMethod("addURL", parameters);
      method.setAccessible(true);
      method.invoke(sysloader, new Object[] {u});
    }
    catch (Throwable t) {
      t.printStackTrace();
      throw new IOException("Error, could not add URL to system classloader");
    } //end try catch

  } //end method

  public static void main(String args[]) throws Exception{
    java.io.File lib=new  java.io.File("lib");
    File[] fs=lib.listFiles();
    for (int k=0;k<fs.length;k++){
      if (!fs[k].getName().toLowerCase().equals("ingeniaseditor.jar"))
     addFile(fs[k]);
     else {
       System.err.println(fs[k].getName());
     }
    }
    if (args.length>0){
      if (args[0].toLowerCase().equals("-t")){
        File tfiles=new File("tutorial");
        File[] tutorials=tfiles.listFiles();

        File selected=(File)javax.swing.JOptionPane.showInputDialog(null,
                                                "Select one tutorial",
                                                "tutorials",
                                                javax.swing.JOptionPane.QUESTION_MESSAGE,null,tutorials,tutorials[0]);
        if (selected!=null){
          Player player = new Player(selected.getPath());
          player.play();
        } else {
          System.exit(0);
        }
      } else {
        Class c=Class.forName("ingenias.editor.IDE");
        Method m=c.getMethod("main",new Class[]{String[].class});
        Object[] argl=new Object[args.length];
        System.arraycopy(args,0,argl,0,args.length);
        m.invoke(c,new Object[]{new String[0]});//args
      }

    } else {
        Class c=Class.forName("ingenias.editor.IDE");
        Method m=c.getMethod("main",new Class[]{String[].class});
        Object[] argl=new Object[args.length];
        System.arraycopy(args,0,argl,0,args.length);
        m.invoke(c,new Object[]{new String[0]});//args

    }
  }
}