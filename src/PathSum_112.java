/**
 * Created by Admin on 2016/8/8.
 */


/**
 * Path Sum
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
     5
   /  \
  4    8
 /    / \
 11  13  4
 / \      \
 7  2      1
 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

 */
public class PathSum_112 {
    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
        if(root.val==sum && root.left==null && root.right==null)
            return true;
        return hasPathSum(root.left,sum-root.val)
                || hasPathSum(root.right,sum-root.val);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.right = node8;
        System.out.println(hasPathSum(root,22));
        System.out.println(hasPathSum(root,23));
        System.out.println(hasPathSum(root,27));
        System.out.println(hasPathSum(root,26));
        System.out.println(hasPathSum(root,18));
        System.out.println(hasPathSum(root,13));
        System.out.println(hasPathSum(null,0));
    }
}
