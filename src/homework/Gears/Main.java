package homework.Gears;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Gear[] gears = new Gear[n];

        for (int i = 0; i < n; i++) {
            gears[i] = new Gear();
        }

        int m = scanner.nextInt();

        for (int i = 0; i < m; i++) {
            int g1 = scanner.nextInt() - 1;
            int g2 = scanner.nextInt() - 1;

            gears[g1].addNeighbor(gears[g2]);
            gears[g2].addNeighbor(gears[g1]);
        }

        if (dfs(gears[0], true)) {
            for (int i = 0; i < n; i++) {
                if (gears[i].getDirection()) {
                    System.out.println("clockwise");
                } else {
                    System.out.println("counter-clockwise");
                }
            }
        } else {
            System.out.println("block");
        }
    }

    /**
     * @param v   - gear
     * @param dir - new direction for current gear
     * @return true - system doesn't block, false - block
     */
    private static boolean dfs(Gear v, boolean dir) {
        if (v.hasDirection()) {
            return dir == v.getDirection();
        }

        v.setDirection(dir);

        for (var neighbor : v.getNeighbors()) {
            if (!dfs(neighbor, !dir)) {
                return false;
            }
        }

        return true;
    }
}