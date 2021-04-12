package com.kelvin.calculator.operator;

import com.kelvin.calculator.exception.InvalidOperandException;

import java.math.BigDecimal;

public abstract class Operator {
    public enum OperandType {
        LEFT,
        RIGHT,
        LEFT_AND_RIGHT
    }

    public int priority;
    public OperandType operandType;
    public String signature;

    Operator() {
        this.initProperties();
    }

    public BigDecimal run(BigDecimal leftOperand, BigDecimal rightOperand) throws InvalidOperandException {
        if (!this.validate(leftOperand, rightOperand)) {
            throw new InvalidOperandException();
        }
        return this.calculate(leftOperand, rightOperand);
    }

    protected abstract void initProperties();

    protected abstract boolean validate(BigDecimal leftOperand, BigDecimal rightOperand);

    protected abstract BigDecimal calculate(BigDecimal leftOperand, BigDecimal rightOperand);
}
