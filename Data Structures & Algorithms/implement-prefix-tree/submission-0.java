public class Node {
    Node[] children;
    boolean isWord;

    public Node() {
        children = new Node[26];
        isWord = false;
    }
}

public class PrefixTree {
    Node root;

    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }
            curr = curr.children[index];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        Node node = getLatestNode(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        return getLatestNode(prefix) != null;
    }

    public Node getLatestNode(String prefix) {
        Node curr = root;

        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                return null;
            }
            curr = curr.children[index];
        }
        return curr;
    }
}