package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.person.People;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {
//        Processor processor = new Processor();
//        processor.execute(() -> System.out.println("This is an example text.\n"));
//
//        ExpressionExecutor expressionExecutor = new ExpressionExecutor();       // [5]
//
//        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);           // [6]
//        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);           // [7]
//        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);           // [8]
//        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);
//
//        System.out.println("\nCalculating expressions with lambdas");
//        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
//        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
//        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
//        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);
//
//        System.out.println("\nCalculating expressions with method references");
//        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
//        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
//        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
//        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);
//
//        PoemBeautifier poemBeautifier = new PoemBeautifier();
//
//        System.out.println("\nPoem Beautifier results:");
//        poemBeautifier.beautify("poem", " beautifier", (text1, text2) -> text1 + "ABC" + text2.toUpperCase());
//        poemBeautifier.beautify("poem", " beautifier", (text1, text2) -> "ABC" + text1 + "ABC" + text2 + " aplication");
//        poemBeautifier.beautify("poem", " beautifier", (text1, text2) -> "~~ " + text1 + " ~~" + text2 + " ~~");
//        poemBeautifier.beautify("Hi", " Bye", (text1, text2) -> "(～￣▽￣)～ " + text1 + " and " + text2 + " ¬_¬");
//        poemBeautifier.beautify("poem", " beautifier", (text1, text2) -> "^^" + text1 + text2 + "^^");
//
//        System.out.println("Using Stream to generate even numbers from 1 to 20");
//        NumbersGenerator.generateEven(20);
//
//        People.getList().stream()
//                .map(s -> s.toUpperCase())
//                .forEach(System.out::println);
//
//        People.getList().stream()
//                .map(String::toUpperCase)
//                .forEach(s -> System.out.println(s));
//
//        System.out.println("\ndlugosc napisu > 11");
//        People.getList().stream()
//                .filter(s -> s.length() > 11)
//                .forEach(System.out::println);
//
//
//        People.getList().stream()
//                .map(String::toUpperCase)                             // [1]
//                .filter(s -> s.length() > 11)                         // [2]
//                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")   // [3]
//                .filter(s -> s.substring(0, 1).equals("M"))           // [4]
//                .forEach(System.out::println);


//        BookDirectory theBookDirectory = new BookDirectory();
//        theBookDirectory.getList().stream()
//                .filter(book -> book.getYearOfPublication() > 2005)
//                .forEach(System.out::println);
//
//        List<Book> theResultListOfBooks = theBookDirectory.getList().stream()   // [1]
//                .filter(book -> book.getYearOfPublication() > 2005)                  // [2]
//                .collect(Collectors.toList());                                       // [3]
//
//        System.out.println("# elements: " + theResultListOfBooks.size());       // [4]
//        theResultListOfBooks.stream()                                           // [5]
//                .forEach(System.out::println);
//
//
//        Map<String, Book> theResultMapOfBooks = theBookDirectory.getList().stream()
//                .filter(book -> book.getYearOfPublication() > 2005)
//                .collect(Collectors.toMap(Book::getSignature, book -> book));             // [1]
//
//        System.out.println("# elements: " + theResultMapOfBooks.size());             // [2]
//        theResultMapOfBooks.entrySet().stream()
//                .map(entry -> entry.getKey() + ": " + entry.getValue())                   // [3]
//                .forEach(System.out::println);
//
//
//        String theResultStringOfBooks = theBookDirectory.getList().stream()  // [1]
//                .filter(book -> book.getYearOfPublication() > 2005)
//                .map(Book::toString)
//                .collect(Collectors.joining(",\n", "<<", ">>"));                    // [2]
//
//        System.out.println(theResultStringOfBooks);

        Forum forum = new Forum();
        ForumUser firstUser = forum.getUserList().get(0);

        List<ForumUser> filteredUsers = forum.getUserList().stream()
                .filter(forumUser -> 'M' == forumUser.getSex())
                //.filter(forumUser -> LocalDate.now().getYear() - 20 >= forumUser.getBirthDay().getYear());
                .filter(forumUser -> LocalDate.now().minusYears(20).isAfter(forumUser.getBirthDay()))
                .filter(forumUser -> forumUser.getPostsCount() > 0)
                .map(user -> new ForumUser(user.getId(), user.getName(), user.getSex(), user.getBirthDay(), user.getPostsCount()))
                .toList();

        filteredUsers.forEach(user -> System.out.println(
                "ID: " + user.getId() + " Name: " + user.getName() + " BirthDay: " + user.getBirthDay() +
                        " Posts: " + user.getPostsCount()));


    }
}
