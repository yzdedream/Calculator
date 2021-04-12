package com.kelvin.calculator.test;

import com.kelvin.calculator.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DivideOperatorTest {
    @Test
    public void testDivideOperator() {
        Calculator calculator = new Calculator();

        String exp = "12/-3";
        String result = calculator.run(exp);
        assertTrue("-4".equals(result));

        String exp2 = "12/-3/1";
        String result2 = calculator.run(exp2);
        assertTrue("-4".equals(result2));

        String exp3 = "12/-3/0.5";
        String result3 = calculator.run(exp3);
        assertTrue("-8".equals(result3));

        String exp4 = "10/2/2";
        String result4 = calculator.run(exp4);
        assertTrue("2.5".equals(result4));
    }

    @Test
    public void testOperatorPriority() {
        Calculator calculator = new Calculator();

        String exp = "12/-3-1";
        String result = calculator.run(exp);
        assertTrue("-5".equals(result));

        String exp2 = "1-12/-3";
        String result2 = calculator.run(exp2);
        assertTrue("5".equals(result2));
    }

}
