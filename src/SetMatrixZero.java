/**
 * Created by jmding on 3/4/17.
 */
public class SetMatrixZero {

    public static void setZeroes(int[][] matrix) {

        // Idea: use the first row and column of the matrix to store information of whether this row/column contains 0
        // This requires 0(1) in space

        // Get the number of rows in the matrix
        int row = matrix.length;
        // Get the number of columns in the matrix
        int column = matrix[0].length;
        // Since the idea is using the first row and first column to store the information of whether this row/column contains 0
        // We need two extra variable to store whether the first row and the first column contains 0
        boolean firstRowHasZero = false, firstColumnHasZero = false;

        // Iterate through each cell in the matrix
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                // If the current position has a 0
                if (matrix[i][j] == 0){
                    // If it is on the first row, set the flag
                    if (i == 0) firstRowHasZero = true;
                    // If it is on the first column, st the flag
                    if (j == 0) firstColumnHasZero = true;
                    // Set the first row, which indicates this column contains 0
                    matrix[0][j] = 0;
                    // Set the first column, which indicates this row contains 0
                    matrix[i][0] = 0;
                }
            }
        }

        // Iterate through each cell in the matrix, except the first row and first column
        for (int i = 1; i < row; i++){
            for (int j = 1; j < column; j++){
                // If the row or the column number of the cell mapped on the first row or column has a 0, set the cell to 0
                if (matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        // If the first row has zero (flag is set)
        if (firstRowHasZero){
            // Set all cells on the first row to 0
            for (int i = 0; i < column; i++)
                matrix[0][i] = 0;
        }
        // If the first column has zero (flag is set)
        if (firstColumnHasZero){
            // Set all cells on the first column to 0
            for (int i = 0; i < row; i++)
                matrix[i][0] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        matrix[0] = new int[]{1,2,3,4,5};
        matrix[1] = new int[]{1,2,0,4,5};
        matrix[2] = new int[]{1,2,3,4,5};
        matrix[3] = new int[]{1,2,3,0,5};
        matrix[4] = new int[]{1,2,3,4,5};

        setZeroes(matrix);

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
