package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public void beautify(String text1, String text2, PoemDecorator poemDecorator) {

        String result = poemDecorator.decorate(text1, text2);
        System.out.println("Result equals: " + result);
    }

}
