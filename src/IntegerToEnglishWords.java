/**
 * Created by udingji on 5/11/17.
 */
public class IntegerToEnglishWords {

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
