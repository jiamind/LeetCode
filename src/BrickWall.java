import java.util.HashMap;
import java.util.List;

/**
 * Created by udingji on 5/18/17.
 */
public class BrickWall {

    // There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.
    // The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.
    // If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.
    // You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.

    // Idea: Use a hashmap to record the number of brick ends at each index
    // We need to find the index which has the most number of brick ends in order to cross the least bricks when drop a line from top to bottom
    public int leastBricks(List<List<Integer>> wall) {
        if (wall.size() == 0)
            return 0;

        int maxNumIndex = 0;

        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for (List<Integer> row : wall){
            int index = 0;
            for (int i = 0; i < row.size() - 1; i++){
                index += row.get(i);
                if (hashMap.containsKey(index)){
                    hashMap.put(index,hashMap.get(index) + 1);
                } else {
                    hashMap.put(index,1);
                }
                maxNumIndex = Math.max(maxNumIndex,hashMap.get(index));
            }
        }

        return wall.size() - maxNumIndex;
    }
}
