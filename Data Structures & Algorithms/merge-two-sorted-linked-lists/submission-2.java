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
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        var head = new ListNode();
        var tail = head;
        while (a != null || b != null) {
            if (a == null) {
                tail.next = b;
                b = b.next;
            } else if (b == null) {
                tail.next = a;
                a = a.next;
            } else if (a.val > b.val) {
                tail.next = b;
                b = b.next;
            } else {
                tail.next = a;
                a = a.next;
            }
            tail = tail.next;
        }
        return head.next;
    }
}