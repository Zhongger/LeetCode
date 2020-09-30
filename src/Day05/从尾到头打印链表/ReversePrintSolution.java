package Day05.从尾到头打印链表;

import common.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class ReversePrintSolution {
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
        ReversePrintSolution solution = new ReversePrintSolution();
        int[] res = solution.reversePrint(node1);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }
    public int[] reversePrint(ListNode head){
        if (head==null){
            return null;
        }
        if (head.next==null){
            int[] res = new int[1];
            res[0] = head.val;
            return res;
        }
        Stack<Integer> stack = new Stack<>();
        while (head!=null){
            stack.add(head.val);
            head=head.next;
        }
        ArrayList<Integer> resArr = new ArrayList<>();
        while (!stack.isEmpty()){
            resArr.add(stack.pop());
        }
        int[] res = new int[resArr.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = resArr.get(i);
        }
        return res;
    }
}
