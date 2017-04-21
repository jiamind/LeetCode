/**
 * Created by udingji on 4/20/17.
 */
public class SurroundedRegions {

    // Idea: scan the four boarders of the board. If we find a 'O', recursively mark its neighbors as '1'
    // Then change all remaining 'O' to 'X'
    // Finally, change all '1' to 'O'
    public static void solve(char[][] board) {

        // If the board is null or the board has 0 row, return the method
        if (board == null || board.length == 0)
            return;

        // Get the total number of rows and columns of the board
        int row = board.length;
        int column = board[0].length;

        // Scan the left and right boarder
        for (int i = 0; i < row; i++){
            if (board[i][0] == 'O'){
                fillNeighbor(board,i,0,row,column);
            }
            if (board[i][column-1] == 'O'){
                fillNeighbor(board,i,column-1,row,column);
            }
        }
        // Scan the top and bottom boarder
        for (int j = 0; j < column; j++){
            if (board[0][j] == 'O'){
                fillNeighbor(board,0,j,row,column);
            }
            if (board[row-1][j] == 'O'){
                fillNeighbor(board,row-1,j,row,column);
            }
        }

        // Change all remaining 'O' to 'X'
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }

        // Change all '1' back to 'O'
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == '1')
                    board[i][j] = 'O';
            }
        }
    }

    private static void fillNeighbor(char[][] board, int r, int c, int row, int column){
        board[r][c] = '1';
        int i = r + 1;
        // Scan cells below the current cell
        while (i < row && board[i][c] == 'O'){
            fillNeighbor(board,i,c,row,column);
            i++;
        }
        i = r - 1;
        // Scan cells above the current cell
        while (i >= 1 && board[i][c] == 'O'){
            fillNeighbor(board,i,c,row,column);
            i--;
        }
        i = c + 1;
        // Scan cells to the right of the current cell
        while (i < column && board[r][i] == 'O'){
            fillNeighbor(board,r,i,row,column);
            i++;
        }
        i = c - 1;
        // Scan cells to the left of the current cell
        while (i >= 1 && board[r][i] == 'O'){
            fillNeighbor(board,r,i,row,column);
            i--;
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[5][];
        board[0] = new String("OXXOX").toCharArray();
        board[1] = new String("XOOXO").toCharArray();
        board[2] = new String("XOXOX").toCharArray();
        board[3] = new String("OXOOO").toCharArray();
        board[4] = new String("XXOXO").toCharArray();

        solve(board);

        System.out.println("done");
    }
}
