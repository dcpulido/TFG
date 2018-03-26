/*
 * Created on 05/10/2006
 */
package javacc.parser.ast;


import java.util.List;

import javacc.parser.ast.body.TypeDeclaration;
import javacc.parser.ast.expr.NameExpr;
import javacc.parser.ast.visitor.GenericVisitor;
import javacc.parser.ast.visitor.VoidVisitor;

/**
 * @author Julio Vilmar Gesser
 */
public final class CompilationUnit extends Node {

    public final NameExpr pakage;

    public final List<ImportDeclaration> imports;

    public final List<TypeDeclaration> types;

    public CompilationUnit(NameExpr pakage, List<ImportDeclaration> imports, List<TypeDeclaration> types) {
        this.pakage = pakage;
        this.imports = imports;
        this.types = types;
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
