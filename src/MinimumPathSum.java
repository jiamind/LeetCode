/**
 * Created by jmding on 2/28/17.
 */
public class MinimumPathSum {

    public static int minPathSum(int[][] grid) {
        // Get the number of rows in the grid
        int row = grid.length;
        // If number of row is 0, return 0
        if (row == 0) return 0;
        // Get the number of columns in the grid
        int column = grid[0].length;
        // Create an array to store the min sum at each column in the row
        int[] dp = new int[column];

        // Initialize the origin
        dp[0] = grid[0][0];
        // Populate the first row, since there is only one way to get to each column on the first row
        for (int i = 1; i < column; i++){
            dp[i] = grid[0][i] + dp[i-1];
        }

        // Iterate through all other cells in the other rows
        for (int i = 1; i < row; i++){
            int[] gridRow = grid[i];
            for (int j = 0; j < column; j++){
                // if this is the first column of the row, there is only one way to get here
                if (j == 0){
                    dp[0] += gridRow[0];
                }else {
                    // The min sum would be the min of the cell above it and to the left of it, plus the number in the current cell
                    dp[j] = Math.min(dp[j], dp[j-1]) + gridRow[j];
                }
            }
        }
        // return the last column in the last row
        return dp[column-1];
    }
}
