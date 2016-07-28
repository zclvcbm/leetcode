import java.util.Arrays;

/**
 * Created by Admin on 2016/7/27.
 */

/**
 * Construct Binary Tree from Inorder and Postorder Traversal
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.

 Subscribe to see which companies asked this question
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {

    public static TreeNode buildTree(int[] inorder, int[] postorder){
        if(inorder==null || inorder.length==0)
            return null;
        int n = inorder.length;
        int order = postorder[n-1];
        TreeNode root = new TreeNode(order);
        if(n==1)
            return root;
        int i;
        for(i=0;i<n;i++)
        {
            if(order==inorder[i])
                break;
        }
        int[] la = Arrays.copyOfRange(inorder,0,i);
        int[] ra = Arrays.copyOfRange(postorder,0,i);
        int[] larray = Arrays.copyOfRange(inorder,i+1,inorder.length);
        int[] rarray = Arrays.copyOfRange(postorder,i,postorder.length-1);
        root.left = buildTree(Arrays.copyOfRange(inorder,0,i),Arrays.copyOfRange(postorder,0,i));
        root.right = buildTree(Arrays.copyOfRange(inorder,i+1,inorder.length),Arrays.copyOfRange(postorder,i,postorder.length-1));
        return root;
    }

    public static void main(String[] args){
        int[] array1 = {2,3,4,1,5};
        int[] array2 = {2,4,5,1,3};
        TreeNode root = buildTree(array1,array2);
//        int[] t = Arrays.copyOfRange(array,0,3);
        System.out.println();
    }
}
