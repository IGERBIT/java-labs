package homework.QueenToCorner;

import java.util.Scanner;

public class Main {
    public static int[][] Dirs = {
            //0, 1, 2, 3, 4, 5
            { 1, 2, 3, 0, 4, 5 }, // Forward
            { 0, 4, 2, 5, 3, 1 }, // Right
            { 0, 5, 2, 3, 1, 4 }, // Left
    };

    public static int[] makeMove(int[] pos, int[] dir) {
        return new int[]{ pos[dir[0]], pos[dir[1]], pos[dir[2]], pos[dir[3]], pos[dir[4]], pos[dir[5]] };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean hasStop = false;
        int[] pos = { 0, 1, 2, 3, 4, 5 };

        while (!hasStop) {

            var cmd = scanner.next();

            switch (cmd) {
                //case "F":
                case "FORWARD":
                    var count = scanner.nextInt();
                    for (int i = 0; i < count; i++) {
                        pos = makeMove(pos, Dirs[0]);
                    }
                    break;
                //case "R":
                case "RIGHT":
                    pos = makeMove(pos, Dirs[1]);
                    break;
                //case "L":
                case "LEFT":
                    pos = makeMove(pos, Dirs[2]);
                    break;
                //case "S":
                case "STOP ":
                    hasStop = true;
                    break;
            }

        }

        System.out.print(pos[0]);
    }
}
