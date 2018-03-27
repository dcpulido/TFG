package ingenias.editor.actions;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.Enumeration;
import java.util.Properties;

import javax.swing.ProgressMonitor;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import com.sun.media.sound.Toolkit;

import ingenias.editor.IDEAbs;
import ingenias.editor.DiagramPaneInitialization;
import ingenias.editor.GUIResources;
import ingenias.editor.IDEState;
import ingenias.editor.IDEUpdater;
import ingenias.editor.ProgressListener;
import ingenias.editor.VisitedFileMenuItem;

public class HistoryManager {
	private IDEState ids;
	private GUIResources resources;

	

	public HistoryManager(IDEState ids, GUIResources resources){
		this.ids=ids;
		this.resources=resources;
	}

	public static void updateProperties(Properties extprop, IDEState ids) {
		Enumeration enumeration = extprop.keys();
		while (enumeration.hasMoreElements()) {
			Object key = enumeration.nextElement();
			if (!ids.prop.containsKey(key)) {
				ids.prop.put(key, extprop.get(key));
			}
		}
		//System.err.println (ids.prop);
	}

	protected void updateHistoryButtons() {
		// The View Argument Defines the Context
		//	ids.btb.getUndo().setEnabled(undoManager.canUndo(getGraph().getGraphLayoutCache()));
		//	ids.btb.getRedo().setEnabled(undoManager.canRedo(getGraph().getGraphLayoutCache()));
	}



	public static void updateHistory(File newFile, final GUIResources resources, final IDEState ids, final IDEUpdater updater){
		//	new Exception("update history").printStackTrace();
		/*System.err.println("antes:"+newFile);	
		System.err.println("antes:"+ids.getLastFiles());*/
		if (!ids.getLastFiles().contains(newFile)) {
			if (ids.getLastFiles().size() > 5) {
				ids.getLastFiles().remove(0);
			}
		}
		else {
			ids.getLastFiles().remove(newFile);
		}

		ids.getLastFiles().add(newFile);
		//resources.getFile().removeAll();
		Component[] me = resources.getFile().getMenuComponents();
		for (int k = 0; k < me.length; k++) {
			if (me[k] instanceof VisitedFileMenuItem) {
				resources.getFile().remove(me[k]);
			}
		}		

		for (int k = 0; k < ids.getLastFiles().size(); k++) {
			final File current = (File)ids.getLastFiles().elementAt(k);
			if (current!=null){
				VisitedFileMenuItem vfmi = new VisitedFileMenuItem(current.getPath()
						, current);
				vfmi.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(ActionEvent e) {	
						

						new LoadFileSwingTask(current,updater,ids,resources).execute();
					/*	Runnable loadAction=new Runnable(){
							public void run(){
								IDEState nids=new LoadFileAction(ids,resources).loadFileAction(current,updater);

								if (nids!=null){
									//updater.updateIDEState(nids);
									new IDEFactory(nids,resources).updateButtonBars();
								}	
								resources.getProgressBar().setVisible(false);
								resources.getProgressBar().invalidate();
								resources.getProgressBar().validate();
								resources.getProgressBar().repaint();	
							}
						};
						SwingUtilities.invokeLater(loadAction);*/
						//		new Thread(loadAction).start();
					}
				});

				resources.getFile().add(vfmi);
			}
		}
		//System.err.println("despues:"+ids.getLastFiles());
	}
}
