class WordDictionary {
    
    // Internal node structure for the Trie
    private class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            // 26 lowercase English letters ('a' through 'z')
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    /** Initializes your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }
    
    /** Returns true if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word, 0, root);
    }

    // Helper method for DFS backtracking search
    private boolean match(String word, int index, TrieNode node) {
        // If we reached the end of the word, check if it marks a complete word path
        if (index == word.length()) {
            return node.isEndOfWord;
        }

        char ch = word.charAt(index);

        if (ch == '.') {
            // Wildcard: Check all possible valid child nodes recursively
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    if (match(word, index + 1, node.children[i])) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            // Regular character: Match exactly
            int childIndex = ch - 'a';
            if (node.children[childIndex] == null) {
                return false;
            }
            return match(word, index + 1, node.children[childIndex]);
        }
    }
}
