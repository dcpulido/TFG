/*
 Copyright (C) 2002 Jorge Gomez Sanz
 
 This file is part of INGENIAS IDE, a support tool for the INGENIAS
 methodology, available at http://grasia.fdi.ucm.es/ingenias or
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

package ingenias.editor.editiondialog;

import ingenias.editor.CellHelpWindow;
import ingenias.editor.GraphManager;
import ingenias.editor.entities.Entity;
import ingenias.editor.widget.DnDJTree;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/*
import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
*/

public class GeneralEditionFrame extends javax.swing.JDialog implements java.io.Serializable {
	private JScrollPane mainscroll = new JScrollPane();
	public static final int CANCELLED=0;
	public static final int ACCEPTED=1;
	public static final int PROGRESSING=2;	
	
	private int status=PROGRESSING;
	
	
	public GeneralEditionFrame(ingenias.editor.Editor editor,
							   ingenias.editor.ObjectManager om,
							   GraphManager gm,
							   final Frame dialogOwner,
							   String title,
							   final Entity ent) {
		
		super(dialogOwner, title, true);
		
		final JPanel main = new JPanel();
		
		BorderLayout bl = new BorderLayout();
		//BoxLayout bl = new BoxLayout();
		
		main.setLayout(bl);
		
		this.getContentPane().add(main);
		
		main.addContainerListener(new java.awt.event.ContainerAdapter(){
			public void componentAdded(java.awt.event.ContainerEvent ce){
				pack();
			}
		});
		
		final JDialog self = this;
		
		final GeneralEditionPanel gep = new GeneralEditionPanel(editor, dialogOwner, om, gm, ent);

		main.add(mainscroll, BorderLayout.PAGE_START);
		//main.add(mainscroll,BoxLayout.PAGE_AXIS);
		mainscroll.getViewport().add(gep,null); 
		
		///*
		final JPanel helpPanel = new JPanel();
		
		final JLabel helpLabel = new JLabel("Recommendation");
		//helpLabel.setText("Recommendation"); 
		
		JButton helpClose = new JButton("Close");

		//Entity Model Recommendation
		final JTextPane helpRecom = new JTextPane();
		final JScrollPane schelpRecom = new JScrollPane(helpRecom,
												  JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
												  JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		schelpRecom.setMinimumSize(new Dimension(400, 200));
		schelpRecom.setPreferredSize(new Dimension(450, 400));
		schelpRecom.setVisible(false);
		
		helpRecom.setContentType("text/html");
		//helpRecom.setSize(580,300);
		helpRecom.setText(ent.getHelpRecom());
		helpRecom.setVisible(false);

		//Entity Description
		final JTextPane helpDesc = new JTextPane();
		final JScrollPane schelpDesc = new JScrollPane(helpDesc,
												  JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
												  JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		schelpDesc.setMinimumSize(new Dimension(400, 200));
		schelpDesc.setPreferredSize(new Dimension(450, 400));
		schelpDesc.setVisible(false);

		helpDesc.setContentType("text/html");
		//helpDesc.setSize(580,300);
		helpDesc.setText(ent.getHelpDesc());
		helpDesc.setVisible(false);

		//JScrollPane scrollPane = new JScrollPane(textArea);
		//helpPanel.add(schelpRecom, BorderLayout.CENTER);
		//schelpRecom.getViewport().add(helpRecom, null);
		//schelpRecom.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//schelpRecom.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				
		JPanel helpHeader = new JPanel();
		helpHeader.setLayout(new BorderLayout());
		helpHeader.add(helpClose, BorderLayout.LINE_END);
		helpHeader.add(helpLabel, BorderLayout.LINE_START);
		
		/*
		 panelCreating = new JPanel();
		 //panelCreating.setMinimumSize(new Dimension(160, 200));
		 //panelCreating.setPreferredSize(new Dimension(160, 200));
		 scrollPaneCreating = new JScrollPane(panelCreating,
		 JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
		 JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		 scrollPaneCreating.setMinimumSize(new Dimension(160, 200));
		 scrollPaneCreating.setPreferredSize(new Dimension(160, 200));
		 */

		//BorderLayout borderHelp = new BorderLayout();
		helpPanel.setLayout(new BoxLayout(helpPanel, BoxLayout.Y_AXIS));
		//helpPanel.setPreferredSize(new Dimension(350,300));
		helpPanel.add(helpHeader);
		helpPanel.add(schelpRecom, BoxLayout.Y_AXIS);
		helpPanel.add(schelpDesc, BoxLayout.Y_AXIS);
		helpPanel.setVisible(false);
		helpPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		//*/

		final JButton help = new JButton("Help");
		final JButton helpAbout = new JButton("About");

		helpClose.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent ae) {				
				System.out.println("Help Asked About "+ent+" Closed");
				helpLabel.setText("Recommendation");
				helpPanel.setVisible(false);
				mainscroll.setVisible(true);
				help.setVisible(true);
				helpAbout.setVisible(false);
				schelpRecom.setVisible(false);
				helpRecom.setVisible(false);
				schelpDesc.setVisible(false);
				helpDesc.setVisible(false);
			}
		});
		
