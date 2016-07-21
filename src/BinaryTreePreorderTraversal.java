import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2016/7/21.
 */
public class BinaryTreePreorderTraversal {

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        BinaryTreePreorderTraversal bt = new BinaryTreePreorderTraversal();
        bt.preorderTraversal(root);
        bt.preorderTraversal(null);
    }

    public ArrayList<Integer> preorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<Integer>();
        if(root==null)
            return (ArrayList)list;
        traversal(root,list);
        return (ArrayList)list;
    }

    public void traversal(TreeNode root,List<Integer> list){
        if(root==null)
            return ;
        list.add(root.val);
        if(root.left!=null)
            traversal(root.left,list);
        if(root.right!=null)
            traversal(root.right,list);
    }
}
