import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilterShortLines {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        List<String> lines = new ArrayList<>();

        int avgLength = 0;

        while (true) {
            var line = scanner.nextLine().trim();

            var length = line.length();

            if (length < 1) {
                break;
            }

            avgLength += length;

            lines.add(line);
        }

        avgLength /= lines.size();

        for (String line : lines) {
            if (line.length() >= avgLength) {
                continue;
            }
            System.out.print(line);
            System.out.println(" | Length: " + line.length());
        }

    }
}
