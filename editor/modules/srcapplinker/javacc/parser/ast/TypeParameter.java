/*
 * Created on 05/10/2006
 */
package javacc.parser.ast;


import java.util.List;

import javacc.parser.ast.type.ClassOrInterfaceType;
import javacc.parser.ast.visitor.GenericVisitor;
import javacc.parser.ast.visitor.VoidVisitor;

/**
 * @author Julio Vilmar Gesser
 */
public final class TypeParameter extends Node {

    public final String name;

    public final List<ClassOrInterfaceType> typeBound;

    public TypeParameter(String name, List<ClassOrInterfaceType> typeBound) {
        this.name = name;
        this.typeBound = typeBound;
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
