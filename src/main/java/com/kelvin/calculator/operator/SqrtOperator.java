package com.kelvin.calculator.operator;

import java.math.BigDecimal;

public class SqrtOperator extends Operator {

    @Override
    protected void initProperties() {
        this.operandType = OperandType.RIGHT;
        this.signature = "Sqrt ";
        this.priority = 3;
    }

    @Override
    protected boolean validate(BigDecimal leftOperand, BigDecimal rightOperand) {
        return leftOperand == null
                && rightOperand != null
                && rightOperand.compareTo(BigDecimal.ZERO) >= 0;
    }

    @Override
    protected BigDecimal calculate(BigDecimal leftOperand, BigDecimal rightOperand) {
        if (rightOperand.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }
        BigDecimal bd = BigDecimal.valueOf(Math.sqrt(rightOperand.doubleValue()));
        return bd.add(BigDecimal.valueOf(rightOperand.subtract(bd.multiply(bd)).doubleValue() / (bd.doubleValue() * 2.0)));
        // 32 digits only
    }

}
