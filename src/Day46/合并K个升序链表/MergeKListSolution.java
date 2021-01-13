package Day46.合并K个升序链表;

import common.ListNode;

import java.util.PriorityQueue;

public class MergeKListSolution {
    public static void main(String[] args) {
        MergeKListSolution solution = new MergeKListSolution();
        ListNode head1 = new ListNode(1);
        ListNode node11 = new ListNode(4);
        ListNode node12 = new ListNode(5);
        head1.next=node11;
        node11.next=node12;

        ListNode head2 = new ListNode(1);
        ListNode node21 = new ListNode(3);
        ListNode node22 = new ListNode(4);
        head2.next=node21;
        node21.next=node22;

        ListNode head3 = new ListNode(2);
        ListNode node31 = new ListNode(6);
        head3.next=node31;

        ListNode[] lists = {head1,head2,head3};
        ListNode node = solution.mergeKLists(lists);
        ListNode.printNode(node);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(ListNode head:lists){
            ListNode temp = head;
            while(temp!=null){
                queue.offer(temp.val);
                temp=temp.next;
            }
        }
        ListNode resHead = new ListNode(-1);
        ListNode temp = resHead;
        while (!queue.isEmpty()){
            ListNode node = new ListNode(queue.poll());
            temp.next=node;
            temp=temp.next;
        }
        return resHead.next;
    }
}
