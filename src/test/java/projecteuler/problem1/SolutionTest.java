package projecteuler.problem1;

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
    void shouldBe23for10() {
        int result = solution.sumOfMultiples(10);
        Assertions.assertEquals(23, result);
    }

    @Test
    void shouldBe233168for1000() {
        int result = solution.sumOfMultiples(1000);
        Assertions.assertEquals(233168, result);
    }
}