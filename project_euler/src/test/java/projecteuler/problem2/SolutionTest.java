package projecteuler.problem2;

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
    void shouldBe10forNumbersBelow10() {
        int result = solution.sumOfEvenFibonacciNumbersBelow(10);
        Assertions.assertEquals(10, result);
    }

    @Test
    void shouldBe4613732forNumbersBelow4000000() {
        int result = solution.sumOfEvenFibonacciNumbersBelow(4000000);
        Assertions.assertEquals(4613732, result);
    }
}