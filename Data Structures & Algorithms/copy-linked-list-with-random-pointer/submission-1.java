/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) { 
        var copies = copyNodes(head);
        updatePointers(copies, head);
        return copies.get(head);
    } 
    // time: O(n), space: O(n) 

    private Map<Node, Node> copyNodes(Node head) {
        var map = new HashMap<Node, Node>();
        while(head != null) {
            var newNode = new Node(head.val);
            map.put(head, newNode);
            head = head.next;
        }
        return map;
    }

    private void updatePointers(Map<Node, Node> copies, Node head) {
        while(head != null) {
            var node = copies.get(head);
            node.next = copies.get(head.next);
            node.random = copies.get(head.random);
            head = head.next;
        }
    }
}
