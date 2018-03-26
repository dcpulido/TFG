/*
 * Created on 05/10/2006
 */
package javacc.parser.ast.type;


import java.util.List;

import javacc.parser.ast.visitor.GenericVisitor;
import javacc.parser.ast.visitor.VoidVisitor;

/**
 * @author Julio Vilmar Gesser
 */
public final class ClassOrInterfaceType extends Type {

    public final ClassOrInterfaceType scope;

    public final String name;

    public final List<Type> typeArgs;

    public ClassOrInterfaceType(ClassOrInterfaceType scope, String name, List<Type> typeArgs) {
        this.scope = scope;
        this.name = name;
        this.typeArgs = typeArgs;
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
