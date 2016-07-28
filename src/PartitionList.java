/**
 * Created by Admin on 2016/7/26.
 */

/*
Partition List

Given a linked list and a value x, partition it such that all
nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes
in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.

思路：将原始链拆分成小于3和大于等3的链表，然后再将两个链表链接起来
 */
public class PartitionList {


    public static ListNode partition(ListNode head, int x) {

        if(head==null)
            return null;
        ListNode h1=null,t1=null,h2=null,t2=null; //分别标记两个链表的头尾节点
        while(head!=null){
            if(head.val<x){
                if(t1!=null){
                    t1.next = head;
                    t1 = t1.next;
                }else{
                    h1 = head;
                    t1 = head;
                }
            }else{
                if(t2!=null){
                    t2.next = head;
                    t2 = t2.next;
                }
                else{
                    h2 = head;
                    t2 = head;
                }
            }
            head = head.next;
        }
        if(t2!=null){
            t2.next = null;
        }
        if(t1!=null)
        {
            t1.next = h2;
        }
        return h1!=null?h1:h2;
    }

    public static void main(String[] args){
      //  1->4->3->2->5->2
        ListNode root = new ListNode(1);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(2);
        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        partition(root,3);
    }
}
