package com.kodilla.testing.shape;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ShapeCollector Test Suite")
class ShapeCollectorTestSuite {


    @Nested
    @DisplayName("tests for adding and removing shapes")

    class AddRemoveShapes {

        @Test
        @DisplayName("adding shape to the collection")
        void testAddFigure() {
            // Given
            ShapeCollector collector = new ShapeCollector();
            Shape circle = new Circle(5.0);

            // When
            collector.addFigure(circle);

            // Then
            assertEquals(1, collector.getShapesCount());
            assertEquals(circle, collector.getFigure(0));
        }

        @Test
        @DisplayName("removing shape from the collection")
        void testRemoveFigure() {
            // Given
            ShapeCollector collector = new ShapeCollector();
            Shape square = new Square(4.0);
            collector.addFigure(square);

            // When
            boolean result = collector.removeFigure(square);

            // Then
            assertTrue(result);
            assertEquals(0, collector.getShapesCount());
        }

        @Test
        @DisplayName("should NOT remove a shape that's not in the collection")
        void testRemoveNonExistentFigure() {
            // Given
            ShapeCollector collector = new ShapeCollector();
            Shape triangle = new Triangle(3.0, 4.0);

            // When
            boolean result = collector.removeFigure(triangle);

            // Then
            assertFalse(result);
            assertEquals(0, collector.getShapesCount());
        }
    }

    @Nested
    @DisplayName("Tests for retrieving shapes")
    class RetrieveShapes {

        @Test
        @DisplayName("retrieving a shape from a specific position")
        void testGetFigure() {
            // Given
            ShapeCollector collector = new ShapeCollector();
            Shape square = new Square(4.0);
            collector.addFigure(square);

            // When
            Shape retrievedShape = collector.getFigure(0);

            // Then
            assertEquals(square, retrievedShape);
        }

        @Test
        @DisplayName("NUL when retrieving from an invalid position")
        void testGetFigureInvalidIndex() {
            // Given
            ShapeCollector collector = new ShapeCollector();

            // When
            Shape retrievedShape = collector.getFigure(5);

            // Then
            assertNull(retrievedShape);
        }
    }

    @Nested
    @DisplayName("Tests for showing figures")
    class ShowFigures {

        @Test
        @DisplayName("return names of all shapes in the collection")
        void testShowFigures() {
            // Given
            ShapeCollector collector = new ShapeCollector();
            collector.addFigure(new Circle(5.0));
            collector.addFigure(new Square(4.0));
            collector.addFigure(new Triangle(3.0, 4.0));

            // When
            String result = collector.showFigures();

            // Then
            assertEquals("Circle, Square, Triangle", result);
        }

        @Test
        @DisplayName("return an empty string if no shapes are in the collection")
        void testShowFiguresEmptyCollection() {
            // Given
            ShapeCollector collector = new ShapeCollector();

            // When
            String result = collector.showFigures();

            // Then
            assertEquals("", result);
        }
    }
}
