class MinStack {

    class Element {
        int val;
        Element previous;
    }

    Element head = null;

    public MinStack() {
    }
    
    public void push(int val) {
        var element = new Element();
        element.val = val;
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
        return this.getMin(this.head, Integer.MAX_VALUE);
    }

    int getMin(Element e, int min) {
        if (e.val < min) {
            min = e.val;
        }

        if (e.previous == null) {
            return min;
        }

        return this.getMin(e.previous, min);
    }
}
