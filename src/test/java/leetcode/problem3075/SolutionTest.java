package leetcode.problem3075;

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
    void shouldBe1for1() {
        int[] happiness = new int[]{1};
        int k = 1;
        long result = solution.maximumHappinessSum(happiness, k);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe2for2() {
        int[] happiness = new int[]{2};
        int k = 1;
        long result = solution.maximumHappinessSum(happiness, k);
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe1for1and1() {
        int[] happiness = new int[]{1,1};
        int k = 2;
        long result = solution.maximumHappinessSum(happiness, k);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe3for2and2() {
        int[] happiness = new int[]{2,2};
        int k = 2;
        long result = solution.maximumHappinessSum(happiness, k);
        Assertions.assertEquals(3, result);
    }
}