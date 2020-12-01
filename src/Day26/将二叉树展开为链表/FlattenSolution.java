package Day26.将二叉树展开为链表;

import common.TreeNode;

/**
 * Created by Zhong Mingyi on 2020/12/1.
 */
public class FlattenSolution {
    public static void main(String[] args) {

    }
    public void flatten(TreeNode root) {
        if (root==null){
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode right = root.right;
        TreeNode left = root.left;
        root.left=null;
        root.right=left;
        TreeNode p = root;
        while (p.right!=null){
            p=p.right;
        }
        p.right=right;
    }
}
