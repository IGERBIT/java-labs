package homework.MinimalConstOfTrip;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.BaseTest;

class MinimalConstOfTripTests extends BaseTest {

    @DisplayName("Example")
    @Test
    void main() {
        testWithInputAndOutput(s -> {
            s.println("3");
            s.println("7");
            s.println("10");
            s.println("20");
            s.println("4");
            s.println("8");
            s.println("2");
        }, s -> s.println(12), () -> Main.main(new String[0]));
    }

    @DisplayName("Example 2 ")
    @Test
    void main2() {
        testWithInputAndOutput(s -> {
            s.println("3");
            s.println("1");
            s.println("2");
            s.println("4");
            s.println("2");
            s.println("5");
            s.println("5");
        }, s -> s.println(4), () -> Main.main(new String[0]));
    }
}