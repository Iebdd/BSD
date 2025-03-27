import java.util.LinkedList;
import java.util.Queue;

public class Participation {
    private final Queue<Question> history = new LinkedList<>();

    public void addToHistory(Question element) {
        history.add(element);
    }

    private Question getFromHistory() {
        return history.poll();
    }

    public boolean logQuestion(Question question) {
        history.add(question);
        return history.size() <= 7;
    }
}
