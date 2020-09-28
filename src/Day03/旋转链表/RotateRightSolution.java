package Day03.旋转链表;

import common.ListNode;

public class RotateRightSolution {
    public static void main(String[] args) {

        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        RotateRightSolution solution = new RotateRightSolution();
        ListNode listNode = solution.rotateRight(node1, 4);
        while (listNode != null) {
            System.out.println(listNode.val + "->");
            listNode = listNode.next;
        }
    }

    /**
     * 闭环断链法
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int length = head.length(head);//链表长度

        ListNode lastNode = getLastNode(head);
        lastNode.next = head;//闭环

        ListNode newTail = head;
        for (int i = 0; i < length - k % length - 1; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;

    }

    /**
     * 找到最后一个节点
     *
     * @param head
     * @return
     */
    public ListNode getLastNode(ListNode head) {
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }


}

