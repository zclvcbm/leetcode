/**
 * Created by Admin on 2016/7/29.
 */

/**
 * Odd Even Linked List
 *
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

 You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

 Example:
 Given 1->2->3->4->5->NULL,
 return 1->3->5->2->4->NULL.

 Note:
 The relative order inside both the even and odd groups should remain as it was in the input.
 The first node is considered odd, the second node even and so on ...
 */
public class OddEvenLinkedList {
    public static ListNode oddEvenList(ListNode head) {
        if(head==null)
            return null;
        ListNode tail = head, h = head.next, t = h;
        while(t!=null)
        {
            tail.next = t.next;
            // tail = tail.next;
            // if(taill==null)
            //     break;
            if(tail.next==null) //保证tail指向奇数结点最后一个结点，而不是超出链表
                break;
            else
                tail = tail.next;
            t.next = tail.next;
            t = t.next;
        }
        tail.next = h;
        if(t!=null)            //如果链表长度为奇数，t.next非空，需要将其next设置为null
            t.next = null;
        return head;
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
//        oddEvenList(root);
        oddEvenList(null);
    }
}
