/*
* Programming 1 Exercise 3 - Operators
* Uses your matriculation number to do some calculations and prints a decimal using only integers
* Author: Andreas Hofer
* Last Change: 18.10.2024
*/

public class Operators {
    public static void main(String[] args) {
        int matr = 11705024;
        int[] matr_d = new int[8];
        for (int index = 0; index < 8; index++) {
            matr_d[index] = matr % 10;
            matr /= 10;
        }
        int sum = matr_d[7] + matr_d[6] + matr_d[5] + matr_d[4];
        int product = matr_d[3] * matr_d[2] * matr_d[1];
        int lastDigit = matr_d[0];
        int sub = ++product - sum++;
        int mult = sub * sum;
        int div =  mult / ++lastDigit;
        int deci = mult % lastDigit;
        int centi = 0;
        
        if (deci != 0) {
            int intDiv;
            if (mult < 0) intDiv = (-mult * 1000) / lastDigit;
            else intDiv = (mult * 1000) / lastDigit;
            int milli = intDiv % 10;
            intDiv /= 10;
            centi = intDiv % 10;
            intDiv /= 10;
            deci = intDiv % 10;
            if (milli > 4) {
                ++centi;
                if (centi > 9) {
                    centi = 0;
                    ++deci;
                    if (deci > 9) {
                        deci = 0;
                        ++div;
                    }
                }
            }
        }
        System.out.printf("Result = %d%n", mult);
        System.out.printf("Integer division = %d%n", div);
        System.out.printf("Remainder = %d%n", deci);
        System.out.printf("Division = %d.%d%d", div, deci, centi);
    }
}


/*

*/