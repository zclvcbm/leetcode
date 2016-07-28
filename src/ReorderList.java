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
public class ReorderList {
    public static void reorderList(ListNode head) {
        if(head==null)
            return ;
        int len = 0;
        ListNode p = head;
        while(p!=null)
        {
            p = p.next;
            len++;
        }
        int mid = (len+1)/2;
        p = head;
        ListNode q = head;
        int i=0;
        while(i<mid)
        {
            q = q.next;
            i++;
        }

        ListNode result=null;
        while(q!=null)
        {
            ListNode temp = q.next;
            q.next = result;
            result = q;
            q = temp;
        }

        for(i=0;i<(len/2)-1;i++){
            p = p.next;
        }
        p.next = null;
        p = head;

        q = result;
        for(i=0;i<len/2;i++){
            ListNode temp = q.next;
            q.next = p.next;
            p.next = q;
            p = p.next.next;
            q = temp;
        }
        System.out.println();
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
        node4.next = node5;
        reorderList(root);
    }
}
