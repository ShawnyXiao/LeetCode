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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList();
        if (root == null) {
            return result;
        }
        dfs(result, root, "");
        return result;
    }
    private void dfs(List<String> result, TreeNode root, String parentPath) {
        if (root.left == null && root.right == null) {
            result.add(parentPath + root.val);
            return;
        }
        if (root.left != null) {
            dfs(result, root.left, parentPath + root.val + "->");
        }
        if (root.right != null) {
            dfs(result, root.right, parentPath + root.val + "->");
        }
    }
}