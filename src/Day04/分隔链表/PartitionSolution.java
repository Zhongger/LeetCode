package Day04.分隔链表;

import common.ListNode;

public class PartitionSolution {
    public static void main(String[] args) {

    }

    /**
     * 拆分合并法
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode minHead = new ListNode(0);
        ListNode minPtr = minHead;

        ListNode maxHead = new ListNode(0);
        ListNode maxPtr = maxHead;

        while (head != null) {
            if (head.val < x) {
                minPtr.next = head;
                minPtr = minPtr.next;
            } else {
                maxPtr.next = head;
                maxPtr = maxPtr.next;
            }
            head = head.next;
        }
        maxPtr.next = null;
        minPtr.next = maxHead.next;
        return minHead.next;
    }

}
