package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {

    public static void main(String[] args) {
        Processor processor = new Processor();
        processor.execute(() -> System.out.println("This is an example text.\n"));

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();       // [5]

        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);           // [6]
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);           // [7]
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);           // [8]
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("\nCalculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("\nCalculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        System.out.println("\nPoem Beautifier results:");
        poemBeautifier.beautify("poem", " beautifier", (text1, text2) -> text1 + "ABC" + text2.toUpperCase());
        poemBeautifier.beautify("poem", " beautifier", (text1, text2) -> "ABC" + text1 + "ABC" + text2 + " aplication");
        poemBeautifier.beautify("poem", " beautifier", (text1, text2) -> "~~ " + text1 + " ~~" + text2 + " ~~");
        poemBeautifier.beautify("Hi", " Bye", (text1, text2) -> "(～￣▽￣)～ " + text1 + " and " + text2 + " ¬_¬");
        poemBeautifier.beautify("poem", " beautifier", (text1, text2) -> "^^" + text1 + text2 + "^^");


    }
}