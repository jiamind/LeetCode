import java.util.ArrayList;
import java.util.List;

/**
 * Created by udingji on 5/12/17.
 */
public class ExpressionAddOperators {

    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        char[] array = num.toCharArray();
        helper(result,"",array,0,target,0,0);
        return result;
    }

    // path: the expression so far
    // position: start index of the current new number
    // evaluation: the result/evaluation of the current expression
    // prev: the previous evaluation. If we performed addition, prev is the previous number; if we performed subtraction, prev is the negative of the previous number
    // If we performed multiplication, prev is the whole multiplication chain
    private void helper(List<String> result, String path, char[] array, int position, int target, long evaluation, long prev){
        if (position == array.length){
            if (evaluation == target)
                result.add(path);
        } else {
            // From the current position, form any length of new number until reach the end of the array
            for (int i = position; i < array.length; i++){
                // if we are not at the first digit, and the first digit is 0, this is not a valid number (e.g. 055)
                if (i != position && array[position] == '0') break;
                // Get the current number
                long current = Long.valueOf(new String(array,position,i-position+1));
                // If we are at the head of the array, this is the first number and there is no number before
                if (position == 0){
                    helper(result,path + current, array, i + 1, target, current, current);
                } else {
                    helper(result,path + "+" + current, array,i + 1, target, evaluation + current, current);
                    helper(result, path + "-" + current, array, i + 1, target, evaluation - current, -current);
                    helper(result, path + "*" + current, array, i + 1, target, evaluation - prev + prev * current, prev * current);
                }
            }
        }
    }
}
