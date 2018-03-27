package ingenias.editor.rendererxml;

import javax.swing.JPanel;
import java.awt.LayoutManager;
import java.awt.Color;
import java.awt.*;
import javax.swing.border.*;

public class DashedVerticalLinePanel
    extends JPanel {

  public DashedVerticalLinePanel() {
//    DashedBorder db=new DashedBorder(Color.black);
//    this.setBorder(db);
  }

  public DashedVerticalLinePanel(LayoutManager p0, boolean p1) {
    super(p0, p1);
  }

  public DashedVerticalLinePanel(LayoutManager p0) {
    super(p0);
  }

  public DashedVerticalLinePanel(boolean p0) {
    super(p0);
  }

  public void paint(Graphics g) {
    super.paint(g);
    Dimension size = this.getSize();
    g.setPaintMode();
    g.setColor(Color.black);
    Stroke old = ( (Graphics2D) g).getStroke();
    BasicStroke bs = new BasicStroke(2.0f, BasicStroke.CAP_BUTT,
                                     BasicStroke.JOIN_MITER, 10.0f,
                                     new float[] {5.0f}
                                     , 0.0f);
    ( (Graphics2D) g).setStroke(bs);
    g.drawLine(size.width / 2, 0, size.width / 2, size.height);
    ( (Graphics2D) g).setStroke(old);
  }

  public static void main(String[] args) {
    DashedVerticalLinePanel dashedBorderPanel1 = new DashedVerticalLinePanel();
  }
}
