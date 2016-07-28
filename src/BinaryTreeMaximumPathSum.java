/**
 * Created by Admin on 2016/7/27.
 */

/**
 * Binary Tree Maximum Path Sum
 *
 * Given a binary tree, find the maximum path sum.

 For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.

 For example:
 Given the below binary tree,

 1
 / \
 2   3
 Return 6.

 */
public class BinaryTreeMaximumPathSum {
    public static int max;
    public int maxPathSum(TreeNode root) {
        if(root==null)
            return 0;
        max = root.val;
        help(root);
        return max;
    }

    public int help(TreeNode root){
        if(root==null)
            return 0;
        int left = help(root.left);
        int right = help(root.right);
        int ret = (Math.max(Math.max(left,right),0)+root.val);
        max = Math.max(Math.max(ret,max),left+right+root.val);
        return ret;
    }
}
