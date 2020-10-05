package Day10.有序链表转换二叉搜索树;

import common.ListNode;
import common.TreeNode;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。
 */
public class SortedListToBSTSolution {
    public static void main(String[] args) {
        ListNode head = ListNode.getOneToFiveList();
        SortedListToBSTSolution solution = new SortedListToBSTSolution();
        TreeNode treeNode = solution.sortedListToBST(head);
        System.out.println(treeNode);
    }
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head,null);
    }

    /**
     * 递归创建二叉树
     * @param left
     * @param right
     * @return
     */
    public TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }



    /**
     * 快慢指针法来找链表中的中间节点
     * @param left
     * @param right
     * @return
     */
    public ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


}
