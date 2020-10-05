package Day10.奇偶链表;

import common.ListNode;

public class OddEvenListSolution {
    public static void main(String[] args) {

    }
    public ListNode oddEvenList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode evenHead = evenNode;
        while (evenNode!=null&&evenNode.next!=null){
            oddNode.next=evenNode.next;
            oddNode=oddNode.next;
            evenNode.next=oddNode.next;
            evenNode=evenNode.next;
        }
        oddNode.next=evenHead;
        return head;
    }
}
