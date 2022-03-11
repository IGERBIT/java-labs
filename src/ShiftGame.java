import java.util.Scanner;

public class ShiftGame {
    private static int RightShift(int bitness, int value) {
        int HighBit = (value & 1) << (bitness - 1);
        return (value >>> 1) | HighBit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bitness = scanner.nextInt(); //
        int value = scanner.nextInt();
        int maxValue = value;
        for (int i = 0; i < bitness; i++) {
            value = RightShift(bitness, value);
            if (value > maxValue) {
                maxValue = value;
            }
        }
        System.out.print(maxValue);
    }
}
