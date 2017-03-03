/**
 * Created by jmding on 2/28/17.
 */
public class ValidNumber {

    public static boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        char[] array = s.toCharArray();

        boolean numStarted = false, numEnded = false;
        boolean decimalPointFound = false, eFound = false;
        for (int i = 0; i < s.length(); i++) {
            if ((array[i] == '-' || array[i] == '+') && !numStarted && !numEnded){
                numStarted = true;
                if (i == s.length()-1 || (array[i+1] != '.' && (array[i+1] < '0' || array[i+1] > '9'))) return false;
            } else if (array[i] >= '0' && array[i] <= '9' && !numEnded) {
                numStarted = true;
            } else if (array[i] == '.' && !decimalPointFound && !eFound) {
                numStarted = true;
                decimalPointFound = true;
                if ((i == 0 || array[i-1] < '0' || array[i-1] > '9') && (i == s.length()-1 || array[i+1] < '0' || array[i+1] > '9'))
                    return false;
            } else if (array[i] == 'e' && !eFound){
                eFound = true;
                if (i == 0 || (array[i-1] != '.' && (array[i-1] < '0' || array[i-1] > '9')))
                    return false;
                if (i == s.length()-1 || (array[i+1] != '+' && array[i+1] != '-' && (array[i+1] < '0' || array[i+1] > '9')))
                    return false;
            } else if (numStarted && array[i] == ' ') {
                numEnded = true;
                numStarted = false;
            } else if (numEnded && array[i] == ' ' || !numStarted && array[i] == ' ') {
                continue;
            } else if ((array[i] == '-' || array[i] == '+') && (i != 0 && array[i-1] == 'e')){
                if (i == s.length()-1 || (array[i+1] != '.' && (array[i+1] < '0' || array[i+1] > '9'))) return false;
            }
            else {
                return false;
            }
        }
        return numStarted || numEnded;
    }

    public static void main(String[] args) {
        String str = " 005047e+";
        System.out.println(isNumber(str));
    }
}
