/*
 * Programming 1 Exercise 2
 * A program that outputs variables in a specific way
 * Author: Andreas Hofer
 * Last Change: 16.10.2024
 */

public class Variables {
    public static void main(String[] args) {
        java.util.Locale.setDefault(java.util.Locale.US);
        boolean boolean1 = true;
        char char1 = 70;
        char char2 = 'H';
        byte byte1 = 8;
        short short1 = 16;
        int int1 = 32;
        long long1 = 64;
        float float1 = 32.32f;
        double double1 = 64.64;
        int matr = 11705024;
        System.out.println("boolean: " + boolean1);
        System.out.println("------");
        System.out.printf("%3d%n", byte1);
        System.out.printf("%3d%n", short1);
        System.out.printf("%3d%n", int1);
        System.out.printf("%3d%n", long1);
        System.out.printf("%5.3g%n", float1);
        System.out.printf("%5.3g%n", double1);
        System.out.println("------");
        System.out.printf("%c%c%n", char1, char2);
        System.out.println("Matriculation number: " + matr);
    }
}