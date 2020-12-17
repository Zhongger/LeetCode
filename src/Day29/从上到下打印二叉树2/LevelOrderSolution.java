package Day29.从上到下打印二叉树2;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Zhong Mingyi on 2020/12/17.
 */
public class LevelOrderSolution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> resList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);


        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node!=null){
                    list.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            resList.add(list);
        }
        return resList;

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        root.left = root1;
        root.right = root2;

        TreeNode root21 = new TreeNode(15);
        TreeNode root22 = new TreeNode(7);
        root2.left = root21;
        root2.right = root22;

        LevelOrderSolution solution = new LevelOrderSolution();
        System.out.println(solution.levelOrder(root));

    }
}
