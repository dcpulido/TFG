/*
 * Created on 07/11/2006
 */
package javacc.parser.ast.body;

import javacc.parser.ast.stmt.BlockStmt;
import javacc.parser.ast.visitor.GenericVisitor;
import javacc.parser.ast.visitor.VoidVisitor;

/**
 * @author Julio Vilmar Gesser
 */
public final class InitializerDeclaration extends BodyDeclaration {

    public final BlockStmt block;

    public InitializerDeclaration(BlockStmt block) {
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
