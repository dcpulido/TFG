package ingenias.editor.actions;

import ingenias.editor.GUIResources;
import ingenias.editor.DiagramPaneInitialization;
import ingenias.editor.IDEState;
import ingenias.editor.IDEUpdater;
import ingenias.editor.ProgressListener;

import java.awt.Cursor;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class LoadFileSwingTask extends SwingWorker<Void, Void> implements ProgressListener{
	private File current;
	private IDEUpdater updater;
	private IDEState ids;
	private GUIResources resources;
	private IDEState nids;
	public LoadFileSwingTask(File current, IDEUpdater updater, IDEState ids, final GUIResources resources){
		this.current=current;
		this.updater=updater;
		this.ids=ids;
		this.resources=resources;
		final SwingWorker sw=this;
		this.addPropertyChangeListener(new PropertyChangeListener(){
			/**
			 * Invoked when task's progress property changes.
			 */
			public void propertyChange(PropertyChangeEvent evt) {
				if (!sw.isDone()) {
					
					int progress = sw.getProgress();				
					resources.getProgressBar().setValue(progress);
					resources.getProgressBar().setString("Loading ..."+((progress))+"%");					
				} 
			}
		});
		this.resources.getMainFrame().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		resources.addProgressListener(this);
		resources.getProgressBar().setVisible(true);
		resources.getProgressBar().invalidate();
		resources.getProgressBar().validate();
		resources.getProgressBar().repaint();	
		resources.getProgressBar().setString("Loading ...");
		resources.getProgressBar().setStringPainted(true);
		resources.getMainFrame().setEnabled(false);		
		
	}
	/*
	 * Main task. Executed in background thread.
	 */
	@Override
	public Void doInBackground() {
		nids = new LoadFileAction(ids, resources).loadFileAction(current);
		return null;
	}

	/*
	 * Executed in event dispatching thread
	 */
	@Override
	public void done() {
		if (nids!=null){
			resources.getMainFrame().setTitle("Project:" + current.getAbsolutePath());
			nids.getLastFiles().addAll(ids.getLastFiles());
			HistoryManager.updateHistory(current, resources, nids, updater);
			nids.setCurrentFile(current);
			nids.setCurrentFileFolder(nids.getCurrentFile().getParentFile());
			//jw.setVisible(false);
			
			//new IDEFactory(nids,resources).updateButtonBars();
				
			// TODO Auto-generated method stub
			//resources.getPprin().remove(resources.getProgressBar());				
			//Toolkit.getDefaultToolkit().beep();		
			updater.updateIDEState(nids);
			//updater.updateIDEState(nids);
			new DiagramPaneInitialization(nids,resources).updateButtonBars();
			
		}
		resources.getProgressBar().setVisible(false);
		resources.getProgressBar().invalidate();
		resources.getProgressBar().validate();
		resources.getProgressBar().repaint();
		resources.removeProgressListener(this);
		resources.getProgressBar().setValue(resources.getProgressBar().getMaximum());		
		this.resources.getMainFrame().setCursor(null);
		resources.getMainFrame().setEnabled(true);

		//setCursor(null); //turn off the wait cursor
	}
	public void setCurrentProgress(int progress) {
		setProgress(progress);
	

	}
}

