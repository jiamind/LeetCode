import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by udingji on 5/5/17.
 */
public class BinaryTreePostorderTraversal {

    private class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode current = root;
        List<Integer> result = new ArrayList<>();

        while (current != null || !stack.empty()){
            while (current != null){
                stack.push(current);
                current = current.left;
            }

            current = stack.peek();

            if (current.right != null && current.right != prev){
                current = current.right;
            } else {
                result.add(current.val);
                prev = current;
                stack.pop();
                current = null;
            }
        }

        return result;
    }
}
