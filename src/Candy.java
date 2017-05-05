import java.util.Arrays;

/**
 * Created by jmding on 5/5/17.
 */
public class Candy {

    // Idea: iterate from start to end to populate candies base on the rule,
    // then from end to start to update candies which breaks the rule
    public int candy(int[] ratings) {

        int result = 0;

        // If the ratings array is null, return 0
        if (ratings == null)
            return result;

        // If the length of the ratings array is less than or equal to 1,
        // return the length of the array as the min number of candies required
        if (ratings.length <= 1)
            return ratings.length;

        // Create an array to store candies at each rating, initialize it with 1,
        // since each rating get at least one candy
        int[] candies = new int[ratings.length];
        Arrays.fill(candies,1);

        // Iterate through the ratings from start to end
        for (int i = 1; i < candies.length; i++){
            // If the current rating is greater than the previous one, it gets one more candy than the previous one
            if (ratings[i] > ratings[i-1])
                candies[i] = candies[i-1] + 1;
        }

        // Iterate through the ratings from end to start
        for (int i = candies.length - 1; i > 0; i--){
            // If the current rating is less than the rating before it, the rating before it ought to have one more candy
            // However, we also don't want to undermine the rule (relationship among candies which we establish during previous iteration)
            // Therefore, we take the max value of the current candies of the rating before it, and the candies of the current rating plus one
            // Example: 4,5,6,5,4,3,2,1
            // After first iteration: 1,2,3,1,1,1,1
            // After second iteration: 1,2,6,5,4,3,2,1
            if (ratings[i-1] > ratings[i]){
                candies[i-1]  = Math.max(candies[i-1],candies[i] + 1);
            }
        }

        // Calculate the sum
        for (int c : candies){
            result += c;
        }

        return result;
    }
}
