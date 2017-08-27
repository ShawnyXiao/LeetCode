/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        return Math.abs(leftDepth - rightDepth) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = dfs(node.left);
        int rightDepth = dfs(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}