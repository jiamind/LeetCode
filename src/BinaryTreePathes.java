import java.util.ArrayList;
import java.util.List;

/**
 * Created by udingji on 5/12/17.
 */
public class BinaryTreePathes {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null)
            return result;
        helper(root,result,"");
        return result;
    }

    private static void helper(TreeNode node, List<String> result, String path){
        path += ((path == "" ? "" : "->") + node.val);
        // Terminate condition: the current node has no left or right node. We reach the leaf
        if (node.left == null && node.right == null){
            result.add(path);
        } else {
            if (node.left != null)
                helper(node.left,result,path);
            if (node.right != null)
                helper(node.right,result,path);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);

        root.left = n2;
        root.right = n3;
        n2.right = n5;

        List<String> result = binaryTreePaths(root);

        for (String str : result){
            System.out.println(str);
        }
    }
}
