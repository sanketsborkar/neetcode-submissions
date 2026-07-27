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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            // Traverse right if both nodes are greater
            if (p.val > root.val && q.val > root.val) root = root.right;
            // Traverse left if both nodes are smaller
            else if (p.val < root.val && q.val < root.val) root = root.left;
            // Split point found (one smaller, one larger, or equal to root)
            else return root;
        }
        return null;
    }
}
