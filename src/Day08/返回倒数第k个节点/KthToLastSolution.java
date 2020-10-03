package Day08.返回倒数第k个节点;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 */

public class KthToLastSolution {
    public static void main(String[] args) {
        KthToLastSolution solution = new KthToLastSolution();
        ListNode head = ListNode.getOneToFiveList();
        System.out.println(solution.kthToLast(head, 2));
    }
    public int kthToLast(ListNode head, int k) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp!=null){
            list.add(temp.val);
            temp=temp.next;
        }
        return list.get(list.size()-k);
    }
}
