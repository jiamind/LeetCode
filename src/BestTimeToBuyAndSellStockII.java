/**
 * Created by udingji on 3/27/17.
 */
public class BestTimeToBuyAndSellStockII {


    // Idea: Just sell when you can make a profit!
    public int maxProfit(int[] prices) {

        // The total profit
        int total = 0;

        // If prices is null or the length of the prices array is less than 2, return 0
        if (prices == null || prices.length < 2)
            return total;

        // Iterate through the prices array, starting from the second value
        for (int i = 1; i < prices.length; i++){
            // If the current price is greater than the previous price, sell it
            if (prices[i] > prices[i-1])
                // Add the profit to the total
                total += prices[i] - prices[i-1];
        }

        return total;
    }

}
