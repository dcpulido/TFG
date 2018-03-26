/*
 * Created on 05/10/2006
 */
package javacc.parser.ast;

import javacc.parser.ast.expr.NameExpr;
import javacc.parser.ast.visitor.GenericVisitor;
import javacc.parser.ast.visitor.VoidVisitor;

/**
 * @author Julio Vilmar Gesser
 */
public final class ImportDeclaration extends Node {

    public final NameExpr name;

    public final boolean isStatic;

    public final boolean isAsterisk;

    public ImportDeclaration(NameExpr name, boolean isStatic, boolean isAsterisk) {
        this.name = name;
        this.isStatic = isStatic;
        this.isAsterisk = isAsterisk;
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
