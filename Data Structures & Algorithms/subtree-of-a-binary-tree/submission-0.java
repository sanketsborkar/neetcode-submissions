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
    // Main function to check if subRoot is a subtree of root
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // If the main tree is empty, it cannot contain any subtree
        if (root == null) {
            return false;
        }
        
        // 1. Check if the current tree matching root is identical to subRoot
        if (isSameTree(root, subRoot)) {
            return true;
        }
        
        // 2. If not, recursively check the left and right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Helper function to check if two trees are exactly identical
    private boolean isSameTree(TreeNode p, TreeNode q) {
        // If both are null, they are identical
        if (p == null && q == null) {
            return true;
        }
        // If only one is null, they are not identical
        if (p == null || q == null) {
            return false;
        }
        // If the values don't match, they are not identical
        if (p.val != q.val) {
            return false;
        }
        
        // Recursively check left and right structural matches
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
