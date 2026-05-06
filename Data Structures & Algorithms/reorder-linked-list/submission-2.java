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
    public void reorderList(ListNode head) {
        var slow = head;
        var fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        var reversed = slow.next;
        slow.next = null;
        var previous = (ListNode) null;

        while(reversed != null) {
            var next = reversed.next;
            reversed.next = previous;
            previous = reversed;
            reversed = next;
        }

        reversed = previous;

        while (reversed != null) {
            var aux1 = head.next;
            var aux2 = reversed.next;
            head.next = reversed;
            reversed.next = aux1;
            head = aux1;
            reversed = aux2;
        }
    }
}
