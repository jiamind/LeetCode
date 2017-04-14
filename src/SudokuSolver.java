/**
 * Created by udingji on 2/16/17.
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        if (board == null || board.length < 9) return;
        solve(board);
    }

    private static boolean solve(char[][] board){
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (board[i][j] == '.') {
                    // Check for each individual cell. Try with numbers between 1 to 9
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board,i,j,c)){
                            board[i][j] = c;
                            // If this leads to a successful solution, return true
                            // Otherwise, take back and put '.' into the current cell
                            if (solve(board)){
                                return true;
                            }else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    // If none of 1-9 can be wrote here and solve the sodoku, it failed
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int column, char c){
        for (int i = 0; i < 9; i++){
            if (board[row][i] == c) return false;
            if (board[i][column] == c) return false;
            if (board[3*(row/3)+i/3][3*(column/3)+i%3] == c) return false;
        }
        return true;
    }
}
