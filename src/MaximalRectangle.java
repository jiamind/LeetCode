import java.util.Stack;

/**
 * Created by udingji on 5/16/17.
 */
public class MaximalRectangle {

    // Idea: scan from the first row to the last row. Use an array to keep track of the height at each index at each row.
    // Find the max area at each row
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int[] rowHeight = new int[matrix[0].length];
        int result = 0;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == '0') {
                    rowHeight[j] = 0;
                } else {
                    rowHeight[j]++;
                }
            }
            result = Math.max(result,maxAreaAtRow(rowHeight));
        }
        return result;
    }

    // http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
    private int maxAreaAtRow(int[] rowHeight){
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= rowHeight.length; i++){
            int h = (i == rowHeight.length ? 0 : rowHeight[i]);
            if(s.isEmpty() || h >= rowHeight[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, rowHeight[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }
}
