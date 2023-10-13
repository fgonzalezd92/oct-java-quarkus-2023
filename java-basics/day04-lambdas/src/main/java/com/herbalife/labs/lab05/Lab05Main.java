package com.herbalife.labs.lab05;

public class Lab05Main {
    public static void main(String[] args) {
        DoubleNumberOperation adder = (a, b) -> a + b;
        SingleNumberOperation square = num -> num * num;
        operate(adder);
        compute(square);

        operate(new DoubleNumberOperation() {
            public int calculate(int num1, int num2) {
                return num1 + num2;
            }
        });
        operate((a, b) -> a + b);
        operate((a, b) -> a - b);
        operate((a, b) -> a * b);
        operate((a, b) -> a / b);
        operate((a, b) -> a * a + b * b + 2 * a * b);
        compute(a -> a * a);
        compute(a -> a * a * a);
    }

    static void operate(DoubleNumberOperation doubleNumberOperation) {
        //I am a big data function. I will get the data from some data source
        //You tell me what I should do with the data
        int result = doubleNumberOperation.calculate(5, 10);
        System.out.println(result);
    }

    static void compute(SingleNumberOperation singleNumberOperation) {
        int result = singleNumberOperation.calculate(10);
        System.out.println(result);
    }
}

class Calculator {
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int subtract(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public int divide(int num1, int num2) {
        return num1 / num2;
    }

    public int aPlusBWholeSquared(int num1, int num2) {
        return num1 + num2 + (2 * num1 * num2);
    }

}