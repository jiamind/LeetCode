/**
 * Created by udingji on 2/22/17.
 */
public class NQuensII {

    public static boolean[] columnSet;
    public static boolean[] diagonalToRight;
    public static boolean[] diagonalToLeft;

    public static int totalNQueens(int n) {
        // A boolean array indicates whether each column has been taken
        columnSet = new boolean[n * 2];
        // A boolean array indicates whether each diagonal (right to left) has been taken
        diagonalToLeft = new boolean[n * 2];
        // A boolean array indicates whether each diagonal (left to right) has been taken
        diagonalToRight = new boolean[n * 2];
        // Starting from the first row
        return backtrack(0,n,0);
    }


    public static int backtrack(int r, int n, int count){
        // Iterate through each column on this row
        for (int c = 0; c < n; c++){

            // If this column already has a 'Q', skip
            if (columnSet[c]) continue;

            // All cells on the same right to left diagonal should have the same r - c value
            // If this right to left diagonal already has a 'Q', skip
            int diagonalToLeftNum = r - c;
            if (diagonalToLeft[diagonalToLeftNum]) continue;

            // All cells on the same left to right diagonal should have the same r + c value
            // If this left to right diagonal already has a 'Q', skip
            int diagonalToRightNum = r + c;
            if (diagonalToRight[diagonalToRightNum]) continue;

            // If r reaches the end row, we are done. Increment the counter
            if (r == n - 1){
                count ++;
            }else {
                // Set this column, diagonals are taken
                columnSet[c] = true;
                diagonalToLeft[diagonalToLeftNum] = true;
                diagonalToRight[diagonalToRightNum] = true;

                // Call backtrack for the next row
                count = backtrack(r+1,n,count);

                // Free this column, diagonals
                columnSet[c] = false;
                diagonalToLeft[diagonalToLeftNum] = false;
                diagonalToRight[diagonalToRightNum] = false;
            }
        }
        // Return how many solutions we have
        return count;
    }

}
