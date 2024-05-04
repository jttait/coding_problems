package leetcode.problem881;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class SolutionTest {
    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    private void test(int[] people, int limit, int expected) {
        Assertions.assertEquals(expected, solution.numRescueBoats(people, limit));
    }

    @Test
    void shouldBe0forNoPeople() {
        test(new int[]{}, 1, 0);
    }

    @Test
    void shouldBe1for1person() {
        test(new int[]{1}, 1, 1);
    }

    @Test
    void shouldBe1for2peopleThatFitInOneBoat() {
        test(new int[]{1,1}, 2, 1);
    }

    @Test
    void shouldBe2for3peopleThatWouldFitInOneBoat() {
        test(new int[]{1,1,1}, 3, 2);
    }

    @Test
    void shouldBe2for4peopleThatWouldFitInTwoBoats() {
        test(new int[]{1,1,1,1}, 3, 2);
    }

}