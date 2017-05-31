/**
 * Created by udingji on 5/18/17.
 */
public class ExcelSheetColumnTitle {

    // Given a positive integer, return its corresponding column title as appear in an Excel sheet.

    // Example:
    //  1 -> A
    //  2 -> B
    //  3 -> C
    //  ...
    //  26 -> Z
    //  27 -> AA
    //  28 -> AB

    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0){
            n--;
            sb.insert(0, (char) ('A' + n % 26));
            // We are done with the current digit
            n /= 26;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        for (int i = 1; i < 60; i++){
            System.out.println(convertToTitle(i));
        }
    }
}
