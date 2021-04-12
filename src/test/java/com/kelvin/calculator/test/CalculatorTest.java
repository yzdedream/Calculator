package com.kelvin.calculator.test;

import com.kelvin.calculator.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CalculatorTest {

    @Test
    public void testCalculator() {
        Calculator calculator = new Calculator();

        String exp1 = "1+1";
        String result1 = calculator.run(exp1);
        assertTrue("2".equals(result1));

        String exp2 = "1.5+1.5";
        String result2 = calculator.run(exp2);
        assertTrue("3.0".equals(result2));

        String exp3 = "10+10+10";
        String result3 = calculator.run(exp3);
        assertTrue("30".equals(result3));
    }

    @Test
    public void testNegativeOperand() {
        Calculator calculator = new Calculator();

        String exp = "12+-3";
        String result = calculator.run(exp);
        assertTrue("9".equals(result));

        String exp2 = "-3+-3";
        String result2 = calculator.run(exp2);
        assertTrue("-6".equals(result2));

        String exp3 = "-3+12";
        String result3 = calculator.run(exp3);
        assertTrue("9".equals(result3));
    }

    @Test
    public void testInvalidOperand() {
        Calculator calculator = new Calculator();
        String exp = "k+3";
        String result = calculator.run(exp);
        assertEquals("Invalid operand", result);

        String exp1 = "3+k";
        String result1 = calculator.run(exp1);
        assertEquals("Invalid operand", result1);

        String exp2 = "+3";
        String result2 = calculator.run(exp2);
        assertEquals("Invalid operand", result2);

        String exp3 = "3+";
        String result3 = calculator.run(exp3);
        assertEquals("Invalid operand", result3);

        String exp4 = "+";
        String result4 = calculator.run(exp4);
        assertEquals("Invalid operand", result4);

        String exp5 = "k+k";
        String result5 = calculator.run(exp5);
        assertEquals("Invalid operand", result5);
    }

    @Test
    public void testInvalidOperator() {
        Calculator calculator = new Calculator();
        String exp = "3&3";
        String result = calculator.run(exp);
    }

    @Test
    public void testEmptyCases() {
        Calculator calculator = new Calculator();
        String result1 = calculator.run("");
        assertEquals("Invalid expression", result1);

        String result2 = calculator.run(null);
        assertEquals("Invalid expression", result2);
    }

    @Test
    public void testDecimalOperand() {
        Calculator calculator = new Calculator();

        String exp = "1.1+2.3";
        String result = calculator.run(exp);
        assertTrue("3.4".equals(result));


        String exp2 = "3-0.5";
        String result2 = calculator.run(exp2);
        assertTrue("2.5".equals(result2));
    }
}
