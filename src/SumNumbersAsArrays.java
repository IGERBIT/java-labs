import java.util.Scanner;

public class SumNumbersAsArrays {

    private static final int NUMBER_BASE = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] a = intToArray(scanner.nextInt());
        int[] b = intToArray(scanner.nextInt());

        int[] c = sum(a,b);

        printArray("a", a);
        printArray("b", b);
        printArray("result", c);


    }

    private static void printArray(String name, int[] c) {
        System.out.print(name);
        System.out.print(": [");
        for (int i = 0; i < c.length; i++) {
            if(i != 0) System.out.print(",");
            System.out.printf(" %d", c[i]);
        }
        System.out.println("]");
    }

    private static int[] intToArray(int a) {
        return Integer.toString(a).chars().map(c -> c - '0').toArray();
    }

    private static int[] sum(int[] a, int[] b) {
        if(a.length == 0) {
            return b.clone();
        }

        if(b.length == 0) {
            return a.clone();
        }

        int maxLength = Math.max(a.length, b.length);

        int[] result = new int[maxLength];
        int overValue = 0;

        for (int i = 1; i <= maxLength; i++) {

            int value = overValue;
            if(a.length >= i) value += a[a.length - i];
            if(b.length >= i) value += b[b.length - i];

            overValue = value / NUMBER_BASE;
            value %= NUMBER_BASE;

            result[result.length - i] = value;
        }

        if(overValue > 0) {
            int[] resultWithOBerValue = new int[result.length + 1];
            System.arraycopy(result,0, resultWithOBerValue, 1, result.length);
            resultWithOBerValue[0] = overValue;
            return resultWithOBerValue;
        }

        return result;
    }
}
