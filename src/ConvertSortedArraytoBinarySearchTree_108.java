/**
 * Created by Admin on 2016/8/15.
 */

/**
 * 108. Convert Sorted Array to Binary Search Tree
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * 解题思路：
 本题的解题主要采用分治+递归实现
 因为所给数组为有序数组，题目要求得到一棵平衡二叉树
 1.得到数组中间位置元素，此元素即为平衡查找树的根节点root
 2.然后递归调用函数让数组前半段、后半段也为平衡查找树
 3.root的左右子树分别为步骤2得到平衡查找树的根节点
 4.返回root节点即为最后构建好的平衡二叉树

 */
public class ConvertSortedArraytoBinarySearchTree_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length==0)
            return null;
        return help(nums,0,nums.length-1);
    }

    public TreeNode help(int[] num, int from, int to)
    {
        if(from<=to)
        {
            int mid = (from+to)/2;
            TreeNode root = new TreeNode(num[mid]);
            root.left = help(num,from,mid-1);
            root.right = help(num,mid+1,to);
            return root;
        }
        return null;
    }
}
