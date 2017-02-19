/**
 * Created by jmding on 1/30/17.
 */
public class ZigzagConversion {

    public static String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++){
            int cursor = i;
            // Append the first character of that row
            sb.append(s.charAt(cursor));
            while (cursor < s.length()) {
                // Skip this if it is the last row
                if (i != numRows - 1) {
                    // Move the cursor forward twice the distance to the last row
                    cursor += (numRows - 1 - i) * 2;
                    // Continue if the cursor is out of range
                    if (cursor >= s.length()) continue;
                    // Append that character
                    sb.append(s.charAt(cursor));
                }
                // Skip this if it is the first row
                if (i != 0) {
                    // Move the cursor forward twice the distance to the first row
                    cursor += i * 2;
                    // Continue if the cursor is out of range
                    if (cursor >= s.length()) continue;
                    // Append this character
                    sb.append(s.charAt(cursor));
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
