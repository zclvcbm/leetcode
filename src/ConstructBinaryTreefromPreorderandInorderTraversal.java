/**
 * Created by Admin on 2016/7/27.
 */

import java.util.Arrays;

/**
 * Construct Binary Tree from Preorder and Inorder Traversal
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.

 Subscribe to see which companies asked this question
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder==null || inorder.length==0)
            return null;
        int n = inorder.length;
        int order = preorder[0];
        TreeNode root = new TreeNode(order);
        if(n==1)
            return root;
        int i;
        for(i=0;i<n;i++)
        {
            if(order==inorder[i])
                break;
        }
        root.left = buildTree(Arrays.copyOfRange(preorder,1,i+1),Arrays.copyOfRange(inorder,0,i));
        root.right = buildTree(Arrays.copyOfRange(preorder,i+1,preorder.length),Arrays.copyOfRange(inorder,i+1,inorder.length));
        return root;
    }
}
