/**
 * Created by Admin on 2016/7/21.
 */
/*
题目描述

Given a binary tree, find its minimum depth.The minimum depth
is the number of nodes along the shortest path from the root
node down to the nearest leaf node.
 */
public class MinimumDepthofBinaryTree {

    public int run(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;
        int left = run(root.left);
        int right = run(root.right);
        if(left==0)
            return right+1;
        else if(right==0)
            return left+1;
        return Math.min(left,right)+1;

    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
//        node2.left = node3;
//        node2.right = node4;
        MinimumDepthofBinaryTree mt = new MinimumDepthofBinaryTree();
        int result = mt.run(root);
        System.out.println(result);
        int result1 = mt.run(null);
        System.out.println(result1);

        TreeNode root1 = new TreeNode(1);
        int result2 = mt.run(root1);
        System.out.println(result2);
    }
}
