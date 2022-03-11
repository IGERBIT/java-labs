import java.util.Scanner;

public class MinimalCostOfTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] d = new Integer[n + 1];
        d[0] = 0;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < (n - i); j++) {
                var price = scanner.nextInt();
                if (d[i + j + 1] == null || d[i + j + 1] > d[i] + price) {
                    d[i + j + 1] = d[i] + price;
                }
            }
        }

        System.out.println(d[n]);
    }
}
