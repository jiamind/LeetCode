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
        char base = 'A' - 1;

        while (n > 0){
            // If the number is a multiply of 26 (must be greater than or equal to 26), prepend a 'Z'
            if (n / 26 > 0 && n % 26 == 0) {
                n -= 26;
                sb.insert(0, "Z");
            }else {
                sb.insert(0, (char) (base + n % 26));
            }
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
