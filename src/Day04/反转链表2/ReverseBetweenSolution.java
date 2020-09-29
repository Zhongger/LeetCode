package Day04.反转链表2;

import common.ListNode;

public class ReverseBetweenSolution {
    /**
     * 迭代法，三指针
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head==null){
            return null;
        }
        ListNode cur = head;
        ListNode prev = null;
        while (m>1){
            prev=cur;
            cur=cur.next;
            m--;
            n--;
        }
        ListNode con = prev;
        ListNode tail = cur;
        ListNode third = null;
        while (n>0){
            third=cur.next;
            cur.next=prev;
            prev=cur;
            cur=third;
            n--;
        }
        if (con!=null){
            con.next=prev;
        }else {
            head=prev;
        }
        tail.next=cur;
        return head;
    }
}
