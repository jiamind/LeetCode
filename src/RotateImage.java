/**
 * Created by jmding on 2/20/17.
 */
public class RotateImage {

    public static void rotate(int[][] matrix) {

        // Get the row size and column size of the matrix (should be the same for a NxN matrix)
        int row = matrix.length;
        int column = matrix[0].length;

        // The outer loop is row, only need to iterate through half of it
        for (int r = 0; r < row / 2; r++) {
            // The inner loop is the column. The range for scanning will become smaller and smaller for inner layers
            for (int c = r; c < column - 1 - r; c++) {

                // Store the top value
                int temp = matrix[r][c];

                // Move left to the top
                // The row index of the left becomes smaller (getting closer to the top) as c grows,
                // Column index becomes larger (getting closer to the right) as r grows
                matrix[r][c] = matrix[row - 1 - c][r];

                // Move bottom to the left
                // The row index of the bottom becomes smaller (getting closer to the top) as r grows
                // Column index becomes smaller (closer to the left) as c grows
                matrix[row - 1 - c][r] = matrix[row - 1 - r][column - 1 - c];

                // Move right to the bottom
                // The row index of the right bottom becomes larger (getting closer to the bottom) as c grows
                // Column index becomes smaller (getting closer to the left) as r grows
                matrix[row - 1 - r][column - 1 - c] = matrix[c][column - 1 - r];

                // Move top to the right
                matrix[c][column - 1 - r] = temp;
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        matrix[0] = new int[]{1, 2, 3, 4, 5};
        matrix[1] = new int[]{6, 7, 8, 9, 10};
        matrix[2] = new int[]{11, 12, 13, 14, 15};
        matrix[3] = new int[]{16, 17, 18, 18, 20};
        matrix[4] = new int[]{21, 22, 23, 24, 25};

        rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println("");
        }
    }
}
