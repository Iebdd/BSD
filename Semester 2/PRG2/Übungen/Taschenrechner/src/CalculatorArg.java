import java.util.regex.Pattern;

public class CalculatorArg {

    public static void main(String[] args) {
        double[] numbers = new double[2];
        if (args.length != 3) {
            printArgError();
            return;
        }
        try {
            numbers[0] = Double.parseDouble(args[0]);
            numbers[1] = Double.parseDouble(args[2]);
        } catch (NumberFormatException e) {
            printArgError();
            return;
        }
        if (args[1].matches(Pattern.quote("[+-/*]"))) {
            printArgError();
            return;
        }
        calculate(numbers, args[1].charAt(0));


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
                    return;
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
