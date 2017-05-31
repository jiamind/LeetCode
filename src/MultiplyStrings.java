
/**
 * Created by udingji on 2/17/17.
 */
public class MultiplyStrings {

    // Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

    // Note:

    // The length of both num1 and num2 is < 110.
    // Both num1 and num2 contains only digits 0-9.
    // Both num1 and num2 does not contain any leading zero.
    // You must not use any built-in BigInteger library or convert the inputs to integer directly.


    public static String multiply(String num1, String num2) {
        // The length of the result would be at most the length of num1 plus num2
        int[] pos = new int[num1.length() + num2.length()];

        for(int i = num1.length() - 1; i >= 0; i--) {
            for(int j = num2.length() - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // p1 indicates the tenth digit, p2 indicates the single digit
                int p1 = i + j, p2 = i + j + 1;
                // The sum should be the multiplied result, plus any carried over digit
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        // Do not append leading zero
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "99";
        String num2 = "99";
        long start = System.currentTimeMillis();
        System.out.println(multiply(num1,num2));
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
