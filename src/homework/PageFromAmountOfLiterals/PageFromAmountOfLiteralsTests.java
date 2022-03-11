package homework.PageFromAmountOfLiterals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.BaseTest;

class PageFromAmountOfLiteralsTests extends BaseTest {

    @DisplayName("Example")
    @Test
    void main() {
        testWithInputAndOutput(
            i -> i.println(13),
            o -> o.println(11),
            () -> Main.main(new String[0])
        );
    }
}