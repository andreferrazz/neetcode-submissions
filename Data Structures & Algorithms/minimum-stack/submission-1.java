class MinStack {

    class Element {
        int val;
        int min;
        Element previous;
    }

    Element head = null;

    public MinStack() {
    }
    
    public void push(int val) {
        var element = new Element();
        element.val = val;
        element.min = this.head == null ? val : Integer.min(val, this.head.min);
        element.previous = this.head;
        this.head = element;
    }
    
    public void pop() {
        this.head = this.head.previous;
    }
    
    public int top() {
        return this.head.val;
    }
    
    public int getMin() {
        return this.head.min;
    }
}
