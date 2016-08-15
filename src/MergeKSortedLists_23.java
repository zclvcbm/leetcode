/**
 * Created by Admin on 2016/8/8.
 */
public class MergeKSortedLists_23 {
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0)
            return null;
        if(lists.length==1)
            return lists[0];

        int n = lists.length;
        for(int i=1;i<n;i++)
        {
            lists[0] = mergeTwoLists(lists[0],lists[i]);
        }
        return lists[0];
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

    public static void main(String[] args){
        ListNode root1 = new ListNode(1);
        ListNode node11 = new ListNode(3);
        ListNode node12 = new ListNode(4);
        ListNode node13 = new ListNode(6);
        ListNode node14 = new ListNode(7);
        root1.next = node11;
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;

        ListNode root2 = new ListNode(2);
        ListNode node21 = new ListNode(3);
        ListNode node22 = new ListNode(5);
        ListNode node23 = new ListNode(6);
        ListNode node24 = new ListNode(8);
        root2.next = node21;
        node21.next = node22;
        node22.next = node23;
        node23.next = node24;

        ListNode root3 = new ListNode(0);
        ListNode node31 = new ListNode(8);
        ListNode node32 = new ListNode(9);
        ListNode node33 = new ListNode(16);
        ListNode node34 = new ListNode(18);
        root3.next = node31;
        node31.next = node32;
        node32.next = node33;
        node33.next = node34;

        ListNode[] listNodes = {root1,root2,root3};
        mergeKLists(listNodes);
    }
}
