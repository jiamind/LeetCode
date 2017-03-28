/**
 * Created by udingji on 3/27/17.
 */
public class BestTimeToBuyAndSellStockIII {

    // Time limit exceeds
    // Idea: Divide prices array into two subarrays. Find the max sum of the max profit for each sub price array
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length < 2)
            return 0;

        int maxProf = 0;

        for (int i = 0; i < prices.length; i++){
            maxProf = Math.max(maxProf,maxProfit(prices,0,i) + maxProfit(prices,i,prices.length));
        }

        return maxProf;
    }


    private int maxProfit(int[] prices, int start, int end){

        if (end - start < 2)
            return 0;

        int maxProf = 0, minValue = prices[start];

        for (int i = start+1; i < end; i++){
            if (prices[i] > prices[i-1]){
                maxProf = Math.max(maxProf,prices[i] - minValue);
            } else {
                minValue = Math.min(minValue,prices[i]);
            }
        }

        return maxProf;
    }

    public int maxProfit2(int[] prices) {

        // If the prices array is null, or the length of the prices array is less than 2, return 0
        if (prices == null || prices.length < 2)
            return 0;

        // Initialize the first purchase price as the first price in the array
        // The profit after first sell as 0
        // The money left after second purchase as the min integer value
        // The total profit as 0
        int firstPurchasePrice = prices[0];
        int profitAfterFirstSell = 0;
        int moneyLeftAfterSecondPurchase = Integer.MIN_VALUE;
        int totalProfit = 0;

        // Iterate through the prices array, starting from the second price
        for (int i = 1; i < prices.length; i++){
            // We'd like to purchase stock at the min price possible.
            firstPurchasePrice = Math.min(firstPurchasePrice,prices[i]);
            // We'd like to sell the stock if we can make maximum profit here
            profitAfterFirstSell = Math.max(profitAfterFirstSell,prices[i] - firstPurchasePrice);
            // We'd like to make the most profit in our hands if we purchase the stock the second time here
            moneyLeftAfterSecondPurchase = Math.max(moneyLeftAfterSecondPurchase,profitAfterFirstSell-prices[i]);
            // We'd like to make the most profit if we sell the stock the second time here
            totalProfit = Math.max(totalProfit,moneyLeftAfterSecondPurchase+prices[i]);
        }

        return totalProfit;
    }
}
