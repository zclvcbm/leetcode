/**
 * Created by Admin on 2016/7/27.
 */
public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        ListNode result = null;
        while(head!=null)
        {
            ListNode temp = head.next;
            head.next = result;
            result = head;
            head = temp;
        }
        return result;
    }

    public static ListNode reverseList2(ListNode head) {
        if(head==null)
            return null;
        while(head.next!=null)
        {
            return reverseList2(head.next).next = head;
        }
        return head;
    }

    public static void main(String[] args){
        ListNode root = new ListNode(1);
        ListNode node1 = new ListNode(2);
        root.next = node1;
        ListNode result = reverseList2(root);
        System.out.println(result);
    }
}
