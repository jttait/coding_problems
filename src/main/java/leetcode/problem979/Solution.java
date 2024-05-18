package leetcode.problem979;

public class Solution {
    private int result;

    public Solution() {
        this.result = 0;
    }

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return this.result;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.getLeft() == null && node.getRight() == null) {
            return node.getVal() - 1;
        }
        int leftResult = dfs(node.getLeft());
        int rightResult = dfs(node.getRight());
        result += Math.abs(leftResult) + Math.abs(rightResult);
        return node.getVal() - 1 + leftResult + rightResult;
    }
}
