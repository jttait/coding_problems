package leetcode.problem121;

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
    void shouldBe1ifBuyAt1andSellAt2() {
        int[] prices = new int[]{1,2};
        int result = solution.maxProfit(prices);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldBe2ifPricesAre1and2and3() {
        int[] prices = new int[]{1,2,3};
        int result = solution.maxProfit(prices);
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe2ifPricesAre1and3and2() {
        int[] prices = new int[]{1,3,2};
        int result = solution.maxProfit(prices);
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe10ifPricesAre1and3and2and11and5() {
        int[] prices = new int[]{1,3,2,11,5};
        int result = solution.maxProfit(prices);
        Assertions.assertEquals(10, result);
    }
}