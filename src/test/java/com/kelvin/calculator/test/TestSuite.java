package com.kelvin.calculator.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CalculatorTest.class,
        PlusOperatorTest.class,
        MinusOperatorTest.class,
        MultiplyOperatorTest.class,
        DivideOperatorTest.class,
        FactorialOperatorTest.class,
        SqrtOperatorTest.class
})

public class TestSuite {

}
