
/**
 * Created by udingji on 5/15/17.
 */
public class ImplementTrie {

    // Implement a trie with insert, search, and startsWith methods.

    // Note:
    // You may assume that all inputs are consist of lowercase letters a-z.

    // 93.66%! GJ!
    public class Trie {

        private class TrieNode{
            char val;
            boolean isEnd;
            TrieNode[] neighbors;

            public TrieNode(char val) {
                this.val = val;
                this.isEnd = false;
                this.neighbors = new TrieNode[26];
            }
        }

        TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            this.root = new TrieNode('*');
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode p = root;
            char[] array = word.toCharArray();
            for (int i = 0; i < array.length; i++){
                if (p.neighbors[array[i] - 'a'] == null){
                    TrieNode node = new TrieNode(array[i]);
                    p.neighbors[array[i] - 'a'] = node;
                }
                p = p.neighbors[array[i] - 'a'];
            }
            p.isEnd = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode p = root;
            char[] array = word.toCharArray();
            for (int i = 0; i < array.length; i++){
                p = p.neighbors[array[i] - 'a'];
                if (p == null)
                    return false;
            }
            return p.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode p = root;
            char[] array = prefix.toCharArray();
            for (int i = 0; i < array.length; i++){
                p = p.neighbors[array[i] - 'a'];
                if (p == null)
                    return false;
            }
            return true;
        }
    }
}
