package Day36.验证二叉搜索树;

import common.TreeNode;

public class IsValidBSTSolution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        //限定左子树的最大值是root.val  右子树的最小值是root.val
        return helper(root.left, min, root) && helper(root.right, root, max);
    }
}
