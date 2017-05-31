import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by udingji on 5/14/17.
 */
public class TheSkyLineProblem {

    // A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).

    // Buildings Skyline Contour
    // The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

    // For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

    // The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.

    // For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].

    // Notes:

    // The number of buildings in any input list is guaranteed to be in the range [0, 10000].
    // The input list is already sorted in ascending order by the left x position Li.
    // The output list must be sorted by the x position.
    // There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]


    public static List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();

        // Add the x and y coordinate of each vertex of the building to the height list
        // We make y negative to indicate that this is the left vertex
        for (int[] building : buildings){
            height.add(new int[]{building[0],-building[2]});
            height.add(new int[]{building[1],building[2]});
        }

        // Sort the list base on value of x. if x values are the same, left vertex first
        Collections.sort(height,(h1,h2)->{
            if (h1[0] != h2[0])
                return h1[0] - h2[0];
            return h1[1] - h2[1];
        });

        // Create a priority queue (max heap) to keep track of the highest height
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>((a,b)->{return b-a;});
        // Add 0 to the priority queue as the base height
        priorityQueue.offer(0);

        // Keep track of the previous height (if the current height is the same as previous one, no need to add new point to the result)
        int prevHeight = 0;

        // For each vertex we have
        for (int[] h : height){
            // If this is a left vertex, add the positive height to the priority queue
            // Otherwise, remove this height
            if (h[1] < 0){
                priorityQueue.offer(-h[1]);
            } else {
                priorityQueue.remove(h[1]);
            }
            // Get the current highest height in the priority queue
            int currentHeight = priorityQueue.peek();
            // If the current height does not equal to previous height. (Otherwise, don't need to create a new point)
            if (currentHeight != prevHeight){
                // Add a new key point to the result list
                result.add(new int[]{h[0],currentHeight});
                // Update the previous height as the current height
                prevHeight = currentHeight;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] buildings = {{0,2,3},{2,3,5}};
        List<int[]> result = getSkyline(buildings);

        for (int[] r : result){
            for (int i : r){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
