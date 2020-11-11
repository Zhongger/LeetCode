package Day19.二叉树的中序遍历;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Zhong Mingyi on 2020/11/11.
 */
public class InorderTraversalSolution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            resList.add(root.val);
            root=root.right;
        }
        return resList;
    }

    public static void main(String[] args) {
        InorderTraversalSolution2 solution = new InorderTraversalSolution2();
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode treeNode = new TreeNode(3);
        root.right = right;
        right.left = treeNode;
        System.out.println(solution.inorderTraversal(root));
    }
}
