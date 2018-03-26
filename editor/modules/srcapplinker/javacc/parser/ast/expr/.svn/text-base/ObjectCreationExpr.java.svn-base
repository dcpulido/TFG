/*
 * Created on 05/10/2006
 */
package javacc.parser.ast.expr;


import java.util.List;

import javacc.parser.ast.body.BodyDeclaration;
import javacc.parser.ast.type.ClassOrInterfaceType;
import javacc.parser.ast.type.Type;
import javacc.parser.ast.visitor.GenericVisitor;
import javacc.parser.ast.visitor.VoidVisitor;

/**
 * @author Julio Vilmar Gesser
 */
public final class ObjectCreationExpr extends Expression {

    public final Expression scope;

    public final ClassOrInterfaceType type;

    public final List<Type> typeArgs;

    public final List<Expression> args;

    public final List<BodyDeclaration> anonymousClassBody;

    public ObjectCreationExpr(Expression scope, ClassOrInterfaceType type, List<Type> typeArgs, List<Expression> args, List<BodyDeclaration> anonymousBody) {
        this.scope = scope;
        this.type = type;
        this.typeArgs = typeArgs;
        this.args = args;
        this.anonymousClassBody = anonymousBody;
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
