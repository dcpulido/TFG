package ingenias.editor.extension;

import ingenias.editor.IDEAbs;
import ingenias.editor.IDEState;
import ingenias.editor.Log;
import ingenias.editor.ProjectProperty;
import ingenias.generator.browser.Browser;
import ingenias.generator.browser.BrowserImp;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UpdateToolsAndCG
extends Thread {
	ManageExtensions me;
	Set ct = new HashSet();
	Set cg = new HashSet();
	 IDEState ids;
	 BrowserImp browser=null;
	 ModuleLoader ml=null;
	private boolean stopMonitoring=false;
	
	public UpdateToolsAndCG(ManageExtensions me, ModuleLoader ml, IDEState ids) {
		this.me = me;
		this.ids=ids;
		this.ml=ml;
		browser=new BrowserImp(ids);
	}
	
	public void readLibs(String folder) {
		Set ct1 = new HashSet();
		Set cg1 = new HashSet();
		ml.updateStatus(folder,ct1, cg1);
		Iterator it = ct1.iterator();
		while (it.hasNext()) {
			try {
				Class bt = (Class) it.next();  
				java.lang.reflect.Constructor cons = bt.getDeclaredConstructor(new
						Class[]{Browser.class});
				BasicTool bti = (BasicTool) cons.newInstance(new Object[]{browser});
				System.err.println(ct);
				if (ct.contains(bti.getName())) {
					me.removeEntry(bti);
					System.gc(); // To request a garbage collection that removes unused classloaders
				}
				else {
					
					ct.add(bti.getName());
					System.err.println("Adding module ...."+ct);
				}
				
				me.addToolEntry(bti);
				
			}
			catch (Exception ex) {
				ex.printStackTrace();
				Log.getInstance().logERROR(ex.getMessage());
			}
		}
		it = cg1.iterator();
		while (it.hasNext()) {
			try {
				Class bt = (Class) it.next();
				java.lang.reflect.Constructor cons = bt.getDeclaredConstructor(new
						Class[]{Browser.class});
				BasicCodeGenerator bcg = (BasicCodeGenerator) cons.newInstance(new
						Object[]{browser});
				if (cg.contains(bcg.getName())) {
					me.removeEntry(bcg);
				}
				else {
					cg.add(bcg.getName());
					System.err.println("Adding "+bcg.getName());
					
				}
				me.addCGEntry(bcg);
				
			}
			catch (Exception ex) {
				ex.printStackTrace();
				Log.getInstance().logERROR("Error loading module:"+ex.getMessage());
			}
		}
		if (ct1.size() != 0 || cg1.size() != 0) {
			System.gc();
			
		}
	}
	
	public void run() {
		String folder = null;
		while (!stopMonitoring) {
			if (ids.prop.get("extfolder") == null) {
				folder = "ext";
			}
			else {
				folder = ( (ProjectProperty) ids.prop.get("extfolder")).value;
			}
			this.readLibs(folder);
			
			try {
				Thread.sleep(5000);
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
			
		}
	}

	public void stopUpdate() {
		stopMonitoring=true;
		
	}
}