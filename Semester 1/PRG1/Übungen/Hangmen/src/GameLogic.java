import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;
import java.util.TreeSet;

public class GameLogic {
    private TreeSet<Character> misses = new TreeSet<>();
    private final Stack<String> words = new Stack<>();
    private int wins = 0;


    GameLogic(ArrayList<String> words) {
        this.words.addAll(words);
    }

    public void play() {
        String curr_word;
        HashSet<Character> letters = new HashSet<>();
        ArrayList<Character> word_arr = new ArrayList<>();
        printGreeting();
        while (!words.empty()) {
            letters.clear();
            word_arr.clear();
            curr_word = words.pop();
            word_arr.addAll(Arrays.asList(setLetters(curr_word)));
            letters.addAll(word_arr);
            printWordHeader();
            while (misses.size() > 10 || letters.isEmpty()) {



            }
        }

    }

    private void printStack() {
        while (!words.empty()) {
            System.out.printf("%s ", words.pop());
        }
    }

    private void printLetters(HashSet<Character> letters) {
        for (char letter : letters) {
            System.out.printf("%s ", letter);
        }
        System.out.printf("%n");
    }

    private void printGreeting() {
        System.out.printf("%s%n", "========".repeat(10));
        System.out.printf("HANGMEN (%d Word(s))%n", words.size());
    }

    private void printWordHeader() {
        System.out.printf("%s%n", "--------".repeat(10));
        System.out.printf("Word #%d:%n", wins + 1);
    }

    private void printStatistics(ArrayList<Character> word, HashSet<Character> letters) {
        System.out.print("\nWord:");
        for (Character chara : word) {
            System.out.print(" ");
            if (letters.contains(chara)) {
                System.out.print(chara);
            } else {
                System.out.print("_");
            }
        }
        System.out.printf("Misses (%d/11)%n", this.misses.size());
    }

    private void newGuess(ArrayList<Character> word, HashSet<Character> letters) {
        char input = 0;
        String buffer_in;
        while (input == 0) {
            printStatistics(word, letters);
            buffer_in = Reader.readString();
            if(buffer_in.length() == 1) {
                input = Reader.readString().toLowerCase().charAt(0);
                if (input >= 'a' && input <= 'z') {
                    PrintError.InvalidCharacter();
                }
            } else {
                PrintError.InvalidInput();
            }
        }
    }

    private Character[] setLetters(String input) {
        Character[] letters = new Character[input.length()];
        char[] input_arr = input.toCharArray();
        for (int index = 0; index < input_arr.length; index++) {
            letters[index] = input_arr[index];
        }
        return letters;
    }

    private void printHangman() {
        String[] parts = {
                "",
                "===",
                " |",
                "  ____",
                " |/",
                " |/   |",
                " |    O",
                " |    |",
                " |   /",
                " |   / \\",
                " |   /|",
                " |   /|\\"
        };
        int misses = this.misses.size();
        if (misses == 0) {
            return;
        } else if (misses >= 3) {
            System.out.println(parts[3]);
        }

        if (misses >= 5) {
            System.out.println(parts[5]);
        } else if (misses >= 4) {
            System.out.println(parts[4]);
        } else if (misses >= 2) {
            System.out.println(parts[2]);
        }

        if (misses >= 6) {
            System.out.println(parts[6]);
        } else if (misses >= 2) {
            System.out.println(parts[2]);
        }

        if (misses >= 11) {
            System.out.println(parts[11]);
        } else if (misses >= 10) {
            System.out.println(parts[10]);
        } else if (misses >= 7) {
            System.out.println(parts[7]);
        } else if (misses >= 2) {
            System.out.println(parts[2]);
        }

        if (misses >= 9) {
            System.out.println(parts[9]);
        } else if (misses >= 8) {
            System.out.println(parts[8]);
        } else if (misses >= 2) {
            System.out.println(parts[2]);
        }

        if (misses >= 1) {
            System.out.println(parts[1]);
        }
    }
}

