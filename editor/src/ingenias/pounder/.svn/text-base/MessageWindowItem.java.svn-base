package ingenias.pounder;

import java.awt.event.MouseEvent;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.EventQueue;
import java.awt.Component;
import java.awt.Window;
import java.awt.Robot;

import org.w3c.dom.Element;
import org.w3c.dom.Document;

import com.mtp.gui.WindowWatcher;

import i18n.Strings;
import com.mtp.pounder.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



/**
 Shows a message to the user. The window does not close until the user press "accept"
 @author Jorge Gomez from an original file from Matthew Pekar
 **/
public class MessageWindowItem
    extends RecordingItem {

  /** Coordinates of pointer relative to parent Window. **/
  protected double x, y;
  protected String text;
  protected int pause;
  static javax.swing.JWindow jf = new javax.swing.JWindow();
  static javax.swing.JTextArea ta = new javax.swing.JTextArea();
  static {
    JScrollPane jscp=new JScrollPane();
    jscp.getViewport().add(ta,null);
    jf.getContentPane().setLayout(new GridBagLayout());
    GridBagConstraints gbc=new java.awt.GridBagConstraints();
    gbc.gridx=0;
    gbc.gridx=0;
    gbc.fill=gbc.BOTH;
    gbc.anchor=gbc.CENTER;
    gbc.insets=new java.awt.Insets(10,10,10,10);
    jf.getContentPane().add(jscp, gbc);
    jf.getContentPane().setBackground(Color.BLUE);

    JButton jb=new JButton("close");
//    jf.getContentPane().add(jb, BorderLayout.SOUTH);
    jb.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
       jf.toBack();
      }
    });

    ta.setEditable(false);
    ta.setWrapStyleWord(true);
    ta.setLineWrap(true);
    ta.setFont(new java.awt.Font("monospaced", Font.BOLD, 14));
    ta.setMargin(new Insets(5,5,5,5));
//    ta.setEnabled(false);
    jscp.setMinimumSize(new Dimension(200,100));
//    jscp.setPreferredSize(new Dimension(200,100));
    jf.pack();
    jf.setLocation(getCenter(jf.getSize()));
    jf.show();
  }

  public static Point getCenter(Dimension size){
  Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
  Point result=new Point(
  d.width / 2 - size.width / 2,
  d.height / 2 - size.height / 2);
  return result;
}


  public MessageWindowItem(Element e, PounderPrefs prefs,
                           ComponentIdentifierFactory f) {
    super(e, prefs, f);

    if (!e.hasAttribute("pause")) {
      throw new IllegalArgumentException(Strings.getString(
          "ElementMustContainAttribute:") + "\"pause\"");
    }

    if (!e.hasAttribute("text")) {
      throw new IllegalArgumentException(Strings.getString(
          "ElementMustContainAttribute:") + "\"text\"");
    }

    this.pause=Integer.valueOf(e.getAttribute("pause")).intValue();
    this.text = e.getAttribute("text");
  }

  public MessageWindowItem( long delay) {
    super(delay);

    this.text = "nothing";
  }

  protected Element buildXMLElement(Document doc) {
    return doc.createElement("com.mtp.pounder.MessageWindow");
  }

  protected void addXMLAttributes(Element e, Document doc) {
    super.addXMLAttributes(e, doc);

    e.setAttribute("pause", String.valueOf(x));
    e.setAttribute("text", text);
  }

  public boolean equals(Object o) {
    MessageWindowItem mmi = (MessageWindowItem) o;
    return super.equals(o) &&
        (x == mmi.x) && (y == mmi.y) &&
        (text.equals(mmi.text));
  }

  public void playback(WindowWatcher ww, PounderPrefs prefs) throws Exception {
    // Show the message

    ta.setText(text);
    jf.pack();

    jf.toFront();


   int cont=0;
   while (cont<100 && jf.isVisible()){
     try {
       Thread.currentThread().sleep(60);
     }
     catch (Exception e) {
       e.printStackTrace();
     }
     cont++;
   }
    jf.toBack();
  }

  public String toString() {
    return "Show message " + " x=" + decimalNumberFormat.format(x) + " y=" +
        decimalNumberFormat.format(y) + "text=\"" + text + "\"";
  }

}
