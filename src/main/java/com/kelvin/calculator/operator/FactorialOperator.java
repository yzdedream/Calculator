package com.kelvin.calculator.operator;

import java.math.BigDecimal;

public class FactorialOperator extends Operator {
    @Override
    protected void initProperties() {
        this.operandType = OperandType.LEFT;
        this.signature = "!";
        this.priority = 3;
    }

    @Override
    protected boolean validate(BigDecimal leftOperand, BigDecimal rightOperand) {
        return leftOperand != null
                && rightOperand == null
                && isInteger(leftOperand)
                && leftOperand.compareTo(BigDecimal.ZERO) > 0;
    }

    @Override
    protected BigDecimal calculate(BigDecimal leftOperand, BigDecimal rightOperand) {
        BigDecimal result = BigDecimal.ONE;
        for (BigDecimal i = leftOperand; i.compareTo(BigDecimal.ZERO) > 0; i = i.subtract(BigDecimal.ONE)) {
            result = result.multiply(i);
        }
        return result;
    }

    private boolean isInteger(BigDecimal bigDecimal) {
        return bigDecimal.scale() <= 0 || bigDecimal.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0;
    }
}
