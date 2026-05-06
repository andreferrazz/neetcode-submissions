class MinStack {

    private final class Node {
        Integer val;
        Node previous;
    }

    private Node top;
    private Node min;

    public MinStack() {
        top = new Node();
        min = new Node();
    }
    
    public void push(int val) {
        var newNode = new Node();
        newNode.val = val;
        newNode.previous = top;
        top = newNode;

        if (min.val == null || val <= min.val) {
            var newMin = new Node();
            newMin.val = val;
            newMin.previous = min; 
            min = newMin;
        }
    }
    
    public void pop() {
        if (top.val.equals(min.val)) {
            min = min.previous;
        }
        top = top.previous;
    }
    
    public int top() {
        return top.val;
    }
    
    public int getMin() {
        return min.val;
    }
}
