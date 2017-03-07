import java.util.ArrayList;
import java.util.List;

/**
 * Created by udingji on 3/7/17.
 */
public class RestoreIPAddresses {


    // O(3^4)
    public static List<String> restoreIpAddresses(String s) {

        // Create a list to store results
        List<String> result = new ArrayList<>();
        backtrack(s,result,"",0,0);
        return result;
    }

    private static void backtrack(String ip, List<String> result, String str, int index, int count){
        // There are only 4 parts in the ip address
        if (count > 4) return;
        // If we finished the 4th part and the length of the ip address (without dots) is equal to the length of the original string
        if (count == 4 && index == ip.length())
            // Add the ip in the result list
            result.add(str);

        // Any part in an IP address will have maximum length of 3. We can either scan 1, 2 or 3 characters at a time
        for (int i = 1; i < 4; i++){
            // If adding the characters would exceed the length of the ip address, stop here.
            if (index + i > ip.length()) break;
            // Get the substring from index to index + i exclusive
            String substring = ip.substring(index,index + i);
            // If the length of this part is not 1 and the first character is 0
            // Or the integer value of this part exceed 255
            // This part is not a valid ip address part
            if ((substring.length() != 1 && substring.charAt(0) == '0') || Integer.parseInt(substring) > 255) break;
            // Adding this part to the buffer. Call backtrack method for the next part
            backtrack(ip,result,str + substring + (count == 3? "" : "."),index+i,count+1);
        }
    }

    public static List<String> restoreIpAddresses2(String s) {
        // Create a list to store results
        List<String> result = new ArrayList<>();
        // Create 4 nested loops, each represents a part in a IP address.
        // The length of each part won't be greater than 3
        for (int i = 1; i <= 3; i++ ){
            for (int j = 1; j <= 3; j++){
                for (int m = 1; m <= 3; m++){
                    for (int n = 1; n <=3; n++){
                        // The sum of the length in all 4 parts should be the same as the string
                        if (i+j+m+n == s.length()) {
                            // Get each 4 parts
                            String a = s.substring(0, i);
                            String b = s.substring(i, i + j);
                            String c = s.substring(i + j, i + j + m);
                            String d = s.substring(i + j + m, i + j + m + n);
                            // If each part is valid, add it to the result list
                            if (isValid(a) && isValid(b) && isValid(c) && isValid(d)) {
                                result.add(a + "." + b + "." + c + "." + d);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    private static boolean isValid(String part){
        // If the length of this part is not 1 and the first character is 0
        // Or the integer value of this part exceed 255
        // This part is not a valid IP address part
        if ((part.length() != 1 && part.charAt(0) == '0') || (Integer.parseInt(part) > 255)) return false;
        return true;
    }

    public static void main(String[] args) {
        String s = "25525511135";
        List<String> result = restoreIpAddresses(s);
        for (String str : result){
            System.out.print(str + " ");
        }
    }
}
