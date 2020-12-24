package Day35.二叉搜索树中第K小的元素;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestSolution {

    private List<Integer> inorderList = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(6);
        TreeNode root4 = new TreeNode(2);
        TreeNode root5 = new TreeNode(4);
        TreeNode root6 = new TreeNode(1);

        root.left = root2;
        root.right = root3;
        root2.left = root4;
        root2.right = root5;
        root4.left = root6;

        KthSmallestSolution solution = new KthSmallestSolution();

        System.out.println(solution.kthSmallest(root,3));
    }


    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return inorderList.get(k-1);
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        inorderList.add(root.val);
        inorder(root.right);
    }

}
