/*
 * Created on 04/11/2006
 */
package javacc.parser.ast.stmt;

import javacc.parser.ast.expr.Expression;
import javacc.parser.ast.visitor.GenericVisitor;
import javacc.parser.ast.visitor.VoidVisitor;

/**
 * @author Julio Vilmar Gesser
 */
public final class AssertStmt extends Statement {

    public final Expression check;

    public final Expression msg;

    public AssertStmt(Expression check, Expression msg) {
        this.check = check;
        this.msg = msg;
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
