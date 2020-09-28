package common;

/**
 * 全局链表定义
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
    }

    public static void printNode(ListNode head){
        while (head!=null){
            if (head.next==null){
                System.out.print(head.val);
            }else {
                System.out.print(head.val+"->");
            }
            head = head.next;
        }
    }

    public int length(ListNode head){
        int count = 0;
        if (head==null){
            return 0;
        }else {
            while (head!=null){
                count++;
                head = head.next;
            }
            return count;
        }
    }

}
