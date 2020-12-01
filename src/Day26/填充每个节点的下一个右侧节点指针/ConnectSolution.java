package Day26.填充每个节点的下一个右侧节点指针;

import common.TreeNode2;

/**
 * Created by Zhong Mingyi on 2020/12/1.
 */
public class ConnectSolution {
    public static void main(String[] args) {

    }

    public TreeNode2 connect(TreeNode2 root) {
        if (root == null) return root;
        connectTwoNode(root.left,root.right);
        return root;
    }

    public void connectTwoNode(TreeNode2 node1, TreeNode2 node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        node1.next=node2;
        connectTwoNode(node1.left,node1.right);
        connectTwoNode(node2.left,node2.right);
        connectTwoNode(node1.right,node2.left);
    }
}
