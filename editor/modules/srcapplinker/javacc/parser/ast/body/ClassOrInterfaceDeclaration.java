/*
 * Created on 05/10/2006
 */
package javacc.parser.ast.body;


import java.util.List;

import javacc.parser.ast.TypeParameter;
import javacc.parser.ast.expr.AnnotationExpr;
import javacc.parser.ast.type.ClassOrInterfaceType;
import javacc.parser.ast.visitor.GenericVisitor;
import javacc.parser.ast.visitor.VoidVisitor;

/**
 * @author Julio Vilmar Gesser
 */
public final class ClassOrInterfaceDeclaration extends TypeDeclaration {

    public final int modifiers;

    public final List<AnnotationExpr> annotations;

    public final boolean isInterface;

    public final List<TypeParameter> typeParameters;

    public final List<ClassOrInterfaceType> extendsList;

    public final List<ClassOrInterfaceType> implementsList;

    public final List<BodyDeclaration> members;

    public ClassOrInterfaceDeclaration(int modifiers, List<AnnotationExpr> annotations, boolean isInterface, String name, List<TypeParameter> typeParameters, List<ClassOrInterfaceType> extendsList, List<ClassOrInterfaceType> implementsList, List<BodyDeclaration> members) {
        super(name);
        this.modifiers = modifiers;
        this.annotations = annotations;
        this.isInterface = isInterface;
        this.typeParameters = typeParameters;
        this.extendsList = extendsList;
        this.implementsList = implementsList;
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
