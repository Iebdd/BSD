import java.util.Random;

public class Question {

    private final int first_value;
    private final int second_value;
    private final char operator;
    private boolean  outcome;
    private float input;
    private long time;

    public Question(int lower_bound, int upper_bound) {
        char[] operations = new char[]{'-', '+', '*', '/'};
        int second_value;
        Random random = new Random();
        this.operator = operations[random.nextInt(5)];
        this.first_value = random.nextInt(lower_bound, upper_bound);
        do {
            second_value = random.nextInt(lower_bound, upper_bound);
        } while (second_value == 0 && this.operator == '/');
        this.second_value = second_value;
    }

    public boolean getOutcome() {
        return outcome;
    }

    public char getOperator() {
        return operator;
    }

    public float getInput() {
        return input;
    }

    public int getSecond_value() {
        return second_value;
    }

    public int getFirst_value() {
        return first_value;
    }

    public long getTime() {
        return time;
    }

    public void setOutcome(boolean outcome) {
        this.outcome = outcome;
    }

    public void setInput(float input) {
        this.input = input;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
