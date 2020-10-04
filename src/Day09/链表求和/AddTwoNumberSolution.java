package Day09.链表求和;

import common.ListNode;

/**
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 * 这些数位是反向存放的，也就是个位排在链表首部。
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 */
public class AddTwoNumberSolution {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);

        node1.next = null;


        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(9);
        ListNode node23 = new ListNode(9);
        ListNode node24 = new ListNode(9);
        ListNode node25 = new ListNode(9);
        ListNode node26 = new ListNode(9);
        ListNode node27 = new ListNode(9);
        ListNode node28 = new ListNode(9);


        node21.next = node22;
        node22.next = node23;
        node23.next = node24;
        node24.next = node25;
        node25.next = node26;
        node26.next = node27;
        node27.next = node28;

        AddTwoNumberSolution solution = new AddTwoNumberSolution();
        ListNode resNode = solution.addTwoNumbers(node1, node21);
        ListNode.printNode(resNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy1 = new ListNode(-1);
        dummy1.next = l1;

        ListNode dummy2 = new ListNode(-1);
        dummy2.next = l2;

        ListNode cur1 = dummy1.next;
        ListNode cur2 = dummy2.next;
        ListNode resDummy = new ListNode(-1);
        ListNode cur = resDummy;
        boolean flag = false;//如果为true，就要进位
        while (cur1 != null && cur2 != null) {
            int addNum = 0;
            if (flag){
                addNum = 1;
            }
            int curSum = cur1.val + cur2.val + addNum;
            if (curSum>=10){
                flag = true;
                cur.next=new ListNode(curSum%10);
            }else {
                flag=false;
                cur.next=new ListNode(curSum);
            }
            cur=cur.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        if (cur1==null){
            while (cur2!=null){
                int addNum = 0;
                if (flag){
                    addNum = 1;
                }
                int curSum = cur2.val +addNum;
                if (curSum>=10){
                    flag=true;
                    cur.next=new ListNode(curSum%10);
                }else {
                    flag=false;
                    cur.next=new ListNode(curSum);
                }
                cur=cur.next;
                cur2 = cur2.next;
            }

        }
        if (cur2==null){
            while (cur1!=null){
                int addNum = 0;
                if (flag){
                    addNum = 1;
                }
                int curSum = cur1.val +addNum;
                if (curSum>=10){
                    flag=true;
                    cur.next=new ListNode(curSum%10);
                }else {
                    flag=false;
                    cur.next=new ListNode(curSum);
                }
                cur=cur.next;
                cur1 = cur1.next;
            }
        }

        if (flag){
            cur.next = new ListNode(1);
        }else {
            cur.next = null;
        }



        return resDummy.next;

    }
}
