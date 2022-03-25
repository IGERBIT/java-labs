package lab.SearchVowelsAndConsonantsInSentence;

public final class Pair<A, B> {
    private final A first;
    private final B second;

    public Pair(A firstValue, B secondValue) {
        this.first = firstValue;
        this.second = secondValue;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

}
