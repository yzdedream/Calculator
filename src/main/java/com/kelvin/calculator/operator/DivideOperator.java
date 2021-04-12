package com.kelvin.calculator.operator;

import java.math.BigDecimal;

public class DivideOperator extends Operator {
    @Override
    protected void initProperties() {
        this.operandType = OperandType.LEFT_AND_RIGHT;
        this.priority = 2;
        this.signature = "/";
    }

    @Override
    protected boolean validate(BigDecimal leftOperand, BigDecimal rightOperand) {
        return leftOperand != null && rightOperand != null && !rightOperand.equals(BigDecimal.ZERO);
    }

    @Override
    protected BigDecimal calculate(BigDecimal leftOperand, BigDecimal rightOperand) {
        return leftOperand.divide(rightOperand);
    }
}
