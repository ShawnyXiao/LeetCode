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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return dfs(root, sum, 0);
    }
    private boolean dfs(TreeNode root, int sum, int parentSum) {
        if (root.left == null && root.right == null) {
            return sum == parentSum + root.val;
        }
        boolean leftResult = false, rightResult = false;
        if (root.left != null) {
            leftResult = dfs(root.left, sum, parentSum + root.val);
        }
        if (root.right != null) {
            rightResult = dfs(root.right, sum, parentSum + root.val);
        }
        return leftResult || rightResult;
    }
}