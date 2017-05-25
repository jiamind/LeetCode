import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by udingji on 5/16/17.
 */
public class WallsAndGates {

    // Idea: iterate through all rooms. Put all gates into a queue
    // For each gate or room with distance in the queue, update the distance of any neighbor which is an empty room. Push the neighbor rooms into the queues
    public void wallsAndGates(int[][] rooms) {

        int WALL = -1, GATE = 0, EMPTY_ROOM = Integer.MAX_VALUE;

        if (rooms == null || rooms.length == 0 || rooms[0].length == 0)
            return;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rooms.length; i++){
            for (int j = 0; j < rooms[0].length; j++){
                if (rooms[i][j] == GATE)
                    queue.offer(new int[]{i,j});
            }
        }

        while (!queue.isEmpty()){
            int[] room = queue.poll();
            int row = room[0], column = room[1];
            if (row - 1 >= 0 && rooms[row-1][column] == EMPTY_ROOM){
                rooms[row-1][column] = rooms[row][column] + 1;
                queue.offer(new int[]{row-1,column});
            }

            if (row + 1 < rooms.length && rooms[row+1][column] == EMPTY_ROOM){
                rooms[row+1][column] = rooms[row][column] + 1;
                queue.offer(new int[]{row+1,column});
            }

            if (column - 1 >= 0 && rooms[row][column-1] == EMPTY_ROOM){
                rooms[row][column-1] = rooms[row][column] + 1;
                queue.offer(new int[]{row,column-1});
            }

            if (column + 1 < rooms[0].length && rooms[row][column+1] == EMPTY_ROOM){
                rooms[row][column+1] = rooms[row][column] + 1;
                queue.offer(new int[]{row,column+1});
            }
        }
    }
}
