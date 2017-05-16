/**
 * Created by udingji on 5/15/17.
 */
public class MergeSortedArray {

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
