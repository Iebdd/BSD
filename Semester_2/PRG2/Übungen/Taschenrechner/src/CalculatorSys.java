import java.util.Scanner;
import java.util.regex.Pattern;

public class CalculatorSys {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        double[] numbers = new double[2];
        char operator;
        String dError = "Please enter a non-negative valid double!";
        String oError = "Please enter a valid operator - allowed operators: +,-,*,/";
        numbers[0] = readDouble(dError, 1);
        operator = readOperator(oError);
        numbers[1] = readDouble(dError, 2);
        calculate(numbers, operator);
    }


    public static char readOperator(String message) {
        String input;
        while (true) {
            System.out.print("Operator:");
            input = scanner.nextLine().trim();
            System.out.println(input);
            if (input.matches("[+*/-]")) {
                return input.charAt(0);
            } else {
                System.out.println(message);
            }
        }
    }
    /**
     * Reads a double as input and prints an error message if needed
     */
    public static double readDouble(String message, int index) {
        double input = 0;
        while (input < 1){
            System.out.printf("Value %d:", index);
            try {
                input = Double.parseDouble(scanner.nextLine());
                if (input > 1) {
                    return input;
                }

            } catch (NumberFormatException ignored) {}
            System.out.println(message);
        }
        return input;
    }

    private static void printArgError() {
        System.out.println("Error - arguments must be of type NUMBER1 {'*'|'/'|'+'|'-'} NUMBER2 ");
    }

    static private void calculate(double[] numbers, char operator) {
        switch(operator) {
            case '*':
                System.out.printf("%.2f*%.2f = %.2f", numbers[0], numbers[1], numbers[0] * numbers[1]);
                break;
            case '/':
                if (numbers[1] == 0) {
                    System.out.println("Unable to divide by zero");
                }
                System.out.printf("%f/%f = %.2f", numbers[0], numbers[1], numbers[0] / numbers[1]);
                break;
            case '+':
                System.out.printf("%f+%f = %.2f", numbers[0], numbers[1], numbers[0] + numbers[1]);
                break;
            case '-':
                System.out.printf("%f-%f = %.2f", numbers[0], numbers[1], numbers[0] - numbers[1]);
                break;
        }
    }
}
