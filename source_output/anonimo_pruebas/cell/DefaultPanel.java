package ingenias.editor.cell;

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

public class DefaultPanel extends JPanel {
  BorderLayout borderLayout1 = new BorderLayout();

  public DefaultPanel(JPanel inside) {
   this.setLayout(new BorderLayout());
   this.add(inside, BorderLayout.CENTER);
  }

  public void paint(Graphics graph){
	 
  // graph.setXORMode(Color.WHITE); // If activated, fonts are painted without anti-aliasing. They will look ugly.
   super.paint(graph);
 //  graph.setPaintMode();

  }

}