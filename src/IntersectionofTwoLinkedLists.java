/**
 * Created by Admin on 2016/7/26.
 */
public class IntersectionofTwoLinkedLists {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null)
            return null;
        int alen = 0;
        int blen = 0;
        ListNode p = headA;
        while(p!=null){
            alen++;
            p = p.next;
        }
        p = headB;
        while (p!=null){
            blen++;
            p = p.next;
        }
        if(alen>blen){
            for(int i=0;i<alen-blen;i++){
                headA = headA.next;
            }
        }else{
            for(int i=0;i<blen-alen;i++){
                headB = headB.next;
            }
        }
        while(headA!=null || headB!=null){
            if(headA==headB)
                return headA;
            else{
                headA = headA.next;
                headB = headB.next;
            }
        }
        return headA;
    }

    public static void main(String[] args){
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(2);
        ListNode b3 = new ListNode(3);


        ListNode c1 = new ListNode(4);
        ListNode c2 = new ListNode(5);
        ListNode c3 = new ListNode(6);

        a1.next = a2;
        a2.next = c1;

        b1.next = b2;
        b2.next = b3;
        b3.next = c1;

        getIntersectionNode(a1,b1);
    }
}
