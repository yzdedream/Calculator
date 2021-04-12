package com.kelvin.calculator.operator;

import java.math.BigDecimal;

public class PlusOperator extends Operator {

    @Override
    protected void initProperties() {
        this.priority = 1;
        this.operandType = OperandType.LEFT_AND_RIGHT;
        this.signature = "+";
    }

    @Override
    protected boolean validate(BigDecimal leftOperand, BigDecimal rightOperand) {
        return leftOperand != null && rightOperand != null;
    }

    @Override
    public BigDecimal calculate(BigDecimal leftOperand, BigDecimal rightOperand) {
        return leftOperand.add(rightOperand);
    }
}
