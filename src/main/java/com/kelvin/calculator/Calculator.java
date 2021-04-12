package com.kelvin.calculator;

import com.kelvin.calculator.exception.InvalidExpressionException;
import com.kelvin.calculator.exception.InvalidOperandException;
import com.kelvin.calculator.exception.InvalidOperatorException;
import com.kelvin.calculator.operator.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Calculator {
    private final List<Operator> operators = new ArrayList<>();
    private final MinusHandler minusHandler = new MinusHandler();
    private final DecimalHelper decimalHelper = new DecimalHelper();

    public Calculator() {
        this.initOperators();
    }

    private void initOperators() {
        this.operators.add(new PlusOperator());
        this.operators.add(new MinusOperator());
        this.operators.add(new MultiplyOperator());
        this.operators.add(new DivideOperator());
        this.operators.add(new FactorialOperator());
        this.operators.add(new SqrtOperator());
        this.sortOperatorList();
    }

    private void sortOperatorList() {
        this.operators.sort(Comparator.comparingInt(o -> -o.priority));
    }

    private String preprocessing(String exp) throws InvalidExpressionException {
        this.handleInvalidExpression(exp);
        return this.minusHandler.run(exp);
    }

    private void handleInvalidExpression(String exp) throws InvalidExpressionException {
        if (exp == null || "".equals(exp)) {
            throw new InvalidExpressionException();
        }
    }

    public String run(String expression) {
        String result;
        try {
            expression = this.preprocessing(expression);
            result = this.calculateResult(expression);
            result = this.validateResult(result);
        } catch (InvalidOperandException e) {
            e.printStackTrace();
            return "Invalid operand";
        } catch (InvalidOperatorException e) {
            e.printStackTrace();
            return "Invalid operator";
        } catch (InvalidExpressionException e) {
            e.printStackTrace();
            return "Invalid expression";
        }
        return result;
    }

    private String calculateResult(String expression) throws InvalidOperandException {
        for (Operator operator : this.operators) {
            while (expression.contains(operator.signature)) {
                Operation operation = this.buildOperation(expression, operator);
                OperationResult result = operation.getResult();
                expression = this.replaceSubExpressionWithResult(expression, result);
            }
        }
        return expression;
    }

    private String validateResult(String expression) throws InvalidOperatorException {
        if (this.decimalHelper.isInvalidDecimal(expression)) {
            throw new InvalidOperatorException();
        }
        return expression;
    }


    private Operation buildOperation(String expression, Operator operator) throws InvalidOperandException {
        Operation operation = new Operation();
        operation.operator = operator;
        int operatorStartPosition = expression.indexOf(operator.signature);
        int operatorEndPosition = operatorStartPosition + operator.signature.length() - 1;

        switch (operator.operandType) {
            case LEFT:
                this.fillLeftOperand(expression, operatorStartPosition, operation);
                operation.end = operatorEndPosition;
                break;
            case RIGHT:
                this.fillRightOperand(expression, operatorEndPosition, operation);
                operation.start = operatorStartPosition;
                break;
            case LEFT_AND_RIGHT:
                this.fillLeftOperand(expression, operatorStartPosition, operation);
                this.fillRightOperand(expression, operatorEndPosition, operation);
                break;
            default:
                break;
        }
        return operation;
    }

    private void fillLeftOperand(String exp, int operatorPosition, Operation operation) throws InvalidOperandException {
        for (int pos = operatorPosition - 1; pos >= 0; pos--) {
            if (this.decimalHelper.isInvalidDecimalCharacter(exp.charAt(pos))) {
                operation.start = pos + 1;
                String lefOperandSubstring = exp.substring(pos + 1, operatorPosition);
                operation.leftOperand = this.decimalHelper.parseDecimal(lefOperandSubstring);
                break;
            } else if (pos == 0) {
                operation.start = pos;
                String lefOperandSubstring = exp.substring(0, operatorPosition);
                operation.leftOperand = this.decimalHelper.parseDecimal(lefOperandSubstring);
            }
        }
    }

    private void fillRightOperand(String exp, int operatorPosition, Operation operation) throws InvalidOperandException {
        int length = exp.length();
        for (int pos = operatorPosition + 1; pos < length; pos++) {
            if (this.decimalHelper.isInvalidDecimalCharacter(exp.charAt(pos))) {
                operation.end = pos;
                String rightOperandSubstring = exp.substring(operatorPosition + 1, pos);
                operation.rightOperand = this.decimalHelper.parseDecimal(rightOperandSubstring);
                break;
            } else if (pos == length - 1) {
                operation.end = pos;
                String rightOperandSubstring = exp.substring(operatorPosition + 1);
                operation.rightOperand = this.decimalHelper.parseDecimal(rightOperandSubstring);
            }
        }
    }

    private String replaceSubExpressionWithResult(String exp, OperationResult result) {
        StringBuilder stringBuilder = new StringBuilder(exp);
        if (result.end == exp.length() - 1) {
            stringBuilder.replace(result.start, result.end + 1, result.result.toString());
        } else {
            stringBuilder.replace(result.start, result.end, result.result.toString());
        }
        return stringBuilder.toString();
    }
}
