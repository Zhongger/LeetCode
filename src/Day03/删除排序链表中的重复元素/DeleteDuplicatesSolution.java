package Day03.删除排序链表中的重复元素;

import common.ListNode;

import static common.ListNode.printNode;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 */
public class DeleteDuplicatesSolution {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        DeleteDuplicatesSolution solution = new DeleteDuplicatesSolution();
        ListNode listNode = solution.deleteDuplicates(node1);
        printNode(listNode);
    }

    /**
     * 迭代法求解
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head;

        while (first != null && second != null) {
            ListNode temp = first;
            if (second == null) {
                temp.next = null;
                break;
            }
            while (first != null && second != null && first.val == second.val) {
                second = second.next;
            }
            temp.next = second;
            first = second;

        }
        return head;

    }
}
