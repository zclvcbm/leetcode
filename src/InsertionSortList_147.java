/**
 * Created by Admin on 2016/8/12.
 */


/**
 * insertion-sort-list
 *
 * 题目描述
 *
 * Sort a linked list using insertion sort.
 *
 */
public class InsertionSortList_147 {
    public static ListNode insertionSortList(ListNode head) {
        if(head==null)
            return null;
        ListNode h = new ListNode(0); //为链表添加头节点
        h.next = head;
        ListNode cur = head.next; //从第二个结点开始进行插入操作
        head.next = null;         //使最后一个节点指向空节点
        while(cur!=null)
        {
            ListNode p = h;
            ListNode temp = cur.next; //保存下一个带插入节点
            while(p.next!=null && p.next.val<cur.val)
            {
                p = p.next;
            }
            // 执行插入操作
            cur.next = p.next;
            p.next = cur;
            // 指向下一个带插入节点
            cur = temp;
        }
        return h.next;
    }

    public static void main(String[] args)
    {
        ListNode root = new ListNode(3);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        insertionSortList(root);
    }
}
