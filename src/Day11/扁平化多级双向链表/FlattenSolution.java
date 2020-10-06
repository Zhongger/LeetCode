package Day11.扁平化多级双向链表;

import common.Node2;

import java.util.ArrayDeque;
import java.util.Deque;

public class FlattenSolution {
    public Node2 flatten(Node2 head) {
        if (head == null) return head;
        Node2 pseudoHead = new Node2();
        pseudoHead.val=0;
        pseudoHead.next=head;
        Node2 curr, prev = pseudoHead;
        Deque<Node2> stack = new ArrayDeque<>();
        stack.push(head);

        while (!stack.isEmpty()) {
            curr = stack.pop();
            prev.next = curr;
            curr.prev = prev;

            if (curr.next != null) stack.push(curr.next);
            if (curr.child != null) {
                stack.push(curr.child);
                curr.child = null;
            }
            prev = curr;
        }

        pseudoHead.next.prev = null;
        return pseudoHead.next;


    }
}
