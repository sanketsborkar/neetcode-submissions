/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        // Initialize Min-Heap based on node values
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // Push the head of each non-empty list into the heap
        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }
        
        // Dummy node to easily build the resulting list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // Process the nodes in sorted order
        while (!pq.isEmpty()) {
            ListNode lowestNode = pq.poll();
            current.next = lowestNode;
            current = current.next;
            
            // If there is a next node in the extracted list, push it into the heap
            if (lowestNode.next != null) {
                pq.offer(lowestNode.next);
            }
        }
        
        return dummy.next;
    }
}