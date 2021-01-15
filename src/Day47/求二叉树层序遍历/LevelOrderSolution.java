package Day47.求二叉树层序遍历;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class LevelOrderSolution {

    private ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    arrayList.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            resList.add(arrayList);

        }
        return resList;

    }
}
