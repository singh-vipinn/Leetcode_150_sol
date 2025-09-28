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
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1);  // Base case for exact match
        return dfs(root, 0, targetSum, prefixSumCount);
    }

    private int dfs(TreeNode node, long currentSum, int targetSum, Map<Long, Integer> prefixSumCount) {
        if (node == null) return 0;

        int count = 0;
        currentSum += node.val;

        // Check if there exists a previous prefix sum that currentSum - targetSum
        count += prefixSumCount.getOrDefault(currentSum - targetSum, 0);

        // Add current prefix sum to the map
        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);

        // Explore left and right children
        count += dfs(node.left, currentSum, targetSum, prefixSumCount);
        count += dfs(node.right, currentSum, targetSum, prefixSumCount);

        // Backtrack: remove the current prefix sum before returning
        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);

        return count;
    }
}
