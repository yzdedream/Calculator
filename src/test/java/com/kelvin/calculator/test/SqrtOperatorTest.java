package com.kelvin.calculator.test;

import com.kelvin.calculator.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SqrtOperatorTest {
    @Test
    public void testSqrtOperator() {
        Calculator calculator = new Calculator();

        String exp = "Sqrt 4";
        String result1 = calculator.run(exp);
        assertTrue(result1.equals("2"));


        String exp2 = "3*Sqrt 4";
        String result2 = calculator.run(exp2);
        assertTrue(result2.equals("6"));

        String exp3 = "3*Sqrt 0";
        String result3 = calculator.run(exp3);
        assertTrue(result3.equals("0"));

        String exp4 = "3*Sqrt 0+1";
        String result4 = calculator.run(exp4);
        assertTrue(result4.equals("1"));
    }

    @Test
    public void testInvalidOperand() {
        Calculator calculator = new Calculator();

        String exp = "Sqrt ";
        String result1 = calculator.run(exp);
        assertTrue(result1.equals("Invalid operand"));

        String exp2 = "Sqrt -1";
        String result2 = calculator.run(exp2);
        assertTrue(result2.equals("Invalid operand"));
    }
}
