/*
 * Created on 04/11/2006
 */
package javacc.parser.ast.stmt;


import java.util.List;

import javacc.parser.ast.expr.Expression;
import javacc.parser.ast.visitor.GenericVisitor;
import javacc.parser.ast.visitor.VoidVisitor;

/**
 * @author Julio Vilmar Gesser
 */
public final class SwitchEntryStmt extends Statement {

    public final Expression label;

    public final List<Statement> stmts;

    public SwitchEntryStmt(Expression label, List<Statement> stmts) {
        this.label = label;
        // TODO Auto-generated constructor stub
        this.stmts = stmts;
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
