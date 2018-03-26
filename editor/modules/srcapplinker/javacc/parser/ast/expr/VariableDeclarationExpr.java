/*
 * Created on 03/11/2006
 */
package javacc.parser.ast.expr;


import java.util.List;

import javacc.parser.ast.body.VariableDeclarator;
import javacc.parser.ast.type.Type;
import javacc.parser.ast.visitor.GenericVisitor;
import javacc.parser.ast.visitor.VoidVisitor;

/**
 * @author Julio Vilmar Gesser
 */
public final class VariableDeclarationExpr extends Expression {

    public final int modifiers;

    public final List<AnnotationExpr> annotations;

    public final Type type;

    public final List<VariableDeclarator> vars;

    public VariableDeclarationExpr(int modifiers, List<AnnotationExpr> annotations, Type type, List<VariableDeclarator> vars) {
        this.modifiers = modifiers;
        this.annotations = annotations;
        this.type = type;
        this.vars = vars;
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
