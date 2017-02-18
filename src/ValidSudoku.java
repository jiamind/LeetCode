package test;

import java.util.HashSet;

/**
 * Created by udingji on 2/16/17.
 */
public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        for (int r = 0; r < 9; r++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> column = new HashSet<>();
            HashSet<Character> square = new HashSet<>();

            for (int c = 0; c < 9; c++){
                // Check row
                if (board[r][c] != '.' && !row.add(board[r][c]))
                    return false;
                if (board[c][r] != '.' && !column.add(board[c][r]))
                    return false;

                int rowIndex = 3 * (r/3);
                int columnIndex = 3 * (r%3);
                if (board[rowIndex + c/3][columnIndex + c%3] != '.' && !square.add(board[rowIndex + c/3][columnIndex + c%3]))
                    return false;

            }
        }
        return true;
    }

}
