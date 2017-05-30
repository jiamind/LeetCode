import java.util.Arrays;

/**
 * Created by jmding on 5/28/17.
 */
public class MinimumNumberOfArrowsToBurstBalloons {

    // There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice. Start is always smaller than end. There will be at most 104 balloons.

   // An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely. The problem is to find the minimum number of arrows that must be shot to burst all balloons.


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
