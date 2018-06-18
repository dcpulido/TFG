/*
    Copyright (C) 2002 Jorge Gomez Sanz

    This file is part of INGENIAS IDE, a support tool for the INGENIAS
    methodology, availabe at http://grasia.fdi.ucm.es/ingenias or
    http://ingenias.sourceforge.net

    INGENIAS IDE is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    INGENIAS IDE is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with INGENIAS IDE; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

*/

package ingenias.editor.widget;

import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;

public class CustomJComboBox extends JComboBox implements Editable,java.io.Serializable ,ConfigurableWidget{
  String customtext;
    DefaultComboBoxModel dlm;
  public CustomJComboBox(){
    super();
    this.setEditable(true);
    dlm=new DefaultComboBoxModel();
    this.setModel(dlm);

  }

  public void setDefaultValues(Vector v){


    Enumeration enumeration=v.elements();
    while (enumeration.hasMoreElements()){
      Object o=enumeration.nextElement();
      dlm.addElement(o);
    }
    this.validate();


  }

/*  void textChanged(ItemEvent e) {
    customtext=this.getSelectedItem().toString();
//    this.setText();
  }*/

  public String getText(){
   // if (this.getEditor()!=null){
      return ((JTextField)this.getEditor().getEditorComponent()).getText();
    /*}
    return "";*/
  }


  public void setText(String text){
    if (this.getEditor()!=null){
      ((JTextField)this.getEditor().getEditorComponent()).setText(text);
    }
  }

  public void addFocusListener(FocusListener fl){

    if (this.getEditor()!=null){
      //System.err.println(this.getEditor().getEditorComponent().getClass());
      ((JTextField)this.getEditor().getEditorComponent()).addFocusListener(fl);
    }
  }



  public static void main(String args[]){
   JFrame jf=new JFrame();
   Vector v=new Vector();
   v.add("1");
   v.add("2");

   final CustomJComboBox cjb=new CustomJComboBox();
   Component c[]=cjb.getComponents();





   FocusListener fl=new java.awt.event.FocusAdapter(){


   public void focusLost(FocusEvent fe){
     System.err.println("hola");

     System.err.println(cjb.getText());
   }

   public void focusGained(FocusEvent fe){
          System.err.println("hola");

  System.err.println(cjb.getText());
}

};


   for (int k=0;k<c.length;k++){
   c[k].addFocusListener(fl);
   }

   cjb.setDefaultValues(v);


   JPanel jp=new JPanel();
//   jp.add(cjb);

   jp.add(new JButton("hola"));
   jf.getContentPane().setLayout(new FlowLayout());
   cjb.addFocusListener(new example_jSpinner1_focusAdapter(cjb));
   jf.getContentPane().add(cjb,null);
   jf.getContentPane().add(jp,null);
   jf.pack();

   jf.show();
  }
}
class example_jSpinner1_focusAdapter extends java.awt.event.FocusAdapter  implements java.io.Serializable  {
  CustomJComboBox adaptee;

  example_jSpinner1_focusAdapter(CustomJComboBox adaptee) {
    this.adaptee = adaptee;
  }
  public void focusLost(FocusEvent e) {
    System.err.println("hola");
  }
}

