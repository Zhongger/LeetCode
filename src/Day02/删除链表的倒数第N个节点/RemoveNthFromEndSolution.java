package Day02.删除链表的倒数第N个节点;

import common.ListNode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
public class RemoveNthFromEndSolution {
    public static void main(String[] args) {
        RemoveNthFromEndSolution solution = new RemoveNthFromEndSolution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        System.out.println(solution.length(node1));
        ListNode head = solution.removeNthFromEnd(node1, 1);
        while (head!=null){
            System.out.print(head.val+"->");
            head=head.next;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (length(head)==0||length(head)==1){//边界条件
            return null;
        }
        if (length(head)-n==0){//边界条件
            return head.next;
        }
        int step = length(head) - (n + 1);//指针前进到要删除节点的前一个节点

        ListNode cur = head;
        int i = 0;
        while (i<step){
            cur=cur.next;
            i++;
        }
        cur.next=cur.next.next;
        return head;
    }

    /**
     * 获取链表的长度
     * @param head
     * @return
     */
    public int length(ListNode head){
        int n = 0;
        if (head==null){
            return 0;
        }
        while (head!=null){
            n++;
            head=head.next;
        }
        return n;
    }
}
