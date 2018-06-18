package ingenias.editor.rendererxml;

import java.awt.*;
import javax.swing.JPanel;

/**
 * <p>T�tulo: </p>
 * <p>Descripci�n: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Empresa: </p>
 * @author sin atribuir
 * @version 1.0
 */

public class PaintModePanel extends JPanel {

  public PaintModePanel() {
   }

   public PaintModePanel(LayoutManager p0, boolean p1) {
     super(p0, p1);
   }

   public PaintModePanel(LayoutManager p0) {
     super(p0);
   }

   public PaintModePanel(boolean p0) {
     super(p0);
   }


  public void paint(Graphics graph){
   graph.setPaintMode();
   super.paint(graph);
   //graph.setXORMode(Color.white);

  }

}