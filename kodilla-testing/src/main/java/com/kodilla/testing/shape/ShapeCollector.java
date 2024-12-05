package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    private final List<Shape> shapes = new ArrayList<>();

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        return shapes.remove(shape);
    }

    public Shape getFigure(int n) {
        if (n >= 0 && n < shapes.size()) {
            return shapes.get(n);
        } else {
            return null;
        }
    }

    public String showFigures() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < shapes.size(); i++) {
            result.append(shapes.get(i).getShapeName());
            if (i < shapes.size() - 1) {
                result.append(", ");
            }
        }
        return result.toString();
    }

    public int getShapesCount() {
        return shapes.size();
    }
}
