/**
 * Created by Admin on 2016/7/29.
 */
public class MergeTwoSortedLists {

    public static void main(String[] args){
        ListNode root1 = new ListNode(1);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(6);
        root1.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode root2 = new ListNode(2);
        ListNode node21 = new ListNode(3);
        ListNode node22 = new ListNode(5);
        ListNode node23 = new ListNode(7);
        root2.next = node21;
        node21.next = node22;
        node22.next = node23;
//        mergeTwoLists(root1,root2);

//        mergeTwoLists(null,null);

        mergeTwoLists(new ListNode(3),null);

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        else if(l2==null)
            return l1;
        ListNode p = l1;
        ListNode q = l2;
        ListNode head;
        if(l1.val<=l2.val)
        {
            head = l1;
            l1 = l1.next;
        }else{
            head = l2;
            l2 = l2.next;
        }
        ListNode tail = head;

        while(l1!=null && l2!=null)
        {
            if(l1.val<=l2.val)
            {
                tail.next = l1;
                tail = tail.next;
                l1 = l1.next;
            }else{
                tail.next = l2;
                tail = tail.next;
                l2 = l2.next;
            }
        }
        if(l1!=null)
            tail.next = l1;
        if(l2!=null)
            tail.next = l2;
        return head;
    }
}
