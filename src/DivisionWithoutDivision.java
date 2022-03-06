import java.util.Scanner;

public class DivisionWithoutDivision {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(divide(a,b));
    }

    private static int divide(int divisible, int divider) {
        if(divider == 0) throw new ArithmeticException("divider must be a non-zero value");
        if(divisible == 0) return 0;

        boolean isNegative = false;

        if(divisible < 0) {
            isNegative = true;
            divisible = -divisible;
        }

        if(divider < 0) {
            isNegative = !isNegative;
            divider = -divider;
        }

        if(divider == divisible) {
            return isNegative ? -1 : 1;
        }

        int result = 0;

        int left = 0;
        int rigth = 0xFFFFFFFF;

        while (rigth - left > 1) {

        }



        return isNegative ? -result : result;
    }

}
