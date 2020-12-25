package Day36.二叉搜索树中的插入操作;

import common.TreeNode;

public class InsertIntoBSTSolution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root==null){
            return new TreeNode(val);
        }
        // if (root.val == val)
        //     BST 中一般不会插入已存在元素
        if (root.val>val){
            root.left=insertIntoBST(root.left,val);
        }
        if (root.val<val){
            root.right=insertIntoBST(root.right,val);
        }
        return root;
    }
}
