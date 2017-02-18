package test;

/**
 * Created by udingji on 2/1/17.
 */
public class StringToInteger {

    public static int myAtoi(String str) {

        if (str.trim().isEmpty()) return 0;
        int result = 0;
        boolean isNegative = false;
        boolean started = false;

        for (int i = 0; i < str.length(); i++) {
            if (!started && str.charAt(i) == '-') {
                started = true;
                isNegative = true;
                continue;
            }else if (!started && str.charAt(i) == '+'){
                started = true;
                continue;
            }
            if (!started && str.charAt(i) == ' '){
                continue;
            }
            int value = Character.getNumericValue(str.charAt(i));
            if (value > 9 || value < 0){
                return result;
            }
            if ((Integer.MAX_VALUE - value) / 10 < result){
                return Integer.MAX_VALUE;
            }
            if ((Integer.MIN_VALUE + value) / 10 > result){
                return Integer.MIN_VALUE;
            }
            started = true;
            if (isNegative){
                result = result * 10 - value;
            }else {
                result = result * 10 + value;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "  +0 123";
        System.out.println(myAtoi(str));
    }
}
