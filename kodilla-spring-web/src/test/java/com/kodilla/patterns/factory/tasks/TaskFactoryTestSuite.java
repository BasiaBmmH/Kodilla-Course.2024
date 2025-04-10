package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskFactoryTestSuite {

    @Test
    void testShoppingTask() {
        // Given
        TaskFactory factory = new TaskFactory();
        Task task = factory.makeTask(TaskFactory.SHOPPING);

        // When
        task.executeTask();

        // Then
        assertEquals("buy groceries", task.getTaskName());
        assertTrue(task.isTaskExecuted());
    }

    @Test
    void testPaintingTask() {
        // Given
        TaskFactory factory = new TaskFactory();
        Task task = factory.makeTask(TaskFactory.PAINTING);

        // When
        task.executeTask();

        // Then
        assertEquals("paint bedroom", task.getTaskName());
        assertTrue(task.isTaskExecuted());
    }

    @Test
    void testDrivingTask() {
        // Given
        TaskFactory factory = new TaskFactory();
        Task task = factory.makeTask(TaskFactory.DRIVING);

        // When
        task.executeTask();

        // Then
        assertEquals("drive to office", task.getTaskName());
        assertTrue(task.isTaskExecuted());
    }
}
