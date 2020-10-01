package Day06.相交链表;

import common.ListNode;

/**
 * 相交链表 编写一个程序，找到两个单链表相交的起始节点。
 */
public class GetIntersectionNodeSolution {
    public static void main(String[] args) {
        //Test1
        ListNode a1 = new ListNode(0);
        ListNode a2 = new ListNode(9);
        ListNode a3 = new ListNode(1);
        ListNode c1 = new ListNode(2);
        ListNode c2 = new ListNode(4);
        ListNode b1 = new ListNode(3);

        a1.next=a2;
        a2.next=a3;
        a3.next=c1;
        c1.next=c2;
        b1.next=c1;


        GetIntersectionNodeSolution solution = new GetIntersectionNodeSolution();
        ListNode resNode = solution.getIntersectionNode(a1, b1);
        ListNode.printNode(resNode);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode dummyA = new ListNode(-1);
        ListNode dummyB = new ListNode(-1);
        dummyA.next = headA;
        dummyB.next = headB;
        int lengthA = getListLength(headA);
        int lengthB = getListLength(headB);
        int step = 0;
        step = lengthA-lengthB;
        ListNode ptrA = dummyA;
        ListNode ptrB = dummyB;
        while (step>0){
            ptrA = ptrA.next;
            step--;
        }
        while (step<0){
            ptrB = ptrB.next;
            step++;
        }
        while (ptrA!=null&&ptrB!=null){
            if (ptrA==ptrB){
                break;
            }
            ptrA=ptrA.next;
            ptrB=ptrB.next;
        }

        if (ptrA==null||ptrB==null){
            return null;
        }
        return ptrA;

    }

    public int getListLength(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
