package test;

/**
 * Created by udingji on 2/17/17.
 */
public class MultiplyStrings {

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        if (num1.equals("1")) return num2;
        if (num2.equals("1")) return num1;

        int len1 = num1.length(), len2 = num2.length();

        StringBuilder sb = new StringBuilder();
        int carryOver = 0;
        for (int i = 0; i < len1 + len2; i++){
            int p1 = i, p2 = 0;
            while (num1.length()-1 < p1){
                p1--;
                p2++;
            }
            if (p2 > num2.length()-1) continue;
            int sum = 0;
            while (p1 >= 0 && p2 < num2.length()){
                sum += Character.getNumericValue(num1.charAt(num1.length()-1-p1)) * Character.getNumericValue(num2.charAt(num2.length()-1-p2));
                p1--;
                p2++;
            }
            sum += carryOver;
            carryOver = sum / 10;

            sb.insert(0,String.valueOf(sum%10));
        }
        if (carryOver != 0){
            sb.insert(0,String.valueOf(carryOver));
        }
        return sb.toString();
    }

    public static String multiply2(String num1, String num2) {
        int[] pos = new int[num1.length() + num2.length()];

        for(int i = num1.length() - 1; i >= 0; i--) {
            for(int j = num2.length() - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "99";
        String num2 = "99";
        long start = System.currentTimeMillis();
        System.out.println(multiply2(num1,num2));
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
