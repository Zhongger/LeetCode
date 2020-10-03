package Day08.删除中间节点;

import common.ListNode;

public class DeleteNodeSolution {
    public static void main(String[] args) {
        ListNode head = ListNode.getOneToFiveList();

    }
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
