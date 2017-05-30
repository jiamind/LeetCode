/**
 * Created by udingji on 5/15/17.
 */
public class MergeSortedArray {

    // Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

    // Note:
    // You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        // Fill nums1 from the right. Fill with the greater value of num1 and num2 and move both pointers to the left. Until one of them reaches the head
        while (i >= 0 && j >= 0)
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        // If num2 reaches the head first, we are finished (the rest of num1 are already in place)
        // If num1 reaches the head first, fill the rest of num1 with num2
        while (j >= 0)
            nums1[k--] = nums2[j--];
    }
}
