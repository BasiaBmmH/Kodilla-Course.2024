package com.kodilla.testing.shape;

public class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String getShapeName() {
        return "Circle";
    }

    @Override
    public double getField() {
        return (3.14) * radius * radius;
    }
}
