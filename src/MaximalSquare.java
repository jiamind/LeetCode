/**
 * Created by udingji on 5/16/17.
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {

        if (matrix == null ||  matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        int result = 0;

        for (int i = 1; i < dp.length; i++){
            for (int j = 1; j < dp[0].length; j++){
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j-1],dp[i-1][j-1]),dp[i-1][j]) + 1;
                    result = Math.max(result,dp[i][j]);
                }
            }
        }
        return result * result;
    }
}
