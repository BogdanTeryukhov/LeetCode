package MediumDifficulty;

import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

class LetterCombinationsOfPhoneNumberTest {

    private LetterCombinationsOfPhoneNumber letterCombinationsOfPhoneNumber;

    @BeforeEach
    void setUp(){
        letterCombinationsOfPhoneNumber = new LetterCombinationsOfPhoneNumber();
    }

    @Test
    void merging() {
        List<String> list1 = List.of("a","b","c");
        List<String> list2 = List.of("d","e","f");

        List<String> result = List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        Assertions.assertArrayEquals(result.toArray(), letterCombinationsOfPhoneNumber.merging(list1, list2).toArray());
    }


    @Test
    void testLetterCombinations_MoreThanOne() {
        List<String> result = List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");

        Assertions.assertArrayEquals(result.toArray(), letterCombinationsOfPhoneNumber.letterCombinations("23").toArray());
    }

    @Test
    void testLetterCombinations_Empty() {
        List<String> result = new ArrayList<>();
        Assertions.assertArrayEquals(result.toArray(), letterCombinationsOfPhoneNumber.letterCombinations("").toArray());
    }

    @Test
    void testLetterCombinations_OnlyOne() {
        List<String> result = List.of("a","b","c");
        Assertions.assertArrayEquals(result.toArray(), letterCombinationsOfPhoneNumber.letterCombinations("2").toArray());
    }
}