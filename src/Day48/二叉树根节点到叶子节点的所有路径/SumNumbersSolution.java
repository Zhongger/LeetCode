package Day48.二叉树根节点到叶子节点的所有路径;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SumNumbersSolution {
    List<Integer> list = new ArrayList<>();
    public int sumNumbers (TreeNode root) {
        if (root == null) return 0;
        StringBuffer sb = new StringBuffer();
        dfs(root, sb);
        int res = 0;
        for (int i : list) {
            res += i;
        }
        return res;
    }

    public void dfs(TreeNode root, StringBuffer sb) {
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            list.add(Integer.valueOf(sb.toString()));
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        sb.append(root.val);
        if (root.left != null) dfs(root.left, sb);
        if (root.right != null) dfs(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
    //广度优先
    public int sumNumbers2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> numQueue = new LinkedList<Integer>();
        nodeQueue.offer(root);
        numQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int num = numQueue.poll();
            TreeNode left = node.left, right = node.right;
            if (left == null && right == null) {
                sum += num;
            } else {
                if (left != null) {
                    nodeQueue.offer(left);
                    numQueue.offer(num * 10 + left.val);
                }
                if (right != null) {
                    nodeQueue.offer(right);
                    numQueue.offer(num * 10 + right.val);
                }
            }
        }
        return sum;
    }



    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node2.left = node4;
        node2.right = node5;

        node1.left = node2;
        node1.right = node3;

        SumNumbersSolution solution = new SumNumbersSolution();
        int res = solution.sumNumbers(node1);
        System.out.println(res);
    }
}
