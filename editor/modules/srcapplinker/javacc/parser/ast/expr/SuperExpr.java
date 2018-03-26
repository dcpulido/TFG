/*
 * Created on 20/01/2007
 */
package javacc.parser.ast.expr;

import javacc.parser.ast.visitor.GenericVisitor;
import javacc.parser.ast.visitor.VoidVisitor;

/**
 * @author Julio Vilmar Gesser
 */
public final class SuperExpr extends Expression {

    public final Expression classExpr;

    public SuperExpr(Expression classExpr) {
        this.classExpr = classExpr;
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
