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
        if (head.next == null) {
            return null;
        }

        var node = head;
        var size = 0;
        
        while (node != null) {
            size++;
            node = node.next;
        }

        node = new ListNode(0, head);

        for (int i = 0; i < size - n; i++) {
            node = node.next;
        }

        node.next = node.next.next;
        return size - n == 0 ? node.next : head;
    }
}
