package com.kelvin.calculator;

import com.kelvin.calculator.exception.InvalidOperandException;

import java.math.BigDecimal;

public class DecimalHelper {
    public BigDecimal parseDecimal(String operand) throws InvalidOperandException {
        if (this.isInvalidDecimal(operand)) {
            throw new InvalidOperandException();
        }
        return new BigDecimal(operand);
    }

    public boolean isInvalidDecimal(String operand) {
        if ("".equals(operand)) {
            return true;
        }

        for (char c : operand.toCharArray()) {
            if (this.isInvalidDecimalCharacter(c)) {
                return true;
            }
        }
        return false;
    }

    public boolean isInvalidDecimalCharacter(Character character) {
        return !Character.isDigit(character) && character != '.' && character != '-';
    }
}
