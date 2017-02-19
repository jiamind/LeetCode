
/**
 * Created by udingji on 2/3/17.
 */
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        // If the length of the array is less than 2, return 0 since no water will be contained
        if (height.length < 2) return 0;
        // left pointer points to the left starting position, right pointer points to the right starting position.
        // maxArea stores the max possible area of water
        int left = 0, right = height.length - 1, maxArea = 0;

        // While left pointer does not meet with right pointer
        while (left < right){
            // Find the min height at left and right pointers, times the distance to calculate the area. Update maxArea if it's greater than maxArea
            maxArea = Math.max(maxArea, Math.min(height[left],height[right]) * (right - left));
            // Move the side which has the shorter height towards the other pointer
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        // Return the max area
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1,2,1};
        System.out.println(maxArea(height));

    }
}
