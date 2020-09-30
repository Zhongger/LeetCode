package Day05.复杂链表的复制;

import java.util.HashMap;

/**
 * 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 *
 */
public class CopyRandomListSolution {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next=node2;
        node2.next=null;
        node1.random=node2;
        node2.random=node1;
        CopyRandomListSolution solution = new CopyRandomListSolution();
        Node res = solution.copyRandomList(node1);
        while (res!=null){
            System.out.print("["+res.val+","+(res.random==null?null:res.random.val)+"]   ");
            res=res.next;
        }
    }

    /**
     * HashMap求解法
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur!=null){
            map.put(cur,new Node(cur.val));
            cur=cur.next;
        }
        cur=head;
        while (cur!=null){
            Node node = map.get(cur);
            Node nextNode = map.get(cur.next);
            node.next=nextNode;
            node.random=map.get(cur.random);
            cur=cur.next;
        }
        return map.get(head);
    }
}
class Node {
    int val;
    Node next;//next指向下一个节点
    Node random;//random指向链表中任意节点或null

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
