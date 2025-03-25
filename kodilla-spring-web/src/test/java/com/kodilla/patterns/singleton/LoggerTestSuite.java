package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoggerTestSuite {

    @Test
    void testGetLastLog() {
        // Given
        Logger logger = Logger.getInstance();
        logger.log("First log");

        // When
        String lastLog = logger.getLastLog();

        // Then
        Assertions.assertEquals("First log", lastLog);
    }

    @Test
    void testSingletonInstance() {
        // Given
        Logger firstLogger = Logger.getInstance();
        Logger secondLogger = Logger.getInstance();

        // When
        firstLogger.log("Singleton test log");

        // Then
        Assertions.assertEquals("Singleton test log", secondLogger.getLastLog());
    }
}
