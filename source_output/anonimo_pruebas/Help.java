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
import java.io.*;
import java.awt.event.*;

public class Help
extends JFrame
implements java.io.Serializable {
	JScrollPane scrollhelp = new JScrollPane();
	JTextPane helpPane = new JTextPane();
	JButton close = new JButton();
	
	public Help() {
		super("Help");
		try {
			jbInit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadHelp(String file) {
		try {
			FileInputStream fis = new FileInputStream(file);
			String res = "";
			int read = 1;
			byte[] bs = new byte[2000];
			while (read > 0) {
				read = fis.read(bs);
				if (read > 0) {
					res = res + new String(bs, 0, read);
				}
			}
			//    System.err.println(res);
			helpPane.setContentType("text/html");
			helpPane.setText(res);
			helpPane.setCaretPosition(0);
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	private void jbInit() throws Exception {
		helpPane.setEditable(false);
		helpPane.setText("jTextPane1");
		close.setText("Close");
		close.addActionListener(new Help_close_actionAdapter(this));
		this.getContentPane().add(scrollhelp, BorderLayout.CENTER);
		this.getContentPane().add(close, BorderLayout.SOUTH);
		scrollhelp.getViewport().add(helpPane, null);
	}
	
	void close_actionPerformed(ActionEvent e) {
		this.hide();
	}
	
	public static void main(String args[]) {
		JFrame jf=new JFrame();
		JButton jb=new JButton("prueba");
		jf.getContentPane().add(jb);
		jb.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Help h = new Help();
				h.loadHelp("doc/help/index.htm");
				JFrame.setDefaultLookAndFeelDecorated(true);
				h.helpPane.setCaretPosition(0);
				h.pack();
				h.setExtendedState(JFrame.MAXIMIZED_BOTH);
				h.show();
				
			}
		});
		jf.pack();
		jf.show();
		
		System.err.println("hola");
	}
	
}

class Help_close_actionAdapter
implements java.awt.event.ActionListener, java.io.Serializable {
	Help adaptee;
	
	Help_close_actionAdapter(Help adaptee) {
		this.adaptee = adaptee;
	}
	
	public void actionPerformed(ActionEvent e) {
		adaptee.close_actionPerformed(e);
	}
}