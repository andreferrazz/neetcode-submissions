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
        var previous = (ListNode) null;

        while(reversed != null) {
            var next = reversed.next;
            reversed.next = previous;
            previous = reversed;
            reversed = next;
        }

        reversed = previous;
        slow.next = null;

        while (head != null) {
            var aux = head.next;
            var aux2 = reversed != null ? reversed.next : null;
            head.next = reversed;
            if (reversed != null) {
                head.next.next = aux;
            }
            head = aux;
            reversed = aux2;
        }
    }
}
