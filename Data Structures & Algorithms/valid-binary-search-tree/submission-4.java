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
    public boolean isValidBST(TreeNode root) {
        // Use Integer objects instead of int primitives to easily represent infinity with null
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Integer low, Integer high) {
        // An empty tree/node is a valid BST
        if (node == null) {
            return true;
        }

        // The current node's value must sit strictly between the low and high bounds
        if ((low != null && node.val <= low) || (high != null && node.val >= high)) {
            return false;
        }

        // Recursively validate left and right subtrees with updated constraints
        // For the left child, the current node value becomes the new upper bound (high)
        // For the right child, the current node value becomes the new lower bound (low)
        return validate(node.left, low, node.val) && validate(node.right, node.val, high);
    }
}
