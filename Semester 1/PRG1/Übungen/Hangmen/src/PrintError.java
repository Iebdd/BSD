public class PrintError {
    static public void FileNotGivenError() {
        System.out.println("Error: No file name given!");
    }

    static public void FileNotFoundError() {
        System.out.println("Error: File not found!");
    }

    static public void FileUnreadableError() {
        System.out.println("Error: Could not read file!");
    }

    static public void FileEmptyError() {
        System.out.println("Error: Empty file!");
    }

    static public void FileCorruptError() {
        System.out.println("Error: Corrupt file!");
    }

    static public void InvalidInput() {
        System.out.println("Invalid input!");
    }

    static public void InvalidCharacter() {
        System.out.println("Invalid character!");
    }

    static public void DuplicateGuess() {
        System.out.println("Character already guessed!");
    }

}