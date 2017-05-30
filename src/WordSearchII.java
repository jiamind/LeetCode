import java.util.ArrayList;
import java.util.List;

/**
 * Created by jmding on 5/25/17.
 */
public class WordSearchII {

    // Given a 2D board and a list of words from the dictionary, find all words in the board.

    // Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

    // For example,
    // Given words = ["oath","pea","eat","rain"] and board =

    // [
    //    ['o','a','a','n'],
    //    ['e','t','a','e'],
    //    ['i','h','k','r'],
    //    ['i','f','l','v']
    // ]
    // Return ["eat","oath"].

    // Idea: use Tire data structure to store all words in the array
    // Iterate through each cell on the board and perform dfs. If we find a word matches the trie, add it to the result list
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0)
            return result;

        TrieNode root = buildTrie(words);

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                dfs(board,i,j,root,result);
            }
        }

        return result;
    }

    // Use dfs to search from the starting point to all four directions. Mark all visited cell as '#' for each depth search
    // If we reach a node with contains the word, we found the word. Remove that word from the node to aviod duplicate results
    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> result){
        char ch = board[r][c];
        int i = ch - 'a';

        if (ch == '#' || node.next[i] == null)
            return;

        if (node.next[i].word != null) {
            result.add(node.next[i].word);
            node.next[i].word = null;
        }

        board[r][c] = '#';

        if (r > 0)
            dfs(board, r - 1, c, node.next[i], result);
        if (c > 0)
            dfs(board, r, c - 1, node.next[i], result);
        if (r < board.length - 1)
            dfs(board, r + 1, c, node.next[i], result);
        if (c < board[0].length - 1)
            dfs(board, r, c + 1, node.next[i], result);

        board[r][c] = ch;
    }

    // Build a tire data structure using the word list
    // The end node of a word will have the word store on that node
    private TrieNode buildTrie(String[] words){

        TrieNode root = new TrieNode();
        for (String word : words){
            TrieNode p = root;
            char[] array = word.toCharArray();
            for (char c : array){
                int i = c - 'a';
                if (p.next[i] == null)
                    p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = word;
        }
        return root;
    }


    private class TrieNode{
        TrieNode[] next;
        String word;

        public TrieNode(){
            next = new TrieNode[26];
        }
    }
}
