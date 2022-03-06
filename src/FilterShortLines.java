import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilterShortLines {

    private int age;



    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        List<String> lines = new ArrayList<>();



        int tmpAvgLength = 0;

        while (true) {
            var line = scanner.nextLine().trim();

            var length = line.length();

            if (length < 1) {
                break;
            }

            tmpAvgLength += length;

            lines.add(line);
        }

        tmpAvgLength /= lines.size();

        int finalTmpAvgLength = tmpAvgLength;
        for (String line : lines.stream().filter(l -> l.length() < finalTmpAvgLength).toList()) {
            System.out.print(line);
            System.out.println(" | Length: " + line.length());
        }

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
