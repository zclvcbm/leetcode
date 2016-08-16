/**
 * Created by Admin on 2016/8/15.
 */
public class ConvertSortedListtoBinarySearchTree_109 {
    public static TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        return help(head);
    }

    public static TreeNode help(ListNode head)
    {
        if(head==null)
            return null;
        ListNode a = head;
        ListNode b = head;
        ListNode temp = a;
        for(;b.next!=null && b.next.next!=null;b=b.next.next,temp=a,a=a.next)
            ;
        b = a.next;
        TreeNode root = new TreeNode(a.val);
        temp.next = null;
        if(head==a)
        {
            root.left = null;
        }else{
            root.left = help(head);
        }
        root.right = help(b);
        return root;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(9);
        head.next = node1;
        node1.next = node2;
        sortedListToBST(head);
    }
}
