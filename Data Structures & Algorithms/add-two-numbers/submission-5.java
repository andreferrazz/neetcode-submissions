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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var result = new ListNode(0);
        sum(l1, l2, result);
        return result;//.next != null && result.val == 0 ? result.next : result;
    }

    void sum(ListNode l1, ListNode l2, ListNode acc) {
        var partialResult = getValOrZero(l1) + getValOrZero(l2) + acc.val;
        acc.val = partialResult % 10;
        acc.next = new ListNode(partialResult / 10);
        if (getNextOrNull(l1) == null && getNextOrNull(l2) == null) {
            if (acc.next.val == 0) {
                acc.next = null;
            }
            return;
        }
        sum(getNextOrNull(l1), getNextOrNull(l2), acc.next);
    }

    int getValOrZero(ListNode l) {
        return l == null ? 0 : l.val;
    }

    ListNode getNextOrNull(ListNode l) {
        return l == null ? null : l.next;
    }
}
