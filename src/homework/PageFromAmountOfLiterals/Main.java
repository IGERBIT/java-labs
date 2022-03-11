package homework.PageFromAmountOfLiterals;

import java.util.Scanner;

public class Main {

    private static final int NumberBase = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var result = getPageFromAmountOfLiterals(scanner.nextInt());
        System.out.println(result);
    }

    private static int getNumberOfDigits(int value) {
        int result = 0;
        while (value > 0) {
            value /= NumberBase;
            result++;
        }
        return result;
    }

    private static int getPageFromAmountOfLiterals(int n) {
        int literals = 0;
        int page = 1;
        while (literals < n) {
            literals += getNumberOfDigits(page);
            page++;
        }
        if (literals == n) {
            return page - 1;
        }
        return page - 2;
    }

}
