package Day19.二叉树的中序遍历;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhong Mingyi on 2020/11/11.
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 */
public class InorderTraversalSolution {

    public List<Integer> resList = new ArrayList<>();

    /**
     * 递归实现
     * @param root
     */
    public void inorderTraversalTree(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalTree(root.left);
        resList.add(root.val);
        inorderTraversalTree(root.right);

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        inorderTraversalTree(root);
        return resList;
    }

    public static void main(String[] args) {
        InorderTraversalSolution solution = new InorderTraversalSolution();
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode treeNode = new TreeNode(3);
        root.right = right;
        right.left = treeNode;
        System.out.println(solution.inorderTraversal(root));
    }
}
