package ua.foxmided.counter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CharactersCounterTest {

    @Test
    void testForNullValue() {
        String actualResult = CharactersCounter.initializeCollections(null);
        String expectedResult = "";
        assertEquals(expectedResult, actualResult);
    }
    @Test
    void testForEmotyString() {
        String actualResult = CharactersCounter.initializeCollections("");
        String expectedResult = "";
        assertEquals(expectedResult, actualResult);
    }
    @Test
    void testForSpace() {
        String actualResult = CharactersCounter.initializeCollections(" ");
        String expectedResult = "";
        assertEquals(expectedResult, actualResult);
    }
    @Test
    void testForFewSpaces() {
        String actualResult = CharactersCounter.initializeCollections("   ");
        String expectedResult = "";
        assertEquals(expectedResult, actualResult);
    }
    @Test
    void testForFewSymbols() {
        String actualResult = CharactersCounter.initializeCollections("!!!@@@423");
        String expectedResult = """
                "!" - 3
                "@" - 3
                "4" - 1
                "2" - 1
                "3" - 1
                                
                Total - 9""";
        assertEquals(expectedResult, actualResult);
    }
    @Test
    void testForFewSymbolsSeparatedBySpace() {
        String actualResult = CharactersCounter.initializeCollections("11!! #@117&");
        String expectedResult = """
                "1" - 4
                "!" - 2
                "Space" - 1
                "#" - 1
                "@" - 1
                "7" - 1
                "&" - 1
                               
                Total - 11""";
        assertEquals(expectedResult, actualResult);
    }
    @Test
    void testForWord() {
        String actualResult = CharactersCounter.initializeCollections("Hello");
        String expectedResult = """
                "H" - 1
                "E" - 1
                "L" - 2
                "O" - 1
                                
                Total - 5""";
        assertEquals(expectedResult, actualResult);
    }
    @Test
    void testForTwoWords() {
        String actualResult = CharactersCounter.initializeCollections("Hello World");
        String expectedResult = """
                "H" - 1
                "E" - 1
                "L" - 3
                "O" - 2
                "Space" - 1
                "W" - 1
                "R" - 1
                "D" - 1
                               
                Total - 11""";
        assertEquals(expectedResult, actualResult);
    }
    @Test
    void testForTwoWordsWithSymbols() {
        String actualResult = CharactersCounter.initializeCollections("Hello World");
        String expectedResult = """
                "H" - 1
                "E" - 1
                "L" - 3
                "O" - 2
                "Space" - 1
                "W" - 1
                "R" - 1
                "D" - 1
                                
                Total - 11""";
        assertEquals(expectedResult, actualResult);
    }
    @Test
    void testForThreeWords() {
        String actualResult = CharactersCounter.initializeCollections("Hello My World");
        String expectedResult = """
                "H" - 1
                "E" - 1
                "L" - 3
                "O" - 2
                "Space" - 2
                "M" - 1
                "Y" - 1
                "W" - 1
                "R" - 1
                "D" - 1
                                
                Total - 14""";
        assertEquals(expectedResult, actualResult);
    }
    @Test
    void testForThreeWordsWithSymbols() {
        String actualResult = CharactersCounter.initializeCollections("Hello!!! My!!! World!!!");
        String expectedResult = """
                "H" - 1
                "E" - 1
                "L" - 3
                "O" - 2
                "!" - 9
                "Space" - 2
                "M" - 1
                "Y" - 1
                "W" - 1
                "R" - 1
                "D" - 1
                               
                Total - 23""";
        assertEquals(expectedResult, actualResult);
    }



}