package Day08.二进制链表转整数;

import common.ListNode;

/**
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * 请你返回该链表所表示数字的 十进制值 。
 *
 */
public class GetDecimalValueSolution {
    public static void main(String[] args) {

        GetDecimalValueSolution solution = new GetDecimalValueSolution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(1);
        node1.next=node2;
        node2.next=node3;
        System.out.println(solution.getDecimalValue(node1));
    }

    /**
     * 先反转链表，再相加
     * @param head
     * @return
     */
    public int getDecimalValue(ListNode head) {
        ListNode nowHead = reserveListNode(head);
        ListNode dummy = new ListNode(-1);
        dummy.next=nowHead;
        ListNode cur = nowHead;
        int i = 0;
        int res = 0;
        while (cur!=null){
            res+=cur.val*Math.pow(2,i);
            i++;
            cur=cur.next;
        }
        return res;
    }

    public ListNode reserveListNode(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        ListNode third = null;
        while (cur!=null){
            third=cur.next;
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
