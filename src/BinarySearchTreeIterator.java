import java.util.Stack;

/**
 * Created by udingji on 5/14/17.
 */
public class BinarySearchTreeIterator {

    private class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class BSTIterator {

        Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            pushAllLeft(root);
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !stack.empty();
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            TreeNode node = stack.pop();
            pushAllLeft(node.right);
            return node.val;
        }

        private void pushAllLeft(TreeNode node){
            while (node != null){
                stack.push(node);
                node = node.left;
            }
        }
    }
}
