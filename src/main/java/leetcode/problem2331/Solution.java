package leetcode.problem2331;

public class Solution {
    public boolean evaluateTree(TreeNode root) {
        return dfs(root);
    }

    private boolean dfs(TreeNode node) {
        if (node.getLeft() == null && node.getRight() == null) {
            return node.getVal() == 1;
        }
        boolean leftResult = dfs(node.getLeft());
        boolean rightResult = dfs(node.getRight());
        if (node.getVal() == 2) {
            return leftResult || rightResult;
        }
        return leftResult && rightResult;
    }
}
