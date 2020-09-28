package Day03.两两交换链表中的节点;

import common.ListNode;

/**

 */
public class SwapPairsSolution {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        SwapPairsSolution solution = new SwapPairsSolution();
        ListNode head = solution.swapPairs(node1);
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    /**
     * 迭代法求解
     *  * 时间复杂度：O(N) ，其中 N 指的是链表的节点数量。
     *  * 空间复杂度：O(N) ，递归过程使用的堆栈空间。
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;
        return secondNode;
    }

    /**
     * 迭代法求解
     * 时间复杂度：O(N) ，其中 N 指的是链表的节点数量。
     * 空间复杂度：O(1) 。
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1);//哑节点
        dummyNode.next=head;
        ListNode prevNode = dummyNode;
        while (head!=null&&head.next!=null){
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            prevNode.next=secondNode;
            firstNode.next=secondNode.next;
            secondNode.next=firstNode;

            prevNode=firstNode;
            head=firstNode.next;
        }
        return dummyNode.next;
    }
}
