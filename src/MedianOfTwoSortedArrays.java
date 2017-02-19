/**
 * Created by jmding on 1/25/17.
 */
public class MedianOfTwoSortedArrays {

    //Idea: If we cut the sorted array into two halves with equal length, then any number in the upper half is always greater than any number in the lower half
    //       left_part          |        right_part
    // A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
    // B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]

    // (1) i + j == m - i + n - j (or: m - i + n - j + 1)
    //      if n >= m, we just need to set: i = 0 ~ m, j = (m + n + 1)/2 - i
    // (2) B[j-1] <= A[i] and A[i-1] <= B[j]

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Swith nums1 and nums2 if the length of num1 is greater than the length of nums2.
        // Otherwise will throw error indexOutOfBound on nums2
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        // i is the cut point of nums1, j is the cut point of nums2
        int i, j;
        // min is the start index of nums1. max is the end index of nums1, half is the half size of the combined array
        int min = 0, max = nums1.length, half = (nums1.length + nums2.length + 1) / 2;
        while (min <= max) {
            // Choose the mid as the cut point of nums1
            i = (min + max) / 2;
            // The cut point of nums2 will be the rest of the half size
            j = half - i;

            if (i < nums1.length && nums2[j - 1] > nums1[i]) {
                // i is too small
                min++;
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                // i is too big
                max--;
            } else {
                int max_left, min_right;
                if (i == 0) {
                    // There is nothing on the left side of cut point in nums1
                    max_left = nums2[j - 1];
                } else if (j == 0) {
                    // There is nothing on the left side of cut point in nums2
                    max_left = nums1[i - 1];
                } else {
                    // Pick the largest value to the left of the cut point
                    max_left = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                // If the length of combined array is odd, just return the max left
                if ((nums1.length + nums2.length) % 2 == 1) {
                    return max_left;
                }

                if (i == nums1.length) {
                    // If there is nothing on the right side of nums1
                    min_right = nums2[j];
                } else if (j == nums2.length) {
                    // If there is nothing on the right side of nums2
                    min_right = nums1[i];
                } else {
                    // Pick the smallest value to the left of the cut point
                    min_right = Math.min(nums1[i], nums2[j]);
                }
                // Return the mean
                return (max_left + min_right) / 2.0;
            }
        }
        return -1.0;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

}
