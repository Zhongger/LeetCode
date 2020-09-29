package Day04.删除排序链表中的重复节点2;

import common.ListNode;

public class DeleteDuplicatesSolution {
    public static void main(String[] args) {
        DeleteDuplicatesSolution solution = new DeleteDuplicatesSolution();
        // 1->1->1->2->3
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        ListNode resHead = solution.deleteDuplicates(node1);
        ListNode.printNode(resHead);
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);//哑节点，防止出现头结点特殊情况的问题
        dummy.next=head;
        ListNode cur = dummy ;
        while (cur.next!=null&&cur.next.next!=null){
            if (cur.next.val==cur.next.next.val){
                ListNode temp = cur.next;
                while (temp!=null&&temp.next!=null&&temp.val==temp.next.val){
                    temp=temp.next;
                }
                cur.next=temp.next;
            }else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
