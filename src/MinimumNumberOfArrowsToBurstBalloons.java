import java.util.Arrays;

/**
 * Created by jmding on 5/28/17.
 */
public class MinimumNumberOfArrowsToBurstBalloons {

    // Idea: sort the point (balloons) base on start index
    // Iterate through the array. If two balloons overlap, they can be shot using one arrow.
    // Update the right most index of the last arrow could shot.
    public static int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0)
            return 0;

        int num = 1;
        Arrays.sort(points,(a,b)->{return a[0] - b[0];});
        int lastArrowIndex = points[0][1];

        for (int i = 1 ; i < points.length; i++){
            if (points[i][0] <= lastArrowIndex){
                lastArrowIndex = Math.min(lastArrowIndex,points[i][1]);
            } else {
                num++;
                lastArrowIndex = points[i][1];
            }
        }

        return num;
    }

    public static void main(String[] args) {
        int[][] points = {{10,16}, {2,8}, {1,6}, {7,12}};
        System.out.println(findMinArrowShots(points));
    }
}
