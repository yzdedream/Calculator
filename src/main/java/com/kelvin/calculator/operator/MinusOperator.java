package com.kelvin.calculator.operator;

import java.math.BigDecimal;

public class MinusOperator extends Operator {

    @Override
    protected void initProperties() {
        this.priority = 0;
        this.operandType = OperandType.LEFT_AND_RIGHT;
        this.signature = "_"; // minus operator modified to '_' to avoid ambiguities
    }

    @Override
    protected boolean validate(BigDecimal leftOperand, BigDecimal rightOperand) {
        return leftOperand != null && rightOperand != null;
    }

    @Override
    protected BigDecimal calculate(BigDecimal leftOperand, BigDecimal rightOperand) {
        return leftOperand.subtract(rightOperand);
    }
}
