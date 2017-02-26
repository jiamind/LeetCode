/**
 * Created by jmding on 2/25/17.
 */
public class SpiralMatrixII {

    public static int[][] generateMatrix(int n) {
        int[][] result;
        if (n == 0){
            result = new int[0][0];
            return result;
        }
        if (n == 1){
            result = new int[1][];
            result[0] = new int[]{1};
            return result;
        }

        result = new int[n][n];

        int layer = 0;
        int counter = 1;
        while (layer < ((n + 1) / 2)){

            if (layer != 0){
                // up
                for (int i = n - layer - 1; i >= layer; i--){
                    if (result[i][layer-1] != 0) return result;
                    result[i][layer-1] = counter++;
                }
            }

            // right
            for (int i = layer; i < n - layer; i++){
                if (result[layer][i] != 0) return result;
                result[layer][i] = counter++;
            }

            // down
            for (int i = layer + 1; i < n - layer; i++){
                if (result[i][n-layer-1] != 0) return result;
                result[i][n-layer-1] = counter++;
            }

            // left
            for (int i = n - layer - 2; i >= layer; i--){
                if (result[n-layer-1][i] != 0) return result;
                result[n-layer-1][i] = counter++;
            }

            layer++;

        }
        return result;
    }

    public static int[][] generateMatrix2(int n) {
        // Create a nxn matrix
        int[][] ret = new int[n][n];
        // Left: the first column index when populate from left to right
        // Top: the first row index when populate from top to down
        int left = 0,top = 0;
        // Right: the first column index when populate from right to left
        // Bottom: the first row index when populate from down to up
        int right = n -1,bottom = n - 1;
        // Keep track of the number we populated
        int count = 1;
        // Loop while left does not exceed right
        while (left <= right) {
            // Start from left to right. The row is top starting row index
            for (int j = left; j <= right; j ++) {
                ret[top][j] = count++;
            }
            // Increment top index since we finished the top row
            top ++;
            // Populate from top to bottom. The column is right starting column index
            for (int i = top; i <= bottom; i ++) {
                ret[i][right] = count ++;
            }
            // Decrement right since we finished the right column
            right --;
            // Populate from right to left. The row is bottom starting row index
            for (int j = right; j >= left; j --) {
                ret[bottom][j] = count ++;
            }
            // Decrement bottom since we finished the bottom row
            bottom --;
            // Populate from bottom to top. The column is the left starting column
            for (int i = bottom; i >= top; i --) {
                ret[i][left] = count ++;
            }
            // Increment left since we finished left column
            left ++;
        }
        return ret;
    }


    public static void main(String[] args) {
        int n = 5;
        int[][] result = generateMatrix(n);
        for (int i = 0; i < n; i++){
            System.out.print("[");
            for (int j = 0; j < n; j++){
                System.out.print(result[i][j] + ", ");
            }
            System.out.println("]");
        }

    }
}
