package com.kelvin.calculator;

public class App {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String result = calculator.run("2+3+3");
        String result2 = calculator.run("2+3-3");
        String result3 = calculator.run("5/2-3");


        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
    }
}
