/*
 * Created on 05/10/2006
 */
package javacc.parser.ast.body;


import java.util.List;

import javacc.parser.ast.TypeParameter;
import javacc.parser.ast.expr.AnnotationExpr;
import javacc.parser.ast.expr.NameExpr;
import javacc.parser.ast.stmt.BlockStmt;
import javacc.parser.ast.visitor.GenericVisitor;
import javacc.parser.ast.visitor.VoidVisitor;

/**
 * @author Julio Vilmar Gesser
 */
public final class ConstructorDeclaration extends BodyDeclaration {

    public final int modifiers;

    public final List<AnnotationExpr> annotations;

    public final List<TypeParameter> typeParameters;

    public final String name;

    public final List<Parameter> parameters;

    public final List<NameExpr> throws_;

    public final BlockStmt block;

    public ConstructorDeclaration(int modifiers, List<AnnotationExpr> annotations, List<TypeParameter> typeParameters, String name, List<Parameter> parameters, List<NameExpr> throws_, BlockStmt block) {
        this.modifiers = modifiers;
        this.annotations = annotations;
        this.typeParameters = typeParameters;
        this.name = name;
        this.parameters = parameters;
        this.throws_ = throws_;
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
