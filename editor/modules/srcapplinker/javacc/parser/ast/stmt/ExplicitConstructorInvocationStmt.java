/*
 * Created on 03/11/2006
 */
package javacc.parser.ast.stmt;


import java.util.List;

import javacc.parser.ast.expr.Expression;
import javacc.parser.ast.visitor.GenericVisitor;
import javacc.parser.ast.visitor.VoidVisitor;

/**
 * @author Julio Vilmar Gesser
 */
public final class ExplicitConstructorInvocationStmt extends Statement {

    public final boolean isThis;

    public final Expression expr;

    public final List<Expression> args;

    public ExplicitConstructorInvocationStmt(boolean isThis, Expression expr, List<Expression> args) {
        this.isThis = isThis;
        this.expr = expr;
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
