package problems_by_year.year_2020.month_05.problems_0511.Implement_Trie;


/**
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 */
public class Trie {

    TrieNode root;

    class TrieNode {
        public char data;
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndingChar = false;
        public TrieNode(char data) {
            this.data = data;
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode('/');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode trieNode = root;
        for (Character ch : word.toCharArray()) {
            int pos = ch - 'a';
            if (trieNode.children[pos] == null) {
                trieNode.children[pos] = new TrieNode(ch);
            }
            trieNode = trieNode.children[pos];
        }
        trieNode.isEndingChar = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode trieNode = root;
        for (Character ch : word.toCharArray()) {
            int pos = ch - 'a';
            if (trieNode.children[pos] == null) {
                return false;
            }
            trieNode = trieNode.children[pos];
        }
        return trieNode.isEndingChar;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode trieNode = root;
        for (Character ch : prefix.toCharArray()) {
            int pos = ch - 'a';
            if (trieNode.children[pos] == null) {
                return false;
            }
            trieNode = trieNode.children[pos];
        }
        return true;
    }

}
