/*
 * Programming 1 Exercise 9 - Hangmen>
 * A program which lets you play hangman from an input file
 * Author: Andreas Hofer
 * Last Change: 10.01.2025
 */
import java.util.Scanner;

public class Reader {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Reads a string as input
     */
    public static String readString() {
        return scanner.nextLine();
    }

    /**
     * Reads an integer as input and prints an input message
     */
    public static int readInt(String message) {
        int input = 0;
        while (input < 1){
            System.out.print(message);
            try {
                input = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ignored) {}
        }
        return input;
    }
}
