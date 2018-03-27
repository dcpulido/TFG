package ingenias.editor.cell;

import javax.swing.*;


/**
 * <p>Titulo: </p>
 * <p>Descripcion: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Empresa: </p>
 * @author sin atribuir
 * @version 1.0
 */
import ingenias.editor.entities.*;

public class CustomJLabel extends JLabel {
  private Entity ent;
  public CustomJLabel(Entity ent) {
    super("");
    //System.err.println("1"+ent);
    this.ent=ent;
    this.setText(ent.getId());
  }


  public String getText(){
    if (ent!=null){
      System.err.println("2" + ent);
      return ent.toString();
    } else
      return "";
  }

  public String toString(){
    return ent.toString();
  }

  public static void main(String args[]){
   JFrame jp= new JFrame();
   Entity mient=new Entity("1");
   CustomJLabel cl=new CustomJLabel(mient);
   jp.getContentPane().add(cl);
   jp.pack();
   jp.show();
   mient.setId("3");
   cl.repaint();
  }

}