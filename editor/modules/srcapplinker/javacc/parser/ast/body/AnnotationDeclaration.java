/*
 * Created on 21/11/2006
 */
package javacc.parser.ast.body;


import java.util.List;

import javacc.parser.ast.expr.AnnotationExpr;
import javacc.parser.ast.visitor.GenericVisitor;
import javacc.parser.ast.visitor.VoidVisitor;

/**
 * @author Julio Vilmar Gesser
 */
public final class AnnotationDeclaration extends TypeDeclaration {

    public final int modifiers;

    public final List<AnnotationExpr> annotations;

    public final List<BodyDeclaration> members;

    public AnnotationDeclaration(int modifiers, List<AnnotationExpr> annotations, String name, List<BodyDeclaration> members) {
        super(name);
        this.modifiers = modifiers;
        this.annotations = annotations;
        this.members = members;
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
