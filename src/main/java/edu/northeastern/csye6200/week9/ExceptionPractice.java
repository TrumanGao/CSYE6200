package edu.northeastern.csye6200.week9;

public class ExceptionPractice {

    public static int div(int a, int b) throws Exception {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        } else {
            return a / b;
        }
    }

    static class OneException extends Exception {

    }

    static class TwoException extends OneException {
    }

    static void function1() throws OneException {
        throw new OneException();
    }

    static void function2() throws TwoException {
        throw new TwoException();
    }

    public static void main(String[] args) {
        try {
            function2();
        } catch (OneException e) {
            System.out.println("function1");
        }
    }

}
