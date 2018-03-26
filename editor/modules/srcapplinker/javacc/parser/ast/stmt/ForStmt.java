/*
 * Created on 07/11/2006
 */
package javacc.parser.ast.stmt;


import java.util.List;

import javacc.parser.ast.expr.Expression;
import javacc.parser.ast.visitor.GenericVisitor;
import javacc.parser.ast.visitor.VoidVisitor;

/**
 * @author Julio Vilmar Gesser
 */
public final class ForStmt extends Statement {

    public final List<Expression> init;

    public final List<Expression> update;

    public final Expression iterable;

    public final Statement body;

    public ForStmt(List<Expression> init, Expression iterable, List<Expression> update, Statement body) {
        this.iterable = iterable;
        this.init = init;
        this.update = update;
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
