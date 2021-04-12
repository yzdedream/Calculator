package com.kelvin.calculator.test;

import com.kelvin.calculator.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FactorialOperatorTest {
    @Test
    public void testFactorialOperation() {
        Calculator calculator = new Calculator();

        String exp = "1!";
        String result1 = calculator.run(exp);
        assertTrue(result1.equals("1"));

        String exp2 = "3!";
        String result2 = calculator.run(exp2);
        assertTrue(result2.equals("6"));
    }

    @Test
    public void testInvalidOperand() {
        Calculator calculator = new Calculator();

        String exp = "1.5!";
        String result1 = calculator.run(exp);
        assertTrue(result1.equals("Invalid operand"));

        String exp2 = "-3!";
        String result2 = calculator.run(exp2);
        assertTrue(result2.equals("Invalid operand"));


        String exp3 = "0!";
        String result3 = calculator.run(exp3);
        assertTrue(result3.equals("Invalid operand"));
    }
}
