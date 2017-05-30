/**
 * Created by jmding on 5/29/17.
 */
public class ExcelSheetColumnNumber {

    // Related to question Excel Sheet Column Title

    // Given a column title as appear in an Excel sheet, return its corresponding column number.

    // For example:

    // A -> 1
    // B -> 2
    // C -> 3
    //  ...
    // Z -> 26
    // AA -> 27
    // AB -> 28

    public static int titleToNumber(String s) {
        char[] array = s.toCharArray();
        char base = 'A' - 1;
        int result = 0;

        for (char c : array){
            result = result * 26 + (c - base);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("AA"));
    }
}
