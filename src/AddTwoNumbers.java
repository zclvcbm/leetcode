

/**
 * Created by Admin on 2016/7/26.
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if(l1==null)
        {
            return l2;
        }else if(l2==null){
            return l1;
        }else{
            int add=0;
            ListNode head = l1,tail = l1;
            while(l1!=null && l2!=null)
            {
                int temp = add;
                add = (l1.val+l2.val+temp)/10;
                l1.val = (l1.val+l2.val+temp)%10;
                tail = l1;
                l1 = l1.next;
                l2 = l2.next;
            }

            if(l1==null)
            {
                if(add==0)
                    tail.next = l2;
                else{
                    while(l2!=null)
                    {
                        int temp = add;
                        add = (l2.val+temp)/10;
                        l2.val = (l2.val+temp)%10;
                        tail.next = l2;
                        tail = tail.next;
                        l2 = l2.next;
                    }
                    if(add>0)
                    {
                        tail.next = new ListNode(add);
                    }
                }
            }
            else{
                if(add==0)
                    tail.next = l1;
                else{
                    while(l1!=null)
                    {
                        int temp = add;
                        add = (l1.val+temp)/10;
                        l1.val = (l1.val+temp)%10;
                        tail.next = l1;
                        tail = tail.next;
                        l1 = l1.next;
                    }
                    if(add>0)
                    {
                        tail.next = new ListNode(add);
                    }
                }
            }
            return head;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) {
            return l2;
        }
        else if(l2==null) {
            return l1;
        }
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

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        //链表1只有一个节点且数值为0
        if (l1.val == 0 && l1.next == null ) {
            return l2;
        }
        //链表2只有一个节点且数值为0
        if (l2.val == 0 && l2.next == null) {
            return l1;
        }

        //节点游标
        ListNode currNode1 = l1;
        ListNode currNode2 = l2;
        ListNode preNode1 = null;
        int jinwei = 0;
        while(currNode1 != null && currNode2 != null) {
            preNode1 = currNode1;
            int sum = currNode1.val +currNode2.val + jinwei;
            jinwei = sum / 10;
            currNode1.val = sum % 10;
            currNode1 = currNode1.next;
            currNode2 = currNode2.next;
        }

        //如果链表1为空，则将链表2后面数据连接到链表1上
        if (currNode1 == null) {
            preNode1.next = currNode2;
            currNode1 = preNode1.next;
        }
        //依次更新链表上节点的数值
        while (currNode1 != null) {
            int sum = currNode1.val + jinwei;
            jinwei = sum / 10;
            currNode1.val = sum % 10;
            preNode1 = currNode1;
            currNode1 = currNode1.next;
        }
        //如果最后一个节点数值+进位数>10（有新的进位），则在链表后面添加一个节点
        if (jinwei > 0) {
            preNode1.next = new ListNode(jinwei);
        }
        return l1;
    }

    public static void main(String[] args){
/*        ListNode head = new ListNode(2);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        head.next = node1;
        node1.next = node2;

        ListNode head2 = new ListNode(5);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(4);
        head2.next = node3;
        node3.next = node4;

        ListNode root = addTwoNumbers1(head,head2);
        System.out.println();*/

        ListNode head = new ListNode(5);
        ListNode head2 = new ListNode(5);
//        ListNode root = addTwoNumbers1(head,head2);
        ListNode root = addTwoNumbers2(head,head2);
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }
}
