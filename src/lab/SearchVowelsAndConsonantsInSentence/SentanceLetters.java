package lab.SearchVowelsAndConsonantsInSentence;

public final class SentanceLetters {
    private final int vowels;
    private final int consonant;

    public SentanceLetters(int v, int c) {
        vowels = v;
        consonant = c;
    }

    public int getVowels() {
        return vowels;
    }

    public int getConsonant() {
        return consonant;
    }
}
