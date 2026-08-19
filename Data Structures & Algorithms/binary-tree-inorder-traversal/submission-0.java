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
    public List<Integer> inorderTraversal(TreeNode root) {
 
        List<Integer> treeList = new ArrayList<>();
        traversal(root, treeList);

        return treeList;
    }

    private void traversal(TreeNode root, List<Integer> treeList) {
        if (root == null)
            return;

        traversal(root.left, treeList);
        treeList.add(root.val);
        traversal(root.right, treeList);
    }
}