package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

@DisplayName("Collection Test Suite")
public class CollectionTestSuite {

    @BeforeEach
    public void beforeEachTest() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void afterEachTest() {
        System.out.println("Test Case: end");
    }

    @Test
    @DisplayName("Test for empty list")
    public void testOddNumbersExterminatorEmptyList() {
        // Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> emptyList = Arrays.asList();

        // When
        List<Integer> result = exterminator.exterminate(emptyList);

        // Then
        Assertions.assertTrue(result.isEmpty(), "Result list should be empty for an empty input list.");
    }

    @Test
    @DisplayName("Test for normal list with even and odd numbers")
    public void testOddNumbersExterminatorNormalList() {
        // Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> normalList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // When
        List<Integer> result = exterminator.exterminate(normalList);

        // Then
        List<Integer> expectedList = Arrays.asList(2, 4, 6, 8, 10);
        Assertions.assertEquals(expectedList, result, "The result list should contain only even numbers.");
    }
}
