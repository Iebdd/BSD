import java.util.Scanner;

import java.util.Random;

public class Calculation {

    private final Scanner scanner = new Scanner(System.in);
    private int count;
    private final int lower;
    private final int upper;


    public Calculation(int lower_bound, int upper_bound) {
        this.lower = lower_bound;
        this.upper = upper_bound;
    }

    private String getNextQuestion() {
        Question question = new Question(this.lower, this.upper);
        question.setInput(readInput(question));
        question.setOutcome(evaluate(question));
    }

    private float readInput(Question question) {
        float input;
        long start_time;
        System.out.printf("Please enter the result of: %d %s %d = ", question.getFirst_value(),
                                            question.getOperator(), question.getSecond_value());
        start_time = System.currentTimeMillis();
        while(true) {
            try{
                input = Float.parseFloat(scanner.nextLine());
                question.setTime(System.currentTimeMillis() - start_time);
                return input;
            } catch(NumberFormatException e) {
                System.out.println("Please enter a valid result!");
                System.out.printf("Result of: %d %s %d = ", question.getFirst_value(), question.getOperator(),
                                                            question.getSecond_value());
            }
        }
    }

    private boolean evaluate(Question question) {
        char operator = question.getOperator();
        float input = question.getInput();
        int first_value = question.getFirst_value();
        int second_value = question.getSecond_value();
        return switch (operator) {
            case '-' -> (first_value - second_value == input);
            case '+' -> (first_value + second_value == input);
            case '/' -> (first_value / (float) second_value == input);
            case '*' -> (first_value * second_value == input);
            default -> false;
        };
    }
}
