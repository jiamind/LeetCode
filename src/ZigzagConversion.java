/**
 * Created by jmding on 1/30/17.
 */
public class ZigzagConversion {

    public static String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++){
            int cursor = i;
            sb.append(s.charAt(cursor));
            while (cursor < s.length()) {
                if (i != numRows - 1) {
                    cursor += (numRows - 1 - i) * 2;
                    if (cursor >= s.length()) continue;
                    sb.append(s.charAt(cursor));
                }
                if (i != 0) {
                    cursor += i * 2;
                    if (cursor >= s.length()) continue;
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
