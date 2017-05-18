import java.util.HashMap;
import java.util.List;

/**
 * Created by udingji on 5/18/17.
 */
public class BrickWall {

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
