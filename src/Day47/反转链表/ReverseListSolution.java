package Day47.反转链表;

import common.ListNode;

public class ReverseListSolution {
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur!=null){
            ListNode nextNode = cur.next;
            next=nextNode;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
}
