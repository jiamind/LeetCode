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


    // Idea: Post order traverse the tree using stack. Also keep track of the prev traversed node
    // If we traverse down the tree, push its left node into the stack first, then push the right node, then add its value to the result list
    // If we traverse up the tree (from left node), push any right node to the stack (post-order), then add its value to the result list
    // If we traverse up the tree from right node, just add the value to the result list.
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        Stack<TreeNode> stack = new Stack<>();

        TreeNode prev = null;

        stack.push(root);

        while (!stack.empty()){
            TreeNode node = stack.peek();

            if (prev == null || prev.left == node || prev.right == node){
                if (node.left != null){
                    stack.push(node.left);
                } else if (node.right != null){
                    stack.push(node.right);
                } else {
                    stack.pop();
                    result.add(node.val);
                }
            } else if (node.left == prev){
                if (node.right != null){
                    stack.push(node.right);
                }else {
                    stack.pop();
                    result.add(node.val);
                }
            } else if (node.right == prev){
                stack.pop();
                result.add(node.val);
            }

            prev = node;
        }

        return result;
    }
}
