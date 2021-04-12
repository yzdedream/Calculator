package com.kelvin.calculator.operator;

import java.math.BigDecimal;

public class MultiplyOperator extends Operator {
    @Override
    protected void initProperties() {
        this.priority = 2;
        this.operandType = OperandType.LEFT_AND_RIGHT;
        this.signature = "*";
    }

    @Override
    protected boolean validate(BigDecimal leftOperand, BigDecimal rightOperand) {
        return leftOperand != null && rightOperand != null;
    }

    @Override
    protected BigDecimal calculate(BigDecimal leftOperand, BigDecimal rightOperand) {
        return leftOperand.multiply(rightOperand);
    }
}
