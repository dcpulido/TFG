/*
 * Created on 05/10/2006
 */
package javacc.parser.ast.body;

import javacc.parser.ast.Node;
import javacc.parser.ast.expr.Expression;
import javacc.parser.ast.visitor.GenericVisitor;
import javacc.parser.ast.visitor.VoidVisitor;

/**
 * @author Julio Vilmar Gesser
 */
public final class VariableDeclarator extends Node {

    public final VariableDeclaratorId id;

    public final Expression init;

    public VariableDeclarator(VariableDeclaratorId id, Expression init) {
        this.id = id;
        this.init = init;
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
