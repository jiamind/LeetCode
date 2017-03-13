/**
 * Created by udingji on 3/13/17.
 */
public class ConvertSortedArrayToBinarySearchTree {

    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    // Idea: Get the mid number in the array as the root, numbers before mid are the left sub tree, numbers after mid are the right sub tree
    // Repeat the process for each left and right sub array
    public static TreeNode sortedArrayToBST(int[] nums) {

        // If the array is null or empty, return null
        if (nums == null || nums.length == 0)
            return null;

        return recurSortedArrayToBST(nums,0,nums.length-1);
    }

    private static TreeNode recurSortedArrayToBST(int[] nums, int start, int end){
        // If the array start position is greater than the array end position, we reach the end of the sub tree. return null.
        if (start > end)
            return null;

        // Get the mid number in the sub array
        int mid = start + (end-start+1)/2;
        // Create the root node
        TreeNode root = new TreeNode(nums[mid]);

        // Recursive call on the left sub tree and right sub tree
        root.left = recurSortedArrayToBST(nums,start,mid-1);
        root.right = recurSortedArrayToBST(nums,mid+1,end);

        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        sortedArrayToBST(nums);

        System.out.println("done");
    }
}
