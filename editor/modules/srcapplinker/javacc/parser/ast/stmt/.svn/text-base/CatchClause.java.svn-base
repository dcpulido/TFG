/*
 * Created on 18/11/2006
 */
package javacc.parser.ast.stmt;

import javacc.parser.ast.Node;
import javacc.parser.ast.body.Parameter;
import javacc.parser.ast.visitor.GenericVisitor;
import javacc.parser.ast.visitor.VoidVisitor;

/**
 * @author Julio Vilmar Gesser
 */
public final class CatchClause extends Node {

    public final Parameter except;

    public final BlockStmt catchBlock;

    public CatchClause(Parameter except, BlockStmt catchBlock) {
        this.except = except;
        this.catchBlock = catchBlock;
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
