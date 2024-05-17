package leetcode.problem1325;

public class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return dfs(root, target);
    }

    private TreeNode dfs(TreeNode node, int target) {
        if (node == null) {
            return null;
        }
        TreeNode leftResult = dfs(node.getLeft(), target);
        TreeNode rightResult = dfs(node.getRight(), target);
        TreeNode result = new TreeNode(node.getVal(), leftResult, rightResult);
        if (result.isLeaf() && result.getVal() == target) {
            return null;
        }
        return result;
    }
}
