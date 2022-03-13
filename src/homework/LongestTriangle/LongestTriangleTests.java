package homework.LongestTriangle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.BaseTest;


class LongestTriangleTests extends BaseTest {
    @DisplayName("Example")
    @Test
    void main() {
        testWithInputAndOutput(s -> {
            s.println(5);
            s.println("0 2");
            s.println("2 0");
            s.println("0 1");
            s.println("1 0");
            s.println("0 0");
        }, s -> {
            s.println("0 2");
            s.println("2 0");
            s.println("0 0");
        }, () -> Main.main(new String[0]));
    }
}