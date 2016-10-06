package easy;

import java.util.Scanner;

/**
 * A fraction exists of a numerator (top part) and a denominator (bottom part) as you probably all know.
 * Simplifying (or reducing) fractions means to make the fraction as simple as possible.
 * Meaning that the denominator is a close to 1 as possible.
 * This can be done by dividing the numerator and denominator by their greatest common divisor.
 */
public class Fractions {
    static int numerator;
    static int denominator;

    public static void main(String[] args) {
        Fractions fractions = new Fractions();
        fractions.setNumbers(new Scanner(System.in));
        int nwd = fractions.nwdFinder(numerator, denominator);
        System.out.println("nwd: " + nwd);
        System.out.println("Simplified fraction: " + (numerator / nwd) + "/" + (denominator / nwd));
    }

    private void setNumbers(Scanner scanner) {
        System.out.println("set numbers in order nominator (enter), denominator (enter)");
        this.numerator = scanner.nextInt();
        this.denominator = scanner.nextInt();
    }

    private int nwdFinder(int numerator, int denominator) {
        return (numerator == denominator) ? denominator : this.nwdFinder(Math.abs(numerator - denominator), smallerNumber(numerator, denominator));
    }

    private int smallerNumber(int numerator, int denominator) {
        return numerator < denominator ? numerator : denominator;
    }
}
