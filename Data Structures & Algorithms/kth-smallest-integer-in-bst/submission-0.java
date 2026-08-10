class Solution {
    private int count = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null || count >= k) return;

        // Traverse left
        inorder(node.left, k);

        // Process root
        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        // Traverse right
        inorder(node.right, k);
    }
}
