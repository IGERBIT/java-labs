package lab.FilterShortLines;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        String[] lines = new String[n];

        double avgLength = 0;

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();

            avgLength += line.length();

            lines[i] = (line);
        }

        avgLength /= n;

        for (String line : lines) {
            if (line.length() >= avgLength) {
                continue;
            }
            System.out.print(line);
            System.out.println(" | Length: " + line.length());
        }

    }
}
