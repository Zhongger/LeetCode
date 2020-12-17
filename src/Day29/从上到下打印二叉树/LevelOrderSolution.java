package Day29.从上到下打印二叉树;

import common.TreeNode;

import java.util.*;

/**
 * Created by Zhong Mingyi on 2020/12/17.
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 */
public class LevelOrderSolution {

    private List<Integer> resList = new ArrayList<>();

    public static void main(String[] args) {
        LevelOrderSolution solution = new LevelOrderSolution();
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        root.left = root1;
        root.right = root2;

        TreeNode root21 = new TreeNode(15);
        TreeNode root22 = new TreeNode(7);
        root2.left = root21;
        root2.right = root22;


        int[] ints = solution.levelOrder(root);
        System.out.println(Arrays.toString(ints));
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            resList.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int[] res = new int[resList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = resList.get(i);
        }
        return res;
    }


}
