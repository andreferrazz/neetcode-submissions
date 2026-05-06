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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        var original = head;
        var size = 0;
        
        while (head != null) {
            size++;
            head = head.next;
        }

        if (size == 1) {
            return null;
        }

        head = original;
        var target = size - n - 1;

        if (target < 0) {
            return original.next;
        }

        for (int i = 0; i < target; i++) {
            head = head.next;
        }

        head.next = head.next.next;
        return original;
    }
}
