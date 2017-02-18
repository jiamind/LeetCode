package test;


/**
 * Created by udingji on 2/16/17.
 */
public class CountAndSay {

    public static String countAndSay(int n) {
        if (n == 1) return "1";
        String str = countAndSay(n-1);
        return sayNum(str);
    }

    private static String sayNum(String n){
        StringBuilder sb = new StringBuilder();
        Character temp = null;
        int count = 0;
        for (int i = 0; i < n.length(); i++){
            char c = n.charAt(i);
            if (temp == null || temp != c){
                if (temp != null){
                    sb.append(count);
                    sb.append(temp);
                }
                temp = c;
                count = 1;
            }else {
                count ++;
            }
        }
        sb.append(count);
        sb.append(temp);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
}
