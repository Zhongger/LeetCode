package Day35.把二叉搜索树转换为累加树;

import common.TreeNode;

public class ConvertBSTSolution {
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    int sum = 0;
    public void traverse(TreeNode root){
        if (root==null){
            return;
        }
        traverse(root.right);
        sum+=root.val;
        root.val=sum;
        traverse(root.left);
    }
}
