import java.util.ArrayList;
import java.util.List;

/**
 * Created by udingji on 3/17/17.
 */
public class PascalsTriangle
{

    public static List<List<Integer>> generate(int numRows) {

        // Create the list to store result
        List<List<Integer>> result = new ArrayList<>();
        // If the number of rows is 0, return the empty result
        if (numRows <= 0)
            return result;

        // Create a list to store numbers on each level
        List<Integer> list = new ArrayList<>();
        // The first level has 1
        list.add(1);
        // Add the first level to the result list
        result.add(list);

        // Iterate through all levels starting from the second level (1 means second level)
        for (int i = 1; i < numRows; i++){
            // Create an empty list for this level
            list = new ArrayList<>();
            // Level n has n numbers
            // Calculate each number
            for (int j = 0; j < i+1; j++){
                // If the number is the first number on this level, we take 0 as the number to its upper left
                // If the number is the last number on this level, we take 0 as the number to its upper right
                int num = (j - 1 < 0 ? 0 : result.get(i-1).get(j-1)) + (j >= result.get(i-1).size() ? 0 : result.get(i-1).get(j));
                // Add this number to the list on this level
                list.add(num);
            }
            // Add this level to the result list
            result.add(list);
        }
        // Return the result list
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = generate(5);
        System.out.println("done");
    }
}
