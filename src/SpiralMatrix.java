import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by udingji on 2/23/17.
 */
public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int row = matrix.length;
        if (row == 0) return result;

        int column = matrix[0].length;

        // Starting postion of the top, right, bottom, left bounds
        int topRow = 0, rightColumn = column - 1, bottomRow = row - 1, leftColumn = 0;

        while (topRow <= bottomRow && leftColumn <= rightColumn){
            for (int i = leftColumn; i <= rightColumn; i++){
                result.add(matrix[topRow][i]);
            }
            topRow++;
            if (topRow > bottomRow) break;

            for (int i = topRow; i <= bottomRow; i++){
                result.add(matrix[i][rightColumn]);
            }
            rightColumn--;
            if (rightColumn < leftColumn) break;

            for (int i = rightColumn; i >= leftColumn; i--){
                result.add(matrix[bottomRow][i]);
            }
            bottomRow--;
            if (bottomRow < topRow) break;

            for (int i = bottomRow; i >= topRow; i--){
                result.add(matrix[i][leftColumn]);
            }
            leftColumn++;
            if (leftColumn > rightColumn) break;
        }

        return result;
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[3][4];
//        matrix[0] = new int[]{1,2,3,4};
//        matrix[1] = new int[]{5,6,7,8};
//        matrix[2] = new int[]{9,10,11,12};

//        int[][] matrix = new int[4][4];
//        matrix[0] = new int[]{1,2,3,4};
//        matrix[1] = new int[]{5,6,7,8};
//        matrix[2] = new int[]{9,10,11,12};
//        matrix[3] = new int[]{13,14,15,16};

//        int[][] matrix = new int[1][];
//        matrix[0] = new int[]{1,2,3,4};

        int[][] matrix = new int[3][];
        matrix[0] = new int[]{1};
        matrix[1] = new int[]{2};
        matrix[2] = new int[]{3};

        List<Integer> result = spiralOrder(matrix);
        for (Integer i : result){
            System.out.print(i + ", ");
        }
    }
}
