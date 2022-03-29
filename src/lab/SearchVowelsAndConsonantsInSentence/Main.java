package lab.SearchVowelsAndConsonantsInSentence;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final String EN_VOWELS = "aeiou";
    private static final String RU_VOWELS = "аоэеиыуёюя";

    private static final int PATTERN_FLAGS = Pattern.MULTILINE | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CHARACTER_CLASS | Pattern.UNICODE_CASE;

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        for (String sentence : line.split("\\.{3}|\\.|\\?|!")) {
            sentence = sentence.trim();
            if (sentence.length() < 1) {
                continue;
            }

            SentanceLetters vowelsAndConsonants = getCountOfVowelsAndConsonants(sentence);

            System.out.print(sentence);
            System.out.print(". | ");

            int vowels = vowelsAndConsonants.getVowels();
            int consonants = vowelsAndConsonants.getConsonant();

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

    public static SentanceLetters getCountOfVowelsAndConsonants(String str) {
        int vowels = 0;
        int consonants = 0;

        final var charPattern = Pattern.compile("[a-zа-яё]", PATTERN_FLAGS);

        Matcher matcher = charPattern.matcher(str);

        while (matcher.find()) {
            String character = str.substring(matcher.start(), matcher.end());
            if (RU_VOWELS.contains(character) || EN_VOWELS.contains(character)) {
                vowels++;
            } else {
                consonants++;
            }
        }

        return new SentanceLetters(vowels, consonants);
    }

}
