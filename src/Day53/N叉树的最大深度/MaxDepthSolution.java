package Day53.N叉树的最大深度;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MaxDepthSolution {
    public static void main(String[] args) {
        MaxDepthSolution solution = new MaxDepthSolution();
        Node root = new Node(1);
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(4);
        Node node11 = new Node(5);
        Node node12 = new Node(6);

        List<Node> rootChildren = new ArrayList<>();
        rootChildren.add(node1);
        rootChildren.add(node2);
        rootChildren.add(node3);
        root.children = rootChildren;

        List<Node> node1Children = new ArrayList<>();
        node1Children.add(node11);
        node1Children.add(node12);
        node1.children = node1Children;
        System.out.println(solution.maxDepth(root));


    }


    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        } else if (root.children.isEmpty()) {
            return 1;
        } else {
            List<Integer> heights = new LinkedList<>();
            for (Node child : root.children) {
                heights.add(maxDepth(child));
            }
            return Collections.max(heights) + 1;
        }

    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}