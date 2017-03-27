import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by udingji on 3/24/17.
 */
public class Triangle {

    // Time exceeds limit
    // Idea: Use DFS, Find the min path from top to bottom.
    public static int minimumTotal(List<List<Integer>> triangle) {

        return dfs(triangle,0,0,0);
    }

    private static int dfs(List<List<Integer>> triangle, int level, int index, int sum){
        // If we reach the bottom level, return the sum of all numbers in this path
        if (level >= triangle.size()){
            return sum;
        } else {
            // Otherwise, add the current number to the sum
            sum += triangle.get(level).get(index);
            // The min path sum to this point would be the min path sum of it's lower left and lower right, plus its own value
            return Math.min(dfs(triangle,level+1,index,sum),dfs(triangle,level+1,index+1,sum));
        }
    }



    // Idea: use dynamic programming. Find the min path from bottom to top
    public static int minimumTotal2(List<List<Integer>> triangle) {

        // Get the total number of rows in the triangle
        int row = triangle.size();
        // Create a dynamic programming array to store the minimum path sum at the current level
        // The size of the array would be the size of the bottom level plus one
        int[] dp = new int[triangle.get(triangle.size()-1).size()+1];

        // Iterate through each level, from the bottom to the top
        for (int i = row - 1; i >= 0; i--) {
            // Get the size of the current level
            int num = triangle.get(i).size();
            // Iterate through each number at the current level
            for (int j = 0; j < num; j++){
                // The minimum path sum at each number is the minimum path sum of its lower left and lower right number,
                // Plus its own value.
                // Note: before updating the path sum value, the array stored the path sum of it's lower level
                dp[j] = Math.min(dp[j],dp[j+1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];
    }


    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        Integer[] array = new Integer[]{2};
        row.addAll(Arrays.asList(array));
        triangle.add(new ArrayList<>(row));

        array = new Integer[]{3,4};
        row = new ArrayList<>();
        row.addAll(Arrays.asList(array));
        triangle.add(new ArrayList<>(row));

        array = new Integer[]{6,5,7};
        row = new ArrayList<>();
        row.addAll(Arrays.asList(array));
        triangle.add(new ArrayList<>(row));

        array = new Integer[]{4,1,8,3};
        row = new ArrayList<>();
        row.addAll(Arrays.asList(array));
        triangle.add(new ArrayList<>(row));

        System.out.println(minimumTotal2(triangle));

    }
}
