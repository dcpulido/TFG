/*
 * Created on 07/11/2006
 */
package javacc.parser.ast.stmt;

import javacc.parser.ast.expr.Expression;
import javacc.parser.ast.expr.VariableDeclarationExpr;
import javacc.parser.ast.visitor.GenericVisitor;
import javacc.parser.ast.visitor.VoidVisitor;

/**
 * @author Julio Vilmar Gesser
 */
public final class ForeachStmt extends Statement {

    public final VariableDeclarationExpr var;

    public final Expression iterable;

    public final Statement body;

    public ForeachStmt(VariableDeclarationExpr var, Expression iterable, Statement body) {
        this.var = var;
        this.iterable = iterable;
        this.body = body;
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
