package com.kelvin.calculator.test;

import com.kelvin.calculator.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PlusOperatorTest {
    @Test
    public void testPlusOperation() {
        Calculator calculator = new Calculator();

        String exp1 = "1+1";
        String result1 = calculator.run(exp1);
        assertTrue("2".equals(result1));

        String exp2 = "1+1+1";
        String result2 = calculator.run(exp2);
        assertTrue("3".equals(result2));
    }
}
