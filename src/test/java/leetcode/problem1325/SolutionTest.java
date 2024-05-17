package leetcode.problem1325;

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
    void shouldBeNullIfNoNodesRemaining() {
        TreeNode root = new TreeNode(1);
        TreeNode result = solution.removeLeafNodes(root, 1);
        Assertions.assertNull(result);
    }

    @Test
    void shouldBeUnchangedIfOneNodeAndIsNotTarget() {
        TreeNode root = new TreeNode(1);
        TreeNode result = solution.removeLeafNodes(root, 2);
        TreeNode expected = new TreeNode(1);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void shouldRemoveLeafIfTarget() {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        TreeNode result = solution.removeLeafNodes(root, 2);
        TreeNode expected = new TreeNode(1);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void shouldRemoveLeafAndRootIfBothTarget() {
        TreeNode root = new TreeNode(2, new TreeNode(2), null);
        TreeNode result = solution.removeLeafNodes(root, 2);
        Assertions.assertNull(result);
    }
}