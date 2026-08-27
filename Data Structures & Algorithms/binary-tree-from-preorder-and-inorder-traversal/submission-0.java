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


// Definition for a binary tree node provided by LeetCode


class Solution {
    // Global pointer to track the current root element in preorder array
    private int preorderIndex;
    // Map to cache inorder values and their respective indices
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderIndexMap = new HashMap<>();
        
        // Build the hashmap for O(1) lookups of root positions
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        // Base case: if there are no elements to construct the subtree
        if (left > right) {
            return null;
        }

        // Select the preorderIndex element as the root and increment the pointer
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // Find the boundary index of our root within the inorder array
        int inorderRootIndex = inorderIndexMap.get(rootValue);

        // Recursively build the left and right subtrees
        // Elements from 'left' to 'inorderRootIndex - 1' belong to the left subtree
        root.left = arrayToTree(preorder, left, inorderRootIndex - 1);
        
        // Elements from 'inorderRootIndex + 1' to 'right' belong to the right subtree
        root.right = arrayToTree(preorder, inorderRootIndex + 1, right);

        return root;
    }
}

