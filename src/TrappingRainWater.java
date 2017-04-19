
/**
 * Created by udingji on 2/17/17.
 */
public class TrappingRainWater {

    // Idea: use two pointers to scan towards each other from the start and end point of the height array
    // Store the max height on the left and right side
    // Update the volume base on the volume difference to the max on the left and right
    public static int trap(int[] height) {
        if (height.length < 3) return 0;

        int leftMax = 0, rightMax = 0, result = 0, left = 0, right = height.length - 1;
        while (left < right){
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            if (leftMax < rightMax){
                result += leftMax - height[left];
                left++;
            }else {
                result += rightMax - height[right];
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
