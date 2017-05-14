/**
 * Created by jmding on 3/26/17.
 */
public class BestTimeToBuyAndSellStock {


    // Idea: Keep track of the max profit and min value to buy in
    // Initiate the max profit as 0, and the min value to buy in with the first value in the array
    // Starting from the second value, if it is greater than the previous value, then we calculate and update the new max profit
    // Otherwise, there is no way to make greater profit at this value when you sell (Because selling at the previous value gives you greater profit!)
    // But there is still chance that this value is a new buy in point. Update the min value if this value is smaller than the min value.
    public static int maxProfit(int[] prices) {

        // If prices is null, or the lenght of the prices is less than 2, return 0
        if (prices == null || prices.length < 2)
            return 0;

        // Initiate the max profit as 0, the min value as the first value in the prices array
        int maxProf = 0, minValue = prices[0];

        // Iterate through the prices array, starting from the second value
        for (int i = 1; i < prices.length; i++){
            // If the current price is greater than the previous price
            if (prices[i] > prices[i-1]){
                // Update the max profit
                maxProf = Math.max(maxProf,prices[i] - minValue);
            } else {
                // Otherwise, update the min value to buy in
                minValue = Math.min(minValue,prices[i]);
            }
        }
        // Return the max profit
        return maxProf;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{};
        System.out.println(maxProfit(prices));
    }
}
