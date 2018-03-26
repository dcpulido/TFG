/**
 * 
 */
package ingenias.editor;

import ingenias.editor.entities.Entity;
import ingenias.editor.events.*;
import ingenias.generator.browser.Browser;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import org.jgraph.JGraph;
import org.jgraph.graph.DefaultGraphCell;

public class ButtonToolBar extends JToolBar {
	/**
	 * 
	 */
	private final Editor editor;
	JComboBox jc = new JComboBox(new Object[] {"automatic", "manual"});
	// Actions which Change State
	/**
	 *  Description of the Field
	 */
	protected Action undo, redo, remove, group, ungroup, tofront, toback,
	cut;
	protected EventRedirector copy;
	protected EventRedirectorPaste paste;
	private GraphManager gm;
	protected ObjectManager om;

	public ButtonToolBar(Editor editor, final GraphManager gm, final ObjectManager om){
		this.editor = editor;
		this.setFloatable(false);
		this.gm=gm;
		this.om=om;
		JButton jb = null;
		// Toggle Connect Mode
		/*		Image img_connecton = ImageLoader.getImage("images/connecton.gif");
		 if (graph!=null)
		 graph.setPortsVisible(true);
		 ImageIcon connectIcon = new ImageIcon(img_connecton);
		 jb=new JButton(
		 new AbstractAction("", connectIcon) {
		 public void actionPerformed(ActionEvent e) {
		 if (graph!=null){
		 graph.setPortsVisible(!graph.isPortsVisible());
		 Image img_connect;
		 if (graph.isPortsVisible()) {
		 img_connect = ImageLoader.getImage("images/connecton.gif");
		 }
		 else {
		 img_connect = ImageLoader.getImage("images/connectoff.gif");
		 }
		 ImageIcon connectIcon = new ImageIcon(img_connect);
		 putValue(SMALL_ICON, connectIcon);
		 }
		 }
		 });
		 jb.setToolTipText("View connection ports");
		 toolbar.add(jb);*/

		// Automatic layout


		JPanel jp = new JPanel();
		jp.setAlignmentX(JPanel.LEFT_ALIGNMENT);
		jp.add(new JLabel("Relationship Layout"));
		jp.add(jc);

		this.add(jp);
		
		this.addSeparator();
		Image img_resize = ImageLoader.getImage("images/arrow_inout.png");
		ImageIcon resizeIcon = new ImageIcon(img_resize);
		JButton resize=new JButton(resizeIcon);
		resize.setToolTipText("Resize");
		
		resize.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				if (ButtonToolBar.this.editor.getGraph() != null) {
					new ingenias.editor.actions.ResizeCurrentDiagramAction(ButtonToolBar.this.editor).resizeCurrentDiagram(arg0);					
					
				}
				
			}
			
		});
		this.add(resize);
		

		// Undo
		this.addSeparator();
		Image img_undo = ImageLoader.getImage("images/undo.gif");
		ImageIcon undoIcon = new ImageIcon(img_undo);
		this.undo =
			new AbstractAction("", undoIcon) {

			public void actionPerformed(ActionEvent e) {
				ButtonToolBar.this.editor.undo();
			}
		};
		this.undo.setEnabled(false);
		jb = new JButton(this.undo);
		jb.setToolTipText("Undo an action");
		this.add(jb);
		// Redo
		Image img_redo = ImageLoader.getImage("images/redo.gif");
		ImageIcon redoIcon = new ImageIcon(img_redo);
		redo =
			new AbstractAction("", redoIcon) {

			public void actionPerformed(ActionEvent e) {
				if (ButtonToolBar.this.editor.getGraph() != null) {
					ButtonToolBar.this.editor.redo();
				}
			}
		};
		redo.setEnabled(false);
		jb = new JButton(redo);
		jb.setToolTipText("Redo last action");
		this.add(jb);

		//
		// Edit Block
		//
		this.addSeparator();
		Action action;
		Image img;


		JGraph jg=new JGraph();// fake graph to extract initial action handlers
		// Copy
		action = jg.getTransferHandler().getCopyAction();
		img = ImageLoader.getImage("images/page_copy.png");
		action.putValue(Action.SMALL_ICON, new ImageIcon(img));
		copy = new EventRedirector(this.editor, action,new ImageIcon(img));
		this.add(copy);						

		// Paste
		action = jg.getTransferHandler().getPasteAction();
		img = ImageLoader.getImage("images/page_paste.png");		

		action.putValue(Action.SMALL_ICON, new ImageIcon(img));
		paste = new EventRedirectorPaste(this.editor, action,new ImageIcon(img));
		this.add(paste);


		// Cut
		action = jg.getTransferHandler().getCopyAction(); // cut is simulated
		// with a copy and a delete when paste was performed.
		// it was required this solution to prevent deleting from
		// the ingenias model elements appearing only once.
		/* img = ImageLoader.getImage("images/cut.gif");
			 action.putValue(Action.SMALL_ICON, new ImageIcon(img));
			 cut = new EventRedirectorCut(Editor.this,action);
			 this.add(cut);*/


		// Remove
		Image img_delete =
			ImageLoader.getImage("images/bin.png");
		ImageIcon removeIcon = new ImageIcon(img_delete);
		remove =
			new AbstractAction("", removeIcon) {

			public void actionPerformed(ActionEvent e) {
				if (ButtonToolBar.this.editor.getGraph() != null) {
					if (!ButtonToolBar.this.editor.getGraph().isSelectionEmpty()) {
						Object[] cells =
							ButtonToolBar.this.editor.getGraph().getSelectionCells();
						Vector<Object> cellsToRemove=new Vector<Object>();
						for (Object cell:cells){
							if (cell instanceof DefaultGraphCell){
								Entity ent=(Entity)((DefaultGraphCell)cell).getUserObject();								
								int rep=gm.repeatedInstanceInModels(ent.getId());
								if (rep==1){
									int res = JOptionPane.showConfirmDialog(ButtonToolBar.this.editor.getGraph(),
											"Element " + ent.getId() +
											" of type " + ent.getType() + " is no longer used in other diagrams." +
											" Do you want to remove it from the objects database (y/n)?",
											"Remove?",
											JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
									if (res == JOptionPane.OK_OPTION) {										
										om.removeEntity(ent);
										om.reload();									} 
									cellsToRemove.add(cell);
									
								} else {
									cellsToRemove.add(cell);
								}
							} else {
								cellsToRemove.add(cell);
							}
								
						 
						}
						//cells = ButtonToolBar.this.editor.graph.getDescendants(cells);
						ButtonToolBar.this.editor.getGraph().getGraphLayoutCache().remove(cellsToRemove.toArray(),true,true);
					}
				}
			}
		};

		this.add(remove);

		// Zoom Std
		this.addSeparator();
		Image img_zoom = ImageLoader.getImage("images/zoom.png");
		ImageIcon zoomIcon = new ImageIcon(img_zoom);
		this.add(
				new AbstractAction("", zoomIcon) {
					/**
					 *  Description of the Method
					 *
					 *@param  e  Description of Parameter
					 */
					public void actionPerformed(ActionEvent e) {
						if (ButtonToolBar.this.editor.getGraph() != null) {
							ButtonToolBar.this.editor.getGraph().setScale(1.0);
						}
					}
				});
		// Zoom In
		Image img_zoomin =
			ImageLoader.getImage("images/zoom_in.png");
		ImageIcon zoomInIcon = new ImageIcon(img_zoomin);
		this.add(
				new AbstractAction("", zoomInIcon) {

					public void actionPerformed(ActionEvent e) {
						if (ButtonToolBar.this.editor.getGraph() != null) {
							ButtonToolBar.this.editor.getGraph().setScale(2 * ButtonToolBar.this.editor.getGraph().getScale());
						}
					}
				});
		// Zoom Out
		Image img_zoomout =
			ImageLoader.getImage("images/zoom_out.png");
		ImageIcon zoomOutIcon = new ImageIcon(img_zoomout);
		this.add(
				new AbstractAction("", zoomOutIcon) {

					public void actionPerformed(ActionEvent e) {
						if (ButtonToolBar.this.editor.getGraph() != null) {
							ButtonToolBar.this.editor.getGraph().setScale(ButtonToolBar.this.editor.getGraph().getScale() / 2);
						}
					}
				});

		// Group
		/* toolbar.addSeparator();
		 Image img_group =
		 ImageLoader.getImage("images/group.gif");
		 ImageIcon groupIcon = new ImageIcon(img_group);
		 group =
		 new AbstractAction("", groupIcon) {
		 public void actionPerformed(ActionEvent e) {
		 if (graph != null) {
		 group(graph.getSelectionCells());
		 }
		 }
		 };
		 group.setEnabled(false);
		 toolbar.add(group);
		 // Ungroup
		  Image img_ungroup =
		  ImageLoader.getImage("images/ungroup.gif");
		  ImageIcon ungroupIcon = new ImageIcon(img_ungroup);
		  ungroup =
		  new AbstractAction("", ungroupIcon) {
		  public void actionPerformed(ActionEvent e) {
		  if (graph != null) {
		  ungroup(graph.getSelectionCells());
		  }
		  }
		  };
		  ungroup.setEnabled(false);
		  toolbar.add(ungroup);
		  // To Front
		   toolbar.addSeparator();
		   Image img_tofront =
		   ImageLoader.getImage("images/tofront.gif");
		   ImageIcon toFrontIcon = new ImageIcon(img_tofront);
		   tofront =
		   new AbstractAction("", toFrontIcon) {
		   public void actionPerformed(ActionEvent e) {
		   if (graph != null) {
		   if (!graph.isSelectionEmpty()) {
		   toFront(graph.getSelectionCells());
		   }
		   }
		   }
		   };
		   tofront.setEnabled(false);
		   toolbar.add(tofront);
		   // To Back
		    Image img_toback =
		    ImageLoader.getImage("images/toback.gif");
		    ImageIcon toBackIcon = new ImageIcon(img_toback);
		    toback =
		    new AbstractAction("", toBackIcon) {
		    public void actionPerformed(ActionEvent e) {
		    if (graph != null) {
		    if (!graph.isSelectionEmpty()) {
		    toBack(graph.getSelectionCells());
		    }
		    }
		    }
		    };
		    toback.setEnabled(false);
		    toolbar.add(toback);
		 */
	}

	public void updateActions(ModelJGraph graph){
		copy.updateAction(graph.getTransferHandler().getCopyAction(),graph);
		paste.updateAction(graph.getTransferHandler().getPasteAction(),graph);
	}

	public Action getUndo() {
		return undo;
	}

	protected void setUndo(Action undo) {
		this.undo = undo;
	}

	protected Action getCopy() {
		return copy;
	}

	protected Action getCut() {
		return cut;
	}

	protected Action getGroup() {
		return group;
	}

	public JComboBox getJc() {
		return jc;
	}

	protected Action getPaste() {
		return paste;
	}

	public Action getRedo() {
		return redo;
	}

	protected Action getRemove() {
		return remove;
	}

	protected Action getToback() {
		return toback;
	}

	protected Action getTofront() {
		return tofront;
	}

	protected Action getUngroup() {
		return ungroup;
	}




}