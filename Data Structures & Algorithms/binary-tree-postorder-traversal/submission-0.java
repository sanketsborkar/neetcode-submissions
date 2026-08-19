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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> listNode = new ArrayList<>();
        traverse(root, listNode);
        return listNode;
    }

    public void traverse(TreeNode root, List<Integer> listNode) {
        if (root == null)
            return;

        traverse(root.left, listNode);
        traverse(root.right, listNode);
        listNode.add(root.val);
    }
}