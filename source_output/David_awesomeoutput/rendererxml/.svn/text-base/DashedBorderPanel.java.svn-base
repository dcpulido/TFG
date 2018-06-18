package ingenias.editor.rendererxml;

import javax.swing.JPanel;
import java.awt.LayoutManager;
import java.awt.Color;
import java.awt.*;
import javax.swing.border.*;

public class DashedBorderPanel extends JPanel {

  class DashedBorder extends LineBorder {

    public DashedBorder(Color p0) {
      super(p0);
    }

    public DashedBorder(Color p0, int p1) {
      super(p0, p1);
    }

    public DashedBorder(Color p0, int p1, boolean p2) {
      super(p0, p1, p2);
    }

    public void paintBorder(Component comp,Graphics g, int x1,int x2, int y1,int y2){
      Stroke old=((Graphics2D)g).getStroke();
      BasicStroke bs=new BasicStroke(2.0f, BasicStroke.CAP_BUTT,
                                BasicStroke.JOIN_MITER, 10.0f, new float[]{5.0f}, 0.0f);
      ((Graphics2D)g).setStroke(bs);
      super.paintBorder(comp,g, x1,x2, y1,y2);
    ((Graphics2D)g).setStroke(old);
    }


  }



  public DashedBorderPanel() {
    DashedBorder db=new DashedBorder(Color.black);
    this.setBorder(db);
  }

  public DashedBorderPanel(LayoutManager p0, boolean p1) {
    super(p0, p1);
  }

  public DashedBorderPanel(LayoutManager p0) {
    super(p0);
  }

  public DashedBorderPanel(boolean p0) {
    super(p0);
  }
  public static void main(String[] args) {
    DashedBorderPanel dashedBorderPanel1 = new DashedBorderPanel();
  }
}