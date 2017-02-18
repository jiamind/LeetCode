package test;

/**
 * Created by udingji on 2/3/17.
 */
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        if (height.length < 2) return 0;
        int left = 0, right = height.length - 1, maxArea = 0;

        while (left < right){
            maxArea = Math.max(maxArea, Math.min(height[left],height[right]) * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1,2,1};
        System.out.println(maxArea(height));

    }
}
