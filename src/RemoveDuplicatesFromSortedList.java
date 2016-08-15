/**
 * Created by Admin on 2016/8/4.
 */

/**
 * remove-duplicates-from-sorted-list
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given1->1->2, return1->2.
 * Given1->1->2->3->3, return1->2->3.
 */
public class RemoveDuplicatesFromSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return null;
        ListNode tail = head;
        ListNode cur = tail.next;
        while(cur!=null)
        {
            if(cur.val!=tail.val)
            {
                tail.next = cur;
                tail = tail.next;
                cur = cur.next;
            }
            else{
                cur = cur.next;
            }
        }
        tail.next = cur;
        return head;
    }

    public static void main(String[] args){
        ListNode root = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        deleteDuplicates(root);
//        deleteDuplicates(null);
        deleteDuplicates(node4);
    }
}
