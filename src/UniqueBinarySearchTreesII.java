import java.util.ArrayList;
import java.util.List;

/**
 * Created by jmding on 3/5/17.
 */
public class UniqueBinarySearchTreesII {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<TreeNode> generateTrees(int n) {

        if (n == 0) return new ArrayList<>();
        return recurGenerateTrees(1,n);
    }

    private static List<TreeNode> recurGenerateTrees(int start, int end){

        List<TreeNode> list = new ArrayList<>();

        if (start > end){
            list.add(null);
            return list;
        }

        List<TreeNode> left, right;
        for (int i = start; i <= end; i++){

            left = recurGenerateTrees(start, i-1);
            right = recurGenerateTrees(i+1, end);

            for (TreeNode lnode : left){
                for (TreeNode rnode : right){
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }
        }
        return list;
    }

}
