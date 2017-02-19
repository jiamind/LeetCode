/**
 * Created by udingji on 2/4/17.
 */
public class IntegerToRoman {

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int th = 0, h = 0, t = 0, s = 0;

        th = num / 1000;
        for (int i = 0; i < th; i++)
            sb.append('M');
        num -= th * 1000;

        h = num / 100;
        if (h < 4){
            for (int i = 0; i < h; i++)
                sb.append('C');
        }else if (h == 4){
            sb.append("CD");
        }else if (h == 9) {
            sb.append("CM");
        }else {
            sb.append("D");
            for (int i = 0; i < h-5; i++)
                sb.append("C");
        }
        num -= h * 100;

        t = num / 10;
        if (t < 4){
            for (int i = 0; i < t; i++)
                sb.append('X');
        }else if (t == 4){
            sb.append("XL");
        }else if (t == 9) {
            sb.append("XC");
        }else{
            sb.append("L");
            for (int i = 0; i < t-5; i++)
                sb.append("X");
        }
        num -= t * 10;

        if (num < 4){
            for (int i = 0; i < num; i++)
                sb.append('I');
        }else if (num == 4){
            sb.append("IV");
        }else if (num == 9) {
            sb.append("IX");
        }else{
            sb.append("V");
            for (int i = 0; i < num-5; i++)
                sb.append("I");
        }

        return sb.toString();
    }

    public static String intToRoman2(int num) {
        // M = 1000
        String M[] = {"", "M", "MM", "MMM"};
        // C = 100, D = 500
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        // X = 10, L = 50
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        // I = 1, V = 5
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }

    public static void main(String[] args) {
        int num = 9;
        System.out.println(intToRoman(num));
    }
}
