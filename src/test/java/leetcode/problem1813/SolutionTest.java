package leetcode.problem1813;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {
    private Solution solution;

    @BeforeEach
    void setUp() {
        this.solution = new Solution();
    }

    @Test
    void shouldBeTrueForIdenticalOneWordSentences() {
        String sentence1 = "hello";
        String sentence2 = "hello";
        Assertions.assertTrue(solution.areSentencesSimilar(sentence1, sentence2));
    }

    @Test
    void shouldBeTrueForIdenticalTwoWordSentences() {
        String sentence1 = "hello world";
        String sentence2 = "hello world";
        Assertions.assertTrue(solution.areSentencesSimilar(sentence1, sentence2));
    }

    @Test
    void shouldBeTrueWhenWordsInsertedInMiddle() {
        String sentence1 = "My name is Haley";
        String sentence2 = "My Haley";
        Assertions.assertTrue(solution.areSentencesSimilar(sentence1, sentence2));
    }

    @Test
    void shouldBeFalseWhenWordsMustBeInsertedInMiddleAndAtEnd() {
        String sentence1 = "My name is Haley Smith";
        String sentence2 = "My Haley";
        Assertions.assertFalse(solution.areSentencesSimilar(sentence1, sentence2));
    }

    @Test
    void shouldBeFalseForNonIdenticalOneWordSentences() {
        String sentence1 = "carrot";
        String sentence2 = "alpha";
        Assertions.assertFalse(solution.areSentencesSimilar(sentence1, sentence2));
    }

    @Test
    void shouldBeFalseForDifferentSentences() {
        String sentence1 = "carrot bat shelf";
        String sentence2 = "alpha";
        Assertions.assertFalse(solution.areSentencesSimilar(sentence1, sentence2));
    }

    @Test
    void shouldBeTrueForEatingRightNow() {
        String sentence1 = "eating";
        String sentence2 = "eating right now";
        Assertions.assertTrue(solution.areSentencesSimilar(sentence1, sentence2));
    }
}