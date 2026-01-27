/*
 * Programming 1 Exercise 6 - GeometricShapes
 * A program which takes input and lets you draw rectangles and circles
 * Author: Andreas Hofer
 * Last Change: 27.11.2024
 */

public class Rectangle {
    private static long sequence = 1;
    private final Point point1;
    private final Point point2;
    private int width;
    private int height;

    /**
     * Takes two Point variables and assigns them to this instance's variables
     */
    public Rectangle(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    /**
     * Prints the amount of rectangles printed during this execution
     */
    public static void printSequence() {
        System.out.printf("Rectangle #%d:%n", sequence);
        sequence++;
    }

    /**
     * Returns the x coordinate of either Point variable based on the passed argument
     */
    public int getX(int index) {
        return (index == 1) ? point1.getX() : point2.getX();
    }

    /**
     * Returns the x coordinate of the Point variable based on the passed argument
     */
    public int getY(int index) {
        return (index == 1) ? point1.getY() : point2.getY();
    }

    /**
     * Returns the height of the rectangle
     */
    private int findHeight() {
        int bot = Math.max(getY(1), getY(2));
        int top = Math.min(getY(1), getY(2));
        return Math.abs(bot - top);
    }

    /**
     * Returns the width of the rectangle
     */
    private int findWidth() {
        int left = Math.max(getX(1), getX(2));
        int right = Math.min(getX(1), getX(2));
        return Math.abs(right - left);
    }

    /**
     * Returns the area of the rectangle
     */
    private int findArea() {
        return this.width * this.height;
    }


    /**
     * Prints the parameters of the current rectangle
     */
    public void printRectangle() {
        this.height = findHeight();
        this.width = findWidth();
        System.out.printf("  Width:  %-5d%n", this.width);
        System.out.printf("  Height: %-5d%n", this.height);
        System.out.printf("  Area:   %-5d%n", findArea());
        if (this.width != 0 || this.height != 0) {
            printImage();
        }
    }

    /**
     * Prints an ASCII representation of the rectangle
     */
    private void printImage() {
        System.out.printf("   %s %n", "--".repeat(this.width));
        for (int height = 0; height < this.height; height++) {
            System.out.printf("  |%s|%n", "  ".repeat(this.width));
        }
        System.out.printf("   %s %n", "--".repeat(this.width));
    }
}
