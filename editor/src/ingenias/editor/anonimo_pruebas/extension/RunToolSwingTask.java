package ingenias.editor.extension;

import ingenias.editor.AudioPlayer;
import ingenias.editor.GUIResources;
import ingenias.editor.IDEState;
import ingenias.editor.IDEUpdater;
import ingenias.editor.Log;
import ingenias.editor.ProgressListener;
import ingenias.editor.actions.HistoryManager;
import ingenias.editor.actions.LoadFileAction;

import java.awt.Cursor;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class RunToolSwingTask extends SwingWorker<Void, Void> implements ProgressListener{
	
	
	private IDEState ids;
	private GUIResources resources;
	private IDEState nids;
	private BasicTool bt;
	private int hclogs;
	private int hcout;
	public RunToolSwingTask(final BasicTool bt, IDEState ids, final GUIResources resources){				
		this.ids=ids;
		this.resources=resources;
		this.bt=bt;
		final SwingWorker sw=this;
		this.addPropertyChangeListener(new PropertyChangeListener(){
			/**
			 * Invoked when task's progress property changes.
			 */
			public void propertyChange(PropertyChangeEvent evt) {
				if (!sw.isDone()) {					
					int progress = sw.getProgress();
					resources.getProgressBar().setValue(progress);
					resources.getProgressBar().setString("Running "+bt.getName()+" ..."+((progress))+"%");					
				} 
			}
		});
		this.resources.getMainFrame().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		resources.addProgressListener(this);
		resources.getProgressBar().setVisible(true);
		resources.getProgressBar().invalidate();
		resources.getProgressBar().validate();
		resources.getProgressBar().repaint();	
		resources.getProgressBar().setString("Running "+bt.getName());
		resources.getProgressBar().setStringPainted(true);
		resources.getMainFrame().setEnabled(false);		
		
	}
	/*
	 * Main task. Executed in background thread.
	 */
	@Override
	public Void doInBackground() {
		 hclogs = resources.getLogs().getText().hashCode();
		 hcout = resources.getModuleOutput().getText().hashCode();
		try {
			bt.setProperties(ids.prop);
			bt.run();	
			//AudioPlayer.play("arpa.wav"); // An ok sound
			
		}
		catch (Throwable ex) {
			ex.printStackTrace();			
			Log.getInstance().logERROR(ex);
			StackTraceElement[] ste = ex.getStackTrace();
			for (int k = 0; k < ste.length; k++) {
				Log.getInstance().logERROR(ste[k].toString());
			}
			//AudioPlayer.play("watershot.wav"); // An error sound
			if (resources.getModuleOutput().getText().hashCode() != hcout) {
				resources.getMessagespane().setSelectedIndex(1);
			}

			if (resources.getLogs().getText().hashCode() != hclogs) {
				resources.getMessagespane().setSelectedIndex(0);
			}
		}
			
		return null;
	}

	/*
	 * Executed in event dispatching thread
	 */
	@Override
	public void done() {		
		
		if (resources.getModuleOutput().getText().hashCode() != hcout) {
			resources.getMessagespane().setSelectedIndex(1);
		}

		if (resources.getLogs().getText().hashCode() != hclogs) {
			resources.getMessagespane().setSelectedIndex(0);
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


