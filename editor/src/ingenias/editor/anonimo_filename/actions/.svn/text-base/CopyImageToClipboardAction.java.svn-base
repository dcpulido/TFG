package ingenias.editor.actions;

import ingenias.editor.ClipImage;
import ingenias.editor.GUIResources;
import ingenias.editor.IDEState;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import org.jgraph.JGraph;

public class CopyImageToClipboardAction implements ClipboardOwner{
	
	private IDEState ids;
	private GUIResources resources;
	
	public CopyImageToClipboardAction(IDEState ids, GUIResources resources){
		this.ids=ids;
		this.resources=resources;
	}
	
	public void cpClipboard_actionPerformed() {
		try {
			JGraph graph = this.ids.editor.getGraph();
			if (graph != null) {

				BufferedImage im = new BufferedImage(graph.getPreferredSize().width,
						graph.getPreferredSize().height,
						BufferedImage.TYPE_INT_ARGB);
				Graphics g = im.getGraphics();
				//				Disable double buffer to avoid batik exceptions
				graph.setDoubleBuffered(false);
				//				Render into the SVG Graphics2D implementation
				graph.setVisible(true);
				graph.setSize(graph.getPreferredSize());
				graph.paint(g);
				//				Enable the buffer again
				graph.setDoubleBuffered(true);
				g.dispose();

				// Work around a Sun bug that causes a hang in "sun.awt.image.ImageRepresentation.reconstruct".




				ClipImage ci = new ClipImage(im);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ci, this);
			}
		}
		catch (Exception ae) {
			ae.printStackTrace();
		}

	}

	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		// TODO Auto-generated method stub
		
	}
}
