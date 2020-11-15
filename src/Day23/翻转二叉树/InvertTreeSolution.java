package Day23.翻转二叉树;

import common.TreeNode;

/**
 * Created by Zhong Mingyi on 2020/11/15.
 * 翻转一棵二叉树。
 */
public class InvertTreeSolution {
    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
