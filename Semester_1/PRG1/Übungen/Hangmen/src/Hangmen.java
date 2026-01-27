import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hangmen {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        if (args.length < 1) {
            PrintError.FileNotGivenError();
        } else {
            File file = new File(args[0]);
            if (file.exists()) {
                if(file.canRead()) {
                    try (BufferedReader br = new BufferedReader(new FileReader(file));) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            words.add(line);
                        }
                        Collections.shuffle(words);
                    } catch (IOException e) {
                        PrintError.FileUnreadableError();
                    }
                }
                else {
                    PrintError.FileUnreadableError();
                }
            } else {
                PrintError.FileNotFoundError();
            }
        }
        if (!words.isEmpty()) {
            String word_check = String.join("", words);
            if (!word_check.matches("\n*")) {
                if (word_check.matches("[a-zA-Z\n]+")) {
                    words.removeAll(List.of(""));
                    GameLogic game = new GameLogic(words);
                    game.play();
                } else {
                    PrintError.FileCorruptError();
                }
            } else {
                PrintError.FileEmptyError();
            }
        }
    }
}
