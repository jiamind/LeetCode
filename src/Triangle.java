import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by udingji on 3/24/17.
 */
public class Triangle {

    public static int minimumTotal(List<List<Integer>> triangle) {

        return dfs(triangle,0,0,0);
    }

    private static int recurFindMinSum(List<List<Integer>> triangle, int level, int index){
        if (level >= triangle.size()){
            return 0;
        }

        return triangle.get(level).get(index) + Math.min(recurFindMinSum(triangle,level+1,index),recurFindMinSum(triangle,level+1,index+1));
    }


    private static int dfs(List<List<Integer>> triangle, int level, int index, int sum){
        if (level >= triangle.size()){
            return sum;
        } else {
            sum += triangle.get(level).get(index);
            return Math.min(dfs(triangle,level+1,index,sum),dfs(triangle,level+1,index+1,sum));
        }
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

        System.out.println(minimumTotal(triangle));

    }
}
