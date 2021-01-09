package Day42.反转链表;

import common.ListNode;

public class ReverseListSolution {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
