/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = length(headA), lenB = length(headB);

        while(lenA > lenB) {headA = headA.next; lenA--;}
        while(lenB > lenA) {headB = headB.next; lenB--;}

        while(headA != null && headB != null) {
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;       
    }
    private int length(ListNode node) {
        int count = 0;
        while(node !=null) {
            count++;
            node = node.next;
            return count;
        }
    
}