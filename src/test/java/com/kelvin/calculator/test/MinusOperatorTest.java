package com.kelvin.calculator.test;

import com.kelvin.calculator.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MinusOperatorTest {
    @Test
    public void testMinusOperation() {
        Calculator calculator = new Calculator();

        String exp = "12--3";
        String result = calculator.run(exp);
        assertTrue("15".equals(result));

        String exp2 = "12-3";
        String result2 = calculator.run(exp2);
        assertTrue("9".equals(result2));

        String exp3 = "-12-3";
        String result3 = calculator.run(exp3);
        assertTrue("-15".equals(result3));
    }

}
