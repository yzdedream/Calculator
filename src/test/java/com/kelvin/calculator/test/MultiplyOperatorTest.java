package com.kelvin.calculator.test;

import com.kelvin.calculator.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MultiplyOperatorTest {
    @Test
    public void testMultiplyOperator() {
        Calculator calculator = new Calculator();

        String exp = "12*-3";
        String result = calculator.run(exp);
        assertTrue("-36".equals(result));

        String exp2 = "12*-3*1";
        String result2 = calculator.run(exp2);
        assertTrue("-36".equals(result2));

        String exp3 = "12*-3*0.5";
        String result3 = calculator.run(exp3);
        assertTrue("-18.0".equals(result3));
    }

    @Test
    public void testOperatorPriority() {
        Calculator calculator = new Calculator();

        String exp = "12*-3+1";
        String result = calculator.run(exp);
        assertTrue("-35".equals(result));
    }

}
