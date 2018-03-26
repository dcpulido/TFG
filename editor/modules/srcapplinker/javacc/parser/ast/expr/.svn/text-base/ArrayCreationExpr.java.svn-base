/*
 * Created on 05/10/2006
 */
package javacc.parser.ast.expr;


import java.util.List;

import javacc.parser.ast.type.Type;
import javacc.parser.ast.visitor.GenericVisitor;
import javacc.parser.ast.visitor.VoidVisitor;

/**
 * @author Julio Vilmar Gesser
 */
public final class ArrayCreationExpr extends Expression {

    public final Type type;

    public final List<Type> typeArgs;

    public final int arrayCount;

    public final ArrayInitializerExpr initializer;

    public final List<Expression> dimensions;

    public ArrayCreationExpr(Type type, List<Type> typeArgs, int arrayCount, ArrayInitializerExpr initializer) {
        this.type = type;
        this.typeArgs = typeArgs;
        this.arrayCount = arrayCount;
        this.initializer = initializer;
        this.dimensions = null;
    }

    public ArrayCreationExpr(Type type, List<Type> typeArgs, List<Expression> dimensions, int arrayCount) {
        this.type = type;
        this.typeArgs = typeArgs;
        this.arrayCount = arrayCount;
        this.dimensions = dimensions;
        this.initializer = null;
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
