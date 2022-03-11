package utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseTest {

    private InputStream stdIn;
    private PrintStream stdOut;

    @BeforeEach
    void setUp() {
        stdIn = System.in;
        stdOut = System.out;
    }

    @AfterEach
    void tearDown() {
        System.setIn(stdIn);
        System.setOut(stdOut);
    }

    protected InputStream textToStream(String str) {
        return new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
    }

    protected String crlf2lf(String str) {
        return str.replaceAll("\\r\\n", "\\n");
    }

    protected String cleanUpString(String str) {
        str = crlf2lf(str).replaceAll(" +", " ").trim();
        if (str.endsWith("\\n")) {
            str = str.substring(0, str.length() - 2);
        }
        return str;
    }

    protected ByteArrayOutputStream createOutputStream(PrintStreamFunction fn) {
        var out = new ByteArrayOutputStream();
        try(PrintStream printStream = new PrintStream(out, true, StandardCharsets.UTF_8)) {
            fn.procces(printStream);
        }

        return out;
    }

    protected ByteArrayInputStream createInputStream(PrintStreamFunction fn) {
        return new ByteArrayInputStream(createOutputStream(fn).toByteArray());
    }

    protected String createString(PrintStreamFunction fn) {
        return createOutputStream(fn).toString();
    }

    protected void testWithInputAndOutput(PrintStreamFunction inStream, PrintStreamFunction outStream, VoidFunction func) {
        final var input = createInputStream(inStream);

        final var output = createString(outStream);

        final var result = createString(ps -> {
            System.setIn(input);
            System.setOut(ps);

            func.call();
        });

        assertEquals(cleanUpString(output), cleanUpString(result));
    }
}