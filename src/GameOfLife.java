/**
 * Created by jmding on 3/7/17.
 */
public class GameOfLife {

    public static void gameOfLife(int[][] board) {

        // 0: currently dead, next stage is still dead
        // 1: currently live, next stage is still live
        // 2: currently dead, next stage is live
        // 3: currently live, next stage is dead

        // Get number of rows and columns in the board
        int row = board.length;
        int column = board[0].length;

        // Iterate through each cell in the board
        for (int r = 0; r < row; r++){
            for (int c = 0; c < column; c++){
                // Check number of neighbors that are live
                int num = numOfNeighbors(board,r,c,row,column);
                // If the cell is currently live
                if (board[r][c] == 1){
                    // If the number of neighbors that are live is less than 2 or greater than 3, mark it as dead for the next state
                    if (num < 2 || num > 3) board[r][c] = 3;
                }else {
                    // If the cell is currently dead
                    // If the number of enighbors that are live is equal to 3, mark it as live for the next state
                    if (num == 3) board[r][c] = 2;
                }
            }
        }
        // Iterate through the board, change any 2 to 1, 3 to 0
        for (int r = 0; r < row; r++){
            for (int c = 0; c < column; c++) {
                if (board[r][c] == 2) board[r][c] = 1;
                else if (board[r][c] == 3) board[r][c] = 0;
            }
        }

    }

    private static int numOfNeighbors(int[][] board, int r, int c, int row, int column){

        int num = 0;
        for (int i = Math.max(r-1,0); i <= Math.min(row-1,r+1);i++){
            for (int j = Math.max(c-1,0); j <= Math.min(column-1,c+1);j++){
                if (board[i][j] == 1 || board[i][j] == 3) num++;
            }
        }
        if (board[r][c] == 1 || board[r][c] == 3) num--;
        return num;
    }
}
