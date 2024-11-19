package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {

    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        System.out.println("Test - pierwszy test jednostkowy:");
///////////////////////////////////////////////////////////////////////

        Calculator calculator = new Calculator();

        if (10 == calculator.add(3, 7)) {
            System.out.println("test passed");
        } else {
            System.out.println("ERROR");
        }

        if (-4 == calculator.subtract(3, 7)) {
            System.out.println("test passed");
        } else {
            System.out.println("ERROR");
        }


    }
}