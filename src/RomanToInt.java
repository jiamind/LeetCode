import java.util.HashMap;
import java.util.Map;

/**
 * Created by udingji on 2/4/17.
 */
public class RomanToInt {

    public static int romanToInt(String s) {

        int result = 0;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            char nc;
            switch (c) {
                case 'M':
                    result += 1000;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'C':
                    if (i + 1 < s.length()) {
                        nc = s.charAt(i + 1);
                        if (nc == 'D') {
                            result += 400;
                            i++;
                            break;
                        } else if (nc == 'M') {
                            result +=900;
                            i++;
                            break;
                        }
                    }
                    result += 100;
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'X':
                    if (i + 1 < s.length()) {
                        nc = s.charAt(i + 1);
                        if (nc == 'L') {
                            result += 40;
                            i++;
                            break;
                        } else if (nc == 'C') {
                            result += 90;
                            i++;
                            break;
                        }
                    }
                    result += 10;
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'I':
                    if (i + 1 < s.length()) {
                        nc = s.charAt(i + 1);
                        if (nc == 'V') {
                            result += 4;
                            i++;
                            break;
                        } else if (nc == 'X') {
                            result += 9;
                            i++;
                            break;
                        }
                    }
                    result += 1;
                    break;
                default:
                    break;
            }
            i++;
        }
        return result;
    }


    public static int romanToInt2(String s) {
        int res = 0;
        // Scan from the right of s to the left
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    // If the result is greater than 5, it means this 'I' is a part of 'IV' (4).
                    // Previously we added 5 to the result. Now we need to subtract 1 to make it 4
                    // Otherwise, 'I' means 'I' (1)
                    res += (res >= 5 ? -1 : 1);
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    // If the result is greater than 50, it means this 'X' is a part of 'XL' (40).
                    // Previously we added 50 to the result. Now we need to subtract 10 to make it 40
                    // Otherwise, 'X' means 'X' (10)
                    res += 10 * (res >= 50 ? -1 : 1);
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    // If the result is greater than 500, it means this 'X' is a part of 'CD' (400).
                    // Previously we added 500 to the result. Now we need to subtract 100 to make it 400
                    // Otherwise, 'C' means 'C' (500)
                    res += 100 * (res >= 500 ? -1 : 1);
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "CCCLXXXIII";
        System.out.println(romanToInt(s));
    }
}
