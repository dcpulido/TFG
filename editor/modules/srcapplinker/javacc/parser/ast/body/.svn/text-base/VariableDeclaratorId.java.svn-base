/*
 * Created on 05/10/2006
 */
package javacc.parser.ast.body;

import javacc.parser.ast.Node;
import javacc.parser.ast.visitor.GenericVisitor;
import javacc.parser.ast.visitor.VoidVisitor;

/**
 * @author Julio Vilmar Gesser
 */
public final class VariableDeclaratorId extends Node {

    public final String name;

    public final int arrayCount;

    public VariableDeclaratorId(String name, int arrayCount) {
        this.name = name;
        this.arrayCount = arrayCount;
    }

    @Override
    public <A> void accept(VoidVisitor<A> v, A arg) {
        v.visit(this, arg);
    }

    @Override
    public <R, A> R accept(GenericVisitor<R, A> v, A arg) {
        return v.visit(this, arg);
    }

}
