package ingenias.editor.rendererxml;

import javax.swing.JPanel;
import java.awt.LayoutManager;
import java.awt.Color;
import java.awt.*;
import javax.swing.border.*;

public class LinePanel extends JPanel {

  public LinePanel() {
//    DashedBorder db=new DashedBorder(Color.black);
//    this.setBorder(db);
  this.setLayout(new FlowLayout(FlowLayout.CENTER,0,2));
  }

  public LinePanel(LayoutManager p0, boolean p1) {
    super(p0, p1);
  }

  public LinePanel(LayoutManager p0) {
    super(p0);
  }

  public LinePanel(boolean p0) {
    super(p0);
  }


  public void paint(Graphics g){
        super.paint(g);
    Dimension size=this.getSize();
    g.setPaintMode();
    g.setColor(Color.black);
    g.drawLine(0,size.height/2,size.width,size.height/2);
  }

  public static void main(String[] args) {
    LinePanel dashedBorderPanel1 = new LinePanel();
  }
}
