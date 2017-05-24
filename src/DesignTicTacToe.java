/**
 * Created by udingji on 5/23/17.
 */
public class DesignTicTacToe {

    // Design a Tic-tac-toe game that is played between two players on a n x n grid.
    //
    // You may assume the following rules:
    //
    // A move is guaranteed to be valid and is placed on an empty block.
    // Once a winning condition is reached, no more moves is allowed.
    // A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.

    public class TicTacToe {

        // Idea: when play 1 moves, put value 1; when play 2 moves, put value 2
        // Keep track of the sum of values at each row and column, diagonal and anti-diagonal
        // If the absolute value of sum at any row, column, diagonal, or anti-diagonal equals the length of the board
        // The player wins
        int n;
        int rows[];
        int columns[];
        int diagonal;
        int antiDiagonal;

        /**
         * Initialize your data structure here.
         */
        public TicTacToe(int n) {
            this.n = n;
            rows = new int[n];
            columns = new int[n];
            diagonal = 0;
            antiDiagonal = 0;
        }

        /**
         * Player {player} makes a move at ({row}, {col}).
         *
         * @param row    The row of the board.
         * @param col    The column of the board.
         * @param player The player, can be either 1 or 2.
         *
         * @return The current winning condition, can be either:
         * 0: No one wins.
         * 1: Player 1 wins.
         * 2: Player 2 wins.
         */
        public int move(int row, int col, int player) {
            int value = player == 1 ? 1 : -1;

            rows[row] += value;
            columns[col] += value;

            if (row == col)
                diagonal += value;

            if (row + col == n - 1)
                antiDiagonal += value;

            if (Math.abs(rows[row]) == n || Math.abs(columns[col]) == n || Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n) {
                return player;
            }

            return 0;
        }
    }

    /**
     * Your TicTacToe object will be instantiated and called as such:
     * TicTacToe obj = new TicTacToe(n);
     * int param_1 = obj.move(row,col,player);
     */

}
