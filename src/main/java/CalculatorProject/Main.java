package CalculatorProject;

public class Main {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        int sum = calculator.add(10, 5);
        System.out.println("sum =  " + sum);

        int difference = calculator.subtract(10, 5);
        System.out.println("diff =  " + difference);
    }
}


