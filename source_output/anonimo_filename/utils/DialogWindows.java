package ingenias.editor.utils;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;

import ingenias.editor.BusyMessageWindow;
import ingenias.editor.GUIResources;
import ingenias.editor.IDEState;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

public class DialogWindows {
	
	public static JWindow showMessageWindow(String mess,IDEState ids, final GUIResources resources) {
		final JWindow jw = new BusyMessageWindow(ids,resources.getMainFrame());

		final String message = mess;
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JLabel jl = new JLabel(message);
				jl.setFont(new java.awt.Font("Dialog", 1, 36));
				jw.getContentPane().add(jl);				
				jw.pack();
				jw.setLocation(getCenter(jw.getSize(),resources.getMainFrame()));
				jw.setVisible(true);
			}
		});
		return jw;
	}
	
	public static Point getCenter(Dimension size, Frame frame){
		Dimension d = frame.getSize();
		Point result=new Point(
				(d.width / 2 - size.width / 2)+frame.getLocation().x,
				(d.height / 2 - size.height / 2)+frame.getLocation().y);
		return result;
	}
	
	/*public static File getHomeDir() {
		JFileChooser jfc = new JFileChooser();
		File homedir = jfc.getCurrentDirectory();
		new File(homedir.getPath() + "/.idk").mkdir();
		
	}*/

}
