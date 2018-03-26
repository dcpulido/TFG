/*
 * Created on 05/11/2006
 */
package javacc.parser.ast.body;


import java.util.List;

import javacc.parser.ast.expr.Expression;
import javacc.parser.ast.visitor.GenericVisitor;
import javacc.parser.ast.visitor.VoidVisitor;

/**
 * @author Julio Vilmar Gesser
 */
public final class EnumConstantDeclaration extends BodyDeclaration {

    public final String name;

    public final List<Expression> args;

    public final List<BodyDeclaration> classBody;

    public EnumConstantDeclaration(String name, List<Expression> args, List<BodyDeclaration> classBody) {
        this.name = name;
        this.args = args;
        this.classBody = classBody;
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
