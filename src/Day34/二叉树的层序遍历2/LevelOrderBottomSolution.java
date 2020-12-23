package Day34.二叉树的层序遍历2;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottomSolution {

    private List<List<Integer>> tempList = new ArrayList<>();
    private List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root==null){
            return new ArrayList<>();
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node!=null){
                    list.add(node.val);
                    if (node.left!=null){
                        queue.offer(node.left);
                    }
                    if (node.right!=null){
                        queue.offer(node.right);
                    }
                }
            }
            tempList.add(list);
        }

        for (int i = tempList.size()-1; i >=0 ; i--) {
            resList.add(tempList.get(i));
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

        LevelOrderBottomSolution solution = new LevelOrderBottomSolution();
        System.out.println(solution.levelOrderBottom(root));
    }
}
