/*
 * Programming 1 Exercise 6 - GeometricShapes
 * A program which takes input and lets you draw rectangles and circles
 * Author: Andreas Hofer
 * Last Change: 27.11.2024
 */

public class Point {
    private final int x;
    private final int y;

    /**
     * Takes an integer array and assigns it to the instance variables x and y
     */
    public Point(int[] coords) {
        this.x = coords[0];
        this.y = coords[1];
    }

    /**
     * Returns the x of this Point instance
     */
    int getX(){
        return this.x;
    }

    /**
     * Returns the y of this Point instance
     */
    int getY() {
        return this.y;
    }
}
