/**
 * Created by udingji on 5/23/17.
 */
public class BattleshipsInABoard {


    // Idea: since invalid board won't be given as input, we assume battleship won't cross
    // Count the top left 'X' of a battleship. The top left 'X' shouldn't have adjacent 'X' above or to the left of it
    public int countBattleships(char[][] board) {

        int count = 0;

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == '.')
                    continue;
                if (i > 0 && board[i-1][j] == 'X')
                    continue;
                if (j > 0 && board[i][j-1] == 'X')
                    continue;
                count++;
            }
        }

        return count;
    }
}
