package Day21.二叉树的最大深度;

import common.TreeNode;

import java.util.LinkedList;

/**
 * Created by Zhong Mingyi on 2020/11/13.
 */
public class MaxDepthSolution {
    //递归
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    //广度优先搜索
    public int maxDepth2(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return 0;
        }

        queue.offer(root);

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            count++;
        }
        return count;

    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        MaxDepthSolution solution = new MaxDepthSolution();
        System.out.println(solution.maxDepth(node1));

    }
}
