/**
 * Created by Admin on 2016/7/26.
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        else if(l2==null)
            return l1;
        ListNode head1 = l1;
        ListNode head2 = l2;
        int len1 = 0;
        int len2 = 0;
        while(head1!=null)
        {
            len1++;
            head1 = head1.next;
        }
        while(head2!=null)
        {
            len2++;
            head2 = head2.next;
        }
        head1 = l1;
        head2 = l2;
        int jinwei = 0;
        if(len1>=len2)
        {
            while(head1!=null || head2!=null)
            {
                head1.val = (head1.val+head2.val+jinwei)%10;
                jinwei = head1.val/10;
                head1 = head1.next;
                head2 = head2.next;
            }
            while(head1!=null) {
                head1.val = head1.val % 10;
                head1 = head1.next;
            }
            return l1;
        }else{
            while(head1!=null || head2!=null)
            {
                head2.val = (head1.val+head2.val+jinwei)%10;
                jinwei = head2.val/10;
                head1 = head1.next;
                head2 = head2.next;
            }
            while(head2!=null) {
                head2.val = head2.val % 10;
                head2 = head2.next;
            }
            return l2;
        }
    }

    public static void main(String[] args){
        ListNode head = new ListNode(2);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        head.next = node1;
        node1.next = node2;

        ListNode head2 = new ListNode(5);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(4);
        head2.next = node3;
        node3.next = node4;

        ListNode root = addTwoNumbers(head,head2);
        System.out.println();
    }
}
