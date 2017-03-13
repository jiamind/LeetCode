/**
 * Created by jmding on 3/13/17.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Idea: treat each element in the preorder list as the root. Find the index of that element in the inorder list.
    // Then everything before that index in the inorder list is the left subtree, everything after that index is the right subtree
    // Recursively build the tree

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        return recurBuildTree(0,0,preorder.length - 1,preorder,inorder);
    }

    private static TreeNode recurBuildTree(int preOrderStart, int inOrderStart, int inOrderEnd, int[] preOrder, int[] inOrder){

        // If we reach the end of the preorder list, or start scanning position in the inorder list is greater than the end position
        // Return null
        if (preOrderStart >= preOrder.length || inOrderStart > inOrderEnd){
            return null;
        }

        // Create the root node with the value in the preorder list
        TreeNode node = new TreeNode(preOrder[preOrderStart]);

        // Find the same value in the inorder list
        int index = 0;
        for (int i = inOrderStart; i <= inOrderEnd; i++){
            if (inOrder[i] == preOrder[preOrderStart]){
                index = i;
                break;
            }
        }

        // Link the left node. The next root node would be preOrderStart + 1
        // The starting position in the inOrder list remains the same (scan from the beginning)
        // The end position in the inOrder list is just before that root index we found in the inorder list
        node.left = recurBuildTree(preOrderStart+1, inOrderStart,index - 1,preOrder,inOrder);
        // Link the right node. The next root node would be the current position plus the number of nodes in the left subtree ( index minus the start position in inorder list) plus one
        // The starting position in the inorder list is just after the index
        // The end position in th inOrder list remains the same
        node.right = recurBuildTree(preOrderStart + index - inOrderStart + 1, index + 1, inOrderEnd, preOrder, inOrder);
        return node;
    }
}
