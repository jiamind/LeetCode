/**
 * Created by jmding on 3/1/17.
 */
public class AddBinary {

    public static String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        // Convert two strings into character arrays
        char[] array1 = a.toCharArray();
        char[] array2 = b.toCharArray();

        // Save any carry over value to the next digit
        int carryOver = 0;
        int i = 0;
        // Iterate through two arrays until we reach both ends
        while (i < array1.length || i < array2.length){
            // Get the numbers at the current index (starting from the end) in two arrays
            int i1 = i >= array1.length ? 0 : array1[array1.length-1-i] - '0';
            int i2 = i >= array2.length ? 0 : array2[array2.length-1-i] - '0';

            // Add them together with any carryover and append the number in the string builder. If the sum exceeds 1, sum - 1 and set carryOver to 1
            if (i1+i2+carryOver >= 2){
                sb.append(i1+i2+carryOver-2);
                carryOver = 1;
            }else {
                sb.append(i1+i2+carryOver);
                carryOver = 0;
            }
            i++;
        }

        // If there's still carryover after we reach the head, add the carryover
        if (carryOver == 1){
            sb.append(1);
        }
        // Reverse the string builder and return result
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "10101010";
        String b = "110011";

        System.out.println(addBinary(a,b));
    }
}
