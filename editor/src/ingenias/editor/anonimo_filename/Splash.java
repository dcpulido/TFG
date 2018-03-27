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

public class Splash extends javax.swing.JWindow  implements java.io.Serializable {
	JLabel splash = new JLabel();
	GridLayout gridLayout1 = new GridLayout();
	
	public Splash(Window owner) {
		super(owner);
		javax.swing.ImageIcon ii=new ImageIcon("images/splash.png");
		splash.setIcon(ii);
		
		try {
			jbInit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void show(){
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		this.pack();
		System.err.println(d);
		this.setLocation(ingenias.editor.widget.GraphicsUtils.getCenter(this.getSize()));
		super.show();
		
	}
	
	public static void main(String[] args){
		Splash splash1 = new Splash(null);
		splash1.show();
	}
	
	private void jbInit() throws Exception {
		this.getContentPane().setLayout(gridLayout1);
		gridLayout1.setColumns(1);
		this.getContentPane().add(splash, null);
	}
	
}