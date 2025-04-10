package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public Task makeTask(String taskClass) {
        return switch (taskClass) {
            case SHOPPING -> new ShoppingTask("buy groceries", "lemons", 2.0);
            case PAINTING -> new PaintingTask("paint bedroom", "yellow", "bedroom walls");
            case DRIVING -> new DrivingTask("drive to office", "center", "motor");
            default -> null;
        };
    }
}
