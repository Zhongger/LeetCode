package Day49.最近公共祖先节点;

import common.TreeNode;

public class LowestCommonAncestorSolution {
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        return getCommonAncestor(root, o1, o2).val;
    }
    public TreeNode getCommonAncestor(TreeNode root, int o1,int o2){
        if (root==null||root.val==o1||root.val==o2){// 如果root为空，或者root为o1、o2中的一个，则它们的最近公共祖先就为root
            return root;
        }
        TreeNode left = getCommonAncestor(root.left, o1, o2);
        TreeNode right = getCommonAncestor(root.right, o1, o2);
        if (left==null){
            return right;
        }
        if (right==null){
            return left;
        }
        return root;
    }
}
