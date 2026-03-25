package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConctStringsTest {

    private String originalFirst;
    private String originalSecond;

    @BeforeEach
    void saveOriginalValues() {
        originalFirst = ConctStrings.first;
        originalSecond = ConctStrings.second;
    }

    @AfterEach
    void restoreOriginalValues() {
        ConctStrings.first = originalFirst;
        ConctStrings.second = originalSecond;
    }

    @Test
    void testConcatenar10VecesBuilder_Normal() {
        ConctStrings.first = "A";
        ConctStrings.second = "B";

        String expected = "";
        for (int i = 0; i < 10; i++) {
            expected += "AB" + "\n";
        }

        String actual = ConctStrings.tenConcatBuilder();

        assertEquals(expected, actual);
    }

    @Test
    void testConcatenar100VecesBuilder_Normal() {
        ConctStrings.first = "x";
        ConctStrings.second = "y";

        String actual = ConctStrings.oneHundredConcatBuilder();

        assertEquals(100 * 3, actual.length());
        assertTrue(actual.startsWith("xy"));
        assertTrue(actual.endsWith("\n"));
    }

    @Test
    void testConcatenar1000VecesBuilder_Normal() {
        ConctStrings.first = "foo";
        ConctStrings.second = "bar";

        String actual = ConctStrings.oneThousandConcatBuilder();

        assertEquals(1000 * (3 + 3 + 1), actual.length());
        assertTrue(actual.contains("foobar"));
    }

    @Test
    void testConcatBuilder_BorderEmptyParts() {
        ConctStrings.first = "";
        ConctStrings.second = "";

        String actual10 = ConctStrings.tenConcatBuilder();
        assertEquals(10, actual10.length());
        assertEquals("\n\n\n\n\n\n\n\n\n\n", actual10);

        String actual100 = ConctStrings.oneHundredConcatBuilder();
        assertEquals(100, actual100.length());
    }

    @Test
    void testConcatBuilder_BorderWhitespaceParts() {
        ConctStrings.first = " ";
        ConctStrings.second = " ";

        String actual = ConctStrings.tenConcatBuilder();
        assertEquals(10 * 3, actual.length());
        assertEquals(" ", actual.substring(0, 1));
    }
}
