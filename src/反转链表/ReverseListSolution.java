package 反转链表;

import common.ListNode;

/**
 * @author zhongmingyi
 * @date 2021/9/23 5:36 下午
 */
public class ReverseListSolution {
    public static void main(String[] args) {
        ReverseListSolution solution = new ReverseListSolution();
        ListNode head = ListNode.getOneToFiveList();
        ListNode resHead = solution.reverseList(head);
        ListNode.printNode(resHead);
    }

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
