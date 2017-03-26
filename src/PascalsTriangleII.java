import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by udingji on 3/24/17.
 */
public class PascalsTriangleII {

    // Time exceeds limit
    // Idea: Populate the first half of the level and reverse to get the second half
    // Cache the level above the current level, so we don't need to compute the upper left number
    public static List<Integer> getRow(int rowIndex) {

        List<Integer> result = new ArrayList<>();
        List<Integer> dp = new ArrayList<>();
        dp.add(1);

        for (int i = 0; i <= rowIndex / 2; i++) {
            int num = calcNumAtLevel(i, rowIndex, rowIndex, dp);
            result.add(num);
        }

        List<Integer> temp = new ArrayList<>(result);
        if (rowIndex % 2 == 0)
            temp.remove(temp.size() - 1);
        Collections.reverse(temp);
        result.addAll(temp);

        return result;
    }

    private static int calcNumAtLevel(int index, int row, int rowTotal, List<Integer> dp) {

        if (index == 0 || index == row)
            return 1;
        int left, right;
        if (row == rowTotal){
            left = dp.get(index-1);
        } else {
            left = calcNumAtLevel(index - 1, row - 1, rowTotal, dp);
        }
        right = calcNumAtLevel(index, row - 1, rowTotal, dp);
        if (row == rowTotal)
            dp.add(right);

        return left + right;
    }


    // Idea: Start from level 0 to the bottom. Add 1 to the front every time we compute a new level.
    // Then calculate the numbers between the first and last number (1s). Since we shift the previous level to the right
    // The number at index i would now be the sum of the numbers at index i and i+1
    // 1            (Add 1 to the front)
    // 1 1          (Add 1 to the front)
    // 1 1 1        (Add 1 to the front. Imagine the last two 1s represent the previous level)
    // 1 2 1        (The new value of the middle number is its previous value plus the next value)

    public static List<Integer> getRow2(int rowIndex){

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++){
            result.add(0,1);
            for (int j = 1; j < result.size() - 1; j++){
                result.set(j,result.get(j) + result.get(j+1));
            }
        }

        return result;
    }


    public static void main(String[] args) {
        List<Integer> result = getRow2(0);

        for (Integer i : result)
            System.out.print(i + " ");
    }
}
