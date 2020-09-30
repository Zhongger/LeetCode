package Day05.反转链表1;

import common.ListNode;

/**
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class ReverseListSolution {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        ReverseListSolution solution = new ReverseListSolution();
        ListNode resNode = solution.reverseList(node1);
        ListNode.printNode(resNode);
    }
    public ListNode reverseList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode prev = null;
        ListNode third = null;
        ListNode cur = head;
        while (cur!=null){
            third = cur.next;
            if (third==null){
                cur.next=prev;
                break;
            }
            cur.next=prev;
            prev=cur;
            cur=third;
        }
        return cur;
    }
}
