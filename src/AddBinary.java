/**
 * Created by jmding on 3/1/17.
 */
public class AddBinary {

    // Given two binary strings, return their sum (also a binary string).

    // For example,
    // a = "11"
    // b = "1"
    // Return "100".

    public static String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        // Convert two strings into character arrays
        char[] array1 = a.toCharArray();
        char[] array2 = b.toCharArray();

        int sum = 0, i = 0;
        while ( i < array1.length || i < array2.length){
            sum += i >= array1.length ? 0 : array1[array1.length - 1 - i] - '0';
            sum += i >= array2.length ? 0 : array2[array2.length - 1 - i] - '0';

            sb.append(sum%2);
            sum /= 2;
            i++;
        }

        if (sum != 0)
            sb.append(sum);

        // Reverse the string builder and return result
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "10101010";
        String b = "110011";

        System.out.println(addBinary(a,b));
    }
}
