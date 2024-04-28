package leetcode.problem58;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class SolutionTest {
    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void shouldBe5forHelloWorld() {
        String s = "hello world";
        int result = solution.lengthOfLastWord(s);
        Assertions.assertEquals(5, result);
    }

    @Test
    void shouldBe6forMagicBearHatRabbit() {
        String s = "magic bear hat rabbit";
        int result = solution.lengthOfLastWord(s);
        Assertions.assertEquals(6, result);
    }
}