		help.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent ae) {	
				System.out.println("Help asked "+ent);
				gep.undo();
				helpLabel.setText("Recommendation");
				helpPanel.setVisible(true);
				mainscroll.setVisible(false);
				help.setVisible(false);
				helpAbout.setVisible(true);	
				schelpRecom.setVisible(true);
				helpRecom.setVisible(true);
				schelpDesc.setVisible(false);
				helpDesc.setVisible(false);				
			}
		});
		
		helpAbout.setVisible(false);
		helpAbout.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent ae) {				
				System.out.println("Asked About "+ent);
				helpLabel.setText("General Information");
				helpPanel.setVisible(true);
				mainscroll.setVisible(false);
				help.setVisible(true);
				helpAbout.setVisible(false);	
				schelpRecom.setVisible(false);
				helpRecom.setVisible(false);
				schelpDesc.setVisible(true);
				helpDesc.setVisible(true);				
			}
		});
		
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent ae) {				
				gep.undo();
				self.setVisible(false);
				status=CANCELLED;
			}
		});
		
		JButton accept=new JButton("Accept");
		accept.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent ae) {				
				gep.confirmActions();
				System.out.println("Changes applied "+ent);
				self.setVisible(false);
				status=ACCEPTED;
				
			}
		});
		
		JPanel southButtons = new JPanel();
		
		southButtons.add(accept);
		
		southButtons.add(cancel);
		
		southButtons.add(helpAbout);
		
		southButtons.add(help);
		
		main.add(helpPanel, BorderLayout.LINE_START);
		
		main.add(southButtons, BorderLayout.PAGE_END);						
						
		/*
		 final CellHelpWindow chw = new CellHelpWindow();
		 chw.setDescription(ent.getHelpDesc());
		 chw.setRec(ent.getHelpRecom());
		 chw.setSize(600,600);						
		 chw.setLocation(400+dialogOwner.getLocation().x+getSize().width/2,120+dialogOwner.getLocation().y+getSize().height/2);
		 chw.hide();
		 
		 main.add(chw,BorderLayout.CENTER);
		 */
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				
				if (dialogOwner!=null)
					dialogOwner.requestFocusInWindow();
				
			}});
		
		self.requestFocusInWindow();
		setLocation(dialogOwner.getLocation().x+getSize().width/2,dialogOwner.getLocation().y+getSize().height/2);
		
	}
	
	public void pack(){
		super.pack();
		final JDialog jd = this;
		this.setSize(this.getSize().width+30, 150);
		
	}
	
	
	/*
	 	
	public static void main(String args[]){
		
		System.out.println("hola");
		System.err.println("hola");
		ingenias.editor.entities.INGENIASCodeComponent a = new ingenias.editor.entities.INGENIASCodeComponent("mio");
		a.setCode("hola que tal");
		GraphManager.initInstance(new DefaultMutableTreeNode(),new DnDJTree());
		
		GeneralEditionFrame ge=new GeneralEditionFrame(null,ingenias.editor.ObjectManager.initialise(new DefaultMutableTreeNode(),new JTree()),
													   ingenias.editor.GraphManager.initInstance(new DefaultMutableTreeNode(),new DnDJTree()),
													   null,"hola", a);
		
		
		ge.setVisible(true);
		System.out.println(a.getDescription());
		
		//System.out.println(a.getDescription());
		
	}
	 
	*/		
	
	
	public int getStatus() {
		return status;
	}
}