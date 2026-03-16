/*
* Programming 1 Exercise 4 - ChoicesAndLoops
* A program which takes a variable number of inputs and performs various calculations based on them
* Author: Andreas Hofer
* Last Change: 13.11.2024
*/

import java.util.Scanner;
public class ChoicesAndLoops {

    static private final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        java.util.Locale.setDefault(java.util.Locale.US);
        scanner.useDelimiter("\n");
        long next_value;
        long iterations;
        iterations = read("Amount: ", false);
        long sum = 0;
        long[] minmax = new long[2];

        for (int inputs = 1; inputs <= iterations; inputs++) {
            next_value = read("#" + inputs + ": ", true);
            sum += next_value;
            if (inputs == 1) {
                minmax[0] = next_value;
                minmax[1] = next_value;
            }
            else {
                getMinMax(minmax, next_value);
            }
        }
        double mean = mean(sum, iterations);
        System.out.printf("Sum = %d%n", sum);
        System.out.printf("Minimum = %d%n", minmax[0]);
        System.out.printf("Maximum = %d%n", minmax[1]);
        System.out.printf("Mean = %.2f%n", mean);
        System.out.printf("Reciprocal of mean = %.2f%n", reciprocal(mean));
        System.out.printf("Additive inverse of mean = %.2f%n", additiveInverse(mean));
        System.out.printf("Absolute value of mean = %.2f%n", abs(mean));
        System.out.printf("Delta of minimum and maximum = %d%n", diffMinMax(minmax));
        System.out.printf("Sum of numbers from minimum to maximum = %d%n", sumMinMax(minmax));
    }

    /**
    * Computes the maximum of two integers.
    * (if the description is longer, just use multiple lines)
    */
    static private double abs(double value) {
        return (value < 0) ? -value : value;
    }

    /**
    * Computes the maximum of two integers.
    * (if the description is longer, just use multiple lines)
    */
    static private double additiveInverse(double value) {
        return 0 - value;
    }
    
    /**
    * Calculates the mean of a
    */
    static private double mean(long sum, long amount) {
        return sum / (double)amount;
    }
    
    /**
    * Calculates the reciprocal of a value
    */
    static private double reciprocal(double value) {
        return 1 / value;
    }
    
    /**
    * Adjusts the min and max values based on an input value and
    * whether is lower and/or higher than the current one.
    */
    static private void getMinMax(long[] minmax, long new_value) {
        if (new_value < minmax[0]) minmax[0] = new_value;
        if (new_value > minmax[1]) minmax[1] = new_value;
    }
    
    /**
    * Calculates the difference between two numbers
    */
    static private long diffMinMax(long[] minmax) {
        if (minmax[0] < 0 && minmax[1] < 0) {
            return -minmax[1] - (-minmax[0]);
        }
        else if (minmax[0] < 0) {
            return -minmax[0] + minmax[1];
        }
        else {
            return minmax[1] - minmax[0];
        }
    }
    
    /**
    * Sums and returns all elements of an array
    */
    static private long sumMinMax(long[] minmax) {
        long sum = 0;
        for (long values = minmax[0]; values <= minmax[1]; values++) {
            sum += values;
        }
        return sum;
    }
    
    /**
    * Reads and returns an integer with a variable input 
    * message and an option to not accept negative integers.
    */
    static private long read(String message, boolean negative) {
        boolean valid = false;
        long input = 0;
        while (!valid) {
            System.out.print(message);
            if (scanner.hasNextLong()) {
                input = scanner.nextLong();
                if (!negative) {
                    if (input > 0) valid = true;
                }
                else valid = true;
            }
            else scanner.next();
        }
        return input;
    }
}
