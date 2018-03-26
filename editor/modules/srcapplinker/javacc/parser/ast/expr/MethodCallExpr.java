/*
 * Created on 05/10/2006
 */
package javacc.parser.ast.expr;


import java.util.List;

import javacc.parser.ast.visitor.GenericVisitor;
import javacc.parser.ast.visitor.VoidVisitor;

/**
 * @author Julio Vilmar Gesser
 */
public final class MethodCallExpr extends Expression {

    public final Expression name;

    public final List<Expression> args;

    public MethodCallExpr(Expression name, List<Expression> args) {
        this.name = name;
        this.args = args;
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
