package leetcode.problem2331;

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
    void shouldBeTrueForLeafNodeThatIsTrue() {
        TreeNode root = new TreeNode(1);
        Assertions.assertTrue(solution.evaluateTree(root));
    }

    @Test
    void shouldBeFalseForLeafNodeThatIsFalse() {
        TreeNode root = new TreeNode(0);
        Assertions.assertFalse(solution.evaluateTree(root));
    }

    @Test
    void shouldBeTrueForAndWithBothChildrenTrue() {
        TreeNode root = new TreeNode(3, new TreeNode(1), new TreeNode(1));
        Assertions.assertTrue(solution.evaluateTree(root));
    }

    @Test
    void shouldBeFalseForAndWithBothChildrenFalse() {
        TreeNode root = new TreeNode(3, new TreeNode(0), new TreeNode(0));
        Assertions.assertFalse(solution.evaluateTree(root));
    }

    @Test
    void shouldBeFalseForAndWithOneChildFalse() {
        TreeNode root = new TreeNode(3, new TreeNode(0), new TreeNode(1));
        Assertions.assertFalse(solution.evaluateTree(root));
    }

    @Test
    void shouldBeTrueForOrWithBothChildrenTrue() {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(1));
        Assertions.assertTrue(solution.evaluateTree(root));
    }

    @Test
    void shouldBeTrueForOrWithOneChildTrue() {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(0));
        Assertions.assertTrue(solution.evaluateTree(root));
    }

    @Test
    void shouldBeFalseForOrWithBothChildrenFalse() {
        TreeNode root = new TreeNode(2, new TreeNode(0), new TreeNode(0));
        Assertions.assertFalse(solution.evaluateTree(root));
    }

    @Test
    void shouldBeTrueForLeetcodeExample() {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3, new TreeNode(0), new TreeNode(1)));
        Assertions.assertTrue(solution.evaluateTree(root));
    }
}