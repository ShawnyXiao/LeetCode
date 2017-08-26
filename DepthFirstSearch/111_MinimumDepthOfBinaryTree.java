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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        PriorityQueue<Integer> depths = new PriorityQueue<>();
        dfs(root, depths, 0);
        return depths.peek();
    }
    private void dfs(TreeNode root, PriorityQueue<Integer> depths, int parentDepth) {
        if (root.left == null && root.right == null) {
            depths.add(parentDepth + 1);
            return;
        }
        if (root.left != null) {
            dfs(root.left, depths, parentDepth + 1);
        }
        if (root.right != null) {
            dfs(root.right, depths, parentDepth + 1);
        }
    }
}