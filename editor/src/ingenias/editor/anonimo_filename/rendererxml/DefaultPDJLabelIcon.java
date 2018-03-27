package ingenias.editor.rendererxml;

public class DefaultPDJLabelIcon extends java.beans.DefaultPersistenceDelegate{
    protected void initialize(Class type, Object oldInstance,
                              Object newInstance, java.beans.Encoder out) {
        super.initialize(type, oldInstance,  newInstance, out);

        JLabelIcon m =
            (JLabelIcon)oldInstance;
        JLabelIcon n =
            (JLabelIcon)newInstance;
        out.writeStatement(
                        new java.beans.Statement(oldInstance,
                                      "setIconName",
                                      new Object[]{ m.getIconName()}) );

    }
}
