/**
 * Created by Admin on 2016/8/17.
 */
public class ReverseNodesInKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k<=1)
            return head;
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode tail = h;

        ListNode t = null;
        ListNode p = h.next;
        t = p;
        int i = 1;
        while(t!=null){
            ListNode temp = null;
            if(i==k)
            {
                temp = t.next;
                t.next = null;
                tail.next = reverse(p,t);
                tail = p;
                tail.next = null;
                p = temp;
                t = temp;
                i = 1;
            }else{
                t = t.next;
                i++;
            }
        }
        tail.next = p;
        return h.next;
    }

    public static ListNode reverse(ListNode head, ListNode tail){
        ListNode result = null;
        tail = head;
        while(head!=null){
            ListNode temp = head.next;
            head.next = result;
            result = head;

            head = temp;
        }
        return result;
    }

    public static void main(String[] args){
        ListNode root = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        reverseKGroup(root,3);
    }
}
