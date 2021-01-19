package Day50.二叉树的中序遍历;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//字节飞书后端二面面了这道题，要求使用非递归的方式
public class InorderTraversalSolution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root = stack.poll();
            resList.add(root.val);
            root=root.right;
        }
        return resList;
    }

}
