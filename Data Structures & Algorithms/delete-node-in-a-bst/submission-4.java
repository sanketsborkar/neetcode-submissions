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
    public TreeNode deleteNode(TreeNode root, int key) {
        // Base Case: Key not found or tree is empty
        if (root == null) {
            return null;
        }

        // 1. Search for the node in the left or right subtrees
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Found the node to delete! Handle the 3 cases:

            // Case 1 & 2: Node has 0 or 1 child
            if (root.left == null) {
                return root.right; 
            } else if (root.right == null) {
                return root.left;
            }

            // Case 3: Node has 2 children
            // Find the minimum node in the right subtree (In-Order Successor)
            TreeNode minNode = findMin(root.right);
            // Replace current node's value with successor's value
            root.val = minNode.val;
            // Delete the duplicated successor node from the right subtree
            root.right = deleteNode(root.right, minNode.val);
        }
        return root;
    }

    // Helper method to find the smallest node in a subtree
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}