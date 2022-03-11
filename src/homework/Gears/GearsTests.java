package homework.Gears;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.BaseTest;

class GearsTests extends BaseTest {

    @DisplayName("Example")
    @Test
    void main() {
        testWithInputAndOutput(s -> {
            s.println("5");
            s.println("5");
            s.println("1 2");
            s.println("2 3");
            s.println("5 3");
            s.println("2 4");
            s.println("4 5");
        }, s -> {
            s.println("clockwise");
            s.println("counter-clockwise");
            s.println("clockwise");
            s.println("clockwise");
            s.println("counter-clockwise");
        }, () -> Main.main(new String[0]));
    }
}