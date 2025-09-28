/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maxLen = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        // Start DFS from root:
        // - going left (initial length = 0)
        // - going right (initial length = 0)
        dfs(root.left, 1, true);
        dfs(root.right, 1, false);
        return maxLen;
    }

    private void dfs(TreeNode node, int length, boolean isLeft) {
        if (node == null) return;

        // Update global max
        maxLen = Math.max(maxLen, length);

        // If we just came from left, next is right
        if (isLeft) {
            // Continue ZigZag going right
            dfs(node.right, length + 1, false);
            // Reset length if going left again
            dfs(node.left, 1, true);
        } 
        // If we just came from right, next is left
        else {
            // Continue ZigZag going left
            dfs(node.left, length + 1, true);
            // Reset length if going right again
            dfs(node.right, 1, false);
        }
    }
}
