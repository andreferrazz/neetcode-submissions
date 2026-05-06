class Trie {
    Map<Character, Trie> children = new HashMap<>();
    boolean endOfWord = false;
}

class PrefixTree {
    private Trie root;

    public PrefixTree() {
        root = new Trie();
    }

    public void insert(String word) {
        var trie = root;
        for (char c : word.toCharArray()) {
            trie.children.putIfAbsent(c, new Trie());
            trie = trie.children.get(c);
        }
        trie.endOfWord = true;
    }

    public boolean search(String word) {
        var trie = root;
        for (char c : word.toCharArray()) {
            if (!trie.children.containsKey(c)) return false;
            trie = trie.children.get(c);
        }
        return trie.endOfWord;
    }

    public boolean startsWith(String prefix) {
        var trie = root;
        for (char c : prefix.toCharArray()) {
            if (!trie.children.containsKey(c)) return false;
            trie = trie.children.get(c);
        }
        return true;
    }
}
