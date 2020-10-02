package Day07.移除重复节点;

import common.ListNode;

import java.util.LinkedHashMap;
import java.util.Map;

public class RemoveDuplicateNodesSolution {
    public static void main(String[] args) {
        RemoveDuplicateNodesSolution solution = new RemoveDuplicateNodesSolution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(1);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        ListNode resNode = solution.removeDuplicateNodes(node1);
        ListNode.printNode(resNode);
    }
    public ListNode removeDuplicateNodes(ListNode head) {
        LinkedHashMap<Integer, ListNode> map = new LinkedHashMap<>();
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode cur = dummy.next;
        while (cur!=null){
            map.putIfAbsent(cur.val, cur);
            cur=cur.next;
        }
        ListNode newHead = new ListNode(-1);
        cur = newHead;
        ListNode node = null;
        for (Map.Entry<Integer, ListNode> entry : map.entrySet()) {
            node = entry.getValue();
            node.next=null;
            cur.next =node;
            cur = node;
        }

        return newHead.next;
    }
}
