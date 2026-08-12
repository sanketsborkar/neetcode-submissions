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
    public int goodNodes(TreeNode root) {
        // Pass the root and initialize the max value with the root's value
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int maxSoFar) {
        // Base case: if the node is null, it contributes 0 good nodes
        if (node == null) {
            return 0;
        }

        int goodNodeCount = 0;

        // If current node's value is greater than or equal to the max seen so far
        if (node.val >= maxSoFar) {
            goodNodeCount = 1;
            // Update the maximum value for the subsequent path
            maxSoFar = node.val;
        }

        // Recursively count good nodes in the left and right subtrees
        goodNodeCount += dfs(node.left, maxSoFar);
        goodNodeCount += dfs(node.right, maxSoFar);

        return goodNodeCount;
    }
}
