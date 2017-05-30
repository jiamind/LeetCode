/**
 * Created by udingji on 5/12/17.
 */
public class NumberOfIslands {

    // Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

    // Example 1:

    //        11110
    //        11010
    //        11000
    //        00000
    // Answer: 1

    // Example 2:

    //        11000
    //        11000
    //        00100
    //        00011
    //Answer: 3

    // Idea: Iterate each cell in the 2d array. Use dfs on unvisited islands and mark all adjacent islands as visited
    public static int numIslands(char[][] grid) {

        int result = 0;
        if (grid == null || grid.length == 0)
            return result;

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1' && !visited[i][j]){
                    dfs(grid,i,j,visited);
                    result++;
                }
            }
        }

        return result;
    }

    private static void dfs(char[][] grid, int row, int column, boolean[][] visited){

        // up, down, left, right
        int[] rowMoves = {-1,1,0,0};
        int[] columnMoves = {0,0,-1,1};

        visited[row][column] = true;

        for (int i = 0 ; i < 4; i++){
            if (isValid(grid,row+rowMoves[i],column+columnMoves[i],visited)){
                dfs(grid,row+rowMoves[i],column+columnMoves[i],visited);
            }
        }
    }

    private static boolean isValid(char[][] grid, int row, int column, boolean[][] visited){

        return row >= 0 && row < grid.length && column >= 0 && column < grid[0].length && grid[row][column] == '1' && !visited[row][column];
    }

    public static void main(String[] args) {
        char[][] grid = new char[4][];
        grid[0] = new char[]{'1','1','1','1','0'};
        grid[1] = new char[]{'1','1','0','1','0'};
        grid[2] = new char[]{'1','1','0','0','0'};
        grid[3] = new char[]{'0','0','0','0','0'};
        System.out.println(numIslands(grid));
    }
}
