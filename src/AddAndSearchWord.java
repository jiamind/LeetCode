/**
 * Created by udingji on 5/13/17.
 */
public class AddAndSearchWord {

    public class WordDictionary {

        private class TrieNode{
            char val;
            boolean isEnd;
            TrieNode[] neighbors;

            public TrieNode(char val){
                this.val = val;
                this.isEnd = false;
                this.neighbors = new TrieNode[26];
            }
        }

        TrieNode root;

        /** Initialize your data structure here. */
        public WordDictionary() {
            this.root = new TrieNode('*');
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            TrieNode p = root;
            char[] array = word.toCharArray();
            for (int i = 0; i < array.length; i++){
                if (p.neighbors[array[i] - 'a'] == null){
                    p.neighbors[array[i] - 'a'] = new TrieNode(array[i]);
                }
                p = p.neighbors[array[i] - 'a'];
            }
            // Set the end of the word(node) here. Since a non-leaf node could be the end of a word
            // e.g. add("a"); add("ab"); "a" node is non-leaf, but still an end
            p.isEnd = true;
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            char[] array = word.toCharArray();
            TrieNode node = root;
            return match(node,array,0);
        }

        private boolean match(TrieNode node,char[] array, int i){
            if (node == null)
                return false;
            if (i >= array.length)
                return node.isEnd;

            if (array[i] == '.'){
                for (int j = 0; j < node.neighbors.length; j++){
                    if (match(node.neighbors[j],array,i+1)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (node.neighbors[array[i] - 'a'] != null){
                    return match(node.neighbors[array[i] - 'a'],array,i+1);
                }else {
                    return false;
                }
            }
        }
    }
}
