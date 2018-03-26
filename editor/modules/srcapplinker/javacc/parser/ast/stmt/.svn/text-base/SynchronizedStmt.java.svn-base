/*
 * Created on 18/11/2006
 */
package javacc.parser.ast.stmt;

import javacc.parser.ast.expr.Expression;
import javacc.parser.ast.visitor.GenericVisitor;
import javacc.parser.ast.visitor.VoidVisitor;

/**
 * @author Julio Vilmar Gesser
 */
public final class SynchronizedStmt extends Statement {

    public final Expression expr;

    public final BlockStmt block;

    public SynchronizedStmt(Expression expr, BlockStmt block) {
        this.expr = expr;
        this.block = block;
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
