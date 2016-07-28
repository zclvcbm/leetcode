/**
 * Created by Admin on 2016/7/27.
 */

/**
 * Balanced Binary Tree
 *
 * Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

 Subscribe to see which companies asked this question
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        int left = depthTree(root.left);
        int right = depthTree(root.right);
        if(left>=right-1 && left<=right+1)
        {
            return isBalanced(root.left)&&isBalanced(root.right);
        }else{
            return false;
        }
    }

    public int depthTree(TreeNode root)
    {
        if(root==null)
            return 0;
        else{
            return Math.max(depthTree(root.left),depthTree(root.right))+1;
        }
    }
}
