package com.kelvin.calculator;

public class MinusHandler {
    public String run(String expression) {
        return this.handleAmbiguousMinusCharacter(expression);
    }

    // '-' minus character could mean minus operator or negative number
    // minus operator is replaced with underscore '_' instead
    private String handleAmbiguousMinusCharacter(String exp) {
        for (int pos = 0; pos < exp.length(); pos++) {
            if (isMinusOperator(exp, pos)) {
                StringBuilder stringBuilder = new StringBuilder(exp);
                stringBuilder.setCharAt(pos, '_');
                exp = stringBuilder.toString();
            }
        }
        return exp;
    }

    private boolean isMinusOperator(String exp, int pos) {
        char operator = exp.charAt(pos);
        Character previous = this.getPreviousCharacter(exp, pos);
        Character firstNext = this.getNextCharacter(exp, pos);
        Character secondNext = this.getNextCharacter(exp, pos + 1);

        if (operator != '-') {
            return false;
        }

        if (isDigit(previous)
                && isMinusChar(firstNext)
                && isDigit(secondNext)) {
            return true;
        }

        if (isDigit(previous)
                && isDigit(firstNext)) {
            return true;
        }

        return false;
    }

    private boolean isMinusChar(Character c) {
        return (c != null) && (c == '-');
    }

    private boolean isDigit(Character c) {
        return c != null && Character.isDigit(c);
    }

    private Character getPreviousCharacter(String exp, int pos) {
        if (pos - 1 < 0) {
            return null;
        } else {
            return exp.charAt(pos - 1);
        }
    }

    private Character getNextCharacter(String exp, int pos) {
        if (pos + 1 >= exp.length()) {
            return null;
        } else {
            return exp.charAt(pos + 1);
        }
    }
}
