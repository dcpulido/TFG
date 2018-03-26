package ingenias.editor.events;

import ingenias.editor.cell.*;
import ingenias.editor.entities.*;

import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;
import java.util.Map;
import java.util.Hashtable;
import org.jgraph.graph.*;
import org.jgraph.*;
import org.jgraph.event.*;
import ingenias.editor.ObservableModel;
import java.util.*;

public class AdjustMainLLPorts
    implements org.jgraph.event.GraphModelListener {
  JGraph jg=null;
  public AdjustMainLLPorts(JGraph jg) {
    this.jg=jg;
  }

  public Vector getLifelines(ingenias.editor.Model model) {
   Vector result = new Vector();
   for (int k = 0; k < model.getRootCount(); k++) {
     if (model.getRootAt(k)instanceof LifelineCell) {
       result.add( ( (LifelineCell) model.getRootAt(k)).getUserObject());
     }
   }
   return result;
 }

// private void addPorts

  public void graphChanged(org.jgraph.event.GraphModelEvent gme) {

  }

}