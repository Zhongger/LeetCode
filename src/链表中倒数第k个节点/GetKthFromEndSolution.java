package 链表中倒数第k个节点;

import common.ListNode;

/**
 * @author zhongmingyi
 * @date 2021/9/2 8:42 上午
 */
public class GetKthFromEndSolution {
    public static void main(String[] args) {
        GetKthFromEndSolution solution = new GetKthFromEndSolution();
        ListNode head = ListNode.getOneToFiveList();
        ListNode resNode = solution.getKthFromEnd(head, 2);
        ListNode.printNode(resNode);
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        if (k > length) {
            return null;
        }
        int step = length - k;
        ListNode resNode = head;
        while (step > 0) {
            step--;
            resNode = resNode.next;
        }
        return resNode;
    }
}
