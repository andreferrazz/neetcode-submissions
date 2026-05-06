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
    public boolean hasCycle(ListNode head) {
        return hasCycle(new HashSet<ListNode>(), head);
    }

    boolean hasCycle(Set<ListNode> set, ListNode head) {
        if (head == null) {
            return false;
        }

        if (set.contains(head)) {
            return true;
        }

        set.add(head);
        return hasCycle(set, head.next);
    }
}
