/*
 * Programming 1 Exercise 6 - GeometricShapes
 * A program which takes input and lets you draw rectangles and circles
 * Author: Andreas Hofer
 * Last Change: 27.11.2024
 */

import java.util.Scanner;

public class GeometricShapes {
    private static final int MAX_INPUT = 2;
    private static final Scanner scanner = new Scanner(System.in);
    private static final String delimiter = ("----------");
    public enum menu {QUIT, RECTANGLE, CIRCLE, INVALID};

    public static void main(String[] args) {
        java.util.Locale.setDefault(java.util.Locale.US);
        scanner.useDelimiter("\n");

        menu command = menu.INVALID;
        while(command != menu.QUIT) {
            printMenu();
            String[] tokens = read();
            command = inputCommand(tokens);
            if (command != menu.QUIT) {
                createShape(command);
            }
        }
    }

    /**
     * Creates the shape classes, asks for input and prints them
     */
    private static void createShape(menu command) {
        switch (command) {
            case menu.CIRCLE:
                Circle.printSequence();
                Circle circle = new Circle(readPoint("Center"), readRadius());
                circle.printCircle();
                break;
            case menu.RECTANGLE:
                Rectangle.printSequence();
                Rectangle rectangle = new Rectangle(readPoint("First point"), readPoint("Second point"));
                rectangle.printRectangle();
                break;
        }
    }

    /**
     * Reads a string from the input and splits it based on spaces
     */
    private static String[] read() {
        String input = scanner.next();
        input = input.toLowerCase();
        return input.split(" ");
    }

    /**
     * Determines whether the command is valid and to where it leads
     */
    private static menu inputCommand(String[] tokens) {
        if (tokens.length > MAX_INPUT) {
            return menu.INVALID;
        }
        for (int index = 0; index < tokens.length; index++) {
            if (index == 0) {
                switch(tokens[index]) {
                    case "quit": return menu.QUIT;
                    case "new": break;
                    default: return menu.INVALID;
                }
            }
            else {
                return switch (tokens[index]) {
                    case "rectangle" -> menu.RECTANGLE;
                    case "circle" -> menu.CIRCLE;
                    default -> menu.INVALID;
                };
            }
        }
        return menu.INVALID;
    }

    /**
     * Prints the main menu
     */
    private static void printMenu() {
        System.out.println(delimiter.repeat(8));
        System.out.println("Available commands:");
        System.out.println("  \"New rectangle\" - create new rectangle");
        System.out.println("  \"New circle\" - create new circle");
        System.out.println("  \"Quit\" - quit program");
        System.out.println(delimiter.repeat(8));
        System.out.print("> ");
    }

    /**
     * Reads an int value to assign as radius
     */
    public static int readRadius() {
        int input = -1;
        while (input < 0) {
            System.out.print("  Radius: ");
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
            }
            else {
                scanner.next();
            }
        }
        return input;
    }

    /**
     * Reads two integers to return as a Point object
     */
    public static Point readPoint(String message) {
        char[] output = {'x', 'y'};
        int[] coords = new int[2];
        boolean valid;
        for (int index = 0; index < 2; index++) {
            valid = false;
            while (!valid) {
                    System.out.printf("  %s: %c coordinate: ", message, output[index]);
                if (scanner.hasNextInt()) {
                    coords[index] = scanner.nextInt();
                    valid = true;
                }
                else {
                    scanner.next();
                }
            }
        }
        return new Point(coords);
    }
}


