package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class BoardTestSuite {

    @Test
    void testTaskAdd() {
        // Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        // When
        board.getToDoList().addTask("Task 1");
        board.getInProgressList().addTask("Task 2");
        board.getDoneList().addTask("Task 3");

        // Then
        assertEquals("Task 1", board.getToDoList().getTasks().get(0));
        assertEquals("Task 2", board.getInProgressList().getTasks().get(0));
        assertEquals("Task 3", board.getDoneList().getTasks().get(0));
    }
}
