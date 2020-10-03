package Day08.删除中间节点;

import common.ListNode;

public class DeleteNodeSolution {
    public static void main(String[] args) {
        ListNode head = ListNode.getOneToFiveList();

    }

    /**
     * 狸猫换太子
     * 把下一个节点的值赋给要删除的节点，然后删除下一个节点
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
