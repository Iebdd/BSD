/*
 * Programming 1 Exercise 6 - GeometricShapes
 * A program which takes input and lets you draw rectangles and circles
 * Author: Andreas Hofer
 * Last Change: 27.11.2024
 */

import java.lang.Math;

public class Circle {
    private static int sequence = 1;
    private final Point point;
    private final int radius;

    /**
     * Takes a Point object and an integer and assigns it as instance variables
     */
    public Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    /**
     * Prints the amount of circles printed during this execution
     */
    public static void printSequence() {
        System.out.printf("Rectangle #%d:%n", sequence);
        sequence++;
    }

    /**
     * Returns the x coordinate of the Point instance variable
     */
    public int getX() {
        return point.getX();
    }

    /**
     * Returns the y coordinate of the Point instance variable
     */
    public int getY() {
        return point.getY();
    }

    /**
     * Returns the area of the circle
     */
    private double findArea() {
        return Math.pow(this.radius, 2) * Math.PI;
    }

    /**
     * Prints the parameters of the current circle
     */
    public void printCircle() {
        System.out.printf("  Center:  (%d,%d)%n", getX(), getY());
        System.out.printf("  Radius:  %-5d%n", radius);
        System.out.printf("  Area:    %-5.2f%n", findArea());
        if (this.radius > 0) {
            printImage();
        }

    }

    /**
     * Prints an ASCII representation of the circle
     */
    private void printImage() {
        System.out.printf("  %s--%s%n", "  ".repeat(this.radius), "  ".repeat(this.radius));
        for(int radius = 0; radius < this.radius; radius++) {
            System.out.printf("  %s%n", " ".repeat(6 + this.radius));
        }
        System.out.printf("  |%s::%s|%n", "  ".repeat(this.radius), "  ".repeat(this.radius));
        for (int radius = 0; radius < this.radius; radius++) {
            System.out.printf("  %s%n", " ".repeat(6 + this.radius));
        }
        System.out.printf("  %s--%s%n", "  ".repeat(this.radius), "  ".repeat(this.radius));
    }
}
