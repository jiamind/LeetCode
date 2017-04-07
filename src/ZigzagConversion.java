/**
 * Created by jmding on 1/30/17.
 */
public class ZigzagConversion {

    public static String convert(String s, int numRows) {
        // If the length of the string is less than the number of rows,
        // or the number of rows is 1.
        // The zigzag string is the original string
        if (s.length() <= numRows || numRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        char[] array = s.toCharArray();
        for (int i = 0; i < numRows; i++){
            int cursor = i;
            // Append the first character of that row
            sb.append(array[cursor]);
            while (cursor < array.length) {
                // Go downward then upward to find the next character on this row
                // Skip this if it is the last row
                if (i != numRows - 1) {
                    // Move the cursor forward twice the distance to the last row
                    cursor += (numRows - 1 - i) * 2;
                    // Continue if the cursor is out of range
                    if (cursor >= s.length()) continue;
                    // Append that character
                    sb.append(array[cursor]);
                }
                // Go upward then downward to find the next character on this row
                // Skip this if it is the first row
                if (i != 0) {
                    // Move the cursor forward twice the distance to the first row
                    cursor += i * 2;
                    // Continue if the cursor is out of range
                    if (cursor >= s.length()) continue;
                    // Append this character
                    sb.append(array[cursor]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String r = convert(s,numRows);
        System.out.println(r);
    }
}
