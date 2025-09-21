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
    public ListNode removeNodes(ListNode head) {
        head = reverse(head);
        
        // Step 2: Traverse and remove nodes smaller than max so far
        int max = head.val;
        ListNode curr = head;
        
        while (curr != null && curr.next != null) {
            if (curr.next.val < max) {
                curr.next = curr.next.next; // delete node
            } else {
                curr = curr.next;
                max = curr.val; // update max
            }
        }
        
        // Step 3: Reverse back
        return reverse(head);
    }
    
    // Helper function to reverse a linked list
    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}