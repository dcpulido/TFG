/*
 * Created on 05/10/2006
 */
package javacc.parser.ast.type;

import javacc.parser.ast.visitor.GenericVisitor;
import javacc.parser.ast.visitor.VoidVisitor;

/**
 * @author Julio Vilmar Gesser
 */
public final class PrimitiveType extends Type {

    public static PrimitiveType NULL = new PrimitiveType(Primitive.Null);

    public static PrimitiveType BOOLEAN = new PrimitiveType(Primitive.Boolean);

    public static PrimitiveType CHAR = new PrimitiveType(Primitive.Char);

    public static PrimitiveType BYTE = new PrimitiveType(Primitive.Byte);

    public static PrimitiveType SHORT = new PrimitiveType(Primitive.Short);

    public static PrimitiveType INT = new PrimitiveType(Primitive.Int);

    public static PrimitiveType LONG = new PrimitiveType(Primitive.Long);

    public static PrimitiveType FLOAT = new PrimitiveType(Primitive.Float);

    public static PrimitiveType DOUBLE = new PrimitiveType(Primitive.Double);

    public enum Primitive {
        Null, Boolean, Char, Byte, Short, Int, Long, Float, Double
    }

    public final Primitive type;

    private PrimitiveType(Primitive type) {
        this.type = type;
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
