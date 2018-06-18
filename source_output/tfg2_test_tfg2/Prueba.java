package ingenias.editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Prueba extends JFrame  implements java.io.Serializable {
	JButton jButton1 = new JButton("bot1");
	
	public Prueba() throws HeadlessException {
		super("p1");
		try {
			jbInit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Prueba(GraphicsConfiguration gc) {
		super(gc);
	}
	
	public Prueba(String title) throws HeadlessException {
		super(title);
	}
	
	public Prueba(String title, GraphicsConfiguration gc) {
		super(title, gc);
	}
	
	public static void main(String[] args) throws HeadlessException {
		Prueba prueba1 = new Prueba();
		prueba1.pack();
		prueba1.show();
		System.err.println("termine");
	}
	
	private void jbInit() throws Exception {
		jButton1.setText("jButton1");
		jButton1.addActionListener(new Prueba_jButton1_actionAdapter(this));
		this.getContentPane().add(jButton1, BorderLayout.CENTER);
	}
	
	void jButton1_actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this,"HOOOOLA","saludos",JOptionPane.QUESTION_MESSAGE);
		System.exit(-1);
	}
}

class Prueba_jButton1_actionAdapter implements java.awt.event.ActionListener,java.io.Serializable {
	Prueba adaptee;
	
	Prueba_jButton1_actionAdapter(Prueba adaptee) {
		this.adaptee = adaptee;
	}
	public void actionPerformed(ActionEvent e) {
		adaptee.jButton1_actionPerformed(e);
	}
}