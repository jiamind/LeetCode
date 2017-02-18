/**
 * Created by jmding on 1/25/17.
 */
public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int i, j;
        int min = 0, max = nums1.length, half = (nums1.length + nums2.length + 1) / 2;
        while (min <= max) {
            i = (min + max) / 2;
            j = half - i;

            if (i < nums1.length && nums2[j-1] > nums1[i]){
                // i is too small
                min ++;
            } else if (i > 0 && nums1[i-1] > nums2[j]){
                // i is too big
                max --;
            }else {
                int max_left,min_right;
                if (i == 0){
                    max_left = nums2[j-1];
                } else if (j == 0){
                    max_left = nums1[i-1];
                } else {
                    max_left = Math.max(nums1[i-1],nums2[j-1]);
                }

                if ((nums1.length + nums2.length) % 2 == 1){
                    return max_left;
                }

                if (i == nums1.length){
                    min_right = nums2[j];
                } else if (j == nums2.length){
                    min_right = nums1[i];
                } else {
                    min_right = Math.min(nums1[i],nums2[j]);
                }

                return (max_left + min_right) / 2.0;
            }
        }
        return -1.0;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

}
