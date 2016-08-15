/**
 * Created by Admin on 2016/8/13.
 */
public class SortList_148 {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode a = head;
        ListNode b = head;
        for(;b.next!=null && b.next.next!=null;b=b.next.next,a=a.next)
            ;
        b = sortList(a.next);
        a.next = null;
        a = sortList(head);
        head = null;
        ListNode tail = null;
        while(a!=null && b!=null)
        {
            if(a.val < b.val)
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
            }
            else{
                if(tail!=null)
                {
                    tail.next = b;
                    tail = tail.next;
                }
                else{
                    tail = b;
                    head = tail;
                }
                b = b.next;
            }
        }
        if(a!=null)
        {
            if(tail!=null)
                tail.next = a;
            else
                head = a;
        }
        else if(tail!=null)
        {
            tail.next = b;
        }
        else{
            head = b;
        }
        return head;
    }
}
