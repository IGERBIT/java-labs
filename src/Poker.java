import java.util.*;

public class Poker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var result = getNameOfCardLayout(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        System.out.println(result);
    }

    private static <T> int CountOf(Collection<T> arr, T findValue) {
        int count = 0;
        for (T t : arr) {
            if (t == findValue) {
                count++;
            }
        }
        return count;
    }

    private static String getNameOfCardLayout(int x1, int x2, int x3, int x4, int x5) {
        var arr = List.of(x1, x2, x3, x4, x5);
        Set<Integer> set = new HashSet<>(arr);
        if (set.size() == 1) {
            return "poker";
        }
        if (set.size() == 2) {
            var countOfX1 = CountOf(arr, x1);
            return countOfX1 == 1 || countOfX1 == 4 ? "four of a kind" : "full house";
        }
        if (set.size() == 3) {
            var countOfX1 = CountOf(arr, x1);
            var countOfX2 = CountOf(arr, x2);
            if (countOfX1 == 2 || countOfX2 == 2) {
                return "two pairs";
            }
            return "three of a kind";
        }
        if (set.size() == 4) {
            return "one pair";
        }
        return "all different";
    }
}
