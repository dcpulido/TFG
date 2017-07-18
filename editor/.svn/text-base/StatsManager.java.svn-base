package ingenias.editor;

import ingenias.editor.persistence.PersistenceManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;


public class StatsManager {

	
	public static void saveSessionREG(long ctime, long initTime, Vector<String> questions) {
		try {
			FileOutputStream fos=new FileOutputStream("logs/sessionDataREG"+ctime+".xml");			
			for (String question:questions){				
				fos.write((""+ctime+","+(ctime-initTime)+","+question+"\n").getBytes());
			}
			fos.close();
	//		new PersistenceManager().save(new File("logs/sessionSpecREG"+ctime+".xml"), IDE.ide.ids);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void saveSession(long ctime, long initTime) {
		try {
			FileOutputStream fos=new FileOutputStream("logs/sessionData"+ctime+".xml");
			fos.write((""+ctime+","+(ctime-initTime)).getBytes());
			fos.close();
		//	new PersistenceManager().save(new File("logs/sessionSpec"+ctime+".xml"), IDE.ide.ids);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
