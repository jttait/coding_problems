package leetcode.problem648;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void setUp() {
        this.solution = new Solution();
    }

    @Test
    void shouldFindRootWhenItIsInDictionary() {
        String word = "helpful";
        List<String> dictionary = List.of("help");
        String result = solution.replaceWords(dictionary, word);
        Assertions.assertEquals("help", result);
    }

    @Test
    void shouldBeUnchangedWhenRootNotInDictionary() {
        String word = "carrot";
        List<String> dictionary = List.of("help");
        String result = solution.replaceWords(dictionary, word);
        Assertions.assertEquals("carrot", result);
    }

    @Test
    void shouldHandleMultipleWords() {
        String word = "helpful carrot";
        List<String> dictionary = List.of("help");
        String result = solution.replaceWords(dictionary, word);
        Assertions.assertEquals("help carrot", result);
    }
}