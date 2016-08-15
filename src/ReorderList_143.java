import javax.swing.*;
import java.util.List;

/**
 * Created by Admin on 2016/7/26.
 */

/*
reorder-list

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
You must do this in-place without altering the nodes' values.
For example,
Given{1,2,3,4}, reorder it to{1,4,2,3}.
 */
public class ReorderList_143 {
    public static void reorderList(ListNode head) {
        if(head==null || head.next==null)
            return;
        ListNode a = head;
        ListNode b = head;
        for(;b.next!=null && b.next.next!=null;b=b.next.next,a=a.next)
            ;
        b = a.next;
        a.next = null;
        a = head;

        ListNode result = null;
        while(b!=null)
        {
            ListNode temp = b.next;
            b.next = result;
            result = b;
            b = temp;
        }
        b = result;
        ListNode tail=null;
        while(a!=null && b!=null)
        {
            if(tail!=null)
            {
                tail.next = a;
                tail = tail.next;
            }else{
                tail = a;
                head = tail;
            }
            a = a.next;

            tail.next = b;
            tail = tail.next;
            b = b.next;
        }
        if(a!=null) {
            tail.next = a;
        }
    }

    public static void main(String[] args){
        ListNode root = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;
        reorderList(root);
    }
}
