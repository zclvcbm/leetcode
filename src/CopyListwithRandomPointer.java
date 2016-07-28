/**
 * Created by Admin on 2016/7/26.
 */
/*
Copy List with Random Pointer

A linked list is given such that each node contains an additional random pointer
which could point to any node in the list or null.

Return a deep copy of the list.
 */
public class CopyListwithRandomPointer {

    public static RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)
            return null;

        RandomListNode p = head;

        while(p!=null){
            RandomListNode copy = new RandomListNode(p.label);
            copy.next = p.next;
            p.next = copy;
            p = p.next.next;
        }

        p = head;
        while(p!=null){
            p.next.random = p.random!=null?p.random.next:null;
            p = p.next.next;
        }

        RandomListNode h=head.next, t=h, tail=head;
        for(;;){
            tail.next = t.next;
            tail = tail.next;
            if(tail==null)
                break;
            t.next = tail.next;
            t = t.next;
        }
        return h;
    }

    public static void main(String[] args){
        RandomListNode root = new RandomListNode(1);
        RandomListNode node1 = new RandomListNode(4);
        RandomListNode node2 = new RandomListNode(3);
        RandomListNode node3 = new RandomListNode(2);
        RandomListNode node4 = new RandomListNode(5);
        RandomListNode node5 = new RandomListNode(2);
        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1.random = node3;
        node4.random = node2;
        copyRandomList(root);
    }
}
