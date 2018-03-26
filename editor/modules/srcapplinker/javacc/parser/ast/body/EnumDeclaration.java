/*
 * Created on 05/10/2006
 */
package javacc.parser.ast.body;


import java.util.List;

import javacc.parser.ast.expr.AnnotationExpr;
import javacc.parser.ast.type.ClassOrInterfaceType;
import javacc.parser.ast.visitor.GenericVisitor;
import javacc.parser.ast.visitor.VoidVisitor;

/**
 * @author Julio Vilmar Gesser
 */
public final class EnumDeclaration extends TypeDeclaration {

    public final int modifiers;

    public final List<AnnotationExpr> annotations;

    public final List<ClassOrInterfaceType> implementsList;

    public final List<BodyDeclaration> members;

    public final List<EnumConstantDeclaration> entries;

    public EnumDeclaration(int modifiers, List<AnnotationExpr> annotations, String name, List<ClassOrInterfaceType> implementsList, List<EnumConstantDeclaration> entries, List<BodyDeclaration> members) {
        super(name);
        this.modifiers = modifiers;
        this.annotations = annotations;
        this.implementsList = implementsList;
        this.entries = entries;
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
