package lab.WordCounter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        Map<String, Integer> wordCount = new HashMap<>();

        Pattern pattern = Pattern.compile("\\w+", Pattern.MULTILINE | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CHARACTER_CLASS | Pattern.UNICODE_CASE);
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            var word = str.substring(matcher.start(), matcher.end()).toLowerCase();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        wordCount.forEach((word, repeat) -> System.out.println(word + " " + repeat));
    }
}
