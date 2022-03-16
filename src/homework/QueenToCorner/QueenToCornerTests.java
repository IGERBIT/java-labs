package homework.QueenToCorner;

import org.junit.jupiter.api.Test;
import utils.BaseTest;

class QueenToCornerTests extends BaseTest {

    @Test
    void main() {
        testWithInputAndOutput(s -> {
            s.println("FORWARD 1");
            s.println("LEFT");
            s.println("FORWARD 2");
            s.println("STOP");
        }, s -> s.print(3), () -> Main.main(new String[0]));
    }
}