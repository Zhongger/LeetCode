package Day30.二叉树的最近公共祖先;

import common.TreeNode;

/**
 * Created by Zhong Mingyi on 2020/12/18.
 */
public class LowestCommonAncestorSolution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left == null  && right == null) {
            return null;
        }
        return left == null ? right : left;
    }
}
