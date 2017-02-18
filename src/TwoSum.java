import java.util.Hashtable;

/**
 * Created by jmding on 1/22/17.
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target){
        Hashtable hashtable = new Hashtable<Integer,Integer>();
        for (int i = 0; i < nums.length; i++){
            int num = nums[i];
            if (hashtable.containsKey(num)){
                return (Integer) hashtable.get(num) > i ? new int[]{i,(Integer) hashtable.get(num)} : new int[]{(Integer) hashtable.get(num),i};
            }
                if (!hashtable.containsKey(target-num)){
                    hashtable.put(target-num,i);
                }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,-2,-3,-4,-5};
        int[] r = twoSum(nums,-8);
        if (r != null && r.length > 1) {
            System.out.println("[" + r[0] + "," + r[1] + "]");
        }else {
            System.out.println("not found");
        }
    }
}
