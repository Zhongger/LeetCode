package Day02.两数相加;

import common.ListNode;

/**
 * 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 */
public class AddTwoNumberSolution {
    public static void main(String[] args) {
        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(4);
        ListNode node13 = new ListNode(3);
        node11.next=node12;
        node12.next=node13;
        ListNode node21 = new ListNode(5);
        ListNode node22 = new ListNode(6);
        ListNode node23 = new ListNode(4);
        node21.next=node22;
        node22.next=node23;

        AddTwoNumberSolution solution = new AddTwoNumberSolution();
        ListNode head = solution.addTwoNumbers(node11, node21);
        while (head!=null){
            System.out.print(head.val+"->");
            head=head.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp =head;
        int flag = 0;
        while (l1!=null||l2!=null){
            int x = l1==null?0: l1.val;
            int y = l2==null?0: l2.val;
            int sum = x+y+flag;
            flag = sum/10;//进位的数
            sum=sum%10;//当前位置节点的值
            ListNode node = new ListNode(sum);
            temp.next=node;
            temp = temp.next;
            if (l1!=null){
                l1=l1.next;
            }
            if (l2!=null){
                l2=l2.next;
            }
        }
        if (flag==1){
            ListNode node = new ListNode(flag);
            temp.next=node;
        }
        return head.next;
    }

}
