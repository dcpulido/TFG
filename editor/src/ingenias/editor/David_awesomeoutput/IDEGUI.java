/*
 Copyright (C) 2002 Jorge Gomez Sanz, Ruben Fuentes, Juan Pavon
 
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

import ingenias.editor.widget.DnDJTree;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JEditorPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;



public abstract class IDEGUI extends javax.swing.JFrame  {
	
	public static JPanel rightPanel = new JPanel();
	
	/* File menu elements */	
	JMenu file = new JMenu();
	JMenuItem create = new JMenuItem();	
	JMenuItem newProject = new JMenuItem();
	JMenuItem load = new JMenuItem();
	private JMenuItem importFile = new JMenuItem();
	
	JMenuItem properties = new JMenuItem();	
	
	JMenuItem closeFile = new JMenuItem();
	JMenuItem save = new JMenuItem();
	JMenuItem saveas = new JMenuItem();
	JMenuItem exit = new JMenuItem();
	
	/* Edit menu elements */
	private JMenu edit = new JMenu();
	JMenuItem undo = new JMenuItem();
	JMenuItem redo = new JMenuItem();
	JMenuItem copy = new JMenuItem();
	JMenuItem paste = new JMenuItem();
	JMenuItem delete = new JMenuItem();
	JMenuItem selectall = new JMenuItem();
	private JMenuItem copyImage = new JMenuItem();
	JMenuItem cpClipboard = new JMenuItem();
	
	/* Project menu elements
	 JMenu project = new JMenu(); */
	
	/* Modules menu elements */
	JMenu menuModules = new JMenu();
	JMenu menuTools = new JMenu();
	JMenu menuCodeGenerator = new JMenu();
	
	/* Profiles menu elements */
	JMenu profiles=new JMenu();
	
	/* Preferences menu elements */
	JMenu preferences = new JMenu();
	JMenuItem  resizeAll= new JMenuItem();
	JMenuItem  resizeAllDiagrams= new JMenuItem();
	private JMenuItem elimOverlap;
	private JMenu modelingLanguageNotationSwitchMenu;
	private JMenu propertiesModeMenu;
	
	/* Help menu elements */	
	JMenu help = new JMenu();
	JMenuItem manual = new JMenuItem();
	JMenuItem about = new JMenuItem();
	JMenuItem forcegc = new JMenuItem();
	
	
	JTree arbolObjetos =new JTree();;
	
	/* Project view Browser */	
	DnDJTree arbolProyectos = new DnDJTree();//rootProject);
	Border borderForProjectView;
	
	/* Entities view Browser */
	Border borderForEntitiesView;
	
	BorderLayout borderLayout2 = new BorderLayout();
	JPanel buttonModelPanel=new JPanel(new java.awt.BorderLayout());
	JMenuItem clearMessages = new JMenuItem();	
	
	// GraphManager gm=GraphManager.initInstance(rootProject,arbolProyectos);
	protected JCheckBoxMenuItem editOnMessages;
	protected JCheckBoxMenuItem editPopUpProperties;
	
	JRadioButtonMenuItem  enableINGENIASView= new JRadioButtonMenuItem();
	JRadioButtonMenuItem  enableUMLView= new JRadioButtonMenuItem();
	
	private JRadioButtonMenuItem fullinforelats;
	BorderLayout gridLayout1 = new BorderLayout();
	GridLayout gridLayout2 = new GridLayout();
	
	private JMenu jMenu3;
	JPanel jPanel1 = new JPanel();
	private JPanel jPanel2;
	JSplitPane jSplitPane1 = new JSplitPane();
	JSplitPane splitPanelDiagramMessagesPaneSeparator = new JSplitPane();
	private JRadioButtonMenuItem labelsonly;
	
	JTextPane logs = new JTextPane();
	JMenuBar mainMenuBar = new JMenuBar();
	JPopupMenu messagesMenu = new JPopupMenu();
	JTabbedPaneWithCloseIcons messagespane = new JTabbedPaneWithCloseIcons();
	JTextPane moduleOutput = new JTextPane();
	JTextPane moutput = new JTextPane();
	
	JRadioButtonMenuItem noinformationrelats = new JRadioButtonMenuItem();
	JScrollPane outputpane = new JScrollPane();
	JPanel pprin = new JPanel();
	ButtonGroup propertiesEditModeSelection= new ButtonGroup();
	ButtonGroup relationshipSelection= new ButtonGroup();
	javax.swing.tree.DefaultMutableTreeNode rootObjetos=
	new javax.swing.tree.DefaultMutableTreeNode("System Objects");
	javax.swing.tree.DefaultMutableTreeNode rootProject=
	new javax.swing.tree.DefaultMutableTreeNode("Project");
	
	JScrollPane scrollLogs = new JScrollPane();
	JScrollPane scrolloutput = new JScrollPane();
	JScrollPane scrollPaneForEntitiesView = new JScrollPane();
	JScrollPane scrollPaneForProyectView = new JScrollPane();
	
	private JButton Search;
	
	JEditorPane searchDiagramPanel= new JEditorPane();
	
	protected JTextField searchField;
	
	private JPanel searchPanel;
	
	JSplitPane splitPaneSeparatingProjectsAndEntitiesView = new JSplitPane();
	
	JMenuItem  switchINGENIASView= new JMenuItem();
	JMenuItem  switchUMLView= new JMenuItem();
	
	TitledBorder titleBoderForProjectView;	
	TitledBorder titledBorderForEntitiesView;
	TitledBorder titledBorderForMessagesPane;
	
	ButtonGroup viewSelection= new ButtonGroup();
	JProgressBar pbar=new JProgressBar(1,100);
	
	public IDEGUI() {
		// To enable changes in cursor's shape
		this.getGlassPane().addMouseListener(new MouseAdapter(){});
		
		try {
			jbInit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void about_actionPerformed(ActionEvent e) {
		
	}	
	
	void arbolObjetos_mouseClicked(MouseEvent e) {
		
	}
	
	void arbolProyectos_mouseClicked(MouseEvent e) {
		
	}
	
	void arbolProyectos_mouseEntered(MouseEvent e) {
		
	}
	
	void arbolProyectos_mouseExited(MouseEvent e) {
		
	}
	
	void arbolProyectos_mousePressed(MouseEvent e) {
		
	}
	
	void arbolProyectos_mouseReleased(MouseEvent e) {
		
	}
	
	void capture_actionPerformed(ActionEvent e) {
	}
	
	public void changePropertiesPanel(String oldName,String nname){
		for (int k=0;k<messagespane.getTabCount();k++){
			if (messagespane.getTitleAt(k).equalsIgnoreCase(oldName)){
				messagespane.setTitleAt(k,nname);
			}
		}
	}
	
	void clearMessages_actionPerformed(ActionEvent e, JTextPane pane) {
		
	}
	
	void copy_actionPerformed(ActionEvent e) {
		
	}
	
	void cpClipboard_actionPerformed(ActionEvent e) {
		
	}
	
	void delete_actionPerformed(ActionEvent e) {
		
	}
	
	public void editOnMessages_selected() {
		// TODO Auto-generated method stub
		
	}
	
	public void editPopUpProperties_selected() {
		// TODO Auto-generated method stub
		
	};
	
	void elimOverlapActionPerformed(ActionEvent evt) {
		System.out.println("elimOverlap.actionPerformed, event=" + evt);
		//TODO add your code for elimOverlap.actionPerformed
	}
	
	void elimOverlapKeyPressed(KeyEvent evt) {
		System.out.println("elimOverlap.keyPressed, event=" + evt);
		//TODO add your code for elimOverlap.keyPressed
	}
	
	void elimOverlapMenuKeyTyped(MenuKeyEvent evt) {
		System.out.println("elimOverlap.menuKeyTyped, event=" + evt);
		//TODO add your code for elimOverlap.menuKeyTyped
	}
	
	void enableINGENIASView_actionPerformed(ActionEvent e) {
		
	}
	
	void enableRelatinshipLabels_actionPerformed(ActionEvent e) {
		
	}
	
	void enableUMLView_actionPerformed(ActionEvent e) {
		
	}
	
	void exit_actionPerformed(ActionEvent e) {
		
	}
	
	void forcegc_actionPerformed(ActionEvent e) {
		
	}
	
	public JPanel getButtonModelPanel() {
		return buttonModelPanel;
	}
	
	void importFileActionPerformed(ActionEvent evt) {
		System.out.println("importFile.actionPerformed, event=" + evt);
		//TODO add your code for importFile.actionPerformed
	}
	
	public boolean isEditPropertiesPopUp(){		 
		return this.editPopUpProperties.isSelected();
	}
	
	private void jbInit() throws Exception {
		/* Project view browser */
		
		borderForProjectView = BorderFactory.createLineBorder(Color.black,2);
		titleBoderForProjectView = new TitledBorder(borderForProjectView,"Project view");
		
		/* Entities view browser */
		
		borderForEntitiesView = BorderFactory.createLineBorder(Color.black,2);
		titledBorderForEntitiesView = new TitledBorder(borderForEntitiesView,"Entities view");
		
		/* Messages window pane */
		
		titledBorderForMessagesPane = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140)),"Messages");
		
		this.getContentPane().setLayout(borderLayout2);
		
		/* File menu */
		
		file.setText("File");
		
		file.add(this.create);
		this.create.setText("New Project...");
		create.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newProject_actionPerformed(e);
			}
		});
		
		file.add(newProject);
		newProject.setText("New File...");
		newProject.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newFile_actionPerformed(e);
			}
		});
		
		file.add(load);
		load.setText("Open...");
		load.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				load_actionPerformed(e);
			}
		});
		
		file.add(importFile);
		importFile.setText("Add FileSpec...");
		importFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				importFileActionPerformed(evt);
			}
		});
		
		file.addSeparator();
		
		file.add(this.properties);
		this.properties.setText("Properties");
		properties.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				properties_actionPerformed(e);
			}
		});
		
		file.addSeparator();
		
		file.add(closeFile);
		closeFile.setText("Close File...");
		closeFile.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close_actionPerformed(e);
			}
		});
		
		file.add(save);
		save.setEnabled(false);
		save.setText("Save");
		save.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save_actionPerformed(e);
			}
		});
		
		file.add(saveas);
		saveas.setText("Save as");
		saveas.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e) {
				saveas_actionPerformed(e);
			}
		});
		
		file.addSeparator();
		
		file.add(exit);
		exit.setText("Exit");
		exit.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e) {
				exit_actionPerformed(e);
			}
		});
		
		file.addSeparator();
		
		
		/* 
		   TO DO:
	          - Open Recent File      // Modify the actual listing
		      - Open Recent Project   // Will require a new variable
		      - Close Window          // This effect is clear the diagram panel
		      - Close File            // New File has this effect actually
		      - Revert to Saved       // Revert to last change saved simply reload actual file
		      - Print                 // Similar to copy diagram or to generate document
		*/ 
		
		/* Edit menu */
		
		edit.setText("Edit");
		
		edit.add(undo);
		undo.setText("Undo");
		undo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				undo_actionPerformed(e);
			}
		});
		
		edit.add(redo);
		redo.setText("Redo");
		redo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				redo_actionPerformed(e);
			}
		});
		
		edit.addSeparator();
		
		edit.add(copy);
		copy.setText("Copy");
		copy.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e) {
				copy_actionPerformed(e);
			}
		});
		
		edit.add(paste);
		paste.setText("Paste");
		paste.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e) {
				paste_actionPerformed(e);
			}
		});
		
		edit.add(delete);
		delete.setText("Delete");
		delete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_actionPerformed(e);
			}
		});
		
		edit.add(selectall);
		selectall.setText("Select all");
		selectall.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectall_actionPerformed(e);
			}
		});
		
		edit.addSeparator();
		
		edit.add(copyImage);
		copyImage.setText("Copy diagram as a file");
		copyImage.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e) {
				capture_actionPerformed(e);
			}
		});
		
		edit.add(cpClipboard);		
		cpClipboard.setText("Copy diagram to clipboard");
		cpClipboard.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cpClipboard_actionPerformed(e);
			}
		});
		
		/* Project menu */
		
		/* project.setText("Project"); */
		
		/* project.addSeparator();*/
		
		/* Modules menu */
		
		menuModules.setText("Modules");
		
		menuModules.add(menuTools);
		menuTools.setText("Tools");
		
		menuModules.addSeparator();
		
		menuModules.add(menuCodeGenerator);
		menuCodeGenerator.setText("Code Generator");
		
		/* Profiles menu */
		
		profiles.setText("Profiles");
		
		
		/* Preferences menu */
		
		preferences.setText("Preferences");
		
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setJMenuBar(mainMenuBar);
		this.setTitle("INGENIAS Development Kit");
		this.setSize(800, 600);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				this_windowClosed(e);
			}
			public void windowClosing(WindowEvent e) {
				this_windowClosing(e);
			}
		});
		
		splitPaneSeparatingProjectsAndEntitiesView.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPaneSeparatingProjectsAndEntitiesView.setBottomComponent(scrollPaneForEntitiesView);
		splitPaneSeparatingProjectsAndEntitiesView.setTopComponent(scrollPaneForProyectView);
		
		jPanel1.setLayout(gridLayout1);
		arbolObjetos.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				arbolObjetos_mouseClicked(e);
			}
		});
		
		scrollPaneForProyectView.setAutoscrolls(true);
		scrollPaneForProyectView.setBorder(titleBoderForProjectView);
		scrollPaneForEntitiesView.setBorder(titledBorderForEntitiesView);
		
		help.setText("Help");
		
		manual.setText("Tool manual");
		manual.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e) {
				manual_actionPerformed(e);
			}
		});
		
		about.setText("About IDK");
		about.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(ActionEvent e) {
				about_actionPerformed(e);
			}
		});
		
		splitPanelDiagramMessagesPaneSeparator.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPanelDiagramMessagesPaneSeparator.setLastDividerLocation(150);
		
		pprin.setLayout(new BorderLayout());
		pprin.setName("DiagramPane");
		pprin.setPreferredSize(new Dimension(400, 300));
		pprin.add(BorderLayout.SOUTH,pbar);
		pbar.setVisible(false);
		
		jSplitPane1.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		
		scrollLogs.setBorder(titledBorderForMessagesPane);
		scrollLogs.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				jScrollPane3_keyPressed(e);
			}
		});
		this.clearMessages.setText("Clear");
		clearMessages.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearMessages_actionPerformed(e, (JTextPane)messagesMenu.getInvoker());
			}
		});
		forcegc.setText("Force GC");
		forcegc.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				forcegc_actionPerformed(e);
			}
		});
		
		moutput.setEditable(false);
		moutput.setSelectionStart(0);
		moutput.setText("");
		moduleOutput.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				moduleOutput_mouseClicked(e);
			}
		});
		moduleOutput.setFont(new java.awt.Font("Monospaced", 0, 11));
		logs.setContentType("text/html");
		logs.setEditable(false);
		logs.setText("");
		logs.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				logs_mouseClicked(e);
			}
		});
		logs.addComponentListener(new java.awt.event.ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				logs_componentResized(e);
			}
		});
		
		enableUMLView.setToolTipText("UML view" +
									 "instead of its type");
		enableUMLView.setText("Enable UML view from now on");
		enableUMLView.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enableUMLView_actionPerformed(e);
			}
		});
		enableINGENIASView.setToolTipText("INGENIAS view");
		enableINGENIASView.setText("Enable INGENIAS view from now on");
		enableINGENIASView.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enableINGENIASView_actionPerformed(e);
			}
		});
		
		switchINGENIASView.setToolTipText("Switch to INGENIAS view");
		switchINGENIASView.setText("Switch to INGENIAS view");
		switchINGENIASView.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchINGENIASView_actionPerformed(e);
			}			
		});
		
		switchUMLView.setToolTipText("Switch to UML view");
		switchUMLView.setText("Switch to UML view");
		switchUMLView.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchUMLView_actionPerformed(e);
			}			
		});
		
		resizeAll.setToolTipText("Resize all");
		resizeAll.setText("Resize all entities within current diagram");
		resizeAll.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resizeAll_actionPerformed(e);
			}
		});
		
		resizeAllDiagrams.setToolTipText("Resize all diagrams");
		resizeAllDiagrams.setText("Resize all entities within all defined diagram");
		resizeAllDiagrams.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resizeAllDiagrams_actionPerformed(e);
			}
		});
		
		preferences.add( resizeAll);
		preferences.add( resizeAllDiagrams);
		{
			elimOverlap = new JMenuItem();
			preferences.add(elimOverlap);
			elimOverlap.setText("Eliminate overlap");
			elimOverlap.setAccelerator(KeyStroke.getKeyStroke("F3"));
			elimOverlap.addMenuKeyListener(new MenuKeyListener() {
				public void menuKeyPressed(MenuKeyEvent evt) {
					System.out.println("elimOverlap.menuKeyPressed, event="
									   + evt);
					//TODO add your code for elimOverlap.menuKeyPressed
				}
				public void menuKeyReleased(MenuKeyEvent evt) {
					System.out.println("elimOverlap.menuKeyReleased, event="
									   + evt);
					//TODO add your code for elimOverlap.menuKeyReleased
				}
				public void menuKeyTyped(MenuKeyEvent evt) {
					elimOverlapMenuKeyTyped(evt);
				}
			});
			elimOverlap.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent evt) {
					elimOverlapKeyPressed(evt);
				}
			});
			elimOverlap.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					elimOverlapActionPerformed(evt);
				}
			});
		}
		{
			modelingLanguageNotationSwitchMenu = new JMenu();
			preferences.add(modelingLanguageNotationSwitchMenu);
			modelingLanguageNotationSwitchMenu.setText("Modelling language");
			modelingLanguageNotationSwitchMenu.add(enableINGENIASView);
			
			viewSelection.add(enableINGENIASView);
			modelingLanguageNotationSwitchMenu.add(enableUMLView);
			viewSelection.add(enableUMLView);
			
			enableINGENIASView.setSelected(true);
			modelingLanguageNotationSwitchMenu.add(switchUMLView);
			modelingLanguageNotationSwitchMenu.add(switchINGENIASView);
		}
		{
			propertiesModeMenu = new JMenu();
			preferences.add(propertiesModeMenu);
			propertiesModeMenu.setText("Edit Properties Mode");
			{
				editPopUpProperties = new JCheckBoxMenuItem();
				propertiesModeMenu.add(editPopUpProperties);
				editPopUpProperties
				.setText("Edit Properties in a PopUp Window");
				editPopUpProperties.setSelected(true);
				editPopUpProperties.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						editPopUpProperties_selected();						
					}
				}	);
				propertiesEditModeSelection.add(editPopUpProperties);
			}
			{
				editOnMessages = new JCheckBoxMenuItem();
				propertiesModeMenu.add(editOnMessages);
				editOnMessages.setText("Edit Properties in Messages Panel");
				propertiesEditModeSelection.add(editOnMessages);
				editOnMessages.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						editOnMessages_selected();						
					}
				}	);
			}
		}
		
		mainMenuBar.add(file);
		mainMenuBar.add(edit);
		/*mainMenuBar.add(project);*/
		mainMenuBar.add(menuModules);
		mainMenuBar.add(profiles);
		mainMenuBar.add(preferences);
		mainMenuBar.add(help);
		
		rightPanel.setLayout(new BorderLayout());
		rightPanel.add(buttonModelPanel, BorderLayout.WEST);
		this.getContentPane().add(jSplitPane1, BorderLayout.CENTER);
		rightPanel.add(splitPanelDiagramMessagesPaneSeparator,BorderLayout.CENTER);
		jSplitPane1.add(splitPaneSeparatingProjectsAndEntitiesView, JSplitPane.LEFT);
		splitPaneSeparatingProjectsAndEntitiesView.add(scrollPaneForProyectView, JSplitPane.TOP);
		{
			jPanel2 = new JPanel();
			BorderLayout jPanel2Layout = new BorderLayout();
			jPanel2.setLayout(jPanel2Layout);
			splitPaneSeparatingProjectsAndEntitiesView.add(jPanel2, JSplitPane.BOTTOM);
			jPanel2.add(jPanel1, BorderLayout.SOUTH);
			jPanel2.add(scrollPaneForEntitiesView, BorderLayout.CENTER);
		}
		jSplitPane1.add(rightPanel, JSplitPane.RIGHT);
		splitPanelDiagramMessagesPaneSeparator.add(pprin, JSplitPane.TOP);
		splitPanelDiagramMessagesPaneSeparator.add(messagespane, JSplitPane.BOTTOM);
		JScrollPane scrollSearchDiagram=new JScrollPane();
		scrollSearchDiagram.getViewport().add(searchDiagramPanel,null);
		searchDiagramPanel.setContentType("text/html");
		searchDiagramPanel.setEditable(false);
		
		
		messagespane.addConventionalTab(scrollLogs,   "Logs");			
		scrollLogs.getViewport().add(logs, null);
		scrolloutput.getViewport().add(this.moduleOutput, null);
		messagespane.addConventionalTab(scrolloutput,  "Module Output");
		messagespane.addConventionalTab(scrollSearchDiagram, "Search");
		scrolloutput.getViewport().add(moduleOutput, null);
		{
			searchPanel = new JPanel();
			FlowLayout searchPanelLayout = new FlowLayout();
			searchPanelLayout.setVgap(1);
			searchPanel.setLayout(searchPanelLayout);
			jPanel1.add(searchPanel, BorderLayout.SOUTH);
			searchPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			{
				searchField = new JTextField();
				searchPanel.add(searchField);
				searchField.setColumns(15);
				
				searchField.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent evt) {
						searchFieldKeyTyped(evt);
					}
				});
			}
			{
				Search = new JButton();
				scrollPaneForProyectView.setViewportView(arbolProyectos);
				scrollPaneForEntitiesView.setViewportView(arbolObjetos);
				searchPanel.add(Search);
				
				Search.setIcon(new ImageIcon("images/lense.png"));
				Search.setPreferredSize(new java.awt.Dimension(20, 18));
				Search.setIconTextGap(0);
				Search.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						SearchActionPerformed(evt);
						System.err.println("invocando");
					}
				});
			}
		}
		
		help.add(manual);
		help.add(about);
		help.add(forcegc);
		
		messagesMenu.add(this.clearMessages);
		
		jSplitPane1.setDividerLocation(250);
		splitPaneSeparatingProjectsAndEntitiesView.setDividerLocation(250);
		arbolProyectos.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				arbolProyectos_mouseClicked(e);
			}
		});
		splitPanelDiagramMessagesPaneSeparator.setDividerLocation(400);
	}
	void jScrollPane3_keyPressed(KeyEvent e) {
		/*   System.err.println("pulsado");
		 */
	}
	abstract void load_actionPerformed(ActionEvent e) ;
	
	void logs_componentHidden(ComponentEvent e) {
		
	}
	void logs_componentMoved(ComponentEvent e) {
		
	}
	void logs_componentResized(ComponentEvent e) {
		//		System.err.println("pulsado");
		Point p=new Point(0,(int)logs.getSize().getHeight());
		scrollLogs.getViewport().setViewPosition(p);
		/*   Point p=scrollLogs.getViewport().getGraphLayoutCachePosition();
		 p.y=p.y+10;
		 scrollLogs.getViewport().setViewPosition(p);*/
	}
	void logs_componentShown(ComponentEvent e) {
		
	}
	void logs_mouseClicked(MouseEvent e) {
		
	}
	
	void logs_mouseEntered(MouseEvent e) {
		
	}
	void logs_mouseExited(MouseEvent e) {
		
	}
	
	void logs_mousePressed(MouseEvent e) {
		
	}
	
	void logs_mouseReleased(MouseEvent e) {
		
	}
	
	void manual_actionPerformed(ActionEvent e) {
		
	}
	
	void moduleOutput_mouseClicked(MouseEvent e) {
		
	}
	
	void newFile_actionPerformed(ActionEvent e) {
		
	}
	
	void newProject_actionPerformed(ActionEvent e) {
		
	}
	
	void paste_actionPerformed(ActionEvent e) {
		
	}
	
	void properties_actionPerformed(ActionEvent e) {
		
	}
	
	void redo_actionPerformed(ActionEvent e) {
		
	}
	public void replaceCurrentTrees(DnDJTree arbolProyecto, JTree arbolObjetos2){
		this.arbolProyectos=arbolProyecto;
		this.arbolObjetos=arbolObjetos2;
		arbolObjetos.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				arbolObjetos_mouseClicked(e);
			}
		});
		scrollPaneForProyectView.setViewportView(arbolProyectos);
		scrollPaneForEntitiesView.setViewportView(arbolObjetos);
		arbolProyectos.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				arbolProyectos_mouseClicked(e);
			}
		});
		this.arbolProyectos.setCellRenderer(new ProjectTreeRenderer());
		this.arbolObjetos.setCellRenderer(new ProjectTreeRenderer());
	}
	
	void resizeAll_actionPerformed(ActionEvent e) {
	}
	
	void resizeAllDiagrams_actionPerformed(ActionEvent e) {
	};
	
	void close_actionPerformed(ActionEvent e) {		
	}
	
	void save_actionPerformed(ActionEvent e) {
	}
	
	void saveas_actionPerformed(ActionEvent e) {
	}
	
	public void SearchActionPerformed(ActionEvent evt) {
		System.out.println("Search.actionPerformed, event=" + evt);
		//TODO add your code for Search.actionPerformed
	}
	
	abstract public void searchFieldKeyTyped(KeyEvent evt);
	
	void selectall_actionPerformed(ActionEvent e) {
		
	}
	
	
	
	
	
	public void setButtonModelPanel(JPanel buttonModelPanel) {
		this.buttonModelPanel = buttonModelPanel;
	}
	
	public void switchINGENIASView_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.err.println("ejec1");
		
	}
	
	
	
	
	
	public void switchUMLView_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	void this_windowClosed(WindowEvent e) {
		
	}
	
	/*public void labelsonlyActionPerformed(ActionEvent evt) {
	 System.out.println("labelsonly.actionPerformed, event=" + evt);
	 //TODO add your code for labelsonly.actionPerformed
	 }
	 
	 public void noinformationrelatsActionPerformed(ActionEvent evt) {
	 System.out.println("noinformationrelats.actionPerformed, event=" + evt);
	 //TODO add your code for noinformationrelats.actionPerformed
	 }
	 
	 public void fullinforelatsActionPerformed(ActionEvent evt) {
	 System.out.println("fullinforelats.actionPerformed, event=" + evt);
	 
	 }*/
	
	void this_windowClosing(WindowEvent e) {
		
	};
	void undo_actionPerformed(ActionEvent e) {
		
	};
	
}