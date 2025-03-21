/*
 * Programming 1 Exercise 7 - Encryption
 * A program which takes input and encrypts or decrypts it
 * Author: Andreas Hofer
 * Last Change: 10.12.2024
 */

public class Encryption {
    private enum menu {ENCRYPT, DECRYPT, QUIT, DEFAULT}

    ;

    public static void main(String[] args) {
        menu command = menu.DEFAULT;
        while (command != menu.QUIT) {
            command = parseCommand(Reader.readInt(printMenu()));
            if (command != menu.QUIT) {
                crypt(command);
            }
        }
    }

    /**
     * Encrypts or decrypts based on command and rotation
     */
    static private void crypt(menu command) {

        int rotation = Reader.readInt("  Enter rotation: ");
        System.out.print("  Enter text to ");
        if (command == menu.DECRYPT) {
            rotation = -rotation;
            System.out.print("decrypt: ");
        } else {
            System.out.print("encrypt: ");
        }
        byte[] charArray = Reader.readString().getBytes();
        for (int index = 0; index < charArray.length; index++) {
            charArray[index] = shift(charArray[index], rotation);
        }
        String output = new String(charArray);
        if (command == menu.DECRYPT) {
            System.out.printf("  Decrypted text: %s%n", output);
        } else {
            System.out.printf("  Encrypted text: %s%n", output);
        }
    }

    /**
     * Performs the actual shift of characters
     */
    static private byte shift(byte chara, int rot) {
        byte[][] types = {
                {26, 90, 65},
                {26, 122, 97},
                {10, 57, 48}
        };
        byte type;
        if (chara > 64 && chara < 91) {
            type = 0;
        } else if (chara > 96 && chara < 123) {
            type = 1;
        } else if (chara > 47 && chara < 58) {
            type = 2;
        } else {
            return chara;
        }
        if (abs(rot) > types[type][0]) {
            rot = (byte) (rot % types[type][0]);
        }
        if (rot < 0) {
            if ((chara + rot) < types[type][2]) {
                return (byte) (types[type][1] - (types[type][2] - (chara + rot + 1)));
            } else {
                return (byte) (chara + rot);
            }
        } else {
            if ((chara + rot) > types[type][1]) {
                return (byte) (((chara + rot - 1) - types[type][1]) + types[type][2]);
            } else {
                return (byte) (chara + rot);
            }
        }
    }

    /**
     * Calculates the absolute value of a number
     */
    static private int abs(int number) {
        return (number > 0) ? number : -number;
    }

    /**
     * Parses the input command
     */
    static private menu parseCommand(int command) {
        switch (command) {
            case 1 -> {
                return menu.ENCRYPT;
            }
            case 2 -> {
                return menu.DECRYPT;
            }
            case 9 -> {
                return menu.QUIT;
            }
            default -> {
                return menu.DEFAULT;
            }
        }
    }

    /**
     * Returns a string printing the menu
     */
    static private String printMenu() {
        String delimiter = "--------";
        return String.format("%s%n%s%n%s%n%s%n%s%n%s",
                delimiter.repeat(10),
                "1 - Encrypt text",
                "2 - Decrypt text",
                "9 - Quit",
                delimiter.repeat(10),
                "> ");
    }
}

