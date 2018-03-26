package ingenias.editor;

import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JWindow;

public class BusyMessageWindow extends JWindow {
	IDEState ids=null;

	public BusyMessageWindow(IDEState ids, Frame owner) {
		super(owner);
		ids.setBusy();
		this.ids=ids;
	}


	@Override
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		super.setVisible(b);
		if (!b)
		 ids.setNotBusy();
	}
	
	

}
