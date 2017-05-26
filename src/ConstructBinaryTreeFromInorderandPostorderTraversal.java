import java.util.HashMap;

/**
 * Created by udingji on 3/13/17.
 */
public class ConstructBinaryTreeFromInorderandPostorderTraversal {

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Idea: treat each element in the postorder list as the root. (The last element in the postorder list is the root)
    // Find the index of that element in the inorder list.
    // Then everything before that index in the inorder list is the left subtree, everything after that index is the right subtree
    // Recursively build the tree
    private static TreeNode buildTree(int[] inorder, int[] postorder) {

        // Create a hashmap to store the value and index of the node in inorder list for fast O(1) search time
        HashMap<Integer,Integer> inOrderRoots = new HashMap<>();
        for (int i = 0; i < inorder.length; i++){
            inOrderRoots.put(inorder[i],i);
        }

        // Scan in the postorder list from the end
        return recurBuildTree(postorder.length-1, 0,inorder.length-1,postorder,inOrderRoots);
    }

    private static TreeNode recurBuildTree(int postOrderStart, int inOrderStart, int inOrderEnd, int[] postOrder, HashMap<Integer,Integer> inOrderRoots){

        // If we reach the beginning of the postorder list, or the starting position of inorder list is greater than the end position of inorder list
        if (postOrderStart < 0 || inOrderStart > inOrderEnd){
            return null;
        }

        // Create the root node with the current node in postorder list
        TreeNode treeNode = new TreeNode(postOrder[postOrderStart]);
        // Get the index of the current root in the inorder list
        int index = inOrderRoots.get(postOrder[postOrderStart]);
        // Link the left node
        // The starting position in the postorder list would be the current position minus the number of right sub nodes minus 1
        // The starting position in the inorder list remains the same. The ending position is just before the index (current root in inorder list)
        treeNode.left = recurBuildTree(postOrderStart - (inOrderEnd - index) - 1, inOrderStart, index-1,postOrder,inOrderRoots);
        // Link the right node
        // The starting position in the postorder list is just before the current root in the postorder list (postorder: left -> [right] -> root)
        // The starting position in the inorder list is just after the index (current root in the inorder list)
        // The ending position in the inorder list remains the same
        treeNode.right = recurBuildTree(postOrderStart-1,index+1,inOrderEnd,postOrder,inOrderRoots);
        return treeNode;
    }
}
