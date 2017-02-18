package test;

import java.awt.*;

/**
 * Created by udingji on 2/9/17.
 */
public class KnightsTour {

    private boolean[][] grid;

    private int count, spaces;

    //the possible moves for the Knight

    private static final Point[] MOVES = new Point[]{
            new Point(-2, -1),
            new Point(-2, 1),
            new Point(2, -1),
            new Point(2, 1),
            new Point(-1, -2),
            new Point(-1, 2),
            new Point(1, -2),
            new Point(1, 2)
            };

    /**
     * 029
     *
     * @param rows The number of rows
     *             030
     * @param cols The number of columns
     *             031
     ***/

    public KnightsTour(int rows, int cols) {

        grid = new boolean[rows][cols];

        spaces = rows * cols;

        count = 0;

    }

    /**
     * @param row The current row of the Knight
     * @param col The current column of the Knight
     *
     * @return boolean: true if the Knight visits all of the
     * <p>
     * spaces on the grid, false otherwise
     * <p>
     * <p>
     * <p>
     * This method starts with the current space for the Knight.
     * <p>
     * From there, it flags the current space as occupied and increments
     * <p>
     * the counter for the number of occupied spaces. The unvisited
     * <p>
     * spaces are visited individually in a depth-first manner in
     * <p>
     * an attempt to determine if the path will lead to a solution. If
     * <p>
     * it does, true is returned. If not, the current move is undone, the counter
     * <p>
     * is decremented, and false is returned.
     ***/

    public boolean tourFrom(int row, int col) {

        grid[row][col] = true;

        count++;

        if (count == spaces)

            return true;

        for (Point p : MOVES) {

            int nextRow = row + p.x;

            int nextCol = col + p.y;

            if (nextRow < 0 || nextRow >= grid.length)

                continue;

            else if (nextCol < 0 || nextCol >= grid.length)

                continue;

            else if (grid[nextRow][nextCol])

                continue;

            if (tourFrom(row + p.x, col + p.y))

                return true;

        }

        printGrid();

        grid[row][col] = false;

        count--;

        return false;

    }

    private void printGrid() {
        System.out.println("Count: " + count);
        for (boolean[] rows : grid) {
            for (boolean b : rows) {
                System.out.print((b) ? "T" : "F");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        KnightsTour tour = new KnightsTour(5, 5);
        tour.tourFrom(0, 0);
        tour.printGrid();
    }

}
