package ingenias.editor.cell;

/**
 * <p>T�tulo: </p>
 * <p>Descripci�n: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Empresa: </p>
 * @author sin atribuir
 * @version 1.0
 */
import org.swixml.SwingEngine;

public class SWIRenderer {
  private static SwingEngine swiengine = new SwingEngine(null);
  static {

        swiengine.getTaglib().registerTag("stereotype".toLowerCase(),
                                      ingenias.editor.rendererxml.JLabelStereotype.class);
    swiengine.getTaglib().registerTag("htmllabel".toLowerCase(),
                                      ingenias.editor.rendererxml.JLabelHTML.class);
    swiengine.getTaglib().registerTag("iconlabel".toLowerCase(),
                                      ingenias.editor.rendererxml.JLabelIcon.class);
    swiengine.getTaglib().registerTag("collectionpanel",
                                      ingenias.editor.rendererxml.CollectionPanel.class);
    swiengine.getTaglib().registerTag("label",
    		 ingenias.editor.rendererxml.HTMLLabel.class);
    swiengine.getTaglib().registerTag("linepanel",
                                      ingenias.editor.rendererxml.LinePanel.class);
    swiengine.getTaglib().registerTag("htmllabel",
                                      ingenias.editor.rendererxml.HTMLLabel.class);
    swiengine.getTaglib().registerTag("wraplabel",
                                      ingenias.editor.rendererxml.JMultilineLabel.class);
    swiengine.getTaglib().registerTag("dashedpanel",
                                      ingenias.editor.rendererxml.
                                      DashedBorderPanel.class);
    swiengine.getTaglib().registerTag("myeditor",
            ingenias.editor.rendererxml.
            MyEditorPane.class);
    swiengine.getTaglib().registerTag("mytextpane",
            ingenias.editor.rendererxml.
            MyTextPane.class);
    
    swiengine.getTaglib().registerTag("dashedverticallinepanel",
                                      ingenias.editor.rendererxml.DashedVerticalLinePanel.class);
    swiengine.getTaglib().registerTag("attributepanel",
            ingenias.editor.rendererxml.AttributesPanel.class);

    /*    swiengine.getTaglib().registerTag("paintpanel",
         ingenias.editor.rendererxml.PaintModePanel.class);*/

  }

  public static SwingEngine getSWIEngine() {
    return swiengine;
  }

  public static SwingEngine getAnotherSWIEngine() {
    SwingEngine swiengine = new SwingEngine(null); 
       swiengine.getTaglib().registerTag("stereotype".toLowerCase(),
                                      ingenias.editor.rendererxml.JLabelStereotype.class);
    swiengine.getTaglib().registerTag("htmllabel".toLowerCase(),
                                      ingenias.editor.rendererxml.JLabelHTML.class);
    swiengine.getTaglib().registerTag("iconlabel".toLowerCase(),
                                      ingenias.editor.rendererxml.JLabelIcon.class);
    swiengine.getTaglib().registerTag("collectionpanel",
                                      ingenias.editor.rendererxml.CollectionPanel.class);
    swiengine.getTaglib().registerTag("linepanel",
                                      ingenias.editor.rendererxml.LinePanel.class);
    swiengine.getTaglib().registerTag("htmllabel",
                                      ingenias.editor.rendererxml.HTMLLabel.class);
    swiengine.getTaglib().registerTag("wraplabel",
                                      ingenias.editor.rendererxml.JMultilineLabel.class);
    swiengine.getTaglib().registerTag("dashedpanel",
                                      ingenias.editor.rendererxml.
                                      DashedBorderPanel.class);
    swiengine.getTaglib().registerTag("dashedverticallinepanel",
                                      ingenias.editor.rendererxml.DashedVerticalLinePanel.class);

    return swiengine;
  }

}
