import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Admin on 2016/8/13.
 */

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */
public class PathSumII_113 {
    public static ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null)
            return result;
        help(root,sum,new ArrayList<Integer>());
        return result;
    }

    public static void help(TreeNode root, int sum, ArrayList<Integer> list)
    {
        if(root.left==null && root.right==null && root.val==sum)
        {
            list.add(root.val);
            result.add(list);
        }else{
            list.add(root.val);
            if(root.left!=null)
                help(root.left,sum-root.val,new ArrayList<Integer>(list));
            if(root.right!=null)
                help(root.right,sum-root.val,new ArrayList<Integer>(list));
        }
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
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;
        pathSum(root,22);
    }
}
