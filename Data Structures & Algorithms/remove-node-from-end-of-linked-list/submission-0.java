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
        var map = new HashMap<Integer, ListNode>();
        var i = 0;
        
        while (head != null) {
            map.put(++i, head);
            head = head.next;
        }

        var node = map.getOrDefault(i - n, null);
        
        if (node == null) {
            return map.getOrDefault(i - n + 2, null);
        } else {
            node.next = node.next.next;
        }

        return original;
    }
}
