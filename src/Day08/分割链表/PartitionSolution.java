package Day08.分割链表;

import common.ListNode;

/**
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
 */
public class PartitionSolution {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(10);
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        PartitionSolution solution = new PartitionSolution();
        ListNode resHead = solution.partition(node1, 4);
        ListNode.printNode(resHead);

    }

    /**
     * 先分隔后合并
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode leftHead = new ListNode(-1);
        ListNode leftCur = leftHead;

        ListNode rightHead = new ListNode(-1);
        ListNode rightCur = rightHead;
        while (cur != null) {
            if (cur.val < x) {
                leftCur.next = cur;
                leftCur = leftCur.next;
            } else {
                rightCur.next = cur;
                rightCur = rightCur.next;
            }
            cur = cur.next;
        }
        leftCur.next = rightHead.next;
        rightCur.next = null;
        return leftHead.next;
    }
}
