package com.kelvin.calculator;

import com.kelvin.calculator.exception.InvalidOperandException;
import com.kelvin.calculator.operator.Operator;

import java.math.BigDecimal;

public class Operation {
    public int start;
    public int end;
    Operator operator;
    BigDecimal leftOperand = null;
    BigDecimal rightOperand = null;

    public OperationResult getResult() throws InvalidOperandException {
        OperationResult result = new OperationResult();
        result.start = this.start;
        result.end = this.end;
        result.result = operator.run(leftOperand, rightOperand);
        return result;
    }
}
