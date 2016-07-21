/**
 * Created by Admin on 2016/7/21.
 */

/*
Given a linked list, determine if it has a cycle in it.
Follow up:
Can you solve it without using extra space?
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null)
            return false;
        ListNode fast = head.next;
        ListNode slow = head.next.next;
        while(fast!=null && slow!=null){
            if(fast==slow)
                return true;
            else{
                fast = fast.next;
                if(slow.next!=null)
                    slow = slow.next.next;
                else
                    return false;
            }
        }
        return false;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node3;

        LinkedListCycle lc  = new LinkedListCycle();
        System.out.println(lc.hasCycle(head));
    }
}
