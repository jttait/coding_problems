package leetcode.problem979;

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
    void shouldBe0forRootWithCoin() {
        TreeNode root = new TreeNode(1, null, null);
        int result = solution.distributeCoins(root);
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldBe2forRootWith2childrenAnd3coins() {
        TreeNode root = new TreeNode(3, new TreeNode(0), new TreeNode(0));
        int result = solution.distributeCoins(root);
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldBe3forRootWithNoCoinsAndLeftNodeWith3() {
        TreeNode root = new TreeNode(0, new TreeNode(3), new TreeNode(0));
        int result = solution.distributeCoins(root);
        Assertions.assertEquals(3, result);
    }

    @Test
    void shouldBe0for3nodesEachWithOneCoin() {
        TreeNode root = new TreeNode(1, new TreeNode(1), new TreeNode(1));
        int result = solution.distributeCoins(root);
        Assertions.assertEquals(0, result);
    }
}