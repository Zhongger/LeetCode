package Day29.从上到下打印二叉树3;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Zhong Mingyi on 2020/12/17.
 */
public class LevelOrderSolution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        root.left = root1;
        root.right = root2;

        TreeNode node = new TreeNode(4);
        root1.right = node;

        TreeNode root21 = new TreeNode(15);
        TreeNode root22 = new TreeNode(7);
        root2.left = root21;
        root2.right = root22;

        LevelOrderSolution solution = new LevelOrderSolution();
        System.out.println(solution.levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> resList = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int row = 1;

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (row % 2 == 1) {//奇数层，从左往右
                    TreeNode node = queue.pollFirst();
                    list.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                } else {//偶数层，从右往左
                    TreeNode node = queue.pollLast();
                    list.add(node.val);
                    if (node.right != null) {
                        queue.addFirst(node.right);
                    }
                    if (node.left != null) {
                        queue.addFirst(node.left);
                    }
                }
            }

            row++;
            resList.add(list);

        }
        return resList;
    }
}
