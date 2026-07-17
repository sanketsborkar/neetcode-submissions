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
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);
        return maxDiameter;
    }

    private int calculateHeight(TreeNode node) {
        // Base case: an empty node has a height of 0
        if (node == null) {
            return 0;
        }

        // Recursively find the height of left and right subtrees
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        // The diameter passing through the current node is the sum of its subtrees' heights
        int currentDiameter = leftHeight + rightHeight;

        // Update the global maximum diameter if the current path is longer
        maxDiameter = Math.max(maxDiameter, currentDiameter);

        // Return the height of the current subtree to the parent call
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
