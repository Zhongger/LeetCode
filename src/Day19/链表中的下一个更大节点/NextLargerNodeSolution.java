package Day19.链表中的下一个更大节点;

import common.ListNode;

import java.util.*;

/**
 * Created by Zhong Mingyi on 2020/11/11.
 */

/**
 *  给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
 *
 * 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
 *
 * 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
 *
 */
public class NextLargerNodeSolution {
    public int[] nextLargerNodes(ListNode head) {
        ListNode cur = head;
        List<Integer> arrayList = new ArrayList<>();
        while (cur != null) {
            arrayList.add(cur.val);
            cur = cur.next;
        }
        Integer[] arr = new Integer[arrayList.size()];
        arr = arrayList.toArray(arr);
        int[] resArr = new int[arrayList.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty() || arr[stack.peek()] >= arr[i]) {
                stack.push(i);
            }
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                resArr[stack.peek()] = arr[i];
                stack.pop();
            }
            stack.push(i);

        }
        return resArr;
    }

    public static void main(String[] args) {
        NextLargerNodeSolution solution = new NextLargerNodeSolution();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(1);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        int[] ints = solution.nextLargerNodes(head);
        for (int i = 0; i < ints.length; i++) {
            System.out.printf(ints[i] + " ");
        }
    }
}
