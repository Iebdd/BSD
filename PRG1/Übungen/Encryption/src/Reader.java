import java.util.Scanner;

public class Reader {
    private static final Scanner scanner = new Scanner(System.in);
    /**
     * Reads a string as input
     */
    public static String readString() {
        return scanner.nextLine();
    }

    public static int readInt() {
        int input = 0;
        while (input < 1){
            printMenu();
            try {
                input = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ignored) {}
        }
        return input;
    }
    private static void printMenu() {
        String delimiter = "--------";
        System.out.println(delimiter.repeat(10));
        System.out.println("1 - Encrypt text");
        System.out.println("2 - Decrypt text");
        System.out.println("9 - Quit");
        System.out.println(delimiter.repeat(10));
        System.out.print(">");
    }
}
