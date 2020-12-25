package Day36.删除二叉搜索树中的节点;

import common.TreeNode;

public class DeleteNodeSolution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null){
            return null;
        }
        if (root.val==key){
            if (root.left==null) return root.right;
            if (root.right==null) return root.left;
            TreeNode minNode = getMin(root.right);
            root.val=minNode.val;
            root.right=deleteNode(root.right, minNode.val);
        }else if (root.val>key){
            root.left= deleteNode(root.left,key);
        }else if (root.val<key){
            root.right=deleteNode(root.right,key);
        }
        return root;
    }

    TreeNode getMin(TreeNode node){
        while (node.left!=null){
            node=node.left;
        }
        return node;
    }
}
