/**
 * Created by udingji on 3/27/17.
 */
public class BestTimeToBuyAndSellStockIII {

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
}
