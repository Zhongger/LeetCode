package Day10.复制带随机指针的链表;

import common.Node;

import java.util.LinkedHashMap;

public class CopyRandomListSolution {
    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {
        LinkedHashMap<Node, Node> map = new LinkedHashMap<>();
        Node cur = head;

        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node node = map.get(cur);
            Node nextNode = map.get(cur.next);
            node.next = nextNode;
            node.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
