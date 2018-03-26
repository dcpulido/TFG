/*
 * Created on 21/11/2006
 */
package javacc.parser.ast.expr;


import java.util.List;

import javacc.parser.ast.visitor.GenericVisitor;
import javacc.parser.ast.visitor.VoidVisitor;

/**
 * @author Julio Vilmar Gesser
 */
public final class NormalAnnotationExpr extends AnnotationExpr {

    public final NameExpr name;

    public final List<MemberValuePair> pairs;

    public NormalAnnotationExpr(NameExpr name, List<MemberValuePair> pairs) {
        this.name = name;
        this.pairs = pairs;
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
