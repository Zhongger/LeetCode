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

    /**
     * 构造1->2->3->4->5链表
     * @return
     */
    public static ListNode getOneToFiveList(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        return node1;
    }

}
