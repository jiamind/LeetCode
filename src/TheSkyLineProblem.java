import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by udingji on 5/14/17.
 */
public class TheSkyLineProblem {

    public List<int[]> getSkyline(int[][] buildings) {
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
        int prev = 0;

        // For each vertex we have
        for (int[] h : height){
            // If this is a left vertex, add the positive height to the priority queue
            // Otherwise, remove this height
            if (h[0] < 0){
                priorityQueue.offer(-h[1]);
            } else {
                priorityQueue.remove(h[1]);
            }
            // Get the current highest height in the priority queue
            int current = priorityQueue.peek();
            // If the current height does not equal to previous height. (Otherwise, don't need to create a new point)
            if (current != prev){
                // Add a new key point to the result list
                result.add(new int[]{h[0],current});
                // Update the previous height as the current height
                prev = current;
            }
        }
        return result;
    }
}
