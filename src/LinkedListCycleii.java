/**
 * Created by Admin on 2016/7/21.
 */
/*
linked-list-cycle-ii

题目描述

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
Follow up:
Can you solve it without using extra space?
 */
public class LinkedListCycleii {

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
        node4.next = node2;

        LinkedListCycleii lc = new LinkedListCycleii();
        ListNode resNode = lc.detectCycle(head);
        System.out.println(resNode.val);
    }

    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null)
            return null;
        ListNode fast = head.next;
        ListNode slow = head.next.next;
        while(fast!=null && slow!=null){
            if(fast==slow){
                break;
            }else{
                fast = fast.next;
                if(slow.next!=null)
                    slow = slow.next.next;
                else
                    return null;
            }
        }
        if(fast!=null && slow!=null)
        {
            fast = head;
            while (fast!=slow){
                fast =fast.next;
                slow = slow.next;
            }
            return fast;
        }
        else
            return null;
    }
}
