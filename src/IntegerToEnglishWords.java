/**
 * Created by udingji on 5/11/17.
 */
public class IntegerToEnglishWords {

    // Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

    // For example,
    // 123 -> "One Hundred Twenty Three"
    // 12345 -> "Twelve Thousand Three Hundred Forty Five"
    // 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

    static String[] lessThanTwenty = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    static String[] tens = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    static String[] thousands = {"", "Thousand","Million","Billion"};

    public static String numberToWords(int num) {

        if (num == 0)
            return "Zero";

        String result = "";
        int i = 0;
        while (num > 0){

            if (num % 1000 != 0){
                result = helper(num % 1000) + thousands[i] + " " + result;
            }
            num /= 1000;
            i++;
        }

        return result.trim();
    }

    private static String helper(int num){
        if (num == 0){
            return "";
        } else if (num < 20){
            return lessThanTwenty[num] + " ";
        } else if (num < 100) {
            return tens[num/10] + " " + helper(num%10);
        } else {
            return lessThanTwenty[num/100] + " Hundred " + helper(num%100);
        }
    }

    public static void main(String[] args) {
        int num = 1234567;
        System.out.println(numberToWords(num));
    }
}
