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

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class About extends JDialog  implements java.io.Serializable {
  JLabel splash = new JLabel();
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JTextPane jTextPane1 = new JTextPane();
  BorderLayout borderLayout2 = new BorderLayout();
  JButton close = new JButton();

  public About(){
    super((Frame)null,"ABOUT",true);


   /* javax.swing.ImageIcon ii=new ImageIcon("images/splash.png");
    splash.setIcon(ii);*/
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    About about1 = new About();
    about1.pack();
    about1.show();
  }
  private void jbInit() throws Exception {
    this.getContentPane().setLayout(borderLayout1);
    jTextPane1.setContentType("text/html");
    jTextPane1.setBackground(new Color(0, 0, 173));
    jTextPane1.setFont(new java.awt.Font("Dialog", 1, 12));
    jTextPane1.setForeground(Color.yellow);
    jTextPane1.setBorder(BorderFactory.createEtchedBorder());
    jTextPane1.setEditable(false);
    jTextPane1.setText("<html><body>" +
    		"<Font color=\"#ffffcc\"><b><CENTER>INGENIAS Development Kit</CENTER><br>" +
    		"Version 2.8 (Release Aranjuez)<p>developed by: <br>Jorge Gomez Sanz (jjgomez@sip.ucm.es)<br>Ruben Fuentes (ruben@sip.ucm.es)<br>Juan Pav&oacute;n (jpavon@sip.ucm.es)</b></font></body></html>");
    jPanel1.setLayout(borderLayout2);
    close.setText("Close");
    close.addActionListener(new About_close_actionAdapter(this));
    this.getContentPane().add(splash, BorderLayout.CENTER);
    this.getContentPane().add(jPanel1,  BorderLayout.SOUTH);
    jPanel1.add(jTextPane1, BorderLayout.CENTER);
    jPanel1.add(close, BorderLayout.SOUTH);
    this.setResizable(false);
  }

  void close_actionPerformed(ActionEvent e) {
   this.hide();
  }
}

class About_close_actionAdapter implements java.awt.event.ActionListener,  java.io.Serializable  {
  About adaptee;

  About_close_actionAdapter(About adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.close_actionPerformed(e);
  }
}
