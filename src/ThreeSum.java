import java.util.*;

/**
 * Created by jmding on 2/5/17.
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
//        Arrays.sort(nums);
//        int j = 0, i = 1;
//        while (i < nums.length){
//            if (nums[i] == nums[j]){
//                i++;
//            }else {
//                j++;
//                nums[j] = nums[i];
//                i++;
//            }
//        }
//        nums = Arrays.copyOf(nums,j+1);
        if (nums.length < 3) return result;
        if (nums.length == 3){
            if(nums[0] + nums[1] + nums[2] == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[0]);
                list.add(nums[1]);
                list.add(nums[2]);
                result.add(list);
                return result;
            }
        }

        Arrays.sort(nums);
        int index = 0, left = 1, right = nums.length - 1;
        while (index < nums.length - 2 && nums[index] <= 0){
            while (left<right){
                int sum = nums[left] + nums[index] + nums[right];
                if (sum < 0){
                    left++;
                }else if (sum > 0){
                    right--;
                }else{
                    result.add(Arrays.asList(nums[index],nums[left],nums[right]));
                    while (left < right && nums[left] == nums[left+1]) left++;
                    left++;
                    while (right > left && nums[right] == nums[right-1]) right--;
                    right--;
                }
            }
            while (index < nums.length - 1 && nums[index] == nums[index+1]) index++;
            index++;
            left = index+1;
            right = nums.length -1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,0};
        List<List<Integer>> result = threeSum(nums);
        if (result != null){
            System.out.println("[");
            for (List<Integer> list: result){
                System.out.print("[");
                for (int n : list){
                    System.out.print(n + ", ");
                }
                System.out.println("],");
            }
            System.out.println("]");
        }
    }
}
