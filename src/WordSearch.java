/**
 * Created by udingji on 5/14/17.
 */
public class WordSearch {


    public boolean exist(char[][] board, String word) {

        if (board == null || board.length == 0)
            return word == null || word.length() == 0;

        if (word == null || word.length() == 0){
            return true;
        }

        char[] array = word.toCharArray();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board,array,i,j,0, visited)){
                    return true;
                }

            }
        }
        return false;
    }

    private boolean exist(char[][] board, char[] array, int x, int y, int index, boolean[][] visited){

        if (index >= array.length)
            return true;

        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y] || array[index] != board[x][y]){
            return false;
        }

        visited[x][y] = true;

        if (exist(board,array,x-1,y,index+1,visited) ||
                exist(board,array,x+1,y,index+1,visited) ||
                exist(board,array,x,y-1,index+1,visited) ||
                exist(board,array,x,y+1,index+1,visited)){
            return true;
        }

        visited[x][y] = false;

        return false;
    }
}
