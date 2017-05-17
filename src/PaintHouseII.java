/**
 * Created by udingji on 5/17/17.
 */
public class PaintHouseII {

    public int minCostII(int[][] costs) {

        if (costs == null || costs.length == 0)
            return 0;

        // Keep track of the smallest cost color and the second most smallest cost color at the current house
        int currentFirstSmallestCost = -1, currentSecondSmallestCost = -1;

        for (int i = 0; i < costs.length; i++){

            // Save the previous smallest and second smallest value, set the current smallest and second smallest as -1, since we are starting with a new house
            int lastFirstSmallestCost = currentFirstSmallestCost, lastSecondSmallestCost = currentSecondSmallestCost;
            currentFirstSmallestCost = -1;
            currentSecondSmallestCost = -1;

            for (int j = 0; j < costs[0].length; j++){
                // If the current color selection does not conflict with the previous smallest cost color selection, go from that route (previous house picks the smallest cost color)
                // Otherwise, go from the previous second smallest cost color (previous house picks the second smallest cost color)
                if (j != lastFirstSmallestCost){
                    costs[i][j] += (lastFirstSmallestCost < 0 ? 0 : costs[i-1][lastFirstSmallestCost]);
                } else {
                    costs[i][j] += (lastSecondSmallestCost < 0 ? 0 : costs[i-1][lastSecondSmallestCost]);
                }

                // Update the current smallest cost color and second smallest cost color
                if (currentFirstSmallestCost < 0 || costs[i][j] < costs[i][currentFirstSmallestCost]){
                    currentSecondSmallestCost = currentFirstSmallestCost;
                    currentFirstSmallestCost = j;
                } else if (currentSecondSmallestCost < 0 || costs[i][j] < costs[i][currentSecondSmallestCost]){
                    currentSecondSmallestCost = j;
                }
            }
        }

        return costs[costs.length-1][currentFirstSmallestCost];
    }
}
