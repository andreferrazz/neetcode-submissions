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

        if (a == null) {
            return b;
        }
        
        if (b == null) {
            return a;
        }

        var result = (ListNode) null;

        if (a.val < b.val) {
            result = new ListNode(a.val);
            a = a.next;
        } else {
            result = new ListNode(b.val);
            b = b.next;
        }

        var tail = result;

        while (a != null || b != null) {
            if (a == null) {
                tail.next = new ListNode(b.val);
                b = b.next;
            } else if (b == null) {
                tail.next = new ListNode(a.val);
                a = a.next;
            } else if (a.val > b.val) {
                tail.next = new ListNode(b.val);
                b = b.next;
            } else {
                tail.next = new ListNode(a.val);
                a = a.next;
            }
            tail = tail.next;
        }

        return result;
    }
}