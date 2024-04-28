package leetcode.problem13;

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
    void shouldBe1forI() {
        int result = solution.romanToInt("I");
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe5forV() {
        int result = solution.romanToInt("V");
        Assertions.assertEquals(5, result);
    }

    @Test
    void shouldBe10forX() {
        int result = solution.romanToInt("X");
        Assertions.assertEquals(10, result);
    }

    @Test
    void shouldBe50forL() {
        int result = solution.romanToInt("L");
        Assertions.assertEquals(50, result);
    }

    @Test
    void shouldBe100forC() {
        int result = solution.romanToInt("C");
        Assertions.assertEquals(100, result);
    }

    @Test
    void shouldBe500forD() {
        int result = solution.romanToInt("D");
        Assertions.assertEquals(500, result);
    }

    @Test
    void shouldBe1000forM() {
        int result = solution.romanToInt("M");
        Assertions.assertEquals(1000, result);
    }

    @Test
    void shouldBe2forII() {
        int result = solution.romanToInt("II");
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe4forIV() {
        int result = solution.romanToInt("IV");
        Assertions.assertEquals(4, result);
    }

    @Test
    void shouldBe9forIX() {
        int result = solution.romanToInt("IX");
        Assertions.assertEquals(9, result);
    }

    @Test
    void shouldBe40forXL() {
        int result = solution.romanToInt("XL");
        Assertions.assertEquals(40, result);
    }

    @Test
    void shouldBe90forXC() {
        int result = solution.romanToInt("XC");
        Assertions.assertEquals(90, result);
    }

    @Test
    void shouldBe400forCD() {
        int result = solution.romanToInt("CD");
        Assertions.assertEquals(400, result);
    }

    @Test
    void shouldBe900forCM() {
        int result = solution.romanToInt("CM");
        Assertions.assertEquals(900, result);
    }

    @Test
    void shouldBe2024forMMXXIIII() {
        int result = solution.romanToInt("MMXXIIII");
        Assertions.assertEquals(2024, result);
    }
}