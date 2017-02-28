/**
 * Created by jmding on 2/28/17.
 */
public class UniquePathII {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        // If the starting postion or the destination has an obstacle, return 0
        if (obstacleGrid[0][0] == 1 || obstacleGrid[row-1][column-1] == 1) return 0;

        // Create a 2D dynamic programming array
        int[][] dp = new int[row][column];
        // Set the ways to reach origin position to 1
        dp[0][0] = 1;
        // For each cell in the first column, the number of ways to get there is either 0 if it has an obstacle or the same as the number of ways to get the previous cell
        for (int i = 1; i < row; i++){
            dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i-1][0];
        }
        // For each cell in the first row, the number of ways to get there is either 0 if it has an obstacle or the same as the number of ways to get the previous cell.
        for (int i = 1; i < column; i++){
            dp[0][i] = obstacleGrid[0][i] == 1 ? 0 : dp[0][i-1];
        }

        // For each other cells, the number of ways to get there is either 0 if it has an obstacle
        // Or the sum of ways to get the previous cell in the current row and ways to get the same column on the previous row.
        for (int i = 1; i < row; i++){
            for (int j = 1; j < column; j++){
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[row-1][column-1];
    }

    public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        // The number of columns in the grid
        int column = obstacleGrid[0].length;
        // Array that represents number of ways to reach each column in the current row
        int[] dp = new int[column];
        // The number of ways to reach the first column in the first row is 1
        dp[0] = 1;
        // Iterate through each row
        for (int[] row : obstacleGrid) {
            // Iterate through each column on the current row
            for (int j = 0; j < column; j++) {
                // If there is an obstacle in the current cell, set dp at this position to 0
                if (row[j] == 1)
                    dp[j] = 0;
                // Otherwise, the number of ways to reach current cell is the sum of ways to reach the previous cell in the current row and ways to reach the same column in the previous row (value of dp[j])
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[column - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[1][];
        obstacleGrid[0] = new int[]{0,0};

        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
