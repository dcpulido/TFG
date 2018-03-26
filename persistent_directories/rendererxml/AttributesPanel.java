package ingenias.editor.rendererxml;

import javax.swing.JPanel;
import java.awt.*;
import javax.swing.border.*;
import java.util.*;
import java.beans.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import ingenias.editor.*;
import ingenias.editor.entities.Entity;
import ingenias.editor.entities.FrameFact;

import javax.swing.*;

public class AttributesPanel extends JComponent {
  private boolean settingcollection=false;
  private Box box = Box.createVerticalBox();

  Vector tobeduplicated=new Vector();
  
  public AttributesPanel() {
    this.setLayout(new BorderLayout());
    super.add(box, BorderLayout.CENTER);
  }
  
  public void setEntity(java.lang.Object ent){
	  Method[] methods = ent.getClass().getDeclaredMethods();
	  box.removeAll();
	  for (Method m: methods){
		  if (m.getName().toLowerCase().startsWith("get")){
			  String attName=m.getName().substring(3);
			  Object result;
			try {
				result = m.invoke(ent,new Object[]{});
				String value="null";
				  if (result!=null)
					  value=result.toString();			  
				  JPanel attPane=new JPanel(new FlowLayout(FlowLayout.LEFT));
				  attPane.add(new JLabel(attName+" : "+m.getReturnType().getName()+" = "+value));			  
				  box.add(attPane);
			} catch (IllegalArgumentException e) {
				
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				
				e.printStackTrace();
			}			  
		  }
	  }
  }

  

  public static void main(String[] args) throws IllegalArgumentException,
      IllegalAccessException {

    JFrame jf=new JFrame();

    AttributesPanel colpal = new AttributesPanel();
    colpal.setEntity(new FrameFact("hola"));
    colpal.setEntity(new FrameFact("hola"));
    jf.getContentPane().add(colpal);
    jf.pack();
    jf.show();    
    jf.pack();
  }
}
