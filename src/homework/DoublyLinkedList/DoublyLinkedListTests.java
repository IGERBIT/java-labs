package homework.DoublyLinkedList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.BaseTest;

import java.io.IOException;

class DoublyLinkedListTests extends BaseTest {

    @DisplayName("Example")
    @Test
    void main() throws IOException {

        var in = getClass().getResourceAsStream("1.in.txt");
        var out = getClass().getResourceAsStream("1.out.txt");

        if(out == null) return;

        testWithStream(in,  out, () -> Main.main(new String[0]));
    }
}