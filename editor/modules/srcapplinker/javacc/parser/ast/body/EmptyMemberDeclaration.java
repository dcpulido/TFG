/*
 * Created on 07/11/2006
 */
package javacc.parser.ast.body;

import javacc.parser.ast.visitor.GenericVisitor;
import javacc.parser.ast.visitor.VoidVisitor;

/**
 * @author Julio Vilmar Gesser
 */
public final class EmptyMemberDeclaration extends BodyDeclaration {

    public static final EmptyMemberDeclaration SINGLETON = new EmptyMemberDeclaration();

    private EmptyMemberDeclaration() {
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
