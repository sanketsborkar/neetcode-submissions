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
    public List<List<Integer>> levelOrder(TreeNode root) {
         List<List<Integer>> result = new ArrayList<>();
        
        // Base case: if the tree is empty, return an empty list
        if (root == null) {
            return result;
        }
        
        // Initialize a queue to keep track of nodes to visit
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        // Process the tree level by level
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            
            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                
                // Enqueue left child if it exists
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                // Enqueue right child if it exists
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            
            // Add the populated level to the final result list
            result.add(currentLevel);
        }
        
        return result;
    }
}
