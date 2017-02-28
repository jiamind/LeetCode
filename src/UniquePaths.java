/**
 * Created by jmding on 2/28/17.
 */
public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        // Create 2D dynamic programming array
        int[][] dp = new int[m][n];
        // Each cell in the first column is 1. Since there is only one way to move from (0,0) to any cell on the first row
        for (int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        // Each cell on the first row is 1. Since there is only one way to move from (0,0) to any cell on the first column
        for (int i = 0; i < n; i++){
            dp[0][i] = 1;
        }
        // For each of any other cell, the number of ways to move to that cell is the sum of ways to move to its adjacent cells.
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
