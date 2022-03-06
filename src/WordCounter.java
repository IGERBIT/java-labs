import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class WordCounter {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        var str = scanner.nextLine();

        Map<String, Integer> wordCount = new HashMap<>();

        var pattern = Pattern.compile("\\w+", Pattern.MULTILINE | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CHARACTER_CLASS | Pattern.UNICODE_CASE);
        var matcher = pattern.matcher(str);

        while (matcher.find()) {
            var word = str.substring(matcher.start(), matcher.end()).toLowerCase();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        wordCount.forEach((word, repeat) -> {
            System.out.println(word + " " + repeat);
        });

    }
}
