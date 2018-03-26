/*
 * Created on 05/10/2006
 */
package javacc.parser.ast.expr;

import javacc.parser.ast.visitor.GenericVisitor;
import javacc.parser.ast.visitor.VoidVisitor;

/**
 * @author Julio Vilmar Gesser
 */
public final class LiteralExpr extends Expression {

    public final Object value;

    public LiteralExpr(Object value) {
        this.value = value;
    }

    @Override
    public <A> void accept(VoidVisitor<A> v, A arg) {
        v.visit(this, arg);
    }

    @Override
    public <R, A> R accept(GenericVisitor<R, A> v, A arg) {
        return v.visit(this, arg);
    }

    public static LiteralExpr newIntegerLiteral(String source) {
        int length = source.length();
        long computedValue = 0L;

        if (source.charAt(0) == '0') { // octal or hex
            if (length == 1) {
                return new LiteralExpr(new Integer(0));
            }
            final int shift;
            final int radix;
            int j;
            if ((source.charAt(1) == 'x') || (source.charAt(1) == 'X')) {
                radix = 16;
                shift = 4;
                j = 2;
            } else {
                radix = 8;
                shift = 3;
                j = 1;
            }
            while (source.charAt(j) == '0') {
                j++; //jump over redondant zero
                if (j == length) { //watch for 000000000000000000
                    return new LiteralExpr(new Integer(0));
                }
            }

            while (j < length) {
                int digitValue = Character.digit(source.charAt(j++), radix);
                computedValue = (computedValue << shift) | digitValue;
                if (computedValue > 0xFFFFFFFFL) {
                    throw new NumberFormatException();
                }
            }
        } else { // decimal, radix = 10
            for (int i = 0; i < length; i++) {
                int digitValue = Character.digit(source.charAt(i), 10);
                computedValue = 10 * computedValue + digitValue;
                if (computedValue > Integer.MAX_VALUE) {
                    throw new NumberFormatException();
                }
            }
        }
        return new LiteralExpr(new Integer((int) computedValue));
    }

    public static LiteralExpr newLongLiteral(String source) {
        int length = source.length() - 1; //minus one because the last char is 'l' or 'L'

        long computedValue;
        if (source.charAt(0) == '0') {
            if (length == 1) {
                return new LiteralExpr(new Long(0));
            }
            final int shift, radix;
            int j;
            if ((source.charAt(1) == 'x') || (source.charAt(1) == 'X')) {
                shift = 4;
                j = 2;
                radix = 16;
            } else {
                shift = 3;
                j = 1;
                radix = 8;
            }
            int nbDigit = 0;
            while (source.charAt(j) == '0') {
                j++; //jump over redondant zero
                if (j == length) {
                    //watch for 0000000000000L
                    return new LiteralExpr(new Long(0));
                }
            }

            int digitValue = Character.digit(source.charAt(j++), radix);
            if (digitValue >= 8) {
                nbDigit = 4;
            } else if (digitValue >= 4) {
                nbDigit = 3;
            } else if (digitValue >= 2) {
                nbDigit = 2;
            } else {
                nbDigit = 1; //digitValue is not 0
            }
            computedValue = digitValue;
            while (j < length) {
                digitValue = Character.digit(source.charAt(j++), radix);
                if ((nbDigit += shift) > 64) {
                    throw new NumberFormatException();
                }
                computedValue = (computedValue << shift) | digitValue;
            }
        } else {
            //-----------case radix=10-----------------
            long previous = 0;
            computedValue = 0;
            final long limit = Long.MAX_VALUE / 10; // needed to check prior to the multiplication
            for (int i = 0; i < length; i++) {
                int digitValue = Character.digit(source.charAt(i), 10);
                previous = computedValue;
                if (computedValue > limit) {
                    throw new NumberFormatException();
                }
                computedValue *= 10;
                if ((computedValue + digitValue) > Long.MAX_VALUE) {
                    throw new NumberFormatException();
                }
                computedValue += digitValue;
                if (previous > computedValue) {
                    throw new NumberFormatException();
                }
            }
        }
        return new LiteralExpr(new Long(computedValue));
    }

    public static LiteralExpr newCharLiteral(String source) {
        if (source.charAt(1) != '\\') {
            // just a letter
            return new LiteralExpr(source.charAt(1));
        }
        if (source.charAt(2) != 'u') {
            char c;
            switch (source.charAt(2)) {
                case 'b':
                    c = '\b';
                    break;
                case 't':
                    c = '\t';
                    break;
                case 'n':
                    c = '\n';
                    break;
                case 'f':
                    c = '\f';
                    break;
                case 'r':
                    c = '\r';
                    break;
                case '\"':
                    c = '\"';
                    break;
                case '\'':
                    c = '\'';
                    break;
                case '\\':
                    c = '\\';
                    break;
                default:
                    // octal
                    return new LiteralExpr((char) Integer.parseInt(source.substring(3, source.length() - 1), 8));
            }
            return new LiteralExpr(c);
        }
        // unicode
        return new LiteralExpr((char) Integer.parseInt(source.substring(3, 7), 16));
    }
}
