package lab.SearchVowelsAndConsonantsInSentence;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    private static final String EN_VOWELS = "aeiou";
    private static final String RU_VOWELS = "аоэеиыуёюя";

    private static final int PATTERN_FLAGS = Pattern.MULTILINE | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CHARACTER_CLASS | Pattern.UNICODE_CASE;

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        var line = scanner.nextLine();

        for (String sentence : line.split("\\.")) {
            sentence = sentence.trim();
            if (sentence.length() < 1) {
                continue;
            }

            var vowelsAndConsonants = getCountOfVowelsAndConsonants(sentence);

            System.out.print(sentence);
            System.out.print(". | ");

            int vowels = vowelsAndConsonants.getFirst();
            int consonants = vowelsAndConsonants.getSecond();

            if (vowels > consonants) {
                System.out.print("There are more vowels.");
            } else if (vowels < consonants) {
                System.out.print("There are more consonants.");
            } else {
                System.out.print("There are the same number of consonants and vowels.");
            }

            System.out.println(" (vowels: " + vowels + ", consonants: " + consonants + " )");
        }
    }

    public static Pair<Integer, Integer> getCountOfVowelsAndConsonants(String str) {
        int vowels = 0;
        int consonants = 0;

        final var charPattern = Pattern.compile("[a-zа-яё]", PATTERN_FLAGS);

        var matcher = charPattern.matcher(str);

        while (matcher.find()) {
            var character = str.substring(matcher.start(), matcher.end());
            if (RU_VOWELS.contains(character) || EN_VOWELS.contains(character)) {
                vowels++;
            } else {
                consonants++;
            }
        }

        return new Pair<>(vowels, consonants);
    }

}
