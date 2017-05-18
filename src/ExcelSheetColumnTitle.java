/**
 * Created by udingji on 5/18/17.
 */
public class ExcelSheetColumnTitle {


    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        char base = 'A' - 1;

        while (n > 0){
            if (n / 26 > 0 && n % 26 == 0) {
                n -= 26;
                sb.insert(0, "Z");
            }else {
                sb.insert(0, (char) (base + n % 26));
            }
            n /= 26;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        for (int i = 1; i < 60; i++){
            System.out.println(convertToTitle(i));
        }
    }
}
