package Day06.移除链表元素;

import common.ListNode;

/**
 * 删除链表中等于val的所有节点
 */
public class RemoveElementsSolution {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        RemoveElementsSolution solution = new RemoveElementsSolution();
        ListNode resNode = solution.removeElements(node1, 1);
        ListNode.printNode(resNode);

    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode cur = dummy.next;
        ListNode prev = dummy;
        while (cur!=null){
            if (cur.val==val){
                prev.next=cur.next;
                cur=cur.next;
            }else {
                cur=cur.next;
                prev=prev.next;
            }
        }
        return dummy.next;
    }
}
