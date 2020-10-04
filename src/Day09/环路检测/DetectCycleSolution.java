package Day09.环路检测;

import common.ListNode;

/**
 * 给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。
 * 有环链表的定义：在链表中某个节点的next元素指向在它前面出现过的节点，则表明该链表存在环路。
 */
public class DetectCycleSolution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 此处如果用if (slow != null && fast != null && slow.val == fast.val) 会超出时间限制
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }

        // slow从head开始，fast从相遇点开始，一步一步走再次相遇即为环入口
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
