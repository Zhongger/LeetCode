package Day05.链表中倒数第k个节点;

import common.ListNode;

public class GetKthFromEndSolution {
    public static void main(String[] args) {
        ListNode head = ListNode.getOneToFiveList();
        GetKthFromEndSolution solution = new GetKthFromEndSolution();
        ListNode res = solution.getKthFromEnd(head, 5);
        ListNode.printNode(res);
    }
    public ListNode getKthFromEnd(ListNode head, int k) {
        int size = 0;
        ListNode dummy = new ListNode(-1);//哑节点
        dummy.next=head;
        ListNode cur = dummy;
        ListNode temp = head;
        while (temp!=null){
            temp=temp.next;
            size++;
        }
        int step = size-k+1;
        while (step>0&&cur!=null){
            cur = cur.next;
            step--;
        }
        return cur;
    }
}
