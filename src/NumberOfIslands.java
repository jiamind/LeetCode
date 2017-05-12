/**
 * Created by udingji on 5/12/17.
 */
public class NumberOfIslands {


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
