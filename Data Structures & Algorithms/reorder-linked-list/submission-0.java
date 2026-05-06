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
        var positionToNode = new HashMap<Integer, ListNode>();
        var size = 0;
        
        while (head != null) {
            positionToNode.put(size, head);
            head = head.next;
            size++;
        }

        var reordered = new ListNode();

        for (int i = 0, j = size - 1; i <= j; i++, j--) {
            reordered.next = positionToNode.get(i);
            reordered.next.next = positionToNode.get(j);
            reordered = reordered.next.next;
        }
        
        reordered.next = positionToNode.get(size / 2);
        reordered.next.next = null;
    }
}
