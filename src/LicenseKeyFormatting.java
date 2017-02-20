/**
 * Created by jmding on 2/20/17.
 */
public class LicenseKeyFormatting {

    public static String licenseKeyFormatting(String S, int K) {
        if (K <= 0) return S;
        StringBuilder sb = new StringBuilder();
        // Iterate through the string starting from the right
        for (int i = S.length() - 1; i >= 0; i--){
            // If the character at i is not '-'
            if (S.charAt(i) != '-'){
                // A group is K characters plus one '-', which is (K+1). '-' is inserted at Kth position
                if (sb.length() % (K+1) == K){
                    sb.append('-');
                }
                sb.append(S.charAt(i));
            }
        }
        return sb.reverse().toString().toUpperCase();
    }

    public static void main(String[] args) {
        String S = "--a-a-a-a--";
        int K = 2;
        System.out.printf(licenseKeyFormatting(S,K));
    }
}
