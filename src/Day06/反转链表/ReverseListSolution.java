package Day06.反转链表;

import common.ListNode;

public class ReverseListSolution {
    public static void main(String[] args) {
        ListNode head = ListNode.getOneToFiveList();
        ReverseListSolution solution = new ReverseListSolution();
        ListNode resNode = solution.reverseList(head);
        ListNode.printNode(resNode);
    }

    /**
     * 迭代法求解
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode third = null;
        while (cur!=null){
            third=cur.next;
            cur.next=prev;
            prev=cur;
            cur=third;
        }
        return prev;
    }
}
