/*
 * Created on 05/10/2006
 */
package javacc.parser.ast;

import javacc.parser.ast.visitor.DumpVisitor;
import javacc.parser.ast.visitor.GenericVisitor;
import javacc.parser.ast.visitor.VoidVisitor;

/**
 * @author Julio Vilmar Gesser
 */
public abstract class Node {

    /**
     * This attribute can store additional information from semantic analysis.
     */
    public Object data;

    public <A> void accept(VoidVisitor<A> v, A arg) {
        v.visit(this, arg);
    }

    public <R, A> R accept(GenericVisitor<R, A> v, A arg) {
        return v.visit(this, arg);
    }

    @Override
    public final String toString() {
        DumpVisitor visitor = new DumpVisitor();
        accept(visitor, null);
        return visitor.getSource();
    }

}
