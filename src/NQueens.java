import java.util.*;

/**
 * Created by jmding on 2/21/17.
 */
public class NQueens {

    // TLE.
//    public static List<List<String>> solveNQueens(int n) {
//
//        List<List<String>> r = new ArrayList<>();
//        HashSet<String> result = new HashSet<>();
//        char[][] array = new char[n][n];
//        for (int i = 0; i < n; i++){
//            Arrays.fill(array[i],'.');
//        }
//        backtrack(n,n,result,array);
//        Iterator iterator = result.iterator();
//        while (iterator.hasNext()){
//            String[] strings = ((String)iterator.next()).split(",");
//            r.add(Arrays.asList(strings));
//        }
//        return r;
//
//    }
//
//    public static void backtrack(int n, int remain, HashSet<String> result, char[][] array) {
//        if (remain == 0){
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < n; i++){
//                sb.append(array[i]);
//                if (i != n - 1) sb.append(',');
//            }
//            result.add(sb.toString());
//            return;
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (array[i][j] == '.') {
//                    if (isValid(array,n,i,j)) {
//                        array[i][j] = 'Q';
//                        backtrack(n,remain-1,result,array);
//                        array[i][j] = '.';
//                    }
//                }
//            }
//        }
//
//    }
//
//    public static boolean isValid(char[][] array, int n, int r, int c){
//        for (int i = 0; i < n; i++){
//            if ( (i != c && array[r][i] == 'Q') || (i != r && array[i][c] == 'Q'))
//                return false;
//        }
//        int i = 1;
//        while (r+i < n && c+i < n){
//            if (array[r+i][c+i] == 'Q')
//                return false;
//            i++;
//        }
//        i = 1;
//        while (r-i >= 0 && c-i >= 0){
//            if (array[r-i][c-i] == 'Q')
//                return false;
//            i++;
//        }
//        i = 1;
//        while (r-i >= 0 && c+i < n){
//            if (array[r-i][c+i] == 'Q')
//                return false;
//            i++;
//        }
//        i = 1;
//        while (r+i < n && c-i >= 0){
//            if (array[r+i][c-i] == 'Q')
//                return false;
//            i++;
//        }
//
//        return true;
//    }



    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();
        // Fill the chessboard with '.' (empty space)
        char[][] array = new char[n][n];
        for (int i = 0; i < n; i++){
            Arrays.fill(array[i],'.');
        }
        // Starting from the top, we fill the chessboard row by row
        backtrack(n,result,array,0);
        Iterator iterator = result.iterator();
        return result;

    }

    public static void backtrack(int n, List<List<String>> result, char[][] array, int row) {
        // If row reaches the end, we finished.
        // Add the list to the result
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(String.valueOf(array[i]));
            }
            result.add(list);
            return;
        }
        // For each column in this row
        for (int column = 0; column < n; column++) {
            // If we see an empty space
            if (array[row][column] == '.') {
                // We try to fill in a 'Q', to see if it's valid
                if (isValid(array, n, row, column)) {
                    // If it is valid, we write down this 'Q'
                    array[row][column] = 'Q';
                    // We are finished with this row since only one 'Q' is allowed per row
                    // We move on to the next row
                    backtrack(n, result, array, row+1);
                    // We finished this round. Remove the 'Q' we just filled. Ready to try the next column position
                    array[row][column] = '.';
                }
            }
        }

    }

    public static boolean isValid(char[][] array, int n, int r, int c){
        // For each column
        for (int j = 0; j < n; j++){
            // For each row until r, since rows below r are not touch yet.
            for (int i = 0; i < r; i++){
                // If any cell has 'Q', and the row distance and column distance are the same, or they are on the same column
                if (array[i][j] == 'Q' && (Math.abs(i-r) == Math.abs(j-c)||c==j))
                    return false;
            }
        }

        return true;
    }




    public static void main(String[] args) {
        List<List<String>> result = solveNQueens(5);
        for (List<String> list : result){
            for (String s : list){
                System.out.println(s);
            }
            System.out.println();
        }
    }
}
