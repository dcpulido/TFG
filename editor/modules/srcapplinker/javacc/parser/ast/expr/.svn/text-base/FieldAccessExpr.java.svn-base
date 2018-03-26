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
public final class FieldAccessExpr extends Expression {

    public final Expression object;

    public final List<Type> typeArgs;

    public final String field;

    public FieldAccessExpr(Expression object, List<Type> typeArgs, String field) {
        this.object = object;
        this.typeArgs = typeArgs;
        this.field = field;
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
