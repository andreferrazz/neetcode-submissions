class PrefixTree {

    class Node {
        String val;
        Node left;
        Node right;

        Node(String val) { this.val = val; }
    }

    private Node root;

    public PrefixTree() {
         
    }

    public void insert(String word) {
        if (root == null) {
            root = new Node(word);
            return;
        } else {
            insert(word, root);
        }
    }

    private void insert(String word, Node node) {
        var comparison = word.compareTo(node.val);

        if (comparison == 0) {
            return;
        } else if (comparison > 0 && node.right == null) {
            node.right = new Node(word);
        } else if (comparison < 0 && node.left == null) {
            node.left = new Node(word);
        } else if (comparison > 0) {
            insert(word, node.right);
        } else if (comparison < 0) {
            insert(word, node.left);
        }
    }

    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, Node node) {
        if (node == null) {
            return false;
        }

        var comparison = word.compareTo(node.val);

        if (comparison > 0) {
            return search(word, node.right);
        } else if (comparison < 0) {
            return search(word, node.left);
        } else {
            return true;
        }
    }

    public boolean startsWith(String prefix) {
        return startsWith(prefix, root);
    }

    private boolean startsWith(String prefix, Node node) {
        if (node == null) {
            return false;
        }

        if (node.val.startsWith(prefix)) {
            return true;
        } 

        var comparison = prefix.compareTo(node.val);

        if (comparison > 0) {
            return startsWith(prefix, node.right);
        } else {
            return startsWith(prefix, node.left);
        }
    }
}
