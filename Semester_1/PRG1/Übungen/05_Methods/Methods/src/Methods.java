/*
 * Programming 1 Exercise 5 - Methods
 * A program which takes two numbers and performs various calculations with them.
 * Author: Andreas Hofer
 * Last Change: 13.11.2024
 */
import java.util.Scanner;
public class Methods {

    static private final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        java.util.Locale.setDefault(java.util.Locale.US);
        scanner.useDelimiter("\n");
        long[] values = new long[2];
        values[0] = read();
        values[1] = read();
        long[] primes = primes(values);
        long min = min(values);
        long max = max(values);

        System.out.printf("min(%d,%d) = %d%n", values[0], values[1], min);
        System.out.printf("max(%d,%d) = %d%n", values[0], values[1], max);
        System.out.printf("sum(%d,%d) = %d%n", values[0], values[1], sum(values));
        System.out.printf("sumFromTo(%d,%d) = %d%n", values[0], values[1], sumFromTo(values));
        System.out.printf("delta(%d,%d) = %d%n", values[0], values[1], delta(values));
        System.out.printf("mean(%d,%d) = %.2f%n", values[0], values[1], mean(values));
        System.out.printf("gcd(%d,%d) = %d%n", values[0], values[1], gcd(values));
        System.out.printf("lcm(%d,%d) = %d%n", values[0], values[1], lcm(values));
        System.out.printf("primes(%d,%d) = {", values[0], values[1]);
        if(primes.length != 0) {
            for (int index = 0; index < primes.length; index++) {
                if (primes[index] >= min && primes[index] <= max) {
                    System.out.printf("%d", primes[index]);
                    if (index + 1 != primes.length && primes[index + 1] <= max) {
                        System.out.print(", "); // Only print a preceding comma if the next prime index is not
                    }                           // out of bounds and its value is not higher than the max
                }
            }
        }
        System.out.println("}");
    }

    /**
     * Finds and returns all prime numbers between 2 and the max input value
     */
    static private long[] primes(long[] values) {
        long max = max(values);
        long[] primes = new long[]{2, 3, 5, 7};     //Predefine some primes to make the start easier
        for (int index = 10; index <= max; index++) {
            for (int p_index = 0; p_index < primes.length; p_index++) {
                if (index % primes[p_index] == 0) { //Check if any of the stored prime numbers divide
                    break;                          //cleanly with the number being checked
                } else if (primes[p_index]*primes[p_index] >= index) {
                    primes = append(primes, index); //Stop if the current prime number squared is higher than the
                    break;                          //number being checked and add it to the numbers
                }
            }
        }
    return primes;
    }

    /**
     * Returns the input array with the passed value appended to it
     */
    static private long[] append(long[] array, long value) {
        long[] new_array = new long[array.length + 1];
        for (int index = 0; index < array.length; index++) {
            new_array[index] = array[index];
        }
        new_array[new_array.length - 1] = value;
        return new_array;
    }

    /**
     * Returns the lowest common denominator
     */
    static private long lcm(long[] values) {
        long min = min(values);
        long max = max(values);
        long abs = abs(min * max);
        return abs / gcd(values);
    }

    /**
     * Returns the greatest common divisor of two values
     * by repeatedly dividing one with another
     */
    static private long gcd(long[] values) {
        long min = min(values);
        long max = max(values);
        long remainder;
        do {
            remainder = max % min;
            max = min;
            min = remainder;
        } while (remainder != 0);
        return max;
    }
    /**
     * Returns the smaller of two integers.
     */
    static private long min(long[] values) {
        return (values[0] < values[1]) ? values[0] : values[1];
    }

    /**
     * Returns the absolute value of a given value
     */
    static private long abs(long value) {
        return (value < 0) ? -value : value;
    }

    /**
     * Returns the larger of two integers.
     */
    static private long max(long[] values) {
        return (values[0] > values[1]) ? values[0] : values[1];
    }

    /**
     * Returns the sum of all given array elements.
     */
    static private long sum (long[] values) {
        long sum = 0;
        for (long value : values) {
            sum += value;
        }
        return sum;
    }

    static private long sumFromTo (long[] values) {
        long sum = 0;
        long end = max(values);
        for (long start = min(values); start <= end; start++) {
            sum += start;
        }
        return sum;
    }

    /**
     * Returns the mean of a given array of elements.
     */
    static private double mean(long[] values) {
        return sum(values) / (double)values.length;
    }

    /**
     * Returns the difference between two given numbers
     */
    static private long delta(long[] values) {
        long min = min(values);
        long max = max(values);
        if (min < 0 && max < 0) {
            return -max - (-min);
        }
        else if (min < 0) {
            return -min + max;
        }
        else {
            return max - min;
        }
    }

    /**
     * Reads and returns a positive integer
     */
    static private long read() {
        boolean valid = false;
        long input = 0;
        while (!valid) {
            System.out.print("Enter a positive number: ");
            if (scanner.hasNextLong()) {
                input = scanner.nextLong();
                if (input > 0) valid = true;
            }
            else scanner.next();
        }
        return input;
    }
}

