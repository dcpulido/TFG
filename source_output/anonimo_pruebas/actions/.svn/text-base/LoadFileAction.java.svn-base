package ingenias.editor.actions;

import ingenias.editor.BusyMessageWindow;
import ingenias.editor.DiagramPaneInitialization;
import ingenias.editor.GUIResources;
import ingenias.editor.IDEAbs;
import ingenias.editor.IDEState;
import ingenias.editor.IDEUpdater;
import ingenias.editor.Log;
import ingenias.editor.VisitedFileMenuItem;
import ingenias.editor.persistence.PersistenceManager;
import ingenias.editor.utils.DialogWindows;
import ingenias.editor.widget.GraphicsUtils;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Properties;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.plaf.ProgressBarUI;

public class LoadFileAction {
	private IDEState ids;
	private GUIResources resources;


	public LoadFileAction(IDEState ids, GUIResources resources){
		this.ids=ids;
		this.resources=resources;

	}

	public void loadNewFile(IDEUpdater updater) {
		int result = JOptionPane.OK_OPTION;
		if (ids.isChanged()) {
			result = JOptionPane.showConfirmDialog(resources.getMainFrame(),
					"You will loose current data. Do you want to continue (y/n)?",
					"Warning", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE);
		}

		if (result == JOptionPane.OK_OPTION) {			
			try {
				JFileChooser jfc = null;
				if (ids.getCurrentFileFolder() == null) {
					jfc = new JFileChooser();
				}
				else {
					jfc = new JFileChooser(ids.getCurrentFileFolder().getPath());
				}
				jfc.addChoosableFileFilter(
						new javax.swing.filechooser.FileFilter() {
							public boolean accept(File f) {
								boolean acceptedFormat = f.getName().toLowerCase().endsWith(
								".xml");
								return acceptedFormat || f.isDirectory();
							}

							public String getDescription() {
								return "xml";
							}
						});
				jfc.setLocation(GraphicsUtils.getCenter(resources.getMainFrame(),jfc.getSize()));
				jfc.showOpenDialog(resources.getMainFrame());
				final File input = jfc.getSelectedFile();
				if (input != null && !input.isDirectory()) {
					/*new Thread() {
						public void run() {*/

					ids.setChanged(false);
					resources.setUnChanged();
					new LoadFileSwingTask(input,updater,ids,resources).execute();				

					/*						}
					}

					.start();*/
				}
			}
			catch (Exception e1) {
				e1.printStackTrace();

			}
			//resources.getMainFrame().setEnabled(true);			
		}

		resources.getMainFrame().setEnabled(true);
	
	}

	public IDEState loadFileAction(File file) {
		//System.err.println("antes ids:"+ids.getStateChangelistener());
		final File input = file;
		assert(file!=null);			
		
		try {
			
			Properties oldprops = (Properties) ids.prop.clone();

			PersistenceManager pm = new PersistenceManager();
						
			pm.savePreferences(ids);
			resources.setCurrentProgress(20);			
			IDEState nids=IDEState.emptyIDEState();
			
			// Loads data from the file
			pm.load(input.getAbsolutePath(),resources, ids.prop, nids);
			
			return nids;		
			/*new IDEFactory(ids,resources).initialiseInternalIDEStateFromNewIDEState(oldprops, nids);
					ids.setCurrentFile(input);
					ids.setCurrentFileFolder(ids.getCurrentFile().getParentFile());					
					resources.getMainFrame().setTitle("Project:" + input.getAbsolutePath());
					HistoryManager.updateHistory(input, resources, ids);
					System.err.println("despues ids:"+ids.getStateChangelistener());*/

		}
		catch (ingenias.exception.UnknowFormat e1) {
			Log.getInstance().logSYS(e1.getMessage());

			JOptionPane.showMessageDialog(resources.getMainFrame(),
			"Failure loading: format unknown. See MESSAGES pane");

		}
		catch (ingenias.exception.DamagedFormat df) {
			Log.getInstance().logSYS(df.getMessage());
			JOptionPane.showMessageDialog(resources.getMainFrame(),
			"Failure loading: some diagrams could not be loaded. See MESSAGES pane");

		}
		catch (ingenias.exception.CannotLoad cl) {
			Log.getInstance().logSYS(cl.getMessage());
			JOptionPane.showMessageDialog(resources.getMainFrame(),
			"Failure loading: could not load anything. See MESSAGES pane");

		}

		resources.getMainFrame().setEnabled(true);

		return null;

		/*jw.setVisible(false);
				resources.getMainFrame().setEnabled(true);*/
		//}}).start();


	}





}
